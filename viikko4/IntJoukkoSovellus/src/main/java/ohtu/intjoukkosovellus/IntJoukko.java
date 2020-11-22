package ohtu.intjoukkosovellus;

import java.util.Arrays;

public class IntJoukko {

    public final static int ALKUKOKO = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] joukonAlkiot;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        joukonAlustus(ALKUKOKO, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        joukonAlustus(kapasiteetti, OLETUSKASVATUS);

    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        joukonAlustus(kapasiteetti, kasvatuskoko);
    }

    private void joukonAlustus(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IllegalArgumentException("Kapasitteetti ei voi olla negatiivinen");
        }
        if (kasvatuskoko < 0) {
            throw new IllegalArgumentException("Kasvatuskoko ei voi olla negatiivinen");
        }
        joukonAlkiot = new int[kapasiteetti];
        Arrays.fill(joukonAlkiot, 0);
        
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {

        if (alkioidenLkm == 0) {
            joukonAlkiot[0] = luku;
            alkioidenLkm++;
            return true;
        }
        if (!lukuLoytyyJoukosta(luku)) {
            joukonAlkiot[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % joukonAlkiot.length == 0) {
                kasvataTaulua();
            }
            return true;
        }
        return false;
    }

    private void kasvataTaulua() {
        joukonAlkiot = Arrays.copyOf(joukonAlkiot, joukonAlkiot.length + kasvatuskoko);
    }

    public boolean lukuLoytyyJoukosta(int luku) {
        return luvunKohtaTaulukossa(luku) != -1;
    }

    public boolean poista(int luku) {
        int kohta = luvunKohtaTaulukossa(luku);
        if (kohta != -1) {
            joukonAlkiot[kohta] = 0;
            siirraLukujaYhdella(kohta);
            alkioidenLkm--;
            return true;
        }

        return false;
    }

    private void siirraLukujaYhdella(int kohta) {
        int apu;
        for (int j = kohta; j < alkioidenLkm - 1; j++) {
            apu = joukonAlkiot[j];
            joukonAlkiot[j] = joukonAlkiot[j + 1];
            joukonAlkiot[j + 1] = apu;
        }
    }

    private int luvunKohtaTaulukossa(int luku) {
        int kohta = -1;

        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == joukonAlkiot[i]) {
                kohta = i;
                break;
            }
        }

        return kohta;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        System.arraycopy(vanha, 0, uusi, 0, vanha.length);
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + joukonAlkiot[0] + "}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += joukonAlkiot[i];
                tuotos += ", ";
            }
            tuotos += joukonAlkiot[alkioidenLkm - 1];
            tuotos += "}";
            return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        System.arraycopy(joukonAlkiot, 0, taulu, 0, taulu.length);
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdisteJoukko = new IntJoukko();
        yhdisteJoukko = lisaaAlkioita(yhdisteJoukko, a);
        yhdisteJoukko = lisaaAlkioita(yhdisteJoukko, b);
        return yhdisteJoukko;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkausJoukko = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            if (b.lukuLoytyyJoukosta(aTaulu[i])) {
                leikkausJoukko.lisaa(aTaulu[i]);
            }
        }
        return leikkausJoukko;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko erotusJoukko = new IntJoukko();
        erotusJoukko = lisaaAlkioita(erotusJoukko, a);
        erotusJoukko = poistaAlkioita(erotusJoukko, b);

        return erotusJoukko;
    }

    private static IntJoukko lisaaAlkioita(IntJoukko johonLisataan, IntJoukko jostaLisataan) {
        int[] tauluJostaListaan = jostaLisataan.toIntArray();
        for (int i = 0; i < tauluJostaListaan.length; i++) {
            johonLisataan.lisaa(tauluJostaListaan[i]);
        }
        return johonLisataan;
    }

    private static IntJoukko poistaAlkioita(IntJoukko jostaPoistetaan, IntJoukko jotkaPoistetaan) {
        int[] tauluJotkaPoistetaan = jotkaPoistetaan.toIntArray();
        for (int i = 0; i < tauluJotkaPoistetaan.length; i++) {
            jostaPoistetaan.poista(tauluJotkaPoistetaan[i]);
        }
        return jostaPoistetaan;
    }
}
