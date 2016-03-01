<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/12/6 0006
 * Time: 4:00
 */

require_once ("userManager.php");
$userManager=new userManager();

if(empty($_POST['oldPasswords'])||empty($_POST['newPasswords'])||empty($_POST['check'])){
    header("Location: ../../ui/userUI/passwordsModify.php?err=1");
}
else{
    $old=$_POST['oldPasswords'];
    $new=$_POST['newPasswords'];
    $check=$_POST['check'];
    session_start();
    if($old==$_SESSION['password']){
        if($new==$check){
            $userManager->updatePasswords($_SESSION['id'],$check);
            $_SESSION['password']=$check;
            header("Location: ../../ui/userUI/passwordsModify.php?success=1");
        }
        else{
            header("Location: ../../ui/userUI/passwordsModify.php?err=2");
        }
    }
    else{
        header("Location: ../../ui/userUI/passwordsModify.php?err=3");
    }


}