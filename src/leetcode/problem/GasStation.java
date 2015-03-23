package leetcode.problem;

/**
 * https://leetcode.com/problems/gas-station/
 * 
 * @author v11
 */
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int sum = 0 ,p=0;
		for(int i=0;i<cost.length;i++){
			cost[i] = gas[i] - cost[i];
			sum+=cost[i];
		}
		if(sum<0) return -1;
		sum=0;
		for(int i=0;i<cost.length;i++){
			if(sum<0){
				sum=0;
				p=i;
			}
			sum+=cost[i];
			
		}
		return p;
	}
}
