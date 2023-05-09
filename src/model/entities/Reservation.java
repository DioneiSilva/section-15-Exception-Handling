package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	// Converte no formato de data esperado e static para não ter que instanciar um novo SimpleDateFormat para cada objeto que a aplicação tiver.
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;	
		
	}
	
	
			public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	} 
	
	public Date getCheckOut() {
		return checkOut;	
		
		
	}
	
	//Método para calcular a diferença entre datas para retornar a duração da reserva em dias
	
	public long duration() {
		
		// Pega a diferença entre as duas datas em milisegundos		
		long diff = checkOut.getTime() - checkIn.getTime();
		
		// Converte milisegundos para dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
				
		}
	public String upDateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		
		if(checkIn.before(now)||checkOut.before(now)) {
			return "Error in reservation: Reservation dates for update must be future dates";
		}
		 if(! checkOut.after(checkIn)) {
			return"Error in reservation: Check-out date must be after check-in date";
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;		
		// Se não ocorrer nenhum erro retorna nulo
		
		return null;
	}
	
	// Método ToString para retornar as informações da reserva
	
		@Override
		public String toString() {
			return "Room " + roomNumber
					+ ", checkIn: "
					+ sdf.format(checkIn)
					+ ", check-out: "
					+ sdf.format(checkOut) 
					+ ", "					
					+ duration()
					+ " nights"; 
		}
	
	
	
	
	
	

}
