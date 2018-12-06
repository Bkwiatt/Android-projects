package battlequest.android.example.com.battlequest;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class AddTicketsFragment extends Fragment implements View.OnClickListener {
    MediaPlayer mp;
    int totalTickets = 0;
    TextView showValue;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.addtickets, container, false);
        mp = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.cashreg);
        showValue = (TextView) rootView.findViewById(R.id.ticketCounter);
        showValue.setText("Tickets: " + Integer.toString(totalTickets));


        Button ticket1 = (Button) rootView.findViewById(R.id.button);
        Button ticket2 = (Button) rootView.findViewById(R.id.button2);
        Button ticket3 = (Button) rootView.findViewById(R.id.button3);
        Button ticket4 = (Button) rootView.findViewById(R.id.button4);
        Button ticket5 = (Button) rootView.findViewById(R.id.button5);
        Button ticket6 = (Button) rootView.findViewById(R.id.button6);
        Button ticket7 = (Button) rootView.findViewById(R.id.button7);
        Button ticket8 = (Button) rootView.findViewById(R.id.button8);
        Button ticket9 = (Button) rootView.findViewById(R.id.button9);
        Button ticket10 = (Button) rootView.findViewById(R.id.button10);
        Button ticket11 = (Button) rootView.findViewById(R.id.button11);
        Button ticket12 = (Button) rootView.findViewById(R.id.button12);
        Button ticket13 = (Button) rootView.findViewById(R.id.button13);
        Button ticket14 = (Button) rootView.findViewById(R.id.button14);
        Button ticket15 = (Button) rootView.findViewById(R.id.button15);
        Button ticket16 = (Button) rootView.findViewById(R.id.button16);
        Button ticket17 = (Button) rootView.findViewById(R.id.button17);
        Button ticket18 = (Button) rootView.findViewById(R.id.button18);
        Button ticket19 = (Button) rootView.findViewById(R.id.button19);

        ticket1.setOnClickListener(this);
        ticket2.setOnClickListener(this);
        ticket3.setOnClickListener(this);
        ticket4.setOnClickListener(this);
        ticket5.setOnClickListener(this);
        ticket6.setOnClickListener(this);
        ticket7.setOnClickListener(this);
        ticket8.setOnClickListener(this);
        ticket9.setOnClickListener(this);
        ticket10.setOnClickListener(this);
        ticket11.setOnClickListener(this);
        ticket12.setOnClickListener(this);
        ticket13.setOnClickListener(this);
        ticket14.setOnClickListener(this);
        ticket15.setOnClickListener(this);
        ticket16.setOnClickListener(this);
        ticket17.setOnClickListener(this);
        ticket18.setOnClickListener(this);
        ticket19.setOnClickListener(this);

        return rootView;
    }

    public void onDestroy() {
        super.onDestroy();
        mp.release();
        mp = null;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button:
                mp.start();
                Toast.makeText(getActivity(), "You Purchased 1 Ticket!", Toast.LENGTH_SHORT).show();
                totalTickets += 1;
                showValue.setText("Tickets: " + Integer.toString(totalTickets));
                break;
            case R.id.button2:
                mp.start();
                Toast.makeText(getActivity(), "You Purchased 5 Ticket!", Toast.LENGTH_SHORT).show();
                totalTickets += 5;
                showValue.setText("Tickets: " + Integer.toString(totalTickets));
                break;
            case R.id.button3:
                mp.start();
                Toast.makeText(getActivity(), "You Purchased 10 Ticket!", Toast.LENGTH_SHORT).show();
                totalTickets += 10;
                showValue.setText("Tickets: " + Integer.toString(totalTickets));
                break;
            case R.id.button4:
                mp.start();
                Toast.makeText(getActivity(), "You Purchased 20 Ticket!", Toast.LENGTH_SHORT).show();
                totalTickets += 20;
                showValue.setText("Tickets: " + Integer.toString(totalTickets));
                break;
            case R.id.button5:
                mp.start();
                Toast.makeText(getActivity(), "You Purchased 25 Ticket!", Toast.LENGTH_SHORT).show();
                totalTickets += 25;
                showValue.setText("Tickets: " + Integer.toString(totalTickets));
                break;
            case R.id.button6:
                mp.start();
                Toast.makeText(getActivity(), "You Purchased 30 Ticket!", Toast.LENGTH_SHORT).show();
                totalTickets += 30;
                showValue.setText("Tickets: " + Integer.toString(totalTickets));
                break;
            case R.id.button7:
                mp.start();
                Toast.makeText(getActivity(), "You Purchased 50 Ticket!", Toast.LENGTH_SHORT).show();
                totalTickets += 50;
                showValue.setText("Tickets: " + Integer.toString(totalTickets));
                break;
            case R.id.button8:
                mp.start();
                Toast.makeText(getActivity(), "You Purchased 75 Ticket!", Toast.LENGTH_SHORT).show();
                totalTickets += 75;
                showValue.setText("Tickets: " + Integer.toString(totalTickets));
                break;
            case R.id.button9:
                mp.start();
                Toast.makeText(getActivity(), "You Purchased 100 Ticket!", Toast.LENGTH_SHORT).show();
                totalTickets += 100;
                showValue.setText("Tickets: " + Integer.toString(totalTickets));
                break;
            case R.id.button10:
                mp.start();
                break;
            case R.id.button11:
                mp.start();
                break;
            case R.id.button12:
                mp.start();
                break;
            case R.id.button13:
                mp.start();
                break;
            case R.id.button14:
                mp.start();
                break;
            case R.id.button15:
                mp.start();
                break;
            case R.id.button16:
                mp.start();
                break;
            case R.id.button17:
                mp.start();
                break;
            case R.id.button18:
                mp.start();
                break;
            case R.id.button19:
                mp.start();
                break;


        }

    }

}




