package cqupt.mt2013.cmtmp.model;
import java.sql.SQLException;

import cqupt.mt2013.cmtmp.tools.*;
/**
 * 
 * @author 廖渝瀚
 * @version 1.0
 * UserBean操作类，用于UserBean的增删改查及其它操作
 *
 */
public class UserBeanOp {
	/**
	 * 登陆验证
	 * <p/>
	 * @param u 用户名
	 * @param p 密码
	 * <p/>
	 * @return
	 */
	public boolean checkUser(String u, String p) {
		boolean b = false;
		ConnDB cdb = new ConnDB();
		String sql = "select USER_PASSWORD from user where USER_ID='" + u + "'";
		String pwdb = null;
		cdb.connect();
		cdb.setSqlStatement(sql);
		cdb.execQuery();
		try {
			if (cdb.getResultSet().next()) {
				
				pwdb = cdb.getResultSet().getString(1);
			} else {
				return false;//既然用户都不存在，就没必要继续了
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cdb.close();
		}

		SimpleMessageDigest md = new SimpleMessageDigest();
		// System.out.println(p);
		//  System.out.println(ts.getSHA_1String());
		if (md.isStringMatchSHA1(p, pwdb)) {
			b = true;
		}

		return b;
	}
}
