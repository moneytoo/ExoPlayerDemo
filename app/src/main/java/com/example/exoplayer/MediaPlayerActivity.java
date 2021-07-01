package com.example.exoplayer;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MediaPlayerActivity extends AppCompatActivity {

    VideoView mVideoView;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediaplayer);
        mediaController = new MediaController(this);
        mVideoView = findViewById(R.id.mVideoView);
        mediaController.setAnchorView(mVideoView);
        mVideoView.setVideoURI(getIntent().getData());
        mVideoView.setMediaController(mediaController);
        mVideoView.start();
    }
}
