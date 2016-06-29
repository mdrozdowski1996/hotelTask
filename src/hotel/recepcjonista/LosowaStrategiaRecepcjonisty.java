package hotel.recepcjonista;
import hotel.hotel.Ankieta;
import hotel.hotel.Pokoj;

import java.util.Random;

public class LosowaStrategiaRecepcjonisty extends StrategiaRecepcjonisty{
	Random r = new Random();
	public LosowaStrategiaRecepcjonisty(){
		super("losowa");
	}
	public int wybierzPokoj(Pokoj[] pokoje, Ankieta ankieta){
		if(pokoje.length >= 0) return r.nextInt(pokoje.length);
		else return -1;
	
	}
	public String toString(){
		return this.nazwa;
	}
}
