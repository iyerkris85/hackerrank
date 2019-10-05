package linkedin;

public class numIslandsCount {
    public int numIslands(char[][] grid) {

        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length;  j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    count++;
                    markVisited(grid, i, j, visited);
                }
            }
        }

        return count;
    }

    private void markVisited(char[][] grid, int x, int y, boolean[][] visited){

        if(x < 0 || y< 0 || x>grid.length-1 || y > grid[x].length-1 ){
            return;
        }
        if(visited[x][y]){
            return;
        }
        visited[x][y] = true;
        if(grid[x][y] == '0'){
            return;
        }
        markVisited(grid,x+1, y, visited);
        markVisited(grid,x-1, y, visited);
        markVisited(grid,x, y+1, visited);
        markVisited(grid,x, y-1, visited);
    }

    public static void main(String args[]){



        char[][] samplegrid1 = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
        };
        char[][] samplegrid2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'},
        };


        numIslandsCount sample = new numIslandsCount();
        System.out.println(sample.numIslands(samplegrid2));
    }

}
