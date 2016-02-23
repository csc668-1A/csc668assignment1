/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc668assignment1;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Item-quantity pairs in a transaction 
 * @author Karl
 */
public class TransactionItem {
    private int quantity;
    private String upc;
    private ProductSpec productSpec;
    
    public TransactionItem(){
        
    }
    public TransactionItem(String upc, int quantity ){
        this.quantity = quantity;
        this.upc = upc;
        this.productSpec = ProductCatalog.getProductSpec(upc);
    }
    /*ACCESSORS*/
    public int getQuantity(){
        return this.quantity;
    }
    public String getUpc(){
        return this.upc;
    }
    public ProductSpec getProductSpec(){
        if(productSpec!=null){
            return productSpec;
        }
        else
            return null;
    }
    public double getSubtotal(){
        double subtotal=this.quantity * this.productSpec.getUnitPrice();
        subtotal=Math.floor(subtotal * 100) / 100;
        return subtotal;
    }
    /*MUTATORS*/
    public void setQuantity(int q){
        this.quantity=q;
    }
    public void setUpc(String upc){
        this.upc=upc;
    }
    /**
     * uses the upc of the product to retrieve the description from the Catalog
     * @param upc 
     */
    public void setProductSpec(String upc){
        this.productSpec = ProductCatalog.getProductSpec(upc);
    }
    
    //added by Jie
    //override the toString() method for testing
    @Override
    public String toString(){
        return "upc: " + upc + " quantity: " + quantity + " unit Price: "+ this.productSpec.getUnitPrice();
        
    }
    public static void main(String[] args) throws FileNotFoundException, IOException{
        //initiate the product catalog
        ProductCatalog.getProductCatelog("products.txt").setProductCatelog();
        TransactionItem s = new TransactionItem("1001", 5);
        System.out.println(s);
        System.out.println("the subtotal for this salesLineitem is: " + s.getSubtotal());
    }
}
