package com.vageesha.practical05;

import android.provider.BaseColumns;

public final class UsersMaster {

    private UsersMaster() {}

    public static class order implements BaseColumns {

        public static final String TABLE_NAME = "orders";
        public static final String COLUMN_NAME_ORDER_ID = "orderID";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_CUSTOMER_ID = "customerID";
        public static final String COLUMN_NAME_PRODUCT_ID = "productID";
        public static final String COLUMN_NAME_QUANTITY = "quantity";
        public static final String COLUMN_NAME_TOTAL_PRICE = "totalPrice";

    }
}
