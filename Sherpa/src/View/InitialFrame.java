package View;

import java.awt.Color;
import javax.swing.*;


public class InitialFrame extends JFrame
{
    //---------------Attributes---------------
    private InitialPanel ip;

    //--------------Constructor---------------
    public InitialFrame()
    {
        super("Sherpa");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1400, 800);
        setVisible(true);
        JLabel tempWindow = new JLabel("This window is placeholder and not fully "
                + "implemented");
        tempWindow.setForeground(Color.red);
        tempWindow.setBounds(500, 300, 400, 20);
        add(tempWindow);

        ip = new InitialPanel();
        add(ip);
    }
    
    //--------------Modules---------------
    public InitialPanel getIp()
    {
        return ip;
    }
  
}
