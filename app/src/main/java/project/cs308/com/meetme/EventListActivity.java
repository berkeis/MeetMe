package project.cs308.com.meetme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by bi on 11-May-16.
 */
public class EventListActivity  extends AppCompatActivity {

    static ArrayList<Event> eventList = new ArrayList<Event>();
    ListView eventsListView;
    static ArrayAdapter<Event> eventAdapter;
    private final static int INVITE = 0, DELETE = 1;
    int longClickedItemIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventlist_layout);


        eventsListView = (ListView) findViewById(R.id.listView);


        registerForContextMenu(eventsListView);
        eventsListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                longClickedItemIndex = position;
                return false;
            }
        });


        Event event;
        event = new Event(0,"Gelecek Konusmasi","Cok onemli seyler hakkinda konusulacak");
        eventList.add(event);
        event = new Event(1,"Cevre Konusmasi","Cevre kirliligi hakkinda");
        eventList.add(event);


        eventAdapter = new EventListAdapter();

        eventsListView.setAdapter(eventAdapter);
        eventAdapter.notifyDataSetChanged();




    }





    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()){
            case INVITE:

                startActivity(new Intent(EventListActivity.this, InviteActivity.class));

                break;
            case DELETE:

                Toast.makeText(getApplicationContext(),"Event Deleted!", Toast.LENGTH_LONG).show();

                break;
        }

        return super.onContextItemSelected(item);
    }



    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,view,menuInfo);

        menu.setHeaderTitle("Event Options");
        menu.add(Menu.NONE,INVITE,menu.NONE, "Invite attendee");
        menu.add(Menu.NONE,DELETE,menu.NONE, "Delete event");
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
