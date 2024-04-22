package a;

import java.util.Date;

public class Main {
    public static void main() {
        Employee[] employees = new Employee[5];
        employees[0] = new HourlyEmployee("John", "Smith", "111-11-1111", 35.0, 40, new Birthdate(new Date(1990, 1, 1)));
        employees[1] = new SalariedEmployee("Antonio", "Smith", "222-22-2222", 800.0, new Birthdate(new Date(1990, 1, 1)));
        employees[2] = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06, new Birthdate(new Date(1990, 1, 1)));
        employees[3] = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, .04, 300, new Birthdate(new Date(1990, 1, 1)));
        employees[4] = new PieceWorker("Jane", "Doe", "555-55-5555", 10.0, 20, new Birthdate(new Date(1990, 1, 1)));

        for (Employee currentEmployee : employees) {
            String name = String.format("%s %s", currentEmployee.getFirstName(), currentEmployee.getLastName());
            double payout = currentEmployee.earnings();
            if (currentEmployee.getBirthdate().isThisMonth()) {
                payout += 200;
            }
            System.out.printf("%s earned %.2f NIS%n", name, payout);
        }

    }
}


