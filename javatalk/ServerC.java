package javatalk;
import java.io.IOException; 
import java.io.PrintWriter; 
import java.net.ServerSocket; 
import java.net.Socket; 
import java.util.Scanner; 

public class ServerC { 
	public static void main(String[] args) throws IOException {   
		System.out.println("�ȴ�B������������������");  
        ServerSocket A = new ServerSocket(6666);; 
        Socket socket = A.accept(); 
        System.out.println("B�������㣬����IP��ַ��"+socket.getInetAddress());  
        PrintWriter toB = new PrintWriter(socket.getOutputStream()); 
        Scanner Asay = new Scanner(System.in);
        Scanner Bsay = new Scanner(socket.getInputStream());
        //A���Բ��Ϸ���Ϣ��B�Ľ���
        Thread send = new Thread(){
            public void run() {
            	try {
					PrintWriter toB = new PrintWriter(socket.getOutputStream());
				} catch (IOException e) {
					e.printStackTrace();
				}
            	while(Asay.hasNextLine()) {   
            			String Awords = Asay.nextLine(); 
            			toB.println(Awords); 
            			toB.flush();    
            			if(Awords.equals("exit")) {
      	                	 System.out.println("���뿪��B");
      	                	 Asay.close();
      	                	 try {
      	                		socket.close();
      	                		toB.close();
								A.close();
								
							} catch (IOException e) {
								e.printStackTrace();
							}
      	                	 break;
               			}
            	}
            }
        };
        send.start();
        //A���Ͻ���B����Ϣ��
        Thread receive = new Thread(){
            public void run() {
            	while(Bsay.hasNextLine()){ 
				     String Bwords = Bsay.nextLine();
				     if(Bwords.equals("exit")) {
				    	 System.out.println("B�뿪����");
				    	 Bsay.close();
				    	 break;
				     }
				     else {
				    	 System.out.println("B:"+Bwords);  
				     }
				 } 
            }
        };
        receive.start();  
  }   
}