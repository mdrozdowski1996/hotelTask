package hotel.recepcjonista;

import hotel.cechy.CechyPokoju;
import hotel.hotel.Ankieta;
import hotel.hotel.Pokoj;


public class PerfekcjonistycznaStrategiaRecepcjonisty extends StrategiaRecepcjonisty{
	public PerfekcjonistycznaStrategiaRecepcjonisty(){
		super("perfekcjonistyczna");
	}
	public int wybierzPokoj(Pokoj[] pokoje, Ankieta ankieta){
		int miejsce = -1, minNumer = 1000000;
		for(int i = 0; i < pokoje.length; i++){
			if(ankieta.pokazCechy().iloscWspolnychCech(pokoje[i].pokazCechy()) == CechyPokoju.iloscCech){
				if(pokoje[i].pokazNumer() < minNumer){
					miejsce = i;
					minNumer = pokoje[i].pokazNumer();
				}
			}
		}
		return miejsce;
	}
	public String toString(){
		return this.nazwa;
	}
}
