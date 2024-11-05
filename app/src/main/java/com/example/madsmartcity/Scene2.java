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

public class Scene2 extends Fragment {

    // Arguments for fragment initialization
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Scene2() {
        // Required empty public constructor
    }

    // Factory method to create a new instance of Scene2 with arguments
    public static Scene2 newInstance(String param1, String param2) {
        Scene2 fragment = new Scene2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retrieve arguments if available
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_scene2, container, false);

        // Initialize and set up VideoView
        VideoView s2 = view.findViewById(R.id.Scene2);
        s2.setVideoPath("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.vid2);

        // Set MediaController to control video playback
        MediaController mediaController = new MediaController(requireContext());
        s2.setMediaController(mediaController);
        mediaController.setAnchorView(s2);

        // Initialize End button and set its visibility to gone initially
        Button endBtn = view.findViewById(R.id.EndButton);
        endBtn.setVisibility(View.GONE);  // Hide end button until video completes

        // Set onClickListener for End button to start MainActivity3
        endBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity3.class);
                startActivity(intent);
            }
        });

        // Show End button when the video completes
        s2.setOnCompletionListener(mediaPlayer -> endBtn.setVisibility(View.VISIBLE));

        // Start the video
        s2.start();

        return view;
    }
}