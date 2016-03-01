package src.org.game.frame;
public class AImachao extends AIcomputer{
	public static int[][] returnArray;
	public int returnArray(int[][] hb,int[][] sb,int[][] box,int step,boolean isMine) {
		int a;
		int b;
		int c=0;
		int[][] boxscan = new int[5][5];
		for(a=0;a<5;a++){
			for(b=0;b<5;b++){
				boxscan[a][b] = box[a][b];
			}
		}
		if(step==1){			//1是限制不能走竖边。
			for(a=0;a<6;a++){
				for(b=0;b<5;b++){
					if(sb[a][b]==0){
						sb[a][b]=3;
					}
				}
			}
			AIeasy computer = new AIeasy();
			computer.returnArray(hb, sb, box, step, isMine);
			for(a=0;a<6;a++){
				for(b=0;b<5;b++){
					if(sb[a][b]==3){
						sb[a][b]=0;
					}
				}
			}
			for(a=0;a<5;a++){
				for(b=0;b<5;b++){
					if(box[a][b]!=0 && hb[a][b]*hb[a+1][b]*sb[b][a]*sb[b+1][a]==0){
						box[a][b]=0;
					}
				}
			}
		}
		if(step==2){			//2是限制不能走横边。
			for(a=0;a<6;a++){
				for(b=0;b<5;b++){
					if(hb[a][b]==0){
						hb[a][b]=3;
					}
				}
			}
			AIeasy computer = new AIeasy();
			computer.returnArray(hb, sb, box, step, isMine);
			for(a=0;a<6;a++){
				for(b=0;b<5;b++){
					if(hb[a][b]==3){
						hb[a][b]=0;
					}
				}
			}
			for(a=0;a<5;a++){
				for(b=0;b<5;b++){
					if(box[a][b]!=0 && hb[a][b]*hb[a+1][b]*sb[b][a]*sb[b+1][a]==0){
						box[a][b]=0;
					}
				}
			}
		}
		for(a=0;a<5;a++){
			for(b=0;b<5;b++){
				if(boxscan[a][b] < box[a][b]){
					c=1;
				}
			}
		}
		return c;
	}
}
