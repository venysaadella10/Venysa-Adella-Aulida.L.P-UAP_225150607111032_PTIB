public class Pemesanan {
    private Hotel hotel;
    private String nomorKamar;

    public Pemesanan(Hotel hotel, String nomorKamar) {
        this.hotel = hotel;
        this.nomorKamar = nomorKamar;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public String getNomorKamar() {
        return nomorKamar;
    }
}
