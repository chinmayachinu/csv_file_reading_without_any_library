import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadCsv {

	public static void main(String[] args) throws IOException {
	    Scanner scanner=new Scanner(System.in);

	    Path path = Paths.get("D://data/employee1.csv");
    	Stream<String> lines = Files.lines(path);

	    //reading the complete csv
	    if (Files.exists(path)){
            List<List<String>> columns = lines
                .map((line) -> Arrays.asList(line.split(",")))
                .collect(Collectors.toList());
            columns.forEach((l)->System.out.println(l));
            //Reading the csv according to the salary
            //Enter the salary to see the employee are there earning the same or more or less
    	    System.out.println("enter the salary");
    	    int sal=scanner.nextInt(); 
    	    System.out.println("1.Check the employee above inputed salary   2.Check the employee below the salary");
    	    int n=scanner.nextInt();
    	    switch (n) {
			case 1:
				System.out.println("These are the employees having salary above "+sal);

	    	    columns.forEach((c)->{
	    	    	int salary=Integer.parseInt(c.get(2));

	    	    	if(sal<=salary)
	    	    	{
	    	    		System.out.println(c);
	    	    	}
	    	    });
				break;
			case 2:
				System.out.println("These are the employees having salary less then "+sal);

	    	    columns.forEach((c)->{
	    	    	int salary=Integer.parseInt(c.get(2));

	    	    	if(sal>=salary)
	    	    	{
	    	    		System.out.println(c);
	    	    	}
	    	    });
				break;
			default:System.out.println("Invalid input");
				break;
			}
    		
    	    
    	    
    	    //reading the csv based on grade
    	    System.out.println("enter the grade of employee");
    	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	    String grade=br.readLine();
    	    columns.forEach((c)->{
    	    String employeeGrade=c.get(1);

    	    	if(employeeGrade.equalsIgnoreCase(grade))
    	    	{
    	    		System.out.println(c);
    	    	}
    	    });
    	    
    	    
    	    //reading the csv based on contact number
    	    System.out.println("enter the contact number of employee");
    	    long num=Long.parseLong(br.readLine());
    	    columns.forEach((c)->{
    	    long contactNumber=Long.parseLong(c.get(3));

    	    	if(num==contactNumber)
    	    	{
    	    		System.out.println(c);
    	    	}
    	    	
    	    });

    	    
	    }
	    
	    
	}

}
