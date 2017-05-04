package singleselect;

public class TeacherAction {
	private String forward;
	
	
	public String getForward() {
		return forward;
	}


	public void setForward(String forward) {
		this.forward = forward;
	}


	public String execute(){
		String result="teacher";
		if(getForward().equals("pingfeng")){
			result="pingfeng";
		}
		if(getForward().equals("main")){
			result="main";
		}
		if(getForward().equals("operation")){
			result="operation";
		}
		if(getForward().equals("teststate")){
			result="teststate";
		}
		return result;
	}

}
