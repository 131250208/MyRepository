<?php

/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/12/5 0005
 * Time: 11:57
 */
require_once ("../../bl/healthStateBL/healthManager.php");
require_once ("../../bl/usersBL/userManager.php");
class healthStateUI
{

    public function echoAllHealthShow(){
        $healthManager=new healthManager();
        $userManager=new userManager();

        $healths=$healthManager->getAllShowList();
        if($healths!="没有结果"){
            for($i=0;$i<count($healths["id"]);$i++){
                $userId=$healths["userId"][$i];
                $date=$healths["date"][$i];
                $user=$userManager->findUser($userId);
                $userName=$user["name"];

                $target=$healthManager->getLastTarget($userId);
                $state=$healthManager->getState($userId,$date);
                $exercise=$healthManager->getExercise_last($userId,$date);
                $sleep=$healthManager->getSleep($userId,$date);

                echo " <div class=\"fitness\" style=\"margin-top: 15px;height: 400px\">
                    <div style=\"text-align: center;margin-bottom: 20px;\"><b style=\"padding-top: 0px;font-size: 30px\">".$userName.":".$date."</b></div>
                    <table class=\"table\">
                        <thead class=\"table_head\">
                        <tr class=\"info\"><th></th><th>身高（cm）</th><th>体重(kg)</th><th>跑步（km）</th><th>消耗（calorie）</th><th>睡眠（h）</th></tr>
                        </thead>
                        <tbody class=\"table_body\">
                        <tr class=\"info\"><td><b>期望目标</b></td><td>".$target["height"]."</td><td>".$target["weight"]."</td><td>".$target["exercise"]."</td><td>".$target["consumption"]."</td><td>".$target["sleep"]."</td></tr>

                        <thead class=\"table_head\">
                        <tr class=\"info\"><th></th><th>身高（cm）</th><th>体重(kg)</th><th>骨龄</th><th>心率（次/min）</th><th>血压（高，低）</th></tr>
                        </thead>
                        <tbody class=\"table_body\">
                        <tr class=\"info\"><td><b>身体状况</b></td><td>".$state["height"]."</td><td>".$state["weight"]."</td><td>".$state["age"]."</td><td>".$state["heartRate_avg"]."</td><td>".$state["bloodPressure_h_avg"].",".$state["bloodPressure_l_avg"]."</td></tr>
                    </table>
                    <table class=\"table\">
                        <thead class=\"table_head\">
                        <tr class=\"info\"><th></th><th>运动距离（km）</th><th>时长(h)</th><th>消耗（calorie）</th><th>方式</th><th></th></tr>
                        </thead>
                        <tbody class=\"table_body\">
                        <tr class=\"info\"><td><b>运动情况</b></td><td>".$exercise["distance"]."/".$target["exercise"]."</td><td>".$exercise["during"]."</td><td>".$exercise["consumption"]."/".$target["consumption"]."</td><td>".$exercise["way"]."</td><td></td></tr>

                        <thead class=\"table_head\">
                        <tr class=\"info\"><th></th><th>开始时间</th><th>结束时间</th><th>时长（h）</th><th>偏离目标（h）</th><th></th></tr>
                        </thead>
                        <tbody class=\"table_body\">
                        <tr class=\"info\"><td><b>睡眠情况</b></td><td>".$sleep["start_time"]."</td><td>".$sleep["end_time"]."</td><td>".$sleep["during"]."</td><td>".($sleep["during"]-$target["sleep"])."</td><td></td></tr>
                        </tbody>
                    </table>
                </div>";

            }
        }
    }
    public function echoHealthManager(){

        $healthManager=new healthManager();
        $date=date("Y-m-d");
        $userId=$_SESSION['id'];

        $target=$healthManager->getLastTarget($userId);
        $state=$healthManager->getState($userId,$date);
        $exercise=$healthManager->getExercise_last($userId,$date);
        $sleep=$healthManager->getSleep($userId,$date);

        $target_height="未知";
        $target_weight="未知";
        $target_exercise="未知";
        $target_consumption="未知";
        $target_sleep="未知";

        $state_height="未知";
        $state_weight="未知";
        $state_age="未知";
        $state_heartRate="未知";
        $state_bp_h="未知";
        $state_bp_l="未知";

        $exercise_dist="未知";
        $exercise_during="未知";
        $exercise_consumption="未知";
        $exercise_way="未知";

        $sleep_sta="未知";
        $sleep_end="未知";
        $sleep_during="未知";
        if($target!="没有结果"){
            $target_height=$target["height"];
            $target_weight=$target["weight"];
            $target_exercise=$target["exercise"];
            $target_consumption=$target["consumption"];
            $target_sleep=$target["sleep"];
        }
        if($state!="没有结果"){
            $state_height=$state["height"];
            $state_weight=$state["weight"];
            $state_age=$state["age"];
            $state_heartRate=$state["heartRate_avg"];
            $state_bp_h=$state["bloodPressure_h_avg"];
            $state_bp_l=$state["bloodPressure_l_avg"];
        }
        if($exercise!="没有结果"){
            $exercise_dist=$exercise["distance"];
            $exercise_during=$exercise["during"];
            $exercise_consumption=$exercise["consumption"];
            $exercise_way=$exercise["way"];
        }
        if($sleep!="没有结果"){
            $sleep_sta=$sleep["start_time"];
            $sleep_end=$sleep["end_time"];
            $sleep_during=$sleep["during"];
        }

        echo " <div class=\"fitness\">
                    <div style=\"text-align: center;margin-bottom: 20px;\"><b style=\"padding-top: 0px;font-size: 30px\">健康数据</b></div>
                    <table class=\"table\">
                        <thead class=\"table_head\">
                        <tr class=\"info\"><th></th><th>身高（cm）</th><th>体重(kg)</th><th>跑步（km）</th><th>消耗（calorie）</th><th>睡眠（h）</th></tr>
                        </thead>
                        <tbody class=\"table_body\">
                        <tr class=\"info\"><td><b>期望目标</b></td><td>".$target_height."</td><td>".$target_weight."</td><td>".$target_exercise."</td><td>".$target_consumption."</td><td>".$target_sleep."</td></tr>

                        <thead class=\"table_head\">
                        <tr class=\"info\"><th></th><th>身高（cm）</th><th>体重(kg)</th><th>骨龄</th><th>心率（次/min）</th><th>血压（高，低）</th></tr>
                        </thead>
                        <tbody class=\"table_body\">
                        <tr class=\"info\"><td><b>身体状况</b></td><td>".$state_height."</td><td>".$state_weight."</td><td>".$state_age."</td><td>".$state_heartRate."</td><td>".$state_bp_h.",".$state_bp_l."</td></tr>
                    </table>
                    <table class=\"table\">
                        <thead class=\"table_head\">
                        <tr class=\"info\"><th></th><th>运动距离（km）</th><th>时长(h)</th><th>消耗（calorie）</th><th>方式</th><th></th></tr>
                        </thead>
                        <tbody class=\"table_body\">
                        <tr class=\"info\"><td><b>运动情况</b></td><td>".$exercise_dist."/".$target_exercise."</td><td>".$exercise_during."</td><td>".$exercise_consumption."/".$target_consumption."</td><td>".$exercise_way."</td><td></td></tr>

                        <thead class=\"table_head\">
                        <tr class=\"info\"><th></th><th>开始时间</th><th>结束时间</th><th>时长（h）</th><th>偏离目标（h）</th><th></th></tr>
                        </thead>
                        <tbody class=\"table_body\">
                        <tr class=\"info\"><td><b>睡眠情况</b></td><td>".$sleep_sta."</td><td>".$sleep_end."</td><td>".$sleep_during."</td><td>".($sleep_during-$target_sleep)."</td><td></td></tr>
                        </tbody>
                    </table>
                   <p style=\"float: right;padding-bottom: 20px\">
                        <a class=\"btn btn-success\" href=\"../../bl/healthStateBL/addHealthStateShow.php?userId=".$userId."&date=".$date."\">
                            晒一晒
                        </a>
                    </p>
                </div>";
    }
}