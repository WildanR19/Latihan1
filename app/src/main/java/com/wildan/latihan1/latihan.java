package com.wildan.latihan1;

import android.provider.BaseColumns;

final class latihan {
    private latihan() {
    }

    public static class TabelSoal implements BaseColumns {

        public static final String TABLE_NAME = "soal";
        public static final String COLUMN_SOAL = "question";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_OPTION4 = "option4";
        public static final String COLUMN_ANSWER = "answer";
    }
}
