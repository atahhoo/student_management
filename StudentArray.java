package ѧ������ϵͳ;

import java.util.ArrayList;

public class StudentArray {
	ArrayList<Student> ar = new ArrayList<Student>();
	//������з�װ��get��index������������ͨ���������ô������е�Student��
	

	public void Quicksort(int start,int end) {
		if(start<end) 
	       { 
	           int key=Begin.a.ar.get(start).studentnumber;//��ʼ�������Ԫ  
	           int i=start,j;//��ʼ��i,j  
	           for(j=start+1;j<end;j++) 
	           {
	               if(Begin.a.ar.get(j).studentnumber<key)//����˴�Ԫ��С�ڻ�Ԫ����Ѵ�Ԫ�غ�i+1��Ԫ�ؽ���������i��1������ڻ���ڻ�Ԫ�����ѭ��  
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
	           Quicksort( start, i-1);//�ݹ����  
	           Quicksort( i+1, end); 
	             
	       }    // TODO �Զ����ɵķ������
		
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
				String result = "��"+String.valueOf(middle)+"λ��";
				return result;
			}
		}
		String error = "��������";
		return error;
    }

	public String searchname(String searchData, int start, int end) {
		// TODO Auto-generated method stub
		for(int i=0;i<Begin.a.ar.size();i++) {
			if(Begin.a.ar.get(i).name.equals(searchData)) {
				String searchname = searchData + "�����ݿ���" + "��"+String.valueOf(i)+"λ��";
				return searchname;
			}
		}
		String error ="error";
		return error;
	} 
}