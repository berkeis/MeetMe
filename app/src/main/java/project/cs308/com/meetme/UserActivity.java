package project.cs308.com.meetme;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bi on 10-May-16.
 */
public class UserActivity extends AppCompatActivity {

    static ArrayList<Event> eventList = new ArrayList<Event>();
    ListView notesListView;
    int longClickedItemIndex = -1;
    private final static int EDIT = 0, DELETE = 1, JOIN = 2;
    static ArrayAdapter<Event> eventAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_layout);


        notesListView = (ListView) findViewById(R.id.listView);
        eventAdapter = new EventListAdapter();



        registerForContextMenu(notesListView);
        notesListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                longClickedItemIndex = position;
                return false;
            }
        });



        final Button createBtn = (Button) findViewById(R.id.createButton);
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri imageUri= Uri.parse("android.resource://project.cs308.com.meetme/drawble/pencil_icon.png");

                Event event = new Event(0,"tedTalk","about environment",imageUri);

                eventList.add(0,event);

                notesListView.setAdapter(eventAdapter);


                eventAdapter.notifyDataSetChanged();


                //startActivity(new Intent(MainActivity.this, NoteDetailActivity.class));
            }
        });




    }




    private class EventListAdapter extends ArrayAdapter<Event> {
        public EventListAdapter() {
            super(UserActivity.this, R.layout.listview_item, eventList);
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
            ImageView ivNoteImg = (ImageView) view.findViewById(R.id.listItemImg);
            ivNoteImg.setImageURI(currentNote.getImageUri());

            return view;
        }
    }




    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,view,menuInfo);

        menu.setHeaderTitle("Event Options");
        menu.add(Menu.NONE,EDIT,menu.NONE, "Edit Event");
        menu.add(Menu.NONE,DELETE,menu.NONE, "Delete Event");
        menu.add(Menu.NONE,JOIN,menu.NONE, "Join Event");

    }




}
