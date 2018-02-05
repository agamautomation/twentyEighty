package com.twentyeighty.utilities;

public class Result {
	public Result() {
		result = false;
		object = null;
	}

	public void setResult(boolean value) {
		this.result = value;
	}

	public boolean getResult() {
		return this.result;
	}

	public void setObject(Object value) {
		this.object = value;
	}

	public Object getObject() {
		return this.object;
	}

	private boolean result;
	private Object object;
}
