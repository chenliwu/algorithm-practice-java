

public class Solution {

    public static void main(String[] args) {
        // System.out.println(new Solution().Sum_Solution(5));
        System.out.println("123456781".substring(0,8));
    }

    public int Sum_Solution(int n) {
        if(n==1){
            return 1;
        }
        return n+Sum_Solution(n-1);
    }


}