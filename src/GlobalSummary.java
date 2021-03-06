import java.util.HashMap;

class GlobalSummary {

    private HashMap<GlobalSummaryKey, Summary> map;

    public GlobalSummary(){
	map = new HashMap<GlobalSummaryKey, Summary>();
    }

    public void put(GlobalSummaryKey key, Summary value) {
	map.put(key, value);
    }

    public Summary get(GlobalSummaryKey key) {
	return map.get(key);
    }
}
