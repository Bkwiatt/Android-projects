package battlequest.android.example.com.battlequest;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import battlequest.android.example.com.battlequest.R;

public class MusicService extends Service {
    private MediaPlayer mainMusic;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mainMusic = MediaPlayer.create(this, R.raw.fortnitemusic);
        mainMusic.setLooping(true);
        mainMusic.start();
        return START_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mainMusic.stop();
    }
}