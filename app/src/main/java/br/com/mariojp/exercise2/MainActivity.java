package br.com.mariojp.exercise2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button btnTrocar;
    private String user = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        btnTrocar=findViewById(R.id.btnTrocar);
        if(savedInstanceState != null) {
            user = savedInstanceState.getString("USER", "");
        }
        if(!user.isEmpty()){
            textView.setText("Oi, "+user+"!");
        }

    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) { ;
        outState.putString("USER", user);
        super.onSaveInstanceState(outState);
    }

    public void trocarUsuario(View view){
        Intent intent = new Intent(this, OutraActivity.class);
        intent.putExtra("USER",user);
        startActivityForResult(intent, 200);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(data.hasExtra("USER")){
            if(data.getStringExtra("USER").trim().isEmpty()){
                user="";
                textView.setText("Oi!");
            }else{
                user=data.getStringExtra("USER");
                textView.setText("Oi "+user+"!");
            }
        }
    }
}