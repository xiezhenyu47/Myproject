
import java.util.Scanner;

class EveryNumber{
	private int number;
	private boolean flag;
	public boolean IsTrue(int num) {
		if(number==num) {
			flag=true;
		}else {
			flag=false;
		}
		return flag;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
public class Number {
	private EveryNumber[] everyNumber;
	private EveryNumber[] inputNumber;
	private int N;
	private int step;
	public Number(int n) {
		N=n;
		step=0;
		this.everyNumber=new EveryNumber[N];
		this.inputNumber=new EveryNumber[N];
		for(int i=0;i<N;i++) {
			everyNumber[i]=new EveryNumber();
			inputNumber[i]=new EveryNumber();
		}
	}
	public void nextStep() {
		this.step++;
	}
	public int[] getRandomNumber() {
		int[] num=new int[4];
		for(int i=0;i<4;i++) {
			num[i]=everyNumber[i].getNumber();
		}
		return num;
	}
	public void randomNumber() {
		int num;
		for(int i=0;i<N;i++) {
			num=(int)(Math.random()*10);
			everyNumber[i].setNumber(num);
		}
	}
	public int[] compareNomber() {
		int trueNumber=0;
		int trueButNotCurrect=0;
		int[] num1= {0,0,0,0,0,0,0,0,0,0};
		int[] num2= {0,0,0,0,0,0,0,0,0,0};
		int[] num= {0,0};
		for(int i=0;i<N;i++) {
			if(everyNumber[i].IsTrue(inputNumber[i].getNumber())) {
				trueNumber++;
			}else {
				num1[everyNumber[i].getNumber()]++;
				num2[inputNumber[i].getNumber()]++;
			}
		}
		int min=0;
		for(int i=0;i<10;i++) {
			min=(num1[i]<=num2[i]?num1[i]:num2[i]);
			trueButNotCurrect+=min;
		}
		num[0]=trueNumber;
		num[1]=trueButNotCurrect;
		return num;
	}
	/*public boolean inputIsTrue(String string) {
		boolean flag;
		if(string.length()!=N) {
			flag=false;
			System.out.println("输入数据长度错误");
		}
	}*/
	public void clean() {
		this.step=0;
	}
	
	public int getStep() {
		return step;
	}
	public void setInputNumber(int x1,int x2,int x3,int x4) {
			inputNumber[0].setNumber(x1);
			inputNumber[1].setNumber(x2);
			inputNumber[2].setNumber(x3);
			inputNumber[3].setNumber(x4);
	}
	
	public int getN() {
		return N;
	}
	public static void main(String[] args) {
		
	}
}
