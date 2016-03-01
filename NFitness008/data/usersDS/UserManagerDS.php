<?php

/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/11/9 0009
 * Time: 16:57
 */
require_once(dirname(__FILE__).'/../Sql.php');
class UserManagerDS
{

    public function createTable_user(){
        $mysqli=new Sql();
        $mysqli->connect();
        $sql="create table user (
                id INT(16) NOT NULL AUTO_INCREMENT,
                account VARCHAR(64) NOT NULL,
                passwords VARCHAR(128) not null,
                identity VARCHAR(6) not null,
                name VARCHAR(32) ,
                gender VARCHAR(2) ,
                age int(4) ,
                note VARCHAR(64),
                nf int(16) ,
                PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;";
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }
    public function createTable_follow(){
        $mysqli=new mysqli("localhost","root","","nfitness");
        if($mysqli->connect_error){
            die("连接失败".$mysqli->connect_error);
        }
        else{
            echo"连接成功</br>";
        }
        $sql="create table follow (
                id INT(16) NOT NULL AUTO_INCREMENT,
                follower_id INT(16) NOT NULL,
                followed_id INT(16) not null,
                PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;";
        $mysqli->query($sql);
    }

    //注册新用户
    public function register($account,$passwords,$name,$gender,$age){
        $sql="INSERT INTO `user`( `account`, `passwords`, `identity`, `name`, `gender`, `age`, `nf`) VALUES
                        ('$account',md5('$passwords'),'普通','$name','$gender','$age',0)";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }
    //通过用户账号查找id
    public function getUserID($account){
        $sql="SELECT u.id  FROM `user` u WHERE `account`='$account'";
        $mysqli=new Sql();
        $mysqli->connect();
        $res=$mysqli->execute_dql($sql);
        //处理结果
        $newRes="没有结果";
        if($row=$res->fetch_row()){
            $newRes= $row[0];
        }

        //释放内存
        $res->free();
        $mysqli->close();

        return $newRes;
    }
    //通过用户账号查找id
    public function getUserID_byName($user_name){
        $sql="SELECT u.id  FROM `user` u WHERE `name`='$user_name'";
        $mysqli=new Sql();
        $mysqli->connect();
        $res=$mysqli->execute_dql($sql);
        //处理结果
        $newRes="没有结果";
        if($row=$res->fetch_row()){
            $newRes= $row[0];
        }

        //释放内存
        $res->free();
        $mysqli->close();

        return $newRes;
    }
    //通过账号找密码
    public function getUserPassword($account){
        $sql="SELECT u.passwords  FROM `user`u WHERE `account`='$account'";
        $mysqli=new Sql();
        $mysqli->connect();
        $res=$mysqli->execute_dql($sql);
        //处理结果
        $newRes="没有结果";
        if($row=$res->fetch_row()){
            $newRes= $row[0];
        }

        //释放内存
        $res->free();
        $mysqli->close();

        return $newRes;
    }
    //更改个人说明
    public function updateNote($userID,$note){
        $sql="UPDATE `user` SET `note`='$note' WHERE id='$userID'";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }
    //删除用户
    public function delUser($userID){
        $sql="DELETE FROM `user` WHERE `id`='$userID'";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }
    //更改用户密码
    public function updatePasswords($userID,$passwords){
        $sql="UPDATE `user` SET `passwords`=md5('$passwords') WHERE id='$userID'";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }
    //更改用户昵称
    public function updateName($userID,$name){
        $sql="UPDATE `user` SET `name`='$name' WHERE id='$userID'";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }
    //更改用户性别
    public function updateGender($userID,$gender){
        $sql="UPDATE `user` SET `gender`='$gender' WHERE id='$userID'";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }
    //更改用户年龄
    public function updateAge($userID,$age){
        $sql="UPDATE `user` SET `age`='$age' WHERE id='$userID'";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }
    //更改用户权限
    public function modifyIdentity($userID,$identity){
        $sql="UPDATE `user` SET `identity`='$identity' WHERE id='$userID'";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }
    //更改用户NF值
    public function updateNF($userID,$nf){
        $sql="UPDATE `user` SET `nf`='$nf' WHERE id='$userID'";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }
    //查询用户，通过用户昵称，返回布尔值
    public function hasUser($user_name){
        $sql="SELECT * FROM `user` WHERE `name`='$user_name'";
        $mysqli=new Sql();
        $mysqli->connect();
        $res=$mysqli->execute_dql($sql);
        $mysqli->close();
        if($row=$res->fetch_row()){
            $res->free();
            return true;
        }
        return false;
    }
    //查询用户，返回用户信息
    public function findUser($userID){
        $sql="SELECT * FROM `user` WHERE `id`='$userID'";
        $mysqli=new Sql();
        $mysqli->connect();
        $res=$mysqli->execute_dql($sql);
        //处理结果
        $newRes="没有结果";
        if($row=$res->fetch_row()){
            for($i=0;$i<count($row);$i++){
                $newRes=array("id"=>$row[0],"account"=>$row[1],"passwords"=>$row[2],"identity"=>$row[3],"name"=>$row[4],
                    "gender"=>$row[5],"age"=>$row[6],"note"=>$row[7],"nf"=>$row[8]);
            }
        }

        //释放内存
        $res->free();
        $mysqli->close();

        return $newRes;
    }
    //查询朋友圈好友（互相关注）中nf排名前十的的朋友id，name，fn
    public function findFriends($userID){
        $sql="select u.id ,u.name,u.nf
              FROM  `user`u
              where u.id='$userID'OR u.id IN (SELECT  `followed_id`  FROM `follow` WHERE `follower_id`='$userID'
              AND `followed_id` IN (SELECT  `follower_id`  FROM `follow` WHERE `followed_id`='$userID'))
              order by u.nf DESC
              limit 0,10";
        $mysqli=new Sql();
        $mysqli->connect();
        $res=$mysqli->execute_dql($sql);
        //将结果保存为数组
        $ids=array();
        $names=array();
        $nfs=array();

        $newRes="没有结果";
        if($row=$res->fetch_row()){
            do{
                foreach($row as $key=>$val){
                    if($key==0){
                        array_push($ids,$val);
                    }
                    elseif($key==1){
                        array_push($names,$val);
                    }
                    elseif($key==2){
                        array_push($nfs,$val);
                    }
                }
            }while($row=$res->fetch_row());
            $newRes=array("id"=>$ids,"name"=>$names,"nf"=>$nfs);
        }
        //释放内存
        $res->free();
        $mysqli->close();

        return $newRes;
    }
    //查询粉丝数
    public function findFollowers($userID){
        $sql="SELECT  count(`follower_id`)  FROM `follow` WHERE `followed_id`='$userID'";
        $mysqli=new Sql();
        $mysqli->connect();
        $res=$mysqli->execute_dql($sql);
        //处理结果
        $newRes="没有结果";
        if($row=$res->fetch_row()){
            $newRes= $row[0];
        }

        //释放内存
        $res->free();
        $mysqli->close();

        return $newRes;
    }
    //查询关注的人数
    public function findTheFollowed($userID){
        $sql="SELECT count(`followed_id`) FROM `follow` WHERE `follower_id`='$userID'";
        $mysqli=new Sql();
        $mysqli->connect();
        $res=$mysqli->execute_dql($sql);

        //处理结果
        $newRes="没有结果";
        if($row=$res->fetch_row()){
            $newRes= $row[0];
        }

        //释放内存
        $res->free();
        $mysqli->close();

        return $newRes;
    }
    //查询a是否关注了b
    public function isFollowed($a,$b){
        $sql="SELECT * FROM `follow` WHERE `follower_id`='$a'and `followed_id`='$b'" ;
        $mysqli=new Sql();
        $mysqli->connect();
        $res=$mysqli->execute_dql($sql);

        //处理结果
        $newRes="没有结果";
        if($row=$res->fetch_row()){
            $newRes= "已关注";
        }

        //释放内存
        $res->free();
        $mysqli->close();

        return $newRes;
    }
    //关注某人
    public function follows($user1,$user2){
        $sql="INSERT INTO `follow`( `follower_id`,`followed_id`) VALUES
                        ('$user1','$user2')";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }
    //取消关注
    public function unfollows($user1,$user2){
        $sql="DELETE FROM `follow` WHERE `follower_id`='$user1' AND `followed_id`= '$user2'";
        $mysqli=new Sql();
        $mysqli->connect();
        $mysqli->execute_dml($sql);
        $mysqli->close();
    }
}

//实例化并建表
//$userManager->createTable_follow();
//for($i=9;$i<=58;$i++){
//    if($i%6==1){
//        $userManager->modifyIdentity($i,"医生");
//    }
//    elseif($i%6==2){
//        $userManager->modifyIdentity($i,"教练");
//    }
//    elseif($i%6==3){
//        $userManager->modifyIdentity($i,"医生&教练");
//    }
//
//}
//print_r($res) ;

//for($i=0;$i<count($arr["id"]);$i++){
//    echo "id=".$arr["id"][$i]."--"."name=".$arr["name"][$i]."--"."nf=".$arr["nf"][$i]."\n";
//}
//
//echo $arr=$userManager->findFollowers(2)."\n";
//echo $arr=$userManager->findTheFollowed(2);
////添加100个用户
//for($i=1;$i<=50;$i++){
//    $test_acount="test".$i;
//    $test_passwords="123";
//    $test_name="唐家".$i."少";
//    $test_gender="女";
//    if($i%2==0){
//        $test_gender="男";
//    }
//    $test_age=20+($i%10);
//    $userManager->register($test_acount,$test_passwords,$test_name,$test_gender,$test_age);
//    //分配NF值
//    $userManager->updateNF($i,rand(0,5000));
//}

////使他们互相关注
//for($i=9;$i<=58;$i++){
//    for($j=9;$j<=58;$j++){
//        if(rand(0,10)>=3){
//            $userManager->follows($i,$j);
//        }
//    }
//}

//$userManager->createTable_user();
?>