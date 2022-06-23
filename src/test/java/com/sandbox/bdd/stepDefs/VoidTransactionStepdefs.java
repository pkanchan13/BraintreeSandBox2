package com.sandbox.bdd.stepDefs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.sandbox.bdd.stepDefs.config.ReadUrl;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sandbox.bdd.response.TransactionResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VoidTransactionStepdefs {

    BaseStepDef baseStepDef = new BaseStepDef();
    static TransactionResponse transactionResponse = null;
    ReadUrl readJson = new ReadUrl();
    String url = readJson.getUrl("void");

    @Given("voidTransaction request")
    public void voidtransaction_request() {
        //   voidTransactionEndPoint =  baseStepDef.getBraintreeInfo().getAddPaymentMethodEndpoint();
    }

    @Given("set {string} as transaction id")
    public void set_as_transaction_id(String arg0) {
        baseStepDef.getBraintreeInfo().setVoidTransactionEndPoint(arg0);
    }

    @When("voidTransaction method is called")
    public void voidtransaction_method_is_called() {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<TransactionResponse> transactions = restTemplate.exchange(url, HttpMethod.POST, entity, TransactionResponse.class);
        System.out.println(transactions.getBody());
        transactionResponse = transactions.getBody();

    }

    @Then("{string} returned as response message")
    public void returned_as_response_message(String arg0) {
        assertEquals(arg0, transactionResponse.getMessage());

    }

}