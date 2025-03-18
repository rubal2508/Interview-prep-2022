import java.io.*;
import java.util.*;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.core.JsonProcessingException;

/*
Design a key value store which can perform ALL the following operations in Θ(1): (amortized) time complexity:
- V get(K)
- (K,V) getRandom()
- void put(K, V)
- V delete(K)
*/

// Main class should be named 'Solution' and should not be public.
class Uber {
    public static void main(String[] args) {
        System.out.println("Hello, World");
        
        RandomHashMap<Integer, Integer> randomHashMap = new RandomHashMap<>();
        randomHashMap.put(1,null);
        randomHashMap.put(2,2);
        randomHashMap.put(3,3);
        randomHashMap.put(4,4);
        randomHashMap.put(5,5);
        randomHashMap.put(6,6);
        randomHashMap.put(7,7);
        randomHashMap.put(8,8);
        
        System.out.println(randomHashMap.get(1));
        System.out.println(randomHashMap.delete(1));
        System.out.println(randomHashMap.get(1));
        MapEntry entry = randomHashMap.getRandom();
        System.out.println(entry.key + " " + entry.value);
    }
}

class RandomHashMap<K,V>{
    private HashMap<K,Integer> hmap;
    private ArrayList<MapEntry<K,V>> arrayList;
    
    RandomHashMap(){
        hmap = new HashMap<>();
        arrayList = new ArrayList<>();
    }
    
    public V get(K key){
        // check if key not present
        
        if(null == key){
            // throw new NullPointerException();
            return null;
        }
        
        if(!hmap.containsKey(key)){
            // throw RuntimeException("Key not found");
            return null;
        }
        
        // get index
        int i = hmap.get(key);
        
        MapEntry<K,V> entry = arrayList.get(i);
        return entry.value;
    }
    
    public void put(K key, V value){
        // check if key already present
        if(hmap.containsKey(key)){
            // update the existing key
            int i = hmap.get(key);
            MapEntry<K,V> entry = arrayList.get(i);
            entry.value = value;
            return;
        }
        else {
            // crete a new entry and add to the end of list
            MapEntry<K,V> newEntry = new MapEntry(key, value);
            arrayList.add(newEntry);
            hmap.put(key, arrayList.size()-1);
        }
    }
    
    public V delete(K key){
        // check if key not present
        if(!hmap.containsKey(key)){
            // throw RuntimeException("Key not found");
            return null;
        }
        
        // get index
        int i = hmap.get(key);
        int target_i = arrayList.size()-1;
        
        // swap with last element in list
        MapEntry<K,V> currEntry = arrayList.get(i);
        MapEntry<K,V> lastEntry = arrayList.get(target_i);
        
        arrayList.set(i, lastEntry);
        arrayList.remove(target_i);
        
        // update hashmap
        hmap.put(lastEntry.key, i);
        hmap.remove(key);
        
        return currEntry.value;
    } 
    
    public MapEntry<K,V> getRandom(){
        
        int n = arrayList.size();
        
        Random random = new Random();
        int randomNumber = random.nextInt(n-1); 
        
        System.out.println("random: " + randomNumber);
        
        return arrayList.get(randomNumber);
    }
}
class MapEntry<K,V>{
    K key;
    V value;
    
    MapEntry(K key, V value){
        this.key = key;
        this.value = value;
    }
}
