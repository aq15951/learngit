package pr.fd.future;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库连接与关闭类
 * 
 * @author
 * 
 */
public class ConnectionMysql {

	public Connection conn;
	public PreparedStatement pstmt;
	public ResultSet rs;
	 

	/**
	 * 与数据库获取连接
	 * 
	 * @return
	 */
	public Connection getConnection() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/alk", "root",
					"root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 关闭数据库相关的资源
	 * 
	 * @param conn
	 *            数据库连接对象
	 * @param pstmt
	 *            语句对象
	 * @param rs
	 *            结果集
	 */
	public void closeAll(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if (null != rs) {
			try {
				rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		if (null != pstmt) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (null != con) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 执行增、删、改操作
	 * 
	 * @param sql
	 *            预处理的SQL语句
	 * @param param
	 *            语句对象
	 * @return 受影响行数
	 */
	public int executeUpdate(String sql, Object param[]) {
		conn = getConnection();
		int num = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			if (null != param && param.length > 0) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]);
				}
			}
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return num;
	}

	/**
	 * 执行查操作
	 * 
	 * @param sql
	 *            预处理的SQL语句
	 * @param param
	 *            语句对象
	 * @return 受影响行数
	 */
	public ResultSet executeQuery(String sql, Object param[]) {
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			if (null != param && param.length > 0) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]);
				}
			}
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
/**
 *  递归案例:
 *   第一天给你1元，第二天给你两元，第三给你4元，以后的每一天都给你前一天的2倍，问第30天到底给了多少钱？
 * @param money 初始值
 * @param count 要给的次数
 * @return  返回最终的结果
 */
	public static long count(long money,int count) {
		count++;
		if(count>30){
			return money;
		}else{
			return  Long.valueOf(  count(money * 2,count));
		}
	}

	public static void main(String[] args) {
		// System.out.println(new ConnectionMysql().getConnection());
		long l = count(1,0);
		System.out.println(l);

	}

}
