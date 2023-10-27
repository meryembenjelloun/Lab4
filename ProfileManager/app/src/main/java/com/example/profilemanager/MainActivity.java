package com.example.profilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnOpenInGoogleMaps(View view){
        TextView teamAddress = (TextView) findViewById(R.id.teamAddressTextField);
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q="+teamAddress.getText());
        Intent mapIntent=new Intent(Intent.ACTION_VIEW,gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        startActivity(mapIntent);

    }

    public void OnSetAvatarButton(View view){
        Intent intent= new Intent(getApplicationContext(),ProfileActivity.class);
        startActivityForResult(intent,0);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_CANCELED){
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }

        ImageView avatarImage = (ImageView) findViewById(R.id.avatarImage);
        String drawableName = "ic_logo_00";
        int imageId = data.getIntExtra("imageID", R.id.teamid00);

        if (imageId == R.id.teamid00) {
            drawableName = "ic_logo_00";
        } else if (imageId == R.id.teamid01) {
            drawableName = "ic_logo_01";
        } else if (imageId == R.id.teamid02) {
            drawableName = "ic_logo_02";
        } else if (imageId == R.id.teamid03) {
            drawableName = "ic_logo_03";
        } else if (imageId == R.id.teamid04) {
            drawableName = "ic_logo_04";
        } else if (imageId == R.id.teamid05) {
            drawableName = "ic_logo_05";
        }

        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
        avatarImage.setImageResource(resID);
    }
    
}