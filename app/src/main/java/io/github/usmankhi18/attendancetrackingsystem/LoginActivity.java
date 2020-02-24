package io.github.usmankhi18.attendancetrackingsystem;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class LoginActivity extends Activity {
    LinearLayout Login;
    EditText user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Login = (LinearLayout) findViewById(R.id.login);
        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);

        Login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        login();
                    }
                }
        );

    }

    private void login(){
        if(!user.getText().toString().isEmpty() && !pass.getText().toString().isEmpty()){
            if(user.getText().toString().equalsIgnoreCase("Admin")) {
                Intent in = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(in);
                finish();
            }
            else if(user.getText().toString().equalsIgnoreCase("Student")){
                Intent in = new Intent(LoginActivity.this, StudentDashboardActivity.class);
                startActivity(in);
                finish();
            }
            else if(user.getText().toString().equalsIgnoreCase("Teacher")){
                Intent in = new Intent(LoginActivity.this, TeacherDashboardActivity.class);
                startActivity(in);
                finish();
            }
            else{
                Toast.makeText(getApplicationContext(),"Wrong Credentials!!",Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(getApplicationContext(),"Please Enter Complete Details",Toast.LENGTH_LONG).show();
        }
    }
}
