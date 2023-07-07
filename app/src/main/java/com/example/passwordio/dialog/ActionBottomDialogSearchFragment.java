package com.example.passwordio.dialog;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.passwordio.DB;
import com.example.passwordio.R;
import com.example.passwordio.models.Folder;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textfield.TextInputEditText;

public class ActionBottomDialogSearchFragment extends BottomSheetDialogFragment implements View.OnClickListener{


    private TextInputEditText  username;
    LinearLayout noteLayout, loginLayout;
    Button b;

    private TextView s;
    private DB db;
    public static ActionBottomDialogSearchFragment newInstance() {
        return new ActionBottomDialogSearchFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bottom_sheet_search_item, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ;
        db = new DB(view.getContext());
        s = view.findViewById(R.id.searchView);
       b=view.findViewById(R.id.button);
       b.setOnClickListener(this);
        username = view.findViewById(R.id.Username);
        loginLayout = view.findViewById(R.id.bottomSheetInsertLayoutLogin);
        view.findViewById(R.id.bottomSheetInsertSave).setOnClickListener(this);
      s.setText(".");


    }


    private void handleSave() {

        String uname = username.getText().toString();
        String res = db.loginsByName(uname);
        s.setText(res);
    }



    @Override
    public void onClick(View view) {
        handleSave();
    }

}
