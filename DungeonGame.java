class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int res = find(dungeon, 0, 0, 0, 0);
        res = -res + 1;
        return res;
    }
     public static int find(int[][] map, int x, int y, int min, int sum) {
        if (x == map.length || y == map[0].length) {
            return Integer.MIN_VALUE;
        }
        if (x == map.length - 1 && y == map[0].length - 1) {
            return Math.min(min, sum += map[x][y]);
        }
        sum += map[x][y];
        min = Math.min(min, sum);
        min = Math.max(find(map, x, y + 1, min, sum), find(map, x + 1, y, min, sum));
        return min;
    }
public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        dp[dungeon.length-1][dungeon[0].length-1] =1 ;
        for(int i =dungeon[0].length-2;i>=0;i--){
            dp[dungeon.length-1][i]=Math.max(1, dp[dungeon.length-1][i+1]-dungeon[dungeon.length-1][i+1]);
        }
        for(int i =dungeon.length-2;i>=0;i--){
            dp[i][dungeon[0].length-1]=Math.max(1, dp[i+1][dungeon[0].length-1]-dungeon[i+1][dungeon[0].length-1]);
        }
        for(int i=dungeon.length-2;i>=0;i--){
            for(int j=dungeon[0].length-2;j>=0;j--){
                int right =Math.max(dp[i][j+1]-dungeon[i][j+1], 1);
                int down =Math.max(dp[i+1][j]-dungeon[i+1][j], 1);
                dp[i][j]=Math.min(right,down);
            }
        }
        return Math.max(dp[0][0]-dungeon[0][0], 1);
    }
}
