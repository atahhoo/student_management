package 学生管理系统;

import java.util.ArrayList;

public class StudentArray {
	ArrayList<Student> ar = new ArrayList<Student>();
	//这个类中封装了get（index）方法，可以通过其来调用存在其中的Student类
	

	public void Quicksort(int start,int end) {
		if(start<end) 
	       { 
	           int key=Begin.a.ar.get(start).studentnumber;//初始化保存基元  
	           int i=start,j;//初始化i,j  
	           for(j=start+1;j<end;j++) 
	           {
	               if(Begin.a.ar.get(j).studentnumber<key)//如果此处元素小于基元，则把此元素和i+1处元素交换，并将i加1，如大于或等于基元则继续循环  
	               { 
	                   Student temp=Begin.a.ar.get(j); 
	                   Begin.a.ar.set(j, Begin.a.ar.get(i+1));
	                   Begin.a.ar.set(i+1, temp);
	                   i++; 
	               } 
	                 
	           } 
	           Student c = Begin.a.ar.get(start);
	           Begin.a.ar.set(start, Begin.a.ar.get(i));
	           Begin.a.ar.set(i, c);
	           Quicksort( start, i-1);//递归调用  
	           Quicksort( i+1, end); 
	             
	       }    // TODO 自动生成的方法存根
		
	}
	
	public  String  Binserch( int searchData, int start, int end) {
		
		Quicksort(0, Begin.a.ar.size());
		int a = start;
		int b = end-1;
		int middle;
		while(a <= b) {
			middle = (a + b)/2;
			if(searchData < Begin.a.ar.get(middle).studentnumber) {
				b = middle - 1;
			}else if(searchData > Begin.a.ar.get(middle).studentnumber) {
				a = middle + 1;
			}else if(searchData == Begin.a.ar.get(middle).studentnumber) {
				String result = "在"+String.valueOf(middle)+"位置";
				return result;
			}
		}
		String error = "参数错误";
		return error;
    }

	public String searchname(String searchData, int start, int end) {
		// TODO Auto-generated method stub
		for(int i=0;i<Begin.a.ar.size();i++) {
			if(Begin.a.ar.get(i).name.equals(searchData)) {
				String searchname = searchData + "在数据库中" + "在"+String.valueOf(i)+"位置";
				return searchname;
			}
		}
		String error ="error";
		return error;
	} 
}