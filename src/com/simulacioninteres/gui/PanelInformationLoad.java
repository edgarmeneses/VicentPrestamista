package com.simulacioninteres.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.simulacioninteres.logic.FactorLoan;

public class PanelInformationLoad extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JLabel lblSeedMoney;
	private JLabel lblInteresRate;
	private JLabel lblLoadPeriod;
	private JLabel lblamount;
	private JTextField txtSeedMoney;
	private JTextField txtInteresRate;
	private JTextField txtLoadPeriod;
	private JTextField txtamount;
	private JLabel edit;
	private FactorLoan factorLoan;
	
	public PanelInformationLoad(FactorLoan factorLoan) {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		JPanel panelLabels = new JPanel();
		panelLabels.setLayout(new GridLayout(4, 2));
		this.factorLoan = factorLoan;
		lblSeedMoney = new JLabel("Dinero inicial");
		lblInteresRate =new JLabel("Tasa de interes");
		lblLoadPeriod = new JLabel("Periodo Maximo de prestamo");
		lblamount= new JLabel("Monto minimo de prestamo");
		
		txtSeedMoney = new JTextField(factorLoan.getSeedMoney()+"");
		txtSeedMoney.setEditable(false);
		txtInteresRate =new JTextField(factorLoan.getInteresRate()+"");
		txtInteresRate.setEditable(false);
		txtLoadPeriod = new JTextField(factorLoan.getLoanPeriod()+"");
		txtLoadPeriod.setEditable(false);
		txtamount=new JTextField(factorLoan.getMaxMoneyLoan()+"");
		txtamount.setEditable(false);
		
		panelLabels.add(lblSeedMoney);
		panelLabels.add(txtSeedMoney);
		panelLabels.add(lblInteresRate);
		panelLabels.add(txtInteresRate);
		panelLabels.add(lblLoadPeriod);
		panelLabels.add(txtLoadPeriod);
		panelLabels.add(lblamount);
		panelLabels.add(txtamount);
		
		add(panelLabels,BorderLayout.CENTER);
		edit();
	}
	
	private void edit(){
		edit = new JLabel("Editar");
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/edit.png"));
		edit.setIcon(icon);
		edit.addMouseListener(new MouseListener() {
			
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
				edit.setToolTipText("Editar datos del prestamo");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(edit.getText().equalsIgnoreCase("Editar")){
					txtInteresRate.setEditable(true);
					txtLoadPeriod.setEditable(true);
					txtSeedMoney.setEditable(true);
					txtamount.setEditable(true);
					edit.setText("Guardar");
					ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/save.png"));
					edit.setIcon(icon);
				}else{
					txtInteresRate.setEditable(false);
					txtLoadPeriod.setEditable(false);
					txtSeedMoney.setEditable(false);
					txtamount.setEditable(false);
					edit.setText("Editar");
					ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/edit.png"));
					edit.setIcon(icon);
					changeInformation();
				}
			}
		});
		
		add(edit, BorderLayout.SOUTH);
	}
	
	private void changeInformation(){
		
		factorLoan.setSeedMoney(Double.valueOf(txtSeedMoney.getText()));
		factorLoan.setInteresRate(Double.valueOf(txtInteresRate.getText()));
		factorLoan.setLoanPeriod(Integer.valueOf(txtLoadPeriod.getText()));
		factorLoan.setMaxMoneyLoan(Double.valueOf(txtamount.getText()));
		
//		
		txtSeedMoney.setText(factorLoan.getSeedMoney()+"");
		txtamount.setText(factorLoan.getMaxMoneyLoan()+"");
//		txtInteresRate.setText(factorLoan.getInteresRate()+"");
//		txtLoadPeriod.setText(factorLoan.getLoanPeriod()+"");
	}
	

}
