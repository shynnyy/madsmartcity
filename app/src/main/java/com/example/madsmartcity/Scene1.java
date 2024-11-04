package com.example.madsmartcity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.fragment.app.Fragment;

public class Scene1 extends Fragment {

    // Arguments for fragment initialization
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Scene1() {

    }


    public static Scene1 newInstance(String param1, String param2) {
        Scene1 fragment = new Scene1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_scene1, container, false);


        VideoView s1 = view.findViewById(R.id.Scene1);
        s1.setVideoPath("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.vid1);


        MediaController mediaController = new MediaController(requireContext());
        s1.setMediaController(mediaController);
        mediaController.setAnchorView(s1);
        Button endBtn = view.findViewById(R.id.EndButton);
        endBtn.setVisibility(View.GONE);

        endBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity3.class);
                startActivity(intent);
            }
        });

        // Show End button when the video completes
        s1.setOnCompletionListener(mediaPlayer -> endBtn.setVisibility(View.VISIBLE));

        // Start the video
        s1.start();

        return view;
    }
}
