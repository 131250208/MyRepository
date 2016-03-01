package src.org.game.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public final class StartFlash extends Panel implements Runnable{
	// ���Ի���
    private int _MAX_COUNT = 10;

    //������
    private char _flag='|';
    
    private Image _screen;

    private Graphics _bg;

    private Thread _L_WriterType;

    private static Color _L_fClr;

    private static Color _L_bClr;

    private static String _M_Text[];

    private int _S_COUNT;

    private Font _L_TTF;

    private int _L_Speed;

    private int _L_Delay;

    private String _C_Text[];

    private static int _L_COUNT;

    private static int _F_COUNT;
    
    private static int _T_COUNT;

    private static int _N_Text;

    private String _FontName;

    private final static int _WIDTH = 500;

    private final static int _HEIGHT = 375;

    private static int _FontStyle;

    private static int _FontSize;

    private static    Image _back = null;

  
    private static final long serialVersionUID = 1L;

    private boolean _isRun;

    /** *//**
     * ��������,ע�뱳��ͼ,ѭ����ʾ����������,�ٶ�,�ӳ�
     * @param img
     * @param strContent
     * @param speed
     * @param delay
     */
  

    public StartFlash(Image img,String[] strContent, int speed, int delay) {
            init(img,strContent, speed, delay);
    }

    public void init(Image img,String[] strContent, int speed, int delay) {
            //��ʼ����ɫ
            setBackground(Color.BLACK);
            // ԭʼ�Ի���Ϣ
            _M_Text = new String[_MAX_COUNT];
            // ����Ի���Ϣ
            _C_Text = new String[_MAX_COUNT];

            _back=img;
            _FontName = "����";

            _FontStyle = 0;

            _FontSize = 15;

            _L_TTF = new Font(_FontName, _FontStyle, _FontSize);
            _L_bClr = Color.BLACK;
            _L_fClr = new Color(250, 250, 250);

            int length = strContent.length;

            // ѭ������
            _N_Text = strContent.length - 1;

            // ֱ��copy String����
            System.arraycopy(strContent, 0, _M_Text, 0, length);

            //�ٶȼ��ӳ��趨
            _L_Speed = speed;
            _L_Delay = delay;
            
            //��������
            _screen = new BufferedImage(_WIDTH, _HEIGHT, 1);
            _bg = _screen.getGraphics();

            //�����߳�
                    _isRun = true;
                    _L_WriterType = new Thread(this);
                    _L_WriterType.start();
            
    }

    /** *//**
     * ֹͣ�߳�
     *
     */
    public void stop() {
            _S_COUNT = 0;
            _L_COUNT = 0;
            _F_COUNT = 0;
            if (_L_WriterType != null) {
                    _isRun = false;
                    _L_WriterType = null;
            }
    }

    /** *//**
     * ����ͼ��
     */
    public void paint(Graphics g) {
            _bg.setColor(_L_bClr);
            _bg.fillRect(0, 0, _WIDTH, _HEIGHT);
            _bg.setColor(_L_fClr);
            _bg.setFont(_L_TTF);
            _bg.drawImage(_back, 0, 0, this);
            for (int i = 0; i <= _L_COUNT; i++) {
                    //ת����ǰ����topλ��
                    Double top = new Double((double) _FontSize
                                    * (3.0D + 2.0D * (double) i));
                    if (_C_Text[i] != null) {
                            _bg.drawString(_C_Text[i], 50, top.intValue());
                    }
            }

            g.drawImage(_screen, 0, 0, this);
    }

    /** *//**
     * ͼ�α��
     */
    public void update(Graphics g) {
            paint(g);
    }

    /** *//**
     * ���¿�ʼ
     *
     */
    private void begin() {
            //������л������ݡ�
            for (int i = 0; i < _C_Text.length; i++) {
                    _C_Text[i] = null;
            }
            _F_COUNT = 0;
            _S_COUNT = 0;
            _L_COUNT = 0;
            _T_COUNT++;
            if (_T_COUNT > _N_Text) {
                    _T_COUNT = 0;
            }
            repaint();
    }

    public void run() {
            while (_isRun) {
                    try {

                            //�ַ����ۼ�
                            _S_COUNT++;
                            //���ַ���������ζԻ�ʱ
                            if (_S_COUNT == _M_Text[_T_COUNT].length()) {
                                    _C_Text[_L_COUNT] = _M_Text[_T_COUNT].substring(_F_COUNT,
                                                    _S_COUNT);
                                    begin();
                                    Thread.sleep(_L_Delay);
                                    repaint();
                            }
                            //�ȶԱ�ʶ�趨����Ի�
                            if (_M_Text[_T_COUNT].charAt(_S_COUNT) != _flag) {
                                    _C_Text[_L_COUNT] = _M_Text[_T_COUNT].substring(_F_COUNT,
                                                    _S_COUNT)
                                                    + "_";
                            } else {
                                    _C_Text[_L_COUNT] = _M_Text[_T_COUNT].substring(_F_COUNT,
                                                    _S_COUNT);
                            }
                            //���Էֱ��Ƿ�ת���Ի���ʱ�Ĳ�ͬ�ӳ�
                            boolean shortSleep;
                            //��'|'��ʶ����ʱִ��
                            if (_M_Text[_T_COUNT].charAt(_S_COUNT) == _flag) {
                                    _L_COUNT++;
                                    _S_COUNT++;
                                    _F_COUNT = _S_COUNT;
                                    shortSleep = true;
                            } else {
                                    shortSleep = false;
                            }
                            //ˢ��
                            repaint();
                            //�ж��ٶ�
                            if (!shortSleep) {
                                    Thread.sleep(_L_Speed);
                            } else {
                                    Thread.sleep(10 * _L_Speed);
                            }
                    } catch (InterruptedException e) {
                            stop();
                    }
            }
    }
    
    public int getMaxCount() {
            return _MAX_COUNT;
    }

    public void setMaxCount(int max_count) {
            _MAX_COUNT = max_count;
    }




}