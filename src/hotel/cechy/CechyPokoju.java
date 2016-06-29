package hotel.cechy;


public class CechyPokoju {
	public static final int iloscCech = 6; 
	
	private Kolorystyka kolor;
	private Kierunek kierunek;
	private Styl styl;
	private boolean dostepDoInternetu;
	private int iloscOsob;
	private int cena;
	
	public Kolorystyka zwrocKolor(){
		return this.kolor;
	}
	public Kierunek zwrocKierunek(){
		return this.kierunek;
	}
	public Styl zwrocStyl(){
		return this.styl;
	}
	public int zwrocCene(){
		return this.cena;
	}
	public int zwrocIloscOsob(){
		return this.iloscOsob;
	}
	public boolean zwrocDostepDoInternetu(){
		return this.dostepDoInternetu;
	}
	
	public CechyPokoju(Kolorystyka kolor, Kierunek kierunek, Styl styl, boolean dostepDoInternetu, int iloscOsob, int cena){
		this.kolor = kolor;
		this.kierunek = kierunek;
		this.styl = styl;
		this.dostepDoInternetu = dostepDoInternetu;
		this.cena = cena;
		this.iloscOsob = iloscOsob;
	}
	
	public int iloscWspolnychCech(CechyPokoju cechy){
		int ilosc = 0;
		if(this.dostepDoInternetu == cechy.dostepDoInternetu)ilosc++;
		if(this.kolor.equals(cechy.zwrocKolor()))ilosc++;
		if(this.cena <= cechy.zwrocCene())ilosc++;
		if(this.iloscOsob >= cechy.zwrocIloscOsob())ilosc++;
		if(this.styl.equals(cechy.zwrocStyl()))ilosc++;
		if(this.kierunek.equals(this.zwrocKierunek()))ilosc++;
		return ilosc;
	}
	
	public String toString(){
		String wynik;
		if(dostepDoInternetu) wynik = "tak";
		else wynik = "nie";
		wynik = iloscOsob + ", " + cena + ", " + styl.toString() + ", " + kolor.toString() + ", " + kierunek.toString() + ", " + wynik;
		return wynik;
	}
}
