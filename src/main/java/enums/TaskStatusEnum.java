package enums;

public enum TaskStatusEnum {
	IN_PROGRESS("In progress"),
	CONCLUDED("Concluded");
	
	String description;

	private TaskStatusEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
