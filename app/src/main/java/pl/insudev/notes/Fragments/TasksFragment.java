package pl.insudev.notes.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pl.insudev.notes.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TasksFragment extends Fragment {

    public TasksFragment() {
        // Required empty public constructor
    }

    public static TasksFragment newInstance(int pos, String title) {

        Bundle args = new Bundle();
        args.putInt("someInt", pos);
        args.putString("someTitle", title);
        TasksFragment fragment = new TasksFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);
        TextView text = view.findViewById(R.id.titlePage1);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void Cos(String asd) {
        TextView text = getView().findViewById(R.id.titlePage1);
        text.setText("1");
    }

    public interface TaskfragmentListener {
        void setBottomSheet(boolean option);
    }


}
