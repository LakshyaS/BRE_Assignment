package com.company.application.ruleengine;

import java.util.ArrayList;
import java.util.List;

import com.company.application.models.Action;
import com.company.application.models.Payment;
import com.company.application.rule.Rule;

public class RuleEngine {

	List<Rule<Payment, Action>> rules;

	public RuleEngine() {
		rules = new ArrayList<>();
	}
	
	public List<Action> applyRule(Payment input) {
		
		return rules.stream()
					.filter(rule -> rule.matches(input))
					.map(rule -> rule.process())
					.findFirst()
					.orElseThrow(() -> new RuntimeException("No matching rule found"));
					
	}
	
	public RuleEngine registerRule(Rule<Payment, Action> rule) {
		rules.add(rule);
		return this;
	}

}
