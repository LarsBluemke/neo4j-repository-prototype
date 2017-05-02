package repositoryprototype.dummymodel.system;

import java.util.LinkedList;
import java.util.List;

public class System {
	
	private List<AssemblyContext> contexts;
	
	public System() {
		this.contexts = new LinkedList<>();
	}

	public List<AssemblyContext> getCotexts() {
		return contexts;
	}

	public void addContext(AssemblyContext cotext) {
		this.contexts.add(cotext);
	}
	
}
