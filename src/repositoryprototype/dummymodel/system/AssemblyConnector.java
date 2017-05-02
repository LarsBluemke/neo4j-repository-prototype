package repositoryprototype.dummymodel.system;

public class AssemblyConnector {

	private final OperationProvidedRole providedRole;
	private final OperationRequiredRole requiredRole;
	
	public AssemblyConnector(OperationProvidedRole providedRole, OperationRequiredRole requiredRole) {
		this.providedRole = providedRole;
		this.requiredRole = requiredRole;
	}
	
	public OperationProvidedRole getProvidedRole() {
		return providedRole;
	}

	public OperationRequiredRole getRequiredRole() {
		return requiredRole;
	}
	
}
