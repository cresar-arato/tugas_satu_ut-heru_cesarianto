package tugasSatu;

import java.util.Scanner;

class WarungJava {
	public static void tampilMenu(Menu[] daftarMenu) {
		System.out.println("========================================");
		System.out.println("          >>Menu Warung Java<<          ");
		System.out.println("========================================");
		
		System.out.println("");
		System.out.println("----Makanan----");
		if (daftarMenu[0].getKategori().equals("Makanan")) {
			System.out.println("1. " + daftarMenu[0].getNama() + " - Rp. " + (int)daftarMenu[0].getHarga());
		}
		if (daftarMenu[1].getKategori().equals("Makanan")) {
			System.out.println("2. " + daftarMenu[1].getNama() + " - Rp. " + (int)daftarMenu[1].getHarga());
		}
		if (daftarMenu[2].getKategori().equals("Makanan")) {
			System.out.println("3. " + daftarMenu[2].getNama() + " - Rp. " + (int)daftarMenu[2].getHarga());
		}
		if (daftarMenu[3].getKategori().equals("Makanan")) {
			System.out.println("4. " + daftarMenu[3].getNama() + " - Rp. " + (int)daftarMenu[3].getHarga());
		}
		System.out.println("");
		System.out.println("----Minuman----");
		if (daftarMenu[4].getKategori().equals("Minuman")) {
			System.out.println("1. " + daftarMenu[4].getNama() + " - Rp. " + (int)daftarMenu[4].getHarga());
		}
		if (daftarMenu[5].getKategori().equals("Minuman")) {
			System.out.println("2. " + daftarMenu[5].getNama() + " - Rp. " + (int)daftarMenu[5].getHarga());
		}
		if (daftarMenu[6].getKategori().equals("Minuman")) {
			System.out.println("3. " + daftarMenu[6].getNama() + " - Rp. " + (int)daftarMenu[6].getHarga());
		}
		if (daftarMenu[7].getKategori().equals("Minuman")) {
			System.out.println("4. " + daftarMenu[7].getNama() + " - Rp. " + (int)daftarMenu[7].getHarga());
		}
		System.out.println("");
		System.out.println("========================================");
		System.out.println("");
	}
		
		public static Menu cariMenu(String namaMenu, Menu[] daftarMenu) {
			namaMenu = namaMenu.toLowerCase().trim();
				if (daftarMenu[0].getNama().toLowerCase().startsWith(namaMenu) || 
			        daftarMenu[0].getNama().toLowerCase().contains(namaMenu)) return daftarMenu[0];

			    if (daftarMenu[1].getNama().toLowerCase().startsWith(namaMenu) || 
			        daftarMenu[1].getNama().toLowerCase().contains(namaMenu)) return daftarMenu[1];

			    if (daftarMenu[2].getNama().toLowerCase().startsWith(namaMenu) || 
			        daftarMenu[2].getNama().toLowerCase().contains(namaMenu)) return daftarMenu[2];

			    if (daftarMenu[3].getNama().toLowerCase().startsWith(namaMenu) || 
			        daftarMenu[3].getNama().toLowerCase().contains(namaMenu)) return daftarMenu[3];

			    if (daftarMenu[4].getNama().toLowerCase().startsWith(namaMenu) || 
			        daftarMenu[4].getNama().toLowerCase().contains(namaMenu)) return daftarMenu[4];

			    if (daftarMenu[5].getNama().toLowerCase().startsWith(namaMenu) || 
			        daftarMenu[5].getNama().toLowerCase().contains(namaMenu)) return daftarMenu[5];

			    if (daftarMenu[6].getNama().toLowerCase().startsWith(namaMenu) || 
			        daftarMenu[6].getNama().toLowerCase().contains(namaMenu)) return daftarMenu[6];

			    if (daftarMenu[7].getNama().toLowerCase().startsWith(namaMenu) || 
			        daftarMenu[7].getNama().toLowerCase().contains(namaMenu)) return daftarMenu[7];

			    return null;
			}
		
	public static void main(String[] args) {
		Menu[] daftarMenu = Menu.getDaftarMenu();
		
		tampilMenu(daftarMenu);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Masukkan Pesanan Anda (Maks 4 Menu)");
		System.out.println("Contohnya: Ayam = 2 atau teh=3");
		System.out.println("ingat, harus nama_makanan sama_dengan jumlah");
		System.out.println("Lalu Tekan Enter");
		System.out.println("");
		
		String[] inputMenu = new String[4];
		Menu[] pesanMenu = new Menu[4];
		int[] jmlhMenu = new int[4];
		
		System.out.print("Pesanan Pertama : ");
		inputMenu[0] = scanner.nextLine();
		System.out.print("Pesanan Kedua : ");
		inputMenu[1] = scanner.nextLine();
		
		System.out.print("Pesan Lagi? (Ya/Tidak)");
		String tanya = scanner.nextLine();
		
		if(tanya.equalsIgnoreCase("Ya")) {
			System.out.print("Pesanan Ketiga : ");
			inputMenu[2] = scanner.nextLine();
			System.out.print("Pesanan Terakhir : ");
			inputMenu[3] = scanner.nextLine();
		} else {
			inputMenu[2] = "";
			inputMenu[3] = "";
		}
		
		if (!inputMenu[0].isEmpty()) {
			String[] parts = inputMenu[0].split("=");
			String namaMenu = parts[0].trim();
			int jumlah = Integer.parseInt(parts[1].trim());
			pesanMenu[0] = cariMenu(namaMenu, daftarMenu);
			jmlhMenu[0] = jumlah;	
		}
		if (!inputMenu[1].isEmpty()) {
			String[] parts = inputMenu[1].split("=");
			String namaMenu = parts[0].trim();
			int jumlah = Integer.parseInt(parts[1].trim());
			pesanMenu[1] = cariMenu(namaMenu, daftarMenu);
			jmlhMenu[1] = jumlah;	
		}
		if (!inputMenu[2].isEmpty()) {
			String[] parts = inputMenu[2].split("=");
			String namaMenu = parts[0].trim();
			int jumlah = Integer.parseInt(parts[1].trim());
			pesanMenu[2] = cariMenu(namaMenu, daftarMenu);
			jmlhMenu[2] = jumlah;	
		}
		if (!inputMenu[3].isEmpty()) {
			String[] parts = inputMenu[3].split("=");
			String namaMenu = parts[0].trim();
			int jumlah = Integer.parseInt(parts[1].trim());
			pesanMenu[3] = cariMenu(namaMenu, daftarMenu);
			jmlhMenu[3] = jumlah;
		}
		hitungdancetak(pesanMenu, jmlhMenu);
		scanner.close();
	}

	public static void hitungdancetak(Menu[] pesanMenu, int[] jmlhMenu) {
		double totBiaya = 0;
		double totPesan1 = 0, totPesan2 = 0, totPesan3 = 0, totPesan4 = 0;
		double diskon = 0;
		double pelayanan = 20000;
		
		System.out.println("");
		System.out.println("========================================");
		System.out.println("             >>Warung Java<<            ");
		System.out.println("            >>Struk Pesanan<<           ");
		System.out.println("========================================");
		System.out.println("");
		
		if (pesanMenu[0] != null) {
			totPesan1 = pesanMenu[0].getHarga() * jmlhMenu[0];
			System.out.printf("%-15s %d x Rp. %-7d = Rp. %d\n",pesanMenu[0].getNama(),jmlhMenu[0],(int)pesanMenu[0].getHarga(), (int)totPesan1);
			totBiaya += totPesan1;
		}
		if (pesanMenu[1] != null) {
			totPesan2 = pesanMenu[1].getHarga() * jmlhMenu[1];
			System.out.printf("%-15s %d x Rp. %-7d = Rp. %d\n",pesanMenu[1].getNama(),jmlhMenu[1],(int)pesanMenu[1].getHarga(), (int)totPesan2);
			totBiaya += totPesan2;
		}
		if (pesanMenu[2] != null) {
			totPesan3 = pesanMenu[2].getHarga() * jmlhMenu[2];
			System.out.printf("%-15s %d x Rp. %-7d = Rp. %d\n",pesanMenu[2].getNama(),jmlhMenu[2],(int)pesanMenu[2].getHarga(), (int)totPesan3);
			totBiaya += totPesan3;
		}
		if (pesanMenu[3] != null) {
			totPesan4 = pesanMenu[3].getHarga() * jmlhMenu[3];
			System.out.printf("%-15s %d x Rp. %-7d = Rp. %d\n",pesanMenu[3].getNama(),jmlhMenu[3],(int)pesanMenu[3].getHarga(), (int)totPesan4);
			totBiaya += totPesan4;
		}
		System.out.println("----------------------------------------");
		System.out.printf("Total Harga : \t\t\t Rp. %d\n", (int)totBiaya);

		//pajak 10%
		double pajak = totBiaya * 0.1;
		System.out.printf("Pajak (10%%) : \t\t\t Rp. %d\n",(int)pajak);

		//jasa pelayanan
		System.out.printf("Biaya Pelayanan : \t\t Rp. %d\n",(int)pelayanan);
		
		double total = totBiaya + pajak + pelayanan;
		
		if (total > 100000) {
			diskon = total * 0.1;
			System.out.println("");
			System.out.println("Pengurang");
			System.out.printf("Diskon (10%%) : \t\t\t Rp. -%d\n",(int)diskon);
		}
		double totAkhir = total - diskon;
		System.out.println("----------------------------------------");
		System.out.printf("Total Bayar : \t\t\t Rp. %d\n",(int)totAkhir);
		System.out.println("");
		System.out.println("########################################");
		
		if(total > 50000) {
			System.out.println("------------Promo Spesial---------------");
			String gratisMinuman = "";
			if(pesanMenu[0] != null && pesanMenu[0].getKategori().equals("Minuman")) gratisMinuman = pesanMenu[0].getNama();
			else if(pesanMenu[1] != null && pesanMenu[1].getKategori().equals("Minuman")) gratisMinuman = pesanMenu[1].getNama();
			else if(pesanMenu[2] != null && pesanMenu[2].getKategori().equals("Minuman")) gratisMinuman = pesanMenu[2].getNama();
			else if(pesanMenu[3] != null && pesanMenu[3].getKategori().equals("Minuman")) gratisMinuman = pesanMenu[3].getNama();
			
			if(!gratisMinuman.isEmpty()) {
				System.out.println("Selamat, Anda Dapat Promo Beli 1 dapat 1 untuk " + gratisMinuman);
			} else {
				System.out.println("Selamat, Anda Dapat Promo Beli 1 dapat 1 di Pembelian Berikutnya");
			}
		}
		System.out.println("");
		System.out.println("Terimah Kasih Sudah Datang ke Warung Java");
		System.out.println("Sampai Jumpa dan Hati-Hati di Jalan :)");
	}
}