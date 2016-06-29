package hotel.recepcjonista;

import hotel.hotel.Ankieta;
import hotel.hotel.Pokoj;

public class Recepcjonista {
	private String imie;
	private String nazwisko;
	private StrategiaRecepcjonisty strategia;
	public Recepcjonista(String imie, String nazwisko, StrategiaRecepcjonisty strategia){
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.strategia = strategia;
	}
	
	public int wybierzPokoj(Pokoj[] pokoje, Ankieta ankieta){
		return this.strategia.wybierzPokoj(pokoje, ankieta);
	}
	public String toString(){
		return "Recepcjonista: " + imie + " " + nazwisko + ", " + strategia.toString() + ".";
	}
}
