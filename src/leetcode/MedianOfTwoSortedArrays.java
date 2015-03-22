package leetcode;
/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 * @author v11
 */
public class MedianOfTwoSortedArrays {
	int findK(int A[],int p1,int B[],int p2,int k){
		if((A.length-p1) > (B.length-p2)) return findK(B,p2,A,p1,k);
		if(p1 == A.length) return B[p2+k-1];
		if(k == 1){
			System.out.println(p1+" "+p2);
			return Math.min(A[p1],B[p2]);
		}
		int midA = Math.min(k/2 +p1, A.length);
		int midB = Math.min(k/2 +p2, B.length);
		if(A[midA-1] < B[midB-1]){
			int dis = (midA - p1) ;
			return findK(A,midA,B,p2,k-dis);
		}else{
			int dis = (midB - p2) ;
			return findK(A,p1,B,midB,k-dis);
		}
	}
    public double findMedianSortedArrays(int A[], int B[]) {
    	System.out.println(findK(A,0,B,0,(A.length+B.length+1)/2) );
    	System.out.println(findK(A,0,B,0,(A.length+B.length+2)/2) );
		return (findK(A,0,B,0,(A.length+B.length+1)/2) + findK(A,0,B,0,(A.length+B.length+2)/2))*0.5;
    }
    public static void main(String[] args) {
    	int A[]={1,1};
    	int B[]={1,2};
		double n = new MedianOfTwoSortedArrays().findMedianSortedArrays(A, B);
		System.out.println(n);
	}
}
