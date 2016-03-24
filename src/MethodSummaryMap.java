// Class that represents a map from method representations to method summaries.
import java.util.HashMap;
class MethodSummaryMap {
    private HashMap<MethodSummaryKey, MethodSummary> map;

    public MethodSummaryMap() {
	map = new HashMap<MethodSummaryKey, MethodSummary>();
    }

    public MethodSummary get(MethodSummaryKey key) {
	return map.get(key);
    }
    
    public void put(MethodSummaryKey key, MethodSummary value) {
	map.put(key, value);
    }
}
