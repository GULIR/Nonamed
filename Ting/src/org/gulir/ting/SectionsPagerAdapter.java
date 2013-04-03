package org.gulir.ting;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

	public static final int TAB_COUNT = 3;
	
	private String pageTitles[] = new String[TAB_COUNT];
	
	public SectionsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {

		switch(position) {
		case 0:
			return new RSSPageFragment();
		case 1:
			return new CalendarPageFragment();
		case 2:
			return new InfoPageFragment();
		default:
			return new InfoPageFragment();
		}


	}

	@Override
	public int getCount() {
		// Show 3 total pages.
		return TAB_COUNT;
	}

	public void setPageTitle(int position, String title) {
		pageTitles[position] = title;
	}
	
	@Override
	public CharSequence getPageTitle(int position) {
		return pageTitles[position];
	}
}


