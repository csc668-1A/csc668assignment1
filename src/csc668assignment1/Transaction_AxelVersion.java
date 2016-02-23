/*
 * Just a stub with getters and setters.
 */
package csc668assignment1;

/**
 *
 * @author 
 */
public class Transaction_AxelVersion {
    private String _name, _upc;
    private int _quantity;
    private Payment _payment;
    public Transaction_AxelVersion(String name, String upc, int quantity, Payment payment) {
        _name = name;
        _upc = upc;
        _quantity = quantity;
        _payment = payment;
    }
    public String getUpc() {
        return _upc;
    }
    public int getQuantity() {
        return _quantity;
    }

    public String getName() {
        return _name;
    }
    
    public Payment getPayment() {
        return _payment;
    }
}
