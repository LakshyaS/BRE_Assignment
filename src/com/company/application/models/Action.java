package com.company.application.models;

public class Action {

	private String packingSlip;

	public Action(String packingSlip) {
		this.packingSlip = packingSlip;
	}

	public String getPackingSlip() {
		return packingSlip;
	}

	public void setPackingSlip(String packingSlip) {
		this.packingSlip = packingSlip;
	}

	@Override
	public String toString() {
		return "Action [packingSlip=" + packingSlip + "]";
	}
}
