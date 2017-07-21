package com.example.android.habittracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.android.habittracker.data.HabitsContract.HabitsEntry;

public class HabitsDbHelper extends SQLiteOpenHelper {

    private static final String LOG_TAG = HabitsDbHelper.class.getSimpleName();

    //name of database file
    private static final String DATABASE_NAME = "habit.db";

    //database version
    private static final int DATABASE_VERSION = 1;

    public HabitsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the habits table
        String SQL_CREATE_HABITS_TABLE = "CREATE TABLE " + HabitsEntry.TABLE_NAME + " ("
                + HabitsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitsEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL, "
                + HabitsEntry.COLUMN_HABIT_DATE + " TEXT NOT NULL, "
                + HabitsEntry.COLUMN_HABIT_DURATION + " TEXT NOT NULL, "
                + HabitsEntry.COLUMN_HABIT_GOAL + " TEXT NOT NULL, "
                + HabitsEntry.COLUMN_HABIT_GOAL_ACHIEVED + " INTEGER NOT NULL DEFAULT 0, "
                + HabitsEntry.COLUMN_HABIT_SATISFACTION_LEVEL + " INTEGER NOT NULL DEFAULT 0);";

        Log.i(LOG_TAG, SQL_CREATE_HABITS_TABLE);

        db.execSQL(SQL_CREATE_HABITS_TABLE);
    }

    /**
     * This method inserts habits in the Habits table
     *
     * @param name              - Name of the habit
     * @param date              - Date when it has happened
     * @param duration          - Duration of the habit
     * @param goal              - Description of the goal
     * @param goalAchieved      - States whether goal was achieved or not
     * @param satisfactionLevel - Level of satisfaction perceived by the user
     */
    public void insertHabit(String name, String date, String duration, String goal, int goalAchieved, int satisfactionLevel) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues habitValues = new ContentValues();
        habitValues.put(HabitsEntry.COLUMN_HABIT_NAME, name);
        habitValues.put(HabitsEntry.COLUMN_HABIT_DATE, date);
        habitValues.put(HabitsEntry.COLUMN_HABIT_DURATION, duration);
        habitValues.put(HabitsEntry.COLUMN_HABIT_GOAL, goal);
        habitValues.put(HabitsEntry.COLUMN_HABIT_GOAL_ACHIEVED, goalAchieved);
        habitValues.put(HabitsEntry.COLUMN_HABIT_SATISFACTION_LEVEL, satisfactionLevel);

        db.insert(HabitsContract.HabitsEntry.TABLE_NAME, null, habitValues);
    }

    public Cursor queryAllHabits() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                HabitsEntry._ID,
                HabitsEntry.COLUMN_HABIT_NAME,
                HabitsEntry.COLUMN_HABIT_DATE,
                HabitsEntry.COLUMN_HABIT_DURATION,
                HabitsEntry.COLUMN_HABIT_GOAL,
                HabitsEntry.COLUMN_HABIT_GOAL_ACHIEVED,
                HabitsEntry.COLUMN_HABIT_SATISFACTION_LEVEL
        };

        return db.query(
                HabitsEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null,
                null);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }
}
