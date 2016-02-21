package com.simulacioninteres.logic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.BitSet;
/**
 * clase que tiene las caracteristicas generales de los prestamos
 * se maneja el dinero inicial el periodo de prestamo y el interes
 * @author AntoniusHack
 *
 */
public class FactorLoan {

	private double seedMoney;
	private double interesRate;
	private int loanPeriod;
	private double minMoneyLoan;
	private double raisedMoney;
	private ArrayList<Loan> loans;

	public FactorLoan(double seedMoney, double interesRate, int loanPeriod, double maxMoneyLoan) {
		this.seedMoney = seedMoney;
		this.interesRate = interesRate;
		this.loanPeriod = loanPeriod;
		this.minMoneyLoan = maxMoneyLoan;
		this.raisedMoney=0;
		this.loans = new ArrayList<Loan>();
	}
	/**
	 * metodo que vacia toda la lista de prestamosy crear la primera cuota
	 */
	private void init(){
		loans.removeAll(loans);
		loans.add(new Loan(interesWithMoney(seedMoney), loanPeriod));
	}
	/**
	 * metodo para agregar un nuevo prestamo
	 * @param loan
	 */
	public void addLoand(Loan loan){
		loans.add(loan);
	}
	/**
	 * metodo que resive un valor de dinero y retorna el dinero mas el interes
	 * @param money
	 * @return
	 */
	public double interesWithMoney(double money){
		return (money + (money*interesRate));
	}
	/**
	 * se retorna la ganancia que setiene en un dia
	 * @param day
	 */
	public double gaiOfDay(int day){
		init();
		for (int i = 1; i < day; i++) {
			createLoan(i);
		}
		return valorPrestado();
	}

	public int day(double money){
		init();
		int day = 1;
		while(valorPrestado()< money){
			createLoan(day);
			day=day+1;
		}
		return day;
	}
	
//
//	public void createLoan(int loanNumber){
//		addLoand(new Loan(interesWithMoney(valueNextLoan(loanNumber)), loanPeriod));
//	}
	
	public void createLoan(int loanNumber){
		raisedMoney=raisedMoney+valueNextLoan(loanNumber);
		if (raisedMoney>=minMoneyLoan) {
			addLoand(new Loan(interesWithMoney(raisedMoney), loanPeriod));
			//addLoand(new Loan(approximated(interesWithMoney(raisedMoney)), loanPeriod));
			raisedMoney=0;
		}	
	}

	public double valueNextLoan(int loanNumber){
		double valor = 0;
		for (int i = 0; i < loans.size(); i++) {
			if(loans.get(i).getQuotaNumber()<30){
				valor = valor+loans.get(i).getQuotaValue();
				loans.get(i).setQuotaNumber(loans.get(i).getQuotaNumber()+1);
			}
		}
		return valor;
	}

	public double valorPrestado(){
		double valor = 0;
		for (Loan loan : loans) {
			if(loan.getQuotaNumber() < 30){
				//valor =(valor + loan.getLoanValue());
				valor=valor+(loan.getQuotaValue()*(loan.getPeriod()-loan.getQuotaNumber()));
			}
			
		}
		return valor;//+raisedMoney;
	}
	

	public static double approximated(double number){
		number = Math.ceil(number);
		if(number < 10){
			return 50;
		}
		return (double) (calculateApproach((long)number));
	}
	
	public static long calculateApproach(long number){
		if(getDigit(number, 2) < 5){
			return (Math.round(number/100)*100)+50;
		}else if(getDigit(number, 2) == 5){
			return calculateApproach(number, 1);
		}
		else{
			return (Math.round(number/100)*100)+100;
		}
	}
	
	private static long calculateApproach(long number, int pos){
		if(getDigit(number, pos) ==0){
			return (Math.round(number/100)*100)+50;
		}
		return (Math.round(number/100)*100)+100;
	}
	
	private static long  getDigit(long number, int pos){
		String auxNumero = number+"";
		return Integer.parseInt(auxNumero.charAt(auxNumero.length()-pos)+"");
	}


	public double getSeedMoney() {
		return seedMoney;
	}
	public void setSeedMoney(double seedMoney) {
		this.seedMoney = seedMoney;
	}
	public double getInteresRate() {
		return interesRate;
	}
	public void setInteresRate(double interesRate) {
		this.interesRate = interesRate;
	}
	public int getLoanPeriod() {
		return loanPeriod;
	}
	public void setLoanPeriod(int loanPeriod) {
		this.loanPeriod = loanPeriod;
	}
	public ArrayList<Loan> getLoans() {
		return loans;
	}
	public double getMaxMoneyLoan() {
		return minMoneyLoan;
	}
	public void setMaxMoneyLoan(double maxMoneyLoan) {
		this.minMoneyLoan = maxMoneyLoan;
	}
	public double getRaisedMoney() {
		return raisedMoney;
	}
	public void setRaisedMoney(long raisedMoney) {
		this.raisedMoney = raisedMoney;
	}

	public static void main(String[] args) {
		
		//System.out.println(Math.ceil(549.9));
		//System.out.println(approximated(550.1119999));
//		long p =(long) 550.233;
//		System.out.println(p);
				FactorLoan factorPrestamo = new FactorLoan(100000, 0.1, 30,10000);
				double num = factorPrestamo.gaiOfDay((int)365);
		//		
				System.out.println(num);
				System.out.println(factorPrestamo.loans.size());
//		
				for (Loan prestamo :factorPrestamo.loans) {
					System.out.println(prestamo);
				}
				System.out.println("**********************************************");
				int dia = factorPrestamo.day(1000000);
				System.out.println(dia);
				//System.out.println(factorPrestamo.valorPrestado());
		//		System.out.println(factorPrestamo.loans.size());
		//		for (Loan prestamo :factorPrestamo.loans) {
		//			System.out.println(prestamo);
		//		}
	}


}
