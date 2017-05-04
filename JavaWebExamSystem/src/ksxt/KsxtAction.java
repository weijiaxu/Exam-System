package ksxt;

import java.util.ArrayList;

public class KsxtAction {
	private String otitle;
	public String getOtitle(){
		return otitle;
	}
	public void setOtitle(String otitle){
		this.otitle=otitle;
	}
	private String operationid;
	public String getOperationid(){
		return operationid;
	}
	public void setOperationid(String operationid){
		this.operationid=operationid;
	}
	private String sno;
	public String getSno(){
		return sno;
	}
	public void setSno(String sno){
		this.sno=sno;
	}
	private int num;
	public int getNum(){
		return num;
	}
	public void setNum(int num){
		this.num=num;
	}
	public String execute() throws Exception {
		return "success";
}
	//选择操作题函数，调用ksxtDao.selectOperations()函数执行数据库
	public ArrayList operate(String ope,int m1,int m2,int m3) throws Exception{
		KsxtDao ksxtDao = new KsxtDao();
        ArrayList operations = ksxtDao.selectOperations(ope,m1,m2,m3);
    	return operations;
	}
	//根据学号查询grade表中操作题题号
	public String queryOpeid(String account){
		KsxtDao que = new KsxtDao();
		String operaid = que.selectOpeid(account);
		return operaid;
	}
}