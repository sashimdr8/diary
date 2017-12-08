package com.diary.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.util.List;

/**
 * Created by brain on 2/27/17.
 */

public class Utils {


    public static boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    public static void hideKeypad(View view) {
        InputMethodManager mgr = (InputMethodManager) view.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static float convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    public static  int convertDpToInt(float dp , Context context){
        Resources r = context.getResources();
        int px = Math.round(TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 14,r.getDisplayMetrics()));
        return px;
    }




    /*  public static void handleTokenExpired(Activity activity) {
        TraceSellApp.component(activity).provideData().clear();
        Intent intent = new Intent(activity, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        activity.finish();
        activity.startActivity(intent);
    }
*/
    public static void showSnackbar(Activity activity, String message) {
        Snackbar snackbar = Snackbar.make(
                (activity.findViewById(android.R.id.content)),
                message, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }
}
