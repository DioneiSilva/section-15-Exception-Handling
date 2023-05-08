package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	System.out.print("Room number: ");
	int number = sc.nextInt();
	System.out.print("Check-in date(dd/mm/yyyy): ");
	Date checkIn = sdf.parse(sc.next());
	
	System.out.print("Check-out date (dd/mm/yyyyy)");
	Date checkOut = sdf.parse(sc.next());
	
	if(! checkOut.after(checkIn)) {
		System.out.print("Error in reservation: Check-out date must after check-in date");
	}
	else {
		Reservation reservation = new Reservation(number, checkIn, checkOut);
		System.out.println("Reservation: " + reservation);
		
	}
	
	
	
	
	
	
	sc.close();

	}

}
