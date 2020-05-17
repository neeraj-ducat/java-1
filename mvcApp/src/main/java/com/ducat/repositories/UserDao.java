package com.ducat.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ducat.entities.User;

@Repository
public class UserDao {

	// JdbcTemplate object is autowired
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//Queries
	private static final String Save_Query="insert into UsersMaster (name, mailId, password) values(?,?,?)";
	private static final String Find_By_MailId_Query="select * from UsersMaster where mailId=?";
	
	//Method to save a user
	public void save(User user)
	{
		jdbcTemplate.update(Save_Query, user.getName(), user.getMailId(),user.getPassword());
	}
	
	//Method to find User using mailId
	public List<User> findByMailId(String mailId)
	{
		return jdbcTemplate.query(Find_By_MailId_Query, new String[] {mailId}, mapper);
		
	}
	
	// RowMapper implementation
	RowMapper<User> mapper = new RowMapper() {
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setMailId(rs.getString(3));
			user.setPassword(rs.getString(4));
			return user;
		}
		
	};
}
