/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc668assignment1.Resources;

/**
 *
 * @author axelanconaesselmann
 */
public class ResourceException extends Exception {
    private String _message;

    @Override
    public String getMessage() {
        return _message;
    }
    void setMessage(String message) {
        _message = message;
    }
    
}
