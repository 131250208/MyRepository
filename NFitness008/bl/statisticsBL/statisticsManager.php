<?php

/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/12/3 0003
 * Time: 0:05
 */
require_once("../../data/healthStatesDS/HealthManagerDS.php");
class statisticsManager
{
    public $healthManager=null;
    function __construct(){
        $this->healthManager=new HealthManagerDS();
    }
    //查询某个时间段的睡眠状况，返回二维数组
    public function getSleep_somedays($userId,$date1,$date2){
        $res=$this->healthManager->getSleep_somedays($userId,$date1,$date2);
        return $res;
    }
    //查询某个时间段身体状况数据，返回二维数组
    public function getState_somedays($userId,$date1,$date2){
        $res=$this->healthManager->getState_somedays($userId,$date1,$date2);
        return $res;
    }

    //查询某个时间段锻炼情况，返回二维数组
    public function getExercise_last_somedays($userId,$date1,$date2){
        $res=$this->healthManager->getExercise_last_somedays($userId,$date1,$date2);
        return $res;
    }
}