package com.hbase.utils;

/**
 * 
 * @author FR
 *
 */
public class AjaxJson {
	 private Object msg;
	    private Boolean success = true;

	    public AjaxJson(Object msg, Boolean success) {
	        super();
	        this.msg = msg;
	        this.success = success;
	    }

	    public AjaxJson(Object msg) {
	        super();
	        this.msg = msg;
	    }

	    public AjaxJson() {
	        super();
	    }

	    public Object getMsg() {
	        return msg;
	    }

	    public AjaxJson setMsg(Object msg) {
	        this.msg = msg;
	        return this;
	    }

	    public Boolean getSuccess() {
	        return success;
	    }

	    public AjaxJson setSuccess(Boolean success) {
	        this.success = success;
	        return this;
	    }
}
