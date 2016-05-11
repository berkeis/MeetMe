package project.cs308.com.meetme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by bi on 11-May-16.
 */
public class EventHandler extends AppCompatActivity {
    private String[] arraySpinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventcreation_layout);

        this.arraySpinner = new String[] {
                "Individual Meetings", "Group Meetings"
        };
        Spinner s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, arraySpinner);
        s.setAdapter(adapter);

        Button submitBtn = (Button) findViewById(R.id.submitButton);
        submitBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(EventHandler.this, UserActivity.class));


            }
        });



        }






}
