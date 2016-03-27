import soot.SceneTransformer;
import java.util.Map;

class PerformanceBugAnalysis extends SceneTransformer {

    String mainClassName;

    public PerformanceBugAnalysis(String mainClassName) {
	this.mainClassName = mainClassName;
    }
    
    // Main entry point to the analysis.
    protected void internalTransform(String phaseName, Map options) {

	System.out.println("=== STARTED PERFORMANCE BUG ANALYSIS ===");

	PointsToAnalysis ptsToAnalysis = new PointsToAnalysis();
	GlobalPointsToMap globalPtsToMap = ptsToAnalysis.computeGlobalPointsToMap(mainClassName);

	System.out.println("=== FINISHED PERFORMANCE BUG ANALYSIS ===");
    }

    private static PerformanceBugAnalysis instance = null;
    
    public static PerformanceBugAnalysis v(String mainClassName) {
	if(instance == null) {
	    instance = new PerformanceBugAnalysis(mainClassName);
	}
	return instance;
    }
}
