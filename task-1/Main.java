import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Elevator {
    private int numFloors;
    private int currentFloor;


    public Elevator(int numFloors,int currentFloor) {
        this.numFloors = numFloors;
        this.currentFloor = currentFloor;

    }

    public void move(int targetFloor) {
        if (targetFloor > currentFloor) {
            System.out.println("Moving up from floor " + currentFloor + " to floor " + targetFloor + ".");
        } else if (targetFloor < currentFloor) {
            System.out.println("Moving down from floor " + currentFloor + " to floor " + targetFloor + ".");
        } else {
            System.out.println("Elevator is already at floor " + targetFloor + ".");
        }
        currentFloor = targetFloor;
    }

    public void firstComeFirstServe(List<Integer> requests) {
        Collections.sort(requests);
        for (int request : requests) {
            move(request);
        }
    }

    public void nearestFloorServeFirst(List<Integer> requests) {
        Collections.sort(requests, Comparator.comparingInt(x -> Math.abs(x - currentFloor)));
        for (int request : requests) {
            move(request);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of floors in the building: ");
        int numFloors = scanner.nextInt();
        System.out.println("enter the current floor in which lift is standing: ");
        int currentFloor=scanner.nextInt();

        System.out.print("Enter the number of persons entering the elevator: ");
        int numPersons = scanner.nextInt();

        Elevator elevator = new Elevator(numFloors,currentFloor);
        List<Integer> requests = new ArrayList<>();

        System.out.println("Enter the floor requests for each person:");
        for (int i = 0; i < numPersons; i++) {
            System.out.print("Person " + (i + 1) + " requests to go to floor: ");
            int request = scanner.nextInt();
            requests.add(request);
        }

        System.out.print("Enter 1 for First come First serve, 2 for Nearest Floor Serve First: ");
        int useCase = scanner.nextInt();

        if (useCase == 1) {
            elevator.firstComeFirstServe(requests);
        } else if (useCase == 2) {
            elevator.nearestFloorServeFirst(requests);
        } else {
            System.out.println("Invalid input. Please enter 1 or 2.");
        }

        scanner.close();
    }
}
