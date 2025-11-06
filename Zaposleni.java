package Zadatak2;
import java.util.*;
import java.util.ArrayList;

public class Zaposleni {
	
	private int ID;
	private String ime;
	private String prezime;
	private double plataPoSatu;
	private double ukupanBrojSati;
	
	public Zaposleni (int ID, String ime, String prezime, double plataPoSatu, double ukupanBrojSati) {
		this.ID=ID;
		this.ime=ime;
		this.prezime=prezime;
		this.plataPoSatu=plataPoSatu;
		this.ukupanBrojSati=ukupanBrojSati;
	}

	public String tipZaposlenog() {
		// TODO Auto-generated method stub
		return null;
	}

	public double izracunajPlatu() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getID() {return ID;}
	public void setID(int iD) {ID = iD;}
	
	public String getIme() {return ime;}
	public void setIme(String ime) {this.ime = ime;}

	public String getPrezime() {return prezime;}
	public void setPrezime(String prezime) {this.prezime = prezime;}

	public double getPlataPoSatu() {return plataPoSatu;}
	public void setPlataPoSatu(double plataPoSatu) {this.plataPoSatu = plataPoSatu;}

	public double getUkupanBrojSati() {
		return ukupanBrojSati;}
	public void setUkupanBrojSati(double ukupanBrojSati) {
		this.ukupanBrojSati = ukupanBrojSati;}
	
class Konobar extends Zaposleni {
	private double prekovremeniSati;
	
	public Konobar(int id, String ime, String prezime, double plataPoSatu, double ukupanBrojSati, double prekovremeniSati) {
        super(id, ime, prezime, plataPoSatu, ukupanBrojSati);
        this.prekovremeniSati = prekovremeniSati;
    }
	public void setPrekovremeniSati(double prekovremeniSati) {
		this.prekovremeniSati = prekovremeniSati;
	}



	@Override
	public double izracunajPlatu() {
		double redovni = ukupanBrojSati * plataPoSatu;
		double prekovremeni = ukupanBrojSati * plataPoSatu*1.2;
		return 4*(redovni + prekovremeni);
	}
	@Override
    public String tipZaposlenog() {
        return "Konobar";
    }

    public double getPrekovremeniSati() {
        return prekovremeniSati;
    }

	
}

class Kuvar extends Zaposleni {
	public Kuvar (int id, String ime, String prezime, double plataPoSatu, double ukupanBrojSati, double prekovremeniSati) {
		super(id, ime, prezime, plataPoSatu, ukupanBrojSati);
	}	
	 @Override   
	 public double izracunajPlatu() {
		 return (1500 + 4 * ukupanBrojSati * plataPoSatu);
		 }
	 @Override
	 public String tipZaposlenog() {
		 return "Kuvar";
		 }
}

class Menadzer extends Zaposleni {
	private boolean bonusDaNe;
	private double bonus;
	public Menadzer (int id, String ime, String prezime, double plataPoSatu, double ukupanBrojSati, double prekovremeniSati,boolean bonusDaNe, double bonus) {
		super(id, ime, prezime, plataPoSatu, ukupanBrojSati);
		this.bonus=bonus;
		this.bonusDaNe=bonusDaNe;
	}
	
	
	public boolean isBonusDaNe() {return bonusDaNe;}
	public void setBonusDaNe(boolean bonusDaNe) {
		this.bonusDaNe = bonusDaNe;}


	public void setBonus(double bonus) {this.bonus = bonus;}
	
	public double izracunajPlatu() {
		if (bonusDaNe=true) {
			return (1300 + 4*ukupanBrojSati*plataPoSatu + bonus);
		} else	{
			return (1300 + 4*ukupanBrojSati*plataPoSatu);
		}
		}

	@Override
    public String tipZaposlenog() {
        return "Menadzer";
    }

    public double getBonus() {
        return bonus;
    }
	
}

class Restoran {
    private String naziv;
    private String adresa;
    private String PIB;
    private List<Zaposleni> zaposleni;

    public Restoran(String naziv, String adresa, String PIB) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.PIB = PIB;
        this.zaposleni = new ArrayList<>();
    }

	public String getNaziv() {return naziv;}
	public void setNaziv(String naziv) {
		this.naziv = naziv;}

	public String getAdresa() {return adresa;}
	public void setAdresa(String adresa) {
		this.adresa = adresa;}

	public String getPIB() {return PIB;}
	public void setPIB(String pIB) {
		PIB = pIB;}

	public List<Zaposleni> getZaposleni() {return zaposleni;}
	public void setZaposleni(List<Zaposleni> zaposleni) {
		this.zaposleni = zaposleni;
	}
	
	public void dodajZaposlenog(Zaposleni z) {
        zaposleni.add(z);
    }
	
	
 
	
	
	
}
}