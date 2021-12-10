package com.course.ice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SignUp extends AppCompatActivity {

    Button back, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        back = (Button)findViewById(R.id.back);
        register = (Button)findViewById(R.id.register);

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, MainActivity.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, MainActivity.class);
                EditText e1 = (EditText)findViewById(R.id.register_ID);
                EditText e2 = (EditText)findViewById(R.id.register_PW);
                EditText e3 = (EditText)findViewById(R.id.name);
                EditText e4 = (EditText)findViewById(R.id.phone);

                String ID = e1.getText().toString();
                String PW = e2.getText().toString();
                String name = e3.getText().toString();
                String phone = e4.getText().toString();

                ID = ID.trim();
                PW = PW.trim();
                name = name.trim();

                List<String> ID_list = new ArrayList<String>();

                String[] columns = new String[]{"customer_id"};
                Cursor c = getContentResolver().query(MyContentProvider.CONTENT_URI, columns, null, null, null, null);

                if(c != null) {
                    while(c.moveToNext()) {
                        String id = c.getString(0);
                        ID_list.add(id);
                        //c.close();
                    }
                }

                if(ID.getBytes().length <= 0){
                    //아이디 미입력
                    Toast.makeText(SignUp.this, "아이디를 입력해주세요.", Toast.LENGTH_LONG).show();

                }
                else if(PW.getBytes().length <= 0){
                    //비밀번호 미입력
                    Toast.makeText(SignUp.this, "비밀번호를 입력해주세요.", Toast.LENGTH_LONG).show();
                }
                else if(name.getBytes().length <= 0){
                    //이름 미입력
                    Toast.makeText(SignUp.this, "이름을 입력해주세요.", Toast.LENGTH_LONG).show();

                }
                else if(ID_list.contains(ID)){
                    //아이디 중복
                    Toast.makeText(SignUp.this, "중복된 아이디입니다.", Toast.LENGTH_LONG).show();

                }
                else{
                    //회원 가입 성공
                    ContentValues addValues = new ContentValues();
                    addValues.put(MyContentProvider.CUSTOMER_ID, ID);
                    addValues.put(MyContentProvider.CUSTOMER_PW, PW);
                    addValues.put(MyContentProvider.NAME, name);
                    addValues.put(MyContentProvider.PHONE, phone);
                    getContentResolver().insert(MyContentProvider.CONTENT_URI, addValues);
                    Toast.makeText(getBaseContext(),
                            "회원가입 완료!", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }

            }
        });
    }


}