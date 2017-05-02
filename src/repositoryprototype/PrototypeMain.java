package repositoryprototype;

import java.io.File;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import repositoryprototype.dummymodel.SystemDummyModelProvider;
import repositoryprototype.dummymodel.system.AssemblyConnector;
import repositoryprototype.dummymodel.system.AssemblyContext;
import repositoryprototype.dummymodel.system.OperationProvidedRole;
import repositoryprototype.dummymodel.system.OperationRequiredRole;
import repositoryprototype.dummymodel.system.SystemModel;

public class PrototypeMain {
	
    private static final File DB_PATH = new File( "target/neo4j-repository-prototype" );


	public static void main(String[] args) {
		
		// Create a dummy model
		AssemblyContext c1 = new AssemblyContext("c1");
		AssemblyContext c2 = new AssemblyContext("c2");
		OperationProvidedRole opr = new OperationProvidedRole("provided role");
		OperationRequiredRole orr = new OperationRequiredRole("required role");
		c1.addProvidedRole(opr);
		c2.addRequiredRole(orr);
		AssemblyConnector conn = new AssemblyConnector(opr, orr);
		SystemModel system = new SystemModel();
		system.addContext(c1);
		system.addContext(c2);
		system.addConnector(conn);
		
	    GraphDatabaseService graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(DB_PATH);
	    registerShutdownHook(graphDb);
	    System.out.println("Started db");
		SystemDummyModelProvider provider = new SystemDummyModelProvider(graphDb);
		provider.setModel(system);
		provider.saveModel();
		graphDb.shutdown();
		System.out.print("Shut down db");
		
		
	}
	
	private static void registerShutdownHook( final GraphDatabaseService graphDb )
    {
        // Registers a shutdown hook for the Neo4j instance so that it
        // shuts down nicely when the VM exits (even if you "Ctrl-C" the
        // running application).
        Runtime.getRuntime().addShutdownHook( new Thread()
        {
            @Override
            public void run()
            {
                graphDb.shutdown();
            }
        } );
    }

}
