package com.simulacioninteres.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.simulacioninteres.logic.FactorLoan;

public class PanelDay extends JPanel{
	private JLabel lblday;
	private JTextField txtDay;
	private JLabel lblResult;
	private JTextField txtResult;
	private JLabel calculate;
	private FactorLoan factorLoan;


	public PanelDay(FactorLoan factorLoan) {
		// TODO Auto-generated constructor stub
		this.factorLoan = factorLoan;
		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 2));
		lblday = new JLabel("Ingrese el monto");
		txtDay = new JTextField();
		lblResult = new JLabel("Resultado");
		txtResult = new JTextField("0 dias");
		txtResult.setEnabled(false);

		panel.add(lblday);
		panel.add(txtDay);
		panel.add(lblResult);
		panel.add(txtResult);

		add(panel,BorderLayout.CENTER);
		calculate();

	}

	private void calculate(){
		calculate = new JLabel("Calcular");
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/images/calculate.png")); 
		Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(70, 
				70, 
				Image.SCALE_DEFAULT)); 
		//label_imagen.setIcon(imagen); 
		//ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/calculate.png"));
		calculate.setIcon(icon);
		calculate.addMouseListener(new MouseListener() {

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
				calculate.setToolTipText("Calcular");
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int ganOfDay = factorLoan.day(Double.valueOf(txtDay.getText()));
				txtResult.setText(ganOfDay +" dias");
			}
		});
		add(calculate, BorderLayout.SOUTH);
	}
}


