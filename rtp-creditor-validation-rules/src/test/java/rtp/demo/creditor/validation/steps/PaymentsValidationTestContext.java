package rtp.demo.creditor.validation.steps;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import rtp.demo.creditor.domain.account.Account;
import rtp.demo.creditor.domain.fi.CreditorBank;
import rtp.demo.creditor.domain.rtp.simplified.CreditTransferMessage;
import rtp.demo.creditor.validation.PaymentValidationRequest;

public class PaymentsValidationTestContext {

	private CreditorBank creditor = new CreditorBank();
	private LocalDateTime processingDateTime;
	private Set<Account> accounts = new HashSet<Account>();
	private CreditTransferMessage creditTransferMessage = new CreditTransferMessage();
	private Set<PaymentValidationRequest> validationRequestResults = new HashSet<PaymentValidationRequest>();

	public void executeRules() {

		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();

		KieSession kSession = kContainer.newKieSession("payments-validation-ksession");
		// kSession.insert(new Message("Dave", "Hello, HAL. Do you read me, HAL?"));
		System.out.println("\n\nRunning Rules");
		kSession.fireAllRules();
		System.out.println("Done Running Rules");
		kSession.getQueryResults("", "");

		kSession.destroy();
	}

	public CreditorBank getCreditor() {
		return creditor;
	}

	public void setCreditor(CreditorBank creditor) {
		this.creditor = creditor;
	}

	public LocalDateTime getProcessingDateTime() {
		return processingDateTime;
	}

	public void setProcessingDateTime(LocalDateTime processingDateTime) {
		this.processingDateTime = processingDateTime;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public CreditTransferMessage getCreditTransferMessage() {
		return creditTransferMessage;
	}

	public void setCreditTransferMessage(CreditTransferMessage creditTransferMessage) {
		this.creditTransferMessage = creditTransferMessage;
	}

	public Set<PaymentValidationRequest> getValidationRequestResults() {
		return validationRequestResults;
	}

	public void setValidationRequestResults(Set<PaymentValidationRequest> validationRequestResults) {
		this.validationRequestResults = validationRequestResults;
	}

}
