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

    public int CountProducts() {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "select count(*) from Products";
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

    public int CountProductsByCate(int cateID) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "select count(*) from Products where [CategoryID] = ?";
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

    public ArrayList<Product> Pagingproduct(int index) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Product> listP = new ArrayList<>();
        int distance = (index - 1) * 32;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "select p.ProductID , p.Description, p.Image,p.Name ,p.Price, ctp.CategoryID ,ctp.CategoryName\n"
                        + "from Products p inner join CategoryProduct ctp on p.CategoryID = ctp.CategoryID\n"
                        + "order by ProductID \n"
                        + "offset ? rows fetch next 32 rows only;";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, distance);
                rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        Product pd = new Product();
                        ProductCategory pdct = new ProductCategory(rs.getInt("CategoryID"), rs.getString("CategoryName"));
                        pd.setProductID(rs.getInt("ProductID"));
                        pd.setDescription(rs.getString("Description"));
                        pd.setImgProduct(rs.getString("Image"));
                        pd.setNameProduct(rs.getString("Name"));
                        pd.setPrice(rs.getFloat("Price"));
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

    public ArrayList<ProductCategory> GetAllCategory() {
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

    public ArrayList<Product> PagingGetProductByCateId(int cateId, int index) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Product> listP = new ArrayList<>();
        int distance = (index - 1) * 32;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "select p.ProductID , p.Description, p.Image,p.Name ,p.Price, ctp.CategoryID ,ctp.CategoryName \n"
                        + "from Products p inner join CategoryProduct ctp on p.CategoryID = ctp.CategoryID \n"
                        + "where  ctp.CategoryID = ?\n"
                        + "order by ProductID   \n"
                        + "offset ? rows fetch next 32 rows only;";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, cateId);
                pst.setInt(2, distance);
                rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        Product pd = new Product();
                        ProductCategory pdct = new ProductCategory(rs.getInt("CategoryID"), rs.getString("CategoryName"));
                        pd.setProductID(rs.getInt("ProductID"));
                        pd.setDescription(rs.getString("Description"));
                        pd.setImgProduct(rs.getString("Image"));
                        pd.setNameProduct(rs.getString("Name"));
                        pd.setPrice(rs.getFloat("Price"));
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

    public ArrayList<Product> SearchProductsByName(String name, int index) {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Product> listP = new ArrayList<>();
        int distance = (index - 1) * 32;
        try {
            cn = DatabaseConnectionManager.getConnection();
            if (cn != null) {
                String sql = "select p.ProductID , p.Description, p.Image,p.Name ,p.Price, ctp.CategoryID ,ctp.CategoryName  \n"
                        + "                      from Products p inner join CategoryProduct ctp on p.CategoryID = ctp.CategoryID \n"
                        + "                      where  p.Name like ?\n"
                        + "                       order by ProductID   \n"
                        + "                     offset ? rows fetch next 32 rows only;"
                        + "offset ? rows fetch next 32 rows only;";
                pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + name + "%");
                pst.setInt(2, distance);
                rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        Product pd = new Product();
                        ProductCategory pdct = new ProductCategory(rs.getInt("CategoryID"), rs.getString("CategoryName"));
                        pd.setProductID(rs.getInt("ProductID"));
                        pd.setDescription(rs.getString("Description"));
                        pd.setImgProduct(rs.getString("Image"));
                        pd.setNameProduct(rs.getString("Name"));
                        pd.setPrice(rs.getFloat("Price"));
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

    public static void main(String[] args) {
        ProductDAO pd = new ProductDAO();
//        ArrayList<Product> lp = pd.Pagingproduct(1);

//        ArrayList<ProductCategory> lp = pd.GetAllCategory();
        ArrayList<Product> list = pd.PagingGetProductByCateId(1, 1);
        for (Product i : list) {
            System.out.println(i);
        }
    }
}
