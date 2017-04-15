/**
 * Kelas ini merepresentasikan objek peta/wilayah yang dikunjungi oleh Tyber
 * 
 * @author Galuh Buana Putra Kautsar - 1406543580
 * @version 2015.03.20
 *
 */
public class Peta
{
	private char[][] petaks;
	private int baris;
	private int kolom;
	
	/**
	 * Constructor dari kelas Peta
	 * @param baris jumlah baris dari peta
	 * @param kolom jumlah kolom dari peta
	 */
	public Peta(int baris, int kolom)
	{
		this.petaks = new char[baris+2][kolom+2];
		
		for (int i = 0; i < baris+2; i++) {
			for (int j = 0; j < kolom+2; j++) {
				petaks[i][j] = '#';
			}
		}
		
		this.baris = baris;
		this.kolom = kolom;
	}

	/**
	 * Method untuk mendapatkan peta
	 * @return peta
	 */
	public char[][] getPetaks() {
		return petaks;
	}
}