package leetcode.problem;
/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 * @author v11
 */
public class SearchinRotatedSortedArray {
	int findMaxNumber(int[] A){
		int l = 0, r = A.length - 1;
		if(A[r]>A[l]) return r;
		while (l + 1 < r) {
			int mid = (l + r) >> 1;
			if(A[mid] > A[0]) l = mid;
			else r = mid;
		}
		if(A[r]>A[l]) return r;
		return l;
		
	}
	int findNum(int[] A,int l,int r,int target){
		if(l>r) return -1;
		while(l+1<r){
			int mid = (l+r)>>1;
			if(A[mid] < target) l = mid;
			else r = mid;
		}
		if(A[l] == target) return l;
		if(A[r] == target) return r;
		return -1;
	}
	public int search(int[] A, int target) {
		//find the MaxNumber idx
		int h = findMaxNumber(A);
		int l = findNum(A,0,h,target);
		if(l !=-1) return l;
		int r = findNum(A,h+1,A.length-1,target);
		if(r!=-1) return r;
		return -1;
	}
}
