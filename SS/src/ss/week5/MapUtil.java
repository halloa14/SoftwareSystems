package ss.week5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapUtil {
	
    /*@ ensures (\forall int i, j; 0 < i & i < \old(map.values().size()) 
					& 0 < j & j < \old(map.values().size()) & i != j;
					 !\old(map.values().toArray()[i]).equals(\old(map.values().toArray()[j])))
					 	<==> \result == true; @*/
	
	public static <K, V> boolean isOneOnOne(Map<K, V> map) {
        for (V value : map.values()) {
        	ArrayList<V> lijst = new ArrayList<V>(map.values());
        	lijst.remove(value);
        	if (lijst.contains(value)) {
        		return false;
        	}
        }
        return true;
    }
	
	/*@ ensures (\forall int i; 0 < i & i < \old(range.size());
	 				map.containsValue(range.toArray()[i]) <==> \result == true);@*/
    public static <K, V> 
           boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
        for (V value : range) {
        	if (!map.containsValue(value)) {
        		return false;
        	}
        }
        return true;
    }
    
    
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
    	Map<V, Set<K>> result = new HashMap<V, Set<K>>();
        for (K key : map.keySet()) {
        	V value = map.get(key);
        	if (!result.containsKey(value)) {
        		HashSet<K> keyset = new HashSet<K>();
            	keyset.add(key);
            	result.put(value, keyset);
        	}
        	result.
        }
        return null;
	}
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
        // TODO: implement, see exercise P-5.3
        return null;
	}
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
        // TODO: implement, see exercise P-5.4
        return false;
	}
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        // TODO: implement, see exercise P-5.5
        return null;
	}
}
