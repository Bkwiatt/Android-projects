package battlequest.android.example.com.battlequest;

import android.app.FragmentManager;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.signin.SignIn;
import com.google.android.gms.tasks.Task;

import java.util.jar.Attributes;

public class signIn extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    private DrawerLayout drawer;
    private ImageButton homeButton;
    int totalTickets = 0;
    TextView showValue;
    private LinearLayout Prof_Section;
    private Button SignOut;
    private SignInButton SignIn;
    private TextView Name, Email;
    private ImageView profilePic;
    private GoogleApiClient googleApiClient;
    private static final int REQ_CODE = 9001;
    MediaPlayer loginSound = new MediaPlayer();
    private MySqliteOpenHelper mySqliteOpenHelper;
    private SQLiteDatabase mDatabase;
    private String oAuthID = "811026734309-cseo4qm7e0efbvrnuqscjn0578pu4l4p.apps.googleusercontent.com";
    public GoogleSignInClient mGoogleSignInClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("TAG", "PROGRAM STARTED");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        //Initializing Sign in Variables
        SignIn = (SignInButton) findViewById(R.id.sign_in_button);
        loginSound = MediaPlayer.create(this, R.raw.swoop);
        SignIn.setOnClickListener(this);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().requestIdToken(oAuthID).build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.sign_in_button:
                signIn();
                break;

        }

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, REQ_CODE);

        //Create sql db
        mySqliteOpenHelper = new MySqliteOpenHelper(getApplicationContext());
        mDatabase = mySqliteOpenHelper.getReadableDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from users ; ", null);


    }


    private void signOut() {
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {


            }
        });


    }

    private void handleResult(Task<GoogleSignInAccount> completedTask) {

        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            String name = account.getGivenName();
            String email = account.getEmail();
            Log.i("TAG", name);

            String img_url = account.getPhotoUrl().toString();
            Log.i("TAG", img_url);
            //Glide.with(this).load(img_url).into(profilePic);;

            Intent intent = new Intent(signIn.this, MainActivity.class);
            intent.putExtra("NAME_KEY", name);
            loginSound.start();
            startActivity(intent);

        } catch (ApiException e) {
            Log.i("TAG", "SIGN IN FAILURE");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_CODE) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleResult(task);
        }
    }


}
