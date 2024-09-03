package task4;

import java.util.Arrays;
import java.util.Scanner;

public class Input {

    public static void main(String[] args) {

        int n = 0;
        int k = 0;

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
            k = scanner.nextInt();
        }

        CalculateLists lists = new CalculateLists(n, k);

        for (int i = 0; i < n; i++) {
            if (scanner.hasNextLong()) {
                lists.addElement(scanner.nextLong(), i);
            }
        }

        Arrays.stream(lists.getList()).forEach(l -> System.out.print(l + " "));
        System.out.println();

        long originalSum = lists.getListSum();

        long newElement = 0;
        int indexOfElement = -1;
        for (int i = 0; i < k; i++) {
            if (scanner.hasNextInt()) {
                 indexOfElement = scanner.nextInt();
            }
            if (scanner.hasNextLong()) {
                newElement = scanner.nextLong();
            }
            lists.updateList(newElement, indexOfElement);
            Arrays.stream(lists.getList()).forEach(l -> System.out.print(l + " "));
            System.out.println();
        }

        long newListSum = lists.getListSum();

        if (lists.equalSums(originalSum, newListSum)) {
            System.out.println(newListSum - originalSum);
        }
    }
}
