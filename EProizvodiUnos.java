package Zadatak1;

import java.util.*;

public class EProizvodiUnos {
    public static void ispisiProizvode(List<EProizvodi> proizvodi, String tip) {
        if (proizvodi.isEmpty()) {
            System.out.println("Nema unesenih proizvoda!");
            return;
        }

        if (tip == null || tip.isEmpty()) {
            System.out.println("\n=== Svi proizvodi ===");
            for (EProizvodi p : proizvodi) {
                System.out.println(p);
            }
        } else {
            System.out.println("\n=== Proizvodi tipa: " + tip + " ===");
            boolean nadjen = false;
            for (EProizvodi p : proizvodi) {
                if (p.getTip().equalsIgnoreCase(tip)) {
                    System.out.println(p);
                    nadjen = true;
                }
            }
            if (!nadjen) {
                System.out.println("Nema proizvoda tog tipa!");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<EProizvodi> proizvodi = new ArrayList<>();
        int izbor = -1;

        while (izbor != 0) {
            System.out.println("\n***MENI***");
            System.out.println("1. Unos uređaja");
            System.out.println("2. Pregled svih uređaja");
            System.out.println("3. Pregled uređaja određenog tipa");
            System.out.println("0. Izlaz");
            System.out.print("Unesite opciju: ");
            izbor = sc.nextInt();
            sc.nextLine(); 

            if (izbor == 1) {
                System.out.print("Unesite šifru uređaja (RA - računar, TE - telefon, TV - TV): ");
                String sifra = sc.nextLine().trim().toUpperCase();

                System.out.print("Unesite opis uređaja: ");
                String opis = sc.nextLine();

                System.out.print("Unesite uvoznu cijenu: ");
                double cijena = sc.nextDouble();
                sc.nextLine();

                if (sifra.startsWith("RA")) {
                    System.out.print("Procesor: ");
                    String procesor = sc.nextLine();
                    System.out.print("Memorija u GB: ");
                    int memorija = sc.nextInt();
                    sc.nextLine();
                    proizvodi.add(new Racunari(opis, sifra, cijena, procesor, memorija));
                    System.out.println("Racunar dodat!");

                } else if (sifra.startsWith("TE")) {
                    System.out.print("Operativni sistem: ");
                    String os = sc.nextLine();
                    System.out.print("Velicina ekrana u incima: ");
                    double ekran = sc.nextDouble();
                    sc.nextLine();
                    proizvodi.add(new Telefoni(opis, sifra, cijena, os, ekran));
                    System.out.println(" Telefon dodat!");

                } else if (sifra.startsWith("TV")) {
                    System.out.print("Velicina ekrana u incima: ");
                    double ekran = sc.nextDouble();
                    sc.nextLine();
                    proizvodi.add(new TV(opis, sifra, cijena, ekran));
                    System.out.println(" TV uredjaj dodat!");

                } else {
                    System.out.println(" Nepoznata sifra! Uredjaj nije dodat.");
                }

            } else if (izbor == 2) { 
                ispisiProizvode(proizvodi, null);

            } else if (izbor == 3) { 
                System.out.print("Unesite tip uredjaja (Racunari / Telefoni / TV): ");
                String tip = sc.nextLine();
                ispisiProizvode(proizvodi, tip);

            } else if (izbor == 0) {
                System.out.println("Kraj programa.");

            } else {
                System.out.println("Pogresan unos! Pokusajte ponovo.");
            }
        }

        sc.close();
    }
}
