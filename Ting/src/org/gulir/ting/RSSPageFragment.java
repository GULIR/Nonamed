package org.gulir.ting;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class RSSPageFragment extends Fragment {

	protected static final String FEED_URL = "http://www.concelloderianxo.es/c/blogs_aggregator/rss?p_l_id=10577&organizationId=10544";
	
	public RSSPageFragment() {
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.activity_list, container,
				false);
		ListView listView = (ListView) rootView
				.findViewById(R.id.listView);

		ArrayList<RSSItem> list = new ArrayList<RSSItem>();
		
		RSSFeeder feeder = new RSSFeeder(FEED_URL, getActivity(), list);
		
		feeder.execute();
		
		RSSListAdapter la =  new RSSListAdapter(getActivity(), R.layout.rssitemview, list);
		
		listView.setAdapter(la);
		
		return rootView;
	}

}
