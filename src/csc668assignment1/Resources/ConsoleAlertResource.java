/*
 * This class is responsible for printing alert messages to the Command Line
 */
package csc668assignment1.Resources;

/**
 *
 * @author axelanconaesselmann
 */
public class ConsoleAlertResource implements AlertMessageResourceInterface {
    public void print(String alertMessage) {
        System.out.println("----- Alert Message -----");
        System.out.println(alertMessage);
        System.out.println();
    }
}
