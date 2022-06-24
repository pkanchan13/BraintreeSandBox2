package com.sandbox.bdd.Service;

import com.braintreegateway.*;
import com.sandbox.braintree.Config.BraintreeGatewayConfig;
import com.sandbox.braintree.Repository.PaymentMethodRepository;
import com.sandbox.braintree.Repository.TransactionRepository;
import com.sandbox.braintree.Service.InitializeService;
import com.sandbox.braintree.Service.InitializeServiceImpl;
import com.sandbox.braintree.Service.TransactionService;
import com.sandbox.braintree.Service.TransactionServiceImpl;
import com.sandbox.braintree.model.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class AddTransactionMockTest {
    @Mock
    private TransactionService transactionService;

    @Mock
    private BraintreeGatewayConfig braintreeGatewayConfig;

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionServiceImpl transactionServiceImpl;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testCharge() throws Exception {
        TransactionEntity transactionEntity=addTransaction();
        int id=835930442;
        BraintreeGateway braintreeGateway = new BraintreeGateway("sandbox", "psbgxppgzh88j6tp", "7snrhvgj4kbzwg5w", "2668adf35fe5f3673eecdd2bf9bf621a");
        when(transactionService.charge(any(ChargeRequest.class),anyInt(),anyString())).thenReturn(buildTransactionResponse());
        when(braintreeGatewayConfig.getBraintreeGatewayInstance()).thenReturn(braintreeGateway);
        when(transactionRepository.save(addTransaction())).thenReturn(transactionEntity);
        TransactionResponse transactionResponse;
        transactionResponse = transactionService.charge(buildTransactionRequest(),835930442,"false");
        assertEquals("Transaction successful", transactionResponse.getMessage());
        verify(transactionService,times(1)).charge(ArgumentMatchers.refEq(buildTransactionRequest()),ArgumentMatchers.refEq(id),ArgumentMatchers.refEq("false"));
    }

    @Test
    public void captureCharge() throws Exception {
        TransactionEntity transactionEntity=updateStatus();
        String transactionId="835930442";
        BraintreeGateway braintreeGateway = new BraintreeGateway("sandbox", "psbgxppgzh88j6tp", "7snrhvgj4kbzwg5w", "2668adf35fe5f3673eecdd2bf9bf621a");
        when(transactionService.captureTransaction(anyString())).thenReturn(buildCaptureResponse());
        when(braintreeGatewayConfig.getBraintreeGatewayInstance()).thenReturn(braintreeGateway);
        when(transactionRepository.save(updateStatus())).thenReturn(transactionEntity);
        TransactionResponse transactionResponse;
        transactionResponse = transactionService.captureTransaction(transactionId);
        assertEquals("Ok", transactionResponse.getMessage());
        verify(transactionService,times(1)).captureTransaction(ArgumentMatchers.refEq(transactionId));
    }

    private ChargeRequest buildTransactionRequest() {
        ChargeRequest chargeRequest = new ChargeRequest();
        chargeRequest.setTokenId("g8np8dm");
        chargeRequest.setAmount(BigDecimal.valueOf(500.7));
        return chargeRequest;
    }

    private TransactionResponse buildTransactionResponse() {
        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setMessage("Transaction successful");
        return transactionResponse;
    }
    private TransactionResponse buildCaptureResponse() {
        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setTransactionStatus("SUBMITTED FOR SETTLEMENT");
        transactionResponse.setMessage("Ok");
        return transactionResponse;
    }

    private TransactionRequest buildRequest() {
        TransactionRequest request = new TransactionRequest()
                .amount(BigDecimal.valueOf(500.7))
                .paymentMethodToken("g8np8dm")
                .options()
                .submitForSettlement(false)
                .done();
        return request;
    }

    private TransactionEntity addTransaction() {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setTokenId("g8np8dm");
        transactionEntity.setAmount(BigDecimal.valueOf(500.7));
        return transactionEntity;
    }
    private TransactionEntity updateStatus() {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setTokenId("g8np8dm");
        transactionEntity.setStatus("SUBMITTED FOR SETTLEMENT");
        return transactionEntity;
    }
}
