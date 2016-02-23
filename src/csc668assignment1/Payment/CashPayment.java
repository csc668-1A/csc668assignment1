/*
 * Only a stub for now
 */
package csc668assignment1.payment;

import csc668assignment1.Payment;

/**
 *
 * @author Susanne
 */
public class CashPayment extends Payment {
    private double _change;
    
    public CashPayment() {
        _type = "CASH";
        _change = 0.0;
    }
    
    public CashPayment(double amount){
        _type   = "CASH";
        _change = 0;
        _amountDue = amount;
    }
    
    @Override
    public String toString() {
        return _type + " " + Double.toString(getAmountDue());
    }

    public void makePayment(double amountPaid){
        _amountDue -= amountPaid;
        if( _amountDue < 0) 
            _change = (-1) * _amountDue;
    }
    
    public double getChange() {
        return _change;
    }
}
