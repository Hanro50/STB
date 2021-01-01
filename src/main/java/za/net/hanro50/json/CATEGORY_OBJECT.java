package za.net.hanro50.json;

import com.google.gson.annotations.Expose;

public class CATEGORY_OBJECT {
	@Expose
	private String searchterm;
	@Expose
	private String path;
	@Expose
	private String image;
	@Expose
	private String name;

	public String getName() {
		return name;
	}

	public String getImage() {
		return image;
	}

	public String getPath() {
		return path;
	}

	public String getSearchterm() {
		return searchterm;
	}

	private CATEGORY_OBJECT() {
		
	}
	
}
