<?php

/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/11/9 0009
 * Time: 21:12
 */
require_once(dirname(__FILE__).'/../Sql.php');
class AdminDS
{
    public function createTable_apply(){
        $mysqli= new mysqli("localhost","root","","nfitness");
        if($mysqli->connect_error){
            die("连接失败".$mysqli->connect_error);
        }
        else{
            echo"连接成功<br/>";
        }

        $sql="create table apply (
                id INT(16) NOT NULL AUTO_INCREMENT,
                user_id INT(16) NOT NULL,
                apply_identity VARCHAR(4) not null,
                name VARCHAR(8) not null,
                identity_num int(18) not null,
                images TEXT not null,
                state VARCHAR(8) not null,
                PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;";
        $mysqli->query($sql);

    }
    public function createTable_whistle_blowing(){
        $mysqli= new mysqli("localhost","root","","nfitness");
        if($mysqli->connect_error){
            die("连接失败".$mysqli->connect_error);
        }
        else{
            echo"连接成功<br/>";
        }

        $sql="create table whistle_blowing (
                id INT(16) NOT NULL AUTO_INCREMENT,
                user_id1 INT(16) NOT NULL,
                user_id2 INT(16) NOT NULL,
                detail TEXT not null,
                images TEXT not null,
                PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;";
        $mysqli->query($sql);

    }

    //写申请
    public function addApply($user_id,$apply_identity,$name,$identity_num,$images){
        $sql="INSERT INTO `apply`(`user_id`, `apply_identity`, `name`, `identity_num`, `images`, `state`)
               VALUES ('$user_id','$apply_identity','$name','$identity_num','$images','未处理')";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }
    //删除申请
    public function delApply($applyID){
        $sql="DELETE FROM `apply` WHERE `id`='$applyID'";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }
    //通过该申请
    public function passApply($applyID){
        $sql="UPDATE `apply` SET
              `state`='通过' WHERE `id`='$applyID'";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }
    //查找所有申请
    public function getAllApplys(){
        $sql="SELECT * FROM `apply` ORDER BY `id` DESC";
        //处理
        $mysqli=new Sql();
        $mysqli->connect();
        $res=$mysqli->execute_dql($sql);
        //将结果保存为数组
        $ids=array();
        $user_ids=array();
        $apply_identitys=array();
        $names=array();
        $identity_nums=array();
        $images=array();
        $states=array();

        $newRes="没有结果";
        if($row=$res->fetch_row()){
            do{
                foreach($row as $key=>$val){
                    switch($key){
                        case 0:array_push($ids,$val);
                            break;
                        case 1:array_push($user_ids,$val);
                            break;
                        case 2:array_push($apply_identitys,$val);
                            break;
                        case 3:array_push($names,$val);
                            break;
                        case 4:array_push($identity_nums,$val);
                            break;
                        case 5:array_push($images,$val);
                            break;
                        case 6:array_push($states,$val);
                            break;
                    }
                }
            } while($row=$res->fetch_row());
            $newRes=array("id"=>$ids,"user_id"=>$user_ids,"apply_identity"=>$apply_identitys,"name"=>$names,"identity_num"=>$identity_nums,
                "images"=>$images,"state"=>$states);
        }
        //释放内存
        $res->free();
        $mysqli->close();

        return $newRes;
    }
    //举报
    public function sendWhistle_blowing($user_id1,$user_id2,$detail,$images){
        $sql="INSERT INTO `whistle_blowing`(`user_id1`, `user_id2`, `detail`, `images`)
                VALUES ('$user_id1','$user_id2','$detail','$images'";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }
    //删除举报

    public function delWhistle_blowing($whisId){
        $sql="DELETE FROM `whistle_blowing` WHERE `id`='$whisId'";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }
    //查看所有举报
    public function getAllWhistle_blowings(){
        $sql="SELECT * FROM `whistle_blowing`ORDER BY `id` DESC";
        //处理
        $mysqli=new Sql();
        $mysqli->connect();
        $res=$mysqli->execute_dql($sql);
        //将结果保存为数组
        $ids=array();
        $user_id1s=array();
        $user_id2s=array();
        $details=array();
        $images=array();

        $newRes="没有结果";
        if($row=$res->fetch_row()){
            do{
                foreach($row as $key=>$val){
                    switch($key){
                        case 0:array_push($ids,$val);
                            break;
                        case 1:array_push($user_id1s,$val);
                            break;
                        case 2:array_push($user_id2s,$val);
                            break;
                        case 3:array_push($details,$val);
                            break;
                        case 4:array_push($images,$val);
                            break;
                    }
                }
            } while($row=$res->fetch_row());
            $newRes=array("id"=>$ids,"user_id1"=>$user_id1s,"user_id2"=>$user_id2s,"detail"=>$details,"images"=>$images
               );
        }
        //释放内存
        $res->free();
        $mysqli->close();

        return $newRes;
    }
}

$admin=new Admin();
$admin->createTable_apply();