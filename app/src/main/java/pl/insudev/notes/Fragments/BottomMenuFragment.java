package pl.insudev.notes.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

import pl.insudev.notes.Models.Task;
import pl.insudev.notes.R;

public class BottomMenuFragment extends Fragment {

    private BottomSheetBehavior bottomSheetBehavior;
    private Button addButton;

    private EditText taskContent;
    private TextView listTitle;


    private MyListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment_bottom_menu, container, false);

        taskContent = view.findViewById(R.id.newTaskContent);
        addButton = view.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.AddTask(
                        new Task(taskContent.getText().toString(), new Date().toString(), false),
                        listTitle.getText().toString());

            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (MyListener) context;


    }


    public void setText(String txt) {
        listTitle = getView().findViewById(R.id.titleTopBar);
        listTitle.setText(txt);
        NestedScrollView nsv = getView().findViewById(R.id.bottomSheet);
        bottomSheetBehavior = BottomSheetBehavior.from(nsv);

        bottomSheetBehavior.setPeekHeight(180);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);


    }

    public interface MyListener {
        void AddTask(Task task, String title);
    }

}
