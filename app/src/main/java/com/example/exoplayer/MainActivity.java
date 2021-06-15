package com.example.exoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.StyledPlayerView;

public class MainActivity extends AppCompatActivity {

    private StyledPlayerView playerView;
    private SimpleExoPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerView = findViewById(R.id.video_view);

        playerView.setShowNextButton(false);
        playerView.setShowPreviousButton(false);
        playerView.setShowFastForwardButton(false);
        playerView.setShowRewindButton(false);

        playerView.setShowSubtitleButton(true);

        player = new SimpleExoPlayer.Builder(this)
                .build();

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.test5);
        MediaItem.Builder mediaItemBuilder = new MediaItem.Builder()
                .setUri(uri);

        playerView.setPlayer(player);

        player.setMediaItem(mediaItemBuilder.build());

        player.prepare();

        playerView.setControllerShowTimeoutMs(-1);
        playerView.showController();
    }
}