package com.company.application.ruleimpl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.company.application.constants.ItemType;
import com.company.application.constants.PerformedAction;
import com.company.application.models.Action;
import com.company.application.models.Order;
import com.company.application.models.Payment;
import com.company.application.rule.Rule;
import com.company.application.ruleengine.RuleEngine;

public class BookTest {

	@Test
	public void process_test() {
		Order item = new Order(ItemType.BOOK.value);
		Payment input = new Payment(item);
		Rule<Payment, Action> book_rule = new Book(input);

		book_rule.process();
		List<Action> actualActions = new ArrayList<>();
		actualActions.addAll(book_rule.process());

		List<Action> expectedActions = new ArrayList<>();
		expectedActions.add(new Action(PerformedAction.CREATE_DUPLICATE_PACKING_CLIP_FOR_ROYALTY_DEPT.value));
		expectedActions.add(new Action(PerformedAction.GENERATE_COMMISSION_PAYMENT.value));

		for (int i = 0; i < expectedActions.size(); i++) {
			assertEquals(expectedActions.get(i).getPackingSlip(), actualActions.get(i).getPackingSlip());
		}
	}

	@Test
	public void matches_test_when_ruleExists() {
		RuleEngine ruleEngine = new RuleEngine();
		Order item = new Order(ItemType.BOOK.value);
		Payment input = new Payment(item);
		Rule<Payment, Action> book_rule = new Book(input);
		ruleEngine.registerRule(book_rule);

		assertEquals(true, book_rule.matches(input));
	}

	@Test
	public void matches_test_when_ruleDoesNotExists() {
		RuleEngine ruleEngine = new RuleEngine();
		Order item = new Order(ItemType.RANDOM_TEST_ITEM.value);
		Payment input = new Payment(item);
		Rule<Payment, Action> book_rule = new Book(input);
		ruleEngine.registerRule(book_rule);

		assertEquals(false, book_rule.matches(input));
	}
	
}
