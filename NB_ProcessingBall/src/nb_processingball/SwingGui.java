/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nb_processingball;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author scuola
 */

public class SwingGui {

    private JFrame frame;

    public SwingGui(DatiCondivisi datiC) {
        frame = new JFrame("Controls");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // a panel where add buttons with flow layout
        JPanel controls = new JPanel();
        controls.setLayout(new FlowLayout());

        // define the button to choose color background
        JButton pickColor = new JButton("Colore ...");
        pickColor.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(pickColor, "Color Picker", Color.RED);
                datiC.setColor(color.getRed(), color.getGreen(), color.getBlue());
            }
        });

        // define the button to show the animated figure
        JButton incBtn = new JButton("Incrementa");
        incBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               datiC.incVel();
            }
        });
        
        // define the button to hide the animated figure
        JButton delBtn = new JButton("Decrementa");
        delBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               datiC.decVel();
            }
        });

        // add the buttons to the panel
        controls.add(pickColor);
        controls.add(incBtn);
        controls.add(delBtn);
        // add the panel to the frame
        frame.add(controls);
        frame.setSize(400, 80);
    }

    public void show() {
        frame.setVisible(true);
    }
}
