package hotel.hotel;

public class Data {
	private int dzien;
	private int miesiac;
	private int rok;
	
	public Data(int dzien, int miesiac, int rok){
		this.dzien = dzien;
		this.miesiac = miesiac;
		this.rok = rok;
	}
	
	public int zwrocDzien(){
		return this.dzien;
	}
	public int zwrocMiesiac(){
		return this.miesiac;
	}
	public int zwrocRok(){
		return this.rok;
	}
	public String toString(){
		return "" + dzien + " - " + miesiac + " - " + rok;
	}

}
