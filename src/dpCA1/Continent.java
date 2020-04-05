package dpCA1;

public enum Continent {
	
		EUROPE("Europe"),
		ASIA("Asia"),
		AFRICA("Africa"),
		SOUTHAMERICA("South America"),
		ANTARCTICA("Antarctica"),
		NORTHAMERICA("NorthAmerica"),
		OCEANIA("Oceania");
	
	public final String continent;
	
	Continent(String continent) {
		this.continent = continent;
	}
	
	public String getCont() {
		return continent;
	}
	public static boolean checkCont(String c) {
		for(Continent cont : Continent.values()) {
			if(cont.getCont().equals(c)) {
				return true;
			}
		}
		return false;
	}	
}
