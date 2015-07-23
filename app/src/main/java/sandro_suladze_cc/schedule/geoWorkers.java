package sandro_suladze_cc.schedule;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

import sandro_suladze_cc.schedule.Adapters.WorkersAdapter;


public class geoWorkers extends ActionBarActivity {
    WorkersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_workers);

        ArrayList<GeoWorkersGetter> listViewData = getGeoCClistData();
        adapter = new WorkersAdapter(this, listViewData);

        ListView listView = (ListView) findViewById(R.id.listview);

        listView.setAdapter(adapter);

        registerForContextMenu(listView);



    }

    private ArrayList<GeoWorkersGetter> getGeoCClistData(){
        ArrayList<GeoWorkersGetter> list = new ArrayList<>();

        for(int i = 0; i < ListOfWorkers.names.length; i++){
            GeoWorkersGetter cc = new GeoWorkersGetter(ListOfWorkers.names[i], ListOfWorkers.phNumbers[i],
                    ListOfWorkers.images[i]);
            list.add(cc);
        }
        return list;
    }

    protected static final int CONTEXTMENU_OPTION1 = 1;
    protected static final int CONTEXTMENU_OPTION2 = 2;
    protected static final int CONTEXTMENU_OPTION3 = 3;

    String names;
    String numbers;
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);



        AdapterContextMenuInfo info = (AdapterContextMenuInfo) menuInfo;
        View TargetV = (View) info.targetView;
        names = (String)((TextView) TargetV.findViewById(R.id.name)).getText();




        menu.setHeaderTitle(names);


        menu.add(Menu.NONE, CONTEXTMENU_OPTION1, 0, "Call");
        menu.add(Menu.NONE, CONTEXTMENU_OPTION2, 1, "SMS");
        menu.add(Menu.NONE, CONTEXTMENU_OPTION3, 2, "Mail");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {


        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();



        View TargetV = (View) menuInfo.targetView;

        numbers = (String)((TextView) TargetV.findViewById(R.id.number)).getText();


        switch (item.getItemId()) {

            case CONTEXTMENU_OPTION1:
                //call
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+numbers));
                startActivity(callIntent);
                break;

            case CONTEXTMENU_OPTION2:
                //sms
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setData(Uri.parse("sms:"+numbers));
                startActivity(smsIntent);
                break;

            case CONTEXTMENU_OPTION3:
                // mail
                Toast.makeText(getApplicationContext(), "Coming soon... ", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_geo_workers, menu);
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
