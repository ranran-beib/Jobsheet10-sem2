public class AntrianKRS05 {
    private MahasiswaKRS05[] data;
    private int front;
    private int rear;
    private int size;
    private int max;
    private int totalDilayani;
    private int maxPerDPA;

    public AntrianKRS05(int max) {
        this.max = max;
        this.data = new MahasiswaKRS05[max];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
        this.totalDilayani = 0;
        this.maxPerDPA = 30;
    }

    // Cek antrian kosong
    public boolean isEmpty() {
        return size == 0;
    }

    // Cek antrian penuh
    public boolean isFull() {
        return size == max;
    }

    // Mengosongkan antrian
    public void kosongkanAntrian() {
        if (!isEmpty()) {
            front = 0;
            rear = -1;
            size = 0;
            System.out.println("Antrian berhasil dikosongkan.");
        } else {
            System.out.println("Antrian sudah kosong.");
        }
    }

    // Menambahkan antrian
    public void tambahAntrian(MahasiswaKRS05 mhs) {
        if (isFull()) {
            System.out.println("Antrian penuh! Tidak dapat menambah mahasiswa.");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = mhs;
        size++;
        System.out.println(mhs.nama + " (NIM: " + mhs.nim + ") berhasil masuk ke antrian KRS.");
    }

    // Memanggil antrian untuk proses KRS - setiap 1x panggilan = 2 mahasiswa
    public void panggilAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak ada mahasiswa yang dipanggil.");
            return;
        }
        if (totalDilayani >= maxPerDPA) {
            System.out.println("DPA sudah mencapai batas maksimal (" + maxPerDPA + " mahasiswa). Sesi selesai.");
            return;
        }

        System.out.println("=== Memanggil 2 Mahasiswa untuk Proses KRS ===");
        int jumlahDipanggil = 0;
        for (int i = 0; i < 2; i++) {
            if (!isEmpty() && totalDilayani < maxPerDPA) {
                MahasiswaKRS05 mhs = data[front];
                front = (front + 1) % max;
                size--;
                totalDilayani++;
                jumlahDipanggil++;
                System.out.print("  Dipanggil [" + jumlahDipanggil + "]: ");
                mhs.tampilkanData();
            }
        }
        System.out.println("Total mahasiswa telah diproses KRS: " + totalDilayani);
    }

    // Menampilkan semua antrian
    public void tampilkanSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("--- Daftar Antrian KRS ---");
        System.out.println("NO  | NIM - NAMA - PRODI - KELAS");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ".  ");
            data[index].tampilkanData();
        }
        System.out.println("Total antrian: " + size);
    }

    // Menampilkan 2 antrian terdepan
    public void tampilkan2Terdepan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("--- 2 Mahasiswa Terdepan dalam Antrian KRS ---");
        System.out.println("NIM - NAMA - PRODI - KELAS");
        int tampil = Math.min(2, size);
        for (int i = 0; i < tampil; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }

    // Menampilkan antrian paling akhir
    public void lihatAkhir() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Mahasiswa paling belakang dalam antrian:");
            data[rear].tampilkanData();
        }
    }

    // Cetak jumlah antrian
    public void cetakJumlahAntrian() {
        System.out.println("Jumlah mahasiswa dalam antrian saat ini: " + size);
    }

    // Cetak jumlah yang sudah melakukan proses KRS
    public void cetakJumlahDilayani() {
        System.out.println("Jumlah mahasiswa yang sudah proses KRS: " + totalDilayani);
    }

    // Cetak jumlah mahasiswa yang belum melakukan proses KRS (yang masih di antrian)
    public void cetakBelumKRS() {
        System.out.println("Jumlah mahasiswa yang belum proses KRS: " + size);
        System.out.println("Sisa kuota DPA: " + (maxPerDPA - totalDilayani) + " mahasiswa");
    }
}