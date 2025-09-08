package org.example;

public class Draft2_2 {

    class Account {
        private double balance;

        public Account(double balance) {
            this.balance = Math.max(balance, 0);
        }

        public double getBalance() {
            return balance;
        }

        public void withdraw(double sum) {
            if (balance - sum >= 0) {
                // снятие разрешено
            } else {
                // снятие запрещено
            }
        }
    }

    /**
     * Пример класса, расширяющего функциональность класса-родителя
     * Класс счета с овердрафтом позволяет обойти основное ограничение стандартного счета и уйти в минус на балансе
     */
    class OverdraftAccount extends Account {
        private double overdraftLimit;

        public OverdraftAccount(double balance, double overdraftLimit) {
            super(balance);
            this.overdraftLimit = overdraftLimit;
        }

        // здесь мы расширяем возможность класса-родителя, позволяя обойти основное ограничение стандартного счета и уйти в минус на балансе
        @Override
        public void withdraw(double sum) {
            if (getBalance() + overdraftLimit - sum >= 0) {
                // снятие разрешено
            } else {
                // снятие запрещено
            }
        }
    }

    /**
     * Пример класса, специализирующего родителя
     * Класс накопительного счета уточняет класс родитель, добавляя специализированный метод начисления процентов и
     * вводя дополнительное ограничение на снятие - только в конце месяца (периода)
     */
    class SavingAccount extends Account {

        private float rate;

        public SavingAccount(double balance, float rate) {
            super(balance);
            this.rate = rate;
        }

        private boolean isEndOfMonth() {
            return true;
        }

        public void chargeInterest() {
            //начислить проценты
        }

        @Override
        public void withdraw(double sum) {
            if (getBalance() - sum >= 0 && isEndOfMonth()) {
                // снятие разрешено
            } else {
                // снятие запрещено
            }
        }

    }


    class Chair {
        protected boolean hasBack;
        protected int legsCount;

        public Chair(boolean hasBack, int legsCount) {
            this.hasBack = hasBack;
            this.legsCount = legsCount;
        }
    }

    class SeatingFurniture extends Chair {

        public SeatingFurniture(boolean hasBack, int legsCount) {
            super(hasBack, legsCount);
        }


    }

}
