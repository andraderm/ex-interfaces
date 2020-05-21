package model.services;

import java.util.ArrayList;
import java.util.List;

public class PaypalService implements PaymentService {

	public List<Double> tax(List<Double> installments) {
		Double value;
		List<Double> taxedValues = new ArrayList<>();
		int month = 1;
		for(Double installment : installments) {
			value = installment * (1.00 + (double) month/100);
			value *= 1.02;
			taxedValues.add(value);
			month += 1;
		}
		return taxedValues;
	}



}
