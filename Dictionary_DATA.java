

	import java.io.File;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.util.Scanner;

	public class EV_2_DATA
	{

		public static void main(String[] args)
		{
			Scanner sc = new Scanner(System.in);
			String s;

			try
			{
				FileWriter fwriter = new FileWriter(new File("d:/Dictdata.txt"));
				PrintWriter outputFile = new PrintWriter(fwriter);
				System.out.println("กรุณาพิมพ์คำที่ต้องการเพิ่มในดิกชันนารี ภาษาอังกฤษ,ภาษาไทย เช่น Zebra,ม้าลาย");
				for (int i = 1; i <= 100; i++)
				{
					System.out.print(i + ".");
					s = sc.nextLine();
					outputFile.println(s);
				}
				sc.close();
				outputFile.close();

			} catch (IOException e)
			{
				e.printStackTrace();
			}
			
		}

	}


