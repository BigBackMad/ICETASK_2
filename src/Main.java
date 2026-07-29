//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    String[] months = {"MONTH 1", "MONTH 2", "MONTH 3"};
    String[] gyms = {"GYM 1", "GYM 2", "GYM 3"};
    int[][] weightLoss = {{10,20,27},{22,5,20},{30,20,10}};

    int SIZE = gyms.length;

    int[] totalWeightLoss = new int[SIZE];
    double[] averageWeightLoss = new double[SIZE];
    int[] gymMax = new int[SIZE];
    int[] gymMin = new int[SIZE];

    for(int i = 0; i < SIZE; i++){
        gymMin[i] = weightLoss[0][i];
    }

    System.out.println("GYM WEIGHTLOSS APPLICATION");
    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
    System.out.printf("%-18s", " ");

    for(int month = 0; month < SIZE; month++){
        System.out.printf("%-18s", months[month]);
    }

    System.out.printf("%-18s %-18s %-18s %-18s", "|" + "TOTAL", "AVG", "MIN", "MAX");
    System.out.println();
    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");

    for(int gym = 0; gym < weightLoss.length; gym++){

        gymMin[gym] = weightLoss[gym][0];
        gymMax[gym] = weightLoss[gym][0];

        for(int month = 0; month < weightLoss[gym].length; month++){

            int monthWeightLoss = weightLoss[gym][month];

            totalWeightLoss[gym] += monthWeightLoss;

            if (monthWeightLoss > gymMax[gym]) {
                gymMax[gym] = monthWeightLoss;
            }

            if (monthWeightLoss < gymMin[gym]) {
                gymMin[gym] = monthWeightLoss;
            }
        }

        averageWeightLoss[gym] = (double) totalWeightLoss[gym] / weightLoss[gym].length;
    }

    for (int gym = 0; gym < SIZE; gym++) {

        System.out.printf("%-18s", gyms[gym]);

        for (int month = 0; month < weightLoss[gym].length; month++) {
            System.out.printf("%-18s", weightLoss[gym][month] + "kg");
        }

        System.out.printf("%s%-18s%-18s%-18s%-18s", "|", totalWeightLoss[gym] + "kg", String.format("%.2f", averageWeightLoss[gym]) + "kg", gymMin[gym] + "kg", gymMax[gym] + "kg");
        System.out.println();
    }

}
