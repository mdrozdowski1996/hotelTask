package hotel.recepcjonista;

import hotel.hotel.Ankieta;
import hotel.hotel.Pokoj;


public class AproksymacyjnaStrategiaRecepcjonisty extends StrategiaRecepcjonisty{
	public AproksymacyjnaStrategiaRecepcjonisty(){
		super("aproksymacyjna");
	}
	public int wybierzPokoj(Pokoj[] pokoje, Ankieta ankieta){
		int iloscWspolnychCech, maksymalnaIloscWspolnychCech = 0, maksCena = 0, najnizszyNumer = 1000000, indeks = -1;
		for(int i = 0; i < pokoje.length; i++){
			iloscWspolnychCech = ankieta.pokazCechy().iloscWspolnychCech(pokoje[i].pokazCechy());
			if(iloscWspolnychCech > maksymalnaIloscWspolnychCech ){
				maksymalnaIloscWspolnychCech = iloscWspolnychCech;
				maksCena = pokoje[i].pokazCechy().zwrocCene();
				najnizszyNumer = pokoje[i].pokazNumer();
				indeks = i;
			}
			else if(iloscWspolnychCech == maksymalnaIloscWspolnychCech){
				if(pokoje[i].pokazCechy().zwrocCene() > maksCena ){
					maksymalnaIloscWspolnychCech = iloscWspolnychCech;
					maksCena = pokoje[i].pokazCechy().zwrocCene();
					najnizszyNumer = pokoje[i].pokazNumer();
					indeks = i;
				}
				else if(pokoje[i].pokazCechy().zwrocCene() == maksCena && pokoje[i].pokazNumer() < najnizszyNumer){
					maksymalnaIloscWspolnychCech = iloscWspolnychCech;
					maksCena = pokoje[i].pokazCechy().zwrocCene();
					najnizszyNumer = pokoje[i].pokazNumer();
					indeks = i;
				}
			}
		}
		return indeks;
	}
	public String toString(){
		return this.nazwa;
	}
	
}

