public abstract class Hotel {
    protected String jenisKamar;
    protected double hargaAwal;

    public Hotel(String jenisKamar, double hargaAwal) {
        this.jenisKamar = jenisKamar;
        this.hargaAwal = hargaAwal;
    }

    public abstract double hitungBiayaHarian(long durasi);
    public abstract double hitungBiayaSinggah(long durasi);
    public abstract double discount(int voucher);

    public String getJenisKamar() {
        return jenisKamar;
    }
}
