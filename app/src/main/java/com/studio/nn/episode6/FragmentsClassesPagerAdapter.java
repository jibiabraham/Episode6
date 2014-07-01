package com.studio.nn.episode6;

import java.util.List;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * Adapter for {@link ViewPager} that will populated from the collection of Fragments classes. Objects of that classes
 * will be instantiated on demand and used as a pages views.
 */
public class FragmentsClassesPagerAdapter extends FragmentPagerAdapter {

    // -----------------------------------------------------------------------
    //
    // Constructors
    //
    // -----------------------------------------------------------------------
    public FragmentsClassesPagerAdapter(FragmentManager fragmentManager, Context context,
                                        List<VerticalPageFragment> pages) {
        super(fragmentManager);
        mPagesClasses = pages;
        mContext = context;
    }

    // -----------------------------------------------------------------------
    //
    // Fields
    //
    // -----------------------------------------------------------------------
    private List<VerticalPageFragment> mPagesClasses;
    private Context mContext;

    // -----------------------------------------------------------------------
    //
    // Methods
    //
    // -----------------------------------------------------------------------
    @Override
    public Fragment getItem(int position) {
        return mPagesClasses.get(position);
    }

    @Override
    public int getCount() {
        return mPagesClasses.size();
    }
}
