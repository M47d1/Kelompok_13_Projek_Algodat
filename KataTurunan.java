class KataTurunan {
    //referensi ke kamus, ntar buat nyari kata
    private Kamus kamus;

    //ini konstruktornya, objek kamus yang ntar dipake buat nyari kata
    public KataTurunan(Kamus kamus) {
        this.kamus = kamus;
    }

    //method buat nampilin kata turunan
    public void tampilkanTurunanKata(String kataInduk) {
        //cari node kata induk yang dimaksud di kamus
        TreeNode nodeInduk = kamus.cariKata(kataInduk);

        //kalo kata induk gaada di kamus, pesan error
        if (nodeInduk == null) {
            System.out.println("Kata induk tidak ditemukan: " + kataInduk);
            return;
        }

        //kalo kata induk ada di kamus
        System.out.println("Kata Turunan untuk '" + kataInduk + "':");
        //imbuhan buat kata turunan
        String[] akhiran = {"-an", "-kan", "me-", "pe-"};
        for (String akhir : akhiran) {
            String kataTurunan = generateTurunanKata(kataInduk, akhir);
            TreeNode nodeTurunan = kamus.cariKata(kataTurunan);
            
            if (nodeTurunan != null && !nodeTurunan.definisi.isEmpty()) {
                System.out.println(kataTurunan + " - " + nodeTurunan.definisi + " (" + nodeTurunan.kelasKata + ")");
            }
        }
    }

    private String generateTurunanKata(String kataInduk, String akhiran) {
        if (akhiran.startsWith("-")) {
            return kataInduk + akhiran.substring(1);
        } else if (akhiran.endsWith("-")) {
            return akhiran.substring(0, akhiran.length() - 1) + kataInduk;
        }
        return kataInduk;
    }
}
