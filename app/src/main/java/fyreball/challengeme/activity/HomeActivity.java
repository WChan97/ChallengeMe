package fyreball.challengeme.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Random;

import fyreball.challengeme.R;

/**
 * An activity class that displays the random challenge and allows the user to refresh it.
 */
public class HomeActivity extends AppCompatActivity {

    // UI fields
    private TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Define components
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        mTextView = (TextView) findViewById(R.id.challengeView);

        // Set up action bar
        setSupportActionBar(toolbar);

        // Display content
        displayNewChallenge();

        // Set up onclick listener
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayNewChallenge();
            }
        });
    }

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

    /**
     * A helper method to display a new challenge onscreen.
     */
    private void displayNewChallenge() {
        mTextView.setText(getChallenge());
    }

    /**
     * A helper method to generate and return a string with a random challenge.
     *
     * @return the challenge string
     */
    private String getChallenge() {
        String challenge = null;

        int freq = getRandomNumberInRange(1, 5);

        if (freq == 1) {
            challenge = getString(R.string.challenge_box_jumps) + getRandomNumberInRange(1,5) + getString(R.string.times_suffix);
        }
        else if (freq == 2) {
            challenge = getString(R.string.challenge_push_ups) + getRandomNumberInRange(1,5) + getString(R.string.times_suffix);
        }
        else if (freq == 3) {
            challenge = getString(R.string.challenge_sit_ups) + getRandomNumberInRange(1,5) + getString(R.string.times_suffix);
        }
        else if (freq == 4) {
            challenge = getString(R.string.challenge_squats) + getRandomNumberInRange(1,5) + getString(R.string.times_suffix);
        }
        else if (freq == 5) {
            challenge = getString(R.string.challenge_planking) + getRandomNumberInRange(1,5) + getString(R.string.minutes_suffix);
        }
        return challenge;
    }

    /**
     * A helper method to generate and return a random number between two values.
     *
     * @param min - the minimum value
     * @param max - the maximum value
     * @return the random value
     */
    private int getRandomNumberInRange(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
