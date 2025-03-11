package simple_inheritance_example;

public class TwinPrimeGenerator {
    public static void main(String[] args){
        int i = generateTwinPrime(95500, 96000);
        System.out.println(i);
    }
    public static int generateTwinPrime(int min, int max) {
        int m = 0;
        for(int i = min + 2; i <= max; i++) {//Iterates through all numbers between min and max to find twin prime
            if(isPrime(i) && isPrime(i-2)) {
                m = i;
                break;
            }
        }
        return m;
    }
    /* Helper function to check if a number is a prime number*/
    static boolean isPrime(int num) {
        for(int i = 2; i < num/2; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

