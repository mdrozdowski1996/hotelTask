package hotel.klient;

import hotel.hotel.Ankieta;
import hotel.hotel.Pokoj;

public class Klient {
	private String imie;
	private String nazwisko;
	private StrategiaKlienta strategiaKlienta; 
	
	public Klient(String imie, String nazwisko, StrategiaKlienta strategiaKlienta){
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.strategiaKlienta = strategiaKlienta;
	}
	
	public boolean akceptuj(Pokoj pokoj, Ankieta ankieta){
		return this.strategiaKlienta.akceptujPokoj(pokoj, ankieta);
	}
	
	public String toString(){
		return "Klient: " + imie + " " + nazwisko + ", " + strategiaKlienta.toString();
	}

}
