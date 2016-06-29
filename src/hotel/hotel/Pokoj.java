package hotel.hotel;

import hotel.cechy.CechyPokoju;

import java.util.LinkedList;
import java.util.ListIterator;

public class Pokoj {
	
	private int numer;
	private CechyPokoju cechy;
	private LinkedList<Data> poczatek = new LinkedList<Data>();
	private LinkedList<Integer> dlugosc = new LinkedList<Integer>();
	
	public Pokoj(CechyPokoju cechy, int numer){
		this.cechy = cechy;
		this.numer = numer;
	}
	public int pokazNumer(){
		return this.numer;
	}
	public CechyPokoju pokazCechy(){
		return this.cechy;
	}
	
	public boolean czyWolny(KonkretnaData data){
		boolean bufor = true;
		ListIterator<Data> itPoczatku = this.poczatek.listIterator();
		ListIterator<Integer> itDlugosci = this.dlugosc.listIterator();
		while (itPoczatku.hasNext() && itDlugosci.hasNext()){
			Data p = (Data) itPoczatku.next();
			int d = (int) itDlugosci.next();
			bufor = bufor && !data.sieZazebia(new KonkretnaData(p, d));
		}
		return bufor;
	}
	
	public void dodajRezerwacje(Ankieta ankieta){
		poczatek.addLast(ankieta.poczatek());
		dlugosc.addLast(ankieta.dlugoscPobytu());
	}
	public String toString(){
		return "Proponowany pokój: " + numer + ", " + cechy.toString() + "."; 
	}
}
