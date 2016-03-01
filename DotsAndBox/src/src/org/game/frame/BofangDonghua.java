package src.org.game.frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BofangDonghua {

	JPanel CTP, ZYP;
	Thread T;
	int Length, Seconds;

	public BofangDonghua(JPanel zyp,// 需要引用的面板
			JPanel JP1,// 动画加在哪个面板上
			int x, int y, int WIDTH, int HEIGHT,// 动画加在面板的坐标和动画的长宽
			int seconds,// 播放间隔的时间（毫秒）
			String filename,// 存放图片的文件夹名称
			int length,// 有多少张图要播放
			String type,// 播放图片的格式
			boolean loop,// 是否循环播放
			int compNum,// 组件数量，用来方便标记动画该放在第几层
			int Pass// 播放动画后进入第几关
	) {
		CTP = JP1;
		ZYP = zyp;
		Length = length;
		Seconds = seconds;
		InputImage input2 = new InputImage(filename, length, type);

		ImageRun it = new ImageRun(JP1, x, y, WIDTH, HEIGHT, compNum, Pass,
				CTP, ZYP);
		it.getImageArray(input2.reImages());// 获取动画对象数组

		it.isLoop(loop);
		it.setseconds(seconds);
		// 启动线程
		Thread t = new Thread(it);
		T = t;

	}

	public int retime() {

		return Length * Seconds;

	}

	public void vediostart() {
		T.start();
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
