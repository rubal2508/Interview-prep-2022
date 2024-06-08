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
  - Do DFS, the last leaf node to be put into a stack first so it can be printed in last

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

#### Normal
- [Number of Islands](https://leetcode.com/problems/number-of-islands/): Flod fill algo 
- [Max Area of Island](https://leetcode.com/problems/max-area-of-island/): Flod fill algo 
- [Clone Graph](https://leetcode.com/problems/clone-graph/): serious backtracking, wasnt intuitive, saw sol 
- [Walls and Gates](https://leetcode.com/problems/walls-and-gates/): Doable
- [Rotting Oranges](https://leetcode.com/problems/rotting-oranges/): used to approach of As Far from Land as Possible
- [Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow/): do dfs from ocean to inside
- [Surrounded Regions](https://leetcode.com/problems/surrounded-regions/): do dfs from outside
- [Course Schedule](https://leetcode.com/problems/course-schedule/): Cycle detection, used dfs
- [Course Schedule II](https://leetcode.com/problems/course-schedule-ii/): Cycle detection, used Kahn's algo 
- [Graph Valid Tree](https://leetcode.com/problems/graph-valid-tree/): union find and the property of tree that edges = n-1
- [Number of Connected Components in an Undirected Graph](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/): easy
- [Redundant Connection](https://leetcode.com/problems/redundant-connection/): disjoint set, union find algo 
- [Word Ladder](https://leetcode.com/problems/word-ladder/) ⭐️ kind hard, saw sol
  - If we can build a graph of words (where 2 words are connected if they have 1 character diff) then we can simply run bfs and find the distance.
  - We can optimise building the graph by having patterns as key and list of words as value. Neighbour of a word is all the lists of all patterns it can make

#### Advanced
- [Reconstruct Itinerary](https://leetcode.com/problems/reconstruct-itinerary/) ⭐️ 
  - very interesting, saw the video 
  - Sort the edges `uv` based on `v`, so neighbours in adj_list are in sorted order
  - Cant use visited array as we can visit the nodes multiple times. So how to do?
  - Keep removing the edges(neighbours) from adj_list once you use it, and add the node in sol list
  - You can say you have used all edges once len(sol) = len(tickets) + 1
  - How to backtrack? add/remove from sol list, add/remove neighbours
  - Earlier this solution was working but now leetcode has put TLE for this

- [Min Cost to Connect All Points](https://leetcode.com/problems/min-cost-to-connect-all-points/) ⭐️ Minimum spaning tree problem
- [Network Delay Time](https://leetcode.com/problems/network-delay-time/) ⭐️ Dijkastra algo, shortest path from a src
- [Swim in Rising Water](https://leetcode.com/problems/swim-in-rising-water/) ⭐️ 
  - modified Dijkastra. Thought of brute force on my but but it would have caused tle so saw approach in video 
  - use pq to get the node with min weight
  - We dont need a finalised set because weight will never be reduced, so we only use the visited set
- [Alien Dictionary](https://leetcode.com/problems/alien-dictionary/) ⭐️ 
  - Topological sort
  - Why are we comparng only adjacent words? why not all the word pairs?
- [Cheapest Flights Within K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/) ⭐️ 
  - saw video, used bellmann ford, nice problem 
  - we need to clone dist array at each iteration because we want to limit the updates going beyond k
  - `dist[v] = Math.min(dist[v], distClone[u]+w)`


