<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/12/3 0003
 * Time: 17:10
 */

header("content-type: text/html;charset=utf-8");
$actiId=$_GET["id"];

require_once ("activitiesManager.php");
require_once ("../usersBL/userManager.php");

$actiManager=new activitiesManager();
$userManager=new userManager();

session_start();

$actiManager->parActivity($actiId,$_SESSION['id']);

$parNum=$actiManager->getParNum($actiId); //已参加人数
$acti=$actiManager->getActivity_activityID($actiId);
$parNum_max=$acti["numOfPar"];//限制人数

if($parNum>=$parNum_max){
    //分发NF
    $nf=$acti["nf"];
    $partantsID=$actiManager->getAllParticipants($actiId);
    $nf_avg=$nf/count($partantsID);
    for($i=0;$i<count($partantsID);$i++){
        $userManager->addNF($partantsID[$i],$nf_avg);
    }
    $userManager->addNF($acti["sponsor_id"],$nf*1.2);
}

$body=$_SESSION['locate'];
header("Location: ../../ui/mainFrameUI/home.php?body=".$body);