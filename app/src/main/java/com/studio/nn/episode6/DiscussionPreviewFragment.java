package com.studio.nn.episode6;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jibi on 26/6/14.
 */
public class DiscussionPreviewFragment extends Fragment {
    public DiscussionPreviewFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.discussion_preview, container, false);
        return view;
    }
}
