package rtp.demo.creditor.validation;

import java.util.HashSet;
import java.util.Set;

import rtp.demo.creditor.domain.error.PaymentValidationError;
import rtp.demo.creditor.domain.rtp.simplified.CreditTransferMessage;

public class PaymentValidationRequest {

	private CreditTransferMessage paymentMessage;
	private Set<PaymentValidationError> errors = new HashSet<PaymentValidationError>();

	public CreditTransferMessage getPaymentMessage() {
		return paymentMessage;
	}

	public void setPaymentMessage(CreditTransferMessage paymentMessage) {
		this.paymentMessage = paymentMessage;
	}

	public Set<PaymentValidationError> getErrors() {
		return errors;
	}

	public void setErrors(Set<PaymentValidationError> errors) {
		this.errors = errors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((errors == null) ? 0 : errors.hashCode());
		result = prime * result + ((paymentMessage == null) ? 0 : paymentMessage.hashCode());
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
		PaymentValidationRequest other = (PaymentValidationRequest) obj;
		if (errors == null) {
			if (other.errors != null)
				return false;
		} else if (!errors.equals(other.errors))
			return false;
		if (paymentMessage == null) {
			if (other.paymentMessage != null)
				return false;
		} else if (!paymentMessage.equals(other.paymentMessage))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PaymentValidationRequest [paymentMessage=" + paymentMessage + ", errors=" + errors + "]";
	}

}
