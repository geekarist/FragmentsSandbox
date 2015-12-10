package com.github.geekarist.fragmentssandbox;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class EditYourNameFragment extends Fragment {
    private static final String TAG = EditYourNameFragment.class.getName();

    private EditText nameText;
    private View cleanUpButton;
    private Listener listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_edit_your_name, container, false);
        nameText = (EditText) inflatedView.findViewById(R.id.text_name);
        cleanUpButton = inflatedView.findViewById(R.id.button_cleanup);
        listener = (Listener) getActivity();
        return inflatedView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cleanUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanUpText();
                listener.consumeName(nameText.getText().toString());
            }
        });
    }

    private void cleanUpText() {
        nameText.setText(nameText.getText().toString().toUpperCase());
    }

    public interface Listener {
        void consumeName(String name);
    }
}
