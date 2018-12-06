package battlequest.android.example.com.battlequest;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private ImageButton homeButton;
    int totalTickets = 0;
    public TextView showValue;
    private MySqliteOpenHelper mySqliteOpenHelper;
    private SQLiteDatabase mDatabase;
    private ImageView profilePic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");


        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_menu);
        navigationView.setNavigationItemSelectedListener(this);

                //Grab Google sign in info from signIn Activity
        Bundle extras = getIntent().getExtras();
        //String googleDisplayName = extras.getString("NAME_KEY");
        //updateUserInfo(googleDisplayName);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.close_drawer_open);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }


    }


    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        final MediaPlayer click = MediaPlayer.create(this, R.raw.clicksound);
        ImageButton navIcon = (ImageButton) findViewById(R.id.nav_games);

        switch (item.getItemId()) {
            case R.id.nav_account:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AccountFragment()).commit();
                click.start();
                break;

            case R.id.nav_games:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new GamesFragment()).commit();
                click.start();
                break;

            case R.id.nav_add:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AddTicketsFragment()).commit();
                click.start();
                break;

            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                click.start();
                break;

            case R.id.nav_social:
                Toast.makeText(this, "Share", Toast.LENGTH_LONG).show();
                click.start();
                break;

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final MediaPlayer click = MediaPlayer.create(this, R.raw.clicksound);
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new SettingsFragment()).commit();
            click.start();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**public void updateUserInfo(String username) {
        String url = "https://lh5.googleusercontent.com/-90Bc0TkHEc8/AAAAAAAAAAI/AAAAAAAAEAk/_mD8mGsSOr0/s96-c/photo.jpg";

        NavigationView navigationView1 = (NavigationView) findViewById(R.id.nav_menu);
        View hView = navigationView1.getHeaderView(0);
        TextView nav_user = (TextView) hView.findViewById(R.id.username);
        nav_user.setText(username);
        //Glide.with(this).load(url).into(profilePic);
    }**/

    @Override
    public void onPause() {
        super.onPause();
        stopService(new Intent(getBaseContext(), MusicService.class));
    }

    @Override
    public void onResume() {
        super.onResume();
        startService(new Intent(getBaseContext(), MusicService.class));
    }



}





