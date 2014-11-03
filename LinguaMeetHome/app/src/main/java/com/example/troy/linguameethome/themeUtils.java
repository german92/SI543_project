package com.example.troy.linguameethome;

/**
 * Created by Troy on 11/2/2014.
 */
import android.app.Activity;

import android.content.Intent;


public class themeUtils

{

    private static int cTheme;



    public final static int C1 = 0;

    public final static int C2 = 1;

    public static void changeToTheme(Activity activity, int theme)

    {

        cTheme = theme;

        activity.finish();



        activity.startActivity(new Intent(activity, activity.getClass()));


    }

    public static void onActivityCreateSetTheme(Activity activity)

    {

        switch (cTheme)

        {

            default:

            case C1:

                activity.setTheme(R.style.CustomTheme1);

                break;

            case C2:

                activity.setTheme(R.style.CustomTheme2);

                break;

        }

    }

}



