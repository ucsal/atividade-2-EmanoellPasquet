package br.com.mariojp.exercise2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AnotherActivity extends MainActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_activity);
        editText = findViewById(R.id.editText);

        if (getIntent().hasExtra("USER")) {
            editText.setText(getIntent().getStringExtra("USER"));
        }
    }

    public void confirm(View v){
        getIntent().putExtra("USER", editText.getText().toString());
        setResult(200,getIntent());
        finish();
    }

    public void cancel(View v) {
        setResult(500, null);
        finish();
    }
}
