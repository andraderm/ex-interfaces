package model.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.services.PaymentService;

public class Installment {
	
	private Integer number;
	private List<Double> installmentValues = new ArrayList<>();
	private List<Date> dates = new ArrayList<>();
	
	private PaymentService paymentService;
	
	public Installment() {
	}
	
	public Installment(Integer number, Double contractValue, Date date, PaymentService paymentService) {
		this.number = number;
		this.paymentService = paymentService;
		for(int i = 1; i <= number; i++) {
			this.installmentValues.add(contractValue/number);
		}
		installmentDates(date);
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public List<Double> getInstallmentValue() {
		return paymentService.tax(installmentValues);
	}

	public PaymentService getPaymentService() {
		return paymentService;
	}

	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	public List<Date> getDates(){
		return dates;
	}

	private void installmentDates(Date date) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		for(int i = 0; i < number; i++) {
			cal.add(Calendar.MONTH, 1);
			this.dates.add(cal.getTime());
		}
	}

}
