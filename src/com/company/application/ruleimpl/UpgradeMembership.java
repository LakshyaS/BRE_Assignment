package com.company.application.ruleimpl;

import java.util.ArrayList;
import java.util.List;

import com.company.application.constants.ItemType;
import com.company.application.constants.PerformedAction;
import com.company.application.models.Action;
import com.company.application.models.Payment;
import com.company.application.rule.Rule;

public class UpgradeMembership implements Rule<Payment, Action> {

	private Payment input;

	public UpgradeMembership() {	}
	
	public UpgradeMembership(Payment input) {
		this.input = input;
	}
	
	@Override
	public List<Action> process() {
		List<Action> actions = new ArrayList<>();
		actions.add(new Action(PerformedAction.APPLY_UPGRADE.value));
		actions.add(new Action(PerformedAction.EMAIL_OWNER.value));
		return actions;
	}

	@Override
	public boolean matches(Payment input) {
		return input.getItem().getItemName().equals(ItemType.UPGRADE_TO_MEMBERSHIP.value); // chk warning
	}

}
