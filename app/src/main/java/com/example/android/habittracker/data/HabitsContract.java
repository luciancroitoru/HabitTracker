package com.example.android.habittracker.data;

import android.provider.BaseColumns;

public final class HabitsContract {
    private HabitsContract() {
    }

    public static final class HabitsEntry implements BaseColumns {
        public static final String TABLE_NAME = "habits";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_HABIT_NAME = "habit_name";
        public static final String COLUMN_HABIT_DATE = "date";
        public static final String COLUMN_HABIT_DURATION = "duration";
        public static final String COLUMN_HABIT_GOAL = "goal";
        public static final String COLUMN_HABIT_GOAL_ACHIEVED = "goal_achieved";
        public static final String COLUMN_HABIT_SATISFACTION_LEVEL = "satisfaction_level";

        public static final int GOAL_ACHIEVED_NO = 0;
        public static final int GOAL_ACHIEVED_YES = 1;

        public static final int SATISFACTION_LEVEL_UNSATISFACTORY = 0;
        public static final int SATISFACTION_LEVEL_SATISFACTORY = 1;
        public static final int SATISFACTION_LEVEL_GOOD = 2;
        public static final int SATISFACTION_LEVEL_VERY_GOOD = 3;
    }
}
