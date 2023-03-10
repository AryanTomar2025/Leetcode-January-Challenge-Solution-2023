class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalgas = Arrays.stream(gas).sum();  // total sum of gas using inbuilt function in java
        int totalcost = Arrays.stream(cost).sum(); // total sum of cost using inbuilt function in java
        
        if(totalcost>totalgas)return -1; // if totalcost is greater than totalgas then it is impossible to  cover circular track
        
		// if totalcost is less than totalgas  or totalcost is equal to totalgas then then it is 100% that their is any index present in gas array  by which we can complete a circular track
        int resultIndex =0; 
        int total =0;
        
        for(int i=0;i<gas.length;i++){
            total += gas[i] - cost[i];
            
            if(total<0){  // if total is less than 0 then this is not a correct index  we will move to next index and total is upadated to 0
                resultIndex = i+1;
                total =0;
            }
        }
        return resultIndex;
    }
}
