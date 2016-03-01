<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/12/6 0006
 * Time: 0:40
 */

require_once ("suggestionsManager.php");
require_once ("../usersBL/userManager.php");
$suggestionManager=new suggestionsManager();
$userManager=new userManager();

$accept=$_GET['accept'];
$sugID=$_GET['id'];

if($accept==1){
    //分发NF
    $userManager->addNF($_GET['send_id'],20);
    $userManager->addNF($_GET['accepter_id'],5);
    $suggestionManager->dealSuggestion($sugID,"已采纳");
}
else{
    $suggestionManager->dealSuggestion($sugID,"未采纳");
}

header("Location: ../../ui/mainFrameUI/home.php?body=3");
