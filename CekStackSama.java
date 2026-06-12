import java.util.Stack;

public class CekStackSama {

    public static boolean apakahStackSama(Stack<Integer> stack1, Stack<Integer> stack2) {
        // 1. Jika ukuran berbeda, otomatis tidak sama
        if (stack1.size() != stack2.size()) {
            return false;
        }

        // Stack sementara untuk menyimpan elemen agar stack asli tidak rusak
        Stack<Integer> temp1 = new Stack<>();
        Stack<Integer> temp2 = new Stack<>();
        
        boolean sama = true;

        // 2. Bandingkan elemen satu per satu dari atas (top)
        while (!stack1.isEmpty()) {
            int elemen1 = stack1.pop();
            int elemen2 = stack2.pop();

            // Simpan ke stack sementara
            temp1.push(elemen1);
            temp2.push(elemen2);

            // Jika ada elemen yang tidak cocok, set flag menjadi false
            if (elemen1 != elemen2) {
                sama = false;
                break; // Keluar dari loop lebih cepat
            }
        }

        // 3. Kembalikan elemen dari stack sementara ke stack asli
        while (!temp1.isEmpty()) {
            stack1.push(temp1.pop());
        }
        while (!temp2.isEmpty()) {
            stack2.push(temp2.pop());
        }

        return sama;
    }
    public static void main(String[] args) {
        // Inisialisasi Stack 1
        Stack<Integer> s1 = new Stack<>();
        s1.push(10);
        s1.push(20);
        s1.push(30);

        // Inisialisasi Stack 2 (Sama dengan Stack 1)
        Stack<Integer> s2 = new Stack<>();
        s2.push(10);
        s2.push(20);
        s2.push(30);

        // Inisialisasi Stack 3 (Beda isi/urutan)
        Stack<Integer> s3 = new Stack<>();
        s3.push(30);
        s3.push(20);
        s3.push(10);

        // Uji Coba Pengecekan
        System.out.println("Apakah Stack 1 sama dengan Stack 2? " + apakahStackSama(s1, s2)); // Output: true
        System.out.println("Apakah Stack 1 sama dengan Stack 3? " + apakahStackSama(s1, s3)); // Output: false
        
        // Memastikan stack asli tidak berubah/rusak setelah dicek
        System.out.println("Isi Stack 1 setelah pengecekan: " + s1); // Output: [10, 20, 30]
    }
}