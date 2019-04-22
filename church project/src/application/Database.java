package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Database {

	File song_list = new File("src\\application\\Song_List.txt");
	
	public String input(String song_name, int number_verse, int number_chorus) 
	{
		try {
			int num;
			
			PrintWriter write = new PrintWriter(new FileOutputStream((song_list), true));
			
			write.append(song_name + " " + " {");
			
			if(number_chorus == 0) {
				for (int i = 0; i < number_verse; i++) {
					num = i + 1;
					
					write.append("\r\n\t\tverse " + num);
				}
			}
			else {
				for(int i = 0; i < number_chorus; i++) {
					num = i + 1;
					
					write.append("\r\n\t\tverse " + num);
					write.append("\r\n");
					write.append("\t\tchorus " + num);
				}
			}
			
			write.append("\r\n\t}\r\n");
			
			write.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found ");
		}
		
		return "Song recorded";
	}
	
	public static void main(String[] args)
	{
		Database dbtester = new Database();
		
		System.out.println(dbtester.input("God's Grace", 2, 2));
		System.out.println(dbtester.input("Amazing Grace", 4, 0));
	}
}
