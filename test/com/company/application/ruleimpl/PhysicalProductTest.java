package com.company.application.ruleimpl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.company.application.OrderProcessor;
import com.company.application.constants.ItemType;
import com.company.application.constants.PerformedAction;
import com.company.application.models.Action;
import com.company.application.models.Order;
import com.company.application.models.Payment;
import com.company.application.rule.Rule;
import com.company.application.ruleengine.RuleEngine;

public class PhysicalProductTest {

	@Test
	public void process_test() {
		Order item = new Order(ItemType.PHYSICAL_PRODUCT.value);
		Payment input = new Payment(item);
		Rule<Payment, Action> physical_product_rule = new PhysicalProduct(input);

		physical_product_rule.process();
		List<Action> actualActions = new ArrayList<>();
		actualActions.addAll(physical_product_rule.process());

		List<Action> expectedActions = new ArrayList<>();
		expectedActions.add(new Action(PerformedAction.GENERATE_SHIPPING_PACKING_SLIP.value));
		expectedActions.add(new Action(PerformedAction.GENERATE_COMMISSION_PAYMENT.value));

		for (int i = 0; i < expectedActions.size(); i++) {
			assertEquals(expectedActions.get(i).getPackingSlip(), actualActions.get(i).getPackingSlip());
		}
	}

	@Test
	public void matches_test_when_ruleExists() {
		RuleEngine ruleEngine = new RuleEngine();
		Order item = new Order(ItemType.PHYSICAL_PRODUCT.value);
		Payment input = new Payment(item);
		Rule<Payment, Action> physical_product_rule = new PhysicalProduct(input);
		ruleEngine.registerRule(physical_product_rule);

		assertEquals(true, physical_product_rule.matches(input));
	}

	@Test
	public void matches_test_when_ruleDoesNotExists() {
		RuleEngine ruleEngine = new RuleEngine();
		Order item = new Order(ItemType.RANDOM_TEST_ITEM.value);
		Payment input = new Payment(item);
		Rule<Payment, Action> physical_product_rule = new PhysicalProduct(input);
		ruleEngine.registerRule(physical_product_rule);

		assertEquals(false, physical_product_rule.matches(input));
	}

}
