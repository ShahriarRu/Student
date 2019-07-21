import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
public static void main(String[] args) {


//		Check arguments
        if (args == null || args.length != 1)
        {
            System.out.println("Error!!! Please Pass right Arguments");
            return; // Exit early.
        }

		else if(args[0].equals(Constants.ShowAll)) 
		{
			System.out.println("Loading data ...");		
			try {
				FileInputStream in = new FileInputStream(Constants.StudentList);
				InputStreamReader isr = new InputStreamReader(in);
				BufferedReader s = new BufferedReader(isr); 
				String r = s.readLine(); String i[] = r.split(Constants.StudentEntryDelimiter);

				for(String j : i){
			 		System.out.println(j);
				}
			}catch (Exception e){} 
			System.out.println("Data Loaded.");
		}


		else if(args[0].equals(Constants.ShowRandom)) 
		{
			System.out.println("Loading data ...");			
			try {
				FileInputStream in = new FileInputStream(Constants.StudentList);
				InputStreamReader isr = new InputStreamReader(in);
				BufferedReader s = new BufferedReader(isr);
				String r = s.readLine();
				System.out.println(r);
				String i[] = r.split(Constants.StudentEntryDelimiter);	
				Random x = new Random(0);
				int y = x.nextInt();
				System.out.println(i[y]);
			} catch (Exception e){} 
			System.out.println("Data Loaded.");			
		}

		else if(args[0].contains(Constants.AddEntry)){
			System.out.println("Loading data ...");			
			try {
				FileWriter fw = new FileWriter(Constants.StudentList, true);
				BufferedWriter s = new BufferedWriter(fw);
				String t = args[0].substring(1);
	        	Date d = new Date();
	        	String df = "dd/mm/yyyy-hh:mm:ss a";
	        	DateFormat dateFormat = new SimpleDateFormat(df);
	        	String fd= dateFormat.format(d);
				s.write(", "+t+"\nList last updated on "+fd);
				s.close();
			}catch (Exception e){}							
			System.out.println("Data Loaded.");	
		}

		else if(args[0].contains(Constants.FindEntry)) 
		{
			System.out.println("Loading data ...");			
			try {
				BufferedReader s = new BufferedReader(
					new InputStreamReader(
						new FileInputStream(Constants.StudentList))); 
				String r = s.readLine();
				String i[] = r.split("Constants.StudentEntryDelimiter");	
				boolean done = false;
				String t = args[0].substring(1);
				for(int idx = 0; idx<i.length && !done; idx++) {
				if(i[idx].equals(t)) {
					System.out.println("We found it!");
					done=true;
				}
			}
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}

		else if(args[0].contains(Constants.ShowCount)) 
		{
			System.out.println("Loading data ...");			
			try {
				FileInputStream in = new FileInputStream("student.txt");
				InputStreamReader isr = new InputStreamReader(in);
				BufferedReader s = new BufferedReader(isr);
				String D = s.readLine();
				char a[] = D.toCharArray();			
				boolean in_word = false;
				int count=0;
				for(char c:a) {
					if(c ==' ') 
					{
						if (!in_word) 
							{
								count++; in_word =true;
							}

						else { 
							in_word=false;
						}			
					}
				}
				System.out.println(count +" word(s) found " + a.length);
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
	}
}
