package battlequest.android.example.com.battlequest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

public class SettingsFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        addListenerOnButton(rootView);

        return rootView;
    }


    public void addListenerOnButton(View rootView) {
        CheckBox musicToggle = (CheckBox) rootView.findViewById(R.id.musicCheckBox);
        Log.i("TAG", "method ran");
        musicToggle.setChecked(true);

        musicToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    Log.i("TAG", "isChecked = true");
                    getActivity().startService(new Intent(getActivity(), MusicService.class));

                } else if (!(((CheckBox) v).isChecked())) {
                    Log.i("TAG", "isChecked = false");
                    getActivity().stopService(new Intent(getActivity(), MusicService.class));

                }
            }
        });


    }
}
