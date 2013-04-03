package org.gulir.ting;

import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

public final class RSSFeeder extends AsyncTask<Void, Void, Void> {

	private ProgressDialog progress = null;
	
	public Activity activity = null;
	public ArrayList<RSSItem> itemList = new ArrayList<RSSItem>();
	String feedUrl = null;;

	
	public RSSFeeder (String feedUrl, Activity activity, ArrayList<RSSItem> itemList) {
		this.feedUrl = feedUrl;
		this.activity = activity;
		this.itemList = itemList;
		
	}
	
	@Override
	protected Void doInBackground(Void... params) {
		retrieveRSSFeed(feedUrl, itemList);

		return null;
	}

	@Override
	protected void onCancelled() {
		super.onCancelled();
	}

	@Override
	protected void onPreExecute() {
		progress = ProgressDialog.show(activity, null,
				"Loading RSS Feeds...");

		super.onPreExecute();
	}

	@Override
	protected void onPostExecute(Void result) {

		progress.dismiss();

		super.onPostExecute(result);
	}

	@Override
	protected void onProgressUpdate(Void... values) {
		super.onProgressUpdate(values);
	}

	  private void retrieveRSSFeed(String rssurl,ArrayList<RSSItem> list)
	    {
	        try
	        {
	           URL url = new URL(rssurl);
	           SAXParserFactory factory = SAXParserFactory.newInstance();
	           SAXParser parser = factory.newSAXParser();
	           XMLReader xmlreader = parser.getXMLReader();
	           RSSParser theRssHandler = new RSSParser(list);

	           xmlreader.setContentHandler(theRssHandler);

	           InputSource is = new InputSource(url.openStream());

	           xmlreader.parse(is);
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }

}
