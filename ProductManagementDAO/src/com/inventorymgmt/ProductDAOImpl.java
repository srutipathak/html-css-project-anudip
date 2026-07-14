package com.inventorymgmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	

	@Override
	public void addProduct(Product p) {
		// TODO Auto-generated method stub
		try {
			con=DBConnection.getConnection();
			String sql="INSERT INTO Product VALUES(?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getName());
			ps.setString(3, p.getCategory());
			ps.setDouble(4, p.getPrice());
			ps.setInt(5, p.getStock());
			int i=ps.executeUpdate();
			
			if(i>0) {
				System.out.println("Product added successfully!!!");
			}
			else {
				System.out.println("Product not added!!!");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateProduct(Product p) {
		// TODO Auto-generated method stub
		try {
			con=DBConnection.getConnection();
			String sql="UPDATE Product set name=?, category=?, price=?, stock=? WHERE id=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setString(2, p.getCategory());
			ps.setDouble(3, p.getPrice());
			ps.setInt(4, p.getStock());
			ps.setInt(5, p.getId());
			int i=ps.executeUpdate();
			
			if(i>0) {
				System.out.println("Product updated successfully!!!");
			}
			else {
				System.out.println("Product not updated!!!");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
    public void deleteProduct(int id) {
        try {
            con = DBConnection.getConnection();

            String sql = "DELETE FROM Product WHERE id=?";
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int i = ps.executeUpdate();

            if (i > 0) {
                System.out.println("Product deleted successfully!!!");
            } else {
                System.out.println("Product not found!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product searchProduct(int id) {

        Product p = null;

        try {
            con = DBConnection.getConnection();

            String sql = "SELECT * FROM Product WHERE id=?";
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                p = new Product();

                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setCategory(rs.getString("category"));
                p.setPrice(rs.getDouble("price"));
                p.setStock(rs.getInt("stock"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return p;
    }

    @Override
    public List<Product> displayAllProducts() {

        List<Product> list = new ArrayList<>();

        try {
            con = DBConnection.getConnection();

            String sql = "SELECT * FROM Product";
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {

                Product p = new Product();

                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setCategory(rs.getString("category"));
                p.setPrice(rs.getDouble("price"));
                p.setStock(rs.getInt("stock"));

                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}