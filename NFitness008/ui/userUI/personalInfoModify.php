<!DOCTYPE html>
<?php
session_start();
?>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>NFitness个人信息修改</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <!--    自定义样式-->
    <link rel="stylesheet" href="../../css/formStyle.css">
    <link rel="stylesheet" href="../../css/buttons.css">
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

<div class="panel_mine">
    <div class="panel_heading_mine">
        <h4>个人信息</h4>
    </div>
    <?php
    if(!empty($_GET['success'])){
        $success=$_GET['success'];
        $inform="???";
        if($success==1){
            $inform="更改个人信息成功！";
        }
        echo "         <div style=\"height: 20px\">
                    <p style=\"text-align: center\"><b style=\"color: yellow\">".$inform."</b></p>
                </div>";
    }
    if(!empty($_GET['err'])){
        $err=$_GET['err'];
        $inform="???";
        if($err==1){
            $inform="必要信息不能为空";
        }
        elseif($err==2){
            $inform="年龄必须填数字";
        }
        echo "         <div style=\"height: 20px\">
                    <p style=\"text-align: center\"><b style=\"color: yellow\">".$inform."</b></p>
                </div>";
    }
    ?>
    <div class="panel_content_mine">
        <form class="form-horizontal"  method="post" action="http://localhost/NFitness008/bl/usersBL/modifyPersonalDataProgress.php">
            <fieldset>
                <div class="control-group">

                    <!-- Text input-->
                    <label class="control-label" for="input01">昵称</label>
                    <div class="controls">
                        <?php
                            require_once ("../../bl/usersBL/userManager.php");
                            $userManager=new userManager();
                            $user=$userManager->findUser($_SESSION['id']);

                            echo "<input type=\"text\" placeholder=\"例如：张三\" value=".$user["name"]." class=\"input-xlarge\" name=\"name\">";
                        ?>

                        <p class="help-block">你的社区名字</p>
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label">性别</label>
                    <div class="controls" id="radio">
                        <!-- Multiple Radios -->
                        <label class="radio">
                            <input type="radio" value="男" name="gender" checked="checked">
                            男
                        </label>
                        <label class="radio">
                            <input type="radio" value="女" name="gender">
                            女
                        </label>
                    </div>

                </div>

                <div class="control-group">

                    <!-- Text input-->
                    <label class="control-label" for="input01">年龄</label>
                    <div class="controls">
                        <?php
                        echo "<input type=\"text\" placeholder=\"例如：20\" value=".$user["age"]." class=\"input-xlarge\" name=\"age\">";
                        ?>
                        <p class="help-block">你的真实年龄</p>
                    </div>
                </div>

                <div class="control-group">

                    <!-- Text input-->
                    <label class="control-label" for="input01">身份权限</label>
                    <div class="controls">
                        <?php
                        echo "<input type=\"text\" placeholder=\"placeholder\" value=".$user["identity"]." class=\"input-xlarge\"  disabled>";
                        ?>
                        <p class="help-block"><a href="apply.php" target="_blank">还是普通用户?点击申请</a></p>
                    </div>
                </div>



                <div class="control-group">

                    <!-- Textarea -->
                    <label class="control-label">个人说明（可选）</label>
                    <div class="controls">
                        <div class="textarea">
                            <?php
                            echo " <textarea type=\"\" class=\"\" content=".$user["note"]." name=\"note\"> </textarea>";
                            ?>
                        </div>
                    </div>
                </div>
                <div>
                    <p style="float: right;margin-right: 20px">
                        <button style="border: 0px;padding: 0px">
                            <a class="btn btn-success btn-lg" type="submit">
                                确认更改
                            </a>
                        </button>
                    </p>
                </div>
            </fieldset>
        </form>

    </div>
</div>
</body>
</html>