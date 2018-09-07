package com.usersauth.service.impl;

import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spr.contents.msg.ListVO;
import com.spr.contents.msg.Page;
import com.spr.contents.msg.Results;
import com.usersauth.entity.SysUserLog;
import com.usersauth.entity.SysUserLogExample;
import com.usersauth.mapper.SysUserLogMapper;
import com.usersauth.utils.RedisUtils;
import com.usersauth.vo.SysUserLogVO;
import com.usersauth.vo.SysUserVO;

/**
 * @类描述： 用户日志管理
 * @项目名称：spr-usersauth-system
 * @包名： com.usersauth.service.impl
 * @类名称：UsersLogServiceImpl
 * @创建人：刘晔
 * @创建时间：2018年5月17日上午11:03:11
 * @修改人：刘晔
 * @修改时间：2018年5月17日上午11:03:11
 * @修改备注：
 */
@Service
public class UsersLogServiceImpl {
	
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	
	@Autowired
	SysUserLogMapper sysUserLogMapper;
	@Autowired
	RedisUtils redisUtils;
	
	/**
	 * @描述: 记录用户操作信息
	 * @方法名: userLogAdd
	 * @param auth_token
	 * @param permission_code
	 * @返回类型 void
	 * @创建人 刘晔
	 * @创建时间 2018年5月17日下午2:21:46
	 * @修改人 刘晔
	 * @修改时间 2018年5月17日下午2:21:46
	 * @修改备注
	 */
	public void userLogAdd(String auth_token,String[] permission_code) {
		
		SysUserVO vo = redisUtils.getSysUserVO(auth_token);
		SysUserLog sysUserLog = new SysUserLog(vo.getId(), permission_code[0], permission_code[1], new Date());
		if(vo!=null) {
			//记录信息
			sysUserLogMapper.userLogAdd(sysUserLog);
    	}
		logger.info("用户日志管理==>用户："+vo.getNickname()+"，访问了："+permission_code[0]+":"+permission_code[1]+"权限。");
	}
	/**
	 * @描述: 查询用户日志信息
	 * @方法名: selectUserLog
	 * @param at
	 * @return
	 * @返回类型 Results<ListVO<SysUserLog>>
	 * @创建人 刘晔
	 * @创建时间 2018年5月17日下午2:40:12
	 * @修改人 刘晔
	 * @修改时间 2018年5月17日下午2:40:12
	 * @修改备注
	 */
	public Results<ListVO<SysUserLog>> selectUserLog(SysUserLogVO at) {
		ListVO<SysUserLog> listVO = new ListVO<>();
//		int currentPage = at.getPage().getCurrentPage();
//		int pageSize = at.getPage().getPageSize();
//		//添加分页信息
//		Page page = new Page(currentPage, pageSize, sysUserLogMapper.count(at));
////		(#{page.currentPage}-1)*#{page.pageSize}
//		at.getPage().setCurrentPage((currentPage-1)*pageSize);
//		List<SysUserLog> selectUserLog = sysUserLogMapper.selectUserLog(at);
		SysUserLogExample sysUserLogExample = new SysUserLogExample();
		if (at.getStart_date() != null && at.getEnd_date() != null) {
			sysUserLogExample.createCriteria().andRecord_dateBetween(at.getStart_date(), at.getEnd_date());
		}
		Page page = new Page(at.getPage().getCurrentPage(),at.getPage().getPageSize(),sysUserLogMapper.countByExample(sysUserLogExample));
		// 添加排序以及分页
		sysUserLogExample.setOrderByClause("id desc limit " + page.getCurrentResult() + "," + page.getPageSize());
		listVO.setList(sysUserLogMapper.selectByExample(sysUserLogExample));
		listVO.setPage(page);
		return new Results<>(listVO);
	}
 }
