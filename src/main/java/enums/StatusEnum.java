package enums;

public enum StatusEnum {
	IN_PROGRESS("In progress"),
	CONCLUDED("Concluded");
	
	String description;

	private StatusEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}