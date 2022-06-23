package com.sandbox.bdd.stepDefs.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "braintree")
@SuppressWarnings("unused")
public class EndPointsInfo {
    
    private String addCustomerEndpoint;
    private String addPaymentMethodEndpoint;
    private String chargeTransactionEndpoint;

    public String getVoidTransactionEndPoint() {
        return voidTransactionEndPoint;
    }

    public void setVoidTransactionEndPoint(String voidTransactionEndPoint) {
        this.voidTransactionEndPoint = voidTransactionEndPoint;
    }

    private String voidTransactionEndPoint;

    public String getRefundTransactionEndPoint() {
        return refundTransactionEndPoint;
    }

    public void setRefundTransactionEndPoint(String refundTransactionEndPoint) {
        this.refundTransactionEndPoint = refundTransactionEndPoint;
    }

    private String refundTransactionEndPoint;

    public String getCaptureTransactionEndpoint() {
        return captureTransactionEndpoint;
    }

    public void setCaptureTransactionEndpoint(String captureTransactionEndpoint) {
        this.captureTransactionEndpoint = captureTransactionEndpoint;
    }

    private String captureTransactionEndpoint;
    
    public String getAddCustomerEndpoint() {
        return addCustomerEndpoint;
    }

    public void setAddCustomerEndpoint(String addCustomerEndpoint) {

        this.addCustomerEndpoint = addCustomerEndpoint;
    }

    public String getAddPaymentMethodEndpoint() {
        return addPaymentMethodEndpoint;
    }

    public void setAddPaymentMethodEndpoint(String addPaymentMethodEndpoint) {
        this.addPaymentMethodEndpoint = addPaymentMethodEndpoint;
    }

    public String getChargeTransactionEndpoint() {
        return chargeTransactionEndpoint;
    }

    public void setChargeTransactionEndpoint(String chargeTransactionEndpoint) {
        this.chargeTransactionEndpoint = chargeTransactionEndpoint;
    }
    public EndPointsInfo(){
        System.out.println("---->");
    }

}
