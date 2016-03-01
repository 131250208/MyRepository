<?php

/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/11/10 0010
 * Time: 14:03
 */
class Sql
{

    private $mysqli;
    private static $localhost="localhost";
    private static $account="root";
    private static $passwords="";
    private static $dbname="nfitness";

    public function connect(){
        $this->mysqli=new mysqli(Sql::$localhost,Sql::$account,Sql::$passwords,Sql::$dbname);
        if($this->mysqli->connect_error){
            die("连接失败".$this->mysqli->connect_error);
        }
        else{
//            echo"连接成功\n";
            $this->mysqli->query("set names utf8");
        }

    }
    public function execute_dql($sql){
        $res=$this->mysqli->query($sql) or die("语句".$sql."操作失败".$this->mysqli->error);
        return $res;
    }
    public function execute_dml($sql){
        $res=$this->mysqli->query($sql) or die("语句".$sql."操作失败".$this->mysqli->error);
        if(!$res){
            return 0;//失败
        }
        else{
            if($this->mysqli->affected_rows>0){
                return 1;//有行受到影响
            }
            else{
                return 2;//没有行受到影响
            }
        }
    }
    public function multi_query($sql){
        $res=$this->mysqli->multi_query($sql) or die("语句".$sql."操作失败".$this->mysqli->error);
        return $res;

    }
    public function close(){
        $this->mysqli->close();
    }

    public function moreResult(){
        return $this->mysqli->more_results();
    }

    public function nextResult(){
        return $this->mysqli->next_result();
    }
    public function storeResult(){
        return $this->mysqli->store_result();
    }
}