import java.util.ArrayList;

public class PerfectSquare {

	public void fill(int [][] sol, int n, ArrayList<Integer> squares){
		
		for(int i=0;i<squares.size();i++){
			
			for(int j=0;j<=n;j++){
				
				if(i==0){
					sol[i][j] = j;
				}
				
				else if(j<squares.get(i)){
					sol[i][j] = sol[i-1][j];
				}
				else{
					int diff = j - squares.get(i);
					sol[i][j] = Math.min(sol[i-1][j], 1+sol[i][diff]);
				}
			}
		}
		System.out.println(sol[squares.size()-1][n]);
	}
	
	public void better(int[]sol, int n, ArrayList<Integer> squares){
		
		for(int i=0;i<squares.size();i++){
			int min = Integer.MAX_VALUE;
			int j=0;
			for(;j<sol.length;j++){
				
				if(j<squares.get(i)){
					min = Math.min(sol[j-squares.get(i)], min);
				}
			}
			sol[j] = min;
		}
		
		System.out.println(sol[n-1]);
	}
	
	public int calc(int x){
		  if(x==0||x==1){
	            return x;
	        }
	        
	        int start = 0;
	        int end = x;
	        int ans=0;
	        while(start < end){
	            
	            int mid = (start+end)/2;
	            
	            if(mid*mid==x){
	                return mid;
	            }
	            else if(mid*mid < x){
	                start = mid+1;
	                ans = mid;
	            }
	            else{
	                end = mid-1;
	            }
	        }
	        return ans;
	}
	public static void main(String[] args) {
		int n=13;
		ArrayList<Integer> squares = new ArrayList<Integer>(); 
		for(int i=1;i*i<=n;i++){
			squares.add(i*i);
		}
		
		PerfectSquare pf = new PerfectSquare();
		int [][] sol = new int[squares.size()][n+1];
		
		pf.fill(sol, n, squares);
		int [] x = new int[n];
		//pf.better(x, n, squares);
		
		
		//System.out.println(pf.calc(2147395599));
        
      
		
		String s = "HelloWorld";
		String s1 = "llo";
		
		System.out.println(s.indexOf(s1));
		
		String [] strs = {"abc","abcdef","ab"};
		System.out.println("abc".indexOf("ab"));
		//System.out.println(pf.longestCommonPrefix(strs));
	}
	
	
	public String longestCommonPrefix(String[] strs) {
	    if(strs == null || strs.length == 0)    return "";
	    String pre = strs[0];
	    int i = 1;
	    while(i < strs.length){
	        while(strs[i].indexOf( pre) != 0){
	            pre = pre.substring(0,pre.length()-1);
	        	System.out.println(pre);
	        }
	        i++;
	    }
	    return pre;
	}
}
