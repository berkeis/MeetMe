package project.cs308.com.meetme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by bi on 11-May-16.
 */
public class InviteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invitation_layout);


        final Button inviteBtn = (Button) findViewById(R.id.inviteButton);
        inviteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Toast.makeText(getApplicationContext(),"Invitation Sent", Toast.LENGTH_LONG).show();

                startActivity(new Intent(InviteActivity.this, UserActivity.class));
            }
        });




    }

}
