package repositoryprototype.dummymodel.system;

public class OperationRequiredRole {

	private String name;
	private boolean isConnected;

	public OperationRequiredRole(String name) {
		this.name = name;
		this.setConnected(false);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isConnected() {
		return isConnected;
	}

	public void setConnected(boolean isConnected) {
		this.isConnected = isConnected;
	}
}
