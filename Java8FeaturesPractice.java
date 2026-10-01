import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8FeaturesPractice {

    public static void main(String[] args) {

        
        System.out.println("     JAVA 8 FEATURES PRACTICE");
        

        // 1. Lambda Expressions
        System.out.println("\n1. Lambda Expressions");
        // Exercise 1 - No Parameter

        Runnable greeting = () -> {
            System.out.println("Hello Java 8");
        };

        greeting.run();


        // Exercise 2 - One Parameter

        java.util.function.Consumer<String> greetName = (name) -> {
            System.out.println("Hello " + name);
        };

        greetName.accept("Regina");


        // Exercise 3 - Two Parameters

        java.util.function.BiConsumer<Integer, Integer> addNumbers = (a, b) -> {
            System.out.println(a + b);
        };

        addNumbers.accept(10, 20);


        // Exercise 4 - Addition

        java.util.function.BinaryOperator<Integer> addition = (a, b) -> {
            return a + b;
        };

        int result = addition.apply(10, 20);

        System.out.println("Addition = " + result);


        // Exercise 5 - Even/Odd Checking

        java.util.function.Predicate<Integer> checkEven = (number) -> {
            return number % 2 == 0;
        };

        int number = 10;

        if (checkEven.test(number)) {
            System.out.println(number + " is Even");
        } else {
            System.out.println(number + " is Odd");
        }


        // Exercise 6 - String Operation

        java.util.function.Function<String, Integer> stringLength = (text) -> {
            return text.length();
        };

        int length = stringLength.apply("Java");

        System.out.println("Length = " + length);


        // Exercise 7 - Real-Life Example

        java.util.function.Predicate<Integer> discountEligible = (amount) -> {
            return amount >= 1000;
        };

        int purchaseAmount = 1500;

        if (discountEligible.test(purchaseAmount)) {
            System.out.println("Customer is eligible for discount");
        } else {
            System.out.println("Customer is not eligible for discount");
        }



        // 2. Functional Interfaces
        System.out.println("\n2. Functional Interfaces");

        // Exercise 1: Custom greeting interface
        Greeting customGreeting = name ->
                System.out.println("Welcome, " + name);

        customGreeting.sayHello("Regina");

        // Exercise 2: Square of a number
        NumberOperation square = n -> n * n;
        System.out.println("Square = " + square.calculate(5));

        // Exercise 3: Check whether a number is positive
        NumberCheck positive = n -> n > 0;
        System.out.println("Is 8 positive? " + positive.check(8));


        // 3. forEach()
        System.out.println("\n3. forEach()");

         List<String> names =
                Arrays.asList("Regina", "Aman", "Priya");

        // Exercise 1: Print all names
        names.forEach(name -> System.out.println(name));

        // Exercise 2: Print numbers
        List<Integer> numbers = Arrays.asList(10, 20, 30);
        numbers.forEach(n -> System.out.println("Number: " + n));

        // Exercise 3: Print product names
        List<String> products =
                Arrays.asList("Laptop", "Phone", "Headphones");

        products.forEach(product ->
                System.out.println("Product: " + product));


        // 4. Stream API
        System.out.println("\n4. Stream API");

        List<Integer> values =
                Arrays.asList(10, 15, 20, 20, 25, 30);

        // filter(): Keep only even numbers
        System.out.println("Even numbers:");
        values.stream()
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.println(n));

        // map(): Square each number
        System.out.println("Squares:");
        values.stream()
                .map(n -> n * n)
                .forEach(n -> System.out.println(n));

        // sorted(): Sort numbers
        System.out.println("Sorted numbers:");
        values.stream()
                .sorted()
                .forEach(n -> System.out.println(n));

        // distinct(): Remove duplicates
        System.out.println("Distinct numbers:");
        values.stream()
                .distinct()
                .forEach(n -> System.out.println(n));

        // count(): Count numbers greater than 20
        long count = values.stream()
                .filter(n -> n > 20)
                .count();

        System.out.println("Numbers greater than 20: " + count);

        // collect(): Collect even numbers into a new List
        List<Integer> evenNumbers = values.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Collected even numbers: " + evenNumbers);


        // 5. Method References
        System.out.println("\n5. Method References");

        // Exercise 1: Print names using a method reference
        names.forEach(System.out::println);

        // Exercise 2: Print uppercase names using a method reference
        Function<String, String> uppercase = String::toUpperCase;

        names.stream()
                .map(uppercase)
                .forEach(System.out::println);


        // 6. Default Methods
        System.out.println("\n6. Default Methods");

        Vehicle car = new Car();
        car.start();
        car.stop();



        // 7. Static Methods in Interfaces
        System.out.println("\n7. Static Methods in Interfaces");

        System.out.println("Square = " + Calculator.square(6));
        System.out.println("Multiply = " + Calculator.multiply(4, 5));


        // 8. Optional
        System.out.println("\n8. Optional");

        // of(): Use when the value is not null
        Optional<String> name = Optional.of("Regina");
        System.out.println("of(): " + name.get());

        // ofNullable(): Value may be null
        String unknownName = null;
        Optional<String> optionalName =
                Optional.ofNullable("Regina");
        System.out.println("ofNullable(): " + optionalName);

        // isPresent(): Check whether a value exists
        if (name.isPresent()) {
            System.out.println("Name is present: " + name.get());
        }

        // orElse(): Provide a fallback value
        String displayName = optionalName.orElse("Guest");
        System.out.println("Display name: " + displayName);


        // 9. Date and Time API
        System.out.println("\n9. Date and Time API");

        // LocalDate: Date only
        LocalDate today = LocalDate.now();
        System.out.println("Today's date: " + today);

        // LocalTime: Time only
        LocalTime currentTime = LocalTime.now();
        System.out.println("Current time: " + currentTime);

        // LocalDateTime: Date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current date and time: " + currentDateTime);
    }
        @FunctionalInterface
    interface Greeting {
        void sayHello(String name);
    }

    @FunctionalInterface
    interface NumberOperation {
        int calculate(int number);
    }

    @FunctionalInterface
    interface NumberCheck {
        boolean check(int number);
    }

    interface Vehicle {
        default void start() {
            System.out.println("Vehicle is starting");
        }

        default void stop() {
            System.out.println("Vehicle is stopping");
        }
    }

    static class Car implements Vehicle {
    }

    interface Calculator {
        static int square(int number) {
            return number * number;
        }

        static int multiply(int a, int b) {
            return a * b;
        }
    }
}