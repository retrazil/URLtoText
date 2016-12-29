
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author suraj
 */
public class ButtonListener implements ActionListener {

    private JTextArea displayWebsite;
    private JTextField inputURL;

    public ButtonListener(JTextField inputURL, JTextArea displayWebsite) {
        this.inputURL = inputURL;
        this.displayWebsite = displayWebsite;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        List<String> shellCommand = new ArrayList<>();;
        
        shellCommand.add("lynx");
        shellCommand.add("-dump");
        shellCommand.add(inputURL.getText());

        ProcessBuilder pb = new ProcessBuilder(shellCommand);
        StringBuilder webText = new StringBuilder();

        try {
            Process lynxDumper = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(lynxDumper.getInputStream()));
            webText.append(reader.readLine());
            String line;
            while ((line = reader.readLine()) != null) {
                webText.append(reader.readLine() + "\n");
            }
            reader.close();
        } catch (Exception exc) {
            System.out.println("Error :(");
        }
        
        System.out.println(webText.toString());

            displayWebsite.setText(webText.toString());
    }

}
