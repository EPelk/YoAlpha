package com.example.yoalpha2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

public class Util {

    public static final String PREFS_NAME = "prefs";
    public static final String PREF_DARK_THEME = "dark_theme";
    public static boolean useDarkTheme = true;

    public static boolean switchTo(Activity self, int id){
        Intent switchActivity = null;
        if (id == R.id.nav_announcements) {
            switchActivity = new Intent(self, AnnouncementsActivity.class);
        } else if (id == R.id.nav_info) {
            switchActivity = new Intent(self, InfoActivity.class);
        } else if (id == R.id.nav_clubsport) {
            switchActivity = new Intent(self, ClubSportActivity.class);
        } else if (id == R.id.nav_teachers) {
            switchActivity = new Intent(self, DirectoryActivity.class);
        }


        if (switchActivity instanceof Intent || id == R.id.nav_home)
        {
            DrawerLayout drawer = self.findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            if(!(id == R.id.nav_home)) {
                self.startActivity(switchActivity);
            }
            if (!(self instanceof MainActivity)) {
                self.finish();

            }
            return true;
        }
        return false;
    }


    public static void toggleTheme(Activity self, boolean darkTheme, View v) {
        SharedPreferences.Editor editor = self.getSharedPreferences(PREFS_NAME, self.MODE_PRIVATE).edit();
        editor.putBoolean(PREF_DARK_THEME, darkTheme);
        editor.apply();

        Intent intent = self.getIntent();
        self.finish();

        self.startActivity(intent);
    }
}
