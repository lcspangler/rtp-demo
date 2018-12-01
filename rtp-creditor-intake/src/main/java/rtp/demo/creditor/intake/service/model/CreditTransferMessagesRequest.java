package rtp.demo.creditor.intake.service.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import iso.std.iso._20022.tech.xsd.pacs_008_001.FIToFICustomerCreditTransferV06;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditTransferMessagesRequest")
public class CreditTransferMessagesRequest {

	@XmlElement
	private List<FIToFICustomerCreditTransferV06> creditTransferMessages;

	public List<FIToFICustomerCreditTransferV06> getCreditTransferMessages() {
		return creditTransferMessages;
	}

	public void setCreditTransferMessages(List<FIToFICustomerCreditTransferV06> creditTransferMessages) {
		this.creditTransferMessages = creditTransferMessages;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creditTransferMessages == null) ? 0 : creditTransferMessages.hashCode());
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
		CreditTransferMessagesRequest other = (CreditTransferMessagesRequest) obj;
		if (creditTransferMessages == null) {
			if (other.creditTransferMessages != null)
				return false;
		} else if (!creditTransferMessages.equals(other.creditTransferMessages))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CreditTransferMessagesRequest [creditTransferMessages=" + creditTransferMessages + "]";
	}

}
