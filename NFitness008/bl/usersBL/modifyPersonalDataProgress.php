<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/12/6 0006
 * Time: 3:29
 */
require_once ("userManager.php");
$userManager=new userManager();
if(empty($_POST['name'])||empty($_POST['age'])){
    header("Location: ../../ui/userUI/personalInfoModify.php?err=1");
}
else{
    $note="";
    if(!empty($_POST['note'])){
        $note=$_POST['note'];
    }
    $age=$_POST['age'];
    $name=$_POST['name'];
    $gender=$_POST['gender'];

    if(!is_numeric($age)){
        header("Location: ../../ui/userUI/personalInfoModify.php?err=2");
    }
    else{
        session_start();
        $userId=$_SESSION['id'];
        $userManager->updateAge($userId,$age);
        $userManager->updateGender($userId,$gender);
        $userManager->updateName($userId,$name);
        $userManager->updateNote($userId,$note);
        header("Location: ../../ui/userUI/personalInfoModify.php?success=1");
    }
}