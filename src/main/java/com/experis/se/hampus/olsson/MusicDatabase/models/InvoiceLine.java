package com.experis.se.hampus.olsson.MusicDatabase.models;

public class InvoiceLine {
    private int invoiceLineId;
    private int invoiceId;
    private int trackId;
    private double unitPrice;
    private int quantity;

    public InvoiceLine(){
 }
 public InvoiceLine (int invoiceLineId, int invoiceId, int trackId, double unitPrice, int quantity) {
     this.invoiceLineId=invoiceLineId;
     this.invoiceId=invoiceId;
     this.trackId=trackId;
     this.unitPrice=unitPrice;
     this.quantity=quantity;
}

 public int getInvoiceLineId() {
     return invoiceLineId;
 }

 public void setInvoiceLineId(int invoiceLineId) {
     this.invoiceLineId = invoiceLineId;
 }

 public int getInvoiceId() {
     return invoiceId;
 }

 public void setInvoiceId(int invoiceId) {
     this.invoiceId = invoiceId;
 }

 public int getTrackId() {
     return trackId;
 }

 public void setTrackId(int trackId) {
     this.trackId = trackId;
 }

 public double getUnitPrice() {
     return unitPrice;
 }

 public void setUnitPrice(double unitPrice) {
     this.unitPrice = unitPrice;
 }

 public int getQuantity() {
     return quantity;
 }

 public void setQuantity(int quantity) {
     this.quantity = quantity;
 }

}
