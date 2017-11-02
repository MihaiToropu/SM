package MS_LCG;

public class Common {

    private int _number;

    public int _pow(int x, int n) {
        int i;
        int number = 1;

        for (i = 0; i < n; ++i) {
            number *= x;
        }

        return (number);
    }


    public int countNumbers(int seed) {
        int count = 0;
        while (seed != 0) {
            ++count;
            seed = seed / 10;
        }

        //_number = (int)seed;
        return count;
    }

    public int rotateSeedtoLeft(int seed, int nrOfRotations) {

        int number = seed * seed;
        int len = Integer.toString(number).length();
        int[] iarray = new int[len];
        for (int index = 0; index < len; index++) {
            iarray[index] = number % 10;
            number /= 10;
        }

        int[] newArray = new int[len];
        for (int x = 0; x <= iarray.length - 1; x++) {
            newArray[(x + nrOfRotations) % iarray.length] = iarray[x];
        }

        for(int i = 0; i < newArray.length / 2; i++)
        {
            int temp = newArray[i];
            newArray[i] = newArray[newArray.length - i - 1];
            newArray[newArray.length - i - 1] = temp;
        }

        StringBuilder strNum = new StringBuilder();

        for (int num : newArray) {
            strNum.append(num);
        }
        int finalInt = Integer.parseInt(strNum.toString());
        //System.out.println(finalInt);

        return finalInt;

    }

}
