package com.company.application.constants;

public enum PerformedAction {

	GENERATE_SHIPPING_PACKING_SLIP("Generate packing slip for shipping"),
	CREATE_DUPLICATE_PACKING_CLIP_FOR_ROYALTY_DEPT("Create duplicate packing slip for royalty department"),
	ACTIVATE_MEMBERSHIP("Activate the membership"),
	APPLY_UPGRADE("Apply the upgrade"),
	EMAIL_OWNER("Email the owner and inform them of the activation/upgrade"),
	ADD_FREE_FIRST_AID_VIDEO("add a free First Aid video to the packing slip"),
	GENERATE_COMMISSION_PAYMENT("Generate a commission payment to the agent");
	
	public final String value;
	
	private PerformedAction(String value) {
		this.value = value;
	}
}
