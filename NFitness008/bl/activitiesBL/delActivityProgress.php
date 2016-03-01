<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/12/5 0005
 * Time: 23:39
 */


header("content-type: text/html;charset=utf-8");
$actiId=$_GET["id"];

require_once ("activitiesManager.php");
$actiManager=new activitiesManager();

session_start();
$actiManager->delActivity($actiId);



$body=$_SESSION['locate'];
header("Location: ../../ui/mainFrameUI/home.php?body=".$body);