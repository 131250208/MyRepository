<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>NFitness举报</title>
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
        <h4>举报</h4>
    </div>

    <div class="panel_content_mine">
        <form class="form-horizontal">
            <fieldset>
                <div class="control-group">

                    <!-- Text input-->
                    <label class="control-label" for="input01">举报对象</label>
                    <div class="controls">
                        <input type="text" placeholder="placeholder" class="input-xlarge">
                        <p class="help-block">要举报的用户的昵称</p>
                    </div>
                </div>

                <div class="control-group">

                    <!-- Textarea -->
                    <label class="control-label">说明</label>
                    <div class="controls">
                        <div class="textarea">
                            <textarea type="" class="" style="width: 250px;height: 100px"> </textarea>
                        </div>
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label">证明截图</label>

                    <!-- File Upload -->
                    <div class="controls">
                        <input class="input-file" id="fileInput" type="file">
                    </div>
                    <p class="help-block">可选项</p>
                </div>
                <div>
                    <p style="float: right;margin-right: 20px">
                        <button style="border: 0px;padding: 0px">
                            <a class="btn btn-success btn-lg" type="submit">
                                确认提交
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