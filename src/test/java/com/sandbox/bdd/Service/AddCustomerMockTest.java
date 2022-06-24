package com.sandbox.bdd.Service;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.Customer;
import com.braintreegateway.CustomerRequest;
import com.braintreegateway.Result;
import com.sandbox.braintree.Config.BraintreeGatewayConfig;
import com.sandbox.braintree.Repository.PaymentMethodRepository;
import com.sandbox.braintree.Service.InitializeService;
import com.sandbox.braintree.Service.InitializeServiceImpl;
import com.sandbox.braintree.model.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.List;

public class AddCustomerMockTest {
    @Mock
    private InitializeService initializeService;

    @Mock
    private BraintreeGatewayConfig braintreeGatewayConfig;

    @Mock
    private PaymentMethodRepository paymentMethodRepository;

    @InjectMocks
    private InitializeServiceImpl initializeServiceImpl;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testAddCustomer() throws Exception {
        AddInstrumentEntity addInstrumentEntity=addInstrument();
        BraintreeGateway braintreeGateway = new BraintreeGateway("sandbox", "psbgxppgzh88j6tp", "7snrhvgj4kbzwg5w", "2668adf35fe5f3673eecdd2bf9bf621a");
        when(initializeService.addCustomer(any(AddInstrumentRequest.class))).thenReturn(buildCustomerResponse());
        when(braintreeGatewayConfig.getBraintreeGatewayInstance()).thenReturn(braintreeGateway);
        when(paymentMethodRepository.save(addInstrument())).thenReturn(addInstrumentEntity);
        PaymentMethodResponse paymentMethodResponse;
        paymentMethodResponse = initializeService.addCustomer(buildCustomerRequest());
        assertEquals(200, Integer.parseInt(paymentMethodResponse.getCode()));
       // verify(initializeService,times(1)).addCustomer(refEq(buildCustomerRequest()));
       verify(initializeService,times(1)).addCustomer(ArgumentMatchers.refEq(buildCustomerRequest()));
    }

    private AddInstrumentRequest buildCustomerRequest() {
        AddInstrumentRequest addInstrumentRequest = new AddInstrumentRequest();
        addInstrumentRequest.setFirst_name("Neha");
        addInstrumentRequest.setLast_name("xyz");
        addInstrumentRequest.setCompany("Ticketmaster");
        addInstrumentRequest.setPhone("9987778956");
        addInstrumentRequest.setEmail("neha.sharma12@gmail.com");
        return addInstrumentRequest;
    }

    private PaymentMethodResponse buildCustomerResponse() {
        PaymentMethodResponse paymentMethodResponse = new PaymentMethodResponse();
        paymentMethodResponse.setFirstname("Neha");
        paymentMethodResponse.setCode("200");
        paymentMethodResponse.setMessage("ok");
        return paymentMethodResponse;
    }

    private CustomerRequest buildRequest() {
        CustomerRequest customerRequest = new CustomerRequest()
                .firstName("Neha")
                .lastName("xyz")
                .company("TCS")
                .email("neha.sharma12@gmail.com")
                .phone("9987778956");
        return customerRequest;
    }

//    private Result<Customer> customerResult() {
//        Result<Customer> mockCustomerResult = mock(Result.class);
//        Customer mockCustomer = mock(Customer.class);
//        List mockList = mock(List.class);
//        when(mockCustomerResult.getTarget()).thenReturn(mockCustomer);
//        return mockCustomerResult;
//    }
    private AddInstrumentEntity addInstrument() {
        AddInstrumentEntity addInstrumentEntity = new AddInstrumentEntity();
        addInstrumentEntity.setFirst_name("Neha");
        addInstrumentEntity.setLast_name("xyz");
        addInstrumentEntity.setCompany("TCS");
        addInstrumentEntity.setEmail("neha.sharma12@gmail.com");
        addInstrumentEntity.setPhone("9987778956");
        return addInstrumentEntity;
    }
}
