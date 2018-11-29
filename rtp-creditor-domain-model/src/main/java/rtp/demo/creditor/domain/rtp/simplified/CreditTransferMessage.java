package rtp.demo.creditor.domain.rtp.simplified;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/*
 * Examples of fields found on the RTP Credit Transfer Message. For demo use only.
 * 
 * An Instructing Agent will use the Credit Transfer Message to initiate a Credit Transfer. 
 * This message is sent by a Debtor FI to a Creditor FI through RTP.
 * 
 * RTP documentation at: https://www.theclearinghouse.org/payment-systems/rtp/-/media/583eefdd2c5f4359b9c3523ae2db9f65.ashx
 */
public class CreditTransferMessage {

	// Unique ID for credit transfer message, set by Debtor FI
	// Format: MYYYYMMDDbbbbbbbbbbbBAAAnnnnnnnnnnn
	// Pos. 01-01 - Prefix "M"
	// Pos. 02-09 - File creation date in format YYYYMMDD
	// Pos. 10-20 - FI Identifier (11 digit Participant ID)
	// Pos. 21-21 - Message generation source ("B" if generated by a TCH FI)
	// Pos. 22-24 - Alphabetic serial identifier (3 alphabetic characters)
	// Pos. 25-35 - Message serial number (11 numeric characters)
	// Example: M2015111511021200201BFFF00000000001
	// XML Location: GrpHdr.MsgId
	private String creditTransferMessageId;

	// The Instruction Identifier is assigned by the Debtor FI to uniquely identify
	// a single Credit Transfer
	// Format: YYYYMMDDbbbbbbbbbbbBRRRRnnnnnnnnnnnn
	// Pos. 01-08 - File creation date in format YYYYMMDD
	// Pos. 09-19 - Participant ID (11 digits)
	// Pos. 20-20 - Message generation source ("B" if generated by a TCH FI)
	// Pos. 21-24 - Alphanumeric serial identifier (4 alphanumeric characters)
	// Pos. 25-35 - Message serial number (11 alphanumeric characters)
	// Example: 2015111511021200201BFFFF00000000001
	// XML Location: CdtTrfTxInf.PmtId.InstrId
	private String paymentInstructionId;

	// This is the customer reference assigned to the transaction. The E2E
	// identification must be passed on throughout the entire payment chain without
	// being changed.
	// Example: E2E-Ref001
	// XML Location: CdtTrfTxInf.PmtId.EndToEndId
	private String endToEndId;

	// Date and time at which the message was created, Eastern Time
	// Format: YYYY-MM-DDThh:mm:ss
	// Example: 2015-11-12T10:05:00
	// Rule: Creation Date Time must be within 1 calendar day of the system’s
	// date/time.
	// XML Location: GrpHdr.CreDtTm
	private LocalDateTime creationDateTime;

	// Number of individual transactions contained in the message.
	// Example: 1
	// Rule: Expected value is "1"
	// XML Location: GrpHdr.NbOfTxs
	private Integer numberOfTransactions;

	// Total amount of money moved between the instructing agent and the instructed
	// agent.
	// Example: 525.25
	// Rule: Reject if the value of the request is less than or equal to zero
	// XML Location: GrpHdr.TtlIntrBkSttlmAmt
	private BigDecimal paymentAmount;

	// Type of currency for the payment transaction
	// Example: USD
	// Rule: Only Currency supported by RTP is US Dollar
	// XML Location: GrpHdr.TtlIntrBkSttlmAmt
	private String paymentCurrency;

	// Method used to settle the single Credit Transfer processed through RTP
	// Example: CLRG
	// Rule: Expected value of "CLRG"
	// XML Location: GrpHdr.SttlmInf.SttlmMtd
	private String settlementMethod;

	// Identification of the Debtor FI.
	// Format: 9 digit Routing and Transit Number
	// Example: 021200201
	// Rule: Member Identification must be valid 9-digit Routing and Transit Number.
	// XML Location: CdtTrfTxInf.InstgAgt.FinInstnId.ClrSysMmbId.MmbId
	private String debtorId;

	// Debtor account identifier assigned by an institution.
	// Format: Up to 17 characters account identification (alphanumeric)
	// Example: 11000179512199001
	// XML Location: CdtTrfTxInf.CdtrAcct.Id.Othr.Id
	private String debtorAccountNumber;

	// Identification of the Creditor FI.
	// Format: 9 digit Routing and Transit Number
	// Example: 020010001
	// Rule: Member Identification must be valid 9-digit Routing and Transit Number.
	// XML Location: CdtTrfTxInf.InstdAgt.FinInstnId.ClrSysMmbId.MmbId
	private String creditorId;

	// Creditor account identifier assigned by an institution.
	// Format: Up to 17 characters account identification (alphanumeric)
	// Example: 12000194212199001
	// XML Location: CdtTrfTxInf.CdtrAcct.Id.Othr.Id
	private String creditorAccountNumber;

	public String getCreditTransferMessageId() {
		return creditTransferMessageId;
	}

	public void setCreditTransferMessageId(String creditTransferMessageId) {
		this.creditTransferMessageId = creditTransferMessageId;
	}

	public String getPaymentInstructionId() {
		return paymentInstructionId;
	}

	public void setPaymentInstructionId(String paymentInstructionId) {
		this.paymentInstructionId = paymentInstructionId;
	}

	public String getEndToEndId() {
		return endToEndId;
	}

	public void setEndToEndId(String endToEndId) {
		this.endToEndId = endToEndId;
	}

	public LocalDateTime getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(LocalDateTime creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public Integer getNumberOfTransactions() {
		return numberOfTransactions;
	}

	public void setNumberOfTransactions(Integer numberOfTransactions) {
		this.numberOfTransactions = numberOfTransactions;
	}

	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentCurrency() {
		return paymentCurrency;
	}

	public void setPaymentCurrency(String paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
	}

	public String getSettlementMethod() {
		return settlementMethod;
	}

	public void setSettlementMethod(String settlementMethod) {
		this.settlementMethod = settlementMethod;
	}

	public String getDebtorId() {
		return debtorId;
	}

	public void setDebtorId(String debtorId) {
		this.debtorId = debtorId;
	}

	public String getDebtorAccountNumber() {
		return debtorAccountNumber;
	}

	public void setDebtorAccountNumber(String debtorAccountNumber) {
		this.debtorAccountNumber = debtorAccountNumber;
	}

	public String getCreditorId() {
		return creditorId;
	}

	public void setCreditorId(String creditorId) {
		this.creditorId = creditorId;
	}

	public String getCreditorAccountNumber() {
		return creditorAccountNumber;
	}

	public void setCreditorAccountNumber(String creditorAccountNumber) {
		this.creditorAccountNumber = creditorAccountNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creationDateTime == null) ? 0 : creationDateTime.hashCode());
		result = prime * result + ((creditTransferMessageId == null) ? 0 : creditTransferMessageId.hashCode());
		result = prime * result + ((creditorAccountNumber == null) ? 0 : creditorAccountNumber.hashCode());
		result = prime * result + ((creditorId == null) ? 0 : creditorId.hashCode());
		result = prime * result + ((debtorAccountNumber == null) ? 0 : debtorAccountNumber.hashCode());
		result = prime * result + ((debtorId == null) ? 0 : debtorId.hashCode());
		result = prime * result + ((endToEndId == null) ? 0 : endToEndId.hashCode());
		result = prime * result + ((numberOfTransactions == null) ? 0 : numberOfTransactions.hashCode());
		result = prime * result + ((paymentAmount == null) ? 0 : paymentAmount.hashCode());
		result = prime * result + ((paymentCurrency == null) ? 0 : paymentCurrency.hashCode());
		result = prime * result + ((paymentInstructionId == null) ? 0 : paymentInstructionId.hashCode());
		result = prime * result + ((settlementMethod == null) ? 0 : settlementMethod.hashCode());
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
		CreditTransferMessage other = (CreditTransferMessage) obj;
		if (creationDateTime == null) {
			if (other.creationDateTime != null)
				return false;
		} else if (!creationDateTime.equals(other.creationDateTime))
			return false;
		if (creditTransferMessageId == null) {
			if (other.creditTransferMessageId != null)
				return false;
		} else if (!creditTransferMessageId.equals(other.creditTransferMessageId))
			return false;
		if (creditorAccountNumber == null) {
			if (other.creditorAccountNumber != null)
				return false;
		} else if (!creditorAccountNumber.equals(other.creditorAccountNumber))
			return false;
		if (creditorId == null) {
			if (other.creditorId != null)
				return false;
		} else if (!creditorId.equals(other.creditorId))
			return false;
		if (debtorAccountNumber == null) {
			if (other.debtorAccountNumber != null)
				return false;
		} else if (!debtorAccountNumber.equals(other.debtorAccountNumber))
			return false;
		if (debtorId == null) {
			if (other.debtorId != null)
				return false;
		} else if (!debtorId.equals(other.debtorId))
			return false;
		if (endToEndId == null) {
			if (other.endToEndId != null)
				return false;
		} else if (!endToEndId.equals(other.endToEndId))
			return false;
		if (numberOfTransactions == null) {
			if (other.numberOfTransactions != null)
				return false;
		} else if (!numberOfTransactions.equals(other.numberOfTransactions))
			return false;
		if (paymentAmount == null) {
			if (other.paymentAmount != null)
				return false;
		} else if (!paymentAmount.equals(other.paymentAmount))
			return false;
		if (paymentCurrency == null) {
			if (other.paymentCurrency != null)
				return false;
		} else if (!paymentCurrency.equals(other.paymentCurrency))
			return false;
		if (paymentInstructionId == null) {
			if (other.paymentInstructionId != null)
				return false;
		} else if (!paymentInstructionId.equals(other.paymentInstructionId))
			return false;
		if (settlementMethod == null) {
			if (other.settlementMethod != null)
				return false;
		} else if (!settlementMethod.equals(other.settlementMethod))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CreditTransferMessage [creditTransferMessageId=" + creditTransferMessageId + ", paymentInstructionId="
				+ paymentInstructionId + ", endToEndId=" + endToEndId + ", creationDateTime=" + creationDateTime
				+ ", numberOfTransactions=" + numberOfTransactions + ", paymentAmount=" + paymentAmount
				+ ", paymentCurrency=" + paymentCurrency + ", settlementMethod=" + settlementMethod + ", debtorId="
				+ debtorId + ", debtorAccountNumber=" + debtorAccountNumber + ", creditorId=" + creditorId
				+ ", creditorAccountNumber=" + creditorAccountNumber + "]";
	}

}
