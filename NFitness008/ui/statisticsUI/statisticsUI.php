<?php

/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/12/5 0005
 * Time: 10:16
 */
class statisticsUI
{

    public function echoStatistics(){
        echo "     <div class=\"statistic\">
                    <div class=\"statistic_head\">
                        <div class=\"statistic_input\">
                            <div class=\"control-group statistic_type\">

                                <!-- Select Basic -->
                                <label class=\"control-label\">数据</label>
                                <div class=\"controls\">
                                    <select class=\"input-xlarge\" id=\"select\">
                                    <option>睡眠时长</option>
                                    <option>心率</option>
                                    <option>血压</option>
                                    <option>跑步公里数</option>
                                    <option>消耗热量</option></select>
                                </div>

                            </div>
                            <div class=\"control-group statistic_start\">

                                <!-- Text input-->
                                <label class=\"control-label\" for=\"input01\">开始时间</label>
                                <div class=\"controls\">
                                    <input type=\"text\" placeholder=\"2015\" class=\"input-xlarge acti_public_timetxt\" id=\"start_y\">
                                    -
                                    <input type=\"text\" placeholder=\"01\" class=\"input-xlarge acti_public_timetxt\" id=\"start_m\">
                                    -
                                    <input type=\"text\" placeholder=\"01\" class=\"input-xlarge acti_public_timetxt\" id=\"start_d\">
                                </div>
                            </div>
                            <div class=\"control-group statistic_end\">

                                <!-- Text input-->
                                <label class=\"control-label\" for=\"input01\">结束时间</label>
                                <div class=\"controls\">
                                    <input type=\"text\" placeholder=\"2015\" class=\"input-xlarge acti_public_timetxt\" id=\"end_y\">
                                    -
                                    <input type=\"text\" placeholder=\"12\" class=\"input-xlarge acti_public_timetxt\" id=\"end_m\">
                                    -
                                    <input type=\"text\" placeholder=\"25\" class=\"input-xlarge acti_public_timetxt\" id=\"end_d\">
                                </div>
                            </div>
                        </div>
                        <div class=\"statistic_btn\">
                            <p style=\"float: right;\" onclick=\"printChart()\">
                                <a class=\"btn btn-success btn-lg\" href=\"#\">
                                    查询历史数据
                                </a>
                            </p>
                        </div>
                    </div>
                    <div class=\"statistic_chart\">
                        <canvas id=\"myChart\" width=\"400\" height=\"400\"></canvas>
                    </div>
                </div>";
    }
}