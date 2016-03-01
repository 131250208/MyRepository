<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/11/6 0006
 * Time: 20:11
 */
//    error_reporting(E_ALL & ~ E_NOTICE);
    header("content-type: text/html;charset=utf-8");
    //接受用户名和密码
    $account=$_POST['account'];
    $passwords=$_POST['passwords'];


    //从数据库中找到账号对应密码的加密值
    require_once ("userManager.php");

    $userManager=new userManager();
    $user=$userManager->getUserPassword("$account");
    echo $user;
    if($user!="没有结果"){
        if($user==md5($passwords)){
            //成功登录
            //保存用户信息
            $userId=$userManager->getUserID_byAccount("$account");
            Session_start();
            $_SESSION['account'] = $account;
            $_SESSION['password'] = $passwords;
            $_SESSION['id'] = $userId;

            $user=$userManager->findUser($userId);
            if($user['identity']=="管理员"){
                header("Location: ../../ui/adminUI/adminUI.php?body=1");
            }
            else{
                header("Location: ../../ui/mainFrameUI/home.php");
            }


            exit();
        }
        else{
            header("Location: ../../ui/userUI/login.php?errno=2");
            exit();
        }
    }
    else{
        header("Location: ../../ui/userUI/login.php?errno=1");
        exit();
    }

/*打印整个结果*/
//    while($row=$result->fetch_row()){
//        foreach ($row as $item) {
//            echo"--$item";
//        }
//        echo"<br/>";
//    }
//    //连接数据库
//    $link=mysqli_connect("localhost","root","");
//    if(!$link){
//        die("连接失败".mysqli_errno());
//    }
//    //设置访问数据库的编码
//    mysqli_query($link,"set names utf8")or die(mysqli_errno());
//    //选择数据库
//    mysqli_select_db($link,"nfitness")or die(mysqli_errno());
//    //sql语句
//    $sql="select passwords from account where id=$account";
//    $result=mysqli_query($link,$sql);
//    if($row=mysqli_fetch_assoc($result)){
//        if($row['passwords']==$passwords){
//            header("Location: home.php");
//            exit();
//        }
//        else{
//            header("Location: login.php?errno=2");
//            exit();
//        }
//    }
//    else{
//        header("Location: login.php?errno=1");
//        exit();
//    }
//    if($account=="wyc"&&$passwords=="123"){
//        header("Location: home.php");
//        exit();
//    }
//    else{
//        header("Location: login.php?errno=1");
//        exit();
//    }

?>