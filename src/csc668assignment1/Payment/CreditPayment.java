/*
 * Only a stub for now
 */
package csc668assignment1.payment;

import csc668assignment1.Payment;

/**
 *
 * @author axelanconaesselmann, Susanne
 */
public class CreditPayment extends Payment {
    private int _cardNbr;

    public CreditPayment(){
        _type = "CREDIT";
        _cardNbr = 0;
    }
    
    public CreditPayment(String cardNum){
        _type   ="CREDIT";
        _cardNbr=Integer.parseInt(cardNum);
    }
    
    public CreditPayment(double amountDue,String cardNum){
        _type   ="CREDIT";
        _cardNbr=Integer.parseInt(cardNum);
        _amountDue = amountDue;
    }
    
    public CreditPayment(double amountDue, int cardNbr){
        _type    = "CREDIT";
        _cardNbr = cardNbr;
        _amountDue = amountDue;
    }
    @Override
    public String toString() {
        return _type + " " + _cardNbr;
    }
    
   public void makePayment(double amountPaid){
       _amountDue -= amountPaid;
   }
   public int getCardNum(){
       return this._cardNbr;
   }

    
}
