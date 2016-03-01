<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/11/30 0030
 * Time: 21:56
 */

    header("content-type: text/html;charset=utf-8");
    //接受注册信息
    require_once ("userManager.php");
    $userManager=new userManager();

    if(empty($_POST['name'])||empty($_POST['account'])||empty($_POST['password'])||empty($_POST['passwordCheck'])||empty($_POST['gender'])||empty($_POST['age'])){
        header("Location: ../../ui/userUI/register.php?success=2");
    }
    else{
        $name=$_POST['name'];
        $account=$_POST['account'];
        $passwords=$_POST['password'];
        $passwordCheck=$_POST['passwordCheck'];
        $gender=$_POST['gender'];
        $age=$_POST['age'];

        $erro_userName=0;
        $erro_account=0;
        $erro_passwords=0;
        $erro_age=0;
        //用户名已存在
        if($hasUserName=$userManager->hasUser($name)){
            $erro_userName=1;
        }
        //账号已存在
        if($userID=$userManager->getUserID_byAccount($account)!="没有结果"){
            $erro_account=1;
        }
        //两次密码不一致
        if($passwords!=$passwordCheck){
            $erro_passwords=1;
        }
        //年龄请填写数字
        if(!is_numeric($age)){
            $erro_age=1;
        }
        //输入合法
        if($erro_userName==0&&$erro_account==0&&$erro_passwords==0&&$erro_age==0){
            $userManager->register($account,$passwordCheck,$name,$gender,$age);

            header("Location: ../../ui/userUI/register.php?success=1");
            exit();
        }
        else{
            header("Location: ../../ui/userUI/register.php?erro_userName=".$erro_userName."&erro_account=".$erro_account."&erro_passwords=".$erro_passwords."&erro_age=".$erro_age);
        }

    }




