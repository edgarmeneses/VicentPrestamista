package com.simulacioninteres.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.simulacioninteres.logic.FactorLoan;

public class WindowsMain extends JFrame{
	private FactorLoan factorLoan;
	private JLabel money;
	private JLabel day;
	private JLabel setting;
	private JPanel panelOptions;
	private JLabel lblTitle;
	private JLabel logout;
	private WindowsMain windowsMain;
	
	public WindowsMain(FactorLoan factorLoan) {
		// TODO Auto-generated constructor stub
		setSize(500, 600);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setUndecorated(false);
		setBackground(Color.WHITE);
		this.factorLoan = factorLoan;
		this.windowsMain=this;
		ImageIcon icono = new ImageIcon(getClass().getResource("/images/money.png")); 
	    this.setIconImage(icono.getImage());
		
		Font font = new Font("Arial", Font.BOLD, 30);
		this.lblTitle = new JLabel("Calculadora de prestamos");
		this.lblTitle.setForeground(Color.BLUE);
		this.lblTitle.setFont(font);
		this.lblTitle.setBounds(70, 10, 400,	50);
		add(lblTitle);
		
		this.panelOptions = new JPanel();
		this.panelOptions.setLayout(new GridLayout(2,2));
		this.panelOptions.setBounds(70, 100, 400, 450);
		
		money();
		day();
		setting();
		logout();
		
		add(panelOptions);
	}
	
	public void money(){
		money = new JLabel();
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/money.png"));
		money.setIcon(icon);
		money.addMouseListener(new MouseListener() {
			
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
				money.setToolTipText("Calcular dinero en un tiempo determinado");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				WindowsGainDay gainDay = new WindowsGainDay(windowsMain);
				gainDay.setVisible(true);
			}
		});
		panelOptions.add(money);
	}
	
	public void day(){
		day = new JLabel();
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/date.png"));
		day.setIcon(icon);
		day.addMouseListener(new MouseListener() {
			
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
				day.setToolTipText("Calcular dias para obtener el dinero");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				WindowsDay windowsDay = new WindowsDay(windowsMain);
				windowsDay.setVisible(true);
			}
		});
		panelOptions.add(day);
	}
	
	public void setting(){
		setting= new JLabel();
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/setting.png"));
		setting.setIcon(icon);
		setting.addMouseListener(new MouseListener() {
			
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
				setting.setToolTipText("Configuraciones del prestamo");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				WindowsInformation information = new WindowsInformation(windowsMain);
				information.setVisible(true);
			}
		});
		panelOptions.add(setting);
	}
	
	private void logout(){
		logout = new JLabel();
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/images/logout.png")); 
		Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(128, 
		                                                               128, 
		                                                               Image.SCALE_DEFAULT));
		logout.setIcon(icon);
		logout.addMouseListener(new MouseListener() {
			
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
				money.setToolTipText("Salir");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int option = JOptionPane.showConfirmDialog(null, "¿Seguro que desea salir?", "Confirmación de salida",  JOptionPane.YES_NO_OPTION);
				if(option==0){
					System.exit(0);

				}
			}
		});
		panelOptions.add(logout);
	}
	
	public FactorLoan getFactorLoan() {
		return factorLoan;
	}

	public static void main(String[] args) {
		FactorLoan factorPrestamo = new FactorLoan(100000, 0.1, 30,10000);
		WindowsMain main = new WindowsMain(factorPrestamo);
		main.setVisible(true);
	}

}
