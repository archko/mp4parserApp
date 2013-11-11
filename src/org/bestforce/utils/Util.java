package org.bestforce.utils;

import java.io.File;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.vicmns.mp4parserapptest.R;

public class Util {

    private static File getDir(final Context mCtx, final String aPref, final String aDefaultDirName, final String aFolderName) {
        final SharedPreferences pref=PreferenceManager.getDefaultSharedPreferences(mCtx);
        final String dirName=pref.getString(aPref, aDefaultDirName)+"/"+aFolderName+"/";

        final File dir=new File(dirName.replace("//", "/").replace("//", "/"));
        if (!dir.exists()) {
            if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {
                dir.mkdirs();
            }
        }

        return dir;
    }

    public static File getTestMp4ParserVideosDir(final Context mCtx) {
        return getDir(mCtx, "pref_dir_videos", "/sdcard/mp4", "");
    }

    public static ProgressDialog ShowWaitDialog(final Context mCtx, final int ResourceId) {
        final ProgressDialog dialog=new ProgressDialog(mCtx);
        dialog.setMessage(mCtx.getString(ResourceId==0 ? R.string.message_wait : ResourceId));
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);

        dialog.show();

        return dialog;
    }

}
