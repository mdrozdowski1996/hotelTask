package hotel.hotel;
import hotel.cechy.CechyPokoju;
import hotel.cechy.Kierunek;
import hotel.cechy.Kolorystyka;
import hotel.cechy.Styl;
import hotel.klient.Klient;
import hotel.klient.StrategiaKlienta;
import hotel.klient.StrategiaKlientaBudzetowego;
import hotel.klient.StrategiaKlientaPerfekcjonistycznego;
import hotel.klient.StrategiaKlientaPolowicznego;
import hotel.klient.StrategiaKlientaUgodowego;
import hotel.klient.StrategiaKlientaWidokowego;
import hotel.recepcjonista.AproksymacyjnaStrategiaRecepcjonisty;
import hotel.recepcjonista.LosowaStrategiaRecepcjonisty;
import hotel.recepcjonista.PerfekcjonistycznaStrategiaRecepcjonisty;
import hotel.recepcjonista.Recepcjonista;
import hotel.recepcjonista.StrategiaRecepcjonisty;
import hotel.recepcjonista.ZlosliwaStrategiaRecepcjonisty;

import java.util.Arrays;
import java.util.LinkedList;

public class Hotel {
	private Pokoj[] pokoje;
	private Recepcjonista[] recepcjonisci;
	
	public Hotel(Pokoj[] pokoje, Recepcjonista[] recepcjonisci){
		this.pokoje = pokoje;
		this.recepcjonisci = recepcjonisci;
	}
	
	public int zwrocIndeks(Pokoj pokoj){
		int indeks = -1;
		for(int i = 0; i < pokoje.length; i++){
			if(pokoje[i].equals(pokoj)) indeks = i;
		}
		return indeks;
	}
	public Pokoj[] zwrocWolnePokoje(KonkretnaData data, Pokoj[] pokoj){
		int ilosc = 0;
		for(int i = 0; i < pokoj.length; i++){
			if(pokoj[i].czyWolny(data) && zwrocIndeks(pokoj[i]) != -1)ilosc++;
		}
		Pokoj[] mojePokoje = new Pokoj[ilosc];
		ilosc = 0;
		for(int i = 0;i < pokoj.length; i++){
			if(pokoj[i].czyWolny(data) && zwrocIndeks(pokoj[i]) != -1){
				mojePokoje[ilosc] = pokoj[i];
				ilosc++;
			}
		}
		return mojePokoje;
	}
	
	public Zamowienie przyjmijZamowienie(Klient klient, Ankieta ankieta){
		return new Zamowienie(klient, ankieta);
	}
	
	public void akceptuj(Zamowienie[] zamowienia, Pokoj[] pokoje){
		
		LinkedList<Zamowienie> mojeZamowienia = new LinkedList(Arrays.asList(zamowienia));
		int numerRecepcjonisty = 0;
		int wylosowanyPokoj;
		Zamowienie zamowienie;
		Klient klient; 
		
		while(!mojeZamowienia.isEmpty()){
			
			zamowienie = mojeZamowienia.getFirst();
			klient = zamowienie.zwrocKlient();
			Ankieta ankieta = zamowienie.zwrocAnkiete();
			KonkretnaData data = new KonkretnaData(ankieta.poczatek(), ankieta.dlugoscPobytu());
			Pokoj[] pasujacePokoje = this.zwrocWolnePokoje(data, pokoje);
			wylosowanyPokoj = recepcjonisci[numerRecepcjonisty].wybierzPokoj(pasujacePokoje, zamowienie.zwrocAnkiete());
			zamowienie.dodajIlosc();
			
			
			if(zamowienie.zwrocIlosc() > 3){
				mojeZamowienia.removeFirst();
			}
			else{
				if(wylosowanyPokoj != -1){
					System.out.println(recepcjonisci[numerRecepcjonisty].toString());
					System.out.println(zamowienie.toString());
					System.out.println(pasujacePokoje[wylosowanyPokoj].toString());
					System.out.println(klient.toString());
					
					
				}
				if(wylosowanyPokoj != -1 && klient.akceptuj(pasujacePokoje[wylosowanyPokoj], ankieta)){	
					int indeks = zwrocIndeks(pasujacePokoje[wylosowanyPokoj]);
					pokoje[indeks].dodajRezerwacje(ankieta);	
					mojeZamowienia.removeFirst();
					System.out.println("tak");
				}
				else{
					mojeZamowienia.addLast(zamowienie);
					mojeZamowienia.removeFirst();
					if(wylosowanyPokoj != -1)
					System.out.println("nie");
				}
			}
			numerRecepcjonisty = (numerRecepcjonisty + 1) % recepcjonisci.length;
		}
	}
	
	public static void main(String args[]){
		CechyPokoju cechy = new CechyPokoju(Kolorystyka.JASNOZIELONY, Kierunek.POLUDNIE, Styl.MORSKI, true, 2, 100); 
		CechyPokoju cechy2 = new CechyPokoju(Kolorystyka.STALOWY, Kierunek.POLUDNIE, Styl.NOWOCZESNY, true, 3, 10); 
		CechyPokoju cechy3 = new CechyPokoju(Kolorystyka.STALOWY, Kierunek.POLNOC, Styl.MORSKI, false, 2, 100);
		CechyPokoju cechy4 = new CechyPokoju(Kolorystyka.JASNOZIELONY, Kierunek.POLUDNIE, Styl.MORSKI, false, 4, 100); 
		CechyPokoju cechy5 = new CechyPokoju(Kolorystyka.SELEDYNOWY, Kierunek.ZACHOD, Styl.SECESYJNY, true, 1, 5); 
		CechyPokoju cechy6 = new CechyPokoju(Kolorystyka.SZARY, Kierunek.ZACHOD, Styl.MORSKI, false, 2, 100);
		
		Pokoj pokoj = new Pokoj(cechy, 10);
		Pokoj pokoj2 = new Pokoj(cechy2, 12);
		Pokoj pokoj3 = new Pokoj(cechy3, 13);
		Pokoj pokoj4 = new Pokoj(cechy4, 14);
		Pokoj pokoj5 = new Pokoj(cechy5, 15);
		Pokoj pokoj6 = new Pokoj(cechy6, 16);
		
		Data data = new Data(10, 11, 1999);
		Data data2 = new Data(12, 11, 1999);
		Data data3 = new Data(15, 11, 1999);
		
		Ankieta ankieta = new Ankieta(cechy, 1, data);
		Ankieta ankieta2 = new Ankieta(cechy2, 3, data2);
		Ankieta ankieta3 = new Ankieta(cechy6, 1, data3);
		Ankieta ankieta4 = new Ankieta(cechy, 3, data);
		Ankieta ankieta5 = new Ankieta(cechy2, 4, data2);
		Ankieta ankieta6 = new Ankieta(cechy5, 3, data3);
		
		Pokoj pokoje[] = new Pokoj[6];
		pokoje[0] = pokoj;
		pokoje[1] = pokoj2;
		pokoje[2] = pokoj3;
		pokoje[3] = pokoj4;
		pokoje[4] = pokoj5;
		pokoje[5] = pokoj6;
		
		Recepcjonista[] recepcjonista =  new Recepcjonista[4];
		
		recepcjonista[0] = new Recepcjonista("rec1", "rec1", new LosowaStrategiaRecepcjonisty());
		recepcjonista[1] = new Recepcjonista("rec2", "rec2", new AproksymacyjnaStrategiaRecepcjonisty());
		recepcjonista[2] = new Recepcjonista("rec3", "rec3", new PerfekcjonistycznaStrategiaRecepcjonisty());
		recepcjonista[3] = new Recepcjonista("rec4", "rec4", new ZlosliwaStrategiaRecepcjonisty());
		
		
		Klient klient = new Klient("imie1", "nazwisko1",new StrategiaKlientaPerfekcjonistycznego());
		Klient klient2 = new Klient("imie2", "nazwisko2", new StrategiaKlientaBudzetowego());
		Klient klient3 = new Klient("imie3", "nazwisko3",new StrategiaKlientaPolowicznego());
		Klient klient4 = new Klient("imie4", "nazwisko4", new StrategiaKlientaUgodowego());
		
		Hotel hotel = new Hotel(pokoje, recepcjonista);
		Zamowienie zamowienie = hotel.przyjmijZamowienie(klient, ankieta);
		Zamowienie zamowienie2 = hotel.przyjmijZamowienie(klient2, ankieta2);
		Zamowienie zamowienie3 = hotel.przyjmijZamowienie(klient3, ankieta3);
		Zamowienie zamowienie4 = hotel.przyjmijZamowienie(klient4, ankieta4);
		
		Zamowienie[] zamowienia = new Zamowienie[4];
		zamowienia[0] = zamowienie;
		zamowienia[1] = zamowienie2;
		zamowienia[3] = zamowienie3;
		zamowienia[2] = zamowienie4;
		
		hotel.akceptuj(zamowienia, pokoje);
		
	}
}
