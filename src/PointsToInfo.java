import soot.jimple.toolkits.pointer.LocalMayAliasAnalysis;
import soot.jimple.toolkits.pointer.LocalMustAliasAnalysis;

class PointsToInfo {
    private LocalMayAliasAnalysis mayAlias;
    private LocalMustAliasAnalysis mustAlias;
    
    public PointsToInfo(LocalMayAliasAnalysis mayAlias, LocalMustAliasAnalysis mustAlias) {
	this.mayAlias = mayAlias;
	this.mustAlias = mustAlias;
    }

    public LocalMayAliasAnalysis getMayAliasAnalysis() {
	return mayAlias;
    }

    public LocalMustAliasAnalysis getMustAliasAnalysis() {
	return mustAlias;
    }
}
