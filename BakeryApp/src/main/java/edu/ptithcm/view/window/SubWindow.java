package edu.ptithcm.view.window;

import edu.ptithcm.util.ImageProcess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Le Ngoc Tu
 */
public class SubWindow extends JFrame{
    public SubWindow(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(dim.width*2/3, dim.height*2/3);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationByPlatform(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(confirmClose())
                    dispose();
            }
        });
    }

    public void setTitleAndIcon(String title, String iconPath){
        setTitle(title);
        ImageIcon icon = ImageProcess.getImageIcon(iconPath);
        if(icon.getImageLoadStatus() != MediaTracker.COMPLETE)
            return;
        setIconImage(icon.getImage());
    }

    private boolean confirmClose(){
        int result = JOptionPane.showConfirmDialog(
                this,
                "Bạn có xác nhận đóng cửa sổ?",
                "Xác nhận đóng cửa sổ",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        return (result == JOptionPane.YES_OPTION);
    }
}