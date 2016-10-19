package com.lining.struts2;

import java.sql.*;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import com.lining.struts2.book;
import com.lining.struts2.authoraction;
import com.lining.struts2.author;
public class bookaction extends ActionSupport{
	private ArrayList<book> books = new ArrayList<book>();
	private Connection conn = null;
	
	private String qisbn;
	private String qaname;
	
	private String nisbn;
	private String ntitle;
	private String nauthorid;
	private String npublisher;
	private String npublishdata;
	private String nprice;

	private String a_name;
	private String a_age;
	private String a_country;
	
	private void connect() {
		try {
			String URL ="jdbc:mysql://wppvbamivosx.rds.sae.sina.com.cn:10395/bookdb";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "p123456");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void disconnect() {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}

	private void query(String sql) {
		connect();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				books.add(new book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6)));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		disconnect();
	}
	
	public String queryall() {
		query("SELECT * FROM Book");
		for (book b : books){
			b.author = authoraction.queryone(b.getAuthorid()).getName();
		}
		return "success";
	}

	public String queryisbn() {
		query("SELECT * FROM Book where ISBN = " + qisbn);
		author temp = authoraction.queryone(books.get(0).getAuthorid());
		a_name = temp.getName();
		a_age = temp.getAge();
		a_country = temp.getCountry();
		return "success";
	}

	public String queryauthor() {
		connect();
		ArrayList<String> ss = authoraction.queryname(qaname);
		for (String s : ss){//get author_id list
			try {
				PreparedStatement ps = conn.prepareStatement("select * from Book where Author_ID="+s);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					books.add(new book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6)));
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		disconnect();
		return "success";
	}
	
	private String check(){
		String temp = "success";
		connect();
		try{
			Statement stmt = conn.createStatement();
			String sql = "select * from Author where Author_ID="+nauthorid;
			ResultSet res = stmt.executeQuery(sql);
			if(!res.next()){temp = "error";}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		disconnect();
		return temp;
	}
	public String create() {
		connect();
		try {
			Statement stmt = conn.createStatement();
			String sql = "insert into Book values("+nauthorid+",'"+ntitle+"','"+npublisher+"','"+npublishdata+"',"+nprice+",'"+nisbn+"')";
			int result = stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			addFieldError("nisbn","ISBN重复");
			return "input";
		}
		disconnect();
		return check();
	}
	public void validateCreate()
	{
		  if (nauthorid == null || nauthorid.trim().equals(""))
	      {
	         addFieldError("nauthorid","请输入编号");
	      }else{
	    	  Pattern pattern = Pattern.compile("[0-9]*");
	    	  Matcher isNum = pattern.matcher(nauthorid);
	    	  if( !isNum.matches() ){
	    		  addFieldError("nauthorid","请全部输入数字");
	    	  }
	      }//id
	      if (ntitle == null || ntitle.trim().equals(""))
	      {
	         addFieldError("ntitle","请输入题目");
	      }//title
	      if (npublisher == null || npublisher.trim().equals(""))
	      {
	         addFieldError("npublisher","请输入出版商");
	      }//publisher
	      if (npublishdata == null || npublishdata.trim().equals(""))
	      {
	         addFieldError("npublishdata","请输入出版日期");
	      }else{
	    	  Pattern pattern = Pattern.compile("(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)");
	    	  Matcher isNum = pattern.matcher(npublishdata);
	    	  if( !isNum.matches() ){
	    		  addFieldError("npublishdata","请输入正确日期:yyyy-mm-dd");
	    	  }
	      }//publisherdata
	      if (nprice == null || nprice.trim().equals(""))
	      {
	         addFieldError("nprice","请输入价格");
	      }else{
	    	  Pattern pattern = Pattern.compile("^[0-9]+(\\.[0-9]{2})?$");
	    	  Matcher isNum = pattern.matcher(nprice);
	    	  if( !isNum.matches() ){
	    		  addFieldError("nprice","请输入正确价格 支持两位小数");
	    	  }
	      }//price
	      if (nisbn == null || nisbn.trim().equals(""))
	      {
	         addFieldError("nisbn","请输入ISBN编号");
	      }else{
	    	  Pattern pattern = Pattern.compile("[0-9]*");
	    	  Matcher isNum = pattern.matcher(nisbn);
	    	  if( !isNum.matches() ){
	    		  addFieldError("nisbn","请全部输入数字");
	    	  }
	      }//id
	}
	public String dele() {
		connect();
		try {
			Statement stmt = conn.createStatement();
			String sql = "delete from Book where ISBN='"+qisbn+"'";
			int result = stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		disconnect();	
		return "success";
	}
	
	public String modify(){
		query("SELECT * FROM Book where ISBN = " + qisbn);
		String origid=books.get(0).getPublishdata();///?
		setNauthorid(books.get(0).getAuthorid());
		setNisbn(books.get(0).getIsbn());
		setNtitle(books.get(0).getTitle());
		setNpublisher(books.get(0).getPublisher());
		setNpublishdata(books.get(0).getPublishdata());
		setNprice(books.get(0).getPrice());
		dele();
		return "success";
	}
	
	public ArrayList<book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<book> books) {
		this.books = books;
	}
	
	public String getQisbn() {
		return qisbn;
	}

	public void setQisbn(String qisbn) {
		this.qisbn = qisbn;
	}

	public String getNisbn() {
		return nisbn;
	}

	public void setNisbn(String nisbn) {
		this.nisbn = nisbn;
	}

	public String getNtitle() {
		return ntitle;
	}

	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}

	public String getNauthorid() {
		return nauthorid;
	}

	public void setNauthorid(String nauthorid) {
		this.nauthorid = nauthorid;
	}

	public String getNpublisher() {
		return npublisher;
	}

	public void setNpublisher(String npublisher) {
		this.npublisher = npublisher;
	}

	public String getNpublishdata() {
		return npublishdata;
	}

	public void setNpublishdata(String npublishdata) {
		this.npublishdata = npublishdata;
	}

	public String getNprice() {
		return nprice;
	}

	public void setNprice(String nprice) {
		this.nprice = nprice;
	}

	public String getA_name() {
		return a_name;
	}

	public void setA_name(String a_name) {
		this.a_name = a_name;
	}

	public String getA_age() {
		return a_age;
	}

	public void setA_age(String a_age) {
		this.a_age = a_age;
	}

	public String getA_country() {
		return a_country;
	}

	public void setA_country(String a_country) {
		this.a_country = a_country;
	}

	public String getQaname() {
		return qaname;
	}

	public void setQaname(String qaname) {
		this.qaname = qaname;
	}
}
