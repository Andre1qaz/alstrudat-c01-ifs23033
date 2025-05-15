package del.alstrudat;

// import java.util.Scanner;

public class MobilKBT {
    private LinkedList<DataMobilKBT> daftarMobil;

    public MobilKBT() {
        this.daftarMobil = new LinkedList<>();
        initializeData();
    }

    private void initializeData() {
        // Inisialisasi 20 mobil KBT
        daftarMobil.add(new DataMobilKBT("KBT001", "Tesla Model 3", "Sedan", 190, 60, 5, 400));
        daftarMobil.add(new DataMobilKBT("KBT002", "Nissan Leaf", "Hatchback", 110, 40, 5, 270));
        daftarMobil.add(new DataMobilKBT("KBT003", "Hyundai Kona Electric", "SUV", 150, 64, 5, 415));
        daftarMobil.add(new DataMobilKBT("KBT004", "Porsche Taycan", "Sedan Mewah", 560, 93, 4, 450));
        daftarMobil.add(new DataMobilKBT("KBT005", "Audi e-tron", "SUV", 300, 95, 5, 400));
        daftarMobil.add(new DataMobilKBT("KBT006", "BMW i3", "Hatchback", 125, 42, 4, 250));
        daftarMobil.add(new DataMobilKBT("KBT007", "Mercedes EQC", "SUV", 300, 80, 5, 390));
        daftarMobil.add(new DataMobilKBT("KBT008", "Kia e-Niro", "SUV", 150, 64, 5, 385));
        daftarMobil.add(new DataMobilKBT("KBT009", "Jaguar I-PACE", "SUV", 294, 90, 5, 470));
        daftarMobil.add(new DataMobilKBT("KBT010", "Volkswagen ID.4", "SUV", 150, 77, 5, 420));
        daftarMobil.add(new DataMobilKBT("KBT011", "Tesla Model Y", "Crossover", 220, 75, 5, 505));
        daftarMobil.add(new DataMobilKBT("KBT012", "Rivian R1T", "Pickup", 562, 135, 5, 505));
        daftarMobil.add(new DataMobilKBT("KBT013", "Ford Mustang Mach-E", "SUV", 248, 88, 5, 490));
        daftarMobil.add(new DataMobilKBT("KBT014", "Polestar 2", "Fastback", 300, 78, 5, 395));
        daftarMobil.add(new DataMobilKBT("KBT015", "Volvo XC40 Recharge", "SUV", 300, 78, 5, 400));
        daftarMobil.add(new DataMobilKBT("KBT016", "Mini Cooper SE", "Hatchback", 135, 32, 4, 185));
        daftarMobil.add(new DataMobilKBT("KBT017", "Chevrolet Bolt", "Hatchback", 150, 65, 5, 415));
        daftarMobil.add(new DataMobilKBT("KBT018", "Tesla Model X", "SUV", 350, 100, 7, 525));
        daftarMobil.add(new DataMobilKBT("KBT019", "Lucid Air", "Sedan Mewah", 620, 113, 5, 830));
        daftarMobil.add(new DataMobilKBT("KBT020", "BYD Atto 3", "SUV", 150, 60, 5, 410));
    }

    public void tambahMobil() {
        System.out.println("\n=== TAMBAH MOBIL KBT ===");
        System.out.print("ID Mobil: ");
        String id = Util.getScanner().nextLine();
        
        // Cek apakah ID sudah ada
        if (cariMobilById(id) != null) {
            System.out.println("Mobil dengan ID " + id + " sudah ada!");
            return;
        }
        
        System.out.print("Nama Mobil: ");
        String nama = Util.getScanner().nextLine();

        
        System.out.print("Jenis Mobil: ");
        String jenis = Util.getScanner().nextLine(); 
        
        double dayaListrik = 0;
        int kapasitasBaterai = 0;
        int kapasitasPenumpang = 0;
        double jangkauan = 0;
        
        try {
            System.out.print("Daya Listrik (kW): ");
            dayaListrik = Double.parseDouble(Util.getScanner().nextLine());
            
            System.out.print("Kapasitas Baterai (kWh): ");
            kapasitasBaterai = Integer.parseInt(Util.getScanner().nextLine());
            
            System.out.print("Kapasitas Penumpang: ");
            kapasitasPenumpang = Integer.parseInt(Util.getScanner().nextLine());
            
            System.out.print("Jangkauan (km): ");
            jangkauan = Double.parseDouble(Util.getScanner().nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid! Pastikan input angka yang benar.");
            return;
        }
        
        DataMobilKBT mobilBaru = new DataMobilKBT(id, nama, jenis, dayaListrik, kapasitasBaterai, kapasitasPenumpang, jangkauan);
        daftarMobil.add(mobilBaru);
        System.out.println("Mobil KBT berhasil ditambahkan!");
    }
    
    public void tampilkanSemuaMobil() {
        System.out.println("\n=== DAFTAR MOBIL KBT ===");
        if (daftarMobil.isEmpty()) {
            System.out.println("Tidak ada data mobil KBT.");
            return;
        }
        
        int i = 1;
        for (DataMobilKBT mobil : daftarMobil) {
            System.out.println("\nMobil #" + i);
            mobil.tampilData();
            System.out.println("------------------------");
            i++;
        }
    }
    
    public void tampilkanDetailMobil() {
        System.out.println("\n=== DETAIL MOBIL KBT ===");
        System.out.print("Masukkan ID Mobil: ");
        String id = Util.getScanner().nextLine();
        
        DataMobilKBT mobil = cariMobilById(id);
        if (mobil != null) {
            mobil.tampilData();
        } else {
            System.out.println("Mobil dengan ID " + id + " tidak ditemukan!");
        }
    }
    
    public void updateMobil() {
        System.out.println("\n=== UPDATE DATA MOBIL KBT ===");
        System.out.print("Masukkan ID Mobil yang akan diupdate: ");
        String id = Util.getScanner().nextLine();
        
        DataMobilKBT mobil = cariMobilById(id);
        if (mobil == null) {
            System.out.println("Mobil dengan ID " + id + " tidak ditemukan!");
            return;
        }
        
        System.out.println("Data Mobil Saat Ini:");
        mobil.tampilData();
        
        System.out.println("\nMasukkan data baru (kosongkan jika tidak ingin mengubah)");
        
        System.out.print("Nama Mobil [" + mobil.getNama() + "]: ");
        String nama = Util.getScanner().nextLine();
        if (!nama.isEmpty()) {
            mobil.setNama(nama);
        }
        
        System.out.print("Jenis Mobil [" + mobil.getJenis() + "]: ");
        String jenis = Util.getScanner().nextLine();
        if (!jenis.isEmpty()) {
            mobil.setJenis(jenis);
        }
        
        try {
            System.out.print("Daya Listrik (kW) [" + mobil.getDayaListrik() + "]: ");
            String dayaStr = Util.getScanner().nextLine();
            if (!dayaStr.isEmpty()) {
                mobil.setDayaListrik(Double.parseDouble(dayaStr));
            }
            
            System.out.print("Kapasitas Baterai (kWh) [" + mobil.getKapasitasBaterai() + "]: ");
            String kapasitasStr = Util.getScanner().nextLine();
            if (!kapasitasStr.isEmpty()) {
                mobil.setKapasitasBaterai(Integer.parseInt(kapasitasStr));
            }
            
            System.out.print("Kapasitas Penumpang [" + mobil.getKapasitasPenumpang() + "]: ");
            String penumpangStr = Util.getScanner().nextLine();
            if (!penumpangStr.isEmpty()) {
                mobil.setKapasitasPenumpang(Integer.parseInt(penumpangStr));
            }
            
            System.out.print("Jangkauan (km) [" + mobil.getJangkauan() + "]: ");
            String jangkauanStr = Util.getScanner().nextLine();
            if (!jangkauanStr.isEmpty()) {
                mobil.setJangkauan(Double.parseDouble(jangkauanStr));
            }
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid! Update dibatalkan.");
            return;
        }
        
        System.out.println("Data Mobil KBT berhasil diupdate!");
    }

    public void hapusMobil() {
        System.out.println("\n=== HAPUS MOBIL KBT ===");
        System.out.print("Masukkan ID Mobil yang akan dihapus: ");
        String id = Util.getScanner().nextLine();
        
        DataMobilKBT mobil = cariMobilById(id);
        if (mobil == null) {
            System.out.println("Mobil dengan ID " + id + " tidak ditemukan!");
            return;
        }
        
        System.out.println("Data Mobil yang akan dihapus:");
        mobil.tampilData();
        
        System.out.print("\nApakah Anda yakin ingin menghapus mobil ini? (y/n): ");
        String konfirmasi = Util.getScanner().nextLine();
        
        if (konfirmasi.equalsIgnoreCase("y")) {
            daftarMobil.remove(mobil);
            System.out.println("Mobil berhasil dihapus!");
        } else {
            System.out.println("Penghapusan dibatalkan.");
        }
    }
    
    public void cariMobilByNama() {
        System.out.println("\n=== CARI MOBIL KBT BERDASARKAN NAMA ===");
        System.out.print("Masukkan Nama Mobil: ");
        String keyword = Util.getScanner().nextLine().toLowerCase();
        
        boolean ditemukan = false;
        for (DataMobilKBT mobil : daftarMobil) {
            if (mobil.getNama().toLowerCase().contains(keyword)) {
                if (!ditemukan) {
                    System.out.println("\nHasil Pencarian:");
                    ditemukan = true;
                }
                mobil.tampilData();
                System.out.println("------------------------");
            }
        }
        
        if (!ditemukan) {
            System.out.println("Mobil dengan nama yang mengandung \"" + keyword + "\" tidak ditemukan.");
        }
    }
    
    public void cariMobilByKapasitasPenumpang() {
        System.out.println("\n=== CARI MOBIL KBT BERDASARKAN KAPASITAS PENUMPANG ===");
        System.out.print("Masukkan Kapasitas Penumpang: ");
        
        try {
            int kapasitas = Integer.parseInt(Util.getScanner().nextLine());
            
            boolean ditemukan = false;
            for (DataMobilKBT mobil : daftarMobil) {
                if (mobil.getKapasitasPenumpang() == kapasitas) {
                    if (!ditemukan) {
                        System.out.println("\nHasil Pencarian:");
                        ditemukan = true;
                    }
                    mobil.tampilData();
                    System.out.println("------------------------");
                }
            }
            
            if (!ditemukan) {
                System.out.println("Mobil dengan kapasitas penumpang " + kapasitas + " tidak ditemukan.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid! Masukkan angka untuk kapasitas penumpang.");
        }
    }
    
    private DataMobilKBT cariMobilById(String id) {
        for (DataMobilKBT mobil : daftarMobil) {
            if (mobil.getId().equals(id)) {
                return mobil;
            }
        }
        return null;
    }
    
    public void sortMobilByDaya() {
        LinkedListHelper.sortList(daftarMobil, (a, b) -> {
            if (a.getDayaListrik() > b.getDayaListrik()) return 1;
            else if (a.getDayaListrik() < b.getDayaListrik()) return -1;
            else return 0;
        });
        
        System.out.println("\nDaftar Mobil telah diurutkan berdasarkan Daya Listrik!");
    }
    
    public void sortMobilByKapasitasBaterai() {
        LinkedListHelper.sortList(daftarMobil, (a, b) -> {
            if (a.getKapasitasBaterai() > b.getKapasitasBaterai()) return 1;
            else if (a.getKapasitasBaterai() < b.getKapasitasBaterai()) return -1;
            else return 0;
        });
        
        System.out.println("\nDaftar Mobil telah diurutkan berdasarkan Kapasitas Baterai!");
    }
    

}