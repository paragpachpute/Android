package com.samarth.swami.shreeswamisamarth;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    MediaPlayer mMediaPlayer;
    Utils mUtils;
    static int state;
    static FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mUtils = new Utils();

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(getString(R.string.app_name));

        Intent intent = getIntent();
        int position = intent.getIntExtra(Utils.EXTRA_POSITION, 0);
        mMediaPlayer = MediaPlayer.create(this, mUtils.getSong(position));
        mMediaPlayer.start();
        state = Utils.STATE_PLAYING;


        fab = (FloatingActionButton) findViewById(R.id.fab_play);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(state == Utils.STATE_PLAYING){
                    mMediaPlayer.pause();
                    fab.setBackgroundColor(25564129);
                    fab.setBackgroundResource(R.drawable.ic_play_black_24dp);
                    state = 0;

                }else{
                    mMediaPlayer.start();
                    fab.setBackgroundColor(25564129);
                    fab.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                    state = Utils.STATE_PLAYING;
                }
            }
        });

        loadBackdrop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mMediaPlayer != null)
            mMediaPlayer.stop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadBackdrop() {
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(R.drawable.swami_2).centerCrop().into(imageView);
    }
}
