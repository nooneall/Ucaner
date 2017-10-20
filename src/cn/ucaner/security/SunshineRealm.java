/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 19941115</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;

import cn.ucaner.common.GlobalConstant;
import cn.ucaner.common.spring.ext.SpringContextHolder;
import cn.ucaner.security.entity.Resource;
import cn.ucaner.security.entity.User;
import cn.ucaner.security.service.ResourceService;
import cn.ucaner.security.service.UserService;

/**
* @Package：cn.ucaner.security   
* @ClassName：SunshineRealm   
* @Description：   <p> TODO</p>
* @Author： - DaoDou 
* @CreatTime：2017年10月20日 下午4:10:25   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class SunshineRealm extends AuthorizingRealm {

	/**
	 * 为当前登录的Subject授予角色和权限
	 * 
	 * @see 方法的调用时为需授权资源被访问时
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		// long startTime = System.currentTimeMillis();
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getSession().getAttribute(GlobalConstant.SESSION_PLATFORM_USER_KEY);
		if (user == null) {
			return null;
		}
		if (user.getRoleIdList().size() == 0) {
			return null;
		}
		Set<String> roleIds = new HashSet<>();
		roleIds.addAll(user.getRoleIdList());

		Set<String> permissions = new HashSet<>();
		ResourceService resourceService = SpringContextHolder.getBean(ResourceService.class);
		// SecurityCacheManger securityCacheManger = SpringContextHelper.getBean(SecurityCacheManger.class);
		// List<SysResource> resourceList = securityCacheManger.queryResourceByRoleIds(roleIds);
		List<Resource> resourceList = resourceService.queryResourceByRoleIds(user.getRoleIdList());
		for (Resource resource : resourceList) {
			permissions.add(resource.getCode());
		}
		// long costTime = System.currentTimeMillis() - startTime;
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleIds);
		info.setStringPermissions(permissions);
		return info;
	}

	/**
	 * 获取身份验证信息
	 * 
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String account = (String) token.getPrincipal(); // 得到用户名

		UserService userService = SpringContextHolder.getBean(UserService.class);
		User user = userService.findUserByAccount(account);

		// 用户不存在
		if (user == null) {
			throw new UnknownAccountException();
		}

		// 帐号锁定或已失效
		if (user.getStatus() != GlobalConstant.YES) {
			throw new LockedAccountException();
		}

		// 身份认证验证成功，返回一个AuthenticationInfo
		AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getAccount(), user.getPassword(), getName());
		Subject subject = SecurityUtils.getSubject();
		subject.getSession().setAttribute(GlobalConstant.SESSION_PLATFORM_USER_KEY, user);
		subject.getSession().setAttribute(GlobalConstant.SESSION_PLATFORM_USER_ACCOUNT_KEY, user.getAccount());
		return authcInfo;
	}

	/**
	 * 更新用户授权信息缓存.
	 */
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 清除所有用户授权信息缓存.
	 */
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		cache.clear();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.shiro.realm.AuthenticatingRealm#supports(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	public boolean supports(AuthenticationToken token) {
		// 仅支持UsernamePasswordToken类型的Token
		return token instanceof UsernamePasswordToken;
	}

}
