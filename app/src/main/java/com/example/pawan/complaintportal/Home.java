package com.example.pawan.complaintportal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Home extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    TextView log_out,submit_problem,entry_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        log_out=(TextView) findViewById(R.id.log_out);
        entry_no=(TextView) findViewById(R.id.entry_no);
        submit_problem=(TextView) findViewById(R.id.submit_problem);
        log_out.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                //myIntent.putExtra("key", value); //Optional parameters
                startActivity(myIntent);

            }
        });
        submit_problem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent myIntent = new Intent(getApplicationContext(), Complaint.class);
                //myIntent.putExtra("key", value); //Optional parameters
                startActivity(myIntent);

            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        expListView.setIndicatorBounds(0, 20);
        // setting list adapter
        expListView.setAdapter(listAdapter);
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

      /* You must make use of the View v, find the view by id and extract the text as below*/
                TextView tv = (TextView) v.findViewById(R.id.lblListItem);

                String data = tv.getText().toString();
                if (data == "Carpentor problem") {
                    Intent intent = new Intent(getApplicationContext(), Problems.class);
                    intent.putExtra("type","Carpentor problem" );
                    startActivity(intent);
                }
                if (data == "Electrical Problem") {
                    Intent intent = new Intent(getApplicationContext(), Problems.class);
                    intent.putExtra("type","Electrical problem" );
                    startActivity(intent);
                }
                if (data == "Network Problem") {
                    Intent intent = new Intent(getApplicationContext(), Problems.class);
                    intent.putExtra("type","Network problem" );
                    startActivity(intent);
                }
                Toast.makeText(getApplicationContext(), data, Toast.LENGTH_SHORT).show();

                return true;  // i missed this
            }
        });
        TextView hstcomplaint=(TextView) findViewById(R.id.host_complaint);
        hstcomplaint.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent myIntent = new Intent(getApplicationContext(), Problems.class);
                //myIntent.putExtra("key", value); //Optional parameters
                myIntent.putExtra("type","Hostel problem" );
                startActivity(myIntent);

            }
        });
        TextView instcomplaint=(TextView) findViewById(R.id.inst_complaint);
        instcomplaint.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent myIntent = new Intent(getApplicationContext(), Problems.class);
                //myIntent.putExtra("key", value); //Optional parameters
                myIntent.putExtra("type","Institute problem" );
                startActivity(myIntent);

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.icon){
            return true;}

        return super.onOptionsItemSelected(item);
    }
    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("individual Complaints");
        // Adding child data
        List<String> type = new ArrayList<String>();
        type.add("Carpentor problem");
        type.add("Electrical Problem");
        type.add("Network Problem");
        listDataChild.put(listDataHeader.get(0), type); // Header, Child data
    }

}
