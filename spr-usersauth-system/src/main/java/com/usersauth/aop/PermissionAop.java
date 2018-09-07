package com.usersauth.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.usersauth.exception.AuthException;
import com.usersauth.exception.PermissionException;
import com.usersauth.service.PermissionDaoService;
import com.usersauth.service.impl.UsersLogServiceImpl;
import com.usersauth.utils.RedisUtils;
import com.usersauth.vo.AuthToken;
import com.usersauth.vo.SysUserVO;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Aspect
@Component
public class PermissionAop {

	@Autowired
	PermissionDaoService permissionDaoService;
	@Autowired
	RedisUtils redisUtils;
	
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	@Autowired
	UsersLogServiceImpl usersLogServiceImpl;
	
	@Around("execution(public * com.usersauth.controller..*(..)) && @annotation(p)") //指定拦截器规则
    public Object interceptor(ProceedingJoinPoint  pjp,Permission p) throws Throwable{
		StopWatch watch=new StopWatch();
		logger.info("拦截器开始");
		watch.start();
		String permission_code = p.menu()+":"+p.value();
		Object[] args = pjp.getArgs();
		if(args!=null && args.length==1) {
			AuthToken at = (AuthToken)args[0];
			logger.info("auth_token:"+at.getAuth_token());
			logger.info("permission_code:"+permission_code);
			SysUserVO sysUserVO = redisUtils.getSysUserVO(at.getAuth_token());	
			if(sysUserVO==null) {
				throw new AuthException();
			}
			redisUtils.extensionOfTime(at.getAuth_token());
			if(!permissionDaoService.checkUserVoPermission(sysUserVO,permission_code)) {
				throw new PermissionException();
			}
			//star 当用户有这个权限访问接口时，记录用户操作
			usersLogServiceImpl.userLogAdd(at.getAuth_token(), permission_code.split(":"));
			//end  当用户有这个权限访问接口时，记录用户操作
		}else {
			throw new PermissionException();
		}
		logger.info("拦截器结束");
		watch.stop();
		logger.info("耗时："+watch.getTotalTimeMillis()+"ms.");
		
		
		
		return pjp.proceed();
	}
}
