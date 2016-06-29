package hotel.hotel;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class KonkretnaData {
	private Calendar dataPoczatku;
	private Calendar dataKonca;
	
	public KonkretnaData (Data data, int dlugosc){
		this.dataPoczatku = new GregorianCalendar(data.zwrocRok(), data.zwrocMiesiac(), data.zwrocDzien());
		this.dataKonca = new GregorianCalendar(data.zwrocRok(), data.zwrocMiesiac(), data.zwrocDzien());
		dataKonca.add(Calendar.DAY_OF_YEAR, dlugosc);
	}
	
	public boolean jestWPrzedziale(Calendar data){
		return data.after(dataPoczatku) && data.before(dataKonca);
	}
	
	public boolean sieZazebia(KonkretnaData data){
		return jestWPrzedziale(data.dataPoczatku) || jestWPrzedziale(data.dataKonca) ||
				((data.dataPoczatku.before(dataPoczatku) || data.dataPoczatku.equals(dataPoczatku)) &&
				(data.dataKonca.equals(dataKonca) || data.dataKonca.after(dataKonca)));
	}
}
