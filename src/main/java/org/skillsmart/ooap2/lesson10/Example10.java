package org.skillsmart.ooap2.lesson10;

public class Example10 {

    class One {
        public final String notOverride() {
            return "no override allowed";
        }

        public String canBeOverrided() {
            return "can be overrided";
        }
    }

    class Two extends One {
        @Override
        public String canBeOverrided() {
            return "override";
        }

        //Ошибка: overridden method is final
        /*@Override
        public String notOverride() {
            return "override";
        }*/
    }
}
