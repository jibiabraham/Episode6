package com.studio.nn.episode6;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jibi on 1/7/14.
 */
public class CompositeVerticalPagerFragment extends Fragment {
    private ViewPager mHorizontalPager;
    private int mCentralPageIndex = 0;
    private int sectionNumber;

    public CompositeVerticalPagerFragment() {}

    public static CompositeVerticalPagerFragment newInstance(int sectionNumber){
        CompositeVerticalPagerFragment fragment = new CompositeVerticalPagerFragment();
        Bundle args = new Bundle();
        args.putInt("Section", sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            sectionNumber = getArguments().getInt("Section");
        }
    }

    private ViewPager.OnPageChangeListener mPagerChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageSelected(int position) {
            EventBus.getInstance().post(new PageChangedEvent(mCentralPageIndex == position));
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.composite_vertical_page, container, false);
        mHorizontalPager = (ViewPager) view.findViewById(R.id.fragment_composite_pager);

        populateHorizontalPager();

        mHorizontalPager.setCurrentItem(mCentralPageIndex);
        mHorizontalPager.setOnPageChangeListener(mPagerChangeListener);
        return view;
    }

    private void populateHorizontalPager() {
        ArrayList<VerticalPageFragment> pages = new ArrayList<VerticalPageFragment>();
        for (int i = 0; i < 3; i +=1){
            pages.add(VerticalPageFragment.newInstance(i + 1, sectionNumber));
        }
        mHorizontalPager.setAdapter(new FragmentsClassesPagerAdapter(getChildFragmentManager(), getActivity(), pages));
    }
}
