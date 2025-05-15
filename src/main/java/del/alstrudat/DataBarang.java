package del.alstrudat;

public class DataBarang extends Data {
    private String jenis;
    private double harga;

    public DataBarang(String id, String nama, String jenis, double harga) {
        super(id, nama);
        this.jenis = jenis;
        this.harga = harga;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    @Override
    public void tampilData() {
        System.out.println("ID: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("Jenis: " + jenis);
        System.out.println("Harga: Rp." + harga);
    }
}
