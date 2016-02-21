package com.simulacioninteres.logic;
/**
 * Clase prestamo
 * @author Edgar Antonio Meneses Cadena
 *
 */
public class Loan {
	
	private double loanValue;
	private int quotaNumber;
	private double quotaValue;
	private int period;
	
	public Loan(){
		
	}
		
	public Loan(double loanValue, int loanPeriod) {
		this.loanValue = FactorLoan.approximated(loanValue);
		this.quotaNumber = 0;
		quotaValue = FactorLoan.approximated(loanValue/loanPeriod); //FactorLoan.approximated(loanValue/loanPeriod);
		this.period = loanPeriod;
	}
	
	public double getLoanValue() {
		return loanValue;
	}
	public void setLoanValue(long loanValue) {
		this.loanValue = loanValue;
	}
	public int getQuotaNumber() {
		return quotaNumber;
	}
	public void setQuotaNumber(int quotaNumber) {
		this.quotaNumber = quotaNumber;
	}
	public double getQuotaValue() {
		return quotaValue;
	}
	public void setQuotaValue(long quotaValue) {
		this.quotaValue = quotaValue;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	@Override
	public String toString() {
		return "Loan [loanValue=" + loanValue + ", quotaNumber=" + quotaNumber
				+ ", quotaValue=" + quotaValue + ", period=" + period + "]";
	}

	
}
