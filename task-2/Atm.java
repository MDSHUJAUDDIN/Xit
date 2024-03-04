import java.util.Scanner;

public class Atm {
    int withdrawalAmount;
    int twoThousandNotes;
    int fiveHundredNotes;
    int twoHundredNotes;
    int oneHundredNotes;
    int calculatedAmount = 0;

    public Atm(int withdrawalAmount, int twoThousandNotes, int fiveHundredNotes, int twoHundredNotes, int oneHundredNotes) {
        this.withdrawalAmount = withdrawalAmount;
        this.twoThousandNotes = twoThousandNotes;
        this.fiveHundredNotes = fiveHundredNotes;
        this.twoHundredNotes = twoHundredNotes;
        this.oneHundredNotes = oneHundredNotes;

        performWithdrawal(0);
    }

    void performWithdrawal(int calculatedAmount) {
        if (calculatedAmount >= withdrawalAmount) {
            System.out.println("Withdrawal successful: " + withdrawalAmount);
            return;
        }

        if (twoThousandNotes > 1 && calculatedAmount + 2000 <= withdrawalAmount) {
            twoThousandNotes--;
            performWithdrawal(calculatedAmount + 2000);
            System.out.println("2000 notes remaining: " + twoThousandNotes);
            return;
        }

        if (fiveHundredNotes > 1 && calculatedAmount + 500 <= withdrawalAmount) {
            fiveHundredNotes--;
            performWithdrawal(calculatedAmount + 500);
            System.out.println("500 notes remaining: " + fiveHundredNotes);
            return;
        }

        if (twoHundredNotes > 1 && calculatedAmount + 200 <= withdrawalAmount) {
            twoHundredNotes--;
            performWithdrawal(calculatedAmount + 200);
            System.out.println("200 notes remaining: " + twoHundredNotes);
            return;
        }

        if (oneHundredNotes > 1 && calculatedAmount + 100 <= withdrawalAmount) {
            oneHundredNotes--;
            performWithdrawal(calculatedAmount + 100);
            System.out.println("100 notes remaining: " + oneHundredNotes);
            return;
        }

        System.out.println("Unable to dispense amount: " + withdrawalAmount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the amount that needs to be withdrawn:");
        int withdrawalAmount = scanner.nextInt();

        System.out.println("Enter the number of 2000 notes in the ATM:");
        int twoThousandNotes = scanner.nextInt();

        System.out.println("Enter the number of 500 notes in the ATM:");
        int fiveHundredNotes = scanner.nextInt();

        System.out.println("Enter the number of 200 notes in the ATM:");
        int twoHundredNotes = scanner.nextInt();

        System.out.println("Enter the number of 100 notes in the ATM:");
        int oneHundredNotes = scanner.nextInt();

        Atm atm = new Atm(withdrawalAmount, twoThousandNotes, fiveHundredNotes, twoHundredNotes, oneHundredNotes);
        scanner.close();
    }
}
