package array;

//二分查找给定元素在数组中的起始位置和结束位置
public class LeetCode34 {
    public static void main(String[] args) {
        LeetCode34 leetCode34=new LeetCode34();
        int[] num = new int[]{2, 2};
        int []ans=leetCode34.solution(num,2);

    }
    public int[] solution(int [] num,int target){
        int []ans ={-1,1};
        if(num.length==0){   //空返回规定的数
            return ans;
        }
        if(num.length==1&&num[0]==target){
            return new int[]{0,0};
        }
        int firstpos=-1;
        int start=0;
        int end=0;
        int left=0;
        int right=num.length-1;
        while(left<=right){
            int middle=(left+right)/2;
            if(num[middle]<target){
                left=middle+1;
            }
            else if(num[middle]>target){
                right=middle-1;
            }
            else{
                firstpos=middle;
                break;

            }
        }
        System.out.println("firstpos="+firstpos);
       if(firstpos==-1){
           return ans;
       }
        //接下来要找区间
        int a=num[firstpos];
        int l=firstpos;
        int r=firstpos;
        for(int i=0;i<firstpos;i++){
            if(num[i]==a){
                l=i;
                break;
            }

        }
        System.out.println("l="+l);
        for(int i=right;i>firstpos+1;i--){
            if(num[i]==a){
                r=i;
                break;
            }
        }
        System.out.println("r="+r);
        ans[0]=l;
        ans[1]=r;
        return ans;
    }

}
