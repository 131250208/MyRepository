<?php

/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/11/30 0030
 * Time: 16:51
 */
require_once("../../data/usersDS/UserManagerDS.php");
class userManager
{
    public $userManager1=null;
    function __construct(){
        $this->userManager1=new UserManagerDS();
    }
//    注册新用户
    public function register($account,$passwords,$name,$gender,$age){
        //注册
        $this->userManager1->register($account,$passwords,$name,$gender,$age);
    }
//    更新个人说明
    public function updateNote($userID,$note){
        $this->userManager1->updateNote($userID,$note);
    }
    //删除用户
    public function delUser($userID){
        $this->userManager1->delUser($userID);
    }
    //更改用户密码
    public function updatePasswords($userID,$passwords){
        $this->userManager1->updatePasswords($userID,$passwords);
    }
    //更改用户昵称
    public function updateName($userID,$name){
        $this->userManager1->updateName($userID,$name);
    }
    //更改用户性别
    public function updateGender($userID,$gender){
        $this->userManager1->updateGender($userID,$gender);
    }
    //更改用户年龄
    public function updateAge($userID,$age){
        $this->userManager1->updateAge($userID,$age);
    }
    //更改用户权限
    public function modifyIdentity($userID,$identity){
        $this->userManager1->modifyIdentity($userID,$identity);
    }
    //更改用户NF值
    public function updateNF($userID,$nf){
        $this->userManager1->updateNF($userID,$nf);
    }
    //增加用户NF值
    public function addNF($userID,$nf){
        $user=$this->userManager1->findUser($userID);
        $oldNF=$user["nf"];
        $newNF=$oldNF+$nf;
        $this->userManager1->updateNF($userID,$newNF);
    }
    //通过用户账号查找id
    public function getUserID_byAccount($account){
        $res=$this->userManager1->getUserID($account);
        return $res;
    }
    //通过账号找密码(md5已加密)
    public function getUserPassword($account){
        $res=$this->userManager1->getUserPassword($account);
        return $res;
    }
    //查询用户，通过用户昵称，返回布尔值
    public function hasUser($userName){
        $res= $this->userManager1->hasUser($userName);
        return $res;
    }
    //查询用户，返回用户信息------返回一维数组，下标是属性名
    public function findUser($userID){
        $res=$this->userManager1->findUser($userID);
        return $res;
    }
    //查找用户id，通过昵称
    public function getUserID_byName($user_name){
        $res=$this->userManager1->getUserID_byName($user_name);
        return $res;
    }
    //查询朋友圈好友（互相关注）中nf排名前十的的朋友id，name，fn---------返回二维数组，3组下标依次为id，name，fn
    public function findFriends($userID){
        $res= $this->userManager1->findFriends($userID);
        return $res;
    }
    //查询a是否关注了b
    public function isFollowed($a,$b){
        $res= $this->userManager1->isFollowed($a,$b);
        return $res;
    }
    //查询粉丝数——返回数字
    public function findFollowers($userID){
        $res= $this->userManager1->findFollowers($userID);
        return $res;
    }
    //查询关注的人数——返回数字
    public function findTheFollowed($userID){
        $res=$this->userManager1->findTheFollowed($userID);
        return $res;
    }

    //关注某人
    public function follows($user1,$user2){
        $this->userManager1->follows($user1,$user2);
    }
    //取消关注
    public function unfollows($user1,$user2){
        $this->userManager1->unfollows($user1,$user2);
    }

}

////$res=$test->getUserPassword("test0");
////echo $res;
//$res=$test->findFriends(2);
//$res=json_encode($res);
//print_r($res) ;
