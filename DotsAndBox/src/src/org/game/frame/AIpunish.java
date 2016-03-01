
package src.org.game.frame;
public class AIpunish {
	public static int[][] returnArray;
	static int returnArray(int[][] hb,int[][] sb,int[][] box,int step,boolean isMine) {
		int a;
		int b;
		int c = 0;
		int d;
		int e = 0;
		boolean end = false;
		for(a=0;a<6;a++){
			for(b=0;b<5;b++){
				if(hb[a][b] == 0){
					c++;
				}
			}
		}
		for(a=0;a<6;a++){
			for(b=0;b<5;b++){
				if(sb[a][b] == 0){
					c++;
				}
			}
		}
		d=(int)(Math.random()*c);
		for(a=0;a<6;a++){
			for(b=0;b<5;b++){
				if(hb[a][b] == 0 && end == false){
					if(d == 0){
						hb[a][b] = 1;
						end = true;
					}
					d--;
				}
			}
		}
		for(a=0;a<6;a++){
			for(b=0;b<5;b++){
				if(sb[a][b] == 0 && end == false){
					if(d == 0){
						hb[a][b] = 1;
						end = true;
					}
					d--;
				}
			}
		}
		for(a=0;a<5;a++){
			for(b=0;b<5;b++){
				if(hb[a][b]!=0 && hb[a+1][b]!=0 && sb[b][a]!=0 && sb[b+1][a]!=0 && box[a][b]==0){
					box[a][b] = 1;
					e++;
				}
			}
		}
		if(e>0){
			e=1;
		}
		return e;
	}
}