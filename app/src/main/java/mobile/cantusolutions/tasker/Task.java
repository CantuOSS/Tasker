package mobile.cantusolutions.tasker;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Task extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task, container, false);
    }

}
