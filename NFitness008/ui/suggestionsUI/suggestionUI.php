<?php

/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/12/4 0004
 * Time: 13:38
 */
require_once ("../../bl/usersBL/userManager.php");
require_once ("../../bl/suggestionsBL/suggestionsManager.php");
class suggestionUI
{

    public function echoSuggestionManager($userId){
        //判断权限
        $userManager=new userManager();
        $user=$userManager->findUser($userId);
        $identity=$user["identity"];

        $suggestionManager=new suggestionsManager();

        //所有用户都要打印接收到的
        $suggestions=$suggestionManager->getAcceptedSuggestion($userId);
        if($suggestions!="没有结果"){
            for($i=0;$i<count($suggestions["id"]);$i++){
                //判断建议是否已处理
                if($suggestions["state"][$i]=="未处理"||$suggestions["state"][$i]=="已采纳"){

                    //发送者的名字和权限
                    $suggestion_id=$suggestions["id"][$i];

                    $send_id=$suggestions["sender_id"][$i];
                    $sender=$userManager->findUser($send_id);
                    $sender_name=$sender["name"];
                    $sender_iden=$sender["identity"];

                    $color_blue="#1B9AF7";//教练
                    $color_yellow="#fbcb09";//医生
                    $color_purple="darkmagenta";//医生兼教练
                    if($sender_iden=="医生"){
                        $color_send=$color_yellow;
                    }
                    elseif($sender_iden=="教练"){
                        $color_send=$color_blue;
                    }
                    elseif($sender_iden=="医生&教练"){
                        $color_send=$color_purple;
                    }
                    else{
                        $color_send="black";
                    }
                    //接收者的名字和权限
                    $accept_id=$suggestions["accepter_id"][$i];
                    $accepter=$userManager->findUser($accept_id);
                    $accepter_name=$accepter["name"];
                    $accepter_iden=$accepter["identity"];

                    if($accepter_iden=="医生"){
                        $color_accept=$color_yellow;
                    }
                    elseif($accepter_iden=="教练"){
                        $color_accept=$color_blue;
                    }
                    elseif($accepter_iden=="医生&教练"){
                        $color_accept=$color_purple;
                    }
                    else{
                        $color_accept="black";
                    }
                    //建议内容
                    $suggestion_content=$suggestions["content"][$i];

                    $stateCode="";
                    if($suggestions["state"][$i]=="未处理"){
                        $stateCode="   <div class=\"suggestion_btns\">

                        <div class=\"suggestion_btns_no\">
                            <p>
                                <a class=\"btn btn-success \" href=\"../../bl/suggestionsBL/acceptSuggestionProgress.php?id=".$suggestion_id."&accept=0\">
                                   不采纳
                                </a>
                            </p>
                        </div>
                        <div class=\"suggestion_btns_yes\">
                            <p>
                                <a class=\"btn btn-success \" href=\"../../bl/suggestionsBL/acceptSuggestionProgress.php?id=".$suggestion_id."&accept=1&send_id=".$send_id."&accepter_id=".$accept_id."\">
                                    采纳
                                </a>
                            </p>
                        </div>
                    </div>";
                    }
                    elseif($suggestions["state"][$i]=="已采纳"){


                        $stateCode="   <div class=\"suggestion_btns\">

                        <div class=\"suggestion_btns_no\">
                            <p>
                                <a class=\"btn btn-warning \">
                                   已采纳
                                </a>
                            </p>
                        </div>
                    </div>";
                    }
                    echo "  <article class=\"suggestion\">
                    <div class=\"suggestion_head\">
                        <div class=\"user suggestion_head_send\">
                            <a href=\"../userUI/personalPage.php?id=".$send_id."\" target=\"_blank\">
                                <div class=\"userRank_img\"><img  src=\"../../img/user.png\" width=\"30\"></div>
                                <div class=\"user_name\"style=\"color:".$color_send."\">".$sender_name."-></div>
                                <div class=\"user_name\" style=\"color:".$color_send."\">".$sender_iden."</div>
                            </a>
                        </div>
                        <div class=\"suggestion_to\">
                           ->建议->
                        </div>
                        <div class=\"user suggestion_head_accept\">
                            <a href=\"../userUI/personalPage.php?id=".$accept_id."\" target=\"_blank\">
                                <div class=\"user_name\"style=\"color:".$color_accept."\">".$accepter_iden."</div>
                                <div class=\"user_name\"style=\"color:".$color_accept."\">".$accepter_name."-></div>
                                <div class=\"userRank_img\"><img  src=\"../../img/user.png\" width=\"30\"></div>
                            </a>
                        </div>
                    </div>
                    <div class=\"suggestion_content\">
                        <div class=\"control-group \">
                            <div class=\"controls\">
                                <div class=\"textarea\">
                                    <textarea type=\"\" class=\"suggestion_textarea\" readonly>".$suggestion_content."</textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                 ".$stateCode."
                </article>";
                }

            }
        }

        //特权用户还要打印发出的
       if($identity=="医生"||$identity=="教练"||$identity=="医生&教练"){
            $suggestions=$suggestionManager->getSendedSuggestion($userId);
           if($suggestions!="没有结果"){
               for($i=0;$i<count($suggestions["id"]);$i++){
                   //判断建议是否已处理
                   if($suggestions["state"][$i]=="未处理"||$suggestions["state"][$i]=="已采纳"){

                       //发送者的名字和权限
                       $send_id=$suggestions["sender_id"][$i];
                       $sender=$userManager->findUser($send_id);
                       $sender_name=$sender["name"];
                       $sender_iden=$sender["identity"];

                       $color_blue="#1B9AF7";//教练
                       $color_yellow="#fbcb09";//医生
                       $color_purple="darkmagenta";//医生兼教练
                       if($sender_iden=="医生"){
                           $color_send=$color_yellow;
                       }
                       elseif($sender_iden=="教练"){
                           $color_send=$color_blue;
                       }
                       elseif($sender_iden=="医生&教练"){
                           $color_send=$color_purple;
                       }
                       else{
                           $color_send="black";
                       }
                       //接收者的名字和权限
                       $accept_id=$suggestions["accepter_id"][$i];
                       $accepter=$userManager->findUser($accept_id);
                       $accepter_name=$accepter["name"];
                       $accepter_iden=$accepter["identity"];

                       if($accepter_iden=="医生"){
                           $color_accept=$color_yellow;
                       }
                       elseif($accepter_iden=="教练"){
                           $color_accept=$color_blue;
                       }
                       elseif($accepter_iden=="医生&教练"){
                           $color_accept=$color_purple;
                       }
                       else{
                           $color_accept="black";
                       }
                       //建议内容
                       $suggestion_content=$suggestions["content"][$i];

                       echo "  <article class=\"suggestion\">
                    <div class=\"suggestion_head\">
                        <div class=\"user suggestion_head_send\">
                            <a href=\"../userUI/personalPage.php?id=".$send_id."\" target=\"_blank\">
                                <div class=\"userRank_img\"><img  src=\"../../img/user.png\" width=\"30\"></div>
                                <div class=\"user_name\"style=\"color:".$color_send."\">".$sender_name."-></div>
                                <div class=\"user_name\" style=\"color:".$color_send."\">".$sender_iden."</div>
                            </a>
                        </div>
                        <div class=\"suggestion_to\">
                           ->建议->
                        </div>
                        <div class=\"user suggestion_head_accept\">
                            <a href=\"../userUI/personalPage.php?id=".$accept_id."\" target=\"_blank\">
                                <div class=\"user_name\"style=\"color:".$color_accept."\">".$accepter_iden."</div>
                                <div class=\"user_name\"style=\"color:".$color_accept."\">".$accepter_name."-></div>
                                <div class=\"userRank_img\"><img  src=\"../../img/user.png\" width=\"30\"></div>
                            </a>
                        </div>
                    </div>
                    <div class=\"suggestion_content\">
                        <div class=\"control-group \">
                            <div class=\"controls\">
                                <div class=\"textarea\">
                                    <textarea type=\"\" class=\"suggestion_textarea\" readonly>".$suggestion_content."</textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                </article>";
                   }

               }
           }
        }
    }

    public function echoSuggestionPublish($userId){
        $userManager=new userManager();
        $user=$userManager->findUser($userId);
        $user_iden=$user["identity"];
        if($user_iden=="医生"||$user_iden=="教练"||$user_iden=="医生&教练"){
            echo " <div style=\"padding: 20px;background-color: cornsilk;\">
                    <form class=\"form-horizontal\" method=\"post\" action=\"http://localhost/NFitness008/bl/suggestionsBL/addSuggestionProgress.php\">
                        <fieldset>
                            <div id=\"legend\" class=\"\">
                                <legend class=\"\">写建议</legend>
                            </div>
                            <div class=\"control-group\">

                                <!-- Text input-->
                                <label class=\"control-label\" for=\"input01\">至</label>
                                <div class=\"controls\">
                                    <input type=\"text\" placeholder=\"例如：张三\" class=\"input-xlarge\" name=\"accepter_name\">
                                    <p class=\"help-block\">接收者的昵称</p>
                                </div>
                            </div>

                            <div class=\"control-group\">

                                <!-- Textarea -->
                                <label class=\"control-label\">建议</label>
                                <div class=\"controls\">
                                    <div class=\"textarea\">
                                        <textarea type=\"\" class=\"\" style=\"width: 100%;height: 100px\" name=\"suggestion_content\"> </textarea>
                                    </div>
                                </div>
                            </div>

                        </fieldset>

                        <div style=\"width: 100%;height:40px;margin-top: 10px\">
                            <button style='border:0px;float: right' >
                                <a class=\"btn btn-success btn-lg\"  type='submit'>
                                    确认发布
                                </a>
                            </button>
                        </div>

                    </form>
                </div>";
        }
    }
}