package repositoryprototype;

import repositoryprototype.dummymodel.system.AssemblyConnector;
import repositoryprototype.dummymodel.system.AssemblyContext;
import repositoryprototype.dummymodel.system.OperationProvidedRole;
import repositoryprototype.dummymodel.system.OperationRequiredRole;
import repositoryprototype.dummymodel.system.System;

public class PrototypeMain {

	public static void main(String[] args) {
		
		// Create a dummy model
		AssemblyContext c1 = new AssemblyContext("c1");
		AssemblyContext c2 = new AssemblyContext("c2");
		OperationProvidedRole opr = new OperationProvidedRole("provided role");
		OperationRequiredRole orr = new OperationRequiredRole("required rol");
		AssemblyConnector conn = new AssemblyConnector(opr, orr);
		c1.addProvidedRole(opr);
		c2.addRequiredRole(orr);
		System system = new System();
		system.addContext(c1);
		system.addContext(c2);
		

	}

}
