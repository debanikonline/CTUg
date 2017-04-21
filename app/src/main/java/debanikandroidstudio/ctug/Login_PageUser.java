package debanikandroidstudio.ctug;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login_PageUser extends AppCompatActivity
{
    Button login,register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__page_user);
        login=(Button)findViewById(R.id.UserLoginButtonID);
        register=(Button)findViewById(R.id.UserPageNewUserButtonID);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                //----------after userid and password check use the following intent.
                Intent welcomeuser=new Intent(getApplicationContext(),WelcomeUSER_Navi.class);
                startActivity(welcomeuser);
            }
        });
        register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //this will navigate to the user registration page {NewUserRegistrationPage}
                Intent newuserregistration=new Intent(getApplicationContext(),NewUserRegisterPage.class);
                startActivity(newuserregistration);
            }
        });
    }
}
