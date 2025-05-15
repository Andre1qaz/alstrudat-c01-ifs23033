package del.alstrudat;

public class DataMobilKBT extends Data {
    private String jenis;
    private double dayaListrik; // dalam kW
    private int kapasitasBaterai; // dalam kWh
    private int kapasitasPenumpang; // jumlah orang
    private double jangkauan; // dalam km

    public DataMobilKBT(String id, String nama, String jenis, double dayaListrik, 
                      int kapasitasBaterai, int kapasitasPenumpang, double jangkauan) {
        super(id, nama);
        this.jenis = jenis;
        this.dayaListrik = dayaListrik;
        this.kapasitasBaterai = kapasitasBaterai;
        this.kapasitasPenumpang = kapasitasPenumpang;
        this.jangkauan = jangkauan;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public double getDayaListrik() {
        return dayaListrik;
    }

    public void setDayaListrik(double dayaListrik) {
        this.dayaListrik = dayaListrik;
    }

    public int getKapasitasBaterai() {
        return kapasitasBaterai;
    }

    public void setKapasitasBaterai(int kapasitasBaterai) {
        this.kapasitasBaterai = kapasitasBaterai;
    }

    public int getKapasitasPenumpang() {
        return kapasitasPenumpang;
    }

    public void setKapasitasPenumpang(int kapasitasPenumpang) {
        this.kapasitasPenumpang = kapasitasPenumpang;
    }

    public double getJangkauan() {
        return jangkauan;
    }

    public void setJangkauan(double jangkauan) {
        this.jangkauan = jangkauan;
    }

    @Override
    public void tampilData() {
        System.out.println("ID: " + id);
        System.out.println("Nama Mobil KBT: " + nama);
        System.out.println("Jenis: " + jenis);
        System.out.println("Daya Listrik: " + dayaListrik + " kW");
        System.out.println("Kapasitas Baterai: " + kapasitasBaterai + " kWh");
        System.out.println("Kapasitas Penumpang: " + kapasitasPenumpang + " orang");
        System.out.println("Jangkauan: " + jangkauan + " km");
    }
}
