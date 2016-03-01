<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>NFitness登录</title>
  <link rel="stylesheet" href="../../css/loginStyle.css">
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>
  <div class="logo">
    <a href="#">
      <img src="../../img/NFitness_logo.png" width="2000" alt="NFitness" title="NFitness">
    </a>
  </div>
  <form method="post" action="http://localhost/NFitness008/bl/usersBL/loginProgress.php" class="login">
    <p>
      <label for="login">账号：</label>
      <input type="text" name="account" id="login"/>
    </p>

    <p>
      <label for="password">密码：</label>
      <input type="password" name="passwords" id="password"/>
    </p>

    <p class="login-submit">
      <button type="submit" class="login-button"  >Login</button>
    </p>

    <p class="forgot-password"><a href="register.php">还没有账号？点击立即注册</a></p>

    <?php
    if(!empty($_GET['errno'])){
      $errno=$_GET['errno'];
      if($errno==1){
        echo"<a id='err' size='3' align='center' >没有该账号！</a>";
      }
      elseif($errno==2){
        echo"<a id='err' size='3' align='center' >账号密码错误！</a>";
      }
    }
    ?>
  </form>

  <!--<section class="about">-->
    <!--<p class="about-links">-->
      <!--<a href="http://www.cssflow.com/snippets/dark-login-form" target="_parent">View Article</a>-->
      <!--<a href="http://www.cssflow.com/snippets/dark-login-form.zip" target="_parent">Download</a>-->
    <!--</p>-->
    <!--<p class="about-author">-->
      <!--&copy; 2012&ndash;2013 <a href="http://thibaut.me" target="_blank">Thibaut Courouble</a> - -->
      <!--<a href="http://www.cssflow.com/mit-license" target="_blank">MIT License</a><br>-->
      <!--Original PSD by <a href="http://365psd.com/day/2-234/" target="_blank">Rich McNabb</a>-->
  <!--</section>-->
</body>
</html>
