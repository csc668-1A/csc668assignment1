/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc668assignment1;
import csc668assignment1.payment.CashPayment;
import csc668assignment1.payment.CheckPayment;
import csc668assignment1.payment.CreditPayment;
import java.sql.Timestamp;

import java.util.LinkedList;
import java.text.DecimalFormat;
import csc668assignment1.UserInterface.*;

/**
 * This represents an Invoice from the purchase of an item(s)
 * 
 * @author Karl
 */
public class Invoice {
    private static int invoiceId = 0;
    private String storeName;
    private String customerName;
    private Timestamp dateTime;
    /**
     * A linked list of TransactionItem objects, each with a upc,quantity pair.
     */
    private TransactionItem[] salesLineItem;
    private int totalTransItem;
    //variables for Payment
    private String paymentType;
    private double TenderedAmount;
    private double ReturedAmount;
    private int cardNum;
    private double total;
    private UserInterface ui = new UserInterface();
    
    public Invoice(Transaction t){
        //set the Timestamp
        invoiceId++;
        this.storeName = Store.getStoreName();
        this.customerName = t.getCustomer().getName();
        this.salesLineItem = t.getTransItems();
        this.totalTransItem = t.getTotalTransItems();
        this.total = 0.0;//initialize the total price
        getPayment(t.getPayment());
        calculateTotal(); 
    }
    public void calculateTotal(){
        //Accumulate subtotal from each TransactionItem to get total
        for(int i = 0; i < this.totalTransItem; i++){
            this.total += this.salesLineItem[i].getSubtotal();
        }
        this.total=Math.floor(this.total * 100) / 100;
        //get the amount for return
        this.ReturedAmount = this.TenderedAmount - this.total;
        
    }
    public void getPayment(Payment payment){
        
        if(payment instanceof CheckPayment){
            CheckPayment check = (CheckPayment)payment;
            this.paymentType = check.getType();
            //this.TenderedAmount = check.getAmountDue();
        }else if(payment instanceof CreditPayment){
            CreditPayment credit = (CreditPayment)payment;
            this.paymentType = credit.getType();
            this.cardNum = credit.getCardNum();
        }else{
            CashPayment cash = (CashPayment)payment;
            this.paymentType = cash.getType();
            this.TenderedAmount = cash.getAmountDue();
        }
    }
    /*
     * invoice needs to be printed in the following format
     * STORE NAME
     * Customer Name Date Time
     * Item: description quantity @ unitPrice subtotal
     * ----------
     * Total $xxxx.xx
     * Amount Tendered: xxxx.xx OR Paid by check OR Creadit Card ddddd
     * Amount Returned: xxxx.xx
     */
    public void print(){
        //need to be implemented
        ui.println(this.customerName);
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        
        ui.println(this.storeName);
        for(int i = 0; i < this.totalTransItem; i++){
            String s = "";
            s += this.salesLineItem[i].getProductSpec().getDescription() + "\t";
            s += this.salesLineItem[i].getQuantity();
            s += " @ ";
            s += this.salesLineItem[i].getProductSpec().getUnitPrice() + "\t";
            s += this.salesLineItem[i].getSubtotal();
            ui.println(s); 
        }
        ui.println("-----------------------------------------");
        ui.println("Total $" + Math.floor(this.total * 100) / 100);
        if(this.paymentType.equals("CHECK")){
            ui.println("Paid by check");
        }else if(this.paymentType.equals("CREDIT")){
            ui.println("Paid by Credit Card " + this.cardNum);
        }else{//cash
            ui.println("Amount Tendered: " + numberFormat.format(this.TenderedAmount));
            ui.println("Amount Returned: " + numberFormat.format(this.ReturedAmount));
        }

        ui.println("");

       
    }
/*      ACCESSORS             */
    public static int getInvoiceId(){
        return invoiceId;
    }
    public String getCustomerName(){
        return customerName;
    }
    public Timestamp getTimestamp(){
        return dateTime;
    }
    public TransactionItem[] getProductList(){
        return this.salesLineItem;
    }

    public String getPaymentType(){
        return paymentType;
    }
    public double getTotal(){
        return this.total;
    }
    public int getCardNum(){
        return cardNum;
    }
    public double getAmountTendered(){
        return this.TenderedAmount;
    }
    
/* MUTATORS                      */
    public void setCustomerName(String name){
        this.customerName = name;
    }
    /*public void setUpc(String upc){
        this.upc = upc;
    }*/
    public void setTimestamp(Timestamp ts){
        this.dateTime=ts;
    }
    /*public void setQuantity(int quantity){
        this.quantity=quantity;
    }*/
    public void setProductList(TransactionItem[] a){
        this.salesLineItem=a;
    }
    public void setPaymentType(String name){
        customerName = name;
    }
    public void setCardNum(int cardNum){
        this.cardNum = cardNum;
    }
    public void setAmountTendered(double amtTendered){
        this.TenderedAmount=amtTendered;
    }
}
