package del.alstrudat;

public class App {
    private static MobilKBT mobilManager;
    private static BarangLoader barangLoader;

    public static void main(String[] args) {
        mobilManager = new MobilKBT();
        barangLoader = new BarangLoader();

        boolean running = true;
        while (running) {
            tampilkanMenu();
            int pilihan = bacaInputAngka("Pilih menu: ");

            switch (pilihan) {
                case 1:
                    mobilManager.tampilkanSemuaMobil();
                    break;
                case 2:
                    mobilManager.tambahMobil();
                    break;
                case 3:
                    mobilManager.tampilkanDetailMobil();
                    break;
                case 4:
                    mobilManager.updateMobil();
                    break;
                case 5:
                    mobilManager.hapusMobil();
                    break;
                case 6:
                    mobilManager.cariMobilByNama();
                    break;
                case 7:
                    mobilManager.cariMobilByKapasitasPenumpang();
                    break;
                case 8:
                    mobilManager.sortMobilByDaya();
                    break;
                case 9:
                    mobilManager.sortMobilByKapasitasBaterai();
                    break;
                case 10:
                    barangLoader.tampilkanBarang();
                    break;
                case 11:
                    barangLoader.tambahBarang();
                    break;
                case 0:
                    running = false;
                    System.out.println("Terima kasih telah menggunakan aplikasi ini!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
            

            if (running) {
                System.out.println("\nTekan Enter untuk melanjutkan...");
                Util.getScanner().nextLine();
            }
        }
        
        Util.closeScanner();
    }

    private static void tampilkanMenu() {
        System.out.println("\n=== APLIKASI MANAJEMEN MOBIL KBT ===");
        System.out.println("1. Tampilkan Semua Mobil KBT");
        System.out.println("2. Tambah Mobil KBT");
        System.out.println("3. Tampilkan Detail Mobil KBT");
        System.out.println("4. Update Data Mobil KBT");
        System.out.println("5. Hapus Mobil KBT");
        System.out.println("6. Cari Mobil Berdasarkan Nama");
        System.out.println("7. Cari Mobil Berdasarkan Kapasitas Penumpang");
        System.out.println("8. Urutkan Mobil Berdasarkan Daya Listrik");
        System.out.println("9. Urutkan Mobil Berdasarkan Kapasitas Baterai");
        System.out.println("10. Tampilkan Daftar Barang");
        System.out.println("11. Tambah Barang");
        System.out.println("0. Keluar");
        System.out.println("========================");
    }

    private static int bacaInputAngka(String prompt) {
        int input = -1;
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);
            try {
                input = Integer.parseInt(Util.getScanner().nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Masukkan angka.");
            }
        }

        return input;
    }
}