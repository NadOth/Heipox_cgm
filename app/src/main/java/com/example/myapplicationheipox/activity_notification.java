package com.example.myapplicationheipox;

import android.widget.Toast;
import androidx.appcompat.widget.SwitchCompat;
import android.os.Bundle;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import android.graphics.PorterDuff;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.view.View;
import android.content.SharedPreferences;
import androidx.appcompat.widget.SwitchCompat;
import android.text.Editable;
import android.text.TextWatcher;

public class activity_notification extends AppCompatActivity {

    private EditText minutesEditText;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        // Initialize EditText and SharedPreferences
        minutesEditText = findViewById(R.id.minutesEditText);
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        // Load the previously saved minutes, defaulting to 0 if not found
        int savedMinutes = sharedPreferences.getInt("minutes", 0);
        minutesEditText.setText(String.valueOf(savedMinutes));

        // Find each SwitchCompat directly using its ID and apply color changes
        SwitchCompat switchAll = findViewById(R.id.switch_Notf);
        applyColorToSwitch(switchAll);

        SwitchCompat switchLow = findViewById(R.id.switch_Low);
        applyColorToSwitch(switchLow);

        SwitchCompat switchSoundLow = findViewById(R.id.sound_low);
        applyColorToSwitch(switchSoundLow);

        SwitchCompat switchSoundModes = findViewById(R.id.sound_high);
        applyColorToSwitch(switchSoundModes);

        SwitchCompat switchFall = findViewById(R.id.switch_Fall);
        applyColorToSwitch(switchFall);

        SwitchCompat switchHigh = findViewById(R.id.switch_High);
        applyColorToSwitch(switchHigh);

        SwitchCompat switchSoundHigh = findViewById(R.id.sound_high);
        applyColorToSwitch(switchSoundHigh);

        SwitchCompat switchRise = findViewById(R.id.switch_Rise);
        applyColorToSwitch(switchRise);

        SwitchCompat switchPredection = findViewById(R.id.switch_predection);
        applyColorToSwitch(switchPredection);

        SwitchCompat switchSoundPredection = findViewById(R.id.sound_predc);
        applyColorToSwitch(switchSoundPredection);

        SwitchCompat switchRemainder = findViewById(R.id.switch_Remaind);
        applyColorToSwitch(switchRemainder);

        SwitchCompat switchSoundRemainder = findViewById(R.id.sound_Remaind);
        applyColorToSwitch(switchSoundRemainder);

        minutesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not needed for this implementation
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Not needed for this implementation
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Check if the entered value is valid
                String minutesStr = minutesEditText.getText().toString();
                if (!minutesStr.isEmpty()) {
                    int minutes = Integer.parseInt(minutesStr);
                    if (minutes < 1 || minutes > 60) {
                        minutesEditText.setError("Minutes should be between 1 and 60");
                    } else {
                        // Clear any previous error
                        minutesEditText.setError(null);
                    }
                } else {
                    // Clear any previous error
                    minutesEditText.setError(null);
                }
            }
        });
    }

    private void applyColorToSwitch(SwitchCompat switchCompat) {
        // Change thumb color
        Drawable thumbDrawable = switchCompat.getThumbDrawable();
        thumbDrawable.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.MULTIPLY);
        switchCompat.setThumbDrawable(thumbDrawable);

        // Change track color
        Drawable trackDrawable = switchCompat.getTrackDrawable();
        trackDrawable.setColorFilter(ContextCompat.getColor(this, R.color.Gray_icon), PorterDuff.Mode.MULTIPLY);
        switchCompat.setTrackDrawable(trackDrawable);

        // Change checked track color
        switchCompat.setTrackTintList(ContextCompat.getColorStateList(this, R.color.blue_primary));
    }

    @Override
    protected void onStop() {
        super.onStop();

        String minutesStr = minutesEditText.getText().toString();

        int minutes = Integer.parseInt(minutesStr);

        if (minutes >= 1 && minutes <= 60) {
            SharedPreferences.Editor editor = getSharedPreferences("MyPrefs", MODE_PRIVATE).edit();
            editor.putInt("minutes", minutes);
            editor.apply();
        } else {

            Toast.makeText(this, "Please enter a number between 1 and 60 for minutes.", Toast.LENGTH_SHORT).show();
        }
    }
}
