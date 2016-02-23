/*
 * Author: Jie Li
 * Date: 2016/2/10
 * Description: Item extends ProductSpec. It has one more field, which records the inventory of one kind of product
 */
package csc668assignment1;

/**
 *
 * @author lenovo
 */
public class Item extends ProductSpec{
    private int quantity;
    public Item(int quantity, String upc, String Description, float unitPrice){
        super(upc, Description, unitPrice);
        this.quantity = quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public int getQuantity(){
        return this.quantity;
    }
}
