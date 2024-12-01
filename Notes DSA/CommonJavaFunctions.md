# Common Java Functions

## STL 

#### ArrayList 
- `add`, `get(i)`, `set(i, T e)`
- `contains(e)`, `remove(e)`

#### LinkedList 
- `addFirst`, `addLast`
- `removeFirst`, `removeLast`
- `getFirst`, `getLast`

#### Priority Queue
- `peek`, `add`, `poll`,
- `contains`, `remove`
- Default is min heap


#### Stack
- `peek`, `push`, `pop`
- `Stack<Integer> stack = new Stack<>()`


#### String Builder
- `StringBuilder pattern = new StringBuilder(word)`
- `append(Object)` 	
- `toString()`
- `setChatAt(i,ch)`, `insert(i,Object)`
- `sb = sb.reverse()` 


#### String 

- Does not exisit: `myName.setCharAt(i, '*')`
- `char[] chArr = str.toCharArray()`
- `String 	indexOf(String str)` : Returns the index within this string of the first occurrence of the specified substring.
- `s.substring(0,n)`
- `String[] preList = data.split(" ");`

- How to sort a string

    ``` java
    String test= "edcba";
    char[] ar = test.toCharArray();
    Arrays.sort(ar);
    String sorted = String.valueOf(ar);
    ```

- Converting a string to lowercase and removing all non alpha numeric characters
    ``` java   
    str = str.toLowerCase().replaceAll("[^a-z0-9]", "")
    ```

- comparing two string lexically: `str1.compareTo(str2)`

#### TreeMap
- `Map.Entry<K,V>   map.floorEntry(key)`
- `Map.Entry<K,V>	map.ceilingEntry(K key)` : Returns a key-value mapping associated with the least key greater than or equal to the given key, or null if there is no such key.

#### TreeSet
- `set.ceiling`
- `set.floor`


## Others

#### Learn about split function regex

#### Print an Array

``` java
System.out.println(Arrays.deepToString(dp).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));

System.out.println(Arrays.toString(nums));
```

#### Fill 2D Array
``` java
Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));

```

#### Iterating an HashMap

``` java
for (String key : hmap.keySet()) {
    Object value = hmap.get(key);
}
```

``` java
for (Map.Entry<String, Object> entry : hmap.entrySet()) {
    String key = entry.getKey();
    Object value = entry.getValue();
}
```

#### Custom Comparators

- Max Heap:
 
``` java
PriorityQueue<Integer> queue = new PriorityQueue<>(10, Collections.reverseOrder());
```

``` java
class Sortbyroll implements Comparator<Student> {
    // Sorting in ascending order of roll number
    public int compare(Student a, Student b){
        return a.rollno - b.rollno;
    }
 
PriorityQueue<Student> pq = new PriorityQueue<Student>(5, new Sortbyroll());
```

- Sort 2d array int[][] time intervals: interval that starts early will come before, if clash, then interval that ends later will come before 

``` java
Arrays.sort(intervals, (a,b) -> {
    if(a[0] == b[0]) return b[1] - a[1];
    else return a[0] - b[0];
});
```

- Sort a List of array intervals same as above

``` java
Collections.sort(intervals, (a,b) -> {
        if(a[0] == b[0]) return b[1] - a[1] ;
        else return a[0] - b[0];
});

```


