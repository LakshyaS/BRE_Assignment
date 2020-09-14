package com.company.application.ruleimpl;

import java.util.ArrayList;
import java.util.List;

import com.company.application.constants.ItemType;
import com.company.application.constants.PerformedAction;
import com.company.application.models.Action;
import com.company.application.models.Payment;
import com.company.application.rule.Rule;

public class Video implements Rule<Payment, Action> {

	private Payment input;

	public Video() {	}
	
	public Video(Payment input) {
		this.input = input;
	}
	
	
	@Override
	public List<Action> process() {
		List<Action> actions = new ArrayList<>();
		actions.add(new Action(PerformedAction.ADD_FREE_FIRST_AID_VIDEO.value));
		return actions;
	}

	@Override
	public boolean matches(Payment input) {
		return input.getItem().getItemName().equals(ItemType.VIDEO_LEARNING_TO_SKI.value); // chk warning
	}

}
