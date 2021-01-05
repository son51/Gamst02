package com.example.gamst01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_save;
    String shared = "file"; //설정에 많이 사용됨. - 유지되어야 할것.

    @Override
    protected void onDestroy() { //앱을 종료(activity에서 벗어낫을때 실행)
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shared,0);
        SharedPreferences.Editor editor = sharedPreferences.edit();//저장할때 항상 editor로 불러와야 한다.
        String value = et_save.getText().toString(); //현재 입력된 값을 받아 value에 저장
        editor.putString("Gamst",value); //Gamst = 별명 - 부르기위한 이름(?)
        editor.commit(); //실제적인 save를 완료해라.


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_save = (EditText)findViewById(R.id.et_save);

        SharedPreferences sharedPreferences = getSharedPreferences(shared,0); //글자를 입력받아 뒤로가기를 눌러 종료해도 저장이된다.
        String value = sharedPreferences.getString("Gamst","");
        et_save.setText(value);



    }
}