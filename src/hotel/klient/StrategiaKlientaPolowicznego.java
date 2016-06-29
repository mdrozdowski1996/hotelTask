package hotel.klient;
import hotel.cechy.CechyPokoju;
import hotel.hotel.Ankieta;
import hotel.hotel.Pokoj;
public class StrategiaKlientaPolowicznego extends StrategiaKlienta{
	
	public StrategiaKlientaPolowicznego(){
		super("połowiczna");
	}
	
	public boolean akceptujPokoj(Pokoj pokoj, Ankieta ankieta){
		return 2*ankieta.pokazCechy().iloscWspolnychCech(pokoj.pokazCechy()) >= CechyPokoju.iloscCech;
	}
}
