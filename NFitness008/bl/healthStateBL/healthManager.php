<?php

/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/12/2 0002
 * Time: 12:11
 */
require_once("../../data/healthStatesDS/HealthManagerDS.php");
class healthManager
{
    public $healthManager=null;
    function __construct(){
        $this->healthManager=new HealthManagerDS();
    }

    //创建晒单数据表
    public function create_showHealth(){
        $this->healthManager->create_showHealth();
    }
    //插入晒单信息，某个用户某天的健康状况
    public function insertShowHealth($userId,$date){
        $this->healthManager->insertShowHealth($userId,$date);
    }
    //获取晒单信息
    public function getAllShowList(){
        $res=$this->healthManager->getAllShowList();
        return $res;
    }

    //实时添加锻炼数据
    public function insertExercise($userID,$time,$distance,$during,$consumption,$way){
        $this->healthManager->insertExercise($userID,$time,$distance,$during,$consumption,$way);
    }
    //添加睡眠情况数据
    public function insertSleep($userID,$date,$start_time,$end_time,$during,$deviation){
        $this->healthManager->insertSleep($userID,$date,$start_time,$end_time,$during,$deviation);
    }
    //添加身体状况数据
    public function insertState($userID,$time,$height,$weight,$age,$heartRate,$bloodPressure_h,$bloodPressure_l){
        $this->healthManager->insertState($userID,$time,$height,$weight,$age,$heartRate,$bloodPressure_h,$bloodPressure_l);
    }
    //添加新目标
    public function insertTarget($userID,$time,$height,$weight,$exercise,$consumption,$sleep){
        $this->healthManager->insertTarget($userID,$time,$height,$weight,$exercise,$consumption,$sleep);
    }

    //查询最新的目标,返回数组
    public function getLastTarget($userId){
        $res=$this->healthManager->getLastTarget($userId);
        return $res;
    }

    //查询某日睡眠状况,返回数组
    public function getSleep($userId,$date){
        $res=$this->healthManager->getSleep($userId,$date);
        return $res;
    }
    //查询某日身体状况数据的平均值,返回数组
    public function getState($userId,$date){
        $res=$this->healthManager->getState($userId,$date);
        return $res;
    }
    //查询某日最后的锻炼状况,返回数组
    public function getExercise_last($userId,$date){
        $res=$this->healthManager->getExercise_last($userId,$date);
        return $res;
    }

}