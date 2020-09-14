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

public class UpgradeMembershipTest {


	@Test
	public void process_test() {
		Order item = new Order(ItemType.UPGRADE_TO_MEMBERSHIP.value);
		Payment input = new Payment(item);
		Rule<Payment, Action> UpgradeMembership_rule = new UpgradeMembership(input);

		UpgradeMembership_rule.process();
		List<Action> actualActions = new ArrayList<>();
		actualActions.addAll(UpgradeMembership_rule.process());

		List<Action> expectedActions = new ArrayList<>();
		expectedActions.add(new Action(PerformedAction.APPLY_UPGRADE.value));
		expectedActions.add(new Action(PerformedAction.EMAIL_OWNER.value));

		for (int i = 0; i < expectedActions.size(); i++) {
			assertEquals(expectedActions.get(i).getPackingSlip(), actualActions.get(i).getPackingSlip());
		}
	}

	@Test
	public void matches_test_when_ruleExists() {
		RuleEngine ruleEngine = new RuleEngine();
		Order item = new Order(ItemType.UPGRADE_TO_MEMBERSHIP.value);
		Payment input = new Payment(item);
		Rule<Payment, Action> UpgradeMembership_rule = new UpgradeMembership(input);
		ruleEngine.registerRule(UpgradeMembership_rule);

		assertEquals(true, UpgradeMembership_rule.matches(input));
	}

	@Test
	public void matches_test_when_ruleDoesNotExists() {
		RuleEngine ruleEngine = new RuleEngine();
		Order item = new Order(ItemType.RANDOM_TEST_ITEM.value);
		Payment input = new Payment(item);
		Rule<Payment, Action> UpgradeMembership_rule = new UpgradeMembership(input);
		ruleEngine.registerRule(UpgradeMembership_rule);

		assertEquals(false, UpgradeMembership_rule.matches(input));
	}
	
}
