class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points ,(a,b) -> Integer.compare(a[0],b[0]));
        
        int[] previous = points[0];
        int arrows =1;
        
        for(int i=1;i<points.length;i++){
            int currentStartPoint = points[i][0];
            int currentEndPoint = points[i][1];
            
            int previousStartPoint = previous[0];
            int previousEndPoint = previous[1];
            
            if(currentStartPoint > previousEndPoint){  // no overlapping
                arrows++;
                previous = points[i];
            }else{
                // if currentStartPoint < previousEndPoint ---> overlapping
                previous[0] = Math.max(previousStartPoint , currentStartPoint);
                previous[1] = Math.min(previousEndPoint , currentEndPoint);
            }
        }
        return arrows;
    }
}
