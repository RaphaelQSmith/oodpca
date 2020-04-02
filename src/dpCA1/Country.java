package dpCA1;

public class Country {
	
	private Object code;
	private String name;
	private String continent;
	private float area;
	private String headOfState;

	public Country(Object code, String name, String continent, float area, String headOfState) {
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.area = area;
		this.headOfState = headOfState;
	}

	
	public class CountryBuilder{
		private Object code;
		private String name;
		private String continent;
		private float area;
		private String headOfState;
		
		public CountryBuilder(Object code, String name, String continent) {
			this.code = code;
			this.name = name;
			this.continent = continent;
		}
		
		public CountryBuilder setArea(float area) {
			this.area = area;
			return this;
		}
		
		public CountryBuilder setHoS(String headOfState) {
			this.headOfState = headOfState;
			return this;
		}
		
	}
	
	public Object getCode() {
		return code;
	}

	public void setCode(Object code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}
}
