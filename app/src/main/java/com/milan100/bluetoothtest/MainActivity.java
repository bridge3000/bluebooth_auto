package com.milan100.bluetoothtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.suitebuilder.TestMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    BluetoothArduino mBlue = BluetoothArduino.getInstance("HC-06");
    TextView txtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtStatus = (TextView)findViewById(R.id.txtStatus);

        boolean connResult = mBlue.Connect();
        if(connResult)
        {
            txtStatus.setText("连接成功");
        }
        else
        {
            txtStatus.setText("连接失败");
        }

        Button btnForward = (Button) findViewById(R.id.btnForward);
        btnForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBlue.SendMessage("f");
                txtStatus.setText(mBlue.getLastMessage());
            }
        });

        Button btnLeft = (Button) findViewById(R.id.btnLeft);
        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBlue.SendMessage("l");
                txtStatus.setText(mBlue.getLastMessage());
            }
        });

        Button btnRight = (Button) findViewById(R.id.btnRight);
        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBlue.SendMessage("r");
                txtStatus.setText(mBlue.getLastMessage());
            }
        });

        Button btnBrake = (Button) findViewById(R.id.btnBrake);
        btnBrake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBlue.SendMessage("b");
                txtStatus.setText(mBlue.getLastMessage());
            }
        });

        Button btnForceBrake = (Button) findViewById(R.id.btnForceBrake);
        btnForceBrake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBlue.SendMessage("s");
                txtStatus.setText(mBlue.getLastMessage());
            }
        });

        Button btnLight = (Button) findViewById(R.id.btnLight);
        btnLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBlue.SendMessage("i");
                txtStatus.setText(mBlue.getLastMessage());
            }
        });


    }
}
