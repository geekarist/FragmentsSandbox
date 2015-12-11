package com.github.geekarist.fragmentssandbox;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
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
        nameText.setText(nameArgument());
        cleanUpButton = inflatedView.findViewById(R.id.button_cleanup);
        return inflatedView;
    }

    private String nameArgument() {
        if (getArguments() == null || getArguments().getString("name") == null) {
            return "";
        }
        return getArguments().getString("name");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Do nothing
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Do nothing
            }

            @Override
            public void afterTextChanged(Editable editable) {
                listener.consumeName(editable.toString());
            }
        });
        cleanUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanUpText();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Listener) {
            listener = (Listener) context;
        }
    }

    private void cleanUpText() {
        nameText.setText(nameText.getText().toString().toUpperCase());
    }

    public static Fragment newInstance(String name) {
        EditYourNameFragment fragment = new EditYourNameFragment();
        Bundle args = new Bundle();
        args.putString("name", name);
        fragment.setArguments(args);
        return fragment;
    }

    public interface Listener {
        void consumeName(String name);
    }
}
