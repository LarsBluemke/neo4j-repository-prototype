package repositoryprototype.dummymodel;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;

import repositoryprototype.dummymodel.system.AssemblyConnector;
import repositoryprototype.dummymodel.system.AssemblyContext;
import repositoryprototype.dummymodel.system.OperationProvidedRole;
import repositoryprototype.dummymodel.system.OperationRequiredRole;
import repositoryprototype.dummymodel.system.SystemModel;

public class SystemDummyModelProvider {

	private SystemModel model;
	private GraphDatabaseService graphDb;
	
    private static enum RelTypes implements RelationshipType
    {
        INCLUDES, HAS, CONNECTS
    }
	
	public SystemDummyModelProvider(GraphDatabaseService neo4jDb) {
		this.graphDb = neo4jDb;
		this.setModel(this.loadModel());
	}
	
	public SystemModel loadModel() {
		return null;
	}
	
	public void saveModel() {
		try (Transaction tx = graphDb.beginTx()) {
			Node sn = this.graphDb.createNode();
			sn.addLabel(Label.label("System"));
			sn.setProperty("name", "system");
			
			for(AssemblyContext c : model.getCotexts()) {
				Node cn = this.graphDb.createNode();
				cn.addLabel(Label.label("Assembly Context"));
				cn.setProperty("name", c.getName());
				sn.createRelationshipTo(cn, RelTypes.INCLUDES);
				System.out.println("Added " + c.getName());
				
				for(OperationProvidedRole pr : c.getProvidedRoles()) {
					Node prn = this.graphDb.createNode();
					prn.addLabel(Label.label("Operation Provided Role"));
					prn.setProperty("name", pr.getName());
					cn.createRelationshipTo(prn, RelTypes.HAS);
					System.out.println("Added " + pr.getName());
				}
				
				for(OperationRequiredRole rr : c.getRequiredRoles()) {
					Node rrn= this.graphDb.createNode();
					rrn.addLabel(Label.label("Operation Required Role"));
					rrn.setProperty("name", rr.getName());
					cn.createRelationshipTo(rrn, RelTypes.HAS);
					System.out.println("Added " + rr.getName());

				}
			}
			
			for(AssemblyConnector c : model.getConnectors()) {
				Node pr = graphDb.findNode(Label.label("Operation Provided Role"), "name", c.getProvidedRole().getName());
				Node rr = graphDb.findNode(Label.label("Operation Required Role"), "name", c.getRequiredRole().getName());
				pr.createRelationshipTo(rr, RelTypes.CONNECTS);
				System.out.println("Added connection from " + c.getProvidedRole().getName() + " to " + c.getRequiredRole().getName());
			}
			tx.success();
        }
	}

	public SystemModel getModel() {
		return model;
	}

	public void setModel(SystemModel model) {
		this.model = model;
	}
	
}
