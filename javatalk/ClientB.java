package javatalk;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
 
public class ClientB {
	public static void main(String[] args) {
        System.out.println("屎壓儖孀A，，，，，，，，，");
        Socket socket = null;
        Scanner Bsay = null;
        Scanner Asay = null;
        PrintWriter toA = null;
        try {
            socket = new Socket(InetAddress.getLocalHost().getHostAddress(),6666);
            Asay = new Scanner(socket.getInputStream());
            System.out.println(Asay.nextLine());
            toA = new PrintWriter(socket.getOutputStream());
            System.out.print("B:");
            Bsay = new Scanner(System.in);
            while(Bsay.hasNextLine()){
                String Bwords = Bsay.nextLine();
                System.out.println("B:"+Bwords);
                toA.println(Bwords);
                toA.flush();  
                String Awords = Asay.nextLine();
                System.out.println("A:"+Awords);
                System.out.print("B:");
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        	Bsay.close();
            toA.close();
            Asay.close();
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }   
    } 
}
