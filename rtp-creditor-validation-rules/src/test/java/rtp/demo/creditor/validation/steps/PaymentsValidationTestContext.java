package rtp.demo.creditor.validation.steps;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.kie.api.KieServices;
import org.kie.api.command.Command;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.command.CommandFactory;

import rtp.demo.creditor.domain.account.Account;
import rtp.demo.creditor.domain.rtp.simplified.CreditTransferMessage;
import rtp.demo.creditor.validation.PaymentValidationRequest;
import rtp.demo.creditor.validation.wrappers.CreditorBank;
import rtp.demo.creditor.validation.wrappers.ProcessingDateTime;

public class PaymentsValidationTestContext {

	private CreditorBank creditor = new CreditorBank();
	private ProcessingDateTime processingDateTime;
	private Set<Account> accounts = new HashSet<Account>();
	private CreditTransferMessage creditTransferMessage = new CreditTransferMessage();
	private Set<PaymentValidationRequest> validationRequestResults = new HashSet<PaymentValidationRequest>();

	public void executeRules() {
		PaymentValidationRequest validationRequest = new PaymentValidationRequest();
		validationRequest.setCreditTransferMessage(creditTransferMessage);

		List<Command> cmds = new ArrayList<Command>();
		cmds.add(CommandFactory.newInsert(creditor));
		cmds.add(CommandFactory.newInsert(processingDateTime));
		cmds.add(CommandFactory.newInsert(validationRequest));
		cmds.add(CommandFactory.newInsertElements(accounts));
		cmds.add(CommandFactory.newFireAllRules());
		// cmds.add(CommandFactory.newQuery("getValidationResults",
		// "getValidationResults"));

		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();

		StatelessKieSession kSession = kContainer.newStatelessKieSession("payments-validation-ksession");
		kSession.execute(cmds);
	}

	public CreditorBank getCreditor() {
		return creditor;
	}

	public void setCreditor(CreditorBank creditor) {
		this.creditor = creditor;
	}

	public ProcessingDateTime getProcessingDateTime() {
		return processingDateTime;
	}

	public void setProcessingDateTime(ProcessingDateTime processingDateTime) {
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
