<?php

/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/12/3 0003
 * Time: 10:32
 */
require_once("../../data/activitiesDS/ActivitiesManagerDS.php");
require_once ("../../bl/usersBL/userManager.php");
//活动的状态有：等待/已开启
//一旦满员，立即开启
class activitiesManager
{
    public $activitiesManager=null;
    function __construct(){
        $this->activitiesManager=new ActivitiesManagerDS();
    }

    //发布活动
    public function addActivity($name,$sponsor_id,$start_time,$end_time,$address,$brief,$numOfPar,$nf){
        $this->activitiesManager->addActivity($name,$sponsor_id,$start_time,$end_time,$address,$brief,$numOfPar,$nf);
    }
    //取消/结束活动
    public function delActivity($actID){
        $this->activitiesManager->delActivity($actID);
        $this->activitiesManager->delAllPartants($actID);
    }
    //开启活动
    public function setActivityState($actID){
        $this->activitiesManager->setActivityState($actID,"已开启");
    }

    //查找某人发起的活动
    public function getActivity_sppnserID($sponsorID){
        $res=$this->activitiesManager->getActivity_sppnserID($sponsorID);
        return $res;
    }
    //查找某人参与的活动
    public function getActivity_partantID($partantID){
        $actiIds=$this->activitiesManager->getActivityID_partantID($partantID);
        if($actiIds!="没有结果"){
            $res=$this->activitiesManager->getActivity_manyActivityIDs($actiIds);
        }
        else{
            $res="没有结果";
        }
        return $res;
    }
    //通过id查找某个活动
    public function getActivity_activityID($activityID){
       $res= $this->activitiesManager->getActivity_activityID($activityID);
        return $res;
    }
    //查找所有活动
    public function getAllActivity(){
        $res=$this->activitiesManager->getAllActivity();
        return $res;
    }
    //点击参与活动
    public function parActivity($activityID,$userID){

//        获取当前时间
        $time=date("Y-m-d H:i:s");
        //判断当前时间是否在结束时间之前
        $intime=$this->activitiesManager->inTime($activityID,$time);
        if($intime=="true"){
            $this->activitiesManager->parActivity($activityID,$userID,$time);
        }
        else{
            //提示用户活动已过期
        }
    }
    //退出活动
    public function quitActivity($activityID,$userID){
        //判断活动是否开启，开启则不能退出
        $arr_acti=$this->activitiesManager->getActivity_activityID($activityID);
        $state=$arr_acti["state"];
        if($state=="等待"){
            $this->activitiesManager->quitActivity($activityID,$userID);
        }
        else{
            //提示用户，活动开启后不能退出
        }
    }
    //查找某活动的所有参与者(返回id数组)
    public function getAllParticipants($activityID){
        $res=$this->activitiesManager-> getAllParticipants($activityID);
        return $res;
    }
    //查找某活动参与人数
    public function getParNum($activityID){
        $participants=$this->activitiesManager-> getAllParticipants($activityID);
        return count($participants);
    }
    //查找某活动发起者,返回发起人的名字
    public function getSponsor($activityID){
        $acti=$this->getActivity_activityID($activityID);
        $sponsorid=$acti["sponsor_id"];
        $userManager=new userManager();
        $sponsor=$userManager->findUser($sponsorid);
        $sponsorName=$sponsor["name"];
        return $sponsorName;
    }
}

//$test=new activitiesManager();
//$test->getActivity_partantID(40);