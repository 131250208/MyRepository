<?php

/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/12/3 0003
 * Time: 11:34
 */
require_once("../../data/usersDS/AdminDS.php");
class admin
{
    public $admin=null;
    function __construct(){
        $this->admin=new AdminDS();
    }

    //写申请
    public function addApply($user_id,$apply_identity,$name,$identity_num,$images){
        $this->admin->addApply($user_id,$apply_identity,$name,$identity_num,$images);
    }
    //删除申请
    public function delApply($applyID){
        $this->admin->delApply($applyID);
    }
    //通过该申请
    public function passApply($applyID){
        $this->admin->passApply($applyID);
    }
    //查找所有申请
    public function getAllApplys(){
        $res=$this->admin->getAllApplys();
        return $res;
    }
    //举报
    public function sendWhistle_blowing($user_id1,$user_id2,$detail,$images){
        $this->admin->sendWhistle_blowing($user_id1,$user_id2,$detail,$images);
    }
    //删除举报
    public function delWhistle_blowing($whisId){
        $this->admin->delWhistle_blowing($whisId);
    }
    //查看所有举报
    public function getAllWhistle_blowings(){
        $res=$this->admin->getAllWhistle_blowings();
        return $res;
    }

}