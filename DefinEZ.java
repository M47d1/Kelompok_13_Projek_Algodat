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
class Stack {
    Node top;

    static class Node {
        TreeNode treeNode;
        Node next;

        Node(TreeNode treeNode) {
            this.treeNode = treeNode;
            this.next = null;
        }
    }

    public void push(TreeNode treeNode) {
        Node newNode = new Node(treeNode);
        newNode.next = top;
        top = newNode;
    }

    public TreeNode pop() {
        if (isEmpty()) {
            return null;
        }
        TreeNode treeNode = top.treeNode;
        top = top.next;
        return treeNode;
    }

    public boolean isEmpty() {
        return top == null;
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

        tambahKata("abadi", "Kekal, tidak berkesudahan", "Adjektiva");
        tambahKata("keabadian", "Keadaan atau sifat yang abadi; tidak pernah berakhir atau tidak dapat dihancurkan", "Nomina");
        tambahKata("Mengabdi", "Menunjukan tindakan berbakti atau melayani", "Verba");
        tambahKata("Mengabadikan", "Menunjukan tindakan membuat susuatu menjadi abadi", "Verba");
        tambahKata("Pengabdian", "Hasil atau proses dari mengabdi", "Nomina");
        tambahKata("seabadi", "Perbandingan kesamaan dalam hal abadi", "Adjektiva");
        tambahKata("Terabadikan", "sesuatu yang sudah diabadikan", "Verba");

        tambahKata("abnormal", "Tidak sesuai dengan keadaan biasa; mempunyai kelainan; tidak normal", "Adjektiva");
        tambahKata("keabnormalan", "Keadaan tidak normal", "Nomina");

        tambahKata("absolut", "tidak terbatas; mutlak; tanpa syarat; tidak dapat diragukan lagi; nyata; murni; bebas dari campuran", "Adjektiva");
        tambahKata("mengabsolutkan", "menjadikan absolut", "verba");
        tambahKata("pengabsolutan", "proses, cara, perbuatan mengabsolutkan", "Nomina");
        tambahKata("seabsolut", "Menunjukkan kesamaan tingkat absolut, atau sebanding dengan sifat absolut", "Adjektiva");

        tambahKata("adakala", "kadang-kadang; sekali-sekali; sekali waktu", "Adverbia");
        tambahKata("adakalanya", "Bentuk tidak baku ada kalanya", "Adverbia");

        tambahKata("akan", "Menunjukkan keadaan atau peristiwa yang akan terjadi di masa depan", "Adverbia");
        tambahKata("akan-akan", "Menunjukkan sesuatu yang seolah-olah akan terjadi atau seolah-olah seperti sesuatu", "Adverbia");
        tambahKata("berakan", "Tindakan atau keadaan yang menyebabkan sesuatu bergerak atau beranjak", "Verba");
        tambahKata("berseakan", "perilaku atau tindakan yang seolah-olah tampak atau terjadi", "Verba");
        tambahKata("keakanan", "Keadaan yang berhubungan dengan sesuatu yang bersifat atau berkaitan dengan dunia yang nyata atau aktual", "Nomina");
        tambahKata("keseakanan", "Keadaan yang berkaitan dengan kesan seakan-akan atau mirip dengan sesuatu yang nyata", "Nomina");
        tambahKata("mengakan", "Tindakan yang membuat sesuatu menjadi seakan-akan atau tampak seolah-olah", "Verba");
        tambahKata("mengakankan", "Tindakan yang menegaskan atau menyatakan sesuatu seolah-olah nyata atau pasti", "Verba");
        tambahKata("seakan-akan", "Menunjukkan keadaan yang tampak seperti sesuatu meskipun tidak benar-benar terjadi", "Adverbia");

        tambahKata("banget", "Kata penguat yang digunakan untuk menekankan suatu keadaan atau kualitas yang sangat", "Adverbia");
        tambahKata("kebangetan", "Keadaan yang berlebihan atau terlalu ekstrem dari sesuatu yang seharusnya", "Nomina");

        tambahKata("beli", "Mengambil barang dengan memberikan uang.", "Verba");
        tambahKata("membeli", "Melakukan tindakan membeli.", "Verba");
        tambahKata("pembeli", "Orang yang membeli sesuatu.", "Nomina");
        tambahKata("belian", "Barang atau hasil dari tindakan membeli.", "Nomina");

        tambahKata("bareng", "Bersama-sama atau dalam satu waktu yang sama", "Adverbia");
        tambahKata("berbareng", "Berada atau dilakukan bersama-sama, pada waktu yang sama", "Verba");
        tambahKata("berbarengan", "Dalam keadaan yang bersamaan atau dilakukan bersama-sama", "Adjektiva");
        tambahKata("membarengi", "Melakukan sesuatu bersama-sama dengan yang lain", "Verba");
        tambahKata("membarengkan", "Menyatukan atau mengatur agar terjadi bersama-sama", "Verba");

        tambahKata("canda", "Tindakan atau ucapan yang dimaksudkan untuk menghibur atau membuat orang tertawa, bercanda", "Adverbia");
        tambahKata("bercanda", "Melakukan aktivitas yang dimaksudkan untuk menghibur atau membuat orang tertawa", "Verba");
        tambahKata("candaan", "Ucapan atau tindakan yang bersifat canda atau lelucon", "Nomina");
        tambahKata("mencandai", "Melakukan tindakan bercanda atau menggoda dengan tujuan menghibur atau membuat orang tertawa", "Verba");

        tambahKata("culun", "Istilah yang digunakan untuk menggambarkan seseorang yang dianggap ketinggalan zaman; naif; tidak berpelngalaman", "Adjektiva");

        tambahKata("curam", "Menunjukkan keadaan yang sangat miring atau terjal, biasanya merujuk pada kemiringan permukaan", "Adjektiva");
        tambahKata("kecuraman", "Keadaan atau sifat yang curam, yaitu sangat terjal atau miring", "Nomina");
        tambahKata("mencuram", "Menjadikan sesuatu menjadi curam atau miring", "Verba");

        tambahKata("entah", "Menunjukkan ketidakpastian atau tidak tahu mengenai sesuatu", "Adverbia");
        tambahKata("entah-berentah", "Menunjukkan keadaan yang tidak jelas atau tidak teratur, sering digunakan untuk menyatakan kebingungan atau ketidakpastian", "Adverbia");


        tambahKata("makan", "Memasukkan makanan ke dalam tubuh untuk memperoleh energi.", "Verba");
        tambahKata("makanan", "Sesuatu yang dimakan untuk memperoleh energi.", "Nomina");
        tambahKata("memakan", "Melakukan tindakan makan.", "Verba");
        tambahKata("pemakan", "Orang atau makhluk yang melakukan tindakan makan.", "Nomina");

        tambahKata("minum", "Memasukkan cairan ke dalam tubuh melalui mulut.", "Verba");
        tambahKata("minuman", "Sesuatu yang diminum untuk menghilangkan rasa haus.", "Nomina");
        tambahKata("meminum", "Melakukan tindakan minum.", "Verba");

        tambahKata("belajar", "Proses memperoleh pengetahuan atau keterampilan.", "Verba");
        tambahKata("pelajar", "Orang yang belajar atau menuntut ilmu.", "Nomina");
        tambahKata("belajaran", "Hal yang dipelajari atau bahan pembelajaran.", "Nomina");

        tambahKata("kerja", "Melakukan tugas atau aktivitas untuk tujuan tertentu.", "Nomina");
        tambahKata("pekerja", "Orang yang bekerja atau melakukan tugas.", "Nomina");
        tambahKata("pekerjaan", "Hal atau aktivitas yang dilakukan untuk bekerja.", "Nomina");

        tambahKata("main", "Melakukan aktivitas rekreasi atau permainan.", "Verba");
        tambahKata("mainan", "Sesuatu yang dimainkan, biasanya untuk hiburan.", "Nomina");
        tambahKata("pemainan", "Proses atau cara bermain.", "Nomina");
    
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

        tambahKata("otomatis", "Berhubungan dengan sistem atau proses yang berjalan tanpa campur tangan manusia, bekerja secara sendiri", "Adjektiva");
        tambahKata("mengotomatiskan", "Proses atau tindakan menjadikan sesuatu menjadi otomatis, biasanya dengan menggunakan teknologi", "Verba");
        tambahKata("pengotomatisan", "Proses atau hasil dari mengotomatiskan sesuatu", "Nomina");

        tambahKata("penat", "Keadaan tubuh yang merasa lelah atau letih setelah melakukan aktivitas fisik", "Adjektiva");
        tambahKata("berpenat-penat", "Menunjukkan keadaan yang sangat lelah atau merasa penat karena aktivitas yang berat", "Verba");
        tambahKata("kepenatan", "Keadaan atau proses merasa lelah atau letih", "Nomina");

        tambahKata("vaksin", "Zat yang diberikan untuk meningkatkan daya tahan tubuh terhadap penyakit tertentu", "Nomina");
        tambahKata("memvaksin", "Memberikan vaksin kepada seseorang atau sesuatu", "Verba");
        tambahKata("pemvaksin", "Orang atau pihak yang memberikan vaksin", "Nomina");
        tambahKata("pemvaksinan", "Proses atau tindakan pemberian vaksin", "Nomina");
        tambahKata("tervaksin", "Sudah menerima vaksin", "Verba");

        tambahKata("zaman", "Periode atau waktu tertentu dalam sejarah atau kehidupan", "Nomina");
        tambahKata("menzaman", "Mengalami atau berada pada zaman atau periode tertentu", "Verba");
        tambahKata("zaman-berzaman", "Menunjukkan rentang waktu yang sangat panjang atau berulang kali melalui berbagai zaman", "Adverbia");
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
    public void displayKataTurunan(String kataInduk) {
        TreeNode node = cariKata(kataInduk);
        if (node != null) {
            System.out.println("[" + kataInduk + "]");
            System.out.print("kata turunan:\n" + kataInduk);
            cetakTurunan(node);
            System.out.println(); 
        } else {
            System.out.println("Kata induk tidak ditemukan.");
        }
    }
    private void cetakTurunan(TreeNode node) {
        LinkedList.Node current = node.subNode.head;
        while (current != null) {
            if (!current.treeNode.kata.isEmpty()) {
                System.out.print(" => " + current.treeNode.kata);
            }
            cetakTurunan(current.treeNode); 
            current = current.next;
        }
    }
    public void displayAscending() {
        Stack sortedStack = mergeSortStack(getAllNodes(root));
        while (!sortedStack.isEmpty()) {
            TreeNode node = sortedStack.pop();
            if (!node.kata.isEmpty()) {
                System.out.println(node.kata + " - " + node.definisi);
            }
        }
    }
    public void displayDescending() {
        Stack sortedStack = mergeSortStack(getAllNodes(root));
        Stack reverseStack = new Stack();
        while (!sortedStack.isEmpty()) {
            reverseStack.push(sortedStack.pop());
        }
        while (!reverseStack.isEmpty()) {
            TreeNode node = reverseStack.pop();
            if (!node.kata.isEmpty()) {
                System.out.println(node.kata + " - " + node.definisi);
            }
        }
    }
    private Stack getAllNodes(TreeNode node) {
        Stack stack = new Stack();
        traverseAndCollect(node, stack);
        return stack;
    }
    private void traverseAndCollect(TreeNode node, Stack stack) {
        if (node == null) {
            return;
        }
        if (!node.kata.isEmpty()) {
            stack.push(node);
        }
        LinkedList.Node current = node.subNode.head;
        while (current != null) {
            traverseAndCollect(current.treeNode, stack);
            current = current.next;
        }
    }
    private Stack mergeSortStack(Stack stack) {
        if (stack.isEmpty() || stack.top.next == null) {
            return stack;
        }

        Stack leftStack = new Stack();
        Stack rightStack = new Stack();

        splitStack(stack, leftStack, rightStack);

        leftStack = mergeSortStack(leftStack);
        rightStack = mergeSortStack(rightStack);

        return mergeStacks(leftStack, rightStack);
    }
    private void splitStack(Stack source, Stack left, Stack right) {
        Stack tempStack = new Stack();
        while (!source.isEmpty()) {
            tempStack.push(source.pop());
        }

        boolean toggle = true;
        while (!tempStack.isEmpty()) {
            if (toggle) {
                left.push(tempStack.pop());
            } else {
                right.push(tempStack.pop());
            }
            toggle = !toggle;
        }
    }
    private Stack mergeStacks(Stack left, Stack right) {
        Stack mergedStack = new Stack();
        Stack tempStack = new Stack();

        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.top.treeNode.kata.compareTo(right.top.treeNode.kata) <= 0) {
                tempStack.push(left.pop());
            } else {
                tempStack.push(right.pop());
            }
        }

        while (!left.isEmpty()) {
            tempStack.push(left.pop());
        }

        while (!right.isEmpty()) {
            tempStack.push(right.pop());
        }
        while (!tempStack.isEmpty()) {
            mergedStack.push(tempStack.pop());
        }
        return mergedStack;
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
                    kamus.displayKataTurunan(kataInduk);
                    break;
                case 4: 
                    System.out.println("Tampilkan Berdasarkan: ");
                    System.out.println("1. Ascending");
                    System.out.println("2. Descending");
                    System.out.println("Pilih: ");
                    int sort = scanner.nextInt();
                    scanner.nextLine();
                    if (sort == 1){
                        kamus.displayAscending();
                    } else if (sort == 2){
                        kamus.displayDescending();
                    } else {
                        System.out.println("Pilihan tidak valid!");
                    }
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