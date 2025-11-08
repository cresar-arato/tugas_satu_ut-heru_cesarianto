package tugasDua;

import java.util.ArrayList;
import java.util.List;

class Menu {
	String namaitem;
	double harga;
	String kategori;

	// daftarMenu menjadi statis List agar bisa diakses dan diubah >> WarungJava
    private static List<Menu> daftarMenu = new ArrayList<>(); 
    
    // Blok statis untuk inisialisasi menu awal (Hanya dijalankan sekali)
    static {
        daftarMenu.add(new Menu("Nasi Campur", 15000.0, "Makanan"));
        daftarMenu.add(new Menu("Nasi Kuning", 17000.0, "Makanan"));
        daftarMenu.add(new Menu("Lalapan", 18000.0, "Makanan"));
        daftarMenu.add(new Menu("Soto", 25000.0, "Makanan"));
        daftarMenu.add(new Menu("Teh", 3000.0, "Minuman"));
        daftarMenu.add(new Menu("Susu", 5000.0, "Minuman"));
        daftarMenu.add(new Menu("Kopi", 2000.0, "Minuman"));
        daftarMenu.add(new Menu("Air", 1000.0, "Minuman"));
    }

    public Menu(String namaitem, double harga, String kategori) {
        this.namaitem = namaitem;
        this.harga = harga;
        this.kategori = kategori;
    }

    // Setter untuk memungkinkan perubahan harga
    public void setHarga(double harga) {
        this.harga = harga;
    }

    // Metode untuk mengembalikan daftar menu (sudah diubah menjadi List)
    public static List<Menu> getDaftarMenu() {
        return daftarMenu;
    }

    // Getter tetap sama
    public String getNama() { return this.namaitem; }
    public double getHarga() { return this.harga; }
    public String getKategori() { return this.kategori; }
}