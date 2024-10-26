package edu.ptithcm.view;

import edu.ptithcm.util.ImageProcess;
import edu.ptithcm.view.adminView.AdminFrame;
import edu.ptithcm.view.customerView.CustomerFrame;
import edu.ptithcm.view.window.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Le Ngoc Tu
 */
public class App extends MainWindow{
    private JPanel mainPanel;
    private String backgroundPath = ImageProcess.dirAppImage + "AppBackground.jpg";
    private BufferedImage background;

    public App(){
        setTitleAndIcon("BakeryApp", ImageProcess.dirAppImage + "AppIcon.png");

        initMainPanel();

        JButton adminButton = new JButton("Admin login");
        JButton customerButton = new JButton("Customer login");

        adminButton.addActionListener(event->initAdminView());
        customerButton.addActionListener(event->initCustomerView());

        mainPanel.add(adminButton);
        mainPanel.add(customerButton);

        add(mainPanel);
    }

    private void initMainPanel(){
        try{
            background = ImageProcess.getBufferedImage(backgroundPath);
            mainPanel = new JPanel(){
                @Override
                public void paintComponent(Graphics g){
                    super.paintComponent(g);
                    g.drawImage(background, 0, 0, mainPanel.getWidth(), mainPanel.getHeight(),null);
                }
            };
        }
        catch(IOException e) {
            System.out.printf(
                    "Khong the load appBackground tu file %s: %s\n\n",
                    backgroundPath, e.getMessage()
            );
            mainPanel = new JPanel();
        }
    }

    private void initAdminView(){
        AdminFrame view = new AdminFrame();
        view.setVisible(true);
    }

    private void initCustomerView(){
        CustomerFrame view = new CustomerFrame();
        view.setVisible(true);
    }
}