import java.util.Scanner;

class TreeNode {
    String kata;
    String definisi;
    String kelasKata;
    LinkedList anak;

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

    public void editKata(String kata, String definisiBaru) {
        TreeNode node = cariKata(kata);
        if (node == null || node.definisi.isEmpty()) {
            System.out.println("Kata tidak ditemukan: " + kata);
        } else {
            node.definisi = definisiBaru;
            System.out.println("Definisi kata " + kata + " berhasil diperbarui menjadi: " + definisiBaru);
        }
    }

    public void hapusKata(String kata) {
        TreeNode node = cariKata(kata);
        if (node == null || node.definisi.isEmpty()) {
            System.out.println("Kata tidak ditemukan: " + kata);
            return;
        }
        node.definisi = "";
        node.kelasKata = "";
        node.anak = new LinkedList(); // Menghapus semua anak
        System.out.println("Kata berhasil dihapus: " + kata);
    }

    public void tampilkanAbjad() {
        System.out.println("Kata-kata dalam urutan abjad:");
        dfs(root, "");
    }
}

public class DefinEZ {
    private static Scanner scanner = new Scanner(System.in);
    private static Kamus kamus = new Kamus();

    private static boolean loginAdmin() {
        System.out.print("Masukkan username admin: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password admin: ");
        String password = scanner.nextLine();

        // Cek username dan password admin (contoh: admin, admin123)
        return username.equals("admin") && password.equals("admin123");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Menu DefinEZ ===");
            System.out.println("1. Masuk Sebagai Admin");
            System.out.println("2. Cari Kata (Pengguna)");
            System.out.println("3. Kelas Kata");
            System.out.println("4. Turunan Kata");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");

            int pilihan = 0;
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid, mohon masukkan angka.");
                continue; // Kembali ke menu utama jika input salah
            }

            if (pilihan == 1) {
                if (loginAdmin()) {
                    boolean keluarAdmin = false;
                    while (!keluarAdmin) {
                        System.out.println("\n=== Menu Admin ===");
                        System.out.println("1. Tambah Kata");
                        System.out.println("2. Edit Kata");
                        System.out.println("3. Hapus Kata");
                        System.out.println("4. Tampilkan Kata Secara Abjad");
                        System.out.println("5. Keluar Admin");
                        System.out.print("Pilih opsi: ");

                        int opsiAdmin = 0;
                        try {
                            opsiAdmin = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Input tidak valid, mohon masukkan angka.");
                            continue;
                        }

                        switch (opsiAdmin) {
                            case 1:
                                System.out.print("Masukkan kata: ");
                                String kata = scanner.nextLine();
                                System.out.print("Masukkan definisi: ");
                                String definisi = scanner.nextLine();
                                System.out.print("Masukkan kelas kata (nomina, verba, adjektiva, adverbia): ");
                                String kelasKata = scanner.nextLine();
                                kamus.tambahKata(kata, definisi, kelasKata);
                                break;
                            case 2:
                                System.out.print("Masukkan kata yang ingin diubah: ");
                                String kataEdit = scanner.nextLine();
                                System.out.print("Masukkan definisi baru: ");
                                String definisiBaru = scanner.nextLine();
                                kamus.editKata(kataEdit, definisiBaru);
                                break;
                            case 3:
                                System.out.print("Masukkan kata yang ingin dihapus: ");
                                String kataHapus = scanner.nextLine();
                                kamus.hapusKata(kataHapus);
                                break;
                            case 4:
                                kamus.tampilkanAbjad();
                                break;
                            case 5:
                                keluarAdmin = true;
                                break;
                            default:
                                System.out.println("Pilihan tidak valid. Coba lagi.");
                        }
                    }
                } else {
                    System.out.println("Login gagal. Coba lagi.");
                }
            } else if (pilihan == 2) {
                System.out.print("Masukkan awalan untuk mencari: ");
                String awalan = scanner.nextLine();
                kamus.cariDanTampilkanKata(awalan);
            } else if (pilihan == 3) {
                System.out.println("Keluar dari DefinEZ. Sampai jumpa!");
                break;
            } else {
                System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }
}
