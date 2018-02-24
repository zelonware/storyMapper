package com.geekstorming.storymapper.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Beelzenef on 24/02/2018.
 */

public class EmailChecker {
        private Pattern pattern;
        private Matcher matcher;

        private static final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        public EmailChecker() {
            pattern = Pattern.compile(EMAIL_PATTERN);
        }
        public boolean validate(final String hex) {

            matcher = pattern.matcher(hex);
            //falta realizar un patter mejor
            return true;

        }
}
