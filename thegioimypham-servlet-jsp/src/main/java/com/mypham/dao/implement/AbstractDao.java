package com.mypham.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mypham.dao.GenericDao;
import com.mypham.mapper.RowMapper;

import JDBCConnection.JDBCConnection;

public class AbstractDao<T> implements GenericDao<T>
{

	@Override
	public List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) 
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			List<T> list = new ArrayList<T>();
			conn = JDBCConnection.getJDBCConnection();
			ps = conn.prepareStatement(sql);
			setParameter(ps, parameters);
			rs = ps.executeQuery();
			while (rs.next())
			{
				list.add(rowMapper.mapRow(rs));
			}
			if (list.size()==0)
				return null;
			return list;
		} catch (SQLException e) 
		{
			return null;
		} finally
		{
				try {
					if (conn!=null) 
						conn.close();
					if (ps!=null)
						ps.close();
					if (rs!=null)
						rs.close();
				} catch (SQLException e) {
					return null;
				}
		}
		
	}
	public void setParameter(PreparedStatement ps , Object...paremeters)
	{
		for (int i=0;i<paremeters.length;i++)
		{
			Object parameter = paremeters[i];
				try {
					if (parameter instanceof Long)
						ps.setLong(i+1,(Long) parameter);
					else
						if (parameter instanceof String)
							ps.setString(i+1, (String) parameter);
						else
							if (parameter instanceof Integer)
								ps.setInt(i+1,(Integer)parameter);
							else
								if (parameter instanceof Timestamp)
									ps.setTimestamp(i+1,(Timestamp)parameter);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	@Override
	public Long insert(String sql, Object... parameters) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Long id = null;
			conn = JDBCConnection.getJDBCConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameter(ps, parameters);
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			while (rs.next())
			{
				id = rs.getLong(1);
			}
			conn.commit();
			return id;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally
		{
			try {
				if (conn!=null) 
					conn.close();
				if (ps!=null)
					ps.close();
				if (rs!=null)
					rs.close();
			} catch (SQLException e) {
			}
		}
		return null;
	}
	@Override
	public void update(String sql, Object... parameters) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCConnection.getJDBCConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
			setParameter(ps, parameters);
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally
		{
			
				try {
					if (conn!=null) 
						conn.close();
					if (ps!=null)
						ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}
	@Override
	public void delete(String sql , Object... parameters) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = JDBCConnection.getJDBCConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			setParameter(ps, parameters);
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally 
		{
				try {
					if (conn!=null)
						conn.close();
					if (ps!=null)
						ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	public Long count(String sql , Object...parameters)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Long cnt = null;
			conn = JDBCConnection.getJDBCConnection();
			ps = conn.prepareStatement(sql);
			setParameter(ps, parameters);
			rs = ps.executeQuery();
			while (rs.next())
			{
				cnt = rs.getLong(1);
			}
			return cnt;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally {
				try {
					if (conn!=null)
						conn.close();
					if (ps!=null)
						ps.close();
					if (rs!=null)
						rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
}
