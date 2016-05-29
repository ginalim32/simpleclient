package com.example.peter.simpleclient;

import android.widget.TextView;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import android.os.AsyncTask;
/**
 * Created by peter on 28/5/2016.
 */
public class SendData extends AsyncTask<String,Void,Void> {
    private Socket client;
    private PrintWriter printwriter;

    @Override
    protected Void doInBackground (String... params) {
    //    setContentView(R.layout.activity_simple_client);
        try {

            client = new Socket("192.168.0.15", 56789);  //connect to server
            //((TextView)findViewById(R.id.textView)).setText(String.valueOf(client.isConnected()));
            //client);
            printwriter = new PrintWriter(client.getOutputStream(),true);
            printwriter.write(params[0]);  //write the message to output stream

            printwriter.flush();
            printwriter.close();
            client.close();   //closing the connection

        } catch (UnknownHostException e) {
//            ((TextView)findViewById(R.id.textView)).setText(e.toString());
            e.printStackTrace();
        } catch (IOException e) {
  //          ((TextView)findViewById(R.id.textView)).setText(e.toString());
            e.printStackTrace();
        }
        return null;
    }

}
