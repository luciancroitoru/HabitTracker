package com.example.android.habittracker;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.android.habittracker.data.HabitsContract.HabitsEntry;

import com.example.android.habittracker.data.HabitsDbHelper;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HabitsDbHelper mDbHelper = new HabitsDbHelper(this);

        mDbHelper.insertHabit(
                "Android learning",
                "July 20",
                "9.5 hours",
                "8 hours",
                HabitsEntry.GOAL_ACHIEVED_YES,
                HabitsEntry.SATISFACTION_LEVEL_VERY_GOOD);

        mDbHelper.insertHabit(
                "Exercise",
                "July 20",
                "15 minutes",
                "0 minutes",
                HabitsEntry.GOAL_ACHIEVED_NO,
                HabitsEntry.SATISFACTION_LEVEL_UNSATISFACTORY);

        mDbHelper.insertHabit(
                "Get fresh air",
                "July 20",
                "30 minutes",
                "20 minutes",
                HabitsEntry.GOAL_ACHIEVED_NO,
                HabitsEntry.SATISFACTION_LEVEL_SATISFACTORY);

        mDbHelper.insertHabit(
                "Sleep 8 hours/ night",
                "July 20",
                "8 hrs",
                "7.5 hrs",
                HabitsEntry.GOAL_ACHIEVED_NO,
                HabitsEntry.SATISFACTION_LEVEL_GOOD);

        Cursor readCursor = mDbHelper.queryAllHabits();

        try {
            while (readCursor.moveToNext()) {
                Log.i(LOG_TAG,
                        "Habit: " + readCursor.getInt(0) + " - "
                                + readCursor.getString(1) + " - "
                                + readCursor.getString(2) + " - "
                                + readCursor.getString(3) + " - "
                                + readCursor.getString(4) + " - "
                                + readCursor.getInt(5) + " - "
                                + readCursor.getInt(6));
            }
        } finally {
            readCursor.close();
        }
    }
}
