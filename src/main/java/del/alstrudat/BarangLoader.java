package del.alstrudat;

public class BarangLoader {
    private LinkedList<DataBarang> daftarBarang;
    
    public BarangLoader() {
        this.daftarBarang = new LinkedList<>();
        initData();
    }
    
    private void initData() {
        // Data awal barang
        daftarBarang.add(new DataBarang("B001", "Baterai Lithium-ion", "Komponen", 5000000));
        daftarBarang.add(new DataBarang("B002", "Motor Listrik 150kW", "Penggerak", 20000000));
        daftarBarang.add(new DataBarang("B003", "Converter DC/DC", "Elektronik", 3500000));
        daftarBarang.add(new DataBarang("B004", "Inverter AC", "Elektronik", 7500000));
        daftarBarang.add(new DataBarang("B005", "Charger Onboard", "Pengisian", 4500000));
    }
    
    public void tampilkanBarang() {
        System.out.println("\n=== DAFTAR BARANG ===");
        if (daftarBarang.isEmpty()) {
            System.out.println("Tidak ada data barang.");
            return;
        }
        
        int i = 1;
        for (DataBarang barang : daftarBarang) {
            System.out.println("\nBarang #" + i);
            barang.tampilData();
            System.out.println("------------------------");
            i++;
        }
    }
    
    public void tambahBarang() {
        System.out.println("\n=== TAMBAH BARANG ===");
        System.out.print("ID Barang: ");
        String id = Util.getScanner().nextLine();
        
        // Cek apakah ID sudah ada
        for (DataBarang barang : daftarBarang) {
            if (barang.getId().equals(id)) {
                System.out.println("Barang dengan ID " + id + " sudah ada!");
                return;
            }
        }
        
        System.out.print("Nama Barang: ");
        String nama = Util.getScanner().nextLine();        
        System.out.print("Jenis Barang: ");
        String jenis = Util.getScanner().nextLine();
        
        double harga = 0;
        try {
            System.out.print("Harga Barang: ");
            harga = Double.parseDouble(Util.getScanner().nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input harga tidak valid!");
            return;
        }
        
        DataBarang barangBaru = new DataBarang(id, nama, jenis, harga);
        daftarBarang.add(barangBaru);
        System.out.println("Barang berhasil ditambahkan!");
    }
    
    public void close() {
    }
}
