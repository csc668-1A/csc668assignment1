/*
 * Author: Jie Li
 * Date: 2016/2/10
 * Purpose:1. To store the specifications for all kinds of products
 * Question left:Are we supposed to record the quantity of product?
 *                 Do we need to sort the products?
 */
package csc668assignment1;

//ProductCatelog is a singleton

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class ProductCatalog {
    private static HashMap specifications = new HashMap();
    private static ProductCatalog pc = null;
    private static ProductReader pr = null;
    private ProductCatalog(String filename) throws FileNotFoundException{
        this.pr = new ProductReader(filename);
    }
    
    public static ProductCatalog getProductCatelog(String filename) throws FileNotFoundException{
        if(pc == null){
            //initiate an instance of ProductCatalog
               pc = new ProductCatalog(filename);
        }
        return pc;
    }
    public void setProductCatelog() throws IOException{
        while(pr.hasMoreProduct()){
            ProductSpec newProductSpec = pr.getNextProduct();
            addNewProductSpec(newProductSpec);
        }
    }
    public void addNewProductSpec(ProductSpec newProductSpec){
        //add newProductSpec to hashmap
        specifications.put(newProductSpec.getUpc(), newProductSpec);
        
    } 
    //get the product specification according to a upc
    public static ProductSpec getProductSpec(String upc){
        return (ProductSpec)specifications.get(upc);
    }
    public static boolean hasProduct(String upc){
        return specifications.get(upc) != null;
    }
    public void sortCatelog(){
        
    }
    //test method 
    public static void main(String[] args) throws FileNotFoundException, IOException{
        //initiate one instance of ProductCatalog
        ProductCatalog pc = ProductCatalog.getProductCatelog("products.txt");
        pc.setProductCatelog();
        System.out.println(ProductCatalog.getProductSpec("1001"));
        System.out.println(ProductCatalog.hasProduct("1001"));
    }
    
}

    
