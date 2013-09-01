package DataStructure;

public enum SeasonEnum {
	SPRING("1"), SUMMER("2"), AUTUMN("3"), WINTER("4");
	private String name;
	private SeasonEnum(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public static void main(String[] args) {
		System.out.println(SeasonEnum.SPRING);
	}
}
