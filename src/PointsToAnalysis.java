import soot.*;
import soot.jimple.*;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.toolkits.graph.pdg.EnhancedUnitGraph;
import soot.toolkits.graph.UnitGraph;
import soot.jimple.toolkits.pointer.LocalMayAliasAnalysis;
import soot.jimple.toolkits.pointer.LocalMustAliasAnalysis;
import soot.util.*;
import java.util.Iterator;
import java.util.LinkedList;

class PointsToAnalysis {

    public GlobalPointsToMap computeGlobalPointsToMap(String mainClassName) {
		
	CallGraph callGraph = Scene.v().getCallGraph();
	SootClass sootClass = Scene.v().getSootClass(mainClassName);
	GlobalPointsToMap globalPointsToMap = new GlobalPointsToMap();
	LinkedList<SootMethod> methodQueue = new LinkedList<SootMethod>();
	
	// Add all method to the processing queue, and create empty starting points-to maps for them.
	for(SootMethod sootMethod : sootClass.getMethods()) {
	    
	    methodQueue.add(sootMethod);
	    PointsToMap pointsToMap = new PointsToMap();
	    FunctionSignature signature = new FunctionSignature(sootMethod.getDeclaration());
	    globalPointsToMap.put(signature, pointsToMap);
	}

	// Compute the points-to maps iteratively.
	while(!methodQueue.isEmpty()) {
	    SootMethod sootMethod = methodQueue.remove();
	    computeMethodPointsToMap(sootMethod, globalPointsToMap);
	}

	System.out.println("=== Points-To Maps ===");
	globalPointsToMap.print();

	return globalPointsToMap;
    }

    public void computeMethodPointsToMap(SootMethod sootMethod, GlobalPointsToMap globalPointsToMap) {
	if(!sootMethod.hasActiveBody()) {
	    System.out.println(sootMethod.getDeclaration() + ": No active body. Skipping analysis.");
	    return;
	}
	PointsToMap pointsToMap = globalPointsToMap.get(new FunctionSignature(sootMethod.getDeclaration()));
	Body body = sootMethod.getActiveBody();
	UnitGraph unitGraph = new EnhancedUnitGraph(body);
	LocalMayAliasAnalysis mayAliasAnalysis = new LocalMayAliasAnalysis(unitGraph);
	LocalMustAliasAnalysis mustAliasAnalysis = new LocalMustAliasAnalysis(unitGraph);
	System.out.println("Constructed points-to may and must analyses: " + sootMethod.getDeclaration());
    }    
}
