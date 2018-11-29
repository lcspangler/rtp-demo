package rtp.demo.creditor.domain.account;

public enum AccountStatus {

	OPEN("OPEN"), CLOSED("CLOSED"), BLOCKED("BLOCKED");

	private final String status;

	private AccountStatus(String status) {
		this.status = status;
	}

}
