package javatalk;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
 
public class ClientD {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("Ѱ��A������������������");  
		Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(),6666);
		System.out.println("�ҵ���A"); 
		PrintWriter toA = new PrintWriter(socket.getOutputStream());
		Scanner Bsay = new Scanner(System.in);
		Scanner Asay = new Scanner(socket.getInputStream());
		//B���Բ��Ϸ���Ϣ��A�Ľ���
		Thread send = new Thread(){
	         public void run() {	 
	        	 while(Bsay.hasNextLine()){
	                 String Bwords = Bsay.nextLine();
	                 toA.println(Bwords);
	                 toA.flush();   
	                 if(Bwords.equals("exit")) {
	                	 System.out.println("���뿪��A");
	                	try{
	                		Bsay.close();
	                		toA.close();
							socket.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
	                	 break;
	                 }
	             } 
	         }
		};
		send.start();
		//A���Ͻ���B����Ϣ�Ľ���
		Thread receive = new Thread(){
	         public void run() {
					 while(Asay.hasNextLine()) {
			        	 String Awords = Asay.nextLine();
			        	 if(Awords.equals("exit")) {
		                	 System.out.println("B�뿪����");
		                	 Asay.close();
		                	 break;
		                 }
		                 else {
		                	 System.out.println("B:"+Awords);  
		                 }
			        } 	
	         }
		};
		receive.start();	
    } 
}