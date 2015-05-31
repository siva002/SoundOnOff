package com.example.sivaprasad.soundonoff;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ToggleButton;


public class PreferencesActivity extends ActionBarActivity {

    private ToggleButton toggleButton;
    private boolean sound;
    private SharedPreferences sharedPreferences;
    public static String SHARED_PREFS;
    public static String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        TAG = getApplicationContext().getPackageName();
        SHARED_PREFS = TAG + ".sound";

        toggleButton = (ToggleButton) findViewById(R.id.toggle_sound);

        sharedPreferences = getSharedPreferences("SOUND",MODE_PRIVATE);

        // By default, sound is on. So, set the defalt value to true.
        sound = sharedPreferences.getBoolean("SOUND",true);
        if (sound == true){
            toggleButton.setChecked(true);
        } else {
            toggleButton.setChecked(false);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_preferences, menu);
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

    public void onClickSound(View view) {
        toggleButton = (ToggleButton) findViewById(R.id.toggle_sound);
        sharedPreferences = getSharedPreferences("SOUND",MODE_PRIVATE);
        if (toggleButton.isChecked() == true){
            // Toggle button is checked. Set the Shared preference - SOUND to true
            sharedPreferences.edit().putBoolean("SOUND",true).commit();
        }
        else {
            // Toggle button is unchecked. Set the shared preference - SOUND to false
            sharedPreferences .edit().putBoolean("SOUND",false).commit();
        }
    }
}
