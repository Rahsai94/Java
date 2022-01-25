import java.util.*;

class GFG{


    public static void main(String args[])
    {

            int[] b = new int[]{8,8,4,3};

            int k = 2, n = b.length;

            int[] v = new int[b.length*2];

            for(int i=0;i<v.length;i++)
            {
                v[i]=b[i%b.length];
            }

            int  res = Integer.MAX_VALUE;

            for(int start = k; start <= n; start++)
            {
                int m = n-k;

                int mn = Integer.MAX_VALUE, mx = Integer.MIN_VALUE;

                for(int j=0;j<m; j++)
                {
                    int idx = start+j;
                    mn= Math.min(mn, v[idx]);
                    mx= Math.max(mx, v[idx]);
                }
                res = Math.min(res, mx-mn);
            }

            System.out.println(res);
        }

    }

 