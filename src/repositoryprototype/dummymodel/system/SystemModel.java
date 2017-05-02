package repositoryprototype.dummymodel.system;

import java.util.LinkedList;
import java.util.List;

public class SystemModel {
	
	private List<AssemblyContext> contexts;
	private List<AssemblyConnector> connectors;
	
	public SystemModel() {
		this.contexts = new LinkedList<>();
		this.connectors = new LinkedList<>();
	}

	public List<AssemblyContext> getCotexts() {
		return contexts;
	}

	public void addContext(AssemblyContext cotext) {
		this.contexts.add(cotext);
	}

	public List<AssemblyConnector> getConnectors() {
		return connectors;
	}

	public void addConnector(AssemblyConnector connector) {
		this.connectors.add(connector);
	}
	
}
