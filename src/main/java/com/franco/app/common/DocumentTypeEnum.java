package com.franco.app.common;

public enum DocumentTypeEnum {
	INVOICE(3), SUPPORTING(1), VOUCHER(6),SALESINVOICE(4),BANSTATEMENT(2);

	private int type;

	DocumentTypeEnum(final int type) {
		this.type = type;
	}

	public int getType() {
		return this.type;
	}
	
	public long getTypeLong() {
		return this.type;
	}
}
