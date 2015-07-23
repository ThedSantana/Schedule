package sandro_suladze_cc.schedule;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainMenuActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button workerList = (Button) findViewById(R.id.workerList);
        Button scheduleBtn = (Button) findViewById(R.id.scheduleBtn);
        workerList.setTransformationMethod(null);
        scheduleBtn.setTransformationMethod(null);

        scheduleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sch = new Intent(getApplicationContext(), scheduleDB.class);
                startActivity(sch);

            }
        });

        workerList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent wList = new Intent(getApplicationContext(), geoWorkers.class);
                startActivity(wList);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
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
