package com.school.app.utility;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.util.Log;

public class Helper implements AppConstants {

    public static void showLog(Object message) {
        /**/
        Log.d(TAG, message.toString());
    }

    public static void showLogE(Object message) {
        /**/
        Log.e(TAG, message.toString());
    }

    public static void rateApp(Context context) {
        Uri uri = Uri.parse("market://details?id=" + context.getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        // To count with Play market backstack, After pressing back button,
        // to taken back to our application, we need to add following flags to intent.
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try {
            context.startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + context.getPackageName())));
        }
    }

    public static void shareApp(Context context) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, appShareURL + context.getPackageName());
        sendIntent.setType("text/plain");
        context.startActivity(sendIntent);
    }

    public static void feedbackApp(Context context) {

        String deviceInfo = "Device Info:";
        deviceInfo += "\n OS Version: " + System.getProperty("os.version") + "(" + android.os.Build.VERSION.INCREMENTAL + ")";
        deviceInfo += "\n OS API Level: " + android.os.Build.VERSION.SDK_INT;
        deviceInfo += "\n Device: " + android.os.Build.DEVICE;
        deviceInfo += "\n Model (and Product): " + android.os.Build.MODEL + " (" + android.os.Build.PRODUCT + ")";


        Intent feedbackEmail = new Intent(Intent.ACTION_SEND);

        feedbackEmail.setType("text/email");
        feedbackEmail.putExtra(Intent.EXTRA_TEXT, deviceInfo);
        feedbackEmail.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
        feedbackEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"feedback@gmail.com"});
        context.startActivity(Intent.createChooser(feedbackEmail, "Send Feedback:"));
    }

    @SuppressLint("HardwareIds")
    public static String getDeviceId(Context context) {
        ContentResolver resolver = context.getContentResolver();
        return Settings.Secure.getString(resolver, Settings.Secure.ANDROID_ID);
    }
}

