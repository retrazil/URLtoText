
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author suraj
 */
public class URLtoText implements Runnable{
    private JFrame frame; 
    

    @Override
    public void run() {
        frame = new JFrame("URLtoText");
        frame.setLocationRelativeTo(null); // create a window at the center of the screen
        frame.setPreferredSize(new Dimension(400, 800));
        
        JPanel topArea = new JPanel(new FlowLayout());
        JLabel labeForURLInput = new JLabel("Enter URL");
        JTextArea displayWebPage = new JTextArea();
        JTextField inputURL = new JTextField(20);
        JButton download = new JButton("Go");
        
        // Source : http://docs.oracle.com/javase/tutorial/uiswing/components/scrollpane.html
        JScrollPane scrollPane = new JScrollPane(displayWebPage);
        displayWebPage.setWrapStyleWord(true);
        
        displayWebPage.setEditable(false);
        download.addActionListener(new ButtonListener(inputURL, displayWebPage));
        
        topArea.add(labeForURLInput); 
        topArea.add(inputURL);
        topArea.add(download);
        frame.getContentPane().add(topArea, BorderLayout.PAGE_START);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
}
