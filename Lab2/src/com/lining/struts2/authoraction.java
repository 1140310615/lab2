package com.lining.struts2;

import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.lining.struts2.author;
import com.opensymphony.xwork2.ActionSupport;

public class authoraction extends ActionSupport{
	private ArrayList<author> authors = new ArrayList<author>();
	private static Connection conn = null;
	
	private String nauthorid;
	private String nname;
	private String nage;
	private String ncountry;
	
	private static void connect() {
		try {
			//"jdbc:mysql://localhost:3306/BookDB"
			//"jdbc:mysql://abfinlswxznn.rds.sae.sina.com.cn:10491/bookdb"
			//"jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6139974"
			String URL ="jdbc:mysql://wppvbamivosx.rds.sae.sina.com.cn:10395/bookdb";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "p123456");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void disconnect() {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}

	public static ArrayList<String> queryname(String name){
		ArrayList<String> res = new ArrayList<String>();
		connect();
		try {
			String sql = "select distinct Author_ID from Author where Name='"+name+"'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				res.add(rs.getString(1));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		disconnect();
		return res;
	}
	
	public String queryall(){
		connect();
		try {
			String sql = "select * from Author";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				authors.add(new author(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		disconnect();
		return "success";
	}
	
	public static author queryone(String id){
		connect();
		author result = null;
		try {
			String sql = "select * from Author where Author_ID="+id;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result = new author(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		disconnect();
		return result;
	}
	
	public String create() {
		connect();
		try {
			Statement stmt = conn.createStatement();
			String sql = "insert into Author values("+nauthorid+",'"+nname+"',"+nage+",'"+ncountry+"')";
			int result = stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		disconnect();
		return "success";
	}
	public void validateCreate()
	{
	      if (nname == null || nname.trim().equals(""))
	      {
	         addFieldError("nname","请输入名字");
	      }//name
	      if (nage == null || nage.trim().equals(""))
	      {
	         addFieldError("nage","请输入年龄");
	      }else{
	    	  Pattern pattern = Pattern.compile("[0-9]*");
	    	  Matcher isNum = pattern.matcher(nage);
	    	  if( !isNum.matches() ){
	    		  addFieldError("nage","请全部输入数字");
	    	  }
	      }//age
	      if (ncountry == null || ncountry.trim().equals(""))
	      {
	         addFieldError("ncountry","请输入国籍");
	      }//country
	}
	public ArrayList<author> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<author> authors) {
		this.authors = authors;
	}

	public String getNname() {
		return nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
	}

	public String getNage() {
		return nage;
	}

	public void setNage(String nage) {
		this.nage = nage;
	}

	public String getNcountry() {
		return ncountry;
	}

	public void setNcountry(String ncountry) {
		this.ncountry = ncountry;
	}

	public String getNauthorid() {
		return nauthorid;
	}

	public void setNauthorid(String nauthorid) {
		this.nauthorid = nauthorid;
	}

}
