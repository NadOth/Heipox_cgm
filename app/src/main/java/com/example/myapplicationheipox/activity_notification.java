package com.example.myapplicationheipox;

import androidx.appcompat.widget.SwitchCompat;
import android.os.Bundle;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import android.graphics.PorterDuff;
import androidx.appcompat.app.AppCompatActivity;

public class activity_notification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        // Find each SwitchCompat directly using its ID and apply color changes
        SwitchCompat switchAll = findViewById(R.id.switch_Notf);
        applyColorToSwitch(switchAll);

        SwitchCompat switchLow1 = findViewById(R.id.switch_Low);
        applyColorToSwitch(switchLow1);

        SwitchCompat soundLow = findViewById(R.id.sound_low);
        applyColorToSwitch(soundLow);

        SwitchCompat switchfall = findViewById(R.id.switch_Fall);
        applyColorToSwitch(switchfall);

        SwitchCompat switchhigh = findViewById(R.id.switch_High);
        applyColorToSwitch(switchhigh);

        SwitchCompat soundhigh = findViewById(R.id.sound_high);
        applyColorToSwitch(soundhigh);

        SwitchCompat switchrise = findViewById(R.id.switch_Rise);
        applyColorToSwitch(switchrise);

        SwitchCompat switchpredection = findViewById(R.id.switch_predection);
        applyColorToSwitch(switchpredection);

        SwitchCompat soundpredct = findViewById(R.id.sound_predc);
        applyColorToSwitch(soundpredct);

        SwitchCompat switchremaind = findViewById(R.id.switch_Remaind);
        applyColorToSwitch(switchremaind);

        SwitchCompat soundremaind = findViewById(R.id.sound_Remaind);
        applyColorToSwitch(soundremaind);
    }

    private void applyColorToSwitch(SwitchCompat switchCompat) {
        // Change thumb color
        Drawable thumbDrawable = switchCompat.getThumbDrawable();
        thumbDrawable.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.MULTIPLY);
        switchCompat.setThumbDrawable(thumbDrawable);

        // Change track color
        Drawable trackDrawable = switchCompat.getTrackDrawable();
        trackDrawable.setColorFilter(ContextCompat.getColor(this, R.color.blue_primary), PorterDuff.Mode.MULTIPLY);
        switchCompat.setTrackDrawable(trackDrawable);
    }
}
