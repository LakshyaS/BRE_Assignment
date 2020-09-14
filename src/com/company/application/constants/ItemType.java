package com.company.application.constants;

public enum ItemType {

	PHYSICAL_PRODUCT("Physical Product"),
	BOOK("Book"),
	MEMBERSHIP("Membership"),
	UPGRADE_TO_MEMBERSHIP("Upgrade to membership"),
	VIDEO_LEARNING_TO_SKI("Video-Learning to ski"),
	RANDOM_TEST_ITEM("Random test item");
	
	public final String value;
	
	private ItemType(String value) {
		this.value = value;
	}
}