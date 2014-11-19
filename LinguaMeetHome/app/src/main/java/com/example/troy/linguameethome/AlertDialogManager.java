package com.example.troy.linguameethome;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;

public class AlertDialogManager {

    public void showAlertDialog(Context context, String title, String message,
                                Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(Html.fromHtml("<font color=#000000>Oops!</font>"));
        alertDialog.setMessage(Html.fromHtml("<font color=#000000>Incorrect information, please try again</font>"));

        if(status != null)
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alertDialog.show();
    }
}