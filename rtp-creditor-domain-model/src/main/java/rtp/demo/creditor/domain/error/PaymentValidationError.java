package rtp.demo.creditor.domain.error;

public class PaymentValidationError {

	private RtpRejectReasonCode rtpReasonCode;

	private String errorMessage;

	public RtpRejectReasonCode getRtpReasonCode() {
		return rtpReasonCode;
	}

	public void setRtpReasonCode(RtpRejectReasonCode rtpReasonCode) {
		this.rtpReasonCode = rtpReasonCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((errorMessage == null) ? 0 : errorMessage.hashCode());
		result = prime * result + ((rtpReasonCode == null) ? 0 : rtpReasonCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentValidationError other = (PaymentValidationError) obj;
		if (errorMessage == null) {
			if (other.errorMessage != null)
				return false;
		} else if (!errorMessage.equals(other.errorMessage))
			return false;
		if (rtpReasonCode != other.rtpReasonCode)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PaymentValidationError [rtpReasonCode=" + rtpReasonCode + ", errorMessage=" + errorMessage + "]";
	}

}
