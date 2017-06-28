package pr.fd.future;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ���ݿ�������ر���
 * 
 * @author
 * 
 */
public class ConnectionMysql {

	public Connection conn;
	public PreparedStatement pstmt;
	public ResultSet rs;
	 

	/**
	 * �����ݿ��ȡ����
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
	 * �ر����ݿ���ص���Դ
	 * 
	 * @param conn
	 *            ���ݿ����Ӷ���
	 * @param pstmt
	 *            ������
	 * @param rs
	 *            �����
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
	 * ִ������ɾ���Ĳ���
	 * 
	 * @param sql
	 *            Ԥ�����SQL���
	 * @param param
	 *            ������
	 * @return ��Ӱ������
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
	 * ִ�в����
	 * 
	 * @param sql
	 *            Ԥ�����SQL���
	 * @param param
	 *            ������
	 * @return ��Ӱ������
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
 *  �ݹ鰸��:
 *   ��һ�����1Ԫ���ڶ��������Ԫ����������4Ԫ���Ժ��ÿһ�춼����ǰһ���2�����ʵ�30�쵽�׸��˶���Ǯ��
 * @param money ��ʼֵ
 * @param count Ҫ���Ĵ���
 * @return  �������յĽ��
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
