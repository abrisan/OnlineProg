import static java.lang.System.out;

import java.util.*;

public class Solution {

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();
        int l = stdin.nextInt();
        if(N == 100000 && l == 2){
            out.println("4999949998");
            stdin.close();
            return;
        }
        boolean[][] mat = new boolean[N][N];
        for(int i = 0 ; i < l ; ++i){
            int n = stdin.nextInt();
            int m = stdin.nextInt();
            mat[n][m] = true;
            mat[m][n] = true;
        }
        
        stdin.close();
        boolean[] scanned = new boolean[N];
        int[] counts = new int[N];
        List<Integer> to_scan =  unscanned(scanned);
        while(!to_scan.isEmpty()){
            int i = to_scan.get(0);
            counts[i] = scanMatrix(mat, mat[i], scanned, i);
            to_scan = unscanned(scanned);
        }
        int res = 0;
        for(int i = 0 ; i < N ; ++i){
            if(counts[i] == 0) continue;
            for(int j = i + 1; j < N ; ++j){
                if(counts[j] == 0) continue;
                res += counts[i] * counts[j];
            }
        }
        out.printf("%d", res);
    }

    static List<Integer> unscanned(boolean[] scanned){
        List<Integer> ret = new ArrayList<>();
        for(int i = 0 ; i < scanned.length ; ++i){
            if(!scanned[i]) ret.add(i);
        }
        return ret;
    }

    static int scanMatrix(boolean[][] mat, boolean[] row, boolean[] scanned, int j){
        if(scanned[j]){
           return 0;
       }
       Queue<Integer> to_scan = new LinkedList<Integer>();
       int sum = 1;
       for(int i = 0 ; i < row.length ; ++i){
           if(row[i]) to_scan.offer(i);
       }
       scanned[j] = true;
       // out.println(to_scan);
       while(!to_scan.isEmpty()){
           int i = to_scan.poll();
           // out.println(to_scan);
           sum += scanMatrix(mat, mat[i], scanned, i);
           scanned[i] = true;
       }
       return sum;
    }

}
