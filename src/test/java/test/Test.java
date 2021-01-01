package test;

import java.io.IOException;

import za.net.hanro50.client.TClient;
import za.net.hanro50.debug.Log;
import za.net.hanro50.files.FIleUtil;
import za.net.hanro50.files.FileObj;
import za.net.hanro50.json.GIF_OBJECT;
import za.net.hanro50.json.SearchResults;

public class Test {
	public static TClient client;
	public static SearchResults Baka;
	static {
		FileObj FO = new FileObj("", "tenortoken", "txt",new FIleUtil());
		try {
			client = new TClient(FO.read(""));
		} catch (IOException e) {
			Log.trace(e);
		}

	}
	
	public static void main(String[] args) {
		try {
			Baka = client.getSearchResults("baka").complete();
			Log.out("Results:"+Baka.getResults().length);
			for (GIF_OBJECT GO : Baka.getResults()) {
				Log.out("Media:"+GO.getMedia().length);
			}
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
