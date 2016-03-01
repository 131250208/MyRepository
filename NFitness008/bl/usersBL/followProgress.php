<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/12/6 0006
 * Time: 12:58
 */
require_once ("userManager.php");
$userManager=new userManager();

if(!empty($_GET['id'])&&!empty($_GET['follow'])){
    $userID=$_GET['id'];
    $follow=$_GET['follow'];
    session_start();

    if($follow==1){
        $userManager->follows($_SESSION['id'],$userID);
    }
    elseif($follow==2){
        $userManager->unfollows($_SESSION['id'],$userID);
    }

    header("Location: ../../ui/userUI/personalPage.php?id=".$userID);
}