package demodatabase.android.myapplicationdev.com.demodatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Initiate Variables
    // Including ArrayList, ArrayAdapter and ListView

    Button btnInsert, btnGetTasks;
    TextView tvResults;
    ArrayList<Task> al;
    ArrayAdapter aa;
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnGetTasks = (Button)findViewById(R.id.btnGetTasks);
        tvResults = (TextView)findViewById(R.id.tvResults);
        lv = (ListView)findViewById(R.id.lv);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object
                // Use the Insert Method
                // Close DBHelper

            }
        });
        btnGetTasks.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object
                // Use Get Task Content Method (ArrayList)
                // Close DBHelper
                // Create empty String Variable
                // Create For Loop
                // Use empty String Variable in For Loop
                // Set text in TextView
                // Create new DBHelper object
                // Assign ArrayList<Task> to Get Task Method
                // Close DBHelper
                // Create New ArrayAdapter
                // Assign ListView to ArrayAdapter

            }
        });

    }
}
