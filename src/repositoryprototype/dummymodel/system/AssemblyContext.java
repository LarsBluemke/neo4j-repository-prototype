package repositoryprototype.dummymodel.system;

import java.util.LinkedList;
import java.util.List;

public class AssemblyContext {
	
	private String name;
	private List<OperationProvidedRole> providedRoles;
	private List<OperationRequiredRole> requiredRoles;
	
	public AssemblyContext(String name) {
		this.setName(name);
		this.providedRoles = new LinkedList<>();
		this.requiredRoles = new LinkedList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<OperationProvidedRole> getProvidedRoles() {
		return providedRoles;
	}
	public void addProvidedRole(OperationProvidedRole providedRole) {
		this.providedRoles.add(providedRole);
	}
	public List<OperationRequiredRole> getRequiredRoles() {
		return requiredRoles;
	}
	public void addRequiredRole(OperationRequiredRole requiredRole) {
		this.requiredRoles.add(requiredRole);
	}
	

}
