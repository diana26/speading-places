package com.example.spreadingplaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button button = findViewById(R.id.button);
    EditText editText = findViewById(R.id.editText);

    private int[] users = {1, 2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), SpreadActivity.class);
                if (isValidUser(editText.getText().toString()))
                    startActivity(intent);
                else {
                    editText.setText("");
                    Toast.makeText(getApplicationContext(), "Invalid ID",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidUser(String str) {
        return Arrays.asList(users).contains(Integer.parseInt(str));
    }
}
