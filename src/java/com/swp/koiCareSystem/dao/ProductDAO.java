/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.koiCareSystem.dao;

import com.swp.koiCareSystem.config.DatabaseConnectionManager;
import com.swp.koiCareSystem.model.Product;
import com.swp.koiCareSystem.model.ProductCategory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ProductDAO {
//    public ArrayList<Product> GetAllProduct(){
//        ArrayList<Product> list = new ArrayList<>();
//        return list;
//    }   

    public int countProducts() {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "select count(*) from Products where [isActive] =1";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    return rs.getInt(1);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public int countProductsByCate(int cateID) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "select count(*) from Products where [CategoryID] = ? and [isActive] = 1";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, cateID);
                rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    return rs.getInt(1);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public int countProductsByName(String name) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = " select count(*) from Products where [Name] like ? and [isActive] =1";
                pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + name + "%");
                rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    return rs.getInt(1);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public ArrayList<Product> getAllProducts(int index) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Product> listP = new ArrayList<>();
        int distance = (index - 1) * 32;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "select * from Products p inner join CategoryProduct ctp on p.CategoryID = ctp.CategoryID  \n"
                        + "	where p.isActive =1\n"
                        + "                                    order by ProductID desc \n"
                        + "                           offset ? rows fetch next 32 rows only;";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, distance);
                rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        Product pd = new Product();
                        ProductCategory pdct = new ProductCategory(rs.getInt(8), rs.getString(9));
                        pd.setProductID(rs.getInt(1));
                        pd.setNameProduct(rs.getString(3));
                        pd.setImgProduct(rs.getString(4));
                        pd.setDescription(rs.getString(5));
                        pd.setPrice(rs.getFloat(6));
                        pd.setIsActive(rs.getBoolean(7));
                        pd.setCategoryP(pdct);
                        listP.add(pd);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listP;
    }

    public ArrayList<ProductCategory> getAllCategory() {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<ProductCategory> listPC = new ArrayList<>();
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "select * from CategoryProduct";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        listPC.add(new ProductCategory(
                                rs.getInt(1),
                                rs.getString(2)));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listPC;
    }

    public ArrayList<Product> getProductsByCateId(int cateId, int index) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Product> listP = null;
        int distance = (index - 1) * 32;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "select *  from Products p inner join CategoryProduct ctp on p.CategoryID = ctp.CategoryID \n"
                        + "                      where  ctp.CategoryID = ? and p.isActive =1\n"
                        + "                       order by ProductID \n"
                        + "                        offset ? rows fetch next 32 rows only;";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, cateId);
                pst.setInt(2, distance);
                rs = pst.executeQuery();
                if (rs != null && rs.next()) {

                    listP = new ArrayList<>();
                    do {
                        Product pd = new Product();
                        ProductCategory pdct = new ProductCategory(rs.getInt(8), rs.getString(9));
                        pd.setProductID(rs.getInt(1));
                        pd.setNameProduct(rs.getString(3));
                        pd.setImgProduct(rs.getString(4));
                        pd.setDescription(rs.getString(5));
                        pd.setPrice(rs.getFloat(6));
                        pd.setIsActive(rs.getBoolean(7));
                        pd.setCategoryP(pdct);
                        listP.add(pd);
                    } while (rs.next());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listP;
    }

    public ArrayList<Product> searchProductsByName(String name, int index) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Product> listP = new ArrayList<>();
        int distance = (index - 1) * 32;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "select * from Products p inner join CategoryProduct ctp on p.CategoryID = ctp.CategoryID \n"
                        + "                       where  p.[Name] like ? and p.[isActive] =1\n"
                        + "                       order by ProductID  \n"
                        + "                       offset ? rows fetch next 32 rows only;";
                pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + name + "%");
                pst.setInt(2, distance);
                rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        Product pd = new Product();
                        ProductCategory pdct = new ProductCategory(rs.getInt(8), rs.getString(9));
                        pd.setProductID(rs.getInt(1));
                        pd.setNameProduct(rs.getString(3));
                        pd.setImgProduct(rs.getString(4));
                        pd.setDescription(rs.getString(5));
                        pd.setPrice(rs.getFloat(6));
                        pd.setIsActive(rs.getBoolean(7));
                        pd.setCategoryP(pdct);
                        listP.add(pd);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listP;
    }

    public Product getProductById(int id) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Product pd = null;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "select * \n"
                        + "from Products p inner join CategoryProduct ctp on p.CategoryID = ctp.CategoryID \n"
                        + "where p.ProductID = ? and p.isActive = 1";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, id);
                rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    pd = new Product();
                    ProductCategory pdct = new ProductCategory(rs.getInt(8), rs.getString(9));
                    pd.setProductID(rs.getInt(1));
                    pd.setNameProduct(rs.getString(3));
                    pd.setImgProduct(rs.getString(4));
                    pd.setDescription(rs.getString(5));
                    pd.setPrice(rs.getFloat(6));
                    pd.setIsActive(rs.getBoolean(7));
                    pd.setCategoryP(pdct);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pd;
    }

    public ArrayList<Product> getProducts(int index) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Product> listP = new ArrayList<>();
        int distance = (index - 1) * 20;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "select * from Products p inner join CategoryProduct ctp on p.CategoryID = ctp.CategoryID  \n"
                        + "	where p.isActive =1\n"
                        + "                                    order by ProductID DESC \n"
                        + "                           offset ? rows fetch next 20 rows only;";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, distance);
                rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        Product pd = new Product();
                        ProductCategory pdct = new ProductCategory(rs.getInt(8), rs.getString(9));
                        pd.setProductID(rs.getInt(1));
                        pd.setNameProduct(rs.getString(3));
                        pd.setImgProduct(rs.getString(4));
                        pd.setDescription(rs.getString(5));
                        pd.setPrice(rs.getFloat(6));
                        pd.setIsActive(rs.getBoolean(7));
                        pd.setCategoryP(pdct);
                        listP.add(pd);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listP;
    }

    public boolean deleteProduct(int id) {
        Connection cn = null;
        PreparedStatement pst = null;
        boolean isUpdated = false;

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "UPDATE Products SET isActive = 0 WHERE ProductID = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, id);
                int rowsAffected = pst.executeUpdate();
                isUpdated = (rowsAffected > 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isUpdated;
    }

    public boolean updateProduct(Product product) {
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "UPDATE Products SET CategoryID = ?, Name = ?, Description = ?, Price = ? WHERE ProductID = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, product.getCateId());
                pst.setString(2, product.getNameProduct());
                pst.setString(3, product.getDescription());
                pst.setFloat(4, product.getPrice());
                pst.setInt(5, product.getProductID());
                int rowsAffected = pst.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean updateImgByProductID(int productId, String img) {
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "UPDATE Products SET Image = ? WHERE ProductID = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, img);
                pst.setInt(2, productId);

                int rowsAffected = pst.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean createNewProduct(Product product) {
        Connection cn = null;
        PreparedStatement pst = null;
        boolean isInserted = false;

        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "INSERT INTO Products (CategoryID, Name, Image, Description, Price, isActive) "
                        + "VALUES (?, ?, ?, ?, ?, ?)";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, product.getCategoryP().getCategoryID());
                pst.setString(2, product.getNameProduct());
                pst.setString(3, product.getImgProduct());
                pst.setString(4, product.getDescription());
                pst.setFloat(5, product.getPrice());
                pst.setBoolean(6, product.isIsActive());
                int affectedRows = pst.executeUpdate();
                if (affectedRows > 0) {
                    isInserted = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return isInserted;
    }

    public ArrayList<Product> managerSearchProductsByName(String name, int index) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Product> listP = new ArrayList<>();
        int distance = (index - 1) * 20;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "select * from Products p inner join CategoryProduct ctp on p.CategoryID = ctp.CategoryID \n"
                        + "                       where  p.[Name] like ? and p.[isActive] =1\n"
                        + "                       order by ProductID DESC \n"
                        + "                       offset ? rows fetch next 20 rows only;";
                pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + name + "%");
                pst.setInt(2, distance);
                rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        Product pd = new Product();
                        ProductCategory pdct = new ProductCategory(rs.getInt(8), rs.getString(9));
                        pd.setProductID(rs.getInt(1));
                        pd.setNameProduct(rs.getString(3));
                        pd.setImgProduct(rs.getString(4));
                        pd.setDescription(rs.getString(5));
                        pd.setPrice(rs.getFloat(6));
                        pd.setIsActive(rs.getBoolean(7));
                        pd.setCategoryP(pdct);
                        listP.add(pd);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listP;
    }

    public ArrayList<Product> managerGetProductsByCateId(int cateId, int index) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Product> listP = null;
        int distance = (index - 1) * 20;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "select *  from Products p inner join CategoryProduct ctp on p.CategoryID = ctp.CategoryID \n"
                        + "                      where  ctp.CategoryID = ? and p.isActive =1\n"
                        + "                       order by ProductID DESC  \n"
                        + "                        offset ? rows fetch next 20 rows only;";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, cateId);
                pst.setInt(2, distance);
                rs = pst.executeQuery();
                if (rs != null && rs.next()) {

                    listP = new ArrayList<>();
                    do {
                        Product pd = new Product();
                        ProductCategory pdct = new ProductCategory(rs.getInt(8), rs.getString(9));
                        pd.setProductID(rs.getInt(1));
                        pd.setNameProduct(rs.getString(3));
                        pd.setImgProduct(rs.getString(4));
                        pd.setDescription(rs.getString(5));
                        pd.setPrice(rs.getFloat(6));
                        pd.setIsActive(rs.getBoolean(7));
                        pd.setCategoryP(pdct);
                        listP.add(pd);
                    } while (rs.next());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listP;
    }

    public Product getProductForOrderItemById(int id) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Product pd = null;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "select * \n"
                        + "from Products p inner join CategoryProduct ctp on p.CategoryID = ctp.CategoryID \n"
                        + "where p.ProductID = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, id);
                rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    pd = new Product();
                    ProductCategory pdct = new ProductCategory(rs.getInt(8), rs.getString(9));
                    pd.setProductID(rs.getInt(1));
                    pd.setNameProduct(rs.getString(3));
                    pd.setImgProduct(rs.getString(4));
                    pd.setDescription(rs.getString(5));
                    pd.setPrice(rs.getFloat(6));
                    pd.setIsActive(rs.getBoolean(7));
                    pd.setCategoryP(pdct);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pd;
    }

    public Product getProductByIdWithoutIsActive(int id) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Product pd = null;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "select * \n"
                        + "from Products p inner join CategoryProduct ctp on p.CategoryID = ctp.CategoryID \n"
                        + "where p.ProductID = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, id);
                rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    pd = new Product();
                    ProductCategory pdct = new ProductCategory(rs.getInt(8), rs.getString(9));
                    pd.setProductID(rs.getInt(1));
                    pd.setNameProduct(rs.getString(3));
                    pd.setImgProduct(rs.getString(4));
                    pd.setDescription(rs.getString(5));
                    pd.setPrice(rs.getFloat(6));
                    pd.setIsActive(rs.getBoolean(7));
                    pd.setCategoryP(pdct);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pd;
    }

    public ArrayList<Product> getTop10Product() {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        ArrayList<Product> listP = new ArrayList<>();

        try {
            cn = DatabaseConnectionManager.getConnection();
            String sql = "SELECT TOP 10 p.ProductID, p.Image, p.Name, p.Description, cp.CategoryID, cp.CategoryName\n"
                    + "FROM [dbo].[Products] p\n"
                    + "INNER JOIN [dbo].[CategoryProduct] cp\n"
                    + "ON p.CategoryID = cp.CategoryID\n"
                    + "WHERE p.isActive = 1 ORDER BY p.ProductID desc";
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {                    
                    Product p = new Product();
                    ProductCategory pc = new ProductCategory(rs.getInt(5), rs.getString(6));
                    p.setProductID(rs.getInt(1));
                    p.setImgProduct(rs.getString(2));
                    p.setNameProduct(rs.getString(3));
                    p.setDescription(rs.getString(4));
                    p.setCategoryP(pc);
                    listP.add(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listP;
    }
    
    public static void main(String[] args) {
        ProductDAO pdao = new ProductDAO();
        
        ArrayList<Product> list = pdao.getTop10Product();
        for(Product product : list){
            System.out.println("ID: " + product.getProductID());
            System.out.println("Image: " + product.getImgProduct());
            System.out.println("Name: " + product.getNameProduct());
            System.out.println("Desc: " + product.getDescription());
            System.out.println("Cate ID: " + product.getCateId());
            System.out.println("Cate Name: " + product.getCategoryP().getCategoryName());
            System.out.println("-------------------------------");
        }
    }
}
