package com.example.madsmartcity;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Scene3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Scene3 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Scene3() {
        // Required empty public constructor
    }

    public static Scene3 newInstance(String param1, String param2) {
        Scene3 fragment = new Scene3();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_scene3, container, false);

        VideoView s3 = view.findViewById(R.id.Scene3);
        s3.setVideoPath("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.vid3);

        // Initialize the replay button
        Button endBtn = view.findViewById(R.id.EndButton);
        MediaController mediaController = new MediaController(requireContext());
        s3.setMediaController(mediaController);
        mediaController.setAnchorView(s3);

        endBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Corrected context to getActivity() instead of Scene3.this
                Intent intent = new Intent(getActivity(), MainActivity3.class);
                startActivity(intent);
                // Removed finish() because it's not an Activity
            }
        });

        s3.setOnCompletionListener(mediaPlayer -> {
            endBtn.setVisibility(View.VISIBLE);
        });

        s3.start();

        return view;  // Ensure you return the inflated view
    }
}
