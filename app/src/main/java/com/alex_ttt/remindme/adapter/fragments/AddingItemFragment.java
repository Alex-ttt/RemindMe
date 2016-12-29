package com.alex_ttt.remindme.adapter.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.EditText;

import com.alex_ttt.remindme.R;

public class AddingItemFragment extends DialogFragment implements
        DialogInterface.OnClickListener {

    private View form = null;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        form = getActivity().getLayoutInflater()
                .inflate(R.layout.adding_dialog, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        return(builder.setTitle("Add your history").setView(form)
                .setPositiveButton("Add", this)
                .setNegativeButton("Cancel", null).create());
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        EditText history = (EditText)form.findViewById(R.id.new_history);
        String login = history.getText().toString();
    }

    @Override
    public void onDismiss(DialogInterface unused) {
        super.onDismiss(unused);
    }
    @Override
    public void onCancel(DialogInterface unused) {
        super.onCancel(unused);
    }
}
