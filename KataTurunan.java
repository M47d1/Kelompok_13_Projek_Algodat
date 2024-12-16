class KataTurunan {
    private Kamus kamus;

    public KataTurunan(Kamus kamus) {
        this.kamus = kamus;
    }

    public void tampilkanTurunanKata(String kataInduk) {
        // mencari kata induk dari kamus
        TreeNode rootWordNode = kamus.cariKata(kataInduk);

        if (rootWordNode != null) {
            // Menampilkan turunan kata beserta kelas kata
            System.out.println("Turunan dari kata: " + kataInduk);
            LinkedList.Node saatIni = rootWordNode.anak.kepala;
            while (saatIni != null) {
                TreeNode anakNode = saatIni.treeNode;
                if (!anakNode.kata.isEmpty()) {
                    System.out.println(anakNode.kata + anakNode.definisi + anakNode.kelasKata);
                }
                saatIni = saatIni.berikut;
            }
        } else {
            System.out.println("Kata induk tidak ditemukan!");
        }
    }
}