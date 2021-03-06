package com.nba.initProcess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;




import com.nba.data.Player;
import com.nba.data.Team;
import com.nba.data.FilePathSaver;
import com.nba.main.Main;
import com.nba.registerList.RegisterList;

public class MatchFileReader {
	
	//生成文件路径保存器并获取比赛文件夹路径
	FilePathSaver pathSaver = new FilePathSaver();
	private String filePath = pathSaver.getMatchFilePath();
	
	
	//该方法将会读取比赛信息文件夹中所有球员的信息
	public void readAll() throws Exception{	
		File file = new File(filePath);                
		File[] matchFile = file.listFiles();
		
		int index = 0;
		
		for(int i = 0; i < matchFile.length; i++){
			String[] a = matchFile[i].toString().split("_");
			String[] b = a[1].split("-");
			int c = Integer.parseInt(b[0]);
			if(c > 7)
				index = i;
		}

		for(int i = index; i < matchFile.length; i++)
			readOne(matchFile[i]);
		
		for(int i = 0; i < index; i++)
			readOne(matchFile[i]);
	}
	
	//该方法将会对每一当场比赛信息进行读取工作
	private void readOne(File file) throws IOException, FileNotFoundException{
		
		InputStreamReader read = new InputStreamReader(new FileInputStream(file),"UTF-8");
        BufferedReader bufferedReader = new BufferedReader(read);
        String lineTxt = null;
        int lineNumber = 0;
        while((lineTxt = bufferedReader.readLine()) != null){
            operateMatchTxt(lineTxt, lineNumber++);
        }
        
        sentMatchInfo();
        
        read.close();
	}
	
	private String leftTeamShortName, rightTeamShortName;
	private int leftTeamScore = 0, rightTeamScore = 0;
	private int leftTeamTime = 0, rightTeamTime = 0;
	private int leftTeamFG = 0, rightTeamFG = 0;
	private int leftTeamFGTry = 0, rightTeamFGTry = 0;
	private int leftTeam3FG = 0, rightTeam3FG = 0;
	private int leftTeam3FGTry = 0, rightTeam3FGTry = 0;
	private int leftTeamFTG = 0, rightTeamFTG = 0;
	private int leftTeamFTGTry = 0, rightTeamFTGTry = 0;
	private int leftTeamOffenceRebounds = 0, rightTeamOffenceRebounds = 0;
	private int leftTeamDeffenceRebounds = 0, rightTeamDeffenceRebounds = 0;
	private int leftTeamTotalRebounds = 0, rightTeamTotalRebounds = 0;
	private int leftTeamAssists = 0, rightTeamAssists = 0;
	private int leftTeamSteals = 0, rightTeamSteals = 0;
	private int leftTeamBlocks = 0, rightTeamBlocks = 0;
	private int leftTeamTurnovers = 0, rightTeamTurnovers = 0;
	private int leftTeamFouls = 0, rightTeamFouls = 0;
	private double leftOffenceTimes = 0, rightOffenceTimes = 0;
	
	private int counter = 0;
	private String[] playerName = new String[30];
	private int[] playerTime = new int[30];
	private boolean[] playerIsStart = new boolean[30];
	private int[] playerFG = new int[30];
	private int[] playerFGTry = new int[30];
	private int[] player3FG = new int[30];
	private int[] player3FGTry = new int[30];
	private int[] playerFTG = new int[30];
	private int[] playerFTGTry = new int[30];
	private int[] playerOffenceRebounds = new int[30];
	private int[] playerDeffenceRebounds = new int[30];
	private int[] playerTotalRebounds = new int[30];
	private int[] playerAssists = new int[30];
	private int[] playerSteals = new int[30];
	private int[] playerBlocks = new int[30];
	private int[] playerTurnovers = new int[30];
	private int[] playerFouls = new int[30];
	private int[] playerScores = new int[30];
	
	private boolean isLeft = true;
	private int leftRightSwitchPoint = 0;
	
	private void initInfo(){
		leftTeamScore = 0; rightTeamScore = 0;
		leftTeamTime = 0; rightTeamTime = 0;
		leftTeamFG = 0; rightTeamFG = 0;
		leftTeamFGTry = 0; rightTeamFGTry = 0;
		leftTeam3FG = 0; rightTeam3FG = 0;
		leftTeam3FGTry = 0; rightTeam3FGTry = 0;
		leftTeamFTG = 0; rightTeamFTG = 0;
		leftTeamFTGTry = 0; rightTeamFTGTry = 0;
		leftTeamOffenceRebounds = 0; rightTeamOffenceRebounds = 0;
		leftTeamDeffenceRebounds = 0; rightTeamDeffenceRebounds = 0;
		leftTeamTotalRebounds = 0; rightTeamTotalRebounds = 0;
		leftTeamAssists = 0; rightTeamAssists = 0;
		leftTeamSteals = 0; rightTeamSteals = 0;
		leftTeamBlocks = 0; rightTeamBlocks = 0;
		leftTeamTurnovers = 0; rightTeamTurnovers = 0;
		leftTeamFouls = 0; rightTeamFouls = 0;
		leftOffenceTimes = 0; rightOffenceTimes = 0;
		
	    counter = 0;
		
		isLeft = true;
		leftRightSwitchPoint = 0;
	}
	
	private void operateMatchTxt(String lineTxt, int lineNumber){
		if(lineNumber == 0){
			
			initInfo();
			
			//System.out.println(lineTxt + (-(Main.T - (double)System.currentTimeMillis())/1000) + "s");
			
			String[] teamInfoStage1 = lineTxt.split(";");
			
			String[] teamInfoStage2 = teamInfoStage1[1].split("-");
			leftTeamShortName = teamInfoStage2[0];
			rightTeamShortName = teamInfoStage2[1];
			
			String[] teamInfoStage3 = teamInfoStage1[2].split("-");			
			leftTeamScore = Integer.parseInt(teamInfoStage3[0]);
			rightTeamScore = Integer.parseInt(teamInfoStage3[1]);
		}
		
		if(lineNumber > 2 && lineTxt.length() == 3){
			isLeft = false;
			leftRightSwitchPoint = lineNumber;
		}
		
		if(lineNumber > 2 && lineTxt.length() != 3){
			
			String[] playerInfo = lineTxt.split(";");
			
			playerName[counter] = playerInfo[0];
			
			if(playerInfo[1].length() > 0){
				playerIsStart[counter] = true;
			}else{
				playerIsStart[counter] = false;
			}
			
			playerTime[counter] = playTimeTransform(playerInfo[2]);
			playerFG[counter] = Integer.parseInt(playerInfo[3]);
			playerFGTry[counter] = Integer.parseInt(playerInfo[4]);
			player3FG[counter] = Integer.parseInt(playerInfo[5]);
			player3FGTry[counter] = Integer.parseInt(playerInfo[6]);
			playerFTG[counter] = Integer.parseInt(playerInfo[7]);
			playerFTGTry[counter] = Integer.parseInt(playerInfo[8]);
			playerOffenceRebounds[counter] = Integer.parseInt(playerInfo[9]);
			playerDeffenceRebounds[counter] = Integer.parseInt(playerInfo[10]);
			playerTotalRebounds[counter] = Integer.parseInt(playerInfo[11]);
			playerAssists[counter] = Integer.parseInt(playerInfo[12]);
			playerSteals[counter] = Integer.parseInt(playerInfo[13]);
			playerBlocks[counter] = Integer.parseInt(playerInfo[14]);
			playerTurnovers[counter] = Integer.parseInt(playerInfo[15]);
			playerFouls[counter] = Integer.parseInt(playerInfo[16]);
			if(!playerInfo[17].equals("null")){
				playerScores[counter] = Integer.parseInt(playerInfo[17]);
			}
			
			if(isLeft){
				leftTeamTime = leftTeamTime + playerTime[counter];
				leftTeamFG = leftTeamFG + playerFG[counter];
				leftTeamFGTry = leftTeamFGTry + playerFGTry[counter];
				leftTeam3FG = leftTeam3FG + player3FG[counter];
				leftTeam3FGTry = leftTeam3FGTry + player3FGTry[counter];
				leftTeamFTG = leftTeamFTG + playerFTG[counter];
				leftTeamFTGTry = leftTeamFTGTry + playerFTGTry[counter];
				leftTeamOffenceRebounds = leftTeamOffenceRebounds + playerOffenceRebounds[counter];
				leftTeamDeffenceRebounds = leftTeamDeffenceRebounds + playerDeffenceRebounds[counter];
				leftTeamTotalRebounds = leftTeamTotalRebounds + playerTotalRebounds[counter];
				leftTeamAssists = leftTeamAssists + playerAssists[counter];
				leftTeamSteals = leftTeamSteals + playerSteals[counter];
				leftTeamBlocks = leftTeamBlocks + playerBlocks[counter];
				leftTeamTurnovers = leftTeamTurnovers + playerTurnovers[counter];
				leftTeamFouls = leftTeamFouls + playerFouls[counter];
			}else{
				rightTeamTime = rightTeamTime + playerTime[counter];
				rightTeamFG = rightTeamFG + playerFG[counter];
				rightTeamFGTry = rightTeamFGTry + playerFGTry[counter];
				rightTeam3FG = rightTeam3FG + player3FG[counter];
				rightTeam3FGTry = rightTeam3FGTry + player3FGTry[counter];
				rightTeamFTG = rightTeamFTG + playerFTG[counter];
				rightTeamFTGTry = rightTeamFTGTry + playerFTGTry[counter];
				rightTeamOffenceRebounds = rightTeamOffenceRebounds + playerOffenceRebounds[counter];
				rightTeamDeffenceRebounds = rightTeamDeffenceRebounds + playerDeffenceRebounds[counter];
				rightTeamTotalRebounds = rightTeamTotalRebounds + playerTotalRebounds[counter];
				rightTeamAssists = rightTeamAssists + playerAssists[counter];
				rightTeamSteals = rightTeamSteals + playerSteals[counter];
				rightTeamBlocks = rightTeamBlocks + playerBlocks[counter];
				rightTeamTurnovers = rightTeamTurnovers + playerTurnovers[counter];
				rightTeamFouls = rightTeamFouls + playerFouls[counter];
			}
			counter++;
		}	
		
		/*
		 * by 阿超
		 * 2015年3月13日 20:13:07
		 * 从match里面读数据
		 * */
		
		//如何直接获取球队的信息
		
		//Team Lteam = new Team();
		//Team Rteam = new Team();
		
		//leftOffenceTimes = leftTeamFGTry + 0.4 * leftTeamFTGTry - 1.07 * (leftTeamOffenceRebounds /
		//		(leftTeamOffenceRebounds + rightTeamDeffenceRebounds) * (leftTeamFGTry - leftTeamFG)) + 1.07 * leftTeamTurnovers;
		//rightOffenceTimes = rightTeamFGTry + 0.4 * rightTeamFTGTry - 1.07 * (rightTeamOffenceRebounds /
		//		(rightTeamOffenceRebounds + leftTeamDeffenceRebounds) * (rightTeamFGTry - rightTeamFG)) + 1.07 * rightTeamTurnovers;

		
	}
	
	private int playTimeTransform(String time){
		if(!time.equals("null") && !time.equals("None")){
			String[] array = time.split(":");
	  		return Integer.parseInt(array[0]) * 60 + Integer.parseInt(array[1]);//单位秒
		}else{
			return 0;//先暂时写成这样
		}
	}
	

	private void sentMatchInfo() {
		
		leftOffenceTimes = leftTeamFGTry + 0.4 * leftTeamFTGTry - 1.07 * (leftTeamOffenceRebounds /
				(leftTeamOffenceRebounds + rightTeamDeffenceRebounds) * (leftTeamFGTry - leftTeamFG)) + 1.07 * leftTeamTurnovers;
		rightOffenceTimes = rightTeamFGTry + 0.4 * rightTeamFTGTry - 1.07 * (rightTeamOffenceRebounds /
				(rightTeamOffenceRebounds + leftTeamDeffenceRebounds) * (rightTeamFGTry - rightTeamFG)) + 1.07 * rightTeamTurnovers;
		
		//更新球队信息
		Team LeftTeam =  RegisterList.getTeamWithShortName(leftTeamShortName);		
		LeftTeam.updateTeam(leftOffenceTimes, leftTeamAssists, leftTeamFG, leftTeamFGTry, leftTeam3FG, 
				leftTeam3FGTry, leftTeamFTG, leftTeamFTGTry, leftTeamOffenceRebounds, leftTeamDeffenceRebounds, 
				leftTeamTotalRebounds, leftTeamSteals, leftTeamBlocks, leftTeamTurnovers, leftTeamFouls,
				leftTeamScore, rightTeamScore, rightTeamOffenceRebounds, rightTeamDeffenceRebounds,
				rightTeamTotalRebounds, rightOffenceTimes, rightTeamAssists, rightTeamFG,
				rightTeamFGTry, rightTeam3FG, rightTeam3FGTry, rightTeamFTG, rightTeamFTGTry,
				rightTeamSteals, rightTeamBlocks, rightTeamTurnovers, rightTeamFouls);		
		RegisterList.updateTeam(LeftTeam);
		
		Team RightTeam = RegisterList.getTeamWithShortName(rightTeamShortName);
		RightTeam.updateTeam(rightOffenceTimes,rightTeamAssists, rightTeamFG, rightTeamFGTry, 
				rightTeam3FG, rightTeam3FGTry, rightTeamFTG, rightTeamFTGTry, rightTeamOffenceRebounds, 
				rightTeamDeffenceRebounds, rightTeamTotalRebounds, rightTeamSteals, rightTeamBlocks,
				rightTeamTurnovers,rightTeamFouls, rightTeamScore, leftTeamScore, leftTeamOffenceRebounds,
				leftTeamDeffenceRebounds, leftTeamTotalRebounds, leftOffenceTimes, leftTeamAssists, leftTeamFG, leftTeamFGTry,
				leftTeam3FG, leftTeam3FGTry, leftTeamFTG, leftTeamFTGTry, leftTeamSteals, leftTeamBlocks,
				leftTeamTurnovers, leftTeamFouls);
		RegisterList.updateTeam(RightTeam);

		//更新球员信息
		for(int i = 0; i < counter; i++){
				
			Player tempPlayer = RegisterList.getPlayerWithName(playerName[i]);

			
			if(tempPlayer == null){			
				Player newPlayer = new Player(playerName[i], null, null, null, null, null, null, null, null);
				RegisterList.getCurrentAlphaList().add(newPlayer);
				tempPlayer = newPlayer;
			}
			
			if(i < leftRightSwitchPoint){
				tempPlayer.updatePlayer(playerTime[i], playerIsStart[i], playerFG[i], playerFGTry[i],
						player3FG[i], player3FGTry[i], playerFTG[i], playerFTGTry[i], playerOffenceRebounds[i],
						playerDeffenceRebounds[i], playerTotalRebounds[i], playerAssists[i], playerSteals[i],
						playerBlocks[i], playerTurnovers[i], playerFouls[i], playerScores[i], (leftTeamTime - playerTime[i]),
						leftTeamTotalRebounds, rightTeamTotalRebounds, leftTeamOffenceRebounds, rightTeamOffenceRebounds,
						leftTeamDeffenceRebounds, rightTeamDeffenceRebounds, leftTeamFG, leftTeamFGTry, (rightTeamFGTry - rightTeam3FGTry),
						leftTeamFTGTry, leftTeamTurnovers, rightOffenceTimes);
				tempPlayer.updateTeamShortName(leftTeamShortName);
			}else{
				tempPlayer.updatePlayer(playerTime[i], playerIsStart[i], playerFG[i], playerFGTry[i],
						player3FG[i], player3FGTry[i], playerFTG[i], playerFTGTry[i], playerOffenceRebounds[i],
						playerDeffenceRebounds[i], playerTotalRebounds[i], playerAssists[i], playerSteals[i],
						playerBlocks[i], playerTurnovers[i], playerFouls[i], playerScores[i], (rightTeamTime - playerTime[i]),
						rightTeamTotalRebounds, leftTeamTotalRebounds, rightTeamOffenceRebounds, leftTeamOffenceRebounds,
						rightTeamDeffenceRebounds, leftTeamDeffenceRebounds, rightTeamFG, rightTeamFGTry, (leftTeamFGTry - leftTeam3FGTry),
						rightTeamFTGTry, rightTeamTurnovers, leftOffenceTimes);	
				tempPlayer.updateTeamShortName(rightTeamShortName);
			}
			
			RegisterList.updatePlayer(tempPlayer);
						
		}
	}

}
