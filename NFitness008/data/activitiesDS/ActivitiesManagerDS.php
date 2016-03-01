<?php

/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/11/9 0009
 * Time: 19:00
 */
require_once(dirname(__FILE__).'/../Sql.php');
class ActivitiesManagerDS
{

    public function createTable_activity(){

        $sql="create table activity (
                id INT(16) NOT NULL AUTO_INCREMENT,
                name VARCHAR(32) NOT NULL,
                sponsor_id int(4) not null,
                start_time datetime not null,
                end_time datetime not null,
                address VARCHAR(128) not null,
                brief TEXT not null,
                numOfPar int(4) not null,
                state VARCHAR(8) not null,
                nf int(16) not null,
                PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }
    public function  createTable_parActivity(){

        $sql="create table par_activity (
                id INT(16) NOT NULL AUTO_INCREMENT,
                activityID INT(16) NOT NULL,
                userID VARCHAR(16) not null,
                date date not null,
                PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }

    //发布活动
    public function addActivity($name,$sponsor_id,$start_time,$end_time,$address,$brief,$numOfPar,$nf){
        $sql="INSERT INTO `activity` (`name`,`sponsor_id`,`start_time`,`end_time`,`address`,`brief`,`numOfPar`,`state`,`nf`) VALUES
                                      ('$name','$sponsor_id','$start_time','$end_time','$address','$brief','$numOfPar','等待','$nf')";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }
    //取消活动
    public function delActivity($actID){
        $sql="DELETE FROM `activity` WHERE `id`='$actID'";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();

    }
    //删除该活动所有参与关系
    public function delAllPartants($actiId){
        $sql="DELETE FROM `par_activity` WHERE `activityID`='$actiId'";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }
    //改变活动的状态
    public function setActivityState($actID,$state){
        $sql="UPDATE `activity` SET `state`='$state' WHERE `id`='$actID'";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }

    //查找某人发起的活动
    public function getActivity_sppnserID($sponsorID){
        $sql="SELECT * FROM `activity` WHERE `sponsor_id`='$sponsorID'ORDER BY `id` DESC";

        $mysqli=new Sql();
        $mysqli->connect();
        $res=$mysqli->execute_dql($sql);
        //将结果保存为数组
        $ids=array();
        $names=array();
        $sponsor_ids=array();
        $start_times=array();
        $end_times=array();
        $addresses=array();
        $brieves=array();
        $numOfPars=array();
        $states=array();
        $nfs=array();

        $newRes="没有结果";
        if($row=$res->fetch_row()){
            do{
                foreach($row as $key=>$val){
                    switch($key){
                        case 0:array_push($ids,$val);
                            break;
                        case 1:array_push($names,$val);
                            break;
                        case 2:array_push($sponsor_ids,$val);
                            break;
                        case 3:array_push($start_times,$val);
                            break;
                        case 4:array_push($end_times,$val);
                            break;
                        case 5:array_push($addresses,$val);
                            break;
                        case 6:array_push($brieves,$val);
                            break;
                        case 7:array_push($numOfPars,$val);
                            break;
                        case 8:array_push($states,$val);
                            break;
                        case 9:array_push($nfs,$val);
                            break;
                    }
                }
            } while($row=$res->fetch_row());
            $newRes=array("id"=>$ids,"name"=>$names,"sponsor_id"=>$sponsor_ids,"start_time"=>$start_times,"end_time"=>$end_times,
                "address"=>$addresses,"brief"=>$brieves, "numOfPar"=>$numOfPars,"state"=>$states,"nf"=>$nfs);
        }
        //释放内存
        $res->free();
        $mysqli->close();

        return $newRes;

    }
    //查找某人参与的活动，返回id数组
    public function getActivityID_partantID($partantID){
        $sql="SELECT `activityID` FROM `par_activity` WHERE  `userID`='$partantID' ORDER BY `id` DESC";

        $mysqli=new Sql();
        $mysqli->connect();
        $res=$mysqli->execute_dql($sql);
        //将结果保存为数组
        $ids=array();

        $newRes="没有结果";
        if($row=$res->fetch_row()){
            do{
                array_push($ids,$row[0]);
            } while($row=$res->fetch_row());
            $newRes=$ids;
        }
        //释放内存
        $res->free();
        $mysqli->close();

        return $newRes;
    }
    //通过id查找某个活动
    public function getActivity_activityID($activityID){
        $sql="SELECT * FROM `activity` WHERE `id`='$activityID'";

        $mysqli=new Sql();
        $mysqli->connect();
        $res=$mysqli->execute_dql($sql);

        $newRes="没有结果";
        if($row=$res->fetch_row()){
            $newRes=array("id"=>$row[0],"name"=>$row[1],"sponsor_id"=>$row[2],"start_time"=>$row[3],"end_time"=>$row[4],
                "address"=>$row[5],"brief"=>$row[6], "numOfPar"=>$row[7],"state"=>$row[8],"nf"=>$row[9]);
        }
        //释放内存
        $res->free();
        $mysqli->close();

        return $newRes;
    }
    //通过id数组查找活动
    public function getActivity_manyActivityIDs($activityIDs){
        //将结果保存为数组
        $ids=array();
        $names=array();
        $sponsor_ids=array();
        $start_times=array();
        $end_times=array();
        $addresses=array();
        $brieves=array();
        $numOfPars=array();
        $states=array();
        $nfs=array();

        for($i=0;$i<count($activityIDs);$i++){
            $acti=$this->getActivity_activityID($activityIDs[$i]);

            foreach($acti as $key=>$val){
                switch($key){
                    case "id":array_push($ids,$val);
                        break;
                    case "name":array_push($names,$val);
                        break;
                    case "sponsor_id":array_push($sponsor_ids,$val);
                        break;
                    case "start_time":array_push($start_times,$val);
                        break;
                    case "end_time":array_push($end_times,$val);
                        break;
                    case "address":array_push($addresses,$val);
                        break;
                    case "brief":array_push($brieves,$val);
                        break;
                    case "numOfPar":array_push($numOfPars,$val);
                        break;
                    case "state":array_push($states,$val);
                        break;
                    case "nf":array_push($nfs,$val);
                        break;
                }

            }

        }
        $newRes=array("id"=>$ids,"name"=>$names,"sponsor_id"=>$sponsor_ids,"start_time"=>$start_times,"end_time"=>$end_times,
            "address"=>$addresses,"brief"=>$brieves, "numOfPar"=>$numOfPars,"state"=>$states,"nf"=>$nfs);
        return $newRes;
    }
    //查找所有活动
    public function getAllActivity(){
        $sql="SELECT * FROM `activity`ORDER BY `id` DESC";
        //处理
        $mysqli=new Sql();
        $mysqli->connect();
        $res=$mysqli->execute_dql($sql);
        //将结果保存为数组
        $ids=array();
        $names=array();
        $sponsor_ids=array();
        $start_times=array();
        $end_times=array();
        $addresses=array();
        $brieves=array();
        $numOfPars=array();
        $states=array();
        $nfs=array();

        $newRes="没有结果";
        if($row=$res->fetch_row()){
            do{
                foreach($row as $key=>$val){
                    switch($key){
                        case 0:array_push($ids,$val);
                            break;
                        case 1:array_push($names,$val);
                            break;
                        case 2:array_push($sponsor_ids,$val);
                            break;
                        case 3:array_push($start_times,$val);
                            break;
                        case 4:array_push($end_times,$val);
                            break;
                        case 5:array_push($addresses,$val);
                            break;
                        case 6:array_push($brieves,$val);
                            break;
                        case 7:array_push($numOfPars,$val);
                            break;
                        case 8:array_push($states,$val);
                            break;
                        case 9:array_push($nfs,$val);
                            break;
                    }
                }
            } while($row=$res->fetch_row());
            $newRes=array("id"=>$ids,"name"=>$names,"sponsor_id"=>$sponsor_ids,"start_time"=>$start_times,"end_time"=>$end_times,
                "address"=>$addresses,"brief"=>$brieves, "numOfPar"=>$numOfPars,"state"=>$states,"nf"=>$nfs);
        }
        //释放内存
        $res->free();
        $mysqli->close();

        return $newRes;
    }
    //判断当前时间是否在活动结束时间之前
    public function inTime($activityID,$time){
        $sql="select if('$time' < `end_time`,'true','false') as `inTime`
        from `activity` where `id`=$activityID";
        $mysqli=new Sql();
        $mysqli->connect();
        $res=$mysqli->execute_dql($sql);
        //处理结果
        $newRes="没有结果";
        if($row=$res->fetch_row()){
            $newRes=$row[0];
        }

        //释放内存
        $res->free();
        $mysqli->close();

        return $newRes;
    }
    //参与活动
    public function parActivity($activityID,$userID,$date){
        $sql="INSERT INTO `par_activity`( `activityID`, `userID`, `date`)
              VALUES ('$activityID','$userID','$date')";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }
    //退出活动
    public function quitActivity($activityID,$userID){
        $sql="DELETE FROM `par_activity` WHERE `activityID`='$activityID' AND  `userID`='$userID'";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }

    //查找某活动的所有参与者(返回id数组)
    public function getAllParticipants($activityID){
        $sql="SELECT `userID` FROM `par_activity` WHERE  `activityID`='$activityID' ORDER BY `id` DESC";

        $mysqli=new Sql();
        $mysqli->connect();
        $res=$mysqli->execute_dql($sql);
        //将结果保存为数组
        $ids=array();

        if($row=$res->fetch_row()){
            do{
               array_push($ids,$row[0]);
            } while($row=$res->fetch_row());

        }
        $newRes=$ids;
        //释放内存
        $res->free();
        $mysqli->close();

        return $newRes;
    }

    //模拟5个用户（2,32,42,62,82）一个月的数据
    public function iniTestActiData(){
        for($day=0;$day<=30;$day++){
            for($i=9;$i<=58;$i++){
                $during=rand(1,5);
                $startime=date("Y-m-d H:i:s",strtotime("+".$day." day"));
                $endtime=date("Y-m-d H:i:s",strtotime("+".$day." day +".$during." hour"));
                $this->addActivity("跑步_".$day."_".$i,$i,$startime,$endtime,"测试地址_".$day."_".$i,"测试简介_".$day."_".$i,rand(3,16),rand(3,16)*50);
            }

        }
    }

    public function iniTestParData(){
        for($i=0;$i<1000;$i++){
            $activityID=rand(9,163);
            $userID=rand(2,100);
            $arr=$this->getActivity_activityID($activityID);
            $date=$arr["start_time"];
            $this->parActivity($activityID,$userID,$date);
        }
    }
}


//$activitiesMan=new ActivitiesManagerDS();
//$activitiesMan->iniTestActiData();
//$activitiesMan->createTable_parActivity();
//$activitiesMan->createTable_activity();
//$res=$activitiesMan->getAllActivity();
//print_r($res);
//$activitiesMan->createTable_activity();
//$activitiesMan->createTable_parActivity();
//$activitiesMan->addActivity("夜跑",1,"2015-11-11 20:00:00","2015-11-11 21:00:00","学校运动场","自带水和衣服，天冷",8,200);
?>