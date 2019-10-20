import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class database {

	public static void insert(undubean a)
	{
		
		Connection con;
		
		try {

			con=util.createConnection();
			String sql="insert into undu(row,col,val)values(?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, a.getRow());
			pst.setInt(2, a.getCol());
			pst.setInt(3, a.getVal());
			
			pst.executeUpdate();
		}
		catch (Exception e) {
		}
	}
	
	public static undubean getlast()
	{
		
		undubean u=null;
		Connection con;
		
		try {

			con=util.createConnection();
			String sql="SELECT * FROM undu ORDER BY id DESC LIMIT 1";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			
			if(rs.next())
			{
				u=new undubean();
				
				u.setId(rs.getInt("id"));
				u.setCol(rs.getInt("col"));
				u.setRow(rs.getInt("row"));
				u.setVal(rs.getInt("val"));
			}
			
		}
		catch (Exception e) {
		}
		return u;
	}

	public static int truncate()
	{
		
		Connection con;
		
		try {

			con=util.createConnection();
			String sql="TRUNCATE undu";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.executeUpdate();
			return 1;
		}
		catch (Exception e) {
		}
		return 0;
	}

	public static void delete(int id)
	{
		Connection con;
		
		try {
			
			con=util.createConnection();
			String sql="delete from undu where id = ?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		}
		catch (Exception e) {
		}
	}
}
