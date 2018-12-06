package battlequest.android.example.com.battlequest;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class GamesFragment extends Fragment implements View.OnClickListener {
    ImageButton irlButton, fortniteButton, pubgButton, csgoButton;
    MediaPlayer swoop;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_games, container, false);

        swoop = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.swoop);

        defineButtons(rootView);
        onClick(rootView);


        return rootView;

    }


    public void onClick(View v) {
        View rootView = v;

        switch (v.getId()) {
            case R.id.irlButton:
                swoop.start();
                Fragment newFragment = new IRLFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                transaction.replace(R.id.fragment_container, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;

            case R.id.forniteButton:
                swoop.start();
                Fragment newFragment2 = new FortniteFragment();
                FragmentTransaction transaction2 = getFragmentManager().beginTransaction();

                transaction2.replace(R.id.fragment_container, newFragment2);
                transaction2.addToBackStack(null);
                transaction2.commit();
                break;

            case R.id.pubgButton:
                swoop.start();
                Fragment newFragment3 = new PUBGFragment();
                FragmentTransaction transaction3 = getFragmentManager().beginTransaction();

                transaction3.replace(R.id.fragment_container, newFragment3);
                transaction3.addToBackStack(null);
                transaction3.commit();
                break;

            case R.id.csgoButton:
                swoop.start();
                Fragment newFragment4 = new CSFragment();
                FragmentTransaction transaction4 = getFragmentManager().beginTransaction();

                transaction4.replace(R.id.fragment_container, newFragment4);
                transaction4.addToBackStack(null);
                transaction4.commit();
                break;


        }


    }


    public void defineButtons(View view) {
        View rootView = view;

        irlButton = (ImageButton) rootView.findViewById(R.id.irlButton);
        fortniteButton = (ImageButton) rootView.findViewById(R.id.forniteButton);
        csgoButton = (ImageButton) rootView.findViewById(R.id.csgoButton);
        pubgButton = (ImageButton) rootView.findViewById(R.id.pubgButton);

        irlButton.setOnClickListener(this);
        fortniteButton.setOnClickListener(this);
        csgoButton.setOnClickListener(this);
        pubgButton.setOnClickListener(this);
    }
}

