package leetcode.problem;
/**
 * https://leetcode.com/problems/integer-to-roman/
 * 
 * @author v11
 */
public class IntegerToRoman_12 {
	int[] weights={1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] tokens={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public String intToRoman(int num) {
    	StringBuilder str = new StringBuilder();
    	while(num>0){
    		for(int i=0;i<tokens.length;i++){
    			if(num >= weights[i]) {
    				num -= weights[i];
    				str.append(tokens[i]);
    				break;
    			}
    		}
    	}
		return str.toString();
        
    }
}
