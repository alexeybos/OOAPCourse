package org.skillsmart.ooap2.lesson22;

public class Example22 {

    // класс Лекарство может характеризоваться как формой выпуска, так и назначением. Т.е. имеем признаки:
    // "подразумевается несколько критериев классификации некоторой родительской сущности, и выделить из них единственный самый главный не удаётся"
    // и "подразумевается активное комбинирование этих критериев (разные значения формы и назначения)"

    /** Лекарства:
     * Форма: таблетки, жидкость, гель, капсулы...
     * Назначение: обезболивающее, противовирусное, антигистаминное...
     */
    public class Medicine {
        Double price;
        MedicineForm medicineForm;
        MedicinePurpose medicinePurpose;
    }

    public abstract class MedicineForm {
        public abstract String howToUse();
    }

    public class TabletForm extends MedicineForm {
        @Override
        public String howToUse() {
            return "запить водой";
        }
    }

    public class LiquidForm extends MedicineForm {
        @Override
        public String howToUse() {
            return "налить в стакан и выпить";
        }
    }

    public abstract class MedicinePurpose {
        public abstract String symptomsForUse();
    }

    public class Painkiller extends MedicinePurpose {
        @Override
        public String symptomsForUse() {
            return "все виды боли";
        }
    }

    public class Antiviral extends MedicinePurpose {
        @Override
        public String symptomsForUse() {
            return "грипп, ОРВИ";
        }
    }

}
