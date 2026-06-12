import java.util.Scanner;

public class MenuMakanan {
    public static void main(String[] args) {
        // 1. Inisialisasi data menu menggunakan array
        String[] menu = {"Soto", "Rawon", "Pecel", "Bakso", "Siomay"};
        int[] harga = {15000, 20000, 10000, 12500, 25000};

        Scanner input = new Scanner(System.in);
        String pilihanKembali;

        // Perulangan DO-WHILE agar program terus berjalan selama user memilih 'Y'
        do {
            // 2. Menerima input dari pengguna
            System.out.print("\nIsikan Makanan yang dipesan : ");
            String inputPesanan = input.nextLine();

            System.out.println("\nOutput :");
            System.out.println("Total Harga :");

            // Memisahkan input berdasarkan spasi
            String[] token = inputPesanan.split(" ");
            int totalKeseluruhan = 0;

            // 3. Memproses input (melompat per 2 langkah)
            for (int i = 0; i < token.length; i += 2) {
                String namaMakananDipesan = token[i];
                
                // Proteksi jika user lupa memasukkan angka porsi
                if (i + 1 >= token.length) {
                    System.out.println("  ⚠️ Error: Jumlah porsi untuk '" + namaMakananDipesan + "' belum diisi!");
                    break;
                }

                int jumlahPorsi = Integer.parseInt(token[i + 1]);

                // Mencari indeks makanan di dalam array menu
                int indeksMenu = -1;
                for (int j = 0; j < menu.length; j++) {
                    if (menu[j].equalsIgnoreCase(namaMakananDipesan)) {
                        indeksMenu = j;
                        break;
                    }
                }

                // Jika makanan ditemukan di dalam menu, hitung subtotalnya
                if (indeksMenu != -1) {
                    int hargaSatuan = harga[indeksMenu];
                    int subTotal = hargaSatuan * jumlahPorsi;
                    totalKeseluruhan += subTotal;

                    // Cetak baris rincian sesuai format soal
                    System.out.println("  v " + menu[indeksMenu] + " @" + hargaSatuan + " * " + jumlahPorsi + " = " + subTotal);
                }
            }

            // 4. Cetak total keseluruhan
            System.out.println("Total = " + totalKeseluruhan);
            
            // 5. Fitur Pilihan Kembali
            System.out.print("\nApakah ingin memesan lagi? (y/n) : ");
            pilihanKembali = input.nextLine();

        } while (pilihanKembali.equalsIgnoreCase("y")); // Jika diketik 'y' atau 'Y', program otomatis mengulang dari atas

        System.out.println("\nTerima kasih telah menggunakan program ini!");
        input.close();
    }
}