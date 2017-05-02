package repositoryprototype.dummymodel.system;

public class AssemblyConnector {

	private final OperationProvidedRole providedRole;
	private final OperationRequiredRole requiredRole;
	
	public AssemblyConnector(OperationProvidedRole providedRole, OperationRequiredRole requiredRole) {
		this.providedRole = providedRole;
		this.providedRole.setConnected(true);
		this.requiredRole = requiredRole;
		this.requiredRole.setConnected(true);
	}
	
	public OperationProvidedRole getProvidedRole() {
		return providedRole;
	}

	public OperationRequiredRole getRequiredRole() {
		return requiredRole;
	}
	
}
