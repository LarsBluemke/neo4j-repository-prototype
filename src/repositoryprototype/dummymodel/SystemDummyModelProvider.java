package repositoryprototype.dummymodel;

import org.neo4j.graphdb.GraphDatabaseService;

import repositoryprototype.dummymodel.system.System;

public class SystemDummyModelProvider {

	private System model;
	private GraphDatabaseService neo4jDb;
	
	public SystemDummyModelProvider(System model, GraphDatabaseService neo4jDb) {
		this.model = model;
		this.neo4jDb = neo4jDb;
	}
	
	public void load() {
		
	}
	
	public void save() {
		
	}
}
