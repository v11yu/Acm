package leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 3分+枚举 NlogN
 * 
 * @author v11
 */
public class Sum3Closest {
	int ans,dif=-1;
	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		System.out.println(Arrays.toString(num));
		int l=0,r=num.length-1;
		while(l+2<r){
			int m1 = (l*2+r)/3;
			int m2 = (l+2*r)/3;
			System.out.println("m1:"+m1+" m2:"+m2);
			if(getAns(m1,num,target) < getAns(m2,num,target)) r = m2;
			else l = m1;
			System.out.println("l:"+l+" r:"+r);
		}
		getAns(l,num,target);
		getAns(l+1,num,target);
		getAns(r,num,target);
		return ans;
	}
	public int getAns(int pos,int[] num, int target){
		int min_dif = -1,res=1000000000;
		int bg = 0,ed = num.length-1;
		while(bg<ed){
			int sum = num[pos] + num[bg] + num[ed];
			if(pos == bg ){
				bg++;
				continue;
			}
			if(pos == ed){
				ed--;
				continue;
			}
			
			if(min_dif == -1 || Math.abs(sum - target) < min_dif) {
				res = sum;
				min_dif = Math.abs(sum - target);
				if(dif == -1||min_dif<dif) {
					dif = min_dif;
					ans = res;
				}
			}
			if(sum <target) bg++;
			else ed--;
		}
		System.out.println(res);
		return min_dif;
	}
	public static void main(String[] args) {
		int num[] = {-10,0,-2,3,-8,1,-10,8,-8,6,-7,0,-7,2,2,-5,-8,1,-4,6};
		int target = 18;
		System.out.println(new Sum3Closest().threeSumClosest(num,target));
	}
}