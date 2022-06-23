package com.sandbox.bdd.stepDefs.config;

public class ReadUrl {
    String url = "";

    public String getUrl(String val) {
        switch (val) {
            case "addCustomers":
                return "http://localhost:8081/payment/instrument/v1/customer";
            case "capture":
                return "http://localhost:8081/payment/v1/transaction/capture?transaction_id=8m3qete3";
            case "void":
                return "http://localhost:8081/payment/v1/transaction/void?transaction_id=5aak39y8";
            case "refund":
                return "http://localhost:8081/payment/v1/transaction/refund?transaction_id=gwn7fg4j";
            case "charge":
                return "http://localhost:8081/payment/v1/transaction/init?cus_id=835930442&settlement=false";
            case "addPaymentMethod":
                return "http://localhost:8081/payment/instrument/v1/add?payment_method_nonce=fake-valid-visa-nonce&cus_id=262629438";
            default:
                throw new IllegalStateException("Unexpected value: " + val);
        }
    }
}
