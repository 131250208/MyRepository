<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/12/5 0005
 * Time: 0:29
 */

require_once ("statisticsManager.php");
$statisticsManager=new statisticsManager();

session_start();
$userId=$_SESSION['id'];

$select=$_POST['select'];

$start_y=$_POST['start_y'];
$start_m=$_POST['start_m'];
$start_d=$_POST['start_d'];

$end_y=$_POST['end_y'];
$end_m=$_POST['end_m'];
$end_d=$_POST['end_d'];

$start=$start_y."-".$start_m."-".$start_d;
$end=$end_y."-".$end_m."-".$end_d;
if($select=="睡眠时长"){
    $res=$statisticsManager->getSleep_somedays($userId,$start,$end);
}
elseif($select=="心率"||$select=="血压"){
    $res=$statisticsManager->getState_somedays($userId,$start,$end);
}
elseif($select=="跑步公里数"){
    $res=$statisticsManager->getExercise_last_somedays($userId,$start,$end);
}
elseif($select=="消耗热量"){
    $res=$statisticsManager->getExercise_last_somedays($userId,$start,$end);
}
$res=json_encode($res);
print_r($res) ;