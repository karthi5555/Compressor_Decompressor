/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author Karthik M
 */

import comp_decomp.compressor;
import comp_decomp.decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class AppFrame implements ActionListener{
    JButton compressionButton;
    JButton decompressionButton;
    JFrame frame;
    
    AppFrame(){
        frame = new JFrame("Compress (or) Decompress");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setBackground(Color.blue);
        
        compressionButton = new JButton("select file to Compress");
        compressionButton.setBounds(125, 175, 200, 50);
        compressionButton.setBackground(Color.LIGHT_GRAY);
        compressionButton.addActionListener(this);
        
        decompressionButton = new JButton("select file to Decompress");
        decompressionButton.setBounds(375, 175, 200, 50);
        decompressionButton.setBackground(Color.LIGHT_GRAY);
        decompressionButton.addActionListener(this);
        
        frame.add(compressionButton);
        frame.add(decompressionButton);
        frame.setSize(700, 450);
        
        frame.getContentPane().setBackground(Color.BLUE);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String s = e.getActionCommand();
        if(s.equals("slect file to Compress")){
            frame.getContentPane().setBackground(Color.red);
        }
        if(s.equals("slect file to Decompress")){
            frame.getContentPane().setBackground(Color.GREEN);
        }
        
        if(e.getSource() == compressionButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    compressor.method(file);
                }catch(Exception ee){
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
        
        if(e.getSource() == decompressionButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    decompressor.method(file);
                }catch(Exception ee){
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
    }
    
}
