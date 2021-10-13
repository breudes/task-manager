package enums;

public enum PriorityEnum {
	LOW("Low"),
	MEDIUM("Medium"),
	HIGH("High");
	
	String description;

	private PriorityEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
