package org.skillsmart.ooap2.lesson11;

import org.skillsmart.ooap2.lesson09.General;

public class Example11 {

    // Java не поддерживает множественное наследование. В чисто учебных целях можно конечно попробовать построить упомянутую в задании иерархию через интерфейсы:
    interface IGeneral {
        default String whoAmI(IGeneral obj) {
            System.out.println("I'm " + obj.getClass());
            return "I'm " + obj.getClass();
        }
    }
    interface IAny extends IGeneral {}
    interface IFirst extends IAny {}
    interface ISecond extends IAny {}
    interface IThird extends IFirst {}

    static final class Void implements ISecond, IThird {

        private Void() {}

        public static Void getInstance() {
            return VoidHolder.INSTANCE;
        }
        private static class VoidHolder {
            private static final Void INSTANCE = new Void();
        }
    }

    public static final Void VOID = Void.getInstance();

    public void polyExample() {
        IGeneral general = VOID;
        IAny any = VOID;
        IFirst first = VOID;
        ISecond second = VOID;
        general.whoAmI(any);
        any.whoAmI(general);
        first.whoAmI(second);
        second.whoAmI(first);
    }

    //I'm class org.skillsmart.ooap2.lesson11.Example11$Void
    //I'm class org.skillsmart.ooap2.lesson11.Example11$Void
    //I'm class org.skillsmart.ooap2.lesson11.Example11$Void
    //I'm class org.skillsmart.ooap2.lesson11.Example11$Void
}
