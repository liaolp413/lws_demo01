package cn.com.java.lws.utils;

import org.junit.Test;

public class Dome01 {

    @Test
    public void test(){
        int[] num = new int[20];
        num[0] = 0;
        num[1] = 1;
        for (int i=2;i<20;i++){
            num[i] = num[i-1]+num[i-2];
        }
        for (int j=1;j<=20;j++){
            if (j%5==0){
                System.out.println();
            }
            System.out.println(num[j-1]+"");
        }
    }

    @Test
    public void test02(){
        final int N = 10;
        int[] num = new int[N];
        num[0] = 1;
        for (int i=1;i!=N;i++){

            for (int j=0;j!=i;j++){
                System.out.print(num[j]+"\t");
            }
            System.out.println();
            num[i] = 1;
            for (int j=i-1;j!=0;j--){
                num[j] = num[j]+num[j-1];
            }
        }
    }

    @Test
    public void test03(){
        int[][] p = new int[10][];
        for (int i=0;i<p.length;i++){
            p[i] = new int[i+1];
            for (int j=0;j<i;j++){
                if (i==0||j==0||j==i){
                    p[i][j] = 1;
                }else {
                    p[i][j] = p[i-1][j]+p[i-1][j-1];
                }
                System.out.print(p[i][j]+"\t");
            }
            System.out.println();
        }
    }

    @Test
    public void test04(){
        String a=new String("11");
        String b= new String(a);
        boolean equals = a.equals(b);
        System.out.println(equals);
        System.out.println(a==b);
    }
}
