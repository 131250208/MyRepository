package src.org.game.frame;

public class SetMusic {
	//����
//	PlayMusic musicPlay ;
	AudioPlayer musicPlay2;
	AudioPlayer musicPlay;
	boolean loop;
	int MOS;
	 
	public SetMusic(String s//���ֵ�ַ
			,boolean Loop
			,int mOS//���ֻ�����Ч 1���� 2��Ч
			){
	if(mOS==1){
		musicPlay=new AudioPlayer(s);
		musicPlay.num=1;
	}
	else if(mOS==2){
		musicPlay2=new AudioPlayer(s);
		musicPlay2.num=2;
	}
		MOS=mOS;
		loop=	Loop;	
		
	}
	
	public void play(){
		if(new GetSetting().Music==1&&MOS==1){
			//���ֿ�ʼ
				//��������ѭ��
				 if(loop==true){
					 musicPlay.playloop();
				 }
				 else{
					 musicPlay.playnoloop();
				 }
			}
			if(new GetSetting().Sound==1&&MOS==2){
				//��Ч��ʼ
				//��������ѭ��
				 if(loop==true){
					 musicPlay2.playloop();
				 }
				 else{
					 musicPlay2.playnoloop();
				 }
				}
	}
	public void stop(){
		if(MOS==1){
			musicPlay.stop();
		}

		else if(MOS==2){
			musicPlay2.stop();
		}
		
	}
	
	public static void main(String[] args) {
		//���ֿ�ʼ
				SetMusic musicZJM=new SetMusic("src/music/action/enter.mp3",false,1); 
				musicZJM.play();
	}
}
