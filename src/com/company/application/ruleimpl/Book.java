package com.company.application.ruleimpl;

import java.util.ArrayList;
import java.util.List;

import com.company.application.constants.ItemType;
import com.company.application.constants.PerformedAction;
import com.company.application.models.Action;
import com.company.application.models.Payment;
import com.company.application.rule.Rule;

public class Book implements Rule<Payment, Action> {

	private Payment input;

	public Book() {	}
	
	public Book(Payment input) {
		this.input = input;
	}

	@Override
	public List<Action> process() {
		List<Action> actions = new ArrayList<>();
		actions.add(new Action(PerformedAction.CREATE_DUPLICATE_PACKING_CLIP_FOR_ROYALTY_DEPT.value));
		actions.add(new Action(PerformedAction.GENERATE_COMMISSION_PAYMENT.value));
		return actions;
	}

	@Override
	public boolean matches(Payment input) {
		return input.getItem().getItemName().equals(ItemType.BOOK.value);
	}

}
