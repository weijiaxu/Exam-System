package ksxt;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import java.io.*;
import java.util.Map;
import com.opensymphony.xwork2.ActionSupport;
import ksxt.KsxtDao;

//锟较达拷锟侥硷拷锟斤拷Action
public class UploadAction extends ActionSupport
{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String title;
 	//为文件
    private File[] upload;
    //为文件类型
    private String[] uploadContentType;
    //为文件名
    private String[] uploadFileName;
 //锟斤拷锟斤拷锟斤拷锟斤拷注锟斤拷锟斤拷锟斤拷锟�
    //为文件保存的路径
    private String savePath;
 //锟斤拷锟斤拷锟斤拷锟斤拷注锟斤拷姆锟斤拷锟�
    public void setSavePath(String value){
        this.savePath = value;
    }
    private String getSavePath() throws Exception{
        return ServletActionContext.getRequest().getRealPath(savePath);//锟斤拷锟杰革拷为return savePath;
    }
 public void setTitle(String title) {
  this.title = title;
 }
 public void setUploadContentType(String[] uploadContentType) {
  this.uploadContentType = uploadContentType;
 }
 public void setUploadFileName(String[] uploadFileName) {
  this.uploadFileName = uploadFileName;
 }
 public String getTitle() {
  return (this.title);
 }
 public File[] getUpload() {
	 System.out.println(this.upload+"111111");
  return (this.upload);
 }
 public void setUpload(File[] upload){//setUpload()函数要写在getUpload()函数后面。否则报错找不到setUpload()函数。
	 this.upload=upload;
 }
 public String[] getUploadContentType() {
  return (this.uploadContentType);
 }
 public String[] getUploadFileName() {
  return (this.uploadFileName);
 }
 
 @Override
 public void validate()
 {
	 Map session = ActionContext.getContext().getSession();
	 //锟斤拷锟斤拷锟斤拷锟节碉拷锟斤拷洗锟街拷螅锟斤拷锟斤拷俅锟斤拷峤伙拷锟斤拷锟角帮拷锟斤拷锟揭筹拷妫拷锟斤拷锟劫达拷锟斤拷涌锟斤拷锟斤拷锟较拷锟絞rade锟斤拷锟叫ｏ拷锟斤拷锟斤拷违锟斤拷锟斤拷锟皆硷拷锟�
  File[] files = upload;
  if(files==null){
	  session.put("sid2", "n");
  }else{ 
	  String[] c=getUploadFileName();
		 String h=c[0];
		 String x = (String)session.get("account");
	  if(h.equals(x+".zip")||h.equals(x+".rar")){
	  try{
  for (int i = 0 ; i < files.length ; i++)
  {
   //闁跨喓娈曢崙銈嗗闁跨喐鏋婚幏鐑芥晸閺傘倖瀚归柨鐔告灮閹风兘鏁撴笟銉с�閹风兘鏁撻弬銈嗗闁跨喐鏋婚幏鐑芥晸鐞涙鍤栭幏鐑芥晸閻ㄥ棭鍙忛幏宄板珯闁跨喐鏋婚幏鐑芥晸閺傘倖瀚归柨鐔告灮閹烽攱绀傞柨鐔告灮閹峰嘲瀚欓柨鐔告灮閹风兘鏁撻弬銈嗗闁跨喐鏋婚幏锟�  
	  FileOutputStream fos = new FileOutputStream("D:/upload" + "/" + getUploadFileName()[i]);
   FileInputStream fis = new FileInputStream(files[i]);
   byte[] buffer = new byte[1024];
   int len = 0;
   //当输入流fis中还有数据时，就写入输出流fos中，放到D:/upload文件夹下
   while ((len = fis.read(buffer)) > 0)
   {
    fos.write(buffer , 0 , len);
   }fis.close();fos.close();fos.flush();fos=null;
  }
  session.put("sid2", "y");
  //改变考试状态
  KsxtDao change = new KsxtDao();
  change.changeState(x);
  }catch(Exception e){
	  session.put("sid2", "e"); 
	  e.printStackTrace();
  }
   }else{
	   session.put("sid2", "f"); 
   }
   }
  }
 public String up(){
	 Map session = ActionContext.getContext().getSession();
	 String sid2=(String)session.get("sid2");
	 if(sid2.equals("y")){
		 return "end";
	 }else{
	 return "success";
	 }
 }
}