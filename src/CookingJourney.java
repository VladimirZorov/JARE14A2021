import java.util.Scanner;

public class CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] pastry = new String[n][n];

        int dollarsCollected = 0;
        boolean isInPastry = true;
        int rowMe = -1;
        int collMe = -1;
        int rowFirstPillar = -1;
        int collFirstPillar = -1;
        int rowSecondPillar = -1;
        int collSecondPillar = -1;

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("");
            pastry[i] = line;
            for (int j = 0; j < n; j++) {
                if (line[j].equals("S")) {
                    rowMe = i;
                    collMe = j;
                } else if (line[j].equals("P")) {
                    if (rowFirstPillar == -1) {
                        rowFirstPillar = i;
                        collFirstPillar = j;
                    } else {
                        rowSecondPillar = i;
                        collSecondPillar = j;
                    }
                }
            }
        }
        String s = null;

        while (dollarsCollected < 50 && isInPastry) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    if (rowMe - 1 >= 0) {
                        pastry[rowMe][collMe] = "-";
                        rowMe--;
                        if (pastry[rowMe][collMe].equals("P") && rowFirstPillar == rowMe) {
                            pastry[rowFirstPillar][collFirstPillar] = "-";
                            rowMe = rowSecondPillar;
                            collMe = collSecondPillar;
                            rowFirstPillar = -1;
                            collFirstPillar = -1;
                        } else if (pastry[rowMe][collMe].equals("P") && rowSecondPillar == rowMe) {
                            pastry[rowSecondPillar][collSecondPillar] = "-";
                            rowMe = rowFirstPillar;
                            collMe = collFirstPillar;
                            rowSecondPillar = -1;
                            collSecondPillar = -1;
                        } else if (isStringInt(s = pastry[rowMe][collMe])) {
                            dollarsCollected += Integer.parseInt(pastry[rowMe][collMe]);
                            pastry[rowMe][collMe] = "-";
                        }
                    } else {
                        isInPastry = false;
                    }
                    break;
                case "down":
                    if (rowMe + 1 < n) {
                        pastry[rowMe][collMe] = "-";
                        rowMe++;
                        if (pastry[rowMe][collMe].equals("P") && rowFirstPillar == rowMe) {
                            pastry[rowFirstPillar][collFirstPillar] = "-";
                            rowMe = rowSecondPillar;
                            collMe = collSecondPillar;
                            rowFirstPillar = -1;
                            collFirstPillar = -1;
                        } else if (pastry[rowMe][collMe].equals("P") && rowSecondPillar == rowMe) {
                            pastry[rowSecondPillar][collSecondPillar] = "-";
                            rowMe = rowFirstPillar;
                            collMe = collFirstPillar;
                            rowSecondPillar = -1;
                            collSecondPillar = -1;
                        } else if (isStringInt(s = pastry[rowMe][collMe])) {
                            dollarsCollected += Integer.parseInt(pastry[rowMe][collMe]);
                            pastry[rowMe][collMe] = "-";
                        }
                    } else {
                        isInPastry = false;
                    }
                    break;
                case "left":
                    if (collMe - 1 >= 0) {
                        pastry[rowMe][collMe] = "-";
                        collMe--;
                        if (pastry[rowMe][collMe].equals("P") && rowFirstPillar == rowMe) {
                            pastry[rowFirstPillar][collFirstPillar] = "-";
                            rowMe = rowSecondPillar;
                            collMe = collSecondPillar;
                            rowFirstPillar = -1;
                            collFirstPillar = -1;
                        } else if (pastry[rowMe][collMe].equals("P") && rowSecondPillar == rowMe) {
                            pastry[rowSecondPillar][collSecondPillar] = "-";
                            rowMe = rowFirstPillar;
                            collMe = collFirstPillar;
                            rowSecondPillar = -1;
                            collSecondPillar = -1;
                        } else if (isStringInt(s = pastry[rowMe][collMe])) {
                            dollarsCollected += Integer.parseInt(pastry[rowMe][collMe]);
                            pastry[rowMe][collMe] = "-";
                        }
                    } else {
                        isInPastry = false;
                    }
                    break;
                case "right":
                    if (collMe + 1 < n) {
                        pastry[rowMe][collMe] = "-";
                        collMe++;
                        if (pastry[rowMe][collMe].equals("P") && rowFirstPillar == rowMe) {
                            pastry[rowFirstPillar][collFirstPillar] = "-";
                            pastry[rowSecondPillar][collSecondPillar] = "-";
                            rowMe = rowSecondPillar;
                            collMe = collSecondPillar;
                            rowFirstPillar = -1;
                            collFirstPillar = -1;
                        } else if (pastry[rowMe][collMe].equals("P") && rowSecondPillar == rowMe) {
                            pastry[rowSecondPillar][collSecondPillar] = "-";
                            pastry[rowFirstPillar][collFirstPillar] = "-";
                            rowMe = rowFirstPillar;
                            collMe = collFirstPillar;
                            rowSecondPillar = -1;
                            collSecondPillar = -1;
                        } else if (isStringInt(s = pastry[rowMe][collMe])) {
                            dollarsCollected += Integer.parseInt(pastry[rowMe][collMe]);
                            pastry[rowMe][collMe] = "-";
                        }

                    } else {
                        isInPastry = false;
                    }
                    break;
            }
        }


        if (isInPastry) {
            pastry[rowMe][collMe] = "S";
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news! You are out of the pastry shop.");
        }
        System.out.printf("Money: %d%n", dollarsCollected);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(pastry[i][j]);
            }
            System.out.println();
        }
    }



    public static boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
