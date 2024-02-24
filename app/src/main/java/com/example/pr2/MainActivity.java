package com.example.pr2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pr2.databinding.ActivityMainBinding;
import com.example.pr2.databinding.ConstraintLayoutBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyApp";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*        ConstraintLayoutBinding binding = ConstraintLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());*/
        setContentView(R.layout.linear_layout);
         ImageView imageView = findViewById(R.id.lin_image1);
         Button buttonClick = findViewById(R.id.lin_button1);
         Button button1Click = findViewById(R.id.button4);
        Intent intent = new Intent(this, SecondActivity.class);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Кнопка нажата (программно)");
            }
        };
           button1Click.setOnClickListener(listener);

      /*  binding.textView2.setText(R.string.goodbay_message);
        binding.imageView7.setImageResource(R.drawable.icons8__app);
        binding.consButton.setOnClickListener(view -> onButtonClick(view));
        binding.button2.setOnClickListener(view -> {
            Log.d(TAG, "Кнопка нажата (программно)");
        });*/
     }
    public void onButtonClick(View view)
    {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("userName", "Mosina Viktoriia");
        startActivity(intent);
        Log.d(TAG, "Кнопка нажата (декларативно)");
        mStartForResult.launch(intent);
    }
    private ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        // Обработка успешного результата от второй Activity
                        Intent data = result.getData();
                        String returnedData = data.getStringExtra("returned_data_key");
                        Log.d(TAG, "Received data from SecondActivity: " + returnedData);
                    } else {
                        Log.d(TAG, "SecondActivity returned with result code: " + result.getResultCode());
                    }
                }
            });

}