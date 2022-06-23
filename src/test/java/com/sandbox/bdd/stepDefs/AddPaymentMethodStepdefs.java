package com.sandbox.bdd.stepDefs;

import static com.sandbox.bdd.TestContext.addPaymentMethodEndPoint;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.json.JSONException;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sandbox.bdd.response.PaymentMethodResponse;
import com.sandbox.bdd.stepDefs.config.ReadUrl;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddPaymentMethodStepdefs {

    BaseStepDef baseStepDef = new BaseStepDef();
    private static final String request_json = "";
    static PaymentMethodResponse paymentsResponse = null;
    ReadUrl readJson = new ReadUrl();
    String url = readJson.getUrl("addPaymentMethod");

    @Given("addMethodOfPayment  request")
    public void addmethodofpayment_request() {
        addPaymentMethodEndPoint = baseStepDef.getBraintreeInfo().getAddPaymentMethodEndpoint();
    }

    @Given("set {string} as customer id")
    public void set_as_customer_id(String arg0) {
        baseStepDef.getBraintreeInfo().setAddPaymentMethodEndpoint(arg0);
    }

    @Given("set {string} as nonce")
    public void set_as_nonce(String arg0) {
        baseStepDef.getBraintreeInfo().setAddPaymentMethodEndpoint(arg0);
    }

    @When("add payment method api is called")
    public void add_payment_method_api_is_called() throws JsonProcessingException, JSONException {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<PaymentMethodResponse> payments = restTemplate.exchange(url, HttpMethod.POST, entity, PaymentMethodResponse.class);
        System.out.println(payments.getBody());
        paymentsResponse = payments.getBody();
    }

    @Then("{string} returned as payment type")
    public void returned_as_payment_type(String arg0) {
        assertEquals(arg0, paymentsResponse.getType());
    }

    @Then("{string} returned as message")
    public void returned_as_message(String arg0) {
        assertEquals(arg0, paymentsResponse.getMessage());
    }

    @Then("{string} returned as code")
    public void returned_as_code(String arg0) {
        assertEquals(arg0, String.valueOf(paymentsResponse.getCode()));
    }
}
