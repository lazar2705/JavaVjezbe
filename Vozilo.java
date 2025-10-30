import java.util.*;

public class Vozilo {
    private String proizvodjac;
    private int godinaProizvodnje;
    private int kubikaza;
    private String boja;

    public Vozilo(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja) {
        this.proizvodjac = proizvodjac;
        this.godinaProizvodnje = godinaProizvodnje;
        this.kubikaza = kubikaza;
        this.boja = boja;
    }

    public String getProizvodjac() { return proizvodjac; }
    public void setProizvodjac(String proizvodjac) { this.proizvodjac = proizvodjac; }

    public int getGodinaProizvodnje() { return godinaProizvodnje; }
    public void setGodinaProizvodnje(int godinaProizvodnje) { this.godinaProizvodnje = godinaProizvodnje; }

    public int getKubikaza() { return kubikaza; }
    public void setKubikaza(int kubikaza) { this.kubikaza = kubikaza; }

    public String getBoja() { return boja; }
    public void setBoja(String boja) { this.boja = boja; }

    public String getInfo() {
        return String.format("Proizvodjac: %s, Godina: %d, Kubikaza: %d cm3, Boja: %s",
                proizvodjac, godinaProizvodnje, kubikaza, boja);
    }

    public double cijenaRegistracije() {
        double cijena = 100;

        if (this.godinaProizvodnje < 2010) {
            cijena += 30;
        }

        if (this.kubikaza > 2000) {
            cijena += 20;
        }

        return cijena;
    }
}

class Automobil extends Vozilo {
    private int brojVrata;
    private String tipMotora;

    public Automobil(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja,
                     int brojVrata, String tipMotora) {
        super(proizvodjac, godinaProizvodnje, kubikaza, boja);
        this.brojVrata = brojVrata;
        this.tipMotora = tipMotora;
    }

    public int getBrojVrata() { return brojVrata; }
    public void setBrojVrata(int brojVrata) { this.brojVrata = brojVrata; }

    public String getTipMotora() { return tipMotora; }
    public void setTipMotora(String tipMotora) { this.tipMotora = tipMotora; }

    @Override
    public String getInfo() {
        return super.getInfo() + String.format(", Tip: Automobil, Broj vrata: %d, Tip motora: %s", brojVrata, tipMotora);
    }

    @Override
    public double cijenaRegistracije() {
        double price = super.cijenaRegistracije();


        if (this.tipMotora != " " && this.tipMotora.equalsIgnoreCase("dizel")) {
            price += 50;
        }

        return price;
    }
}

class Kombi extends Vozilo {
    private int brojPutnika;

    public Kombi(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja, int brojPutnika) {
        super(proizvodjac, godinaProizvodnje, kubikaza, boja);
        this.brojPutnika = brojPutnika;
    }

    public int getBrojPutnika() { return brojPutnika; }
    public void setBrojPutnika(int brojPutnika) { this.brojPutnika = brojPutnika; }

    @Override
    public String getInfo() {
        return super.getInfo() + String.format(", Tip: Kombi, Broj putnika: %d", brojPutnika);
    }

    @Override
    public double cijenaRegistracije() {
        double price = super.cijenaRegistracije();

        if (this.brojPutnika > 8) {
            price += 30;
        }

        return price;
    }
}


class Kamion extends Vozilo {
    private double kapacitetTereta;
    private boolean prikolica;

    public Kamion(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja,
                  double kapacitetTereta, boolean prikolica) {
        super(proizvodjac, godinaProizvodnje, kubikaza, boja);
        this.kapacitetTereta = kapacitetTereta;
        this.prikolica = prikolica;
    }

    public double getKapacitetTereta() { return kapacitetTereta; }
    public void setKapacitetTereta(double kapacitetTereta) { this.kapacitetTereta = kapacitetTereta; }

    public boolean hasPrikolica() { return prikolica; }
    public void setPrikolica(boolean prikolica) { this.prikolica = prikolica; }

    @Override
    public String getInfo() {
        return super.getInfo() + String.format(", Tip: kamion, kapacitet tereta: %.2f, prikolica: %s",
                kapacitetTereta, (prikolica ? "da" : "ne"));
    }
}

class Main {
    public static void main(String[] args) {
        List<Vozilo> vozila = new ArrayList<>();
        
        vozila.add(new Automobil("Audi",2008,1800, "svijetlo crvena", 3, "benzin+plin"));
        vozila.add(new Automobil("VW",2012,1900, "siva", 5, "dizel"));
        vozila.add(new Kamion("Scania",2015,5000,"crna", 9, true));
        vozila.add(new Kamion("Volvo",2022, 5000, "bijela",12.5,true));
        vozila.add(new Kombi("VW", 2019,2500, "tamno plava", 15));
        vozila.add(new Kombi("Mercedes", 2012,2200, "zuta", 22));
 
    for (Vozilo v : vozila) {
    	System.out.println(v.getInfo());
    	System.out.printf("Ukupno cijena registracije: %.3fEUR", v.cijenaRegistracije());
    }
    
}
}
