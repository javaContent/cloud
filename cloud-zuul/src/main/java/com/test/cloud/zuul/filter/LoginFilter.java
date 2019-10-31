package com.test.cloud.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.test.common.constant.CommonConst;

public class LoginFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		//返回true 代表过滤器生效
        return true;
	}

	@Override
	public Object run() throws ZuulException {
		//过去Zuul提供的请求上下文对象
        RequestContext ctx = RequestContext.getCurrentContext();
        //从上下文中获取request对象
        HttpServletRequest request = ctx.getRequest();
        //从请求中获取token
//        String token = request.getParameter(CommonConst.ACCESS_TOCKEN);
        String token = request.getHeader(CommonConst.ACCESS_TOCKEN);
        //判断
        if(StringUtils.isEmpty(token)){
            //没有token，拦截
            ctx.setSendZuulResponse(false);
            //返回401状态码，可以考虑重定向到登录页
            ctx.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
        }
        //校验通过，可以考虑把用户信息放入上下文，继续向后执行
        return null;
	}
	
	/**
	 * pre：请求在路由之前执行；
	 * routing：在路由请求时调用；
	 * post：在routing和error过滤器之后调用；
	 * error：处理请求时发生错误调用
	 */
	@Override
	public String filterType() {
		//设置这个过滤器为前置过滤器
        return "pre";
	}

	@Override
	public int filterOrder() {
		//顺序设置为1
        return 1;
	}

}
