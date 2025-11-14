package tugasDua;

import java.util.ArrayList;
import java.util.List;

class Menu {
	String nama;
	int harga;
	String kategori;

	// daftarMenu menjadi statis List agar bisa diakses dan diubah >> WarungJava
    private static List<Menu> daftarMenu = new ArrayList<>(); 
    
    // Blok statis untuk inisialisasi menu awal (Hanya dijalankan sekali)
    static {
        daftarMenu.add(new Menu("Nasi Campur", 15000, "Makanan"));
        daftarMenu.add(new Menu("Nasi Kuning", 17000, "Makanan"));
        daftarMenu.add(new Menu("Lalapan", 18000, "Makanan"));
        daftarMenu.add(new Menu("Soto", 25000, "Makanan"));
        daftarMenu.add(new Menu("Teh", 3000, "Minuman"));
        daftarMenu.add(new Menu("Susu", 5000, "Minuman"));
        daftarMenu.add(new Menu("Kopi", 2000, "Minuman"));
        daftarMenu.add(new Menu("Air", 1000, "Minuman"));
    }

    public Menu(String nama, int harga, String kategori) {
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
    }

    // Setter untuk memungkinkan perubahan harga
    public void setHarga(int harga) {
        this.harga = harga;
    }

    // Metode untuk mengembalikan daftar menu (sudah diubah menjadi List)
    public static List<Menu> getDaftarMenu() {
        return daftarMenu;
    }

    // Getter tetap sama
    public String getNama() { return this.nama; }
    public int getHarga() { return this.harga; }
    public String getKategori() { return this.kategori; }
}