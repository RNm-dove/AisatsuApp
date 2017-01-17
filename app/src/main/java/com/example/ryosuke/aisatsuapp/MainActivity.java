package com.example.ryosuke.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        text = (TextView) findViewById(R.id.text);
    }

    @Override
    public void onClick(View v){
        showTimePickerDialog();
    }

    private void showTimePickerDialog(){
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI_PARTS", String.valueOf(hourOfDay) + ";" + String.valueOf(minute));
                        if (2 <= hourOfDay && 10 > hourOfDay){
                            text.setText("おはよう");
                        } else if(10 <= hourOfDay && hourOfDay <18){
                            text.setText("こんにちは");
                        } else {
                            text.setText("こんばんは");
                        }
                    }
                },

                13,//初期値（時間）
                0,//初期値(ふん)
                true);
        timePickerDialog.show();
    }

}

