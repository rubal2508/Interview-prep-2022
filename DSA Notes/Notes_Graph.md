# Graphs


### BFS
   - $O(V+E)$
   - Print a node then push all unvisited neighbours into a queue (mark them visited before pushing), repeat until queue is empty


### DFS
  - $O(V+E)$
  - Maintain a visited array, loop on all nodes > recurse on all neighbours

<br>

---
---

### Topological Sort 

#### Recursive
  - $O(V+E)$
  - Do DFS, the last leaf node to be put into a stack so it can be printed in last

#### Iterative
  - $O(V+E)$
  - `Kahn's Algo`
  - Indegree of vertices and queue, take nodes with 0 indegree first (no need for visited array)

<br>

---
---

### Cycle Detection

#### DFS
  - Do DFS, also maintain a recursive stack array to detect back edges (slight trick in recursive call condition)

#### BFS
  - `Kahn's algo`
  - Cycle exists if length of output < total number of vertices

#### Undirected Graph
  - DFS, maintain a parent variable, if any neighbour is visited and not parent, its a cycle

<br>

---
---

### Shortest Path

#### Dijkastra's Algo

  - Single source shortest path
  - Non negative weight
  - $O(E.logV)$  ~  $O(E.logE)$ 

    ```
    Use dist[]: initialised as inf, 0 for src 
    Use boolean fin[]: true for nodes whose dist is finalised
    loop V-1 times:
        take the node with smallest dist and not finalised yet 
        make it finalised 
        update distance of all its unfinalised neighbours if they can become smaller 
    ```

  - Can use min heap to get the min dist node to improve time complexity 

#### Bellmanford Algo

  - Single source shortest path
  - Any kind of weight 
  - $O(E.V)$

    ```
    Use dist[]: initialised as inf, 0 for src 
    loop V-1 times:
        loop for all edges uv:
            if(d[v] > d[u] + weight_u_v ) d[v] = d[u] + weight_u_v
    ```

  - Can do one extra iteration, if weight is getting relaxed then there exist a negative weight cycle 

#### Floyd Warshall

  - $O(V^3)$
  - Shortest path btw all vertex pairs 


<br>

---
---

### Minimum spanning tree

`Only for Undirected, Connected, Weighted graph`

#### Prim's Algo

  - $O(E.logV)$
  - Similar to `Dijkastra's`

  - Idea is to add a vertex in MST set then add the minimum weight edge that connects this set to rest of the graph 

      ```
      Use key[]: initialised as inf, 0 for src 
      Use boolean mst[]: true for nodes who are in mst 
      Loop V times:
          take the minimum key which is not yet included in mst set 
          make mst[u] = true 
          add its key to the result 
          for all its unfinalised neighbours if edge_weight_uv is < key[v]: update key[v] = edge_weight_uv
      ```

  - Can use min heap to get the min key node to improve time complexity 

#### Kruskal's Algo

  - `Better`
  - $O(E.logV)$
  - Uses disjoint sets union 
  - Idea is to sort all edges, add an edge if it does not create cycle. Mst size should be v-1 


<br>

---
---

### Other topics

- Articulation point and bridges:  O(V+E): Smart DFS 
- Kosaraju algo: For minimum number of strongly connected components: Directed graph
- Network flow (usually not asked): Ford Fulkerson
- Eulerian circuit: Reconstruct Itinerary

<br>

---
---

### Neetcode Questions

- Number of Islands: Flod fill algo 
- Max Area of Island: Flod fill algo 
- Pacific Atlantic Water Flow: do dfs from ocean to inside
- Surrounded Regions: do dfs from outside
- Rotting Oranges: used to approach of As Far from Land as Possible
- Course Schedule: Cycle detection, used dfs
- Course Schedule II: Cycle detection, used Kahn's algo 
- Redundant Connection: disjoint set, union find algo 
- Network Delay Time: Dijkastra algo, shortest path from a src
- Swim in Rising Water: modified Dijkastra. Thought of brute force on my but but it would have caused tle so saw approach in video 
- Cheapest Flights Within K Stops: saw video, used bellmann ford, nice problem 
- Reconstruct Itinerary: very interesting, saw the video 
- Min Cost to Connect All Points: prims algo, need to learn the impl
- Clone Graph: serious backtracking, wasnt intuitive, saw sol 
- Word Ladder: kind hard, saw sol

