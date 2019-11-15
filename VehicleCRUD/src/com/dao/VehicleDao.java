package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.bean.VehicleBean;
import com.util.VehicleUtil;


public class VehicleDao {
	public static void doInsert(VehicleBean vb){
		try {
			Connection conn=VehicleUtil.createConnection();
			String s1="insert into vehicle(Vehicle_Year,Vehicle_Make,Vehicle_Model)values(?,?,?)";
			PreparedStatement ps=conn.prepareStatement(s1); 
			ps.setInt(1, vb.getYear());
			ps.setString(2, vb.getMake());
			ps.setString(3, vb.getModel());
			ps.executeUpdate();
			System.out.println("data inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<VehicleBean> getAllVehicles(){
		List<VehicleBean> list= new ArrayList<>();
		try {
			Connection conn=VehicleUtil.createConnection();
			String sql="select * from Vehicle";
			PreparedStatement pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				VehicleBean vb=new VehicleBean();
				vb.setId((rs.getInt(1)));
				vb.setYear((rs.getInt(2)));
				vb.setMake(rs.getString(3));
				vb.setModel(rs.getString(4));
				list.add(vb);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	return list;	
	}
	
	public static VehicleBean getVehicleById(int id){
		VehicleBean vb=null;
		try {
			Connection conn=VehicleUtil.createConnection();
			String sql="select * from vehicle where Vehicle_ID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				vb=new VehicleBean();
				vb.setId(rs.getInt("Vehicle_ID"));
				vb.setYear(rs.getInt("Vehicle_Year"));
				vb.setMake(rs.getString("Vehicle_Make"));
				vb.setModel(rs.getString("Vehicle_Model"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	return vb;
	}
	
	public static void updateVehicle(VehicleBean s) {
		try {
			Connection conn=VehicleUtil.createConnection();
			String sql="update Vehicle set Vehicle_Year=?,Vehicle_Make=?,Vehicle_Model=? where Vehicle_ID=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, s.getYear());
			pst.setString(2, s.getMake());
			pst.setString(3, s.getModel());
			pst.setInt(4, s.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void delete(int id) {
		try {
			Connection conn=VehicleUtil.createConnection();
			String sql="delete from vehicle where vehicle_id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1,id);
			pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
