import java.util.Scanner;
import java.util.Arrays;
public class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int rows=sc.nextInt();
        while(rows>0){
            int n=sc.nextInt(),k=sc.nextInt();
            Integer[] nums=new Integer[n];
            for(int i=0;i<n;i++){
                nums[i]=sc.nextInt();
            }
            Arrays.sort(nums);
            int l=-1,r=-1,left=nums[0],curNum=left,cur=0;
            while(cur<n){
                int c=0,p=cur,num=nums[cur];
                if(num>curNum){
                    int diff=curNum-1-left;
                    if(diff>=r-l){
                        r=curNum-1;
                        l=left;
                    }
                    curNum=num;
                    left=num;
                }
                while(p<n&&nums[p]==num){
                    p++;
                    c++;
                }
                if(c<k||(p==n&&c>=k)){
                    if(p==n&&c>=k){
                        int diff=num-left;
                        if(diff>=r-l){
                            r=num;
                            l=left;
                        }
                        break;
                    }
                    int diff=num-1-left;
                    if(diff>=r-l){
                        r=num-1;
                        l=left;
                    }
                    if(p==n){
                        break;
                    }
                    left=nums[p];
                    curNum=left;
                }else{
                    curNum++;
                }
                cur=p;
            }
            System.out.println(l==-1?-1:(l+" "+r));
            rows--;
        }
    }
}