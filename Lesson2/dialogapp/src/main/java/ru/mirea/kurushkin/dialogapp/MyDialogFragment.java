package ru.mirea.kurushkin.dialogapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import ru.mirea.kurushkin.dialogapp.R;

public class MyDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setTitle("Здравствуй МИРЭА!")
                .setMessage("Успех близок?")
                .setIcon(R.mipmap.ic_launcher)

                .setPositiveButton("Иду дальше",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                ((ru.mirea.kurushkin.dialogapp.DialogApp)getActivity()).onOkClicked();
                                dialog.cancel();
                            }
                        })

                .setNeutralButton("На паузе",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                ((ru.mirea.kurushkin.dialogapp.DialogApp)getActivity()).onNeutralClicked();
                                dialog.cancel();
                            }
                        })

                .setNegativeButton("Нет",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                ((ru.mirea.kurushkin.dialogapp.DialogApp)getActivity()).onCancelClicked();
                                dialog.cancel();
                            }
                        });

        return builder.create();
    }
}