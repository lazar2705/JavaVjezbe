package Zadatak1;
import java.util.*;
public class EProizvodi {
	
	private String opis;
	private String sifra;
	private double uvoznaCijena;
	public EProizvodi(String opis, String sifra, double uvoznaCijena) {
			this.opis=opis;
			this.sifra=sifra;
			this.uvoznaCijena=uvoznaCijena;
		}
	public String getOpis() {return opis;}
	public void setOpis(String opis) {
		this.opis = opis;}
	
	public String getSifra() {return sifra;}
	public void setSifra(String sifra) {
		this.sifra = sifra;}
	
	public double getUvoznaCijena() {return uvoznaCijena;}
	public void setUvoznaCijena(double uvoznaCijena) {
		if (uvoznaCijena>0) 
			this.uvoznaCijena=uvoznaCijena;}
	
	
	
	public double obracunMaloprodajneCijene() {
		return uvoznaCijena*1.05;
		
	}
	
	public String getTip() {
		if (sifra.startsWith("RA")) return "Racunari";
		if (sifra.startsWith("TE")) return "Telefoni";
		if (sifra.startsWith("TV")) return "TV";
		return "Nepoznato";
    }
	@Override
	public String toString() {
		return "EProizvodi [opis=" + opis + ", sifra=" + sifra + ", uvoznaCijena=" + uvoznaCijena + "]";
	}
	
}

class Racunari extends EProizvodi {
	private String procesor;
	private int memorija;
	public Racunari(String opis, String sifra, double uvoznaCijena, String procesor, int memorija) {
		super(opis, sifra, uvoznaCijena);
		this.procesor=procesor;
		this.memorija=memorija;
	}
	public String getProcesor() {return procesor;}
	public void setProcesor(String procesor) {
		this.procesor = procesor;}
	
	public int getMemorija() {return memorija;}
	public void setMemorija(int memorija) {
		this.memorija = memorija;}
	
	@Override
    public String getTip() {
        return "Racunari"; // samo tip
    }
	
	@Override
    public String toString() {
        return super.toString() + String.format(", Procesor: %s, Memorija: %d", procesor, memorija);
    }
	
	 @Override
	public double obracunMaloprodajneCijene() {
		double cijena = super.obracunMaloprodajneCijene();
		cijena*=1.05;
		return cijena;
	}
	 
}

class Telefoni extends EProizvodi {
	private String operativniSistem;
	private double velicinaEkrana;
	public Telefoni(String opis, String sifra, double uvoznaCijena, String operativniSistem, double velicinaEkrana) {
		super(opis, sifra, uvoznaCijena);
		this.operativniSistem=operativniSistem;
		this.velicinaEkrana=velicinaEkrana;
	}
	public String getOperativniSistem() {return operativniSistem;}
	public void setOperativniSistem(String operativniSistem) {
		this.operativniSistem = operativniSistem;}
	
	public double getVelicinaEkrana() {return velicinaEkrana;}
	public void setVelicinaEkrana(double velicinaEkrana) {
		this.velicinaEkrana = velicinaEkrana;}
	
	@Override
    public String getTip() {
        return "Telefoni"; // samo tip
    }
	
	@Override
    public String toString() {
        return super.toString() + String.format(", Operativni sistem: %s, Velicina ekrana: %f", operativniSistem, velicinaEkrana);
    }
	
	@Override
	public double obracunMaloprodajneCijene() {
		double cijena = super.obracunMaloprodajneCijene();
		if (velicinaEkrana > 6) cijena*=1.03;
		return cijena;
	}
	
}

class TV extends EProizvodi {
	private double velicinaEkrana;
	public TV(String opis, String sifra, double uvoznaCijena, double velicinaEkrana) {
		super(opis, sifra, uvoznaCijena);
		this.velicinaEkrana=velicinaEkrana;
	}
	public double getVelicinaEkrana() {return velicinaEkrana;}
	public void setVelicinaEkrana(double velicinaEkrana) {
		this.velicinaEkrana = velicinaEkrana;}
	
	@Override
    public String getTip() {
        return "TV"; // samo tip
    }
	
	@Override
	public String toString() {
		return super.toString() +String.format(", Velicina ekrana: %f", velicinaEkrana);
	}
	@Override
	public double obracunMaloprodajneCijene() {
		double cijena = super.obracunMaloprodajneCijene();
		if (velicinaEkrana > 65) cijena*=1.1;
		return cijena;
	}
	
}

class Main {
    public static void ispisiPoTipu(List<EProizvodi> proizvodi, String tip) {
        System.out.println("\nProizvodi tipa: " + tip);
        for (EProizvodi p : proizvodi) {
            if (p.getTip().equalsIgnoreCase(tip)) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        List<EProizvodi> proizvod = new ArrayList<>();

        proizvod.add(new Racunari("ASUS Laptop", "RA111", 500, "Intel i5", 16));
        proizvod.add(new Racunari("Lenovo IDEAPAD3", "RAL01", 750, "AMD Radeon", 15));
        proizvod.add(new TV("HiSense", "TVH01", 1100, 65));
        proizvod.add(new TV("HiSense", "TVH01", 1100, 65));
        proizvod.add(new Telefoni("Samsung S25 ULTRA", "TES25U01", 1300, "Android", 8));
        proizvod.add(new Telefoni("Iphone 17 PRO MAX", "TEIPM01", 1300, "IOS", 7));
        
    
        ispisiPoTipu (proizvod, "TV");
        ispisiPoTipu (proizvod, "Racunari" );
        ispisiPoTipu (proizvod, "Telefoni");

    }
}