package src.org.game.frame;
public class AIlrwxnew {
	public static int[][] returnArray;
	int returnArray(int[][] hb,int[][] sb,int[][] box,boolean isMine) {
	    int a;
	    int b;
	    int c = 0;
	    int f = 0;
		int q = 0;
		for(a=0;a<5;a++){
			for(b=0;b<5;b++){
				if(box[a][b]==1){
					c++;
				}
			}
		}
		if(c>9){
			q=1;
		}
		return q;
	}
}
