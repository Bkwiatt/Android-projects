package battlequest.android.example.com.battlequest;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_page, container, false);
        videoPlay(rootView);

        return inflater.inflate(R.layout.home_page, container, false);

    }

    public void videoPlay(View rootView){
        VideoView videoView = (VideoView)rootView.findViewById(R.id.videoView);
        String videoPath = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.ds;
        videoView.setVideoURI(Uri.parse(videoPath));
        videoView.start();
        Log.i("myTag", "chicken");
    }



}
