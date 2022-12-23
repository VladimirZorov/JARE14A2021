import java.util.*;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tulips = new ArrayDeque<>();
        ArrayDeque<Integer> daffodils = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).forEach(tulips::push);

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).forEach(daffodils::offer);

        int storedFlouers = 0;

        int bouqutsCount = 0;

        while (!tulips.isEmpty() && !daffodils.isEmpty()) {
            int tempTulips = tulips.peek();
            int tempDaffodils = daffodils.peek();
            int checkForBouquet = tempTulips + tempDaffodils;

            if (checkForBouquet == 15) {
                bouqutsCount++;
                tulips.pop();
                daffodils.poll();
            } else if (checkForBouquet > 15) {
                tulips.pop();
                tulips.addFirst(tempTulips-2);
            } else if (checkForBouquet < 15) {
                storedFlouers +=(tulips.pop());
                storedFlouers+=(daffodils.poll());
            }

        }
        int bouquetsOfStoredFlowers =0;
        int totalBouquets = bouqutsCount + (storedFlouers/15);


        if (totalBouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouqutsCount);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", (5-totalBouquets));
        }
    }
}
