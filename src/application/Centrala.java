package application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
//siemka
//costam
//Jeszcze jedno
//asdasdasdasdsadasd
public class Centrala {
	private static Centrala instance;
	private List<Lekarz> lekarze = new ArrayList<Lekarz>();
	private ArrayList<Pacjent> pacjenci = new ArrayList<Pacjent>();
	private List<Recepta> recepty = new ArrayList<Recepta>();
	private List<Skierowanie> skierowania = new ArrayList<Skierowanie>();
	private List<Wizyta> wizyty = new ArrayList<Wizyta>();
	public Centrala() {
		
	
		addPacjent(new Pacjent("96113983712", "Rafon", "Tracz", 12, "Rafonowo", 6, 16,
				"Lodz"));
		addPacjent(new Pacjent("96123983711", "Rafon", "Tracz", 12, "Rafonowo", 6, 16,
				"Lodz"));
		addPacjent(new Pacjent("96123983713", "Rafon", "Tracz", 12, "Rafonowo", 6, 16,
				"Lodz"));
		
       addLekarz(new Lekarz("kucharz96", "1234", "Jan", "Wacek", 35, 100, "111111111"));
		
		addLekarz(new Lekarz("jankomuzykant", "12346", "Kamil", "Kowalski", 30, 110, "111111112"));
		
		addLekarz(new Lekarz("cos96", "ser123", "Magda", "Nowakowska", 45, 200, "211111111"));
		addLekarz(new Lekarz("coswddasd", "ser123", "Eliza", "Nowakowska", 45, 200, "211111111"));

		addWizyta(new Wizyta(0, "96123934567", "choryssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss", "12-10-2005 12:00"));
		addWizyta(new Wizyta(1, "96123983764", "chory", "12-10-2010 12:20"));

		addWizyta(new Wizyta(2, "96123934567", "chorysssssssssssss", "12-10-2005 12:00"));
		addWizyta(new Wizyta(3, "96123983764", "chory", "12-10-2010 12:20"));



		addSkierowanie(new Skierowanie(0, "96123934567", "chorysssssssssssss", "z�amanie"));
		addSkierowanie(new Skierowanie(1, "96123983764", "chory", "z�amany piszczel przez Rafona"));

		addSkierowanie(new Skierowanie(2, "96123934567", "chorysssssssssssss", "z�amanie"));
		addSkierowanie(new Skierowanie(3, "96123983764", "chory", "z�amany piszczel przez Rafona"));


		addRecepta(new Recepta(0, "96123934567", "chorysssssssssssss"));
		addRecepta(new Recepta(1, "96123983764", "chory"));

		addRecepta(new Recepta(2, "96123934567", "chorysssssssssssss"));

		addRecepta(new Recepta(2, "96123983764", "chory"));

		addRecepta(new Recepta(3, "96123983764", "chory"));
		
		
	}
	
	public static Centrala getInstance() {
        if (instance == null) {
            instance = new Centrala();
        }
        
        return instance;
    }
	
	public List<Lekarz> getLekarze() {
		return lekarze;
	}
	
	public ArrayList<Pacjent> getPacjenci() {
		return pacjenci;
	}
	public List<Recepta> getRecepty() {
		return recepty;
	}
	public List<Skierowanie> getSkierowania() {
		return skierowania;
	}
	public List<Wizyta> getWizyty() {
		return wizyty;
	}
	public String Logowanie(String login, String haslo)
	{//
		if(login == null || haslo == null)
			return "";

		if(login.equals("admin") && haslo.equals("admin"))
			return login;
		
		for (Lekarz a : lekarze)
		{
			if(a.getLogin().equals(login) && a.getHaslo().equals(haslo))
				return login;
		}
		return "";
	}
	public void addLekarz(Lekarz e) {
		lekarze.add(e);
	}
	public void removeLekarz(int index) {
		

		for(Iterator<Recepta> iter = recepty.iterator(); iter.hasNext();) {
			Recepta a = iter.next();
			if(a.getId_lekarza()==lekarze.get(index).getId()) 
				iter.remove();
				
			
		}
			for(Iterator<Skierowanie> iter = skierowania.iterator(); iter.hasNext();) {
				Skierowanie a = iter.next();
				if(a.getId_lekarza()==lekarze.get(index).getId()) 
					iter.remove();
					
				
			}
			for(Iterator<Wizyta> iter = wizyty.iterator(); iter.hasNext();) {
				Wizyta a = iter.next();
				if(a.getId_lekarza()==lekarze.get(index).getId()) 
					iter.remove();
					
				
			}
			
			lekarze.remove(index);

	}
	public void addPacjent(Pacjent e) {
		pacjenci.add(e);
	}
	public void removePacjent(int index) {
		pacjenci.remove(index);
	}

	public void addRecepta(Recepta e) {
		recepty.add(e);
	}
	public void removeRecepta(int index) {
		recepty.remove(index);
	}
	public void addSkierowanie(Skierowanie e) {
		skierowania.add(e);
	}
	public void removeSkierowanie(int index) {
		skierowania.remove(index);
	}
	public void addWizyta(Wizyta e) {
		wizyty.add(e);
	}
	public void removeWizyta(int index) {
		wizyty.remove(index);
	}
	
}
