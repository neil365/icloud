package com.usersauth.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alibaba.fastjson.JSONException;
import com.spr.contents.msg.Contents;
import com.spr.contents.msg.Results;
import com.usersauth.exception.AuthException;
import com.usersauth.exception.ParameterException;
import com.usersauth.exception.PermissionDoubleException;
import com.usersauth.exception.PermissionException;
import com.usersauth.exception.RoleException;
import com.usersauth.exception.UsersException;
import com.usersauth.vo.SysUserVO;


@RestControllerAdvice
public class ExceptionController {

	// 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public Results<SysUserVO> globalException(HttpServletRequest request, Throwable ex) {
    	ex.printStackTrace();
        return new Results<SysUserVO>(Contents.ERROR_99,null);
    }
    
    // 捕捉没有权限异常
    @ExceptionHandler(PermissionException.class)
    @ResponseStatus(HttpStatus.OK)
    public Results<SysUserVO> permissionException(HttpServletRequest request, Throwable ex) {
    	ex.printStackTrace();
        return new Results<SysUserVO>(Contents.ERROR_06,null);
    }
    
    // 捕捉没有权限异常
    @ExceptionHandler(AuthException.class)
    @ResponseStatus(HttpStatus.OK)
    public Results<SysUserVO> authException(HttpServletRequest request, Throwable ex) {
    	ex.printStackTrace();
        return new Results<SysUserVO>(Contents.ERROR_04,null);
    }
    
    // 捕捉参数错误异常
    @ExceptionHandler(ParameterException.class)
    @ResponseStatus(HttpStatus.OK)
    public Results<SysUserVO> parameterException(HttpServletRequest request, Throwable ex) {
    	ex.printStackTrace();
        return new Results<SysUserVO>(Contents.ERROR_08,null);
    }
    
    // 捕捉参数错误异常
    @ExceptionHandler(JSONException.class)
    @ResponseStatus(HttpStatus.OK)
    public Results<SysUserVO> jsonException(HttpServletRequest request, Throwable ex) {
    	ex.printStackTrace();
        return new Results<SysUserVO>(Contents.ERROR_08,null);
    }
    
    // 捕捉用户信息错误异常
    @ExceptionHandler(UsersException.class)
    @ResponseStatus(HttpStatus.OK)
    public Results<SysUserVO> usersException(HttpServletRequest request, Throwable ex) {
    	ex.printStackTrace();
        return new Results<SysUserVO>(Contents.ERROR_09,null);
    }
    
    // 捕捉角色信息错误异常
    @ExceptionHandler(RoleException.class)
    @ResponseStatus(HttpStatus.OK)
    public Results<SysUserVO> roleException(HttpServletRequest request, Throwable ex) {
    	ex.printStackTrace();
        return new Results<SysUserVO>(Contents.ERROR_10,null);
    }

    // 捕捉权限信息重复错误异常
    @ExceptionHandler(PermissionDoubleException.class)
    @ResponseStatus(HttpStatus.OK)
    public Results<SysUserVO> permissionDoubleException(HttpServletRequest request, Throwable ex) {
    	ex.printStackTrace();
        return new Results<SysUserVO>(Contents.ERROR_11,null);
    }
}
