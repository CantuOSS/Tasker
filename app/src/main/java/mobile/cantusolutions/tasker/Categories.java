package mobile.cantusolutions.tasker;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Categories#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Categories extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    public Categories() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Categories newInstance(int sectionNumber) {
        Categories fragment = new Categories();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false);
    }

}
