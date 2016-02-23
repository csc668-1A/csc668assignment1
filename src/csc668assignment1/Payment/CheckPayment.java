/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc668assignment1.payment;

import csc668assignment1.Payment;

/**
 *
 * @author Susanne
 */
public class CheckPayment extends Payment {
    
    public CheckPayment(double amount) {
        _type = "CHECK";
        _amountDue = amount;
    }
    @Override
    public String toString() {
        return _type + " " + Double.toString(_amountDue);
    }
    
    public void makePayment(double amountPaid){
       _amountDue -= amountPaid;
   }
}
