package leetcode.model;

import java.util.ArrayList;
import java.util.List;

public class Point {
    public int x;
    public int y;
    public Point() { x = 0; y = 0; }     
    public Point(int a, int b) { x = a; y = b; }
    /**
     * (0,-12),(5,2),(2,5)
     * @param str
     * @return
     */
    public static Point[] getPoints(String str){
    	List<Point> ps = new ArrayList<Point>();
    	String[] ss = str.split(",");
    	Integer fir = null;
		Integer sec = null;
    	for(int i=0;i<ss.length;i++){
    		String tmp;
    		if(i%2 ==0 ){
    			tmp = ss[i].substring(1);
    			fir = Integer.parseInt(tmp);
    		}else{
    			tmp = ss[i].substring(0, ss[i].length()-1);
    			sec = Integer.parseInt(tmp);
        		ps.add(new Point(fir, sec));
    		}
    	}
    	Point ls[] = new Point[ps.size()];
    	return ps.toArray(ls);
    }
}
