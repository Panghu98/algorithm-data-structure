package leetcode;

/**
 * @author panghu
 * @title: Solution7
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-10 下午6:47
 */
public class Solution7 {

    public static int reverse(int x) {
        int rev = 0;
        while(x != 0){
            int pop = x % 10;
            x = x / 10;
            //两个if判断进行是否溢出判断  正溢出和负溢出  其实只需要判断头一次即可
            if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)){
                rev = 0;
                break;
            }else if(rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && x < Integer.MIN_VALUE % 10)){
                rev = 0;
                break;
            }
            //翻转  将个位数向上移动，头一个个位数无效
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        int x = 100;
        System.out.println(reverse(x));
    }

}
