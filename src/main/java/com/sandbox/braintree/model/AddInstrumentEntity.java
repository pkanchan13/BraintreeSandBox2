package com.sandbox.braintree.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "Payment_methods")
public class AddInstrumentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "customer_id", nullable = false)
    private int customersId;

    @Column
    @JsonProperty("is_default")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean is_default;

    @Column
    @JsonProperty("first_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String first_name;

    @Column
    @JsonProperty("last_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String last_name;

    @Column
    @JsonProperty("company")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String company;

    @Column
    @JsonProperty("email")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;

    @Column
    @JsonProperty("phone")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String phone;

    @Column
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomersId() {
        return customersId;
    }

    public void setCustomersId(int customersId) {
        this.customersId = customersId;
    }
}