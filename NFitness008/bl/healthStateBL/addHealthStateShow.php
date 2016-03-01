<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/12/5 0005
 * Time: 15:03
 */

require_once ("healthManager.php");

$healthManager=new healthManager();

$userId=$_GET['userId'];
$date=$_GET['date'];

$healthManager->insertShowHealth($userId,$date);

header("Location: ../../ui/mainFrameUI/home.php?body=4&success=1");