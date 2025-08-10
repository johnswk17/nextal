package com.blanink.nextal.utils;


import com.blanink.nextal.entity.ResultView;

/**
 * @Author:JohnShepherd
 * @Date: 2021/12/29 9:49
 * @Version 1.0
 */
public class ResultUtils {

    public static ResultView success(Object object){
        ResultView ResultView=new ResultView();
        ResultView.setData(object);
        ResultView.setCode(0);
        ResultView.setMsg("成功");
        return ResultView;
    }

    public static ResultView success(Integer code, Object object){
        ResultView ResultView=new ResultView();
        ResultView.setData(object);
        ResultView.setCode(code);
        ResultView.setMsg("成功");
        return ResultView;
    }

    public static ResultView success(){
        return success(null);
    }

    public static ResultView error(Integer code,String msg){
        ResultView ResultView=new ResultView();
        ResultView.setCode(code);
        ResultView.setMsg(msg);
        return ResultView;
    }

    public static ResultView error(Integer code,Object object){
        ResultView ResultView=new ResultView();
        ResultView.setData(object);
        ResultView.setCode(code);
        ResultView.setMsg("失败");
        return ResultView;
    }
}
