package mx.edu.j2se.morales.tasks;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Hola mundo");

		Task Objeto1 = new Task("Prueba1",23);
		Task Objeto3 = new Task("Prueba2",3,26,5);

		Objeto1.setActive(true);
		Objeto3.setActive(true);
		System.out.println("Start time"+Objeto1.getStart()+"end time"+Objeto1.getEnd());
		System.out.println("Start time"+Objeto3.getStart()+"end time"+Objeto3.getEnd());
		System.out.println(Objeto1.nextTimeAfter(2));
		System.out.println(Objeto3.nextTimeAfter(2));

	}
	
}
