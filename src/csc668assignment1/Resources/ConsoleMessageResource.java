/*
 * This class is responsible for printing alert messages to the Command Line
 */
package csc668assignment1.Resources;

/**
 *
 * @author axelanconaesselmann
 */
public class ConsoleMessageResource implements MessageResourceInterface {
    public void printAlertMessage(String alertMessage) {
        System.out.println("----- Alert Message -----");
        System.out.println(alertMessage);
        System.out.println();
    }
    public void printMessage(String message) {
        System.out.println("----- Message -----");
        System.out.println(message);
        System.out.println();
    }
}
