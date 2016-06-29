package hotel.hotel;

import hotel.klient.Klient;

public class Zamowienie{
	Ankieta ankieta;
	Klient klient;
	int ilosc = 0;
	
	public Zamowienie( Klient klient, Ankieta ankieta){
		this.ankieta = ankieta;
		this.klient = klient;
	}
	public String toString(){
		return "Zamówienie: " + ankieta.toString();
	}
	
	public Klient zwrocKlient(){
		return this.klient;
	}
	
	public Ankieta zwrocAnkiete(){
		return this.ankieta;
	}
	public int zwrocIlosc(){
		return this.ilosc;
	}
	
	public void dodajIlosc(){
		this.ilosc++;
	}
	
}
