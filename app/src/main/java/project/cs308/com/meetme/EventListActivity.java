package project.cs308.com.meetme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bi on 11-May-16.
 */
public class EventListActivity  extends AppCompatActivity {

    static ArrayList<Event> eventList = new ArrayList<Event>();
    ListView eventsListView;
    static ArrayAdapter<Event> eventAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_layout);






    }









    private class EventListAdapter extends ArrayAdapter<Event> {
        public EventListAdapter() {
            super(EventListActivity.this, R.layout.listview_item, eventList);
        }

        @Override
        public View getView(int pos, View view, ViewGroup parent) {
            if (view == null)
                view = getLayoutInflater().inflate(R.layout.listview_item, parent, false);

            Event currentNote = eventList.get(pos);

            TextView title = (TextView) view.findViewById(R.id.listItemTitle);
            title.setText(currentNote.getTitle());
            TextView description = (TextView) view.findViewById(R.id.listItemBody);
            description.setText((currentNote.getDescription()));

            return view;
        }
    }





    }
