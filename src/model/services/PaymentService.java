package model.services;

import java.util.List;

public interface PaymentService {
	
	public List<Double> tax(List<Double> installments);

}
