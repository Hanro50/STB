package za.net.hanro50.json;

import com.google.gson.annotations.Expose;

public class MEDIA_OBJECT {
	@Expose
	private String preview;
	@Expose
	private String url;
	@Expose
	private int[] dims;
	@Expose
	private int size;
	
	public int getSize() {
		return size;
	}
	public int[] getDims() {
		return dims;
	}
	public String getUrl() {
		return url;
	}
	public String getPreview() {
		return preview;
	}
	
	private MEDIA_OBJECT() {
		
	}
}
