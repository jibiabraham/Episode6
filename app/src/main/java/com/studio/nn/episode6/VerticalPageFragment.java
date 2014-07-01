package com.studio.nn.episode6;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by jibi on 1/7/14.
 */
public class VerticalPageFragment extends Fragment {
    private int sectionNumber = 0;
    private int position = 0;

    public VerticalPageFragment() {}

    public static VerticalPageFragment newInstance(int position, int sectionNumber){
        VerticalPageFragment fragment = new VerticalPageFragment();
        Bundle args = new Bundle();
        args.putInt("SectionNumber", sectionNumber);
        args.putInt("Position", position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            sectionNumber = getArguments().getInt("SectionNumber");
            position = getArguments().getInt("Position");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vertical_page_instance, container, false);
        TextView postTitle = (TextView) view.findViewById(R.id.post);
        postTitle.setText("Post " + Integer.toString(position));
        return view;
    }
}
