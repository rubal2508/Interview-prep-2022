https://leetcode.com/problems/unique-paths-iii/


class Solution {
    
    public int solution;
    
    public int uniquePathsIII(int[][] grid) {
        
        solution = 0;
        
        int n = grid.length;
        int m = grid[0].length;
        
        outerloop:
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1) {
                    foo(grid, i, j);
                    break outerloop;
                }
            }
        }
        
        
        return solution;
    }
    
    
    
    public void foo(int[][] grid, int i, int j){
        
        int n = grid.length;
        int m = grid[0].length;
        
        if(i < 0 || j < 0 || i>=n || j>= m) {
            // out of boundary
            return;
        }
        
        if(grid[i][j] == -1){
          //obstable 
            return;
        } 
        
        if(grid[i][j] == 2) {
            // ending square
            validateGrid(grid);
            return;
        }
        
        if(grid[i][j] == 3){
            // already travelled
            return;
        }
        
        grid[i][j] = 3;
        foo(grid, i-1, j);
        foo(grid, i+1, j);
        foo(grid, i, j-1);
        foo(grid, i, j+1);
        grid[i][j] = 0;
        return;
        
    }
    
    
    public void validateGrid(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 0) return;
            }
        }
        
        System.out.println(Arrays.deepToString(grid).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
        System.out.println();

        
        solution++;
        
        return;
    }
    
    
    // DFS 
    // take the starting position go : left right up bottom
    // check if its possible to go
    // while going : mark the path that its travelled
    // if you reach destination : check if all the boxes covered, if not, clear the path
    // if you reach out of boundry or hit s blocker, dont mark the path
    
    // undo marking after each iteration
}