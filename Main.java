import java.text.DateFormat.Field;
import java.util.Scanner;

public abstract class Members {
    protected int num1;
    protected int num2;
    protected double answer;
    protected String choice;
    protected abstract void function();
    static String options[] = {"Add", "Subtract", "Multiply", "Divide"};
    public static int index;
    protected void getIndex() {
        for (int i = 0; i < options.length; i++) {
            if (options[i].equalsIgnoreCase(choice)) {
                index = i;
                break; 
            }
        }
    }
}

public class Prompts extends Members {

    @Override
    protected void function() {
        // TODO Auto-generated method stub
        
    }    
    // Print out the list of options
    protected void Out() {
    System.out.print("Choose: ");
    for (int i = 0; i < options.length; i++) {
        System.out.print(options[i] + " ");
    }
    System.out.println();
    }

    // Get user input and check the choice
    public void userInput() {
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextLine();
        System.out.println("Enter first number ");
        num1 = scanner.nextInt();
        System.out.println("Enter second number");
        num2 = scanner.nextInt();
        scanner.close();
        getIndex();

    }
}

// create a class that overrides function for each operation type
public class Add extends Members {
    @Override
    protected void function() {
        answer = num1 + num2;
    }

}

public class Subtract extends Members {
    @Override
    protected void function() {
        answer = num1 - num2;
    }

}

public class Multiply extends Members {
    @Override
    protected void function() {
        answer = num1 * num2;
    }

}

public class Divide extends Members {
    @Override
    protected void function() {
        answer = num1 / num2;
    }

}

// Create an ops factory that will instantiate the correct class
public class Factory {
    // instantiate one of the classes above
    public static Members create() {
        switch (Members.index) {
            case 0: return new Add();
            case 1: return new Subtract();
            case 2: return new Multiply();
            case 3: return new Divide();
            default: return null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Prompts io = new Prompts();

        // Step 1
        io.Out(); // show options
        io.userInput(); //initialized vars with user input

        // Step 2: Create the correct operation object
        Members operation = Factory.create();

        // Step 3: Copy numbers from IO into the operation object
        operation.num1 = io.num1;
        operation.num2 = io.num2;

        // Step 4: Perform the chosen operation (polymorphic call)
        operation.function();

        // Step 5: Display the result
        System.out.println("The answer is: " + operation.answer);
    }
}







