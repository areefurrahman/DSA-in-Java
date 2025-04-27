import java.util.ArrayList;
import java.util.Scanner;

public class LinearRegressionCalculator {

    public static double meanCalculate(ArrayList<Double> dataList){

        if (dataList == null || dataList.size() == 0) {
            throw new IllegalArgumentException("Data list cannot be empty");
        }

        int totalValues = dataList.size();
        double sum = 0;
        for (double value : dataList){
            sum += value;
        }
        return sum/totalValues;
    }
    public static ArrayList<Double> inde_Minus_indemeanCalculate(ArrayList<Double> dataList){

        ArrayList<Double> inde_Minus_indemeanList = new ArrayList<>();

        // Calculating Mean
        double DataMean = meanCalculate(dataList);

        for(double value : dataList){
            double cValue = value-DataMean;
            inde_Minus_indemeanList.add(cValue);
        }

        return inde_Minus_indemeanList;
    }

    public static ArrayList<Double> xi_minus_xmean__multiply__yiminus_ymean(ArrayList<Double> dataList1, ArrayList<Double> dataList2 ){

        ArrayList<Double> xi_minus_xmean__multiply__yiminus_ymeanList = new ArrayList<>();

        if (dataList1.size() == dataList2.size()){
            for (int i = 0; i <dataList1.size() ; i++) {

                double newValue = dataList1.get(i) * dataList2.get(i);
                xi_minus_xmean__multiply__yiminus_ymeanList.add(newValue);
            }
        }
        else {
            System.out.println("x and y lists must have the same size");
        }


        return xi_minus_xmean__multiply__yiminus_ymeanList;
    }

    public static double summationCalculate(ArrayList<Double> dataList){

        double sum = 0;
        for (double value : dataList){
            sum += value;
        }

        return sum;
    }

    public static ArrayList<Double> xi_minus_xmean_square(ArrayList<Double> dataList ){

        ArrayList<Double> xi_minus_xmean_sequareList = new ArrayList<>();

        for (double value : dataList){
            xi_minus_xmean_sequareList.add(value*value);
        }
        return xi_minus_xmean_sequareList;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Double> xData = new ArrayList<>();
        ArrayList<Double> yData = new ArrayList<>();

        System.out.println("Number of Sample Data you want to put: ");
        int numberofData = input.nextInt();


        for (int i = 0; i < numberofData; i++) {
            System.out.println("\n" + (i+1) + "-----⬇️");

            System.out.println("Enter (X) Independent Value");
            double xValue = input.nextDouble();
            xData.add(xValue);
            System.out.println("Enter (Y) Dependent Value");
            double yValue = input.nextDouble();
            yData.add(yValue);

        }

        System.out.println("Enter your Prediction value: ");
        double X = input.nextDouble();


        //Formula  y = mX+c
        // Calculating m --------> Σ ((xi - xmean) * (yi - ymean)) / Σ(xi - xmean)^2

        // Calculating (xi - xmean)
        ArrayList<Double> xi_Minus_xmeanList = inde_Minus_indemeanCalculate(xData);
        // Calculating (yi - ymean)
        ArrayList<Double> yi_Minus_ymeanList = inde_Minus_indemeanCalculate(yData);


        // Calculating ((xi - xmean) * (yi - ymean))
        ArrayList<Double>  xi_minus_xmean__multiply__yi_minus_ymeanList = xi_minus_xmean__multiply__yiminus_ymean(xi_Minus_xmeanList, yi_Minus_ymeanList);
        double FinalValue_xi_minus_xmean__multiply__yi_minus_ymean = summationCalculate(xi_minus_xmean__multiply__yi_minus_ymeanList);

        // Calculating (xi - xmean)^2
        ArrayList<Double> xi_minus_xmean_squareList = xi_minus_xmean_square(xi_Minus_xmeanList);

        double FinalValue_xi_minus_xmean_square = summationCalculate(xi_minus_xmean_squareList);

        if (FinalValue_xi_minus_xmean_square == 0) {
            throw new ArithmeticException("Division by zero: all x values are the same");
        }

        double m = FinalValue_xi_minus_xmean__multiply__yi_minus_ymean/FinalValue_xi_minus_xmean_square;




        // Calculating c ---------> ymean - m * xmean
        double c = meanCalculate(yData) - m * meanCalculate(xData);



        // Calculating y = mX + c

        double y = m*X+c;

        System.out.println(y);
    }
}
