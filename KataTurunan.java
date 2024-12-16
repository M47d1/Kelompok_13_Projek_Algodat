class KataTurunan {
    private Kamus kamus;

    public KataTurunan(Kamus kamus) {
        this.kamus = kamus;
    }

    public void tampilkanTurunanKata(String kataInduk) {
        TreeNode nodeInduk = kamus.cariKata(kataInduk);
        
        if (nodeInduk == null) {
            System.out.println("Kata induk tidak ditemukan: " + kataInduk);
            return;
        }

        System.out.println("Kata Turunan untuk '" + kataInduk + "':");
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
