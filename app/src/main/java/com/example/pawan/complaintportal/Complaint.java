package com.example.pawan.complaintportal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Complaint extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    TextView hstcomplaint,instcomplaint;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        expListView = (ExpandableListView) findViewById(R.id.lvExp1);

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
                    Intent intent = new Intent(getApplicationContext(), Submit_complaint.class);
                    startActivity(intent);
                }
                if (data == "Electrical Problem") {
                    Intent intent = new Intent(getApplicationContext(), Submit_complaint.class);
                    startActivity(intent);
                }
                if (data == "Network Problem") {
                    Intent intent = new Intent(getApplicationContext(), Submit_complaint.class);
                    startActivity(intent);
                }
                Toast.makeText(getApplicationContext(), data, Toast.LENGTH_SHORT).show();

                return true;  // i missed this
            }
        });
        hstcomplaint=(TextView) findViewById(R.id.sub_host);
        hstcomplaint.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent myIntent = new Intent(getApplicationContext(), Submit_complaint.class);
                //myIntent.putExtra("key", value); //Optional parameters
                startActivity(myIntent);

            }
        });
        instcomplaint=(TextView) findViewById(R.id.sub_inst);
        instcomplaint.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent myIntent = new Intent(getApplicationContext(), Submit_complaint.class);
                //myIntent.putExtra("key", value); //Optional parameters
                startActivity(myIntent);

            }
        });

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
        listDataChild.put(listDataHeader.get(0), type);
    }

}
