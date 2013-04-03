package org.gulir.ting;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class RSSListAdapter extends ArrayAdapter<RSSItem> {

	private List<RSSItem> objects = null;

	public RSSListAdapter(Context context, int textviewid) {
		super(context, textviewid);

		this.objects = new ArrayList<RSSItem>();
	}

	public RSSListAdapter(Context context, int textviewid, List<RSSItem> objects) {
		super(context, textviewid, objects);

		this.objects = objects;
	}

	@Override
	public int getCount() {
		return ((null != objects) ? objects.size() : 0);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public RSSItem getItem(int position) {
		return ((null != objects) ? objects.get(position) : null);
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;

		if (null == view) {
			LayoutInflater vi = (LayoutInflater) getContext().getSystemService(
					Context.LAYOUT_INFLATER_SERVICE);
			view = vi.inflate(R.layout.rssitemview, null);
		}

		RSSItem data = objects.get(position);

		if (null != data) {
			TextView title = (TextView) view.findViewById(R.id.txtTitle);
			TextView date = (TextView) view.findViewById(R.id.txtDate);
			TextView description = (TextView) view
					.findViewById(R.id.txtDescription);

			title.setText(data.title);
			date.setText("on " + data.date);
			description.setText(data.description);
		}

		return view;
	}
}
