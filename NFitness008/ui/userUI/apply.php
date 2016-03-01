<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>NFitness身份认证申请</title>
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
        <h4>认证申请</h4>
    </div>

    <div class="panel_content_mine">
        <form class="form-horizontal">
            <fieldset>
                <div class="control-group">

                    <!-- Select Basic -->
                    <label class="control-label">权限申请</label>
                    <div class="controls">
                        <select class="input-xlarge">
                            <option>健康医生</option>
                            <option>健身教练</option></select>
                    </div>

                </div>

                <div class="control-group">

                    <!-- Text input-->
                    <label class="control-label" for="input01">真实姓名</label>
                    <div class="controls">
                        <input type="text" placeholder="例如：张三" class="input-xlarge">
                        <p class="help-block">输入身份证上真实的姓名</p>
                    </div>
                </div>



                <div class="control-group">

                    <!-- Text input-->
                    <label class="control-label" for="input01">身份证号码</label>
                    <div class="controls">
                        <input type="text" placeholder="例如：450***********0036" class="input-xlarge">
                        <p class="help-block">填写身份证上正确号码</p>
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label">身份证照片</label>

                    <!-- File Upload -->
                    <div class="controls">
                        <input class="input-file" id="fileInput" type="file">
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label">有效职业证照片</label>

                    <!-- File Upload -->
                    <div class="controls">
                        <input class="input-file" id="fileInput" type="file">
                    </div>
                </div>
                <div>
                    <p style="float: right;margin-right: 20px">
                        <button style="border: 0px;padding: 0px">
                            <a class="btn btn-success btn-lg" type="submit">
                                提交申请
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