# BRE_Assignment
Problem Statement 2: Business Rules Engine


Imagine you're writing an order processing application for a large company. In the past, this company used a fairly random mixture of manual and ad-hoc automated business practices to handle orders; they now want to put all these various ways of hanadling orders together into one whole: your application. After a full day of workshops you have gathered the following set of rules which need to be managed by the new system.

If the payment is for a physical product, generate a packing slip for shipping.

• If the payment is for a book, create a duplicate packing slip for the royalty department.
• If the payment is for a membership, activate that membership.
• If the payment is an upgrade to a membership, apply the upgrade.
• If the payment is for a membership or upgrade, e-mail the owner and inform them of the activation/upgrade. If the payment is for the video "Learning to Ski," add a free "First Aid" video to the packing slip (the result of a court decision in 1997).

If the payment is for a physical product or a book, generate a commission payment to the agent. Design a new system which can handle these rules and yet open to extension to new rules


# Solution

I have added a Rule Engine which will build all the Rules. 
Order Processor is designed to test all the rules based upon a switch case.

Everytime we need to build a new rule, we will add a class which will implement Rule interface and we will write it's respective logic in the process method of that new Rule class.

Rule Interface is made Generic. Here, I denotes Input and O denotes Output.
My RuleEngine class is implemeting Builder Design Pattern to take care of the Creation of new Rules everytime.

This system will handle the existing rules and yet open to extension to new rule without making any change to the existing system.
This code is open for extension and closed for modification.
