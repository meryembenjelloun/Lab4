package com.example.profilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
    public void SetTeamIcon(View view){
        Intent returnIntent=new Intent();
        ImageView selectedImage =(ImageView) view;
        returnIntent.putExtra("imageID",selectedImage.getId());
        setResult(RESULT_OK,returnIntent);
        finish();
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data){
        if(resultCode==RESULT_CANCELED)return;
        ImageView avatarImage= (ImageView) findViewById(R.id.avatarImage);
        String drawableName="ic_logo_00";
        switch (data.getIntExtra("imageID",R.id.teamid00)){
            case R.id.teamid00;
            drawableName="ic_logo_00";
            break;
        }
    }

}