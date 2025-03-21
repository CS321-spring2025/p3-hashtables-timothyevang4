package simple_inheritance_example;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class HashtableExperiment {
    public static void main(String[] args) {
        //usage statement
        if (args.length < 3) {
            printUsage();
            return;
        }
        //assign variables
        int dataSource = Integer.parseInt(args[0]);
        double loadFactor = Double.parseDouble(args[1]);
        int debugLevel = Integer.parseInt(args[2]);

        // Initialize hash tables
        int minSize = 95500;  // Example minimum size
        int maxSize = 96000;  // Example maximum size

        LinearProbing linearHashTable = new LinearProbing(minSize, maxSize);
        DoubleHashing doubleHashTable = new DoubleHashing(minSize, maxSize);

        // Generate data based on `dataSource`
        List<Object> data = generateData(dataSource, (int) (linearHashTable.m * loadFactor));

        // Insert data into both hash tables
        for (Object key : data) {
            linearHashTable.insert(key);
            doubleHashTable.insert(key);
            if (debugLevel == 2) {
                System.out.println("Inserted " + key);
            }

        }
    }
    //prints usage
    public static void printUsage() {
        System.out.println("""
    Usage: java HashtableExperiment <dataSource> <loadFactor> [<debugLevel>]
    <dataSource>: 1 ==> random numbers
                  2 ==> date value as a long
                  3 ==> word list
    <loadFactor>: The ratio of objects to table size, denoted by alpha = n/m
    <debugLevel>: 0 ==> print summary of experiment
                  1 ==> save the two hash tables to a file at the end
                  2 ==> print debugging output for each insert
    """);
    }
        // Generates data based on the selected source
        public static List<Object> generateData(int dataSource, int count) {
            List<Object> data = new ArrayList<>();
            Random random = new Random();

            switch (dataSource) {
                case 1: // Random numbers
                    for (int i = 0; i < count; i++) {
                        data.add(random.nextInt(100000));  // Random integers
                    }
                    break;
                case 2: // Date values as long
                    long currentTime = System.currentTimeMillis();
                    for (int i = 0; i < count; i++) {
                        data.add(currentTime + i);
                    }
                    break;
                case 3: // Word list (Example: Using hardcoded words)
                    String[] words = {"apple", "banana", "cherry", "date", "elderberry"};
                    for (int i = 0; i < count; i++) {
                        data.add(words[random.nextInt(words.length)]);
                    }
                    break;
                default:
                    System.out.println("Invalid data source.");
                    System.exit(1);
            }
            return data;
        }

        // Saves results to a file
        public static void saveResults(Hashtable linear, Hashtable doubleHash) {
            try (PrintWriter writer = new PrintWriter(new File("hash_results.txt"))) {
                writer.println("Linear Probing Hashtable:");
                writer.println(Arrays.toString(linear.table));
                writer.println("\nDouble Hashing Hashtable:");
                writer.println(Arrays.toString(doubleHash.table));
                System.out.println("Results saved to hash_results.txt");
            } catch (Exception e) {
                System.out.println("Error writing results to file.");
            }
        }

        // Prints a summary of the experiment
        public static void printSummary(Hashtable linear, Hashtable doubleHash) {
            System.out.println("Experiment Summary:");
            System.out.println("Linear Probing Table Size: " + linear.m);
            System.out.println("Double Hashing Table Size: " + doubleHash.m);
        }
    }


