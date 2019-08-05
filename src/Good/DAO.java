package Good;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DAO {
	private static Connection conn=null;
	private static PreparedStatement pst=null;
	private static ResultSet rs=null;
	
	//添加
	public int addGoods(Goods g) {
		try {
			conn=	DButil.getConnection();
			String sql = "insert into wp(Id,Name,Price) values(?,?,?)";// ?参数

			pst = conn.prepareStatement(sql);
			pst.setString(1, g.getId());
			pst.setString(2, g.getName());
			pst.setString(3, g.getPrice());
			int i=pst.executeUpdate();
			return i;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.closePreparedStatement(pst);
			DButil.closeConnection();
		}
		return 0;
	}
	
	//删除
	public static int deleteGoods(String Id) {
		try {
			conn=	DButil.getConnection();
			String sql = "delete from wp where Id=?";	// ?参数

			pst = conn.prepareStatement(sql);
			pst.setString(1, Id);
			int i=pst.executeUpdate();
			return i;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.closePreparedStatement(pst);
			DButil.closeConnection();
		}
		return 0;
	}


	//修改
		public int updateGoods(String Id,String Name,String Price,String id,Goods g) {
			try {
				conn=	DButil.getConnection();
				String sql = "update wp set Id=?,Name=?,Price=? where id=?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, g.getId());
				pst.setString(2, g.getName());
				pst.setString(3, g.getPrice());
				pst.setString(4, g.getid());
				int i=pst.executeUpdate();
				return i;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DButil.closePreparedStatement(pst);
				DButil.closeConnection();
			}
			return 0;
		}
		
     //查询
		public Goods getId(String id) {
			try {
				conn=	DButil.getConnection();
				String sql = "select * from wp where Id ='" + id+"'";// ?参数
				System.out.println(sql);
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				while (rs.next()) {
					Goods g=new Goods(rs.getString("Id") ,
							 rs.getString("Name"),rs.getString("Price"));
					return g;
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DButil.closeResultSet(rs);
				DButil.closePreparedStatement(pst);
				DButil.closeConnection();
			}
			return null;
		}
		}
