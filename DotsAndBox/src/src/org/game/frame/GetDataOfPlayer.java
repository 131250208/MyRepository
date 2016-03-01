package src.org.game.frame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import src.org.game.test.TestJPanel;

public class GetDataOfPlayer {
	ReadAndWriteFile RW=new ReadAndWriteFile();
	String[] s;//暂取数据
	
	ArrayList<String> name=new ArrayList<String>();
	ArrayList<String> money=new ArrayList<String>();
	
	ArrayList<String> bought1=new ArrayList<String>();
	ArrayList<String> bought2=new ArrayList<String>();
	ArrayList<String> bought3=new ArrayList<String>();
	
	ArrayList<String> achieve1=new ArrayList<String>();
	ArrayList<String> achieve2=new ArrayList<String>();
	ArrayList<String> achieve3=new ArrayList<String>();
	ArrayList<String> achieve4=new ArrayList<String>();
	
	ArrayList<String> hero=new ArrayList<String>();
	ArrayList<String> pass=new ArrayList<String>();
	
	int Money,Bought1,Bought2,Bought3,Achieve1,Achieve2,Achieve3,Achieve4,Hero,Pass;
	String n;
	public GetDataOfPlayer(String Name){
		
		n=Name;
		try {
			s=RW.Read("src/txt/Register.txt");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		for(int i=0;i<s.length;i++){
			//分开存入
			String[] data=s[i].split(";");
			name.add(data[0]);
			money.add(data[1]);
			
			bought1.add(data[2]);
			bought2.add(data[3]);
			bought3.add(data[4]);
			
			achieve1.add(data[5]);
			achieve2.add(data[6]);
			achieve3.add(data[7]);
			achieve4.add(data[8]);
			
			hero.add(data[9]);
			pass.add(data[10]);
			
		}
		int index=name.indexOf(Name);
		Money=Integer.parseInt(money.get(index));
		
		Bought1=Integer.parseInt(bought1.get(index));
		Bought2=Integer.parseInt(bought2.get(index));
		Bought3=Integer.parseInt(bought3.get(index));
		
		Achieve1=Integer.parseInt(achieve1.get(index));
		Achieve2=Integer.parseInt(achieve2.get(index));
		Achieve3=Integer.parseInt(achieve3.get(index));
		Achieve4=Integer.parseInt(achieve4.get(index));
		
		Hero=Integer.parseInt(hero.get(index));
		Pass=Integer.parseInt(pass.get(index));
	}
	
	public void change(
			int datanum,//数据的代号
			int lastnum//最后数据的值
			){
		int index=name.indexOf(n);
		switch(datanum){
		case 1:money.set(index, String.valueOf(lastnum));
			break;
		case 2:bought1.set(index, String.valueOf(lastnum));
		break;
		case 3:bought2.set(index, String.valueOf(lastnum));
		break;
		case 4:bought3.set(index, String.valueOf(lastnum));
		break;
		case 5:achieve1.set(index, String.valueOf(lastnum));
		break;
		case 6:achieve2.set(index, String.valueOf(lastnum));
		break;
		case 7:achieve3.set(index, String.valueOf(lastnum));
		break;
		case 8:achieve4.set(index, String.valueOf(lastnum));
		break;
		case 9:hero.set(index, String.valueOf(lastnum));
		break;
		case 10:pass.set(index, String.valueOf(lastnum));
		break;
			
		}
		
		//立即保存
		save();
		
	}
	public void save(){
		int size=name.size();
		String[] save=new String[size];
		
		for(int i=0;i<size;i++){
			save[i]=name.get(i)+";"+money.get(i)+";"+bought1.get(i)+";"+bought2.get(i)+";"+bought3.get(i)+";"+achieve1.get(i)+";"+achieve2.get(i)+";"+achieve3.get(i)+";"+achieve4.get(i)+";"+hero.get(i)+";"+pass.get(i);

		}
		
		
		RW.Write(save, "src/txt/Register.txt");
	}
	
	public String sort(){
		 int index1,index2,index3,index4,index5;
		  String result1,result2,result3,moneyOfwyc,moneyOfsb;
		  
		String result="";
		//排除人机与故事的排名
		  index4=name.indexOf("wyc");		  
		  moneyOfwyc=money.get(index4);
		  name.set(index4, "temp4");
		  money.set(index4, "-44");
		  
		  index5=name.indexOf("sb");		  
		  moneyOfsb=money.get(index5);			
		  name.set(index5, "temp5");
		  money.set(index5, "-55");
		String[] m=new String[money.size()];
		m=money.toArray(m);
		int[] M=new int[m.length];
		for(int i=0;i<m.length;i++){
			M[i]=Integer.parseInt(m[i]);
		}
		  Arrays.sort(M); //排序
		  
		  int NO1=M[M.length-1];
		  int NO2=M[M.length-2];
		  int NO3=M[M.length-3];
		  
		 
		  
		  index1=money.indexOf(String.valueOf(NO1));
		  result1=name.get(index1);
		  money.set(index1, "-111");//为了不重复检索
		  name.set(index1, "temp1");
		  
		  index2=money.indexOf(String.valueOf(NO2));
		  result2=name.get(index2);
		  money.set(index2, "-222");
		  name.set(index2, "temp2");
		  
		  index3=money.indexOf(String.valueOf(NO3));
		  result3=name.get(index3);
		  
		  //恢复暂时改变的数据
		  money.set(index1,String.valueOf(NO1));
		  name.set(index1, result1);
		  money.set(index2, String.valueOf(NO2));
		  name.set(index2, result2);
//		  money.set(index4,moneyOfwyc);
//		  name.set(index4, "wyc");
//		  money.set(index5, moneyOfsb);
//		  name.set(index5, "sb");
//		  
//		  switch(NO){
//		  case 1:
//			  index=money.indexOf(String.valueOf(NO1));
//		  result=name.get(index);
//		  break;
//		  case 2:
//			  index=money.indexOf(String.valueOf(NO2));
//			  result=name.get(index);
//			  break;
//		  case 3:
//			   index=money.indexOf(String.valueOf(NO3));
//			  result=name.get(index);
//			  break;
//		  
//		  }
		  
		  result=result1+";"+result2+";"+result3;
		return result;
		  
		  
		
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
//		//System.out.println(new GetDataOfPlayer("wyc").Money);
		
		String s=new GetDataOfPlayer("wyc").sort();
		//System.out.println(s);
	}
}
