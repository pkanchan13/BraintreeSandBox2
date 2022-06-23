package com.sandbox.braintree.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class ChargeRequest {

    @JsonProperty("amount")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Positive(message="amount cannot be negative")
    private BigDecimal amount;

    @JsonProperty("token_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotEmpty(message = "token id cannot be blank")
    private String tokenId;

    @JsonProperty("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String status;

    @JsonProperty("payment_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String paymentType;

    @JsonProperty("transaction_date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String transactionDate;

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
}
