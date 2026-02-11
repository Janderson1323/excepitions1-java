package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Resevation;
import model.excepitions.DomainException;

public class Program {

	public static void main(String[] args)  {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		
		try {
			
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());

			Resevation resevation = new Resevation(number, checkIn, checkOut);
			System.out.println("Reservation " + resevation);
			System.out.println();

			System.out.println("Enter data to update the reservation: ");
			System.out.printf("Check-in date (dd/MM/yyyy):  ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy) ");
			checkOut = sdf.parse(sc.next());

			resevation.updateDates(checkIn, checkOut);
			System.out.println("Reservation:" + resevation);
			
			
		}
		
		catch (ParseException e ) {
			System.out.println("Invalid date format");
		}
		
		catch (DomainException e ) {
			System.out.println("Error in reservation:" + e.getMessage());
		}
		
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}

		sc.close();

	}

}
