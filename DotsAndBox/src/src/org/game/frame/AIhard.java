package src.org.game.frame;
public class AIhard extends AIcomputer{
	
	public AIhard(){
	}
	public static int[][] returnArray;
	public int returnArray(int[][] hb,int[][] sb,int[][] box,int step,boolean isMine) {
		int a;
	    int b;
	    int c;
	    int d;
	    int e;
	    int f;
	    int g;
	    int i = 1;
	    int j = 0;
	    int k;
	    int q = 0;
	    int re = 0;
	    int[][] boxjudge = new int[5][5];
	    int[][] judge = new int[5][5];
	    int[][] hbscan = new int[6][5];
	    int[][] sbscan = new int[6][5];
	    int[][] target1 = new int[60][3];
	    int[][] target2 = new int[1][3];
	    for(a=0;a<6;a++){
	    	for(b=0;b<5;b++){
	    		hbscan[a][b] = hb[a][b];
	    	}
	    }
	    for(a=0;a<6;a++){
	    	for(b=0;b<5;b++){
	    		sbscan[a][b] = sb[a][b];
	    	}
	    }
	    for(a=0;a<5;a++){
	    	for(b=0;b<5;b++){
	    		if(box[a][b] != 0){
	    			boxjudge[a][b] =-1;
	    		}
	    	}
	    }
	    for(g=0;g<25;g++){
	    	for(a=0;a<5;a++){
	    		for(b=0;b<5;b++){
	    			if(hbscan[a][b]!=0 && sbscan[b][a]!=0 && hbscan[a+1][b]!=0 && sbscan[b+1][a]==0){
	    				sbscan[b+1][a] = 1;
	    				boxjudge[a][b] = -1;
	    			}
	    			if(hbscan[a][b]!=0 && sbscan[b][a]!=0 && hbscan[a+1][b]==0 && sbscan[b+1][a]!=0){
	    				hbscan[a+1][b] = 1;
	    				boxjudge[a][b] = -1;
	    			}
	    			if(hbscan[a][b]!=0 && sbscan[b][a]==0 && hbscan[a+1][b]!=0 && sbscan[b+1][a]!=0){
	    				sbscan[b][a] = 1;
	    				boxjudge[a][b] = -1;
	    			}
	    			if(hbscan[a][b]==0 && sbscan[b][a]!=0 && hbscan[a+1][b]!=0 && sbscan[b+1][a]!=0){
	    				hbscan[a][b] = 1;
	    				boxjudge[a][b] = -1;
	    			}
	    		}
	    	}
	    }
	    for(a=0;a<6;a++){
	    	for(b=0;b<5;b++){
	    		if(hbscan[a][b] == 0){
	    			hbscan[a][b] = 1;
	    			i=1;
	    			for(c=0;c<6;c++){
	    				for(d=0;d<5;d++){
	    					if(hbscan[c][d] == 0){
	    						hbscan[c][d] = 1;
	    						for(e=0;e<5;e++){
	    							for(f=0;f<5;f++){
	    								if(!(hbscan[e][f]!=0 && sbscan[f][e]!=0 && hbscan[e+1][f]!=0 && sbscan[f+1][e]!=0 && boxjudge[e][f]!=-1)){
	    									judge[e][f] = 1;
	    								}
	    							}
	    						}
	    						for(e=0;e<5;e++){
	    			    			for(f=0;f<5;f++){
	    			    				if(judge[e][f]==0){
	    			    					i=0;
	    			    				};
	    			    			}
	    			    		}
	    			    		for(e=0;e<5;e++){
	    							for(f=0;f<5;f++){
	    								judge[e][f] = 0;
	    							}
	    						}
	    			    	    hbscan[c][d] = 0;
	    					}
	    				}
	    			}
	    			for(c=0;c<6;c++){
	    				for(d=0;d<5;d++){
	    					if(sbscan[c][d] == 0){
	    						sbscan[c][d] = 1;
	    						for(e=0;e<5;e++){
	    							for(f=0;f<5;f++){
	    								if(!(hbscan[e][f]!=0 && sbscan[f][e]!=0 && hbscan[e+1][f]!=0 && sbscan[f+1][e]!=0 && boxjudge[e][f]!=-1)){
	    									judge[e][f] = 1;
	    								}
	    							}
	    						}
	    						for(e=0;e<5;e++){
	    							for(f=0;f<5;f++){
	    								if(judge[e][f]==0){
    			    					i=0;
	    								};
	    							}
	    						}
	    						for(e=0;e<5;e++){
	    							for(f=0;f<5;f++){
	    								judge[e][f] = 0;
	    							}
	    						}
	    			    		sbscan[c][d] = 0;
		    				}
	    				}
	    			}
	    			if(i==1){
	    				target1[j][0] = 0;
	    				target1[j][1] = a;
	    				target1[j][2] = b;
	    				j++;
	    			}
	    			hbscan[a][b] = 0;
	    		}
	    	}
		}

	    for(a=0;a<6;a++){
	    	for(b=0;b<5;b++){
	    		if(sbscan[a][b] == 0){
	    			sbscan[a][b] = 1;
	    			i=1;
	    			for(c=0;c<6;c++){
	    				for(d=0;d<5;d++){
	    					if(hbscan[c][d] == 0){
	    						hbscan[c][d] = 1;
	    						for(e=0;e<5;e++){
	    							for(f=0;f<5;f++){
	    								if(!(hbscan[e][f]!=0 && sbscan[f][e]!=0 && hbscan[e+1][f]!=0 && sbscan[f+1][e]!=0 && boxjudge[e][f]!=-1)){
	    									judge[e][f] = 1;
	    								}
	    							}
	    						}
	    						for(e=0;e<5;e++){
	    			    			for(f=0;f<5;f++){
	    			    				if(judge[e][f]==0){
	    			    					i=0;
	    			    				};
	    			    			}
	    			    		}
	    			    		for(e=0;e<5;e++){
	    							for(f=0;f<5;f++){
	    								judge[e][f] = 0;
	    							}
	    						}
	    			    	    hbscan[c][d] = 0;
	    					}
	    				}
	    			}
	    			for(c=0;c<6;c++){
	    				for(d=0;d<5;d++){
	    					if(sbscan[c][d] == 0){
	    						sbscan[c][d] = 1;
	    						for(e=0;e<5;e++){
	    							for(f=0;f<5;f++){
	    								if(!(hbscan[e][f]!=0 && sbscan[f][e]!=0 && hbscan[e+1][f]!=0 && sbscan[f+1][e]!=0 && boxjudge[e][f]!=-1)){
	    									judge[e][f] = 1;
	    								}
	    							}
	    						}
	    						for(e=0;e<5;e++){
	    							for(f=0;f<5;f++){
	    								if(judge[e][f]==0){
    			    					i=0;
	    								};
	    							}
	    						}
	    						for(e=0;e<5;e++){
	    							for(f=0;f<5;f++){
	    								judge[e][f] = 0;
	    							}
	    						}
	    			    		sbscan[c][d] = 0;
		    				}
	    				}
	    			}
	    			if(i==1){
	    				target1[j][0] = 1;
	    				target1[j][1] = a;
	    				target1[j][2] = b;
	    				j++;
	    			}
	    			sbscan[a][b] = 0;
	    		}
	    	}
		}
	    for(a=0;a<6;a++){
	    	for(b=0;b<5;b++){
	    		hbscan[a][b] = hb[a][b];
	    	}
	    }
	    for(a=0;a<6;a++){
	    	for(b=0;b<5;b++){
	    		sbscan[a][b] = sb[a][b];
	    	}
	    }
	    for(a=0;a<5;a++){
	    	for(b=0;b<5;b++){
	    		if(box[a][b] != 0){
	    			boxjudge[a][b] =-1;
	    		}
	    		else{
	    			boxjudge[a][b] =0;
	    		}
	    	}
	    }
	    g=0;
	    if(j>0){						//这是还未到达A状态时候的做法。
	    	for(a=0;a<5;a++){
	    		for(b=0;b<5;b++){
	    			if(g==0){
	    				if(hbscan[a][b]!=0 && sbscan[b][a]!=0 && hbscan[a+1][b]!=0 && sbscan[b+1][a]==0){
	    					target2[0][0]=1;
	    					target2[0][1]=b+1;
	    					target2[0][2]=a;
	    					g++;
	    				}
	    				if(hbscan[a][b]!=0 && sbscan[b][a]!=0 && hbscan[a+1][b]==0 && sbscan[b+1][a]!=0){
	    					target2[0][0]=0;
	    					target2[0][1]=a+1;
	    					target2[0][2]=b;
	    					g++;
	    				}
	    				if(hbscan[a][b]!=0 && sbscan[b][a]==0 && hbscan[a+1][b]!=0 && sbscan[b+1][a]!=0){
	    					target2[0][0]=1;
	    					target2[0][1]=b;
	    					target2[0][2]=a;
	    					g++;
	    				}
	    				if(hbscan[a][b]==0 && sbscan[b][a]!=0 && hbscan[a+1][b]!=0 && sbscan[b+1][a]!=0){
	    					target2[0][0]=0;
	    					target2[0][1]=a;
	    					target2[0][2]=b;
	    					g++;
	    				}
	    			}
	    		}
	    	}
	    	if(g!=0){						//有3的状态。
	    		if(target2[0][0] == 0){
	    			hb[(target2[0][1])][(target2[0][2])]=2;
	    		}
	    		else{
	    			sb[(target2[0][1])][(target2[0][2])]=2;
	    		}
				for(a=0;a<5;a++){
					for(b=0;b<5;b++){
						if(hb[a][b]!=0 && hb[a+1][b]!=0 && sb[b][a]!=0 && sb[b+1][a]!=0 && box[a][b]==0){
							box[a][b] = 2;
							q=1;
							step = 2;
							isMine = false;
						}
					}
				}
	    	}
	    	else{					//无3的情况。
	    		if(j>20){
	    			AIeasy computer = new AIeasy();
	    	    	q=computer.returnArray(hb, sb, box, step, isMine);
	    		}
	    		else{
	    			for(k=0;k<j;k++){
	    				for(a=0;a<6;a++){
	    			    	for(b=0;b<5;b++){
	    			    		hbscan[a][b] = hb[a][b];
	    			    	}
	    			    }
	    			    for(a=0;a<6;a++){
	    			    	for(b=0;b<5;b++){
	    			    		sbscan[a][b] = sb[a][b];
	    			    	}
	    			    }
	    				if(re!=1){
	    					if(target1[k][0] == 0){
		    	    			hbscan[(target1[k][1])][(target1[k][2])]=2;
		    	    		}
		    	    		else{
		    	    			sbscan[(target1[k][1])][(target1[k][2])]=2;
		    	    		}
		    				@SuppressWarnings("unused")
							AIreserch computer = new AIreserch();
		    				re = AIreserch.returnArray(hbscan, sbscan, box, step, false, 1);
		    				if(re==1){
		    					if(target1[k][0] == 0){
			    	    			hb[(target1[k][1])][(target1[k][2])]=2;
			    	    		}
			    	    		else{
			    	    			sb[(target1[k][1])][(target1[k][2])]=2;
			    	    		}
		    				}
	    				}
	        			
	        		}
	    			if(k==j&&re==0){
	    		    	AIeasy computer = new AIeasy();
	    		    	q=computer.returnArray(hb, sb, box, step, isMine);
	    			}
	    		}
	    	}
	    }
	    else{							//这是已到达A状态时的做法。
	    	AIeasy computer = new AIeasy();
	    	q=computer.returnArray(hb, sb, box, step, isMine);
	    }
		return q;
	}
}