package sandro_suladze_cc.schedule;


import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        final Intent i = new Intent(getApplicationContext(), MainMenuActivity.class);
        final EditText user = (EditText) findViewById(R.id.usernameTxt);
        final EditText pass = (EditText) findViewById(R.id.passTxt);
        Button logBtn = (Button) findViewById(R.id.loginBtn);
        logBtn.setTransformationMethod(null);

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String us = user.getText().toString();
                String psw = pass.getText().toString();


                switch (v.getId()) {
                    case R.id.loginBtn:
                        if (us.equals("") && psw.equals("")) {
                            Toast.makeText(getApplicationContext(),
                                    "Fill all fields", Toast.LENGTH_LONG).show();
                        } else if (!us.equals("test") || !psw.equals("123")) {
                            Toast.makeText(getApplicationContext(),
                                    "Wrong ID or password", Toast.LENGTH_LONG).show();
                        } else {
                            startActivity(i);
                        }
                        break;
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
