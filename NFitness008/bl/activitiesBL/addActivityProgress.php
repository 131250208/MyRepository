<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/12/5 0005
 * Time: 19:15
 */

header("content-type: text/html;charset=utf-8");
session_start();

require_once ("activitiesManager.php");
require_once ("../usersBL/userManager.php");
$userManager=new userManager();
$actiManager=new activitiesManager();

$body=$_SESSION['locate'];

if(empty($_POST['acti_name'])||empty($_POST['nf'])||empty($_POST['peopleNum_max'])||
    empty($_POST['addr'])||
empty($_POST['start_y'])||empty($_POST['start_mon'])||empty($_POST['start_d'])||empty($_POST['start_h'])||empty($_POST['start_m'])||
    empty($_POST['end_y'])||empty($_POST['end_mon'])||empty($_POST['end_d'])||empty($_POST['end_h'])||empty($_POST['end_m'])){

    header("Location: ../../ui/mainFrameUI/home.php?failure=1&body=".$body);
}
elseif(!is_numeric($_POST['start_y'])||!is_numeric($_POST['start_mon'])||!is_numeric($_POST['start_d'])||!is_numeric($_POST['start_h'])||!is_numeric($_POST['start_m'])
||!is_numeric($_POST['end_y'])||!is_numeric($_POST['end_mon'])||!is_numeric($_POST['end_d'])||!is_numeric($_POST['end_h'])
    ||!is_numeric($_POST['nf'])||!is_numeric($_POST['peopleNum_max'])){
    header("Location: ../../ui/mainFrameUI/home.php?failure=2&body=".$body);
}
else{
    $acti_name=$_POST['acti_name'];

    $sponserId=$_SESSION['id'];
    $nf=$_POST['nf'];
    $acti_name=$_POST['acti_name'];

    if(empty($_POST['detail'])){
        $detail="无";
    }
    elseif($_POST['detail']==""){
        $detail="无";
    }
    else{
        $detail=$_POST['detail'];
    }
    $addr=$_POST['addr'];

    $peopleNum_max=$_POST['peopleNum_max'];
    $start=$_POST['start_y']."-".$_POST['start_mon']."-".$_POST['start_d']." ".$_POST['start_h'].":".$_POST['start_m'].":00";
    $end=$_POST['end_y']."-".$_POST['end_mon']."-".$_POST['end_d']." ".$_POST['end_h'].":".$_POST['end_m'].":00";

    $actiManager->addActivity($acti_name,$sponserId,$start,$end,$addr,$detail,$peopleNum_max,$nf);
    $userManager->addNF($sponserId,-$nf);
    header("Location: ../../ui/mainFrameUI/home.php?success=2&body=".$body);
}


