import java.util.PriorityQueue;

/**
 * Kelas ini merepresentasikan objek dari pemain utama yaitu Tyber.
 * 
 * @author Galuh Buana Putra Kautsar - 1406543580
 * @version 2015.03.20
 *
 */
public class Tyber
{
	private int baris;
	private int kolom;
	private int posisiAwalBaris;
	private int posisiAwalKolom;
	private PriorityQueue<Item> items;
	private int kapasitas;
	
	/**
	 * Constructor dari kelas Tyber
	 */
	public Tyber()
	{
		this.items = new PriorityQueue<>();
	}

	/**
	 * Method untuk mengeset baris tempat posisi Tyber saat ini
	 * @param baris posisi baris Tyber
	 */
	public void setBaris(int baris)
	{
		this.baris = baris;
	}
	
	/**
	 * Method untuk mendapatkan baris tempat posisi Tyber saat ini
	 * @return posisi baris Tyber
	 */
	public int getBaris()
	{
		return baris;
	}

	/**
	 * Method untuk mengeset kolom tempat posisi Tyber saat ini
	 * @param kolom posisi kolom Tyber
	 */
	public void setKolom(int kolom)
	{
		this.kolom = kolom;
	}
	
	/**
	 * Method untuk mendapatkan kolom tempat posisi Tyber saat ini
	 * @return posisi kolom Tyber
	 */
	public int getKolom()
	{
		return kolom;
	}

	/**
	 * Method untuk mengeset posisi baris awal Tyber saat permainan dimulai
	 * @param posisiAwalBaris posisi baris awal Tyber
	 */
	public void setPosisiAwalBaris(int posisiAwalBaris)
	{
		this.posisiAwalBaris = posisiAwalBaris;
	}
	
	/**
	 * Method untuk mengeset posisi kolom awal Tyber saat permainan dimulai
	 * @param posisiAwalKolom posisi kolom awal Tyber
	 */
	public void setPosisiAwalKolom(int posisiAwalKolom)
	{
		this.posisiAwalKolom = posisiAwalKolom;
	}
	
	/**
	 * Method untuk mendapatkan kumpulan item yang dibawa oleh Tyber
	 * @return kumpulan item yang dibawa oleh Tyber
	 */
	public PriorityQueue<Item> getItems()
	{
		return items;
	}

	/**
	 * Method untuk mengeset jumlah kapasitas item yang dibawa oleh Tyber
	 * @param kapasitas jumlah kapasitas item yang dibawa oleh Tyber
	 */
	public void setKapasitas(int kapasitas)
	{
		this.kapasitas = kapasitas;
	}
	
	/**
	 * Method untuk mendapatkan jumlah kapasitas item yang dibawa oleh Tyber
	 * @return jumlah kapasitas item yang dibawa oleh Tyber
	 */
	public int getKapasitas()
	{
		return kapasitas;
	}
}