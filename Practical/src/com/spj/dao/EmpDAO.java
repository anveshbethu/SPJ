package com.spj.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.ejb.Stateless;
import com.spj.Emp;

@Stateless
public class EmpDAO implements EmpRemote, Serializable{
	
	public void add(Emp e){
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
	         con = DriverManager
			            .getConnection("jdbc:postgresql://spjdb.cee7p279hqea.us-west-2.rds.amazonaws.com:5432/HR",
					            "spj", "spj");
	         PreparedStatement st = 
	         con.prepareStatement("insert into employees values(?,?,?,?)");
	         st.setInt(1, e.getId());
	         st.setString(2, e.getFname());
	         st.setString(3, e.getLname());
	         st.setString(4, e.getDesignation());
	         int result = st.executeUpdate();                

	      } catch (SQLException ex) {
	         ex.printStackTrace();
	      } catch (ClassNotFoundException ex) {
	         ex.printStackTrace();
	      }    
	}

}
