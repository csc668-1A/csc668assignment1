/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package csc668assignment1.UserInterface;

/**
 *
 * @author DC
 */
import java.rmi.*;
public class Server
{
          public static void main(String args[])
{
                   try
{                            //creating implementation object
UserInterface si = new UserInterface();
                             Naming.rebind("POST2SERVER",si);
                             }
catch(Exception e){}
                   }
}

