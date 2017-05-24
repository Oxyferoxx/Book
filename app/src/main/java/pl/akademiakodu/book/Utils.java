package pl.akademiakodu.book;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Malczan on 18.05.2017.
 */

public class Utils {



    public static final int VERSION = 1;

    public static void createSimpleDialog(Context con, String title, String mess){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(con);
        alertDialog.setPositiveButton("OK!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.setTitle(title);
        alertDialog.setMessage(mess);
        alertDialog.setCancelable(false);
        alertDialog.show();
    }
}