package za.net.hanro50.json;

import com.google.gson.annotations.Expose;

public class ERRORS {
	@Expose
	private int code;
	@Expose
	private String error;

	public int getCode() {
		return code;
	}

	public String getError() {
		return error;
	}
	
	
	private ERRORS() {
		
	}
}
