package tw.test.tutor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class file_reader2_1 {

	public static void main(String[] args) throws IOException {
		FileReader reader = new FileReader("dir1/ns1hosp.csv");
		BufferedReader buffer = new BufferedReader(reader);
		
		String line;
		while((line = buffer.readLine())!= null) {
			String[] data = line.split(",");
			System.out.print(data[0] + " : ");
			System.out.print(data[1] + " : ");
			System.out.print(data[2] + " : ");
			System.out.print(data[3] + " : ");
			System.out.print(data[4] + " : ");
			System.out.print(data[5] + " : ");
			System.out.print(data[6] + " : ");
			System.out.println(data[7]);
		}
		
		buffer.close();
	}

}
