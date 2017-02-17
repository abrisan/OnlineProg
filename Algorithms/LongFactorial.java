import java.io.*;
import java.util.*;
import java.math.*;

public class LongFactorial {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();
        System.out.println(fac(N).toString());
        stdin.close();
    }
    
    public static BigInteger fac(int N){
        BigInteger res = new BigInteger("1");
        for(int i = 2; i <= N ; ++i) res = res.multiply(new BigInteger(String.valueOf(i)));
        return res;
    }
    
}
