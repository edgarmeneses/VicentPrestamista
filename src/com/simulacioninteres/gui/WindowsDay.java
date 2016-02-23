package com.simulacioninteres.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WindowsDay extends JFrame{
	private JLabel lblTitle;
	private JLabel back;
	private WindowsMain windowsMain;
	public WindowsDay(WindowsMain windowsMain) {
		// TODO Auto-generated constructor stub
		
//		super(windowsMain, true);
		setSize(500, 600);
		setLocationRelativeTo(null);
		setLayout(null);
		setUndecorated(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.windowsMain=windowsMain;
		this.windowsMain.setVisible(false);
		
		ImageIcon icono = new ImageIcon(getClass().getResource("/images/icono.png")); 
	    this.setIconImage(icono.getImage());
		
		Font font = new Font("Arial", Font.BOLD, 30);
		this.lblTitle = new JLabel("Calculador de ganancias");
		this.lblTitle.setForeground(Color.BLUE);
		this.lblTitle.setFont(font);
		this.lblTitle.setBounds(70, 10, 400,	50);
		add(lblTitle);
		
		PanelInformationLoad informationLoad= new PanelInformationLoad(windowsMain.getFactorLoan());
		informationLoad.setBounds(25, 100, 400, 150);
		add(informationLoad);
		
		PanelDay panelDay = new PanelDay(windowsMain.getFactorLoan());
		panelDay.setBounds(25, 300, 420, 140);
		add(panelDay);
		
		back();
	
	}
	
	public void back(){
		back = new JLabel();
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/back.png"));
		back.setIcon(icon);
		back.setBounds(400, 500, 128, 70);
		back.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				windowsMain.setVisible(true);
			}
		});
		
		add(back);
	}

}