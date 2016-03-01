<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>NFitness账号安全</title>
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
        <h4>账号安全</h4>
    </div>
    <?php
    if(!empty($_GET['success'])){
        $success=$_GET['success'];
        $inform="???";
        if($success==1){
            $inform="更改密码成功！";
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
            $inform="两次密码输入不一致";
        }
        elseif($err==3){
            $inform="原始密码不正确";
        }
        echo "         <div style=\"height: 20px\">
                    <p style=\"text-align: center\"><b style=\"color: yellow\">".$inform."</b></p>
                </div>";
    }
    ?>
    <div class="panel_content_mine">
        <form class="form-horizontal"  method="post" action="http://localhost/NFitness008/bl/usersBL/modifyPasswordsProgress.php">
            <fieldset>
                <div class="control-group">

                    <!-- Text input-->
                    <label class="control-label" for="input01">旧密码</label>
                    <div class="controls">
                        <input type="password" placeholder="placeholder" class="input-xlarge" name="oldPasswords">
                        <p class="help-block">输入该账号原来的密码</p>
                    </div>
                </div>

                <div class="control-group">

                    <!-- Text input-->
                    <label class="control-label" for="input01">新密码</label>
                    <div class="controls">
                        <input type="password" placeholder="placeholder" class="input-xlarge" name="newPasswords">
                        <p class="help-block">输入要更改的新密码</p>
                    </div>
                </div>

                <div class="control-group">

                    <!-- Text input-->
                    <label class="control-label" for="input01">密码确认</label>
                    <div class="controls">
                        <input type="password" placeholder="placeholder" class="input-xlarge" name="check">
                        <p class="help-block">再次输入新密码</p>
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