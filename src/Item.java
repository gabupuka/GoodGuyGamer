/**
 * Kelas ini merepresentasikan objek item yang dimiliki oleh Tyber dan temannya.
 * 
 * @author Galuh Buana Putra Kautsar - 1406543580
 * @version 2015.03.20
 *
 */
public class Item implements Comparable<Item>
{
	private int posisiBaris;
	private int posisiKolom;
	private String nama;
	private int harga;
	private String tipe;
	private int kodeTipe;
	private String kodeUpgrade;
	private boolean isUpgradable;
	
	/**
	 * Constructor dari kelas Item
	 * @param posisiBaris posisi baris dari sebuah item
	 * @param posisiKolom posisi kolom dari sebuah item
	 * @param nama nama dari sebuah item
	 * @param harga harga dari sebuah item
	 * @param tipe tipe dari sebuah item
	 * @param kodeUpgrade kode yang menunjukkan apakah sebuah item dapat di-upgrade atau tidak
	 */
	public Item(int posisiBaris, int posisiKolom, String nama, int harga, String tipe, String kodeUpgrade)
	{
		this.posisiBaris = posisiBaris;
		this.posisiKolom = posisiKolom;
		this.nama = nama;
		this.harga = harga;
		
		this.tipe = tipe;
		if (tipe.equals("Normal")) {
			kodeTipe = 0;
		}
		else if (tipe.equals("Rare")) {
			kodeTipe = 1;
		}
		else {
			kodeTipe = 2;
		}
		
		this.kodeUpgrade = kodeUpgrade;
		if (kodeUpgrade.equals("T")) {
			
			this.isUpgradable = true;
		}
	}

	/**
	 * Method untuk mendapatkan posisi baris dari sebuah item
	 * @return posisi baris dari sebuah item
	 */
	public int getPosisiBaris()
	{
		return posisiBaris;
	}
	
	/**
	 * Method untuk mendapatkan posisi kolom dari sebuah item
	 * @return posisi kolom dari sebuah item
	 */
	public int getPosisiKolom()
	{
		return posisiKolom;
	}

	/**
	 * Method untuk mendapatkan nama dari sebuah item
	 * @return nama dari sebuah item
	 */
	public String getNama()
	{
		return nama;
	}

	/**
	 * Method untuk mendapatkan harga dari sebuah item
	 * @return harga dari sebuah item
	 */
	public int getHarga()
	{
		return harga;
	}

	/**
	 * Method untuk mendapatkan tipe dari sebuah item
	 * @return tipe dari sebuah item
	 */
	public String getTipe()
	{
		return tipe;
	}

	/**
	 * Method untuk mendapatkan kode untuk suatu tipe dari sebuah item
	 * @return kode untuk suatu tipe dari sebuah item
	 */
	public int getKodeTipe()
	{
		return kodeTipe;
	}

	/**
	 * Method untuk mendapatkan status upgradable dari sebuah item
	 * @return status upgradable dari sebuah item
	 */
	public boolean isUpgradable()
	{
		return isUpgradable;
	}

	/**
	 * Method untuk mendapatkan kode untuk suatu status upgradable dari sebuah item
	 * @return kode untuk suatu status upgradable dari sebuah item
	 */
	public String getKodeUpgrade()
	{
		return kodeUpgrade;
	}

	/**
	 * Method untuk mengurutkan kumpulan item yang akan dibuang/diberikan ke teman oleh Tyber berdasarkan
	 * harga, tipe, status upgradable, atau namanya
	 */
	public int compareTo(Item item)
	{
		if (this.harga == item.getHarga()) {
			if (this.tipe.equals(item.getTipe())) {
				if (this.isUpgradable == item.isUpgradable) {
					return item.getNama().compareTo(this.nama);
				}
				return this.kodeUpgrade.compareTo(item.getKodeUpgrade());
			}
			return this.kodeTipe - item.getKodeTipe();
		}
		return this.harga - item.getHarga();
	}
	
	/**
	 * Method untuk mencetak informasi yang diinginkan dari objek item
	 */
	public String toString()
	{
		return "+ " + nama + " " + harga + " " + tipe + " " + kodeUpgrade;
	}
}