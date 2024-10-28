// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.*;
class HelloWorld {
    
  public static class Point implements Comparable<Point> {
        int x;
        int y;
        int disSqr;
        int idx;

        public Point(int x, int y, int disSqr, int idx) {
            this.x = x;
            this.y = y;
            this.disSqr = disSqr;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2) {
            return this.disSqr - p2.disSqr;
        }
    }
    public static void main(String[] args) {
       int arr[][]={{3,3},{5,-1},{-2,4}};
       int k=2;
       PriorityQueue<Point>pq=new PriorityQueue<>();
       for(int i=0;i<arr.length;i++){
           int disSqr=arr[i][0]*arr[i][0]+arr[i][1]*arr[i][1];
           pq.add(new Point(arr[i][0],arr[i][1],disSqr,i));
       }
        for(int i=0;i<k;i++){
            System.out.println(pq.remove().idx);
        }
       
    }
}