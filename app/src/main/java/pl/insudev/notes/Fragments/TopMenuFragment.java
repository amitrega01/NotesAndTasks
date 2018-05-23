package pl.insudev.notes.Fragments;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import pl.insudev.notes.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopMenuFragment extends Fragment {

    private boolean Option;
    private Button TaskBtn;
    private Button NotesBtn;

    private MyActivityListener listener;

    public TopMenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Option = false;


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (MyActivityListener) context;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_menu, container, false);

        TaskBtn = view.findViewById(R.id.tasksBtn);
        NotesBtn = view.findViewById(R.id.notesBtn);
        Option = true;
        TaskBtn.setActivated(true);


        TaskBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                Option = true;

                setButtonsState(Option);
                listener.sendOption(Option);

            }
        });

        NotesBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                Option = false;

                setButtonsState(Option);

                listener.sendOption(Option);
            }
        });

        return view;
    }

    public void changeOption(boolean option) {
        Option = option;
        setButtonsState(option);
    }

    public void setButtonsState(boolean buttonsState) {
        TaskBtn.setActivated(buttonsState);
        NotesBtn.setActivated(!buttonsState);
    }

    public interface MyActivityListener {
        void sendOption(boolean option);
    }


}
