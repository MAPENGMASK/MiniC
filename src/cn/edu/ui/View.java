package cn.edu.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

import cn.edu.com.MyNewGrammar;

public class View extends JFrame {
	private JTextArea textArea;
	private String filename;
	public  View() {
		this.setTitle("MiniC");
		this.setBounds(100, 100, 624, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setDividerLocation(100);
		this.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btn1 = new JButton("打开文件");
		btn1.setBackground(Color.WHITE);
		
		JButton btn2 = new JButton("文件内容");
		btn2.setBackground(Color.WHITE);
		
		JButton btn3 = new JButton("词法分析");
		btn3.setBackground(Color.WHITE);
		
		JButton btn4 = new JButton("语法分析");
		btn4.setBackground(Color.WHITE);
		
		JButton btn5 = new JButton("语义分析");
		btn5.setBackground(Color.WHITE);
		
		JButton btn6 = new JButton("符号列表");
		btn6.setBackground(Color.WHITE);
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser("test/");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int returnVal = fileChooser.showOpenDialog(fileChooser);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					filename = fileChooser.getSelectedFile().getAbsolutePath();
					MyNewGrammar.main(filename);
					textArea.setText(ReadFile(filename));
				}
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(filename!=null)
					textArea.setText(ReadFile(filename));
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(ReadFile("src/binary.txt"));
			}
		});
		
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(ReadFile("src/tree.txt"));
			}
		});
		
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(ReadFile("src/result.txt"));
			}
		});
		
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(ReadFile("src/variabletable.txt"));
			}
		});
		
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		panel.add(btn6);
		
		JPanel panel2 = new JPanel();
		splitPane.setRightComponent(panel2);
		panel2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 600, 500);
		panel2.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setBackground(Color.WHITE);
		textArea.setLineWrap(true);
		
		this.setVisible(true);
	}
	String ReadFile(String filename){
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(new File(filename)));
			String line = "";
			String text="";
			while((line = br.readLine()) != null){
				text+=line+"\n";
			}
			br.close();
			return text;
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "";
	}
	public static void main(String[] args) {
		View windows = new View();
	}
	
}
