import java.io.*;
import java.lang.Number;
class User{
	private String UserName;
	private int step;
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	
}
public class Rank {
	private User[] user=new User[7];
	public Rank() {
		for(int i=0;i<7;i++) {
			user[i]=new User();
		}
	}
    public void compare(String userName,int step) {
    	int j=6;
    	for(int i=0;i<6;i++) {
    		if(step<user[i].getStep()) {
    			j=i;
    			break;
    		}
    	}
    	if(j<6) {
    		for(int i=6;i>j;i--) {
    			user[i].setUserName(user[i-1].getUserName());
    			user[i].setStep(user[i-1].getStep());
    		}
    		user[j].setStep(step);
    		user[j].setUserName(userName);
    	}else {
    		user[6].setStep(step);
    		user[6].setUserName(userName);
    	}
    }
    public String[] display() {
    	String[] string=new String[6];
    	for(int i=0;i<6;i++) {
    		string[i]=user[i].getUserName()+"    "+user[i].getStep();
    		System.out.println(user[i].getUserName()+"  :  "+user[i].getStep());
    	}
    	return string;
    }
    public void readFile() {
        String pathname = "D:\\Java代码\\Guess The Number Game\\src\\rank.txt"; 
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;
            int j;
            for(int i=0;i<6;i++) {
            	line = br.readLine();
            	user[i].setUserName(line);
            	line = br.readLine();
            	j=Integer.parseInt(line);
            	user[i].setStep(j);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeFile() {
        try {
            File writeName = new File("D:\\Java代码\\Guess The Number Game\\src\\rank.txt"); // 相对路径，如果没有则要建立一个新的output.txt文件
            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
            	for(int i=0;i<6;i++) {
            		out.write(user[i].getUserName()+"\r\n"); // \r\n即为换行
                    out.write(user[i].getStep()+"\r\n"); // \r\n即为换行
                    out.flush(); // 把缓存区内容压入文件
            	}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) {
        Rank rank=new Rank();
    	rank.readFile();
    	rank.compare("dsadsa", 35);
    	rank.display();
        rank.writeFile();
    }
}