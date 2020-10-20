package com.experis.se.hampus.olsson.MusicDatabase.models;

public class Invoice {
    private int invoiceId;
    private int customerId;
    private String invoiceDate;
    private String billingAdress;
    private String billingCity;
    private String billingState;
    private String billingCountry;
    private String billingPostalCode;
    private double total;

    public Invoice(){
        
    }
    public Invoice (int invoiceId, int customerId, String invoiceDate, String billingAdress, String billingCity, String billingState, String billingCountry , String billingPostalCode, double total) {
        this.invoiceId=invoiceId;
        this.customerId=customerId;
        this.invoiceDate=invoiceDate;
        this.billingAdress=billingAdress;
        this.billingCity=billingCity;
        this.billingState=billingState;
        this.billingCountry=billingCountry;
        this.billingPostalCode=billingPostalCode;
        this.total=total;
    }
    // public Invoice (int invoiceId, int customerId, double total) {
    //     this.invoiceId=invoiceId;
    //     this.customerId=customerId;
    //     this.total=total;
    // }
    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getBillingAdress() {
        return billingAdress;
    }

    public void setBillingAdress(String billingAdress) {
        this.billingAdress = billingAdress;
    }
    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }
    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }
    public String getBillingPostalCode() {
        return billingPostalCode;
    }

    public void setBillingPostalCode(String billingPostalCode) {
        this.billingPostalCode = billingPostalCode;
    }
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
}
