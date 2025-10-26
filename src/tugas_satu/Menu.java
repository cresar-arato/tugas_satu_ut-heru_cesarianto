package tugas_satu;

class Menu {
	String namaitem;
	double harga;
	String kategori;

	public  Menu(String namaitem, double harga, String kategori) {
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
}