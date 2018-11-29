package rtp.demo.creditor.validation.steps;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import rtp.demo.creditor.domain.account.Account;
import rtp.demo.creditor.domain.error.PaymentValidationError;
import rtp.demo.creditor.domain.rtp.simplified.CreditTransferMessage;
import rtp.demo.creditor.validation.PaymentValidationRequest;
import rtp.demo.creditor.validation.wrappers.ProcessingDateTime;

public class PaymentsValidationSteps {

	private PaymentsValidationTestContext testContext = new PaymentsValidationTestContext();

	@Given("^I am a Creditor FI identified by the routing and transit number \"([^\"]*)\"$")
	public void i_am_a_Creditor_FI_identified_by_the_routing_and_transit_number(String creditorId) throws Throwable {
		testContext.getCreditor().setRoutingAndTransitNumber(creditorId);
	}

	@Given("^I have the following customer bank accounts:$")
	public void i_have_the_following_customer_bank_accounts(DataTable bankAccountsTable) throws Throwable {
		testContext.setAccounts(makeAccounts(bankAccountsTable));
	}

	@Given("^the current date and time is \"([^\"]*)\" ET$")
	public void the_current_date_and_time_is_ET(String dateTimeIso) throws Throwable {
		testContext.setProcessingDateTime(makeProcessingDateTime(dateTimeIso));
	}

	@Given("^I receive the following Credit Transfer Message:$")
	public void i_receive_the_following_Payment_Message(DataTable creditTransferMessageTable) throws Throwable {
		testContext.setCreditTransferMessage(makeCreditTransferMessage(creditTransferMessageTable));
	}

	@When("^I validate the Credit Transfer Message$")
	public void i_validate_the_Payment_Message() throws Throwable {
		testContext.executeRules();

	}

	@Then("^I expect no validation errors$")
	public void i_expect_no_validation_errors() throws Throwable {
		testContext.getValidationRequestResults().forEach(result -> {
			assertTrue(((PaymentValidationRequest) result).getErrors().isEmpty());
		});
	}

	@Then("^I expect the following validation errors:$")
	public void i_expect_the_following_validation_results(DataTable validationErrorsTable) throws Throwable {
		List<PaymentValidationError> expectedErrors = makeValidationErrors(validationErrorsTable);
	}

	private Set<Account> makeAccounts(DataTable bankAccounts) {
		Set<Account> accounts = new HashSet<Account>();

		return accounts;
	}

	private CreditTransferMessage makeCreditTransferMessage(DataTable creditTransferMessageTable) {
		CreditTransferMessage creditTransferMessage = new CreditTransferMessage();

		return creditTransferMessage;
	}

	private ProcessingDateTime makeProcessingDateTime(String dateTimeIso) {
		ProcessingDateTime processingDateTime = new ProcessingDateTime();
		processingDateTime.setProcessingDateTime(LocalDateTime.parse(dateTimeIso));
		return processingDateTime;
	}

	private List<PaymentValidationError> makeValidationErrors(DataTable validationErrorsTable) {
		List<PaymentValidationError> expectedErrors = new ArrayList<PaymentValidationError>();

		return expectedErrors;
	}

}
