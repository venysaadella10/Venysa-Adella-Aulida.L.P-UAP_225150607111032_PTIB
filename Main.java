import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<Pemesanan> daftarPemesanan = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        Random r = new Random();

        int menu = 0;
        while (menu != 4) {
            System.out.println("====================================");
            System.out.println("SELAMAT DATANG DI HOTEL GRIYA SANTHA");
            System.out.println("====================================");
            System.out.println("-------SILAHKAN MEMILIH MENU:-------");
            System.out.println("Menu :");
            System.out.println("1. Booking");
            System.out.println("2. Layanan Ganti Kamar");
            System.out.println("3. Info Kamar yang Tersedia");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            menu = in.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("Jenis Kamar:");
                    System.out.println("1. Reguler");
                    System.out.println("2. Business");
                    System.out.println("3. Mewah");
                    System.out.print("Pilih jenis kamar: ");
                    int jenisKamar = in.nextInt();

                Hotel hotel = null;
                    switch (jenisKamar) {
                        case 1:
                            hotel = new Reguler();
                            break;
                        case 2:
                            hotel = new Bisnis();
                            break;
                        case 3:
                            hotel = new Mewah();
                            break;
                        default:
                            System.out.println("Jenis kamar tidak valid!");
                            break;
                    }

                    if (hotel != null) {
                        System.out.print("Masukkan nomor kamar: ");
                        String nomorKamar = in.next();
                        Pemesanan pemesanan = new Pemesanan(hotel, nomorKamar);
                        daftarPemesanan.add(pemesanan);

                        System.out.println("Pilih durasi menginap:");
                        System.out.println("1. Harian");
                        System.out.println("2. Singgah");
                        System.out.print("Pilih durasi: ");
                        int durasiPilihan = in.nextInt();

                        double biaya = 0;
                        if (durasiPilihan == 1) {
                             System.out.print("Berapa Hari anda akan menginap (Masukkan dalam format angka) : ");
                            long totaltahun = in.nextLong();
                            biaya = hotel.hitungBiayaHarian(totaltahun);
                        } else if (durasiPilihan == 2) {
                            System.out.print("Berapa jam anda akan menginap (Masukkan dalam format angka) : ");
                            long totalbulan = in.nextLong();
                            biaya = hotel.hitungBiayaSinggah(totalbulan); 
                        }

                        int acak = r.nextInt(10)+1;
                        double hargasetelahdiscount;
                        if (acak == 3 || acak == 6 || acak == 9) {
                            int pilih;
                            System.out.println("Selamat anda adalah pelanggan yang berhasil beruntung mendapatkan voucher");
                            System.out.println("1. PASTIMURAH");
                            System.out.println("2. STAYCATION");
                            System.out.print("Pilih Voucher yang ingin anda gunakan : ");
                            pilih = in.nextInt();
                            hargasetelahdiscount = biaya - hotel.discount(pilih);

                            System.out.println("Biaya total: Rp." + hargasetelahdiscount);
                            System.out.println("Pemesanan berhasil!");
                        }else {
                            System.out.println("Biaya total: Rp." + biaya);
                            System.out.println("Pemesanan berhasil!");
                        }

                    }
                    break;

                case 2:
                    if (daftarPemesanan.isEmpty()) {
                        System.out.println("Belum ada pemesanan!");
                    } else {
                        System.out.print("Masukkan nomor kamar anda saat ini: ");
                        String nomorKamarGanti = in.next();

                        boolean found = false;
                        for (Pemesanan pemesanan : daftarPemesanan) {
                            if (pemesanan.getNomorKamar().equals(nomorKamarGanti)) {
                                found = true;
                                System.out.println("Jenis Kamar:");
                                System.out.println("1. Reguler");
                                System.out.println("2. Business");
                                System.out.println("3. Mewah");
                                System.out.print("Pilih jenis kamar baru: ");
                                int jenisKamarGanti = in.nextInt();

                                Hotel hotelGanti = null;
                                switch (jenisKamarGanti) {
                                    case 1:
                                        hotelGanti = new Reguler();
                                        break;
                                    case 2:
                                        hotelGanti = new Bisnis();
                                        break;
                                    case 3:
                                        hotelGanti = new Mewah();
                                        break;
                                    default:
                                        System.out.println("Jenis kamar tidak valid!");
                                        break;
                                }

                                if (hotelGanti != null) {
                                    int indexPemesanan = daftarPemesanan.indexOf(pemesanan);
                                    if (indexPemesanan != 1) {
                                        pemesanan = new Pemesanan(hotelGanti, nomorKamarGanti);
                                        daftarPemesanan.set(indexPemesanan, pemesanan);
                                        System.out.println("Layanan ganti kamar berhasil!");
                                    } else {
                                        System.out.println("Terjadi kesalahan dalam mencari objek pemesanan.");
                                    }
                                }
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("Nomor kamar tidak valid!");
                        }
                    }
                    break;

                case 3:
                    if (daftarPemesanan.isEmpty()) {
                        System.out.println("Semua kamar tersedia.");
                    } else {
                        ArrayList<String> kamarTersedia = new ArrayList<>();
                        kamarTersedia.add("Reguler 19");
                        kamarTersedia.add("Reguler 12");
                        kamarTersedia.add("Bisnis 21");
                        kamarTersedia.add("Bisnis 02");
                        kamarTersedia.add("Mewah 01");
                        kamarTersedia.add("Mewah 32");

                        for (Pemesanan pemesanan : daftarPemesanan) {
                            kamarTersedia.remove(pemesanan.getNomorKamar());
                        }

                        System.out.println("Kamar yang tersedia:");
                        for (String kamar : kamarTersedia) {
                            System.out.println(kamar);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Menu tidak valid!");
                    break;
            }

            System.out.println();
        }

        in.close();
    }
}
