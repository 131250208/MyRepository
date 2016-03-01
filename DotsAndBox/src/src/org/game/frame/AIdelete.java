package src.org.game.frame;


public class AIdelete {
	public static int[][] returnArray;
	int returnArray(int[][] hb,int[][] sb,int[][] box,int step,boolean isMine) {
	    int a;
	    int b;
	    int k = 0;
	    int q = 0;
		for(a=0;a<5;a++){
			for(b=0;b<4;b++){
				if(box[a][b]==1 && box[a][b+1]==1 && q==0){
					box[a][b] = 0;
					box[a][b+1] = 0;
					sb[b+1][a] = 0;
					q=1;
				}
			}
		}
	    if(q == 0){
	    	for(a=0;a<4;a++){
				for(b=0;b<5;b++){
					if(box[a][b]==1 && box[a+1][b]==1 && q==0){
						box[a][b] = 0;
						box[a+1][b] = 0;
						hb[a+1][b] = 0;
						q=1;
					}
				}
			}
	    }
	    if(q == 0){
		    for(a=0;a<5;a++){
		    	for(b=0;b<5;b++){
		    		if(box[a][b] == 0){
		    			k++;
		    		}
		    	}
		    }
		    if(k<=13){
		    	for(a=0;a<5;a++){
		    		for(b=0;b<5;b++){
		    			if(box[a][b] == 1 && q == 0){
		    				if(b == 4){
		    					box[a][b-1] = 0;
		    					box[a][b] = 0;
		    					sb[b][a] = 0;
		    					q=1;
		    				}
		    				else{
		    					box[a][b] = 0;
		    					box[a][b+1] = 0;
		    					sb[b+1][a] = 0;
		    					q=1;
		    				}
		    			}
		    		}
		    	}
		    }
	    }	
		return q;
	}
}
