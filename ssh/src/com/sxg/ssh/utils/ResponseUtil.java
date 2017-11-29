package com.sxg.ssh.utils;

import com.opensymphony.xwork2.ActionContext;


public class ResponseUtil {
	

	public static void putDataIntoValueStack(Object data) {
//		ActionContext context = ActionContext.getContext();
//		ValueStack valueStack = context.getValueStack();
//		valueStack.put("data", data);
		ActionContext.getContext().getValueStack().push(data);
	}
}
