package com.example.intentslearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendMessageActivity extends AppCompatActivity {

    private Button buttonSendMessage;
    private EditText editTextMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        setOnCLickListeners();
    }

    private void setOnCLickListeners() {
        buttonSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editTextMessage.getText().toString();
                //create an intent
                //the arguments are where you are coming from (this)
                //and where you are going (TargetActivity.class)
                Intent intentSendMessage = new Intent(SendMessageActivity.this, RecieveMessageActivity.class);
                //package the text into the intent
                intentSendMessage.putExtra("themessage", message);
                //start the new activity
                startActivity(intentSendMessage);
            }
        });
    }

    private void wireWidgets() {
        buttonSendMessage = findViewById(R.id.button_sendmessage_send);
        editTextMessage = findViewById(R.id.editText_sendmessage_msg);
    }
}
