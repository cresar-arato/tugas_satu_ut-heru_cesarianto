package tugasDua;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class WarungJava {
	// --- METODE UTAMA PROGRAM ---
	public static void main(String[] args) {
        mainMenu();
    }
	private static final Scanner scanner = new Scanner(System.in);

    // --- MENU UTAMA ---
    public static void mainMenu() {
        while (true) {
            System.out.println("\n===== MENU UTAMA WARUNG JAVA =====");
            System.out.println("1. Pemesanan Pelanggan");
            System.out.println("2. Pengelolaan Menu (Admin)");
            System.out.println("3. Keluar Program");
            System.out.print("Pilih opsi (1-3): ");

            String pilihan = scanner.nextLine().trim();

            switch (pilihan) {
                case "1":
                    menuPemesanan();
                    break;
                case "2":
                    menuPengelolaan();
                    break;
                case "3":
                    System.out.println("");
                    System.out.println("Terima kasih dan Sampai jumpa!");
                    return;
                default:
                    System.err.println("❌ Pilihan tidak valid. Silakan masukkan 1, 2, atau 3.");
            }
        }
    }
    
    // tampilMenu menggunakan List
    public static void tampilMenu(List<Menu> daftarMenu) {
        System.out.println("========================================");
        System.out.println("          >>Menu Warung Java<<          ");
        System.out.println("========================================");
        System.out.println("");

        System.out.println("----Makanan----");
        int noMakanan = 1;
        for (Menu menu : daftarMenu) {
            if (menu.getKategori().equalsIgnoreCase("Makanan")) {
                System.out.printf("%d. %-20s - Rp. %d\n", noMakanan, menu.getNama(), (int)menu.getHarga());
                noMakanan++;
            }
        }

        System.out.println("");
        System.out.println("----Minuman----");
        int noMinuman = 1;
        for (Menu menu : daftarMenu) {
             if (menu.getKategori().equalsIgnoreCase("Minuman")) {
                System.out.printf("%d. %-20s - Rp. %d\n", noMinuman, menu.getNama(), (int)menu.getHarga());
                noMinuman++;
            }
        }
        System.out.println("");
        System.out.println("========================================");
    }

    // Mengganti cariMenu agar menerima List
    public static Menu cariMenu(String namaMenu, List<Menu> daftarMenu) {
        String cari = namaMenu.toLowerCase().trim();
        for (Menu menu : daftarMenu) {
            String nama = menu.getNama().toLowerCase();
            if (nama.startsWith(cari) || nama.contains(cari)) {
                return menu;
            }
        }
        return null; 
    }

    // --- MENU 1: PEMESANAN PELANGGAN ---
    public static void menuPemesanan() {
        List<Menu> daftarMenu = Menu.getDaftarMenu();
        List<Menu> pesanMenu = new ArrayList<>();
        List<Integer> jmlhMenu = new ArrayList<>();

        tampilMenu(daftarMenu);

        System.out.println("\n========================================");
        System.out.println(">>MULAI PEMESANAN (Ketik 'selesai' untuk mengakhiri)<<");
        System.out.println("========================================");
        System.out.println("Format: nama_menu=jumlah (Contoh: Nasi Campur=2)");
        
        while (true) {
            System.out.print("Masukkan Pesanan Anda: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("selesai")) {
                break;
            }
            
            try {
                if (!input.contains("=")) {
                    System.err.println("❌ Format harus 'nama_menu=jumlah'.");
                    continue;
                }
                
                String[] parts = input.split("=");
                if (parts.length != 2) {
                    System.err.println("❌ Format tidak valid.");
                    continue;
                }
                
                String namaMenu = parts[0].trim();
                int jumlah = Integer.parseInt(parts[1].trim());
                
                if (jumlah <= 0) {
                     System.err.println("❌ Jumlah pesanan harus lebih dari 0.");
                     continue;
                }

                Menu menuDitemukan = cariMenu(namaMenu, daftarMenu);
                
                if (menuDitemukan != null) {
                    pesanMenu.add(menuDitemukan);
                    jmlhMenu.add(jumlah);
                    System.out.println("-> Pesanan " + menuDitemukan.getNama() + " (" + jumlah + ") berhasil ditambahkan.");
                } else {
                    System.err.println("❌ Maaf, menu '" + namaMenu + "' tidak ditemukan di daftar. Coba lagi.");
                }

            } catch (NumberFormatException e) {
                System.err.println("❌ ERROR: Jumlah harus berupa angka yang valid.");
            } catch (Exception e) {
                 System.err.println("❌ Terjadi kesalahan saat memproses input. Coba lagi.");
            }
        }
        
        if (pesanMenu.isEmpty()) {
            System.out.println("----------------------------------------");
            System.out.println("Anda tidak melakukan pemesanan. Kembali ke Menu Utama.");
        } else {
            hitungdancetak(pesanMenu, jmlhMenu); 
        }
    }
    
    // --- MENU 2: PENGELOLAAN MENU (ADMIN) ---
    public static void menuPengelolaan() {
        List<Menu> daftarMenu = Menu.getDaftarMenu();

        while (true) {
            System.out.println("\n===== PENGELOLAAN MENU =====");
            System.out.println("1. Tambah Menu Baru");
            System.out.println("2. Ubah Harga Menu");
            System.out.println("3. Hapus Menu");
            System.out.println("4. Lihat Daftar Menu");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih opsi (1-5): ");

            String pilihan = scanner.nextLine().trim();
            try {
                switch (pilihan) {
                    case "1":
                        tambahMenu(daftarMenu);
                        break;
                    case "2":
                        ubahHargaMenu(daftarMenu);
                        break;
                    case "3":
                        hapusMenu(daftarMenu);
                        break;
                    case "4":
                        tampilMenu(daftarMenu);
                        break;
                    case "5":
                        return; // Kembali ke mainMenu()
                    default:
                        System.err.println("❌ Pilihan tidak valid. Silakan masukkan 1-5.");
                }
            } catch (Exception e) {
                System.err.println("❌ Terjadi kesalahan dalam proses pengelolaan.");
            }
        }
    }

    // --- FUNGSI ADMIN: TAMBAH MENU ---
    private static void tambahMenu(List<Menu> daftarMenu) {
        while(true){
            System.out.println("\n--- Tambah Menu Baru ---");
            System.out.print("Nama Menu: ");
            String nama = scanner.nextLine();
        
            System.out.print("Harga (contoh: 15000): ");
            int harga = Integer.parseInt(scanner.nextLine());
        
            System.out.print("Kategori (Makanan/Minuman): ");
            String kategori = scanner.nextLine();

            if (harga <= 0 || (!kategori.equalsIgnoreCase("Makanan") && !kategori.equalsIgnoreCase("Minuman"))) {
                System.err.println("❌ Input tidak valid. Harga tidak boleh nol dan kategori harus Makanan/Minuman.");
                
            } else{
                Menu menuBaru = new Menu(nama, harga, kategori);
                daftarMenu.add(menuBaru);
                System.out.println("✅ Menu '" + nama + "' berhasil ditambahkan!");
            }
            // Pertanyaan untuk menambah menu lagi atau berhenti
            System.out.print("Tambah menu lagi? (y/n): ");
            String lagi = scanner.nextLine().trim();

            if (!lagi.equalsIgnoreCase("y")) {
                System.out.println("Kembali ke menu pengelolaan...");
                break;
            }
        } 
    }
    
    // --- FUNGSI ADMIN: UBAH HARGA ---
    private static void ubahHargaMenu(List<Menu> daftarMenu) {
        if (daftarMenu.isEmpty()) {
            System.out.println("Daftar menu kosong.");
            return;
        }
        
        tampilMenu(daftarMenu);
        System.out.println("\n--- Ubah Harga Menu ---");
        
        while (true) {
            System.out.print("Masukkan Nama Menu yang ingin diubah (atau 'batal'): ");
            String inputNama = scanner.nextLine().trim();

            if (inputNama.equalsIgnoreCase("batal")) {
                System.out.println("Perubahan dibatalkan. Kembali ke menu pengelolaan...");
                return;
                }

            //Cari objek Menu berdasarkan nama
            Menu menuToUpdate = cariMenu(inputNama, daftarMenu); 

            if (menuToUpdate != null) {
                System.out.println("Anda memilih: **" + menuToUpdate.getNama() + "** (Harga saat ini: Rp. " + (int)menuToUpdate.getHarga() + ")");
                
                System.out.print("Masukkan Harga Baru (contoh: 20000): ");
                String inputHarga = scanner.nextLine();
                
                try {
                    int hargaBaru = Integer.parseInt(inputHarga);

                    if (hargaBaru <= 0) {
                        System.err.println("❌ Harga harus positif. Coba lagi.");
                        continue;
                    }

                    //Konfirmasi Perubahan
                    System.out.print("Yakin ingin mengubah harga " + menuToUpdate.getNama() + " menjadi Rp. " + (int)hargaBaru + "? (Ya/Tidak): ");
                    String konfirmasi = scanner.nextLine();

                    if (konfirmasi.equalsIgnoreCase("Ya")) {
                        menuToUpdate.setHarga(hargaBaru);
                        System.out.println("✅ Harga menu **" + menuToUpdate.getNama() + "** berhasil diubah.");
                    } else {
                        System.out.println("Perubahan dibatalkan.");
                    }
                    return; // Keluar dari loop setelah selesai
                    
                } catch (NumberFormatException e) {
                    System.err.println("❌ Input harga harus berupa angka. Coba lagi.");
                }

            } else {
                System.err.println("❌ Maaf, menu '" + inputNama + "' tidak ditemukan. Coba lagi.");
            }
        }
    }

    // --- FUNGSI ADMIN: HAPUS MENU ---
    private static void hapusMenu(List<Menu> daftarMenu) {
        if (daftarMenu.isEmpty()) {
            System.out.println("Daftar menu kosong.");
            return;
        }

        // Tampilkan menu untuk referensi nama
        tampilMenu(daftarMenu); 
        
        System.out.println("\n--- Hapus Menu ---");

        while (true) {
            System.out.print("Masukkan Nama Menu yang ingin dihapus (atau 'batal'): ");
            String inputNama = scanner.nextLine().trim();
            
            if (inputNama.equalsIgnoreCase("batal")) {
                System.out.println("Penghapusan dibatalkan. Kembali ke menu pengelolaan...");
                return;
            }

            // 1. Cari objek Menu berdasarkan nama
            Menu hapusMenu = cariMenu(inputNama, daftarMenu); 

            if (hapusMenu != null) {
                
                System.out.print("Yakin ingin menghapus menu **'" + hapusMenu.getNama() + "'**? (Ya/Tidak): ");
                String konfirmasi = scanner.nextLine();

                if (konfirmasi.equalsIgnoreCase("Ya")) {
                    // 2. Hapus objek dari List
                    daftarMenu.remove(hapusMenu);
                    System.out.println("✅ Menu **'" + hapusMenu.getNama() + "'** berhasil dihapus.");
                } else {
                    System.out.println("Penghapusan dibatalkan.");
                }
                return; // Kembali ke menu pengelolaan setelah selesai
                
            } else {
                System.err.println("❌ Maaf, menu '" + inputNama + "' tidak ditemukan. Coba lagi.");
            }
        }
    }
    
    // --- PERHITUNGAN DAN CETAK STRUK (Diperbarui agar menerima List) ---
    public static void hitungdancetak(List<Menu> pesanMenu, List<Integer> jmlhMenu) {
       // Logika hitungdancetak yang sama dengan perbaikan sebelumnya, 
       // namun diadaptasi untuk List dan mencari promo Minuman secara dinamis.
       int totBiaya = 0;
       int diskon = 0;
       int pelayanan = 20000;
       String gratisMinuman = "";
       boolean adaMinuman = false;
       
       System.out.println("\n========================================");
       System.out.println("             >>Warung Java<<            ");
       System.out.println("            >>Struk Pesanan<<           ");
       System.out.println("========================================");
       System.out.println("");
       
       for (int i = 0; i < pesanMenu.size(); i++) {
           Menu menu = pesanMenu.get(i);
           int jumlah = jmlhMenu.get(i);
           
           int subTotal = menu.getHarga() * jumlah;
           System.out.printf("%-15s %d x Rp. %-7d = Rp. %d\n", menu.getNama(), jumlah, (int)menu.getHarga(), (int)subTotal);
           totBiaya += subTotal;
           
           if (menu.getKategori().equalsIgnoreCase("Minuman") && !adaMinuman) {
               gratisMinuman = menu.getNama();
               adaMinuman = true;
           }
       }

       System.out.println("----------------------------------------");
       System.out.printf("Total Harga : \t\t\t Rp. %d\n", (int)totBiaya);
       int pajak = totBiaya * 10/100;
       System.out.printf("Pajak (10%%) : \t\t\t Rp. %d\n", (int)pajak);
       System.out.printf("Biaya Pelayanan : \t\t Rp. %d\n", (int)pelayanan);
       
       int total = totBiaya + pajak + pelayanan;
       
       if (total > 100000.0) {
          diskon = total * 10/100;
          System.out.println("");
          System.out.println("Pengurang");
          System.out.printf("Diskon (10%%) : \t\t\t Rp. -%d\n", (int)diskon);
       }

       int totAkhir = total - diskon;
       System.out.println("----------------------------------------");
       System.out.printf("Total Bayar : \t\t\t Rp. %d\n", (int)totAkhir);
       System.out.println("");
       System.out.println("########################################");

       if (total > 50000.0) {
          System.out.println("------------Promo Spesial---------------");
          if (adaMinuman) {
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