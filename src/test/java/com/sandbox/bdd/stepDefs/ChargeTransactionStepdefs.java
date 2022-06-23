package com.sandbox.bdd.stepDefs;

import static com.sandbox.bdd.TestContext.chargeTransactionEndPoint;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sandbox.bdd.request.TransactionEntity;
import com.sandbox.bdd.response.TransactionResponse;
import com.sandbox.bdd.stepDefs.config.JsonTestHelper;
import com.sandbox.bdd.stepDefs.config.ReadUrl;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ChargeTransactionStepdefs {

    BaseStepDef baseStepDef = new BaseStepDef();
    static TransactionResponse transactionResponse = null;
    ReadUrl readJson = new ReadUrl();
    String url = readJson.getUrl("charge");

    @Given("a charge request")
    public void a_charge_request() {
        try {
            chargeTransactionEndPoint = new JsonTestHelper().getRequest(
                    "src/test/resources/request/ChargeTransaction.json", TransactionEntity.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Given("set {string} as settlement")
    public void set_as_settlement(String arg0) {
        baseStepDef.getBraintreeInfo().setAddPaymentMethodEndpoint(arg0);
    }

    @Given("set {string} as amount")
    public void set_as_amount(String arg0) {
        baseStepDef.getBraintreeInfo().setAddPaymentMethodEndpoint(arg0);
    }

    @Given("set {string} as token_id")
    public void set_as_token_id(String arg0) {
        baseStepDef.getBraintreeInfo().setAddPaymentMethodEndpoint(arg0);
    }

    @When("charge api is called")
    public void charge_api_is_called() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(chargeTransactionEndPoint), headers);
        ResponseEntity<TransactionResponse> transactions = restTemplate.exchange(url, HttpMethod.POST, entity, TransactionResponse.class);
        System.out.println(transactions.getBody());
        transactionResponse = transactions.getBody();
    }

    @Then("a non-empty transaction_id should be generated")
    public void a_non_empty_transaction_id_should_be_generated() {
        transactionResponse.getTransactionId();
    }

    @Then("{string} returned as  response message")
    public void returned_as_response_message(String arg0) {
        assertEquals(arg0, String.valueOf(transactionResponse.getMessage()));
    }
}
