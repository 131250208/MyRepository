<?php

/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/12/3 0003
 * Time: 11:29
 */
require_once("../../data/suggestionsDS/SuggestionManagerDS.php");
class suggestionsManager
{
    public $suggestionsManager=null;
    function __construct(){
        $this->suggestionsManager=new SuggestionManagerDS();
    }

    //发送建议
    public function addSuggestion($sender_id,$accepter_id,$content){
        $this->suggestionsManager-> addSuggestion($sender_id,$accepter_id,$content);
    }
    //删除建议
    public function delSuggestion($sugID){
        $this->suggestionsManager->delSuggestion($sugID);
    }
    //采纳建议（建议状态：已采纳/未处理）
    public function dealSuggestion($sugID,$state){
        $this->suggestionsManager-> dealSuggestion($sugID,$state);
    }
    //查看某人收到的建议
    public function getAcceptedSuggestion($userID){
        $res=$this->suggestionsManager->getAcceptedSuggestion($userID);
        return $res;
    }
    //查看某人的发出的建议
    public function getSendedSuggestion($userID){
        $res= $this->suggestionsManager->getSendedSuggestion($userID);
        return $res;
    }


}


