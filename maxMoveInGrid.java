import java.util.*;

class maxMoveInGrid {
    public static int maxMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans = 0;
        int dp[][] = new int[n][m];
        for (int c = 1; c < m; c++) {
            for (int r = 0; r < n; r++) {
                int temp = 0;
                if ((r - 1) >= 0 && grid[c][r] > grid[c][r - 1] && (r == 1 || dp[c][r - 1] > 0)) {
                    temp = Math.max(temp, dp[c][r - 1] + 1);
                }

                if ((c - 1) >= 0 && (r - 1) >= 0 && (grid[c][r] > grid[c - 1][r - 1]) && (r == 1 || dp[c][r - 1] > 0)) {
                    temp = Math.max(temp, dp[c - 1][r - 1] + 1);
                }

                if ((c + 1) < n && (r - 1) >= 0 && (grid[c][r] > grid[c + 1][r - 1])
                        && (r == 1 || dp[c + 1][r - 1] > 0)) {
                    temp = Math.max(temp, dp[c + 1][r - 1] + 1);
                }

                dp[c][r] = temp;
                ans = Math.max(ans, dp[c][r]);
            }
        }

        return ans;
    }

    public static void main(String []args){
        /* Scanner sc=new Scanner(System.in);
         * taking user input
         * int n=sc.nextInt();
         * int m=sc.nextInt();
         * int grid[][]=new in[n][m];
         * for(int i=0; i<n; i++){
         *     for(int j=0; j<m; j++){
         *         grid[i][j]=sc.nextInt();
         *     }
         * }
         * System.out.println("Maximum Move is: "+maxMoves(grid));
        */
        int grid[][]={{2,4,3,5},{5,4,9,3},{3,4,2,11},{10,9,13,15}};
        System.out.println("Maximum Move is: "+maxMoves(grid));
    }
}
