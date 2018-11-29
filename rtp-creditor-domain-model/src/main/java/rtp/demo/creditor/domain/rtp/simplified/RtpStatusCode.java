package rtp.demo.creditor.domain.rtp.simplified;

public enum RtpStatusCode {

	ACCEPT("ACTC"), REJECT("RJCT"), ACCEPT_WITHOUT_POSTING("ACWP");

	private final String statusCode;

	private RtpStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

}
