package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter patternDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		
		System.out.print("Check-in date (dd/MM/yyyy): ");
		LocalDate checkIn = LocalDate.parse(sc.next(), patternDate);
		
		System.out.print("Check-out date (dd/MM/yyyy): ");
		LocalDate checkOut = LocalDate.parse(sc.next(), patternDate);
		
		if(checkIn.isAfter(checkOut)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");;
		}else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter to update the reservation: ");
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = LocalDate.parse(sc.next(), patternDate);
			
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = LocalDate.parse(sc.next(), patternDate);
			
			LocalDate now = LocalDate.now();
			
			if(checkIn.isBefore(now) || checkOut.isBefore(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}else if(checkIn.isAfter(checkOut)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");;
			}else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}
		}
	}

}
