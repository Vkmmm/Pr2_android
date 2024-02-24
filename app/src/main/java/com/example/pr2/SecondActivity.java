package com.example.pr2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.relative_layout);
        TextView textView = new TextView(this);
        textView.setTextSize(20);
        textView.setPadding(16, 16, 16, 16);
      //  textView.setText("SecondActivity");
       // setContentView(textView);
        Bundle arguments = getIntent().getExtras();
        String name = arguments.get("userName").toString();
        textView.append("\nПользователь: " + name);
        setContentView(textView);
    }
    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                closeActivityWithResult();
            }
        }, 5000);
    }
    private void closeActivityWithResult() {
        Intent intent = new Intent();
        intent.putExtra("returned_data_key", "Returned data from SecondActivity");
        setResult(RESULT_OK, intent);
        finish();
    }

}