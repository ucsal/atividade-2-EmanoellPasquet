package br.com.mariojp.exercise2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button btn;
    private String user = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        btn=findViewById(R.id.btnChange);
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    public void changeUser(View v){
        Intent intent=new Intent(this,AnotherActivity.class);
        intent.putExtra("USER", user);
        startActivityForResult(intent, 200);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(data.hasExtra("USER")){
            if(data.getStringExtra("USER").trim().isEmpty()){
                user="";
                textView.setText("Hello!");
            }else{
                user=data.getStringExtra("USER");
                textView.setText("Hello "+user+"!");
            }
        }
    }
}