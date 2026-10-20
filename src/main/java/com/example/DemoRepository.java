package com.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DemoRepository {


    Connection con=null;
    public DemoRepository()   {
        String url="jdbc:mysql://localhost:3306/restdb";
        String username="root";
        String password="root@1221";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,username,password);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Demo> getDemo(){
        List<Demo> demos= new ArrayList<>();
        String sql="select * from demos";
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                Demo d=new Demo();
                d.setID(rs.getInt(1));
                d.setName(rs.getString(2));
                d.setMarks(rs.getInt(3));

                demos.add(d);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return demos;
    }
    public Demo getDemo(int id){
        Demo d=new Demo();
        String sql="select * from demos where id="+id;
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            if(rs.next()) {

                d.setID(rs.getInt(1));
                d.setName(rs.getString(2));
                d.setMarks(rs.getInt(3));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return d;
    }


    public void create(Demo d1) {
        String sql="insert into demos values (?,?,?)";
        try {

            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, d1.getID());
            ps.setString(2,d1.getName());
            ps.setInt(3,d1.getMarks());
            ps.executeUpdate();

            } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    //update
    public void update(Demo d1) {
        String sql="update demos set name =?,marks=? where id=?";
        try {

            PreparedStatement ps=con.prepareStatement(sql);

            ps.setString(1,d1.getName());
            ps.setInt(2,d1.getMarks());
            ps.setInt(3, d1.getID());
            ps.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void delete(int id) {
        String sql="delete from demos where id=?";
        try {

            PreparedStatement ps=con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
