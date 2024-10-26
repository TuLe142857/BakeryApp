package edu.ptithcm;

import edu.ptithcm.view.App;

import javax.swing.*;
/**
 * @author Le Ngoc Tu
 */
public class Main {
    static{
        try {
            System.out.println("Setting java UI look and feel.....");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            System.out.println("Ok\n");
        } catch (Exception e) {
            System.out.println("Failed\n");
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.setVisible(true);
    }
}