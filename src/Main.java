import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException, SAXException {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        int[] arrayOfNums = generateRandomArray(size);
        double geoMean = geometricMeanOfOddNumbers(arrayOfNums);
        List<Integer> numsAbove150 = new ArrayList<>();
        double avg = calculateAverageAbove150(arrayOfNums, numsAbove150);

        System.out.println("Randomly generated array: " + Arrays.toString(arrayOfNums));
        System.out.println("Geometric mean of odd numbers: " + geoMean);
        System.out.println("Numbers above 150 : " + numsAbove150);
        System.out.println("Average of numbers above 150: " + avg);

        XmlGenUtils.createXML();
        XmlGenUtils.parseXML();
    }

    public static double calculateAverageAbove150(int[] arr, List<Integer>above150) {
        double sum = 0;
        int count = 0;
        for (int num : arr) {
            if (num > 150) {
                above150.add(num);
                sum += num;
                count++;
            }
        }
        if (count == 0) {
            return 0;
        }
        return sum / count;
    }

    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(500) + 1;
        }
        return arr;
    }

    public static double geometricMeanOfOddNumbers(int[] arr) {
        int count = 0;
        double product = 1;
        for (int j : arr) {
            if (j % 2 == 1) {
                product *= j;
                count++;
            }
        }
        if (count == 0) {
            return 0;
        } else {
            return Math.pow(product, 1.0 / count);
        }
    }
}
