package hotel.recepcjonista;

import hotel.hotel.Ankieta;
import hotel.hotel.Pokoj;


public class ZlosliwaStrategiaRecepcjonisty extends StrategiaRecepcjonisty{
	public ZlosliwaStrategiaRecepcjonisty(){
		super("złosliwa");
	}
	
	public int wybierzPokoj(Pokoj[] pokoje, Ankieta ankieta){
		int maksNumer = 0, miejsce = -1, najwyzszaCena = 0, iloscSpelnionych = 7;
		for(int i = 0; i < pokoje.length; i++){
			if( iloscSpelnionych == ankieta.pokazCechy().iloscWspolnychCech(pokoje[i].pokazCechy())){
				if(pokoje[i].pokazCechy().zwrocCene() > najwyzszaCena){
					miejsce = i;
					najwyzszaCena = pokoje[i].pokazCechy().zwrocCene();
					maksNumer = pokoje[i].pokazNumer();
				}
				else if(pokoje[i].pokazCechy().zwrocCene() == najwyzszaCena && maksNumer < pokoje[i].pokazNumer()){
					miejsce = i;
					najwyzszaCena = pokoje[i].pokazCechy().zwrocCene();
					maksNumer = pokoje[i].pokazNumer();
				}
			}
			if( iloscSpelnionych > ankieta.pokazCechy().iloscWspolnychCech(pokoje[i].pokazCechy())){
				miejsce = i;
				najwyzszaCena = pokoje[i].pokazCechy().zwrocCene();
				maksNumer = pokoje[i].pokazNumer();
				iloscSpelnionych = ankieta.pokazCechy().iloscWspolnychCech(pokoje[i].pokazCechy());
			}
		}
		return miejsce;
	}
	public String toString(){
		return this.nazwa; 
	}
	
}
