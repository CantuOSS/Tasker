package mobile.cantusolutions.tasker;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Task extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    ArrayList<Task_element> tasks;
    ListView listView;
    public Task() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Task newInstance(int sectionNumber) {
        Task fragment = new Task();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this.getContext());
        databaseAccess.open();
        tasks = databaseAccess.getTasks();
        databaseAccess.close();
        TaskAdapter adapter = new TaskAdapter(this.getContext(), tasks);
        listView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        upd();
    }

    public void upd(){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this.getContext());
        databaseAccess.open();
        ArrayList<Task_element> nt = databaseAccess.getTasks();
        databaseAccess.close();
        tasks.clear();
        for (Task_element t : nt){
            tasks.add(t);
        }
        TaskAdapter adapter = (TaskAdapter)listView.getAdapter();
        adapter.notifyDataSetChanged();

    }

}
