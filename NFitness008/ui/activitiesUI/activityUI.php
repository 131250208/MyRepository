<?php

/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/12/4 0004
 * Time: 10:35
 */
require_once("../../bl/activitiesBL/activitiesManager.php");
require_once ("../../bl/usersBL/userManager.php");
class activityUI
{
    //输出更换场所的控制栏
    public function echoSquUpdate($choose){
        $options="
               <option>健康广场</option>
             <option>活动广场</option>
            ";
        if($choose=="活动"){
            $options="
             <option>活动广场</option>
            <option>健康广场</option>";
        }
        echo "                  <form method=\"post\" action=\"http://localhost/NFitness008/ui/mainFrameUI/home.php\">
                    <div class=\"squ_choose\">
                        <div class=\"control-group \"style=\"float: left\">
                            <label class=\"control-label\" style=\"float: left;font-size: 20px;margin-right: 15px;margin-left: 5px;\">场所</label>
                            <div class=\"controls\" style=\"float: left\">
                                <select class=\"input-xlarge\" style=\"width: 150px;height: 30px\" name=\"suquare_choose\">
                                   ".$options."
                                </select>
                            </div>
                        </div>
                        <p style=\"float: right\">
                            <button style=\"border: 0px\">
                                <a class=\"btn btn-success\" type=\"submit\">
                                    更换场所
                                </a>
                            </button>
                        </p>
                    </div>
                    <div style=\"clear: both\"></div>
                </form>";
    }

    //输出自己发布的活动
    //输出所有活动信息，参数为活动数组
    public function echoAllActi($allActi){

        $activitiesManager=new activitiesManager();
        $userManager=new userManager();

        for($i=0;$i<count($allActi["id"]);$i++){
            //活动id
            $actiId=$allActi["id"][$i];
            //活动名称
            $activityName=$allActi["name"][$i];
            //发起者
            $sponsorid=$allActi["sponsor_id"][$i];
            $sponsor=$userManager->findUser($sponsorid);
            $sponsorName=$sponsor["name"];
            $sponsor_iden=$sponsor["identity"];
            //nf
            $nf=$allActi["nf"][$i];
            //人数
            $parNum=$activitiesManager->getParNum($actiId); //已参加人数
            $parNum_max=$allActi["numOfPar"][$i];//限制人数
            $parNum_rate=$parNum."/".$parNum_max;
            //时间
            $starTime=$allActi["start_time"][$i];
            $endTime=$allActi["end_time"][$i];
            $time=$starTime."<br>结束时间： ".$endTime;
            //地点
            $addr=$allActi["address"][$i];
            //简介
            $brief=$allActi["brief"][$i];

            //如果报名满员则直接开启
            if($parNum>=$parNum_max){


                $btn="
                    <p>
                        <a class=\"btn btn-warning btn-lg\">
                        已经开启
                        </a>
                    </p>";
            }
            else{
                //判断是否是自己发布的活动
                $btn="
                    <p>
                        <a class=\"btn btn-success btn-lg\" href=\"../../bl/activitiesBL/parActiProgress.php?id=".$actiId."\">
                        报名参与
                        </a>
                    </p>";
                if($sponsorid==$_SESSION['id']){
                    $btn="
                    <p>
                        <a class=\"btn btn-primary btn-lg\" href=\"../../bl/activitiesBL/delActivityProgress.php?id=".$actiId."\">
                        取消活动
                        </a>
                    </p>";
                }
                //判断自己是否参与了该活动
                $partants=$activitiesManager->getAllParticipants($actiId);
                if($partants!="没有结果"){
                    if(in_array($_SESSION['id'],$partants)){
                        $btn="
                    <p>
                        <a class=\"btn btn-danger btn-lg\" href=\"../../bl/activitiesBL/quitActivityProgress.php?id=".$actiId."\">
                        退出活动
                        </a>
                    </p>";
                    }
                }
            }
            $color_blue="#1B9AF7";//教练
            $color_yellow="#fbcb09";//医生
            $color_purple="darkmagenta";//医生兼教练

            if($sponsor_iden=="医生"){
                $color=$color_yellow;
            }
            elseif($sponsor_iden=="教练"){
                $color=$color_blue;
            }
            elseif($sponsor_iden=="医生&教练"){
                $color=$color_purple;
            }
            else{
                $color="black";
            }
            //循环输出所有活动
            echo "
               <article class=\"article_mine \">
                <div class=\"container_mine\">
                    <div class=\"article_mine_header\">
                        <div class=\"article_mine_header_activ\"><h1>".$activityName."</h1></div>
                    <div class=\"article_mine_header_butt\">
                       ".$btn."
                </div>
            </div>
            <div class=\"article_mine_content\">
                <div class=\"article_mine_content_info\">
                    <div >发起者： <a href='../userUI/personalPage.php?id=".$sponsorid."'target=\"_blank\"><b style=\"color:".$color."\">".$sponsorName."->".$sponsor_iden."</b></a> </div>
                    <div >悬赏NF： ".$nf."</div>
                    <div >人数： ".$parNum_rate."</div>
                    <div >开始时间： ".$time."</div>
                    <div  id=\"addr\">地点： ".$addr."
                </div>
            </div>
            <div class=\" article_mine_content_brief article_div\">
            详情： ".$brief."
        </div>
    </div>
    </div>
    </article>";

        }
    }

    public  function echoActiPublish(){
        echo "
  <form method=\"post\" action=\"http://localhost/NFitness008/bl/activitiesBL/addActivityProgress.php\">
        <div class=\"acti_public\">
            <div class=\"acti_public_head\">
                <div id=\"legend\" class=\"acti_public_title\">
                    <legend class=\"\" style=\"font-size: 30px;\">活动发布</legend>
                </div>
                <div class=\"acti_public_btn\">
                    <button style='border: 0px' >
                        <a class=\"btn btn-success btn-lg\"  type='submit'>
                            确认发布
                        </a>
                    </button>

                </div>
            </div>

            <div class=\"acti_public_content\">
                <div class=\"acti_public_data\">
                    <div class=\"control-group\">
                        <!-- Text input-->
                        <label class=\"control-label\" for=\"input01\">活动名</label>
                        <div class=\"controls\">
                            <input type=\"text\" placeholder=\"placeholder\"class=\"input-xlarge\"name='acti_name' >
                        </div>
                    </div>

                    <div class=\"control-group\">

                        <!-- Text input-->
                        <label class=\"control-label\" for=\"input01\">悬赏NF</label>
                        <div class=\"controls\">
                            <input type=\"text\" placeholder=\"placeholder\" class=\"input-xlarge\" name='nf'>
                        </div>
                    </div>

                    <div class=\"control-group\">

                        <!-- Text input-->
                        <label class=\"control-label\" for=\"input01\">人数限制</label>
                        <div class=\"controls\">
                            <input type=\"text\" placeholder=\"placeholder\" class=\"input-xlarge\" name='peopleNum_max'>

                        </div>
                    </div>

                    <div class=\"control-group\">

                        <!-- Text input-->
                        <label class=\"control-label\" for=\"input01\">开始时间</label>
                        <div class=\"controls\">
                            <input type=\"text\" placeholder=\"2015\" class=\"input-xlarge acti_public_timetxt\" name='start_y'>
                            -
                            <input type=\"text\" placeholder=\"01\" class=\"input-xlarge acti_public_timetxt\" name='start_mon'>
                            -
                            <input type=\"text\" placeholder=\"01\" class=\"input-xlarge acti_public_timetxt\" name='start_d'>

                            <input type=\"text\" placeholder=\"18\" class=\"input-xlarge acti_public_timetxt\" style=\"margin-left: 20px;\" name='start_h'>
                            :
                            <input type=\"text\" placeholder=\"00\" class=\"input-xlarge acti_public_timetxt\" name='start_m'>
                        </div>
                    </div>
                    <div class=\"control-group\">

                        <!-- Text input-->
                        <label class=\"control-label\" for=\"input01\">结束时间</label>
                        <div class=\"controls\">
                            <input type=\"text\" placeholder=\"2015\" class=\"input-xlarge acti_public_timetxt\" name='end_y'>
                            -
                            <input type=\"text\" placeholder=\"01\" class=\"input-xlarge acti_public_timetxt\" name='end_mon'>
                            -
                            <input type=\"text\" placeholder=\"01\" class=\"input-xlarge acti_public_timetxt\" name='end_d'>

                            <input type=\"text\" placeholder=\"20\" class=\"input-xlarge acti_public_timetxt\" style=\"margin-left: 20px;\" name='end_h'>
                            :
                            <input type=\"text\" placeholder=\"00\" class=\"input-xlarge acti_public_timetxt\" name='end_m'>
                        </div>
                    </div>
                </div>
                <div class=\"acti_public_detail\">
                    <div class=\"control-group\">

                        <!-- Text input-->
                        <label class=\"control-label\" for=\"input01\">地点</label>
                        <div class=\"controls\">
                            <div class=\"textarea\">
                                <textarea type=\"\" class=\"acti_public_addr\" name='addr'> </textarea>
                            </div>
                        </div>
                    </div>
                    <div class=\"control-group \">

                        <!-- Textarea -->
                        <label class=\"control-label\">详情（可选）</label>
                        <div class=\"controls\">
                            <div class=\"textarea\">
                                <textarea type=\"\" class=\"acti_public_textarea\" name='detail'> </textarea>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </form>";
    }
}