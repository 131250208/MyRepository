package src.org.game.frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BofangDonghua {

	JPanel CTP, ZYP;
	Thread T;
	int Length, Seconds;

	public BofangDonghua(JPanel zyp,// ��Ҫ���õ����
			JPanel JP1,// ���������ĸ������
			int x, int y, int WIDTH, int HEIGHT,// ����������������Ͷ����ĳ���
			int seconds,// ���ż����ʱ�䣨���룩
			String filename,// ���ͼƬ���ļ�������
			int length,// �ж�����ͼҪ����
			String type,// ����ͼƬ�ĸ�ʽ
			boolean loop,// �Ƿ�ѭ������
			int compNum,// ������������������Ƕ����÷��ڵڼ���
			int Pass// ���Ŷ��������ڼ���
	) {
		CTP = JP1;
		ZYP = zyp;
		Length = length;
		Seconds = seconds;
		InputImage input2 = new InputImage(filename, length, type);

		ImageRun it = new ImageRun(JP1, x, y, WIDTH, HEIGHT, compNum, Pass,
				CTP, ZYP);
		it.getImageArray(input2.reImages());// ��ȡ������������

		it.isLoop(loop);
		it.setseconds(seconds);
		// �����߳�
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
		// TODO �Զ����ɵķ������

	}

}
