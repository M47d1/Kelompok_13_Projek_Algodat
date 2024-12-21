// Node untuk LinkedList
class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

// Implementasi LinkedList
class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void add(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public String remove() {
        if (head == null) {
            return null;
        }
        String data = head.data;
        head = head.next;
        return data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
    }
}

// Implementasi Queue dengan LinkedList
class Queue {
    LinkedList list;

    public Queue() {
        this.list = new LinkedList();
    }

    public void offer(String data) {
        list.add(data);
    }

    public String poll() {
        return list.remove();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}

// Implementasi Stack dengan LinkedList
class Stack {
    LinkedList list;

    public Stack() {
        this.list = new LinkedList();
    }

    public void push(String data) {
        Node newNode = new Node(data);
        newNode.next = list.head;
        list.head = newNode;
    }

    public String pop() {
        return list.remove();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}

// Implementasi KataTurunan
class KataTurunan {
    private Kamus kamus;
    private Queue imbuhanQueue;
    private Stack turunanStack;

    // Konstruktor
    public KataTurunan(Kamus kamus) {
        this.kamus = kamus;
        this.imbuhanQueue = new Queue();
        this.turunanStack = new Stack();
        initializeImbuhan();
    }

    // Inisialisasi imbuhan (awalan dan akhiran)
    private void initializeImbuhan() {
        imbuhanQueue.offer("me");
        imbuhanQueue.offer("ber");
        imbuhanQueue.offer("di");
        imbuhanQueue.offer("ter");
        imbuhanQueue.offer("pe");
        imbuhanQueue.offer("kan");
        imbuhanQueue.offer("i");
        imbuhanQueue.offer("an");
    }

    // Method untuk menampilkan turunan kata
    public void tampilkanTurunanKata(String kataInduk) {
        TreeNode nodeInduk = kamus.cariKata(kataInduk);

        if (nodeInduk == null || nodeInduk.definisi.isEmpty()) {
            System.out.println("Kata induk tidak ditemukan: " + kataInduk);
            return;
        }

        // Tampilkan informasi kata induk
        tampilkanInformasiKataInduk(kataInduk, nodeInduk);

        // Proses pembentukan kata turunan
        prosesKataTurunan(kataInduk);

        // Tampilkan semua kata turunan yang ditemukan
        tampilkanHasilTurunan();
    }

    // Method untuk menampilkan informasi kata induk
    private void tampilkanInformasiKataInduk(String kataInduk, TreeNode nodeInduk) {
        System.out.println("\n=== Turunan Kata dari '" + kataInduk + "' ===");
        System.out.println("Kata Dasar: " + kataInduk + " (" + nodeInduk.kelasKata + ")");
        System.out.println("Definisi: " + nodeInduk.definisi);
        System.out.println("\nTurunan kata yang ditemukan:");
    }

    // Method untuk memproses pembentukan kata turunan
    private void prosesKataTurunan(String kataInduk) {
        // Salin queue imbuhan untuk digunakan
        Queue tempQueue = new Queue();
        while (!imbuhanQueue.isEmpty()) {
            String imbuhan = imbuhanQueue.poll();
            tempQueue.offer(imbuhan);

            // Coba sebagai awalan
            cekDanTambahKeTurunan(imbuhan + kataInduk);

            // Coba sebagai akhiran
            cekDanTambahKeTurunan(kataInduk + imbuhan);

            // Coba kombinasi dengan imbuhan lain
            Queue kombinasiQueue = new Queue();
            while (!imbuhanQueue.isEmpty()) {
                String imbuhan2 = imbuhanQueue.poll();
                kombinasiQueue.offer(imbuhan2);
                cekDanTambahKeTurunan(imbuhan + kataInduk + imbuhan2);
            }

            // Kembalikan isi imbuhanQueue
            while (!kombinasiQueue.isEmpty()) {
                imbuhanQueue.offer(kombinasiQueue.poll());
            }
        }

        // Kembalikan isi imbuhanQueue
        while (!tempQueue.isEmpty()) {
            imbuhanQueue.offer(tempQueue.poll());
        }
    }

    // Method untuk memeriksa dan menambahkan kata turunan yang valid
    private void cekDanTambahKeTurunan(String kataTurunan) {
        TreeNode node = kamus.cariKata(kataTurunan);
        if (node != null && !node.definisi.isEmpty()) {
            turunanStack.push(kataTurunan + " (" + node.kelasKata + ")\n  Definisi: " + node.definisi);
        }
    }

    // Method untuk menampilkan hasil kata turunan
    private void tampilkanHasilTurunan() {
        if (turunanStack.isEmpty()) {
            System.out.println("Tidak ditemukan kata turunan.");
            return;
        }

        while (!turunanStack.isEmpty()) {
            System.out.println("- " + turunanStack.pop());
        }
    }
}
