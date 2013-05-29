/*
 * To change this template, choose Tools | Templates and open the
 * template in the editor.
 */
package cqupt.mt2013.cmtmp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.servlet.jsp.tagext.TryCatchFinally;
import javax.sql.DataSource;

import com.sun.org.apache.xml.internal.security.Init;

/**
 *
 * @author Diluka
 */
public class ConnDB {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private int execUpdateNum = 0;
	
	public void connect() {
		try {
			InitialContext ctx=new InitialContext();
			DataSource ds=(DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
			connection=ds.getConnection(); 
			
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	}

	public void setSqlStatement(String sql) {
		try {
			preparedStatement = connection.prepareStatement(sql);
		} catch (SQLException ex) {
			Logger.getLogger(ConnDB.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void setString(int i, String s) {
		try {
			preparedStatement.setString(i, s);
		} catch (SQLException ex) {
			Logger.getLogger(ConnDB.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void execUpdate() {
		try {
			execUpdateNum = preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(ConnDB.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public void execQuery() {
		try {
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException ex) {
			Logger.getLogger(ConnDB.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public int getExecUpdateNum() {
		return execUpdateNum;
	}

	public void close() {
		try {
			if (resultSet != null) {
				if (!resultSet.isClosed()) {
					resultSet.close();
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(ConnDB.class.getName()).log(Level.SEVERE, null, ex);
		}
		try {
			if (!preparedStatement.isClosed()) {
				preparedStatement.close();
			}
		} catch (SQLException ex) {
			Logger.getLogger(ConnDB.class.getName()).log(Level.SEVERE, null, ex);
		}
		try {
			if (!connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException ex) {
			Logger.getLogger(ConnDB.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	
}
