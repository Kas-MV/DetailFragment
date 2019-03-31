package com.example.v_s.androidtutorialfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ItemsFragment extends Fragment {

    private Listener listener;
    private Button item1Button;
    private Button item2Button;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (Listener) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_items, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        item1Button = view.findViewById(R.id.view_item1_button);
        item2Button = view.findViewById(R.id.view_item2_button);

        item1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItem1Click(ItemsFragment.this);
            }
        });

        item2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItem2Click(ItemsFragment.this);

            }
        });
    }

    public interface Listener {
        void onItem1Click(ItemsFragment fragment);
        void onItem2Click(ItemsFragment fragment);
    }
}
