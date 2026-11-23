class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0],profit=0;
        for(int price : prices){
            if(price < min)
                min=price;
            profit = Math.max((price - min),profit);
        }  
        return profit;      
    }
}