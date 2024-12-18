import java.util.Scanner;

class TreeNode {
    String kata;
    String definisi;
    String kelasKata;
    LinkedList subNode;
    public TreeNode kiri;
    public TreeNode kanan;
            
    TreeNode(String kata, String definisi, String kelasKata) {
        this.kata = kata;
        this.definisi = definisi;
        this.kelasKata = kelasKata;
        this.subNode = new LinkedList();
    }
            
    TreeNode dapatkanAnak(char c) {
        return subNode.cariNode(c);
    }
            
    void tambahkanAnak(TreeNode newNode, char c) {
        subNode.tambahNode(c, newNode);
    }
} 
class LinkedList {
    Node head;        
    static class Node {
        char karakter;
        TreeNode treeNode;
        Node next;
            
        Node(char karakter, TreeNode treeNode) {
            this.karakter = karakter;
            this.treeNode = treeNode;
            this.next= null;
        }
    }
    public void tambahNode(char karakter, TreeNode treeNode) {
        if (head == null) {
            head = new Node(karakter, treeNode);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(karakter, treeNode);
        }
    }
    public TreeNode cariNode(char karakter) {
        Node temp = head;
        while (temp != null) {
            if (temp.karakter == karakter) {
                return temp.treeNode;
            }
            temp = temp.next;
        }
        return null;
    }
}
            
class Kamus {
    private TreeNode root;

    Kamus() {
        root = new TreeNode("", "", "");
        inisialisasiDataAwal();
    }
    public void tambahKata(String kata, String definisi, String kelasKata) {
        TreeNode current = root;
        for (char c : kata.toCharArray()) {
            if (current.dapatkanAnak(c) == null) {
                current.tambahkanAnak(new TreeNode("", "", ""), c);
            }
            current = current.dapatkanAnak(c);
        }
        current.kata = kata;
        current.definisi = definisi;
        current.kelasKata = kelasKata;
    }

    private void inisialisasiDataAwal() {
        tambahKata("makan", "Memasukkan makanan ke dalam tubuh untuk memperoleh energi.", "Verba");
        tambahKata("minum", "Memasukkan cairan ke dalam tubuh melalui mulut.", "Verba");
        tambahKata("belajar", "Proses memperoleh pengetahuan atau keterampilan.", "Verba");
        tambahKata("kerja", "Melakukan tugas atau aktivitas untuk tujuan tertentu.", "Nomina");
        tambahKata("main", "Melakukan aktivitas rekreasi atau permainan.", "Verba");
        
        // Tambahkan kata turunan untuk setiap kata dasar
        tambahKata("makanan", "Sesuatu yang dimakan untuk memperoleh energi.", "Nomina");
        tambahKata("memakan", "Melakukan tindakan makan.", "Verba");
        tambahKata("pemakan", "Orang atau makhluk yang melakukan tindakan makan.", "Nomina");
    
        tambahKata("minuman", "Sesuatu yang diminum untuk menghilangkan rasa haus.", "Nomina");
        tambahKata("meminum", "Melakukan tindakan minum.", "Verba");
    
        tambahKata("pelajar", "Orang yang belajar atau menuntut ilmu.", "Nomina");
        tambahKata("belajaran", "Hal yang dipelajari atau bahan pembelajaran.", "Nomina");
    
        tambahKata("pekerja", "Orang yang bekerja atau melakukan tugas.", "Nomina");
        tambahKata("pekerjaan", "Hal atau aktivitas yang dilakukan untuk bekerja.", "Nomina");
    
        tambahKata("mainan", "Sesuatu yang dimainkan, biasanya untuk hiburan.", "Nomina");
        tambahKata("pemainan", "Proses atau cara bermain.", "Nomina");
    
        // Tambahan kata baru
        tambahKata("lari", "Bergerak cepat dengan menggunakan kaki.", "Verba");
        tambahKata("berlari", "Melakukan tindakan lari.", "Verba");
        tambahKata("pelari", "Orang yang melakukan lari, biasanya dalam olahraga.", "Nomina");
        tambahKata("pelarian", "Proses atau tindakan lari untuk menghindar.", "Nomina");
    
        tambahKata("baca", "Melihat dan memahami isi tulisan.", "Verba");
        tambahKata("membaca", "Melakukan tindakan membaca.", "Verba");
        tambahKata("pembaca", "Orang yang membaca atau melihat tulisan.", "Nomina");
        tambahKata("bacaan", "Hal yang dibaca atau bahan bacaan.", "Nomina");
    
        tambahKata("tulis", "Membuat tulisan atau simbol dengan alat tulis.", "Verba");
        tambahKata("menulis", "Melakukan tindakan menulis.", "Verba");
        tambahKata("penulis", "Orang yang menulis, biasanya untuk menghasilkan karya.", "Nomina");
        tambahKata("tulisan", "Hasil dari tindakan menulis.", "Nomina");
    
        tambahKata("lihat", "Memperhatikan sesuatu dengan mata.", "Verba");
        tambahKata("melihat", "Melakukan tindakan melihat.", "Verba");
        tambahKata("penglihat", "Orang atau alat yang digunakan untuk melihat.", "Nomina");
        tambahKata("penglihatan", "Proses atau hasil melihat sesuatu.", "Nomina");
    
        tambahKata("dengar", "Menerima suara melalui telinga.", "Verba");
        tambahKata("mendengar", "Melakukan tindakan mendengar.", "Verba");
        tambahKata("pendengar", "Orang yang mendengarkan sesuatu.", "Nomina");
        tambahKata("pendengaran", "Kemampuan atau proses mendengar suara.", "Nomina");
    
        tambahKata("tanya", "Mengajukan pertanyaan untuk memperoleh jawaban.", "Verba");
        tambahKata("bertanya", "Melakukan tindakan bertanya.", "Verba");
        tambahKata("penanya", "Orang yang mengajukan pertanyaan.", "Nomina");
        tambahKata("pertanyaan", "Hal atau pernyataan yang diajukan untuk dijawab.", "Nomina");
    
        tambahKata("jawab", "Memberikan balasan atas pertanyaan.", "Verba");
        tambahKata("menjawab", "Melakukan tindakan menjawab.", "Verba");
        tambahKata("penjawab", "Orang yang memberikan jawaban.", "Nomina");
        tambahKata("jawaban", "Hasil atau isi dari tindakan menjawab.", "Nomina");
    
        tambahKata("buat", "Menghasilkan sesuatu melalui usaha atau pekerjaan.", "Verba");
        tambahKata("membuat", "Melakukan tindakan membuat.", "Verba");
        tambahKata("pembuat", "Orang yang menghasilkan sesuatu.", "Nomina");
        tambahKata("buatan", "Hasil dari tindakan membuat.", "Nomina");
    
        tambahKata("jual", "Menawarkan barang untuk ditukar dengan uang.", "Verba");
        tambahKata("menjual", "Melakukan tindakan menjual.", "Verba");
        tambahKata("penjual", "Orang yang menawarkan barang untuk dijual.", "Nomina");
        tambahKata("jualan", "Barang atau produk yang dijual.", "Nomina");
    
        tambahKata("beli", "Mengambil barang dengan memberikan uang.", "Verba");
        tambahKata("membeli", "Melakukan tindakan membeli.", "Verba");
        tambahKata("pembeli", "Orang yang membeli sesuatu.", "Nomina");
        tambahKata("belian", "Barang atau hasil dari tindakan membeli.", "Nomina");
    }
    public TreeNode cariKata(String prefix) {
        TreeNode current = root;
        for (char c : prefix.toCharArray()) {
            if (current.dapatkanAnak(c) == null) {
                return null;
            }
            current = current.dapatkanAnak(c);
        }
        return current;
    }

    public void cariDanTampilkanKata(String prefix) {
        TreeNode node = cariKata(prefix);
        if (node == null) {
            System.out.println("Tidak ada kata dengan awalan: " + prefix);
            return;
        }
        System.out.println("Kata-kata yang dimulai dengan '" + prefix + "':");
        dfs(node, prefix);
    }

    private void dfs(TreeNode node, String kata) {
        if (!node.definisi.isEmpty()) {
            System.out.println(node.kata + " - " + node.definisi + " (" + node.kelasKata + ")");
        }
        LinkedList.Node current = node.subNode.head;
        while (current != null) {
            dfs(current.treeNode, kata + current.karakter);
            current = current.next;
        }
    }
    public void displayKelaskata(String kelasKata) {
        displayKlsrekursif(root, kelasKata);
    }
    
    private void displayKlsrekursif(TreeNode node, String kelasKata) {
        if (node == null) {
            return;
        }
        if (node.kelasKata.equalsIgnoreCase(kelasKata) && !node.kata.isEmpty()) {
            System.out.println(node.kata + " - " + node.definisi);
        }
        LinkedList.Node anak = node.subNode.head;
        while (anak != null){
            displayKlsrekursif(anak.treeNode, kelasKata);
            anak = anak.next;
        }
    }    
    public void displayKataTurunan(String kataInduk){
        TreeNode node = cariKata(kataInduk);
        if(node != null){
            System.out.println("[" + kataInduk + "]");
            LinkedList.Node current = node.subNode.head;
            System.out.println("Kata turunan: ");
            while(current != null){
                System.out.println(current.treeNode.kata + " => ");
                current = current.next;
            }
        } else {
            System.out.println("Kata induk tidak ditemukan.");
        }
    }
    public void displaySemuaData(boolean ascending){
        LinkedList<String> data = new LinkedList<>();
        listData(root, data);
        if(ascending){
            sortAscending(data);
        } else {
            sortDescending(data);
        }
        for (String kata : data){
            TreeNode node = cariKata(kata);
            System.out.println(kata + " - " + node.definisi + " (" + node.kelasKata + ")");
        }
    }
    private void listData(TreeNode node, LinkedList<String> listData){
        if(node == null) return;
        if(!nod.kata.isEmpty()){
            listData.tambahNode(node.kata.charAt(0), new TreeNode(node.kata, node.definisi, node.kelasKata));
        }
        LinkedList.Node anak = node.subNode.head;
        while (anak!= null){
            listData(anak.treeNode, data);
            anak = anak.next;
        }
    }
    private void urutkanAscending(LinkedList<String> daftarKata) {
        for (int i = 0; i < daftarKata.size() - 1; i++) {
            for (int j = 0; j < daftarKata.size() - i - 1; j++) {
                if (daftarKata.get(j).compareTo(daftarKata.get(j + 1)) > 0) {
                    String temp = daftarKata.get(j);
                    daftarKata.set(j, daftarKata.get(j + 1));
                    daftarKata.set(j + 1, temp);
                }
            }
        }
    }
    private void urutkanDescending(LinkedList<String> daftarKata) {
        for (int i = 0; i < daftarKata.size() - 1; i++) {
            for (int j = 0; j < daftarKata.size() - i - 1; j++) {
                if (daftarKata.get(j).compareTo(daftarKata.get(j + 1)) < 0) {
                    String temp = daftarKata.get(j);
                    daftarKata.set(j, daftarKata.get(j + 1));
                    daftarKata.set(j + 1, temp);
                }
            }
        }
    }
}
public class DefinEZ {
    private static Scanner scanner = new Scanner(System.in);
    private static Kamus kamus = new Kamus();

    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        while (true) {
            System.out.println(RED + 
            "  _____        __ _       ______ ______\n" +
            " |  __ \\      / _(_)     |  ____|___  /\n" +
            " | |  | | ___| |_ _ _ __ | |__     / / \n" +
            " | |  | |/ _ \\  _| | '_ \\|  __|   / /  \n" +
            " | |__| |  __/ | | | | | | |____ / /__ \n" +
            " |_____/ \\___|_| |_|_| |_|______/_____|\n" +
            "                                       " + RESET);
            System.out.println(RED + "------------Welcome to DefinEZ!-----------" + RESET);
            System.out.println("1. Cari Kata");
            System.out.println("2. Tampilkan Berdasarkan Kelas Kata");
            System.out.println("3. Turunan Kata");
            System.out.println("4. Tampilkan semua kata");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");

            int pilihan = 0;
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid, mohon masukkan angka.");
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Cari kata: ");
                    String awalan = scanner.nextLine();
                    kamus.cariDanTampilkanKata(awalan);
                    break;
                case 2:
                    System.out.println("Pilih kelas kata: ");
                    System.out.println("1. Nomina");
                    System.out.println("2. Verba");
                    System.out.println("3. Adjektiva");
                    System.out.println("4. Adverbia");
                    System.out.print("Pilih = ");
                    
                    int pilihanKelasKata = scanner.nextInt();
                    scanner.nextLine(); 
                    
                    String kelasKata = "";
                    switch (pilihanKelasKata) {
                        case 1:
                            kelasKata = "Nomina";
                            break;
                        case 2:
                            kelasKata = "Verba";
                            break;
                        case 3:
                            kelasKata = "Adjektiva";
                            break;
                        case 4:
                            kelasKata = "Adverbia";
                            break;
                        default:
                            System.out.println("Pilihan tidak valid!");
                            break;
                    }

                    if (!kelasKata.isEmpty()) {
                        System.out.println("kelas kata " + kelasKata + ":");
                        kamus.displayKelaskata(kelasKata);
                    }
                    break;
                case 3:
                    System.out.print("Masukkan kata induk untuk mencari turunannya: ");
                    String kataInduk = scanner.nextLine();
                    // Buat objek KataTurunan dengan referensi ke objek Kamus
                    KataTurunan kataTurunan = new KataTurunan(kamus);
                    // Panggil method tampilkanTurunanKata untuk menampilkan hasil
                    kataTurunan.tampilkanTurunanKata(kataInduk);
                    break;
                case 4: 
                    System.out.println("Tampilkan Berdasarkan: ");
                    System.out.println("1. Ascending");
                    System.out.println("2. Descending");
                    System.out.println("Pilih: ");
                    int sort = scanner.nextInt();
                    scanner.nextLine();
                    boolean ascending = sort == 1;
                    kamus.displaySemuaData(ascending);
                    break;
                case 5:
                    System.out.println("Keluar dari aplikasi. Terima kasih!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }
}