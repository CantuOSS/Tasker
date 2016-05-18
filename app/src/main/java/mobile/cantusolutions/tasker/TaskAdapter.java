package mobile.cantusolutions.tasker;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DCantu on 17/05/16.
 */
public class TaskAdapter extends ArrayAdapter<Task_element> {
    public TaskAdapter(Context context, ArrayList<Task_element> tasks) {
        super(context, 0, tasks);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Task_element task = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.task_list_layout, parent, false);
        }
        // Lookup view for data population
        TextView name = (TextView) convertView.findViewById(R.id.taskName);
        TextView desc = (TextView) convertView.findViewById(R.id.taskDesc);
        TextView date = (TextView) convertView.findViewById(R.id.taskDate);
        TextView remind = (TextView) convertView.findViewById(R.id.taskRemind);
        TextView progress = (TextView) convertView.findViewById(R.id.taskProgress);
        TextView category = (TextView) convertView.findViewById(R.id.taskCategory);
        // Populate the data into the template view using the data object
        name.setText(task.getName());
        desc.setText(task.getDesc());
        date.setText(task.getDate());
        remind.setText(String.valueOf(task.getRemind()));
        progress.setText(String.valueOf(task.getProgress()));
        category.setText(String.valueOf(task.getCategory()));
        // Return the completed view to render on screen
        return convertView;
    }
}
