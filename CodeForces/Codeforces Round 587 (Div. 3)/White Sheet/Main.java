package whitesheet;

import java.util.*;
 
 
public class Main {
	public static void main(String[] args) {
		Scanner io = new Scanner(System.in);
		int x1=io.nextInt();  //read in coordinates
	    int y1=io.nextInt();
	    int x2=io.nextInt();
	    int y2=io.nextInt();   
	    int x3=io.nextInt();
	    int y3=io.nextInt();    
	    int x4=io.nextInt();
	    int y4=io.nextInt();    
	    int x5=io.nextInt();
	    int y5=io.nextInt();
	    int x6=io.nextInt();
	    int y6=io.nextInt();
	    if(y3<=y1&&y4>=y2&&x1>=x3&&x2<=x4){ //all cases to check if white can be seen ontop of black
	    	System.out.println("NO");
	    }else if(y6>=y2&&y5<=y1&&x5<=x1&&x6>=x2){
	    	System.out.println("NO");
	    }else if((x5<=x1&&x3<=x1&&x6>=x2&&x4>=x2&&y3<=y6&&y4>=y2&&y5<=y1)||(x5<=x1&&x3<=x1&&x6>=x2&&x4>=x2&&y5<=y4&&y6>=y2&&y3<=y1)){
	    	System.out.println("NO");
	    }else if((y4>=y2&&y3<=y1&&y6>=y2&&y5<=y1&&x3<=x1&&x6>=x2&&x4>=x5)||(y4>=y2&&y3<=y1&&y6>=y2&&y5<=y1&&x5<=x1&&x4>=x2&&x6>=x3)){
	    	System.out.println("NO");
	    }else{
	    	System.out.println("YES");
	    }
		io.close();
	
	}
}