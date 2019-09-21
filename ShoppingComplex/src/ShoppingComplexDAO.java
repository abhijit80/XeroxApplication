import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShoppingComplexDAO {
	public void saveShoppingComplex(int complexId,String shoppingComplexName,int noOfShops,String location,double ratings) {
	Connection con = null;
	PreparedStatement pstmt = null;
	
	Class.forName(DBConstants.DRIVER_CLASSNAME);
	
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xworkz",DBConstants.USERNAME.DBConstants.PASSWORD);
	con.setAutoCommit(false);
	
	pstmt = con.prepareStatement("INSERT INTO shopping_complex VALUES(?,?,?,?,?)");
	
	pstmt.setInt(1, complexId);
	pstmt.setString(2, shoppingComplexName);
	pstmt.setDouble(5,ratings );
	pstmt.setString(4, location);
	pstmt.setInt(3,noOfShops);
	}

}

public void getAllComplexdetails() {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	Class.forName(DBConstants.DRIVER_CLASSNAME);
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xworkz",DBConstants.USERNAME.DBConstants.PASSWORD);
	
	pstmt = con.prepareStatement("SELECT * FROM shopping_complex as complex");
	rs =pstmt.executeQuery();
	
	while(rs.next()) {
		int complexId =rs.getInt("complex_Id");
		String complexName = rs.getString("complex_name");
		int noOfShops =rs.getInt(3);
		String location = rs.getString(4);
		double rating = rs.getDouble("ratings");
		
		System.out.println(complexId + "\t"+complexName +"\t" +noOfShops+"\t"+location+"\t"+rating);
		
	}
	
} catch(ClassNotFoundException | SQLException e) {
	e.printStackTrace();
}finally {
	try
	
	
	
}
