class Solution {
    
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0 ; i<arr.length-1 ; i++){
            int val1 = arr[i];
            
            for(int j=i+1; j<arr.length ; j++){
                int val2 = arr[j];
                
                double data = (double)val1/val2;
                
                pq.add(new Pair(data , val1 , val2));
                
                if(pq.size() > k){
                    pq.remove();
                }
            }
        }
        
        int[] res = new int[2];
        
        res[0] = pq.peek().val1;
        res[1] = pq.peek().val2;
        
        return res;
    }
    
    public class Pair implements Comparable<Pair>{
        double data ; 
        int val1 ;
        int val2 ;
        
        Pair(double data , int val1 , int val2){
            this.data = data;
            this.val1 = val1; 
            this.val2 = val2;
        }

        public int compareTo(Pair o){
            if(this.data > o.data){
                return 1;
            }
            return -1;
        }
    }
    
    
}
