package com.algowire.perfecto;

import android.content.Context;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import developer.shivam.perfecto.OnNetworkRequest;
import developer.shivam.perfecto.Perfecto;

public class MainActivity extends AppCompatActivity {

    private Context mContext = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Perfecto.with(mContext)
                .fromUrl("http://www.google.com")
                .ofTypeGet()
                .connect(new OnNetworkRequest() {

                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onSuccess(String response) {
                        Log.d("Response", response);
                    }

                    @Override
                    public void onFailure(int responseCode, String responseMessage, String errorStream) {
                        Log.d("Response code", String.valueOf(responseCode));
                        Log.d("Response message", responseMessage);
                        Log.d("Error stream", errorStream);
                    }
                });
    }
}