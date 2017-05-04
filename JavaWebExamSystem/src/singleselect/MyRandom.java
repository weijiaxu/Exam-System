package singleselect;

//导入随机化类
import java.util.Random;

public class MyRandom {
	
	private Random rnd=null;
	private int[] s=null;
	
	/*
	 * 生成一个随机数组s用来存储题号，
	 * 传进去两个参数，
	 * 题库中题的总数目max,
	 * 和您希望每个学生挑选的题目个数n
	 */
	public int[] randomFunction(int max,int n){
		//判断max和n是否符合条件
		if(max>=0&&n>=0&&max>=n){
		//初始化随机数和数组对象
		rnd=new Random();
		s=new int[n];
		//临时值temp存放每次生成的随机数
	    int temp;
	    //i控制题目的个数
	    int i=0;
	    //计数器k计算比较的次数
	    int k=0;
	    int j=0;
		//控制生成随机化数不重复
	    while(i<n){ 
	    	//计数器置0
	    	k=0;
	    	//生成一个随机数放入temp
	    	//rnd.nextInt(max)返回一个伪随机数，它是取自此随机数生成器序列的、在 0（包括）和指定值（不包括）之间均匀分布的 int 值
		    temp=rnd.nextInt(max+1);
		    if(temp==0){
		    	temp=temp+1;
		    }
		    //如果是第一个数，则直接放入数组
			if(i==0){
				s[i]=temp;
				i=i+1;
			}
			//如果不是第一个数，则和前面i-1个数比较，都不相同才能放进数组，否则跳出循环
			else{
				  for(j=0;j<=i-1;j++){
					  if(s[j]==temp){
				          break;
					  }
					  else{
						  k=k+1;
					  }
				  }
			      if(k==i){
			         s[i]=temp;
				     i=i+1;
			      }
		   }
	    }
	    return s;
	}
	else{
		System.out.println("您的输入不合法，输入要求为:max>=0&&n>=0&&max>=n");
		return s;
	}
  }
}
