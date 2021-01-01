package za.net.hanro50.client;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import za.net.hanro50.json.SearchResults;
import za.net.hanro50.types.AsyncProcess;


public class TClient {
	private final String API_KEY;

	public TClient(String token) {
		API_KEY = token;

	}

	/**
	 * Get Search Result GIFs
	 */
	public AsyncProcess<SearchResults> getSearchResults(final String searchTerm) {
		return () -> {
			String url = String.format(
					"https://api.tenor.com/v1/search?q=%1$s&key=%2$s&&contentfilter=high",
					searchTerm.trim().replaceAll(" ", "%20"), API_KEY);
			try {
				return SearchResults.get(get(url));
			} catch (IOException ignored) {

			}
			return null;
		};
	}

	/**
	 * @param searchTerm The term you wish to search for
	 * @return an async process you can use to process the results
	 */
	public AsyncProcess<SearchResults> getRandomResults(final String searchTerm) {
		return () -> {
			String url = String.format(
					"https://api.tenor.com/v1/random?q=%1$s&key=%2$s&&contentfilter=high&media_filter=minimal",
					searchTerm, API_KEY);
			try {
				return SearchResults.get(get(url));
			} catch (IOException ignored) {

			}

			return null;
		};
	}

//	public SearchResults getSearchResults(String searchTerm, int limit) {

	// make search request - using default locale of EN_US

	// }

	/**
	 * Construct and run a GET request
	 */
	private String get(String url) throws IOException {
		HttpURLConnection connection = null;
		try {
			// Get request
			connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

			// Handle failure
			int statusCode = connection.getResponseCode();
			if (statusCode != HttpURLConnection.HTTP_OK && statusCode != HttpURLConnection.HTTP_CREATED) {
				String error = String.format("HTTP Code: '%1$s' from '%2$s'", statusCode, url);
				throw new ConnectException(error);
			}

			// Parse response
			return parser(connection);
		} catch (Exception ignored) {
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		return "{}";
	}

	/**
	 * Parse the response into JSONObject
	 */
	private String parser(HttpURLConnection connection) {
		char[] buffer = new char[1024 * 4];
		int n;
		try (InputStream stream = new BufferedInputStream(connection.getInputStream())) {
			InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
			StringWriter writer = new StringWriter();
			while (-1 != (n = reader.read(buffer))) {
				writer.write(buffer, 0, n);
			}
			return writer.toString();
		} catch (IOException ignored) {
		}
		return "{}";
	}
}
