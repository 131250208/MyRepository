<!DOCTYPE html>
<?php
session_start();
if(is_array($_GET)&&count($_GET)>0){//判断是否通过get传值
    if(!empty($_GET['body'])){//判断body里是否有传值
        $_SESSION['locate']=$_GET['body'];//存在一个值
    }
}
else{
    $_SESSION['locate']=1;//没有传值
}
?>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>NFitness</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
<!--    自定义样式-->
    <link rel="stylesheet" href="../../css/homeStyle.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.js"></script>
    <!--    jquery-->
    <script src="//cdn.bootcss.com/jquery/3.0.0-alpha1/jquery.min.js"></script>
<!--    stickUp-->
    <script src="../../js/stickUp.min.js"></script>
    <script src="../../js/Chart.js"></script>
    <script src="../../js/jquery.grumble.js"></script>

</head>
<body background="../../img/run.jpg">
    <div id="container">
        <div id="heading" >
            <div class="logo">
                <a href="#">
                    <img src="../../img/NFitness_logo.png" width="350" alt="NFitness" title="NFitness">
                </a>
            </div>
            <div class="btn-group">
                <button class="btn">选项</button>
                <button data-toggle="dropdown" class="btn dropdown-toggle"><span class="caret"></span></button>
                <ul class="dropdown-menu">
                    <li>
                        <?php
                        echo " <a href=\"../userUI/personalPage.php?id=".$_SESSION['id']."\" target=\"_blank\">个人主页</a>";
                        ?>

                    </li>
                    <li>
                        <a href="../userUI/personalInfoModify.php" target="_blank">个人信息</a>
                    </li>
                    <li>
                        <a href="../userUI/passwordsModify.php" target="_blank">账号安全</a>
                    </li>
                    <li>
                        <a href="../userUI/apply.php" target="_blank">认证申请</a>
                    </li>
                    <li>
                        <a href="../userUI/whistle_blowing.php">举报</a>
                    </li>
                    <li>
                        <a href="../userUI/login.php">退出</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="content_small">
            <div class="content_user ">
                <?php
                require_once ("../../bl/usersBL/userManager.php");
                $userManager=new userManager();
                $userId=$_SESSION['id'];
                $user=$userManager->findUser($userId);
                $color_blue="#1B9AF7";//教练
                $color_yellow="#fbcb09";//医生
                $color_purple="darkmagenta";//医生兼教练

                $iden=$user["identity"];
                $name=$user["name"];
                $nf=$user["nf"];
                $followed=$userManager->findTheFollowed($userId);//关注数
                $followers=$userManager->findFollowers($userId);//粉丝数

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

                echo "   <div class=\"user_head\">
                    <div class=\"user_head_name\"><a href='../userUI/personalPage.php?id=".$_SESSION['id']."' target=\"_blank\"><h3 style=\"color:".$color."\">".$name."</h3></a></div>
                    <div class=\"user_head_iden\" style=\"color:".$color."\">".$iden."</div>
                </div>
                <div class=\"user_data\">
                    <div ><h4>关注</h4><br>
                        <p>".$followed."</p>
                    </div>
                    <div><h4>粉丝</h4><br>
                        <p>".$followers."</p>
                    </div>
                    <div><h4>NF</h4><br>
                        <p>".$nf."</p>
                    </div>
                </div>";
                ?>

            </div>
            <div class="content_rank  ">
                <div>
                    <h1 class="text-center">NF达人榜</h1>
                </div>
                <div>
                    <?php

                    $friends=$userManager->findFriends($userId);
                    if($friends!="没有结果"){
                        for($i=0;$i<count($friends["id"]);$i++){

                            $friendsId=$friends["id"][$i];
                            $friend=$userManager->findUser($friendsId);
                            $friend_iden=$friend["identity"];
                            if($friend_iden=="医生"){
                                $color=$color_yellow;
                            }
                            elseif($friend_iden=="教练"){
                                $color=$color_blue;
                            }
                            elseif($friend_iden=="医生&教练"){
                                $color=$color_purple;
                            }
                            else{
                                $color="black";
                            }
                            $friend_name=$friends["name"][$i];
                            $friend_nf=$friends["nf"][$i];

                            echo " <div class=\"userRank\">
                        <a href=\"../userUI/personalPage.php?id=".$friendsId."\" target=\"_blank\">
                            <div class=\"userRank_img\"><img  src=\"../../img/user.png\" width=\"30\"></div>
                            <div class=\"userRank_name\" style=\"color: ".$color."\">".$friend_name."</div>
                            <div class=\"userRank_nf\">".$friend_nf."</div>
                        </a>
                    </div>";
                        }
                    }

                    ?>
                </div>
                </di>
            </div>
        </div>
        <div id="content_big">
            <nav class="navbar navbar-inverse " role="navigation">
                <div class="container">
                    <div id="navbar" class="collapse navbar-collapse">
                        <ul class="nav navbar-nav">
                            <li><a href="home.php?body=1">广场</a></li>
                            <li><a href="home.php?body=2">活动管理</a></li>
                            <li><a href="home.php?body=3">建议管理</a></li>
                            <li><a href="home.php?body=4">健康管理</a></li>
                            <li><a href="home.php?body=5">统计分析</a></li>
                        </ul>
                    </div>
                </div>
            </nav>

            <div class="content_body">



                <?php
                    if(!empty($_GET['success'])){
                        $success=$_GET['success'];
                        $inform="";
                        if($success==1){
                            $inform="健康信息成功发布到广场了！";
                        }
                        elseif($success==2){
                            $inform="新活动成功发布到广场了！";
                        }
                        elseif($success==3){
                            $inform="建议成功发送了！";
                        }
                        echo "         <div style=\"height: 20px\">
                    <p style=\"text-align: center\"><b style=\"color: yellow\">".$inform."</b></p>
                </div>";
                    }
                    if(!empty($_GET['failure'])){
                        $failure=$_GET['failure'];
                        $inform="";
                        if($failure==1){
                            $inform="必要数据不能为空";
                        }
                        elseif($failure==2){
                            $inform="请正确填写数据内容";
                        }
                        elseif($failure==3){
                            $inform="该用户不存在";
                        }
                        elseif($failure==4){
                            $inform="不能发送建议给自己";
                        }
                        echo "         <div style=\"height: 20px\">
                    <p style=\"text-align: center\"><b style=\"color: yellow\">".$inform."</b></p>
                </div>";
                    }
                    require_once("../activitiesUI/activityUI.php");
                    require_once("../suggestionsUI/suggestionUI.php");
                    require_once("../statisticsUI/statisticsUI.php");
                    require_once("../healthstateUI/healthStateUI.php");
                    $suggestionUI=new suggestionUI();
                    $activityUI=new activityUI();
                    $statisticsUI=new statisticsUI();
                    $healthUI=new healthStateUI();
                    require_once("../../bl/activitiesBL/activitiesManager.php");
                    $activityManager=new activitiesManager();
                    switch($_SESSION['locate']){
                        case 1:

                            if(!empty($_POST['suquare_choose'])){
                                $choose=$_POST['suquare_choose'];
                                if($choose=="活动广场"){
                                    $activityUI->echoSquUpdate("活动");
                                    $activityUI->echoAllActi($activityManager->getAllActivity());
                                }
                                else{
                                    $activityUI->echoSquUpdate("健康");
                                    $healthUI->echoAllHealthShow();
                                }
                            }
                            else{
                                $activityUI->echoSquUpdate("活动");
                                $activityUI->echoAllActi($activityManager->getAllActivity());
                            }
                            break;
                        case 2:
                            $activityUI->echoActiPublish();
                            //所有发起的活动
                            $actis=$activityManager->getActivity_sppnserID($_SESSION['id']);
                            if($actis!="没有结果"){
                                $activityUI->echoAllActi($actis);
                            }

                            //所有参与的活动
                            $actis=$activityManager->getActivity_partantID($_SESSION['id']);
                            if($actis!="没有结果"){
                                $activityUI->echoAllActi($actis);
                            }

                            break;
                        case 3:
                            $suggestionUI->echoSuggestionPublish($_SESSION['id']);
                            $suggestionUI->echoSuggestionManager($_SESSION['id']);
                            break;
                        case 4:
                            $healthUI->echoHealthManager();
                            break;
                        case 5:
                            $statisticsUI->echoStatistics();
                            break;
                    }
                ?>
            </div>
        </div>

    </div>

    <script>

    function printChart() {
        var select = document.getElementById("select").value;

        var start_y = document.getElementById("start_y").value;
        var start_m = document.getElementById("start_m").value;
        var start_d = document.getElementById("start_d").value;

        var end_y = document.getElementById("end_y").value;
        var end_m = document.getElementById("end_m").value;
        var end_d = document.getElementById("end_d").value;

        //与php交互
        $(function () {
            $.ajax({
                url: "../../bl/statisticsBL/reStatistic.php",
                type: "POST",
                data: {
                    "select": select, "start_y": start_y, "start_m": start_m, "start_d": start_d
                    , "end_y": end_y, "end_m": end_m, "end_d": end_d
                },
                dataType: 'text',
                error: function () {
                    alert('Error loading XML document');
                },
                success: function (data, status) {//如果调用php成功
                    var arr=JSON.parse(data);
                    var dataSet=null;
                    if (select=="睡眠时长"){
                        dataSet=[
                            {
                                fillColor : "rgba(151,187,205,0.5)",
                                strokeColor : "rgba(151,187,205,1)",
                                pointColor : "rgba(151,187,205,1)",
                                pointStrokeColor : "#fff",
                                data :arr["during"]
                            }
                        ];
                    }
                    else if(select=="心率")
                    {
                        dataSet=[
                            {
                                fillColor : "rgba(151,187,205,0.5)",
                                strokeColor : "rgba(151,187,205,1)",
                                pointColor : "rgba(151,187,205,1)",
                                pointStrokeColor : "#fff",
                                data :arr["heartRate_avg"]
                            }
                        ];
                    }
                    else if(select=="血压"){
                        dataSet=[
                            {
                                fillColor : "rgba(151,187,205,0.5)",
                                strokeColor : "rgba(151,187,205,1)",
                                pointColor : "rgba(151,187,205,1)",
                                pointStrokeColor : "#fff",
                                data :arr["bloodPressure_h_avg"]
                            },
                            {
                                fillColor : "rgba(220,220,220,0.5)",
                                strokeColor : "rgba(220,220,220,1)",
                                pointColor : "rgba(220,220,220,1)",
                                pointStrokeColor : "#fff",
                                data :arr["bloodPressure_l_avg"]
                            }

                        ];
                    }
                    else if(select=="跑步公里数"){
                        dataSet=[
                            {
                                fillColor : "rgba(151,187,205,0.5)",
                                strokeColor : "rgba(151,187,205,1)",
                                pointColor : "rgba(151,187,205,1)",
                                pointStrokeColor : "#fff",
                                data :arr["distance"]
                            }
                        ];
                    }
                    else if(select=="消耗热量"){
                        dataSet=[
                            {
                                fillColor : "rgba(151,187,205,0.5)",
                                strokeColor : "rgba(151,187,205,1)",
                                pointColor : "rgba(151,187,205,1)",
                                pointStrokeColor : "#fff",
                                data :arr["consumption"]
                            }
                        ];
                    }

                    //处理数据
                    var chartData = {
                        labels :arr["date"],
                        datasets : dataSet
                    }

                    var ctx = document.getElementById("myChart").getContext("2d");
                    var myNewChart = new Chart(ctx);

                    window.myLine =myNewChart.Line(chartData, {
                        responsive: true
                    });

                }
            });
        });
    }
    </script>

<!--    <!--让排行榜随页面移动-->-->
<!--    <script>-->
<!--        //initiating jQuery-->
<!--        jQuery(function($) {-->
<!--            $(document).ready( function() {-->
<!--                //enabling stickUp on the '.navbar-wrapper' class-->
<!--                $('.content_small').stickUp();-->
<!--            });-->
<!--        });-->
<!---->
<!--    </script>-->


</body>
</html>