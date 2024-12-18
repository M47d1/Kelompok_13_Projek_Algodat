import java.util.Scanner;

class TreeNode {
    String kata;
    String definisi;
    String kelasKata;
    LinkedList anak;
        public TreeNode kiri;
        public TreeNode kanan;
            
                TreeNode(String kata, String definisi, String kelasKata) {
                    this.kata = kata;
                    this.definisi = definisi;
                    this.kelasKata = kelasKata;
                    this.anak = new LinkedList();
                }
            
                TreeNode dapatkanAnak(char c) {
                    return anak.cariNode(c);
                }
            
                void tambahkanAnak(TreeNode anakBaru, char c) {
                    anak.tambahNode(c, anakBaru);
                }
            }
            
            class LinkedList {
                Node kepala;
            
                static class Node {
                    char karakter;
                    TreeNode treeNode;
                    Node berikut;
            
                    Node(char karakter, TreeNode treeNode) {
                        this.karakter = karakter;
                        this.treeNode = treeNode;
                        this.berikut = null;
                    }
                }
            
                public void tambahNode(char karakter, TreeNode treeNode) {
                    if (kepala == null) {
                        kepala = new Node(karakter, treeNode);
                    } else {
                        Node saatIni = kepala;
                        while (saatIni.berikut != null) {
                            saatIni = saatIni.berikut;
                        }
                        saatIni.berikut = new Node(karakter, treeNode);
                    }
                }
            
                public TreeNode cariNode(char karakter) {
                    Node saatIni = kepala;
                    while (saatIni != null) {
                        if (saatIni.karakter == karakter) {
                            return saatIni.treeNode;
                        }
                        saatIni = saatIni.berikut;
                    }
                    return null;
                }
            }
            
            class Kamus {
                private TreeNode root;
            
                Kamus() {
                    root = new TreeNode("", "", ""); // Node akar (kosong)
                    inisialisasiDataAwal(); // Panggil metode untuk inisialisasi data awal
                }
            
                public void tambahKata(String kata, String definisi, String kelasKata) {
                    TreeNode saatIni = root;
                    for (char c : kata.toCharArray()) {
                        if (saatIni.dapatkanAnak(c) == null) {
                            saatIni.tambahkanAnak(new TreeNode("", "", ""), c);
                        }
                        saatIni = saatIni.dapatkanAnak(c);
                    }
                    saatIni.kata = kata;
                    saatIni.definisi = definisi;
                    saatIni.kelasKata = kelasKata;
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
                    TreeNode saatIni = root;
                    for (char c : prefix.toCharArray()) {
                        if (saatIni.dapatkanAnak(c) == null) {
                            return null; // Prefix tidak ditemukan
                        }
                        saatIni = saatIni.dapatkanAnak(c);
                    }
                    return saatIni;
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
                    LinkedList.Node saatIni = node.anak.kepala;
                    while (saatIni != null) {
                        dfs(saatIni.treeNode, kata + saatIni.karakter);
                        saatIni = saatIni.berikut;
                    }
                }
                public void tampilkanKataBerdasarkanKelas(String kelasKata) {
                    tampilkanKataBerdasarkanKelasRekursif(root, kelasKata);
                }
                
                private void tampilkanKataBerdasarkanKelasRekursif(TreeNode node, String kelasKata) {
                    if (node == null) {
                        return;
                    }
                
                    // Pre-order traversal untuk menampilkan kata dengan kelas kata yang sesuai
                    if (node.kelasKata.equalsIgnoreCase(kelasKata)) {
                        System.out.println(node.kata + " - " + node.definisi);
                    }
                
                    tampilkanKataBerdasarkanKelasRekursif(node.kiri, kelasKata);
                tampilkanKataBerdasarkanKelasRekursif(node.kanan, kelasKata);
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
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");

            int pilihan = 0;
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid, mohon masukkan angka.");
                continue; // Kembali ke menu utama jika input salah
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
                    scanner.nextLine(); // Membersihkan newline
                    
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
                        kamus.tampilkanKataBerdasarkanKelas(kelasKata);
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
                    System.out.println("Keluar dari aplikasi. Terima kasih!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }
}