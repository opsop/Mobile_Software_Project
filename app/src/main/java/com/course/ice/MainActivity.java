package com.course.ice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button login, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button)findViewById(R.id.login);
        signup = (Button)findViewById(R.id.signup);

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                EditText e1 = (EditText)findViewById(R.id.input_ID);
                EditText e2 = (EditText)findViewById(R.id.input_PW);
                String ID = e1.getText().toString();
                String PW = e2.getText().toString();

                ArrayList<String[]> ID_PW_list = new ArrayList<String[]>();

                String[] columns = new String[]{"customer_id", "customer_pw"};
                Cursor c = getContentResolver().query(MyContentProvider.CONTENT_URI, columns, null, null, null, null);

                if(c != null) {
                    while(c.moveToNext()) {
                        String id = c.getString(0);
                        String pw = c.getString(1);
                        ID_PW_list.add(new String[]{id,pw});
                        //c.close();
                    }
                }

                if(check_ID_PW(ID_PW_list, ID, PW)) {
                    //로그인 성공
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("ID", ID);
                    startActivity(intent);
                    String message = ID + "님, 환영합니다!";
                    Toast.makeText(getBaseContext(), message, Toast.LENGTH_LONG).show();
                }

                else {
                    //로그인 실패
                    Toast.makeText(getBaseContext(), "로그인 실패!", Toast.LENGTH_LONG).show();
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });

    }

    public boolean check_ID_PW(ArrayList<String[]> a1, String ID, String PW) {
        for(int i = 0; i<a1.size(); i++) {
            if(a1.get(i)[0].equals(ID) & a1.get(i)[1].equals(PW)) {
                return true;
            }
        }
        return false;
    }
}