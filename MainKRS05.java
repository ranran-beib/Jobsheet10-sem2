import java.util.Scanner;

public class MainKRS05 {

    public static void tampilkanMenu() {
        System.out.println("\n======================================");
        System.out.println("  Sistem Antrian Persetujuan KRS DPA  ");
        System.out.println("======================================");
        System.out.println(" 1. Tambah Mahasiswa ke Antrian");
        System.out.println(" 2. Panggil Antrian (proses KRS 2 mhs)");
        System.out.println(" 3. Tampilkan Semua Antrian");
        System.out.println(" 4. Tampilkan 2 Antrian Terdepan");
        System.out.println(" 5. Lihat Antrian Paling Akhir");
        System.out.println(" 6. Cek Antrian Kosong");
        System.out.println(" 7. Cek Antrian Penuh");
        System.out.println(" 8. Kosongkan Antrian");
        System.out.println(" 9. Jumlah Antrian Saat Ini");
        System.out.println("10. Jumlah yang Sudah Proses KRS");
        System.out.println("11. Jumlah yang Belum Proses KRS");
        System.out.println(" 0. Keluar");
        System.out.println("--------------------------------------");
        System.out.print("Pilih menu: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Max antrian 10, max per DPA 30 (sudah diset di dalam class)
        AntrianKRS05 antrian = new AntrianKRS05(10);
        int pilihan;

        System.out.println("=== Sistem Antrian Persetujuan KRS ===");
        System.out.println("Kapasitas antrian: 10 | Maks per DPA: 30 mahasiswa");

        do {
            tampilkanMenu();
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("NIM   : ");
                    String nim = sc.nextLine();
                    System.out.print("Nama  : ");
                    String nama = sc.nextLine();
                    System.out.print("Prodi : ");
                    String prodi = sc.nextLine();
                    System.out.print("Kelas : ");
                    String kelas = sc.nextLine();
                    MahasiswaKRS05 mhs = new MahasiswaKRS05(nim, nama, prodi, kelas);
                    antrian.tambahAntrian(mhs);
                    break;
                case 2:
                    antrian.panggilAntrian();
                    break;
                case 3:
                    antrian.tampilkanSemua();
                    break;
                case 4:
                    antrian.tampilkan2Terdepan();
                    break;
                case 5:
                    antrian.lihatAkhir();
                    break;
                case 6:
                    System.out.println("Antrian kosong? " + (antrian.isEmpty() ? "Ya" : "Tidak"));
                    break;
                case 7:
                    System.out.println("Antrian penuh? " + (antrian.isFull() ? "Ya" : "Tidak"));
                    break;
                case 8:
                    antrian.kosongkanAntrian();
                    break;
                case 9:
                    antrian.cetakJumlahAntrian();
                    break;
                case 10:
                    antrian.cetakJumlahDilayani();
                    break;
                case 11:
                    antrian.cetakBelumKRS();
                    break;
                case 0:
                    System.out.println("Terima kasih. Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        sc.close();
    }
}