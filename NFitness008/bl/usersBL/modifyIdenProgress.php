<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/12/6 0006
 * Time: 13:43
 */

require_once ("userManager.php");
$userManager=new userManager();

if(!empty($_POST['name'])&&!empty($_POST['iden'])){
    $userName=$_POST['name'];
    $iden=$_POST['iden'];
    $userID=$userManager->getUserID_byName($userName);
    $userManager->modifyIdentity($userID,$iden);

    header("Location: ../../ui/adminUI/adminUI.php?success=1");
}
else{
    header("Location: ../../ui/adminUI/adminUI.php?success=2");
}