package msalmani.leitner;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import classes.app;
import classes.dbConnector;

public class BoxActivity extends AppCompatActivity {

    ListView listView;
    List<String> list;
    ArrayAdapter<String> adapter;
    dbConnector db;
    int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        db = new dbConnector(this , app.main.DBNAME , null , 1 );
        list = new ArrayList<String>();

        listView = (ListView)findViewById(R.id.cardsList) ;
        adapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1 , list);
        listView.setAdapter(adapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//
//                // TODO Auto-generated method stub
//
//                // Getting listview click value into String variable.
//                String TempListViewClickedValue = list[position].toString();
//
//                Intent intent = new Intent(BoxActivity.this, CardActivity.class);
//
//                // Sending value to another activity using intent.
//                intent.putExtra("ListViewClickedValue", TempListViewClickedValue);
//
//                startActivity(intent);
//
//
////                Intent myIntent = new Intent(BoxActivity.this, CardActivity.class);
////                BoxActivity.this.startActivity(myIntent);
//            }
//        });




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onResume() {

        String query = "SELECT front FROM card";
        list.clear();

        Cursor c = null;
        c = db.select(query);

        while (c.moveToNext()){
            String item = c.getString(c.getColumnIndex("front"));
            list.add(item);
        }

        adapter.notifyDataSetChanged();

        super.onResume();
    }
}
