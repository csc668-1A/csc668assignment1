/*
 * Author: Jie Li
 * Date: 2016/2/10
 * Purpose:1. To store the specification of a product.
 */
package csc668assignment1;

public class ProductSpec {
    private String upc;
    private String description;
    private float unitPrice;
    public ProductSpec(String upc, String description, float unitPrice){
        this.upc = upc;
        this.description = description;
        this.unitPrice = unitPrice;
        
    }
    public void setUpc(String upc){
        this.upc = upc;
    }
    public String getUpc(){
        return this.upc;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setUnitPrice(float unitPrice){
        this.unitPrice = unitPrice;
    }
    public float getUnitPrice(){
        return this.unitPrice;
    }
    
    @Override
    public String toString(){
        return "upc: "+ this.upc + " description: " + this.description + " price: "+ this.unitPrice;
    }
}
