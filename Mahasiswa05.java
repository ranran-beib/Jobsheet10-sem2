public class Mahasiswa05 {
    String nim;
    String nama;
    String prodi;
    String kelas;
 
    public Mahasiswa05(String nim, String nama, String prodi, String kelas) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.kelas = kelas;
    }
 
    public void tampilkanData() {
        System.out.println(nim + " - " + nama + " - " + prodi + " - " + kelas);
    }
}