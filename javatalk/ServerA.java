package javatalk;
import java.io.IOException; 
import java.io.PrintWriter; 
import java.net.ServerSocket; 
import java.net.Socket; 
import java.util.Scanner; 

public class ServerA { 
	public static void main(String[] args) {   
        System.out.println("�ȴ�B�ҵ��㡤����������������"); 
        PrintWriter toB = null; 
        Scanner Asay = null; 
        Scanner Bsay = null; 
        ServerSocket A = null; 
        try { 
            A = new ServerSocket(6666); 
            Socket socket = A.accept(); 
            System.out.println("B�������㣬����IP��ַ��"+socket.getInetAddress());     
            toB = new PrintWriter(socket.getOutputStream()); 
            toB.println("�㷢����A,����˵"); 
            toB.flush(); 
            Asay = new Scanner(System.in); 
            Bsay = new Scanner(socket.getInputStream()); 
    
            while(Bsay.hasNextLine()){ 
                String Bwords = Bsay.nextLine(); 
                System.out.println("B:"+Bwords); 
                System.out.print("A:"); 
                String Awords = Asay.nextLine(); 
                System.out.println("A:"+Awords); 
                toB.println(Awords); 
                toB.flush(); 
            } 
        } catch (IOException e) { 
            e.printStackTrace(); 
        }finally { 
        	toB.close(); 
            Asay.close(); 
            Bsay.close(); 
            try { 
                A.close(); 
            } catch (IOException e) { 
                e.printStackTrace(); 
            } 
        } 
    } 
}