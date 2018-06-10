package com.cover.test;

import java.util.Scanner;

public class One {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
            int m = in.nextInt();
            int[] stu = new int[n];
            for (int i = 0;i < n;i++) {
            	stu[i] = in.nextInt();
             }
            int q1,q2;
            String c = null;
            
            for (int i = 0;i<m;i++) {
            	c = in.next();
            	q1 = in.nextInt();
            	q2 = in.nextInt();
            	method(c,q1,q2,stu);
            }
		}
	in.close();
}
    private static void method(String c, int a, int b, int[] stu) {  
        int begin,end;     
        if (c.equals("Q")) {  
            end = Math.max(a, b);  
            begin = Math.min(a, b)-1;  
            int max = stu[begin];  
            for (int i = begin; i < end; i++) {  
                if (stu[i] > max) {  
                    max = stu[i];  
                }  
            }  
            System.out.println(max);  
        }  
        if (c.equals("U")) {  
            stu[a - 1] = b;  
        }  
   }  
} 
