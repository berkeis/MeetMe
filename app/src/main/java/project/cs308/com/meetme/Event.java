package project.cs308.com.meetme;

import android.net.Uri;

/**
 * Created by bi on 10-May-16.
 */
public class Event {
    String title;
    String description;
    private Uri imageUri;
    private  int id;



    public int getId() {
        return id;
    }

    public Uri getImageUri() {
        return imageUri;
    }


    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description= description;
    }






    public Event(int id, String title, String description, Uri imageUri){

        this.title = title;
        this.description = description;
        this.imageUri = imageUri;
    }






}
