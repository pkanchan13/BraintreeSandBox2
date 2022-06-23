package com.sandbox.braintree.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddInstrumentRequest {

    @JsonProperty("is_default")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean is_default;

    @JsonProperty("first_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String first_name;

    @JsonProperty("last_name")
    @NotEmpty(message = "Last name cannot be null")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String last_name;

    @JsonProperty("company")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String company;

    @JsonProperty("email")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Email
    private String email;

    @JsonProperty("phone")
    @Size(min = 10, max = 10, message
            = "Phone no should be of 10 digits")
    private String phone;

    @JsonProperty("payment_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String payment_type;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public boolean isIs_default() {
        return is_default;
    }

    public void setIs_default(boolean is_default) {
        this.is_default = is_default;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}