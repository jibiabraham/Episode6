package com.studio.nn.episode6;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.squareup.otto.Subscribe;

/**
 * Created by jibi on 1/7/14.
 */
public class MainActivity extends FragmentActivity {
    private VerticalPager mVerticalPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVerticalPager = (VerticalPager) findViewById(R.id.activity_main_vertical_pager);
        createVerticalPages(10);
    }

    private void createVerticalPages(int howMany) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        for (int i = 0; i < howMany; i+=1){
            CompositeVerticalPagerFragment fragment = CompositeVerticalPagerFragment.newInstance(i + 1);
            fragmentTransaction.add(R.id.activity_main_vertical_pager, fragment);
        }
        fragmentTransaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getInstance().register(this);
    }

    @Override
    protected void onPause() {
        EventBus.getInstance().unregister(this);
        super.onPause();
    }
}
