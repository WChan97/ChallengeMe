package fyreball.challengeme.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Random;

import fyreball.challengeme.R;

public class HomeActivity extends AppCompatActivity {
    //
    private TextView mTextView;

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //
        mTextView = (TextView) findViewById(R.id.challengeView);
        displayChallenge();
        //
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                */
                displayChallenge();
            }
        });
    }
    //
    private int getRandomNumber(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    private String getChallenge() {
        String challenge = "ChallengeMe";
        int freq = getRandomNumber(1, 5);
        if (freq == 1) {
            challenge = "Box Jumps: " + getRandomNumber(1,5) + " Times";
        } else if (freq == 2) {
            challenge = "Push Ups: " + getRandomNumber(1,5) + " Times";
        }
        else if (freq == 3) {
            challenge = "Sit Ups: " + getRandomNumber(1,5) + " Times";
        }
        else if (freq == 4) {
            challenge = "Squats: " + getRandomNumber(1,5) + " Times";
        }
        else if (freq == 5) {
            challenge = "Plank for: " + getRandomNumber(1,5) + " Minutes";
        }
        return challenge;
    }

    private void displayChallenge() {
        mTextView.setText(getChallenge());
    }
    //
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
}
