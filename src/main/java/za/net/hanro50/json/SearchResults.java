package za.net.hanro50.json;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.Expose;
import za.net.hanro50.debug.Log;

public class SearchResults {
	private static final Gson gson =  new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().excludeFieldsWithModifiers()
			.enableComplexMapKeySerialization()
			.create();


	@Expose
	private String web_url;
	@Expose
	private GIF_OBJECT[] results;
	@Expose
	private String next;

	private SearchResults() {
	}

	public static SearchResults get(String json) throws JsonSyntaxException{
		try {

			return gson.fromJson(json, SearchResults.class);
		} catch (RuntimeException e) {
			Log.rep(json);
			throw e;
		}
	}

	public String getWeburl() {
		return web_url;
	}

	public GIF_OBJECT[] getResults() {
		return results;
	}

}
