package ui.system;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import ui.frame.index.homepage.HomepageBounds;
import ui.frame.larger.LargerScrollPane;

public class UIData {
	
	/*
	 * type 1, FrameSize:1920_1080
	 * type 2, FrameSize:1280_720
	 */
	
	public static int fwidth, fheight;
	
	public static int slideMax = 100;
	
	public UIData(int width, int height){
			
			frameWidth = width;
			frameHeight = height;
			changeX = (frameWidth + 0.0) / 1920;
			changeY = (frameHeight + 0.0) / 1080;
			fwidth =  (int) (frameWidth + 0 * changeX);
			fheight = (int) (frameHeight + 0 * changeY);
			init();
	}
	
	public static double changeX;
	public static double changeY;
	public static int currentStep = 0;
		
	private void init(){		
		setFrameLoction();
		setLargerBounds();
		setIndexBoardBounds();
		setSystemBoardBounds();
		setIndexScrollPaneBounds();
		setIndexPanelBounds();
		setHomepagePanelBounds();
		setHotspotPanelBounds();
		setMatchPanelBounds();
		setRankingBounds();
		setTeamBounds();
		setPlayerBounds();
		setMyTeamBounds();
		
		@SuppressWarnings("unused")
		HomepageBounds homepageBounds = new HomepageBounds();
	}
	
	static double k = 1;
	
	private void setFrameLoction(){
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)screensize.getWidth();
		int screenHeight = (int)screensize.getHeight();
		
		k = (screenWidth + 0.0) / 1920;
		
		frameX = (screenWidth - frameWidth) / 2;
		frameY = (screenHeight - frameHeight) / 2;
	}
	
	public static int slideSize;
	
	public static int getNextX(){
		currentStep++;	
		return (slideMax - currentStep) * slideSize;
	}
	
	public static void returnToFormerStep(){
		currentStep--;	
		LargerScrollPane.turnto.doClick();
	}
	
	private void setLargerBounds(){
		largerScrollPaneX = 0;
		largerScrollPaneY = 0;
		slideSize = (int) (1920 * changeX);
		largerScrollPaneWidth = fwidth;
		largerScrollPaneHeight = fheight;
		largerPanelWidth = frameWidth + slideSize * slideMax;
		largerPanelHeight = frameHeight - 10;
	}
	
	private void setIndexScrollPaneBounds(){
		indexScrollPaneX = slideSize * slideMax;
		indexScrollPaneY = 0;
		indexScrollPaneWidth = frameWidth;
		indexScrollPaneHeight = frameHeight;
	}
	
	private void setIndexPanelBounds(){
		indexPanelWidth = indexScrollPaneWidth - 20;
		indexPanelHeight = (int) (frameHeight * 10 - 491 * UIData.changeY);
	}
	
	private void setHomepagePanelBounds(){
		homepagePanelX = 0;
		homepagePanelY = 0;
		homepagePanelWidth = indexPanelWidth;
		homepagePanelHeight = frameHeight;
	}
	
	private void setIndexBoardBounds(){
		indexBoardX = slideSize * slideMax;
		indexBoardY = 0;
		indexBoardWidth = (int) (175 * changeX);
		indexBoardHeight = frameHeight;
	}
	
	private void setSystemBoardBounds(){
		systemBoardX = indexBoardX + indexBoardWidth;
		systemBoardY = (int) ((825 - 160) * changeY);
		systemBoardWidth = (int) (175 * changeX);
		systemBoardHeight = (int) (160 * 2 * changeY);
	}
	
	private void setHotspotPanelBounds(){
		hotspotBoundsX = 0;
		hotspotBoundsY = (int) (frameHeight);
		hotspotBoundsWidth = indexPanelWidth;
		hotspotBoundsHeight = (int)((3000 - 170) * changeY);
	}
	
	public void setMatchPanelBounds(){
		matchBoundsX = 0;
		matchBoundsY = hotspotBoundsY + hotspotBoundsHeight;
		matchBoundsWidth = indexPanelWidth;
		matchBoundsHeight = (int)(1280 * changeY);
	}
	
	private void setRankingBounds(){
		rankingBoundsX = 0;
		rankingBoundsY = matchBoundsY + matchBoundsHeight;
		rankingBoundsWidth = matchBoundsWidth;
		rankingBoundsHeight = (int)(1280 * changeY);
	}
	
	private void setTeamBounds(){
		teamBoundsX = 0;
		teamBoundsY = rankingBoundsY + rankingBoundsHeight;
		teamBoundsWidth = rankingBoundsWidth;
		teamBoundsHeight = (int)(1280 * changeY);
	}
	
	private void setPlayerBounds(){
		playerBoundsX = 0;
		playerBoundsY = teamBoundsY + teamBoundsHeight;
		playerBoundsWidth = teamBoundsWidth;
		playerBoundsHeight = (int)(1280 * changeY);
	}
	
	private void setMyTeamBounds(){
		myTeamBoundsX = 0;
		myTeamBoundsY = playerBoundsY + playerBoundsHeight;
		myTeamBoundsWidth = playerBoundsWidth;
		myTeamBoundsHeight = (int)(1280 * changeY);
	}
	
	public static String favoriteTeam;
	
	public static void setFavoriteTeam(String teamName){
		favoriteTeam = teamName;
	}
	
	public static ArrayList<String> getSuitableSize(){
		ArrayList<String> returnArray = new ArrayList<String>();
		int width = 1920;
		int height = 1080;
		for(double i = 1; i >= 0.4; i-=0.1){
			if(k >= i){
				returnArray.add((int)(width * i) + "x" + (int)(height * i));
			}
		}
		return returnArray;
	}
	
	//frame
	public static int frameX;
	public static int frameY;
	public static int frameWidth;
	public static int frameHeight;
	
	//larger
	public static int largerScrollPaneX;
	public static int largerScrollPaneY;
	public static int largerScrollPaneWidth;
	public static int largerScrollPaneHeight;
	public static int largerPanelWidth;
	public static int largerPanelHeight;
	
	//index
	public static int indexScrollPaneX;
	public static int indexScrollPaneY;
	public static int indexScrollPaneWidth;
	public static int indexScrollPaneHeight;	
	public static int indexPanelWidth;
	public static int indexPanelHeight;
	public static int homepagePanelX;
	public static int homepagePanelY;
	public static int homepagePanelWidth;
	public static int homepagePanelHeight;
	public static int indexBoardX;
	public static int indexBoardY;
	public static int indexBoardWidth;
	public static int indexBoardHeight;
	public static int systemBoardX;
	public static int systemBoardY;
	public static int systemBoardWidth;
	public static int systemBoardHeight;
	public static int hotspotBoundsX;
	public static int hotspotBoundsY;
	public static int hotspotBoundsWidth;
	public static int hotspotBoundsHeight;
	public static int matchBoundsX;
	public static int matchBoundsY;
	public static int matchBoundsWidth;
	public static int matchBoundsHeight;
	public static int rankingBoundsX;
	public static int rankingBoundsY;
	public static int rankingBoundsWidth;
	public static int rankingBoundsHeight;
	public static int teamBoundsX;
	public static int teamBoundsY;
	public static int teamBoundsWidth;
	public static int teamBoundsHeight;
	public static int playerBoundsX;
	public static int playerBoundsY;
	public static int playerBoundsWidth;
	public static int playerBoundsHeight;
	public static int myTeamBoundsX;
	public static int myTeamBoundsY;
	public static int myTeamBoundsWidth;
	public static int myTeamBoundsHeight;
}
