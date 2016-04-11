import soot.*;
import soot.jimple.*;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.toolkits.graph.pdg.EnhancedUnitGraph;
import soot.toolkits.graph.UnitGraph;
import soot.util.*;
import java.util.Iterator;
import java.util.LinkedList;


class SummaryAnalysis {

    public GlobalSummary computeGlobalSummary(String mainClassName, GlobalPointsToMap globalPointsToMap) {

	CallGraph callGraph = Scene.v().getCallGraph();
	SootClass sootClass = Scene.v().getSootClass(mainClassName);
	GlobalSummary globalSummary = new GlobalSummary();
	LinkedList<SootMethod> methodQueue = new LinkedList<SootMethod>();

	// Add all methods to process summary.
	for(SootMethod method : sootClass.getMethods()) {

	    methodQueue.add(method);
	}

	// Compute summaries for the methods.
	while(!methodQueue.isEmpty()){
	    SootMethod method = methodQueue.removeFirst();
	    boolean changed = computeMethodSummary(method, globalSummary);
	}

	return globalSummary;
    }

    public boolean computeMethodSummary(SootMethod method, GlobalSummary globalSummary){
	GlobalSummaryKey key = new GlobalSummaryKey(method.getDeclaration());
	Summary summary = new Summary();
	globalSummary.put(key, summary);
	return true;
    }
}
