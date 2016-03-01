<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>NFitness个人主页</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <!--    自定义样式-->
    <link rel="stylesheet" href="../../css/formStyle.css">
    <link rel="stylesheet" href="../../css/buttons.css">
    <link rel="stylesheet" href="../../css/homeStyle.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body background="../../img/run.jpg">
<div class="heading_mine">
    <div class="logo">
        <a href="#">
            <img src="../../img/NFitness_logo.png" width="350" alt="NFitness" title="NFitness">
        </a>
    </div>
</div>

<div class="personal_page">
    <?php
        require_once ("../../bl/usersBL/userManager.php");
        $userManager=new userManager();

        if(!empty($_GET['id'])){
            $userID=$_GET['id'];
            $user=$userManager->findUser($userID);

            $name=$user["name"];
            $iden=$user["identity"];
            $gender=$user["gender"];
            $age=$user["age"];
            $nf=$user["nf"];
            $note=$user["note"];
            $followed=$userManager->findTheFollowed($userID);
            $followeds=$userManager->findFollowers($userID);

            //名字颜色
            $color_blue="#1B9AF7";//教练
            $color_yellow="#fbcb09";//医生
            $color_purple="darkmagenta";//医生兼教练
            if($iden=="医生"){
                $color=$color_yellow;
            }
            elseif($iden=="教练"){
                $color=$color_blue;
            }
            elseif($iden=="医生&教练"){
                $color=$color_purple;
            }
            else{
                $color="black";
            }

            session_start();
            $btns="";
            if($userID!=$_SESSION['id']){
                $follow="
                <a class=\"btn btn-success\"  href='../../bl/usersBL/followProgress.php?id=".$userID."&follow=1'>
                    关注
                </a>";
                if($userManager->isFollowed($_SESSION['id'],$userID)=="已关注"&&$userManager->isFollowed($userID,$_SESSION['id'])!="已关注"){
                    $follow="
                <a class=\"btn btn-warning\"  href='../../bl/usersBL/followProgress.php?id=".$userID."&follow=2'>
                    取消关注
                </a>";
                }
                elseif($userManager->isFollowed($_SESSION['id'],$userID)=="已关注"&&$userManager->isFollowed($userID,$_SESSION['id'])=="已关注"){
                    $follow="
                <a class=\"btn btn-warning\" href='../../bl/usersBL/followProgress.php?id=".$userID."&follow=2'>
                    互相关注
                </a>";
                }
                $btns="        <div class=\"personal_page_btns\">
            <p style=\"margin-left: 250px\">
                ".$follow."
            </p>
            <p>
                <a class=\"btn btn-danger\" href=\"whistle_blowing.php\" target=\"_blank\">
                    举报
                </a>
            </p>
        </div>";
            }
            echo "  <div style=\"padding: 20px; background-color: #f9ffb7;\">
        <div class=\"personal_page_head\">
            <div class=\"personal_page_img\" ><img  src=\"../../img/user.png\" width=\"200\"></div>
            <div class=\"personal_page_info\">
                <div >
                    <b style=\"font-size: 30px;color:".$color.";font-family: 'Adobe 黑体 Std R'\">
                        ".$name."
                    </b>-> ".$iden."
                </div>
                <div class=\"personal_page_info_data\"> ".$gender." ".$age."岁</div>
                <div class=\"personal_page_info_data\">
                    <div>关注：".$followed."</div>
                    <div>粉丝：".$followeds."</div>
                    <div>NF：".$nf."</div>
                </div>
                <div class=\" personal_page_info_data\" style=\"clear: left\">
                    个人说明：".$note."
                </div>
            </div>
        </div>
        ".$btns."
    </div>";
        }

    ?>
    <div class="panel_heading_mine">
        <h4>个人主页</h4>
    </div>
    <div>
        <?php
            require_once("../activitiesUI/activityUI.php");
            require_once("../../bl/activitiesBL/activitiesManager.php");
            $activityManager=new activitiesManager();
            $activityUI=new activityUI();
            //所有发起的活动
            $userID="";
            if(!empty($_GET['id'])) {
                $userID = $_GET['id'];
            }
            $actis=$activityManager->getActivity_sppnserID($userID);
            if($actis!="没有结果"){
                $activityUI->echoAllActi($actis);
            }
        ?>
    </div>
</div>
</body>
</html>