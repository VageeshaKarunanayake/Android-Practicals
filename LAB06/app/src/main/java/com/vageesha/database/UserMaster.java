package com.vageesha.database;

import android.provider.BaseColumns;

public class UserMaster {

    private UserMaster(){}

    public class Users implements BaseColumns {
        public static final String TABLE_NAME = "users";
        public static final String COLUNM_NAME_ID = "id";
        public static final String COLUMN_NAME_USERNAME = "username";
        public static final String COLUMN_NAME_PASSWORD = "password";
    }
}
