package tugasSatu;

class Menu {
	String namaitem;
	double harga;
	String kategori;

	public Menu(String namaitem, double harga, String kategori) {
		this.namaitem = namaitem;
		this.harga = harga;
		this.kategori = kategori;
	}
	public String getNama() {
		return namaitem;
	}
	
	public double getHarga() {
		return harga;
	}
	
	public String getKategori() {
		return kategori;
	}

	public static Menu[] getDaftarMenu() {
		Menu[] daftarMenu = new Menu[8];
		daftarMenu[0] = new Menu("Nasi Campur", 15000, "Makanan");
		daftarMenu[1] = new Menu("Nasi Kuning", 17000, "Makanan");
		daftarMenu[2] = new Menu("Lalapan", 18000, "Makanan");
		daftarMenu[3] = new Menu("Soto", 25000, "Makanan");
		daftarMenu[4] = new Menu("Teh", 3000, "Minuman");
		daftarMenu[5] = new Menu("Susu", 5000, "Minuman");
		daftarMenu[6] = new Menu("Kopi", 2000, "Minuman");
		daftarMenu[7] = new Menu("Air", 1000, "Minuman");
		return daftarMenu;
	}
}