package DataService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import po.PlayerPO;

public interface PlayerDataService {
	public PlayerPO readOne(File file) throws Exception;
	public void operatePlayerTxt(String lineTxt, int lineNumber);
	public PlayerPO find(String name);
	public ArrayList<PlayerPO> getallplayers();
}
