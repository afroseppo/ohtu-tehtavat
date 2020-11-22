package ohtu.intjoukkosovellus;

import java.util.Scanner;

public class Sovellus {

    private static IntJoukko A, B, C;

    private static IntJoukko mikaJoukko(Scanner lukija) {
        String luettu;
        luettu = lukija.nextLine();
        while (true) {
            if (luettu.equals("A") || luettu.equals("a")) {
                return A;
            } else if (luettu.equals("B") || luettu.equals("b")) {
                return B;
            } else if (luettu.equals("C") || luettu.equals("c")) {
                return C;
            } else {
                System.out.println("Virheellinen joukko! " + luettu);
                System.out.print("Yritä uudelleen!");
                luettu = lukija.nextLine();
            }
        }
    }

    private static void lisaa(Scanner lukija) {
        System.out.print("Mihin joukkoon? ");
        IntJoukko joukko = mikaJoukko(lukija);
        System.out.println("");
        System.out.print("Mikä luku lisätään? ");
        int lisattavaLuku = lukija.nextInt();
        joukko.lisaa(lisattavaLuku);
    }

    private static void yhdiste(Scanner lukija) {
        System.out.print("1. joukko? ");
        IntJoukko aJoukko = mikaJoukko(lukija);
        System.out.print("2. joukko? ");
        IntJoukko bJoukko = mikaJoukko(lukija);
        IntJoukko yhdisteJoukko = IntJoukko.yhdiste(aJoukko, bJoukko);
        System.out.println("A yhdiste B = " + yhdisteJoukko.toString());
    }

    private static void leikkaus(Scanner lukija) {
        System.out.print("1. joukko? ");
        IntJoukko aJoukko = mikaJoukko(lukija);
        System.out.print("2. joukko? ");
        IntJoukko bJoukko = mikaJoukko(lukija);
        IntJoukko leikkausJoukko = IntJoukko.leikkaus(aJoukko, bJoukko);
        System.out.println("A leikkaus B = " + leikkausJoukko.toString());
    }

    private static void erotus(Scanner lukija) {
        System.out.print("1. joukko? ");
        IntJoukko aJoukko = mikaJoukko(lukija);
        System.out.print("2. joukko? ");
        IntJoukko bJoukko = mikaJoukko(lukija);
        IntJoukko erotusJoukko = IntJoukko.erotus(aJoukko, bJoukko);
        System.out.println("A erotus B = " + erotusJoukko.toString());
    }

    private static void poista(Scanner lukija) {
        System.out.print("Mistä joukosta? ");
        IntJoukko joukko = mikaJoukko(lukija);
        System.out.print("Mikä luku poistetaan? ");
        int poistettavaLuku = lukija.nextInt();
        joukko.poista(poistettavaLuku);
    }

    private static void kuuluu(Scanner lukija) {
        System.out.print("Mihin joukkoon? ");
        IntJoukko joukko = mikaJoukko(lukija);
        System.out.print("Mikä luku? ");
        int kysLuku = lukija.nextInt();
        boolean kuuluuko = joukko.lukuLoytyyJoukosta(kysLuku);
        if (kuuluuko) {
            System.out.println(kysLuku + " kuuluu joukkoon ");
        } else {
            System.out.println(kysLuku + " ei kuulu joukkoon ");
        }
    }

    public static void main(String[] args) {
        A = new IntJoukko();
        B = new IntJoukko();
        C = new IntJoukko();
        String luettu;

        System.out.println("Tervetuloa joukkolaboratorioon!");
        System.out.println("Käytössäsi ovat joukot A, B ja C.");
        System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e), leikkaus(le) ja lopetus(quit)(q).");
        System.out.println("Joukon nimi komentona tarkoittaa pyyntöä tulostaa joukko.");

        Scanner lukija = new Scanner(System.in);
        while (true) {
            luettu = lukija.nextLine();
            if (luettu.equals("lisää") || luettu.equals("li")) {
                lisaa(lukija);
            } else if (luettu.equalsIgnoreCase("poista") || luettu.equalsIgnoreCase("p")) {
                poista(lukija);
            } else if (luettu.equalsIgnoreCase("kuuluu") || luettu.equalsIgnoreCase("k")) {
                kuuluu(lukija);
            } else if (luettu.equalsIgnoreCase("yhdiste") || luettu.equalsIgnoreCase("y")) {
                yhdiste(lukija);
            } else if (luettu.equalsIgnoreCase("leikkaus") || luettu.equalsIgnoreCase("le")) {
                leikkaus(lukija);
            } else if (luettu.equalsIgnoreCase("erotus") || luettu.equalsIgnoreCase("e")) {
                erotus(lukija);
            } else if (luettu.equalsIgnoreCase("A")) {
                System.out.println(A);
            } else if (luettu.equalsIgnoreCase("B")) {
                System.out.println(B);
            } else if (luettu.equalsIgnoreCase("C")) {
                System.out.println(C);
            } else if (luettu.equalsIgnoreCase("lopeta") || luettu.equalsIgnoreCase("quit") || luettu.equalsIgnoreCase("q")) {
                System.out.println("Lopetetaan, moikka!");
                break;
            } else {
                System.out.println("Virheellinen komento! " + luettu);
                System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
            }
            System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
        }
    }
}
