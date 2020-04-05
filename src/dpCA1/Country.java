package dpCA1;

public class Country {
	
	private Object code;
	private String name;
	private String continent;
	private float area;
	private String headOfState;
	private static Continent c;

	//	use a instance of the inner class to create a 'Country' object 
	private Country(CountryBuilder builder) {
		this.code = builder.code;
		this.name = builder.name;
		this.continent = builder.continent;
		this.area = builder.area;
		this.headOfState = builder.headOfState;
	}
	//	Inner class used to encapsulate the creation of 'Country' objects
	public static class CountryBuilder{
		private Object code;
		private String name;
		private String continent;
		private float area;
		private String headOfState;
	
		//	Create an object with three obligatory arguments
		public CountryBuilder(Object code, String name, String continent) {
			this.code = code;
			this.name = name;
			this.continent = continent;
			this.headOfState = " ";
			this.area = 0; 
		}
		//	Set area of country
		public CountryBuilder setArea(float area) {
			this.area = area;
			return this;
		}
		//	Set Head of State of country
		public CountryBuilder setHoS(String headOfState) {
			this.headOfState = headOfState;
			return this;
		}
		//	Build Country object with an instance of this inner class as argument
		public Country build() {
			return new Country(this);
		}
		
	}
	
	@Override
	public String toString() {
		return "Country: [" + code +", "+ name + ", "+ continent + ", " + area +", "+ headOfState + "]";
	}
	
	//	Getters and Setters 
	public Object getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getContinent() {
		return continent;
	}

	public float getArea() {
		return area;
	}
	public String getHeadOfState() {
		return headOfState;
	}

}
