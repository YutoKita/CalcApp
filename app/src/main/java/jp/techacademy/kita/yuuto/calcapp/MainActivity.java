package jp.techacademy.kita.yuuto.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText1;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        mEditText1 = (EditText) findViewById(R.id.editText1) ;
        mEditText2 = (EditText) findViewById(R.id.editText2) ;

    }

    @Override
    public void onClick(View v) {

        //初期化
        double num1 = 0;
        double num2 = 0;

        try {
            //mEditText1.getText().toString()でmEditText1の文字列を取得。Double.parseDoubleで文字列型からdouble型に変換
            num1 = Double.parseDouble(mEditText1.getText().toString());
            num2 = Double.parseDouble(mEditText2.getText().toString());
        }catch (Exception e){
            Toast.makeText(this, "数値を入力してください", Toast.LENGTH_SHORT).show();
            return;
        }

        double result = 0;

        if(v.getId()==R.id.button1){
            result = num1 + num2;
        }else if(v.getId()==R.id.button2){
            result = num1 - num2;
        }else if(v.getId()==R.id.button3){
            result = num1 * num2;
        }else if(v.getId()==R.id.button4) {
            if(num2 == 0){
                Toast.makeText(this, "0では割れません", Toast.LENGTH_SHORT).show();
                return;
            }
            result = num1 / num2;
        }

        //intent.putExtraはintentに処理を渡す
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("VALUE1", result);
        startActivity(intent);

    }
}
