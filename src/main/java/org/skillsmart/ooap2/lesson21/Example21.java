package org.skillsmart.ooap2.lesson21;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example21 {

    //наследование реализаций. Тут как-то сложно пошло, думаю подойдет пример из первого курса ооап
    public class LinkedList {
        // ...
        // другие методы
        // ...
        public void right() {
            //go to the right
        }
    }

    public class TwoWayLinkedList extends LinkedList {

        public void left() {
            //go to the left
        }
    }

    //льготное наследование
    public class StringValidator {
        static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        static final String PHONE_REGEX = "^((\\+7|7|8)+([0-9]){10})$";

        public boolean isStringValid(String pt, String str) {
            Pattern pattern = Pattern.compile(pt);
            Matcher matcher = pattern.matcher(str);
            return matcher.matches();
        }
    }

    public class EmailValidator extends StringValidator {
        public boolean isEmailValid(String email) {
            return isStringValid(EMAIL_REGEX, email);
        }
    }

    public class PhoneValidator extends StringValidator {
        public boolean isPhoneValid(String phone) {
            return isStringValid(PHONE_REGEX, phone);
        }
    }

    public class StringValidator2 {
        private String regexForValidate;

        public StringValidator2(String regex) {
            this.regexForValidate = regex;
        }

        public boolean isStringValid(String str) {
            Pattern pattern = Pattern.compile(regexForValidate);
            Matcher matcher = pattern.matcher(str);
            return matcher.matches();
        }
    }

    public class EmailValidator2 extends StringValidator2 {
        private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        public EmailValidator2() {
            super(EMAIL_REGEX);
        }
    }
}
