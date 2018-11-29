package rtp.demo.creditor.validation.steps;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PaymentsValidationSteps {

	@Given("^I have the following customer Bank Accounts$")
	public void i_have_the_following_customer_Bank_Accounts(DataTable arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
		throw new PendingException();
	}

	@Given("^I receive the following Credit Transfer Message:$")
	public void i_receive_the_following_Payment_Message(DataTable arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
		throw new PendingException();
	}

	@When("^I validate the Credit Transfer Message$")
	public void i_validate_the_Payment_Message() throws Throwable {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();

		KieSession kSession = kContainer.newKieSession("payments-validation-ksession");
		// kSession.insert(new Message("Dave", "Hello, HAL. Do you read me, HAL?"));
		kSession.fireAllRules();

		kSession.getQueryResults("", "");

		kSession.destroy();
	}

	@Then("^I expect no validation errors$")
	public void i_expect_no_validation_errors() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^I expect the following validation errors:$")
	public void i_expect_the_following_validation_results(DataTable arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
		throw new PendingException();
	}

}
