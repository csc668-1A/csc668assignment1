/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc668assignment1.Resources;

import csc668assignment1.ProductSpec;

/**
 *
 * @author axelanconaesselmann
 */
public interface ProductsResourceInterface {
    public boolean hasNext();
    public String getUPC();
    public String getDescription();
    public float getUnitPrice();
    public void printProductSpec(ProductSpec product);
}
