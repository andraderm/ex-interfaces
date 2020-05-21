package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = new Date();
		try {
			date = sdf.parse(sc.next());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.print("Contract value: ");
		Double value = sc.nextDouble();
		Contract contract = new Contract(number, date, value);
		
		System.out.print("Number of installments: ");
		Integer numberInstallments = sc.nextInt();
		contract.setInstallment(new Installment(numberInstallments, contract.getTotalValue(), contract.getDate(), new PaypalService()));
		
		System.out.println("Installments: ");
		for(int i = 1; i <= numberInstallments; i++) {
			System.out.println(sdf.format(contract.getInstallment().getDates().get(i-1)) + " - " + contract.getInstallment().getInstallmentValue().get(i-1));
		}
		
		sc.close();
	}

}
