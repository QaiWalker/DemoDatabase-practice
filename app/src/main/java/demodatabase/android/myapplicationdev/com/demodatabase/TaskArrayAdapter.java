package demodatabase.android.myapplicationdev.com.demodatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskArrayAdapter extends ArrayAdapter {

    ArrayList<Task> al;
    Context context;
    int resource;
    TextView tvID, tvDesc, tvDate;

    public TaskArrayAdapter(Context context,int resource, ArrayList<Task> objects){
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.al = objects;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(resource, parent, false);

        //Assign TextView variables (add rowView in front)


        //Get Position for ArrayList
        //Set text for TextView using the Get Methods in Task

        return rowView;

    }
}
