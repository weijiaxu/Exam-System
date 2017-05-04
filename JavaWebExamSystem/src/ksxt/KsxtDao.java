package ksxt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;

public class KsxtDao {
	//加载驱动，返回一个Statement接口
	QD qd = new QD();
    Statement stat= qd.Stat();
    //m1,m2,m3对应于要抽取简单题、中等题、复杂题数目，由.jsp传过来。m为根据所需操作题总数抽出的题的数目(可能会由于题库原因，所选结果不是所需题的总数)
    private int m1,m2,m3;
    private int m;
    //以下3个函数由opeidArray();调用opeNum(int m1,String rank);调用array(int m1,int sum)，产生索取题的题号数组。在操作题题号已存在时被sql(ope);函数调用，返回相应的sql语句。
    //--------------------------------------------------------------------------------------------------------------
    //产生长度为3的随机数组函数,m为随机选的题数目
    public int[] array(int m1,int sum){
    	if(m1>sum){
			  m1=sum;
		  }
		  int[] arr=new int[m1];
		  for(int i =0;i<m1;i++){
		    arr[i]=(int)(Math.random()*sum);
		  }
		  for(int k=1;k<m1;k++){
				for(int j=0;j<k;j++){
					if(arr[k]==arr[j]){
						arr[k]=(int)(Math.random()*sum);
						j=-1;
					}else{}
					}}
		  return arr;
    }
    //返回m1道简单题题号数组,题号未排序
    public int[] opeNum(int m1,String rank){
    	int i=0;int[] arr;
    	try{
			String sql2=null;
			//得到简单题数目sum
			sql2="select count(*) sum from operation where rank='"+rank+"';";
			ResultSet rs3 = stat.executeQuery(sql2);
			rs3.next();
			int sum=rs3.getInt("sum");
			rs3.close();
			//定义一个存简单题题号的数组
			int[] openum=new int[sum];
			sql2="select * from operation where rank='"+rank+"'";
			ResultSet rs2 = stat.executeQuery(sql2);
			while(rs2.next()){
				KsxtAction operation2 = new KsxtAction();
				operation2.setNum(rs2.getInt("operationid"));
				openum[i]=operation2.getNum();
				i++;
			}
			rs2.close();
			//调用随机数组产生随机下标数组，根据下标选出简单题题号数组中的m1个题号数组
	    	int[] xiabiao=array(m1,i);
	    	for(int w=0;w<xiabiao.length;w++){
	    	}
	    	//如果需要的简单题数目超过数据库中简单题的总数
	    	if(m1>i){
	    		m1=i;
	    	}
	    	arr=new int[m1];
	    	//int[] arr=new int[m1];//如果数组只声明不定义长度，在使用arr[0]时会出现空指针异常
	    	//如果在这定义arr在下面return arr;时，会返回空。因为“在一个程序段内定义的变量，不能此程序段外使用！”，所以在此函数开头定义arr数组。
	    	for(int j=0;j<m1;j++){
	    		arr[j]=openum[xiabiao[j]];	
	    	}
		}catch(SQLException e){
			e.printStackTrace();
			if(m1>i){
	    		m1=i;
	    	}
			arr=new int[m1];
		}
    	return arr;
    }
    //随机所选操作题题号数组，包括所需简单题、中等题、复杂题
    public int[] opeidArray(){
    	int[] arr1=opeNum(m1,"easy");
    	int[] arr2=opeNum(m2,"middle");
    	int[] arr3=opeNum(m3,"difficult");
    	int[] array=new int[arr1.length+arr2.length+arr3.length];
    	for(int i=0;i<arr1.length;i++){
    		array[i]=arr1[i];
    	}
    	for(int i=0;i<arr2.length;i++){
    		array[arr1.length+i]=arr2[i];
    	}
    	for(int i=0;i<arr3.length;i++){
    		array[arr1.length+arr2.length+i]=arr3[i];
    	}
    	return array;
    }
    //--------------------------------------------------------------------------------------------------------------
    //如果操作题题号已存在，则截断操作题字符串，取出题号赋值给th数组。在操作题题号已存在时被sql(ope);函数调用，返回相应的sql语句。
    public String[] opeid(String ope){
    	//给所取操作题总数m赋初值，m++之后的m
		m=1;//此处不能写为int m=1;m用作全局变量
		for(int j=0;j<ope.length();j++){
			String a=ope.charAt(j)+"";
		    if(a.equals(",")){
		    	m++;
		    }
		}
		String[] th=new String[m];
	    String b="";
	    for(int j=0,k=0;j<ope.length();j++){
	    String a=ope.charAt(j)+"";
	    if(!a.equals(",")){
	    b=b+a;
	    }else{
	    th[k]=b;k++;
	    b="";
	    }
	    }
	    th[m-1]=b;
	    return th;
    }
    //根据所接收ope参数返回不同的sql语句
    public String sql(String ope){
    	String sql=null,sq=null;
    	//如果grade表不存在操作题题号字符串，则sql语句为下
    	if(ope.equals("0")){
    		//得到一个随机数组，数组内数字未排序
        	int[] ar=opeidArray();
			sql="select * from operation where ";
			//给所取操作题总数m赋初值ֵ
			m=ar.length;
			for(int n=0;n<m;n++){
				sq="operationid="+ar[n]+"";
				if(n==m-1){
				sql=sql+sq;
				}else{
				sql=sql+sq+" or ";	
				}
			}
			//根据所需题和数据库题，所选出的总题数m
			if(m==0){
				sql="select * from operation where operationid=null";
			}
		}//如果grade表已存在操作题题号字符串，则sql语句为下
		else{
			//根据ope操作题题号字符串，调用函数返回题号数组			
			String[] th=opeid(ope);
			sql="select * from operation where ";
			for(int n=0;n<m;n++){
				sq="operationid="+th[n]+"";
				if(n==m-1){
				sql=sql+sq;
				}else{
				sql=sql+sq+" or ";	
				}
			}
		}
    	return sql;
    }
    //挑选操作题，返回题VO的数组
	public ArrayList selectOperations(String ope,int a,int b,int c) throws Exception{
		m1=a;m2=b;m3=c;//此处形参不能为m1,m2,m3，来分别赋值给全局变量m1,m2,m3。这里m1,m2,m3将被认为是形参而不是全局变量。
		Map session = ActionContext.getContext().getSession();
		ArrayList operations=new ArrayList();
		try{//根据ope参数值，调用函数选择要执行的sql语句
			String sql=sql(ope);
			ResultSet rs = stat.executeQuery(sql);
			String s,ss="";
			int q=1;
			//KsxtAction operation = new KsxtAction();//错误！！！
			while(rs.next()){
				KsxtAction operation = new KsxtAction();//必须定义在内部，否则在,jsp端输出的操作题将是该对象的最后一次赋的值，即全是最后一题题目
				s=rs.getString("operationid");
				operation.setOperationid(s);
				if(q==m){ss=ss+s;}else{ss=ss+s+",";}
				q++;
				operation.setOtitle(rs.getString("otitle"));
				//将操作题记录集放到operations对象数组里，作为此函数的返回
				operations.add(operation);
			}
			if(ope.equals("0")){
				//调用下面的addope()函数，将上面随机选出的m个操作题的字符串添加到grades中
				//老师说DAO里面一般不用session，而是在Action中用，所以此处的sid最好是参数传进来
				String account=(String)session.get("account");
				addope(account,ss);
			}
			rs.close();
			stat.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return operations;
	}
	//将学号选择的操作题号添加到grade表中
	public boolean addope(String account,String operaid)
	 {
		 boolean result=false;	
			try {
				String sql="update grade set opeid='"+operaid+"' where sno='"+account+"'";
				if(m==0){
					sql="update grade set opeid=null where sno='"+account+"'";
				}
				int rs = stat.executeUpdate(sql);
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		 return result;
	 }
	//根据学号在grade表中查看操作题题号是否存在
	public String selectOpeid(String account){
		String opeid=null;
		try{
			String sql="select * from grade where sno='"+account+"'";
			ResultSet rs = stat.executeQuery(sql);
			if(rs.next()){
				opeid=rs.getString("opeid");
			}
			rs.close();
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return opeid;
	}
	//在上传成功后改变student表中考生状态״̬
	public void changeState(String x){
		try{
			String sql="update student set loginstate='finished' where sno='"+x+"';";
			stat.executeUpdate(sql);
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}