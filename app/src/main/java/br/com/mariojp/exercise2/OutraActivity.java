package br.com.mariojp.exercise2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class OutraActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outra);
        editText = findViewById(R.id.editText);

        if (getIntent().hasExtra("USER")) {
            editText.setText(getIntent().getStringExtra("USER"));
        }
    }

    public void btnConfirmar(View view){
        getIntent().putExtra("USER", editText.getText().toString());
        setResult(200,getIntent());
        finish();
    }

    public void btnCancelar(View view) {
        setResult(500, null);
        finish();
    }
}
