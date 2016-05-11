package project.cs308.com.meetme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by bi on 10-May-16.
 */
public class UserActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_layout);








        final Button createBtn = (Button) findViewById(R.id.createButton);
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                startActivity(new Intent(UserActivity.this, EventHandler.class));
            }
        });


        final Button eventsBtn = (Button) findViewById(R.id.eventsButton);
        eventsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                startActivity(new Intent(UserActivity.this, EventListActivity.class));
            }
        });




    }






}
