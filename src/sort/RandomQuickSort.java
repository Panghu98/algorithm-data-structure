package sort;

import org.junit.Test;

import static sort.PublicMethod.swap;

/**
 * @author panghu
 * @title: RandomQuickSort
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-21 下午9:49
 */
public class RandomQuickSort {

    private void quickSort(int[] arr, int l, int r) {

        if (l >= r){
            return;
        }
        int position = partition(arr,l,r);
        quickSort(arr,l,position-1);
        quickSort(arr,position+1,r);
    }

    /*
     * 对arr[l...r]部分进行partition操作
     * 返回position,是的arr[l...p-1]<arr[p],arr[p+1...r]>arr[p]
     * */
    public static int partition(int[] arr,int left,int right){

        int value = arr[left];
        //这个地方是唯一的区别.在left~right之间生成一个随机数
        int ranNum = left + (int)(Math.random()*(right-left+1));
        //把随机数作为索引,将索引对应值与最后一位值 right 交换
        swap(arr,right,ranNum);
        int position = left;
        //这里的right值是最右边的值 arr[right]是有效的
        for (int i=left+1;i<=right;i++){
            if (arr[i] < value){
                /*
                 * 相关的操作
                 * 1.比初始位置大的数都放在初始位置的右边一个,放一个position的位置增加一
                 * */
                swap(arr,i,++position);
            }
        }

        //走到这一步的时候  arr[l]存放的是分解值,arr[position]存放的是小于分界值
        //自我感觉这一步  有一种一举两得,即将分界值的位置移到了正确位置,也将左值放在了左边
        swap(arr,left,position);
        return position;

    }

    @Test
    public void test(){
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 50 };
        quickSort(a,  0,a.length-1);
        System.err.println("排好序的数组：");
        for (int e : a) {
            System.out.print(e+" ");
        }
    }


}
