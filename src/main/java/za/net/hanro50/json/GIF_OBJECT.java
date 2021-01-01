package za.net.hanro50.json;

import com.google.gson.annotations.Expose;

import java.util.HashMap;
import java.util.Map;

public class GIF_OBJECT {

	public static class OverrideMap<A,B> extends HashMap<A,B> {
		@Override
		public B put(A key, B value) {
			if (containsKey(key)) {
				remove(key);
			}
			return super.put(key, value);
		}
	}
	@Expose
	private float created;
	@Expose
	private int shares;
	@Expose
	private boolean hasaudio;
	@Expose
	private String id;
	@Expose
	private OverrideMap<FormatType, MEDIA_OBJECT>[] media;
	@Expose
	private String[] tags;
	@Expose
	private String title;
	@Expose
	private String itemurl;
	@Expose
	private boolean hascaption;
	@Expose
	private String url;
	/**
	 * Don't know what this is. Ignoring it
	 */
	@Expose
	private Object composite;

	public float getCreated() {
		return created;
	}

	public boolean isHasaudio() {
		return hasaudio;
	}

	public String getId() {
		return id;
	}

	public Map<FormatType, MEDIA_OBJECT>[] getMedia() {
		return media;
	}

	public String[] getTags() {
		return tags;
	}

	public String getTitle() {
		return title;
	}

	public String getItemurl() {
		return itemurl;
	}

	public boolean isHascaption() {
		return hascaption;
	}

	public String getUrl() {
		return url;
	}

	public int getShares() {
		return shares;
	}
	
	private GIF_OBJECT() {
		
	}
}
