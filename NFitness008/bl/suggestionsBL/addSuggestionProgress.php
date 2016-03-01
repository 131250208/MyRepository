<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/12/5 0005
 * Time: 21:19
 */

header("content-type: text/html;charset=utf-8");

require_once ("suggestionsManager.php");
require_once ("../usersBL/userManager.php");
$suggestionsManager=new suggestionsManager();
$userManager=new userManager();

if(empty($_POST['accepter_name'])||empty($_POST['suggestion_content'])){
    header("Location: ../../ui/mainFrameUI/home.php?failure=1");
}
else{
    $accepter_name=$_POST['accepter_name'];
    $content=$_POST['suggestion_content'];

    if($userManager->hasUser($accepter_name)){
        $accepter_id=$userManager->getUserID_byName($accepter_name);
        session_start();
        $sender_id=$_SESSION['id'];
        if($accepter_id!=$sender_id){
            $suggestionsManager->addSuggestion($sender_id,$accepter_id,$content);
            header("Location: ../../ui/mainFrameUI/home.php?success=3");
        }
        else{
            header("Location: ../../ui/mainFrameUI/home.php?failure=4");
        }
    }
    else{
        header("Location: ../../ui/mainFrameUI/home.php?failure=3");
    }
}



