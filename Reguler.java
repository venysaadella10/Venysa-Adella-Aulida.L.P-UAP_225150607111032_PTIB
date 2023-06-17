public class Reguler extends Hotel {
    double discount = 0;

    public Reguler() {
        super("Reguler", 150000);
    }

    @Override
    public double hitungBiayaHarian(long durasi) {
       return hargaAwal * durasi;
    }

    @Override
    public double hitungBiayaSinggah(long durasi) {
        double biaya;
        if (durasi > 12) {
            biaya = hargaAwal*durasi*0.07;
        } else {
            if (durasi > 6 && durasi <= 12) {
                biaya = hargaAwal*durasi*0.06;
            } else {
                if (durasi <= 6) {
                    biaya = hargaAwal*durasi*0.05;
                } else {
                    biaya = hargaAwal;
                }
            }
        }
        return biaya;
    }

    @Override
    public double discount(int voucher) {
        if (voucher == 1) {
            discount = hargaAwal*(10/100);
        }
        if (voucher == 2) {
            discount = hargaAwal*(20/100);
        }

        return discount;
    }
}
