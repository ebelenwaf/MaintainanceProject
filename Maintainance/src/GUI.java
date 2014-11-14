
//package com.examples;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUI
{
	
	private JTextArea edit=new JTextArea(60, 70);
	
	
	
	static String fileName;
	
	/*
	Validate v=new Validate(edit);
	EncrypterElement ee;
	DecrypterElement de;
	GenEnveloped ge;
	SignValidate sv=new SignValidate(edit);
	MainClass mc = new MainClass(edit);
	
	*/
	public GUI()
    {
		Font font = new Font("consolas", Font.PLAIN, 22);
		edit.setFont(font);
		
		edit.setEditable(false);
		
		
		Font fontbutton = new Font("consolas", Font.BOLD, 14);
		
		edit.setText("Maintainance Project: Select Text file from below");
		/*
		//edit.setSize(500, 1000);
		try
        {
			FileReader reader = new FileReader("../output.txt");
            BufferedReader br = new BufferedReader(reader);
            edit.read( br, null );
            br.close();
            edit.requestFocus();
        }
        catch(Exception e2) { System.out.println(e2); }
		*/
		//edit.setText(homeScreen);
        //edit = new JTextArea(30, 60);
        //edit.setText("one\ntwo\nthree");
        //edit.append("\nfour\nfive");

		//JPanel buttonPanel = new JPanel();
		JButton input= new JButton("Select Input Textfile");
		input.setFont(fontbutton);
		input.addActionListener( new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		try
                {
        			Tree.evaluate();
        			
        			
        			
        			FileReader reader = new FileReader("../output.txt");
                    BufferedReader br = new BufferedReader(reader);
                    edit.read( br, null );
                    br.close();
                    edit.requestFocus();
                }
                catch(Exception e2) { System.out.println(e2); }
        	}
        	
        	
        });
        
		
		
        edit.setSize(300, 400);
        JFrame frame = new JFrame("Maintainance Project");
        
        frame.setSize(850, 600);
        JPanel p1= new JPanel();
        p1.setLayout(new FlowLayout());
        p1.add(input);
       
       
        /*
        p1.add(read);
        
        
        p1.add(dsign);
        
        p1.add(vsign);
        p1.add(vcert);
        */
        
        
        
        
        frame.getContentPane().add( new JScrollPane(edit), BorderLayout.CENTER );
        
       // p1.setSize(1000, 1000);
        frame.add(p1,BorderLayout.SOUTH);
        //frame.getContentPane().add(read, BorderLayout.WEST);
        //frame.getContentPane().add(write, BorderLayout.EAST);
        //frame.getContentPane().add(enc, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }
	
	
	
	
	
	
	public static void main(String [] args)
	{
		//TextAreaLoad test = new TextAreaLoad();
		new GUI();
	}
}
