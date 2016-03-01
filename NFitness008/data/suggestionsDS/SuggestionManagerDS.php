<?php

/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/11/9 0009
 * Time: 18:38
 */
require_once(dirname(__FILE__).'/../Sql.php');
class SuggestionManagerDS
{

     public function createTable_suggestion(){
         //target:此建议的目标（日期+用户id：YYYY-MM-DD_****），用来确定同一类建议，其中一个建议被采纳，其他被删除
         $sql="create table suggestion (
                id INT(16) NOT NULL AUTO_INCREMENT,
                sender_id int(4) NOT NULL,
                accepter_id int(4) not null,
                content TEXT not null,
                state VARCHAR(8) not null,
                PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;";
         $mysqli=new Sql();
         $mysqli->connect();
         $mysqli->execute_dml($sql);
         $mysqli->close();
     }
    //发送建议
    public function addSuggestion($sender_id,$accepter_id,$content){
        $sql="INSERT INTO `suggestion`( `sender_id`, `accepter_id`, `content`, `state`) VALUES
                                    ('$sender_id','$accepter_id','$content','未处理')";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }
    //删除建议
    public function delSuggestion($sugID){
        $sql="DELETE FROM `suggestion` WHERE `id`='$sugID'";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }
    //处理建议（建议状态：已采纳/未处理）
    public function dealSuggestion($sugID, $state){
        $sql="UPDATE `suggestion` SET `state`='$state' WHERE `id`='$sugID'";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }
    //查看某人收到的建议
    public function getAcceptedSuggestion($userID){
        $sql="SELECT * FROM `suggestion` WHERE `accepter_id`='$userID' ORDER BY `id` DESC ";
        //处理
        $mysqli=new Sql();
        $mysqli->connect();
        $res=$mysqli->execute_dql($sql);
        //将结果保存为数组
        $ids=array();
        $sender_ids=array();
        $accepter_id=array();
        $contents=array();
        $states=array();

        $newRes="没有结果";
        if($row=$res->fetch_row()){
            do{
                foreach($row as $key=>$val){
                    switch($key){
                        case 0:array_push($ids,$val);
                            break;
                        case 1:array_push($sender_ids,$val);
                            break;
                        case 2:array_push($accepter_id,$val);
                            break;
                        case 3:array_push($contents,$val);
                            break;
                        case 4:array_push($states,$val);
                            break;
                    }
                }
            } while($row=$res->fetch_row());
            $newRes=array("id"=>$ids,"sender_id"=>$sender_ids,"accepter_id"=>$accepter_id,"content"=>$contents,"state"=>$states
                );
        }
        //释放内存
        $res->free();
        $mysqli->close();

        return $newRes;

    }
    //查看某人的发出的建议
    public function getSendedSuggestion($userID){
        $sql="SELECT * FROM `suggestion` WHERE `sender_id`='$userID'ORDER BY `id` DESC";
        //处理
        $mysqli=new Sql();
        $mysqli->connect();
        $res=$mysqli->execute_dql($sql);
        //将结果保存为数组
        $ids=array();
        $sender_ids=array();
        $accepter_id=array();
        $contents=array();
        $states=array();

        $newRes="没有结果";
        if($row=$res->fetch_row()){
            do{
                foreach($row as $key=>$val){
                    switch($key){
                        case 0:array_push($ids,$val);
                            break;
                        case 1:array_push($sender_ids,$val);
                            break;
                        case 2:array_push($accepter_id,$val);
                            break;
                        case 3:array_push($contents,$val);
                            break;
                        case 4:array_push($states,$val);
                            break;
                    }
                }
            } while($row=$res->fetch_row());
            $newRes=array("id"=>$ids,"sender_id"=>$sender_ids,"accepter_id"=>$accepter_id,"content"=>$contents,"state"=>$states
             );
        }
        //释放内存
        $res->free();
        $mysqli->close();

        return $newRes;
    }
    public function iniData(){
        require_once ("../usersDS/UserManagerDS.php");
        $userM=new UserManagerDS();
        for($i=1;$i<=1000;$i++){
            $send=rand(9,58);
            $accept=rand(9,58);
            if($send!=$accept){
                $sender=$userM->findUser($send);
                if($sender["identity"]!="普通"){
                    $this->addSuggestion($send,$accept,"每天跑个".$i."公里");
                }
            }
            else{
                $i--;
            }
        }
    }
}

//$sug=new SuggestionManagerDS();
////$sug->createTable_suggestion();
//$sug->iniData();
?>