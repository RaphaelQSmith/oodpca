package dpCA1;

public class Country {
	
	private Object code;
	private String name;
	private String continent;
	private float area;
	private String headOfState;

	private Country(CountryBuilder builder) {
		this.code = builder.code;
		this.name = builder.name;
		this.continent = builder.continent;
		this.area = builder.area;
		this.headOfState = builder.headOfState;
	}
	
	public static class CountryBuilder{
		private Object code;
		private String name;
		private String continent;
		private float area;
		private String headOfState;
		
		public CountryBuilder(Object code, String name, String continent) {
			this.code = code;
			this.name = name;
			this.continent = continent;
			this.headOfState = " ";
			this.area = 0; 
		}
		
		public CountryBuilder setArea(float area) {
			this.area = area;
			return this;
		}
		
		public CountryBuilder setHoS(String headOfState) {
			this.headOfState = headOfState;
			return this;
		}
		
		public Country build() {
			return new Country(this);
		}
		
	}
	
	@Override
	public String toString() {
		return "Country: " + name +", "+ continent + ", "+ code;
	}
	
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
