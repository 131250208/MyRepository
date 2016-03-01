<?php

/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/11/9 0009
 * Time: 20:02
 */
require_once(dirname(__FILE__).'/../Sql.php');
class HealthManagerDS
{
    public function createTable_health(){
        //锻炼、消耗、睡眠的单位是：km/d，cal/d,h/d

        //目标按用户意愿更新
        $sql="create table health_target (
                id INT(16) NOT NULL AUTO_INCREMENT,
                user_id INT(16) NOT NULL,
                time datetime not null,
                height float not null,
                weight float not null,
                exercise float not null,
                consumption float not null,
                sleep float not null,
                PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;";

        //健康状态实时添加记录，每天统计取平均值
        $sql.="create table health_state (
                id INT(16) NOT NULL AUTO_INCREMENT,
                user_id INT(16) NOT NULL,
                time datetime not null,
                height float not null,
                weight float not null,
                age float not null,
                heartRate float not null,
                bloodPressure_h float not null,
                bloodPressure_l float not null,
                PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;";

        //锻炼情况实时添加记录，每天统计最后情况
        $sql.="create table health_exercise (
                id INT(16) NOT NULL AUTO_INCREMENT,
                user_id INT(16) NOT NULL,
                time datetime not null,
                distance float not null,
                during float not null,
                consumption float not null,
                way VARCHAR(8) not null,
                PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;";

        //睡眠情况只记录最后情况，从睡下开始计时，起床结束并统计
        //date是当天的日子
        $sql.="create table health_sleep (
                id INT(16) NOT NULL AUTO_INCREMENT,
                user_id INT(16) NOT NULL,
                date date not null,
                start_time datetime not null,
                end_time datetime not null,
                during float not null,
                deviation float not null,
                PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;";

        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->multi_query($sql);
        $mysqli->close();
    }
    //创建晒单数据表
    public function create_showHealth(){

        $sql="create table health_show (
                id INT(16) NOT NULL AUTO_INCREMENT,
                user_id INT(4) NOT NULL,
                date date not null,
                PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->multi_query($sql);
        $mysqli->close();
    }
    //插入晒单信息，某个用户某天的健康状况
    public function insertShowHealth($userId,$date){
        $sql="INSERT INTO `health_show`( `user_id`, `date`)
                  VALUES ('$userId','$date');";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->multi_query($sql);
        $mysqli->close();
    }
    //获取晒单信息
    public function getAllShowList(){
        $sql="select *
        from `health_show`
       ORDER BY `id` DESC
        ";

        $mysqli=new Sql();
        $mysqli->connect();
        $res=$mysqli->execute_dql($sql);
        //将结果保存为数组
        $dates=array();
        $ids=array();
        $userIds=array();

        $newRes="没有结果";
        if($row=$res->fetch_row()){
            do{
                foreach($row as $key=>$val){
                    if($key==0){
                        array_push($ids,$val);
                    }
                    elseif($key==1){
                        array_push($userIds,$val);
                    }
                    elseif($key==2) {
                        array_push($dates, $val);
                    }
                }
            }while($row=$res->fetch_row());
            $newRes=array("id"=>$ids,"userId"=>$userIds,"date"=>$dates);
        }
        //释放内存
        $res->free();
        $mysqli->close();

        return $newRes;
    }
    //初始化某用户的数据
    public function iniUser($userID){
        $date=date("Y-m-d");
        $time=date("Y-m-d H:i:s");
        $sql="INSERT INTO `health_exercise`( `user_id`, `time`, `distance`, `during`, `consumption`, `way`)
                  VALUES ('$userID','$time',0,0,0,'未知');";
        $sql.="INSERT INTO `health_sleep`( `user_id`, `date`, `start_time`, `end_time`, `during`, `deviation`)
                  VALUES ('$userID','$date','未采集','未采集',0,0);";
        $sql.="INSERT INTO `health_state`( `user_id`, `time`, `height`, `weight`, `age`, `heartRate`, `bloodPressure_h`, `bloodPressure_l`)
              VALUES ('$userID','$time',0,0,0,0,0,0);";
        $sql.="INSERT INTO `health_target`(`user_id`, `time`, `height`, `weight`, `exercise`, `consumption`, `sleep`)
              VALUES ('$userID','$time',0,0,0,0,0)";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->multi_query($sql);
        $mysqli->close();

    }
    //实时添加锻炼数据
    public function insertExercise($userID,$time,$distance,$during,$consumption,$way){
//        $sql="UPDATE `health_exercise` SET
//        `date`='$date',`distance`='$distance',`during`='$during',`consumption`='$consumption',`way`='$way' WHERE `user_id`='$userID'";
        $sql="INSERT INTO `health_exercise`( `user_id`, `time`, `distance`, `during`, `consumption`, `way`)
                  VALUES ('$userID','$time','$distance','$during','$consumption','$way');";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }
    //添加睡眠情况数据
    public function insertSleep($userID,$date,$start_time,$end_time,$during,$deviation){
//        $sql="UPDATE `health_sleep` SET
//              `date`='$date',`start_time`=''$start_time'',`end_time`='$end_time',`during`='$during',`deviation`='$deviation' WHERE  `user_id`='$userID'";
        $sql="INSERT INTO `health_sleep`( `user_id`, `date`, `start_time`, `end_time`, `during`, `deviation`)
                  VALUES ('$userID','$date','$start_time','$end_time','$during','$deviation');";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }
    //添加身体状况数据
    public function insertState($userID,$time,$height,$weight,$age,$heartRate,$bloodPressure_h,$bloodPressure_l){
//        $sql="UPDATE `health_state` SET
//       `date`='$date',`height`='$height',`weight`='$weight',`age`='$age',`heartRate`='$heartRate',`bloodPressure`='$bloodPressure' WHERE  `user_id`='$userID'";
        $sql="INSERT INTO `health_state`( `user_id`, `time`, `height`, `weight`, `age`, `heartRate`, `bloodPressure_h`, `bloodPressure_l`)
              VALUES ('$userID','$time','$height','$weight','$age','$heartRate','$bloodPressure_h','$bloodPressure_l');";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }
    //添加新目标
    public function insertTarget($userID,$time,$height,$weight,$exercise,$consumption,$sleep){
//        $sql="UPDATE `health_target` SET
//       `date`='$date',`height`='$height',`weight`='$weight',`exercise`='$exercise',`consumption`='$consumption',`sleep`='$sleep' WHERE `user_id`='$userID'";
        $sql="INSERT INTO `health_target`(`user_id`, `time`, `height`, `weight`, `exercise`, `consumption`, `sleep`)
              VALUES ('$userID','$time','$height','$weight','$exercise','$consumption','$sleep')";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }

    //查询最新的目标,返回数组
    public function getLastTarget($userId){
        $sql="select t.height,t.weight,t.exercise,t.consumption,t.sleep
        from `health_target` t
        WHERE `user_id`='$userId'
        ORDER BY t.time DESC
        limit 0,1";

        $mysqli=new Sql();
        $mysqli->connect();
        $res=$mysqli->execute_dql($sql);
        //处理结果
        $newRes="没有结果";
        if($row=$res->fetch_row()){
            $newRes= array("height"=>$row[0],"weight"=>$row[1],"exercise"=>$row[2],
                "consumption"=>$row[3],"sleep"=>$row[4]);
        }

        //释放内存
        $res->free();
        $mysqli->close();

        return $newRes;
    }
    //查询某日睡眠状况,返回数组
    public function getSleep($userId,$date){
        $sql="select s.start_time,s.end_time,s.during,s.deviation
        from `health_sleep` s
        WHERE `user_id`='$userId'and `date`='$date'
        ";

        $mysqli=new Sql();
        $mysqli->connect();
        $res=$mysqli->execute_dql($sql);
        //处理结果
        $newRes="没有结果";
        if($row=$res->fetch_row()){
            $newRes= array("start_time"=>$row[0],"end_time"=>$row[1],"during"=>$row[2],
                "deviation"=>$row[3]);
        }

        //释放内存
        $res->free();
        $mysqli->close();

        return $newRes;
    }
    //查询某日身体状况数据的平均值,返回数组
    public function getState($userId,$date){
        $sql="select avg(s.height) as `height_avg`,avg(s.weight) as `weight_avg` ,avg(s.age) as `age_avg`,avg(s.heartRate) as `heartRate_avg`,avg(s.bloodPressure_h) as `bloodPressure_h_avg`,avg(s.bloodPressure_l) as `bloodPressure_l_avg`
        from(select date_format(`time`,'%Y-%m-%d') as `date`, `height`,`weight`,`age`,`heartRate`,`bloodPressure_h`,`bloodPressure_l`
        from `health_state`
        WHERE `user_id`='$userId') s
        WHERE s.date='$date'
        ";

        $mysqli=new Sql();
        $mysqli->connect();
        $res=$mysqli->execute_dql($sql);
        //处理结果
        $newRes="没有结果";
        if($row=$res->fetch_row()){
            $newRes= array("height"=>round($row[0],1),"weight"=>round($row[1],1),"age"=>round($row[2],1),
                "heartRate_avg"=>round($row[3],1),"bloodPressure_h_avg"=>round($row[4],1),"bloodPressure_l_avg"=>round($row[5],1));
        }

        //释放内存
        $res->free();
        $mysqli->close();

        return $newRes;
    }
    //查询某日最后的锻炼状况,返回数组
    public function getExercise_last($userId,$date){
        $sql="select `distance`,`during`,`consumption`,`way`
        from `health_exercise`
        WHERE `user_id`='$userId'and date_format(`time`,'%Y-%m-%d')='$date'
        ORDER BY `time` DESC
        limit 0,1
        ";

        $mysqli=new Sql();
        $mysqli->connect();
        $res=$mysqli->execute_dql($sql);
        //处理结果
        $newRes="没有结果";
        if($row=$res->fetch_row()){
            $newRes= array("distance"=>$row[0],"during"=>$row[1],"consumption"=>$row[2],
                "way"=>$row[3]);
        }

        //释放内存
        $res->free();
        $mysqli->close();

        return $newRes;
    }

    //查询某个时间段的睡眠状况，返回二维数组
    public function getSleep_somedays($userId,$date1,$date2){
        $sql="select s.date,s.start_time,s.end_time,s.during,s.deviation
        from `health_sleep` s
        WHERE `user_id`='$userId'and `date` BETWEEN '$date1' AND '$date2'
        ";

        $mysqli=new Sql();
        $mysqli->connect();
        $res=$mysqli->execute_dql($sql);
        //将结果保存为数组
        $dates=array();
        $start_times=array();
        $end_times=array();
        $durings=array();
        $deviations=array();

        $newRes="没有结果";
        if($row=$res->fetch_row()){
            do{
                foreach($row as $key=>$val){
                    if($key==0){
                        array_push($dates,$val);
                    }
                    elseif($key==1){
                        array_push($start_times,$val);
                    }
                    elseif($key==2){
                        array_push($end_times,$val);
                    }
                    elseif($key==3){
                        array_push($durings,$val);
                    }
                    elseif($key==4){
                        array_push($deviations,$val);
                    }
                }
            }while($row=$res->fetch_row());
            $newRes=array("date"=>$dates,"start_time"=>$start_times,"end_time"=>$end_times,"during"=>$durings,"deviation"=>$deviations);
        }
        //释放内存
        $res->free();
        $mysqli->close();

        return $newRes;
    }
    //查询某个时间段身体状况数据，返回二维数组
    public function getState_somedays($userId,$date1,$date2){
        $sql="select s.date,avg(s.height) as `height_avg`,avg(s.weight) as `weight_avg` ,avg(s.age) as `age_avg`,avg(s.heartRate) as `heartRate_avg`,avg(s.bloodPressure_h) as `bloodPressure_h_avg`,avg(s.bloodPressure_l) as `bloodPressure_l_avg`
        from(select date_format(`time`,'%Y-%m-%d') as `date`, `height`,`weight`,`age`,`heartRate`,`bloodPressure_h`,`bloodPressure_l`
        from `health_state`
        WHERE `user_id`='$userId') s
        WHERE s.date BETWEEN '$date1'AND '$date2'
        GROUP BY s.date
        ";

        $mysqli=new Sql();
        $mysqli->connect();
        $res=$mysqli->execute_dql($sql);
        //将结果保存为数组
        $dates=array();
        $height_avgs=array();
        $weight_avgs=array();
        $age_avgs=array();
        $heartRate_avgs=array();
        $bloodPressure_h_avgs=array();
        $bloodPressure_l_avgs=array();

        $newRes="没有结果";
        if($row=$res->fetch_row()){
           do{
                foreach($row as $key=>$val){
                    switch($key){
                        case 0:array_push($dates,$val);
                            break;
                        case 1:array_push($height_avgs,round($val,1));
                            break;
                        case 2:array_push($weight_avgs,round($val,1));
                            break;
                        case 3:array_push($age_avgs,round($val,1));
                            break;
                        case 4:array_push($heartRate_avgs,round($val,1));
                            break;
                        case 5:array_push($bloodPressure_h_avgs,round($val,1));
                            break;
                        case 6:array_push($bloodPressure_l_avgs,round($val,1));
                            break;
                    }
                }
            } while($row=$res->fetch_row());
            $newRes=array("date"=>$dates,"height_avg"=>$height_avgs,"weight_avg"=>$weight_avgs,"age_avg"=>$age_avgs,"heartRate_avg"=>$heartRate_avgs,
            "bloodPressure_h_avg"=>$bloodPressure_h_avgs,"bloodPressure_l_avg"=>$bloodPressure_l_avgs);
        }
        //释放内存
        $res->free();
        $mysqli->close();

        return $newRes;

    }
    //查询某个时间段锻炼情况，返回二维数组
    public function getExercise_last_somedays($userId,$date1,$date2){
        $sql="
        select date_format(`time`,'%Y-%m-%d') as `date`,`distance`,`during`,`consumption`,`way`
        from `health_exercise`
        WHERE `user_id`='$userId'and date_format(`time`,'%Y-%m-%d') BETWEEN '$date1'AND '$date2'
        GROUP BY `date`,`distance`,`during`,`consumption`,`way`
        ORDER BY `time` DESC
        ";

        $mysqli=new Sql();
        $mysqli->connect();
        $res=$mysqli->execute_dql($sql);
        //将结果保存为数组
        $dates=array();
        $distances=array();
        $durings=array();
        $consumptions=array();
        $way=array();

        $newRes="没有结果";
        if($row=$res->fetch_row()){
            do{
                foreach($row as $key=>$val){
                    switch($key){
                        case 0:array_push($dates,$val);
                            break;
                        case 1:array_push($distances,$val);
                            break;
                        case 2:array_push($durings,$val);
                            break;
                        case 3:array_push($consumptions,$val);
                            break;
                        case 4:array_push($way,$val);
                            break;
                    }
                }
            }while($row=$res->fetch_row());


        }
        //搜索出每天最后时间的下标
        $indexs=array();
        $tag=null;
        for($key=0;$key<count($dates);$key++){
            if($key==0){
                $tag=$dates[$key];
                array_push($indexs,$key);
            }
            else{
                if($tag!=$dates[$key]){
                    $tag=$dates[$key];
                    array_push($indexs,$key);
                }
            }

        }

        $newdates=array();
        $newdistances=array();
        $newdurings=array();
        $newconsumptions=array();
        $newways=array();

        for($i=0;$i<count($indexs);$i++){
            array_push($newdates,$dates[$indexs[$i]]);
            array_push($newdistances,$distances[$indexs[$i]]);
            array_push($newdurings,$durings[$indexs[$i]]);
            array_push($newconsumptions,$consumptions[$indexs[$i]]);
            array_push($newways,$way[$indexs[$i]]);
        }
        $newRes=array("date"=>$newdates,"distance"=>$newdistances,"during"=>$newdurings,"consumption"=>$newconsumptions,
            "way"=>$newways);
        //释放内存
        $res->free();
        $mysqli->close();

        return $newRes;

    }

    // 一个月的数据
    public function inidata(){

        //每天记录睡眠、锻炼和身体状况
        for($day=0;$day<=30;$day++){

            for($i=9;$i<=58;$i++){
                $date=date("Y-m-d",strtotime("+".$day." day"));
                $during=(5+rand(0,5));
                $startime=date("Y-m-d H:i:s",strtotime("+".$day." day"));
                $endtime=date("Y-m-d H:i:s",strtotime("+".$day." day +".$during." hour"));
                $this->insertSleep($i,$date,$startime,$endtime,$during,0);
            }

            //8个小时，每个小时记录一次身体状况和锻炼
            for($hour=0;$hour<=8;$hour++){
                $time=date("Y-m-d H:i:s",strtotime("+".$day." day +".$hour." hour"));

                for($i=9;$i<=58;$i++){
                    //锻炼
                    $this->insertExercise($i,$time,rand(2,4)*($hour+1),$hour+1,rand(30,50)*($hour+1),"跑步");
                    //身体状况
                    $this->insertState($i,$time,rand(160,180),rand(40,65)+$day,rand(15,50),rand(45,100),rand(90,150),rand(50,80));
                }
            }

        }
//每周改一次目标
        for($week=1;$week<=4;$week++){
            $time=date("Y-m-d H:i:s",strtotime("+".$week." week"));
            for($i=9;$i<=58;$i++){
                $this->insertTarget($i,$time,180+$week,60+$week*2,rand(100,150)+$week*5,rand(400,500)+$week*10,rand(8,10)+$week);
            }
        }
    }
}
//
//$healthManager=new HealthManagerDS();
//$healthManager->inidata();
//$healthManager->createTable_health();
//$healthManager->create_showHealth();
//for($i=2;$i<=101;$i++){
//    $this->iniUser($i);
//}

//$data=$this->showAllDate(1);
//
//foreach($data AS $item1){
//    foreach($item1 AS $item2){
//        foreach($item2 AS $item3){
//            echo"--$item3";
//        }
//        echo"\n";
//    }
//}