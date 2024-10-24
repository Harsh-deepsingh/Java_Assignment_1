package appDomain;




import shapes.*;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class AppDriver
{

	public static void main( String[] args )
	{
		// TODO Auto-generated method stub

		// refer to demo001 BasicFileIO.java for a simple example on how to
		// read data from a text file

		// refer to demo01 Test.java for an example on how to parse command
		// line arguments and benchmarking tests

		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)

		// refer to demo03 OfficeManager.java on how to create specific
		// objects using reflection from a String
            String fileName = "res/shapes1.txt";
        char sortType = 'h';
        char algorithm = 'b';  // Default to Bubble Sort

        // Parse command line arguments
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-f")) {
                fileName = args[i].substring(2);
            } else if (args[i].startsWith("-t")) {
                sortType = args[i].charAt(2);
            } else if (args[i].startsWith("-s")) {
                algorithm = args[i].charAt(2);
            }
        }

        // Read shapes from file
        Shapes[] shapes = null;
        try {
            shapes = readShapesFromFile(fileName);
            
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Choose comparator
        Comparator<Shapes> comparator = null;
        switch (sortType) {
            case 'h':
                
                comparator = Comparator.naturalOrder();
                
                break;
            case 'a':
                comparator = new BaseArea();
                break;
            case 'v':
                comparator = new Volume();
                break;
        }

        // Sort based on algorithm
        long startTime = System.currentTimeMillis();
        switch (algorithm) {
            case 'b':
                BubbleSort.sort(shapes);
                break;
            case 's':
                SelectionSort.sort(shapes);
                break;
            case 'i':
                InsertionSort.sort(shapes);
                break;
            case 'm':
                MergeSort.sort(shapes);
                break;
            case 'q':
                QuickSort.sort(shapes);
                break;
            case 'h':
                HeapSort.sort(shapes);
                break;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Sorting time: " + (endTime - startTime) + " ms");

        // Output sorted array (first and last elements, and every thousandth element)
        printSortedArray(shapes);
    }

    private static Shapes[] readShapesFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int numShapes = Integer.parseInt(reader.readLine());
        Shapes[] shapes = new Shapes[numShapes];
        for (int i = 0; i < numShapes; i++) {
            String line = reader.readLine();
            if (line == null) {
                System.err.println("Unexpected end of file. Expected " + numShapes + " shapes, but file has fewer entries.");
                break;
            }
            
            String[] tokens = line.split(" ");
            if (tokens.length < 3) {
                System.err.println("Invalid line format at line " + (i + 2) + ": " + line);
                continue;
            }
            
                   

            String shapeType = tokens[0];
            double height = Double.parseDouble(tokens[1]);
            double baseDimension = Double.parseDouble(tokens[2]);
            System.out.println(Arrays.toString(tokens));

            switch (shapeType) {
                case "Cylinder":
                    shapes[i] = new Cylinder(baseDimension, height);
                    break;
                case "Cone":
                    shapes[i] = new Cone(baseDimension, height);
                    break;
                case "Pyramid":
                    shapes[i] = new Pyramid(height, baseDimension);
                    break;
                case "SquarePrism":
                    shapes[i] = new SquarePrism(height, baseDimension);
                    break;
            }
        }
        return shapes;
    }

    private static void printSortedArray(Shapes[] shapes) {
        System.out.println("First shape: " + shapes[0]);
        for (int i = 1000; i < shapes.length; i += 1000) {
            System.out.println("Shape at index " + i + ": " + shapes[i]);
        }
        System.out.println("Last shape: " + shapes[shapes.length - 1]);
    }
            
            
            
	

}
