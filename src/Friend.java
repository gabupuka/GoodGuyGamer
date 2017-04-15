import java.util.ArrayList;

/**
 * Kelas ini merepresentasikan objek dari teman Tyber.
 * 
 * @author Galuh Buana Putra Kautsar - 1406543580
 * @version 2015.03.20
 * 
 */
public class Friend implements Comparable<Friend>
{
	private String posisi;
	private String nama;
	private ArrayList<Item> items;
	
	/**
	 * Constructor dari kelas Friend
	 * @param posisi posisi dari seorang teman Tyber
	 * @param nama nama dari seorang teman Tyber
	 */
	public Friend(String posisi, String nama)
	{
		this.nama = nama;
		this.posisi = posisi;
		this.items = new ArrayList<>();
	}
	
	/**
	 * Method untuk mendapatkan nama dari seorang teman Tyber
	 * @return nama dari seorang teman Tyber
	 */
	public String getNama()
	{
		return nama;
	}
	
	/**
	 * Method untuk mendapatkan kumpulan item yang didapatkan oleh seorang teman Tyber
	 * @return kumpulan item yang didapatkan oleh seorang teman Tyber
	 */
	public ArrayList<Item> getItems()
	{
		return items;
	}

	/**
	 * Method untuk mengurutkan kumpulan teman-teman Tyber berdasarkan abjad namanya
	 * secara ascending
	 */
	public int compareTo(Friend friend)
	{
		return this.nama.compareTo(friend.getNama());
	}
}