<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>NFitness用户注册</title>
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
            <h4>用户注册</h4>
        </div>
        <?php
            if(!empty($_GET['success'])){
                $success=$_GET['success'];
                $inform="???";
                if($success==1){
                    $inform="注册成功！";
                }
                elseif($success==2){
                    $inform="请填写完整信息";
                }
                echo "         <div style=\"height: 20px\">
                    <p style=\"text-align: center\"><b style=\"color: yellow\">".$inform."</b></p>
                </div>";
            }
        ?>
        <div class="panel_content_mine">

            <form class="form-horizontal" method="post" action="http://localhost/NFitness008/bl/usersBL/registerProgress.php">
                <fieldset>
                    <div class="control-group">
                        <!-- Text input-->
                        <label class="control-label" for="input01">昵称</label>
                        <div class="controls">
                            <input type="text" name="name" placeholder="例如：张三" class="input-xlarge">
                            <p class="help-block">
                                输入少于16位字符（8位汉字）
                                <?php
                                if(!empty($_GET['$erro_userName'])){
                                    if($_GET['$erro_userName']==1){
                                        echo "<b style=\"color: red\">  该昵称已存在</b>";
                                    }
                                }
                                ?>

                            </p>
                        </div>
                    </div>
                    <div class="control-group">

                        <!-- Text input-->
                        <label class="control-label" for="input01">用户名</label>
                        <div class="controls">
                            <input type="text" name="account"  class="input-xlarge">
                            <p class="help-block">输入少于13位由英文、数字组合的字符
                                <?php
                                if(!empty($_GET['erro_account'])){
                                    if($_GET['erro_account']==1){
                                        echo "<b style=\"color: red\">  该账号已存在</b>";
                                    }
                                }
                                ?>
                            </p>
                        </div>
                    </div>

                    <div class="control-group">

                        <!-- Text input-->
                        <label class="control-label" for="input01">密码</label>
                        <div class="controls">
                            <input type="password" name="password"  class="input-xlarge">
                            <p class="help-block">输入少于13位由英文、数字和符号组合的字符

                            </p>
                        </div>
                    </div>

                    <div class="control-group">

                        <!-- Text input-->
                        <label class="control-label" for="input01">密码确认</label>
                        <div class="controls">
                            <input type="password" name="passwordCheck"  class="input-xlarge">
                            <p class="help-block">输入与上方一致的密码
                                <?php
                                if(!empty($_GET['erro_passwords'])){
                                    if($_GET['erro_passwords']==1){
                                        echo "<b style=\"color: red\">  两次输入密码不一致</b>";
                                    }
                                }
                                ?>
                            </p>
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
                            <input type="text" name="age"  placeholder="例如：20" class="input-xlarge">
                            <p class="help-block">输入不多于三位的阿拉伯数字
                                <?php
                                if(!empty($_GET['erro_age'])){
                                    if($_GET['erro_age']==1){
                                        echo "<b style=\"color: red\">  请输入数字</b>";
                                    }
                                }
                                ?>
                            </p>
                        </div>
                    </div>
                    <div>
                        <p style="float: right;margin-right: 20px">
                            <button style="border: 0px;padding: 0px">
                                <a class="btn btn-success btn-lg" type="submit">
                                    点击注册
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