https://leetcode.com/problems/top-k-frequent-elements/submissions/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int a : nums){
            if(!map.containsKey(a))
                map.put(a,1);
            else
                map.put(a,map.get(a)+1);
        }
        
        System.out.println(map);
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(k, new MapComparator());
        
        int i=0;
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(i<k) {
                pq.add(entry);
            }
            else {
                int pq_freq = pq.peek().getValue();
                int next_freq = entry.getValue();
                if(next_freq > pq_freq){
                    pq.poll();
                    pq.add(entry);
                }
            }
                
            i++;
        }
        
        
        
        // pq.addAll(map.entrySet());
        
        System.out.println(pq);
        
        int[] sol = new int[k];
        
        for(i=0; i<k; i++) sol[i] = pq.poll().getKey();
        return sol;
    }
}

class MapComparator implements Comparator<Map.Entry<Integer, Integer>>{

    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return o1.getValue().compareTo(o2.getValue());
    }   
}