package com.example.myapplicationheipox;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import com.example.myapplicationheipox.activity_edit_profile;
import com.example.myapplicationheipox.profileActivity;
import com.example.myapplicationheipox.activity_notification;
import com.example.myapplicationheipox.activity_setting;
import com.example.myapplicationheipox.activity_sharing;

public class profileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);
        AppCompatButton editProfileButton = findViewById(R.id.edit_profile_button);
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profileActivity.this, activity_edit_profile.class);
                startActivity(intent);
            }
        });
        LinearLayout settingLayout = findViewById(R.id.setting_layout);
        settingLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profileActivity.this, activity_setting.class);
                startActivity(intent);
            }
        });



        LinearLayout sharingLayout = findViewById(R.id.sharing_layout);
        sharingLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profileActivity.this, activity_sharing.class);
                startActivity(intent);
            }
        });

        LinearLayout notificationLayout = findViewById(R.id.notification_layout);
        notificationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profileActivity.this, activity_notification.class);
                startActivity(intent);
            }
        });




    }
}