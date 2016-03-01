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
    <link rel="stylesheet" href="../../css/formStyle.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body background="../../img/run.jpg">
<div class="heading_mine">
    <div class="logo" style="float: left">
        <a href="#">
            <img src="../../img/NFitness_logo.png" width="350" alt="NFitness" title="NFitness">
        </a>
    </div>
    <div class="admin_head_exit">
        <a href="../userUI/login.php">
            退出
        </a>
    </div>
    <div class="admin_head_name" >
        管理员
    </div>

</div>

<div class="panel_mine">
    <nav class="navbar navbar-inverse" role="navigation">
        <div class="container">
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li><a href="adminUI.php?body=1">权限更改</a></li>
                    <li><a href="adminUI.php?body=2">认证审核</a></li>
                    <li><a href="adminUI.php?body=3">查看举报</a></li>
                </ul>
            </div>
        </div>

    </nav>
    <?php
    if(!empty($_GET['success'])){
        $success=$_GET['success'];
        $inform="???";
        if($success==1){
            $inform="更改权限成功！";
        }
        elseif($success==2){
            $inform="请填写完整信息";
        }
        echo "         <div style=\"height: 20px\">
                    <p style=\"text-align: center\"><b style=\"color: yellow\">".$inform."</b></p>
                </div>";
    }
    ?>
    <div class="panel_content_mine" id="panel_admin">
        <?php
        switch($_SESSION['locate']){
            case 1:
                echo "  <form class=\"form-horizontal\" method=\"post\" action=\"http://localhost/NFitness008/bl/usersBL/modifyIdenProgress.php\">
            <fieldset>
                <div id=\"legend\" class=\"\">
                    <legend class=\"\"><h2>权限更改</h2></legend>
                </div>
                <div class=\"control-group\">

                    <!-- Text input-->
                    <label class=\"control-label\" for=\"input01\">用户昵称</label>
                    <div class=\"controls\">
                        <input type=\"text\" class=\"input-xlarge\" name='name'>
                        <p class=\"help-block\">要更改权限的用户名称</p>
                    </div>
                </div>

                <div class=\"control-group\">

                    <!-- Select Basic -->
                    <label class=\"control-label\">权限</label>
                    <div class=\"controls\">
                        <select class=\"input-xlarge\" name='iden'>
                            <option>教练</option>
                            <option>医生</option>
                            <option>医生&教练</option>
                        </select>
                    </div>

                </div>
                <div>
                    <p style=\"float: right;margin-right: 20px\">
                        <button style=\"border: 0px;padding: 0px\">
                            <a class=\"btn btn-success btn-lg\" type=\"submit\">
                                提交申请
                            </a>
                        </button>
                    </p>
                </div>
            </fieldset>

        </form>";
                break;
            case 2:echo "
             <form class=\"form-horizontal\">
            <fieldset>
                <div class=\"control-group\">

                    <!-- Select Basic -->
                    <label class=\"control-label\">申请人</label>
                    <div class=\"controls\">
                         <input type=\"text\" class=\"input-xlarge\" disabled>
                    </div>

                </div>
                <div class=\"control-group\">

                    <!-- Select Basic -->
                    <label class=\"control-label\">申请权限</label>
                    <div class=\"controls\">
                         <input type=\"text\" class=\"input-xlarge\" disabled>
                    </div>

                </div>

                <div class=\"control-group\">

                    <!-- Text input-->
                    <label class=\"control-label\" for=\"input01\">真实姓名</label>
                    <div class=\"controls\">
                        <input type=\"text\"  class=\"input-xlarge\" disabled>
                    </div>
                </div>



                <div class=\"control-group\">

                    <!-- Text input-->
                    <label class=\"control-label\" for=\"input01\">身份证号码</label>
                    <div class=\"controls\">
                        <input type=\"text\"  class=\"input-xlarge\" disabled>
                    </div>
                </div>

                 <div class=\"control-group\">

                    <!-- Text input-->
                    <label class=\"control-label\" for=\"input01\">职业证件类型</label>
                    <div class=\"controls\">
                        <input type=\"text\"  class=\"input-xlarge\" disabled>
                    </div>
                </div>

                <div class=\"control-group\">

                    <!-- Text input-->
                    <label class=\"control-label\" for=\"input01\">有效职业证件号码</label>
                    <div class=\"controls\">
                        <input type=\"text\"  class=\"input-xlarge\" disabled>
                    </div>
                </div>
                <div>
                    <p style=\"float: right;margin-right: 20px\">
                        <button style=\"border: 0px;padding: 0px\">
                            <a class=\"btn btn-success \" type=\"submit\">
                                通过
                            </a>
                        </button>
                    </p>
                </div>
            </fieldset>
        </form>";
                break;
            case 3:
                echo " <form class=\"form-horizontal\">
            <fieldset>
                 <div class=\"control-group\">

                    <!-- Text input-->
                    <label class=\"control-label\" for=\"input01\">举报人</label>
                    <div class=\"controls\">
                        <input type=\"text\" class=\"input-xlarge\" disabled>
                    </div>
                </div>
                <div class=\"control-group\">

                    <!-- Text input-->
                    <label class=\"control-label\" for=\"input01\">被举报对象</label>
                    <div class=\"controls\">
                        <input type=\"text\" class=\"input-xlarge\" disabled>
                    </div>
                </div>

                <div class=\"control-group\">

                    <!-- Textarea -->
                    <label class=\"control-label\">说明</label>
                    <div class=\"controls\">
                        <div class=\"textarea\">
                            <textarea type=\"\" class=\"\" style=\"width: 250px;height: 100px\" disabled> </textarea>
                        </div>
                    </div>
                </div>

            </fieldset>
        </form>";
                break;
        }
        ?>

    </div>
</div>
</body>
</html>