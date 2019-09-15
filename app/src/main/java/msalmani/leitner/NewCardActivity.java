package msalmani.leitner;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import classes.app;
import classes.dbConnector;


public class NewCardActivity extends AppCompatActivity {

    EditText front , back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_card);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        front = (EditText)findViewById(R.id.frontTxt);
        back = (EditText)findViewById(R.id.backTxt);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setImageResource(R.drawable.ic_check_white);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//
//            }
//        });
    }

    public void newCard(View view){

        if (front.getText().toString().trim().equals("") || back.getText().toString().trim().equals("")){
            Toast.makeText(getApplicationContext() , "Please fill all fields" , Toast.LENGTH_SHORT).show();
            return;
        }

        dbConnector db = new dbConnector(this , app.main.DBNAME , null , 1);

        ContentValues values = new ContentValues();
        values.put(app.db.FRONT , front.getText().toString());
        values.put(app.db.BACK, back.getText().toString());

        Boolean status = db.insert(app.db.TABLE , values);
        if (status == true){
            finish();
        }
        else Toast.makeText(getApplicationContext() , "Couldn't save to database" , Toast.LENGTH_SHORT).show();

    }

}
