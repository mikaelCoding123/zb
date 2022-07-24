package com.response;

public interface HttpStates {
//
//200	OK:请求
//400	Bad Request：客户端请求的语法错误，服务器无法理解
//500	Internal Server Error：内部服务器错误
    //json 中的code值
//200	结果正常
//300	参数错误
//520	后端服务请求失败
//530	服务繁忙

    int Success = 200;
    int Bad_Request = 400;
    int Server_error = 500;
    int Parameter_error = 300;
    int Request_failed = 520;
    int Busy_service = 530;
    int Server_Error_Msg=501;
}
