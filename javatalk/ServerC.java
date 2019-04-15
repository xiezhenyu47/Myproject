package javatalk;
import java.io.IOException; 
import java.io.PrintWriter; 
import java.net.ServerSocket; 
import java.net.Socket; 
import java.util.Scanner; 

public class ServerC { 
	public static void main(String[] args) throws IOException {   
		System.out.println("等待B·········");  
        ServerSocket A = new ServerSocket(6666);; 
        Socket socket = A.accept(); 
        System.out.println("B看见了你，他的IP地址："+socket.getInetAddress());  
        PrintWriter toB = new PrintWriter(socket.getOutputStream()); 
        Scanner Asay = new Scanner(System.in);
        Scanner Bsay = new Scanner(socket.getInputStream());
        //A可以不断发信息给B的进程
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
      	                	 System.out.println("你离开了B");
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
        //A不断接收B的信息的
        Thread receive = new Thread(){
            public void run() {
            	while(Bsay.hasNextLine()){ 
				     String Bwords = Bsay.nextLine();
				     if(Bwords.equals("exit")) {
				    	 System.out.println("B离开了你");
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