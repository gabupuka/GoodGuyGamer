import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * Kelas ini merupakan kelas utama dari program Good Guy Gamer.
 * 
 * @author Galuh Buana Putra Kautsar - 1406543580
 * @version 2015.03.20
 *
 */
public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = in.readLine();
		StringTokenizer token = new StringTokenizer(input);
		
		// Mendapatkan jumlah baris dan kolom serta memasukkannya ke dalam objek peta
		int barisPeta = Integer.parseInt(token.nextToken());
		int kolomPeta = Integer.parseInt(token.nextToken());
		Peta peta = new Peta(barisPeta, kolomPeta);
		
		// Membuat objek Tyber dan mengeset kapasitas item yang dapat dibawa
		Tyber tyber = new Tyber();
		int kapasitasTyber = Integer.parseInt(token.nextToken());
		tyber.setKapasitas(kapasitasTyber);
		
		// Mendapatkan jumlah teman yang terdapat di peta dan membuat kumpulan teman Tyber
		int jumlahTeman = Integer.parseInt(token.nextToken());
		TreeMap<String, Friend> friends = new TreeMap<>();
		ArrayList<Friend> arrFriends = new ArrayList<>();
		
		// Mendapatkan jumlah item yang terdapat di peta dan membuat kumpulan item pada peta
		int jumlahItem = Integer.parseInt(token.nextToken());
		ArrayList<Item> items = new ArrayList<>();
		
		// Memasukkan setiap titik pada peta ke dalam objek peta yang ada
		for (int i = 1; i <= barisPeta; i++) {
			String masukanPeta = in.readLine();
			
			for (int j = 1; j <= kolomPeta; j++) {
				peta.getPetaks()[i][j] = masukanPeta.charAt(j-1);
		
				if (peta.getPetaks()[i][j] == 'S') {
					tyber.setPosisiAwalBaris(i);
					tyber.setPosisiAwalKolom(j);
					tyber.setBaris(i);
					tyber.setKolom(j);
				}
			}
		}
		
		// Memasukkan setiap teman yang ada pada peta ke dalam kumpulan teman Tyber
		String barisTeman = "";
		String kolomTeman = "";
		String namaTeman = "";
		Friend teman = null;
		for (int i = 1; i <= jumlahTeman; i++) {
			String masukanTeman = in.readLine();
			StringTokenizer token2 = new StringTokenizer(masukanTeman);
			barisTeman = (Integer.parseInt(token2.nextToken()) + 1) + "";
			kolomTeman = (Integer.parseInt(token2.nextToken()) + 1) + "";
			namaTeman = token2.nextToken();
			teman = new Friend(barisTeman + " " + kolomTeman, namaTeman);
			
			friends.put(barisTeman + " " + kolomTeman, teman);
			arrFriends.add(teman);
		}
		
		Collections.sort(arrFriends);
		
		// Memasukkan setiap item yang ada pada peta ke dalam kumpulan item pada peta
		for (int i = 1; i <= jumlahItem; i++) {
			String masukanItem = in.readLine();
			StringTokenizer token3 = new StringTokenizer(masukanItem);
			items.add(new Item(Integer.parseInt(token3.nextToken()) + 1, Integer.parseInt(token3.nextToken()) + 1,
								token3.nextToken(), Integer.parseInt(token3.nextToken()), token3.nextToken(),
								token3.nextToken()));
		}
		
		// Memulai program
		playAwal(tyber, peta, items, friends);
		
		// Mencetak informasi dari setiap teman Tyber apakah mendapatkan item atau tidak
		for (int i = 0; i < arrFriends.size(); i++) {
			if (arrFriends.get(i).getItems().size() == 0) {
				System.out.println(arrFriends.get(i).getNama() + " tidak mendapatkan item");
			}
			else {
				System.out.println(arrFriends.get(i).getNama() + " mendapatkan " +
									arrFriends.get(i).getItems().size() + " item");
				
				for (int j = 0; j < arrFriends.get(i).getItems().size(); j++) {
					System.out.println(arrFriends.get(i).getItems().get(j));
				}
			}
		}
		
		// Mencetak informasi dari Tyber apakah ada item yang tersisa atau tidak
		if (tyber.getItems().size() == 0) {
			System.out.println("Tidak ada item tersisa");
		}
		else {
			int jumlahItemTyber = tyber.getItems().size();
			System.out.println("Tersisa " + jumlahItemTyber + " item");
			
			while (! tyber.getItems().isEmpty()) {
				System.out.println((Item) tyber.getItems().poll());
			}
		}
	}
	
	/**
	 * Driver recursive method untuk memulai program
	 * @param tyber pemain utama yaitu Tyber
	 * @param peta peta yang ditelusuri oleh Tyber
	 * @param items kumpulan item pada peta
	 * @param friends kumpulan teman Tyber
	 */
	public static void playAwal(Tyber tyber, Peta peta, ArrayList<Item> items, Map<String, Friend> friends)
	{
		char posisiSekarang = peta.getPetaks()[tyber.getBaris()][tyber.getKolom()];
		play(tyber, peta, posisiSekarang, items, friends);
	}
	
	/**
	 * Helper recursive method untuk memulai program
	 * @param tyber pemain utama yaitu Tyber
	 * @param peta peta yang ditelusuri oleh Tyber
	 * @param posisiSekarang posisi saat ini Tyber berada
	 * @param items kumpulan item pada peta
	 * @param friends kumpulan teman Tyber
	 */
	private static void play(Tyber tyber, Peta peta, char posisiSekarang, ArrayList<Item> items, Map<String, Friend> friends)
	{	
		char titikSekarang = peta.getPetaks()[tyber.getBaris()][tyber.getKolom()];
		char posisiAtas = peta.getPetaks()[tyber.getBaris() - 1][tyber.getKolom()];
		char posisiKanan = peta.getPetaks()[tyber.getBaris()][tyber.getKolom() + 1];
		char posisiBawah = peta.getPetaks()[tyber.getBaris() + 1][tyber.getKolom()];
		char posisiKiri = peta.getPetaks()[tyber.getBaris()][tyber.getKolom() - 1];
		
		// Memeriksa apakah ada item atau teman di posisi saat ini
		periksaItem(tyber, peta, items, titikSekarang);
		periksaTeman(tyber, peta, friends, titikSekarang);

		// Menandakan posisi saat ini sudah pernah dikunjungi
		peta.getPetaks()[tyber.getBaris()][tyber.getKolom()] = 'x';
		
		// Memeriksa apakah posisi saat ini buntu atau tidak
		if (isBuntu(tyber, posisiAtas, posisiKanan, posisiBawah, posisiKiri)) {
			return;
		}
		
		// Memeriksa apakah bisa berjalan ke arah atas dari posisi saat ini
		posisiAtas = peta.getPetaks()[tyber.getBaris() - 1][tyber.getKolom()];
		if (posisiAtas != '#' && posisiAtas != 'x') {
			tyber.setBaris(tyber.getBaris() - 1);
			play(tyber, peta, posisiSekarang, items, friends);
			
			tyber.setBaris(tyber.getBaris() + 1);
			kembali(peta, tyber, titikSekarang, friends);
		}
		
		// Memeriksa apakah bisa berjalan ke arah kanan dari posisi saat ini
		posisiKanan = peta.getPetaks()[tyber.getBaris()][tyber.getKolom() + 1];
		if (posisiKanan != '#' && posisiKanan != 'x') {
			tyber.setKolom(tyber.getKolom() + 1);
			play(tyber, peta, posisiSekarang, items, friends);
			
			tyber.setKolom(tyber.getKolom() - 1);
			kembali(peta, tyber, titikSekarang, friends);
		}
		
		// Memeriksa apakah bisa berjalan ke arah bawah dari posisi saat ini
		posisiBawah = peta.getPetaks()[tyber.getBaris() + 1][tyber.getKolom()];
		if (posisiBawah != '#' && posisiBawah != 'x') {
			tyber.setBaris(tyber.getBaris() + 1);
			play(tyber, peta, posisiSekarang, items, friends);
			
			tyber.setBaris(tyber.getBaris() - 1);
			kembali(peta, tyber, titikSekarang, friends);
		}
		
		// Memeriksa apakah bisa berjalan ke arah kiri dari posisi saat ini
		posisiKiri = peta.getPetaks()[tyber.getBaris()][tyber.getKolom() - 1];
		if (posisiKiri != '#' && posisiKiri != 'x') {
			tyber.setKolom(tyber.getKolom() - 1);
			play(tyber, peta, posisiSekarang, items, friends);
			
			tyber.setKolom(tyber.getKolom() + 1);
			kembali(peta, tyber, titikSekarang, friends);
		}
	}
	
	/**
	 * Method untuk mengecek apakah jalan yang dilalui Tyber buntu atau tidak
	 * @param tyber pemain utama yaitu Tyber
	 * @param atas posisi di atas posisi saat ini
	 * @param kanan posisi di kanan posisi saat ini
	 * @param bawah posisi di kiri posisi saat ini
	 * @param kiri posisi di bawah posisi saat ini
	 * @return posisi saat ini buntu atau tidak
	 */
	public static boolean isBuntu(Tyber tyber, char atas, char kanan, char bawah, char kiri)
	{
		if ((atas == '#' || atas == 'x') && (kanan == '#' || kanan == 'x') &&
			(bawah == '#' || bawah == 'x') && (kiri == '#' || kiri == 'x')) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Method untuk kembali saat jalan sudah buntu
	 * @param peta peta yang ditelusuri oleh Tyber
	 * @param tyber pemain utama yaitu Tyber
	 * @param titikSekarang posisi saat ini Tyber berada
	 * @param friends kumpulan teman Tyber
	 */
	public static void kembali(Peta peta, Tyber tyber, char titikSekarang, Map<String, Friend> friends)
	{
		if (peta.getPetaks()[tyber.getBaris()][tyber.getKolom()] == 'x') {
			peta.getPetaks()[tyber.getBaris()][tyber.getKolom()] = titikSekarang;
		}
		
		periksaTeman(tyber, peta, friends, titikSekarang);
		peta.getPetaks()[tyber.getBaris()][tyber.getKolom()] = 'x';
	}	
	
	/**
	 * Method untuk memeriksa apakah ada item di sebuah titik
	 * @param tyber pemain utama yaitu Tyber
	 * @param peta peta yang ditelusuri oleh Tyber
	 * @param items kumpulan item pada peta
	 * @param titikSekarang posisi saat ini Tyber berada
	 */
	public static void periksaItem(Tyber tyber, Peta peta, ArrayList<Item> items, char titikSekarang)
	{		
		if (titikSekarang == 'I') {
			for (int i = 0; i < items.size(); i++) {
				if (items.get(i).getPosisiBaris() == tyber.getBaris() &&
					items.get(i).getPosisiKolom() == tyber.getKolom()) {
					tyber.getItems().add(items.get(i));
					
					if (tyber.getItems().size() > tyber.getKapasitas()) {
						tyber.getItems().poll();
					}
				}
			}
		}
	}
	
	/**
	 * Method untuk memeriksa apakah ada teman di sebuah titik
	 * @param tyber pemain utama yaitu Tyber
	 * @param peta peta yang ditelusuri oleh Tyber
	 * @param friends kumpulan teman Tyber
	 * @param titikSekarang posisi saat ini Tyber berada
	 */
	public static void periksaTeman(Tyber tyber, Peta peta, Map<String, Friend> friends, char titikSekarang)
	{	
		if (titikSekarang == 'A') {
			if (! tyber.getItems().isEmpty()) {
				Item t = (Item) tyber.getItems().poll();
				friends.get(tyber.getBaris()+ " " +tyber.getKolom()).getItems().add(t);
			}
		}
	}
}
