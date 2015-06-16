package com.bradleege.hellondk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.common.base.Strings;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("hellondklibrary");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView result = (TextView)findViewById(R.id.resultText);
        final EditText one = (EditText)findViewById(R.id.valueOne);
        final EditText two = (EditText)findViewById(R.id.valueTwo);

        Button button = (Button)findViewById(R.id.callNativeButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!Strings.isNullOrEmpty(one.getText().toString()) && !Strings.isNullOrEmpty(two.getText().toString())) {
                    int first = Integer.parseInt(one.getText().toString());
                    int second = Integer.parseInt(two.getText().toString());
                    result.setText(getString(first, second));
                }
            }
        });


    }

    private native void helloLog(String logThis);
    private native String getString(int value1, int value2);
}
