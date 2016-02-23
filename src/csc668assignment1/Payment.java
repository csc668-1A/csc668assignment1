/*
 * Only a stub for now
 */
package csc668assignment1;

/**
 *
 * @author axelanconaesselmann, Susanne
 */
public abstract class Payment {
    protected double _amountDue;
    protected String _type;
    
    public Payment(){
        _amountDue = 0.0;
        _type = "";
    }
    
    public Payment(double amount) {
        _amountDue = amount;
    }
    
    public abstract void makePayment(double amountPaid);

    public String getType() {
        return _type;
    }
    
    public double getAmountDue() {
        return _amountDue;
    }
}
