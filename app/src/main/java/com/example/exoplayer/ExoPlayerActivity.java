package com.example.exoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.StyledPlayerView;

public class ExoPlayerActivity extends AppCompatActivity {

    private StyledPlayerView playerView;
    private SimpleExoPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exoplayer);
        playerView = findViewById(R.id.video_view);
        MediaItem.Builder mediaItemBuilder = new MediaItem.Builder()
                .setUri(getIntent().getData())
                .setMimeType(getIntent().getType());
        player = new SimpleExoPlayer.Builder(this).build();
        playerView.setPlayer(player);
        player.setMediaItem(mediaItemBuilder.build());
        player.prepare();
        player.setPlayWhenReady(true);
    }
}