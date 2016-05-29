package com.example.peter.simpleclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SimpleClient extends AppCompatActivity {
    private Socket client;
    private PrintWriter printwriter;
    private EditText textField;
    private Button button;
    private String messsage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_client);
        textField = (EditText) findViewById(R.id.editText1); //reference to the text field
        button = (Button) findViewById(R.id.button1);   //reference to the send button

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                messsage = textField.getText().toString(); //get the text message on the text field
                textField.setText("");      //Reset the text field to blank

                new SendData().execute(new String [] {messsage});
            }
        });
    }
}
