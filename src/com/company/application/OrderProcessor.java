package com.company.application;

import java.util.List;
import java.util.Scanner;

import com.company.application.constants.ItemType;
import com.company.application.models.Action;
import com.company.application.models.Order;
import com.company.application.models.Payment;
import com.company.application.ruleengine.RuleEngine;
import com.company.application.ruleimpl.Book;
import com.company.application.ruleimpl.Membership;
import com.company.application.ruleimpl.PhysicalProduct;
import com.company.application.ruleimpl.UpgradeMembership;
import com.company.application.ruleimpl.Video;

public class OrderProcessor {

	public OrderProcessor(){
		
	}
	public static void main(String[] args) {
	
		RuleEngine ruleEngine = new RuleEngine();
		ruleEngine
				.registerRule(new PhysicalProduct())
				.registerRule(new Membership())
				.registerRule(new UpgradeMembership())
				.registerRule(new Video())
				.registerRule(new Book());
		
		String choice = "";
		Scanner sc = new Scanner(System.in);
		OrderProcessor processor = new OrderProcessor();
		do {
			System.out.println("Press respective serial number to choose a rule");
			System.out.println("Rules in Business_Rule_Engine :- ");
			System.out.println("1. Physical Product");
			System.out.println("2. Activate Membership");
			System.out.println("3. Upgrade Membership");
			System.out.println("4. Add video - Learning to ski");
			System.out.println("5. Book");
			
			System.out.println("Enter a number:-");
			int a = sc.nextInt();
			
			processor.executeRules(ruleEngine, a);
			System.out.println();
			System.out.println("Do you want to continue ? (Press Y or N) ");
			choice = sc.next();
			
		}while(choice.equalsIgnoreCase("Y"));
		sc.close();
		System.out.println();
		System.out.println("Thank you!");
	
	}

	protected void executeRules(RuleEngine ruleEngine, int a) {
		switch(a){
			case 1: 
				Payment payment1 = new Payment(new Order(ItemType.PHYSICAL_PRODUCT.value));
				List<Action> action1 = ruleEngine.applyRule(payment1);
				print(action1);
				break;
				
			case 2:
				Payment payment2 = new Payment(new Order(ItemType.MEMBERSHIP.value));
				List<Action> action2 = ruleEngine.applyRule(payment2);
				print(action2);
				break;
				
			case 3:
				Payment payment4 = new Payment(new Order(ItemType.UPGRADE_TO_MEMBERSHIP.value));
				List<Action> action4= ruleEngine.applyRule(payment4);
				print(action4);
				break;
				
			case 4:
				Payment payment5 = new Payment(new Order(ItemType.VIDEO_LEARNING_TO_SKI.value));
				List<Action> action5 = ruleEngine.applyRule(payment5);
				print(action5);
				break;
				
			case 5:
				Payment payment3 = new Payment(new Order(ItemType.BOOK.value));
				List<Action> action3 = ruleEngine.applyRule(payment3);
				print(action3);
				break;
				
			default:
				System.out.println("Sorry! This rule does not exist in the system.");
		}
	}
	
	public static void print(List<Action> action) {
		System.out.println("Actions to be performed are:- ");
		for(Action item : action) {
			System.out.println(item.getPackingSlip());
		}
	}
	
}
  