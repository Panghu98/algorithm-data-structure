## 题目
给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为
k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积
是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3
的三段，此时得到的最大乘积是18。


## 关键词
贪心算法，动态规划

## 思路
动摇规划典型问题，一般是用地柜来实现，动态规划的话，简单两说就是讲递归的值存起来