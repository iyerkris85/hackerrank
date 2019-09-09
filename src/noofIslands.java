public class noofIslands {

    public static int[] visitcol = {-1,1,0,0};
    public static int[] visitrow = {0,0,-1,1};

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

        System.out.println(numIslands(samplegrid1));
    }


    public static int numIslands(char grid[][]) {

        int islands = 0;

        //Keep a track of nodes that have been traversed
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0; j<grid[i].length;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    traverseAdjacent(grid, i, j, visited);
                    ++islands;
                }

            }
        }
        return islands;

    }

    public static void traverseAdjacent(char grid[][], int row, int column, boolean visited[][]){

        visited[row][column] =  true;
        for(int i=0;i<4;i++){
            if(isSafe(grid,visited,row+visitrow[i],column+visitcol[i])){
                traverseAdjacent(grid,row+visitrow[i],column+visitcol[i],visited);
            }
        }

    }

    //Logic to deduce islands
    public static boolean isSafe(char grid[][],boolean visited[][],int row, int column){
        if(  (column >= 0) && (row >= 0) && (column < grid[0].length) && (row < grid.length) && (grid[row][column] == '1') && !visited[row][column]){
            return true;
        }else{
            return false;
        }
    }
}
