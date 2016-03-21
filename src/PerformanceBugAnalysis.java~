import java.util.*;
import soot.*;
import soot.jimple.*;
import soot.util.*;


class PerformanceBugAnalysis extends SceneTransformer {

    // Main entry point to the analysis.
    protected void internalTransform(String phaseName, Map options) {

    }

    private static PerformanceBugAnalysis instance = null;
    public static PerformanceBugAnalysis v() {
	if(instance == null) {
	    instance = new PerformanceBugAnalysis();
	}
	return instance;
    }
}
