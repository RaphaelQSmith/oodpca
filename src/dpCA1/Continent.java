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
}
