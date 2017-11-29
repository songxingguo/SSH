package com.sxg.ssh.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sxg.ssh.domain.Student;

public class PrivilegeInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		ActionContext actionContext = invocation.getInvocationContext();
			
		Student stu = (Student)actionContext.getSession().get("stu");
		if (null != stu) {
			return invocation.invoke();
		} else {
			actionContext.put("msg", "还未登录，请重新登录！");
			return Action.INPUT;
		}
	}
	
}
