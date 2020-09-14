package com.company.application.ruleengine;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.company.application.constants.ItemType;
import com.company.application.constants.PerformedAction;
import com.company.application.models.Action;
import com.company.application.models.Order;
import com.company.application.models.Payment;
import com.company.application.rule.Rule;
import com.company.application.ruleengine.RuleEngine;
import com.company.application.ruleimpl.Book;

public class RuleEngineTest {
	
	@Test
	public void bookRuleTest_whenRuleExists() {
		RuleEngine ruleEngine = new RuleEngine();
		Order item = new Order(ItemType.BOOK.value);
		Payment input = new Payment(item);
		Rule<Payment, Action> book_rule = new Book(input);
		ruleEngine.registerRule(book_rule);
		List<Action> actualActions =ruleEngine.applyRule(input);
		List<Action> expectedActions = new ArrayList<>();
		expectedActions.add(new Action(PerformedAction.CREATE_DUPLICATE_PACKING_CLIP_FOR_ROYALTY_DEPT.value));
		expectedActions.add(new Action(PerformedAction.GENERATE_COMMISSION_PAYMENT.value));
		for(int i=0; i<expectedActions.size(); i++ ) {
			assertEquals(expectedActions.get(i).getPackingSlip(), actualActions.get(i).getPackingSlip());
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void bookRuleTest_whenRuleDoesNotExists() {
		RuleEngine ruleEngine = new RuleEngine();
		Order item = new Order(ItemType.RANDOM_TEST_ITEM.value);
		Payment input = new Payment(item);
		Rule<Payment, Action> book_rule = new Book(input);
		ruleEngine.registerRule(book_rule);
		
		try {
			ruleEngine.applyRule(input);
		}
		catch(RuntimeException exc)
		{
			String messg ="No matching rule found";
			assertEquals(messg, exc.getMessage());
			throw exc;
		}
		
	}
	
}
