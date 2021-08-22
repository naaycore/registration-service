package com.prodigious.messanger.repository.implementation;

import java.util.Objects;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.prodigious.messanger.domain.User;
import com.prodigious.messanger.repository.UserDao;

@Repository
public class UserDaoMySql implements UserDao {

	private NamedParameterJdbcTemplate jdbcTemplate;

	public UserDaoMySql(NamedParameterJdbcTemplate jdbcTemplate) {
		if (Objects.isNull(jdbcTemplate)) {
			throw new NullPointerException("jdbctemplate is null");
		}
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void saveUser(User user) {
		String query = "call prodigious_messanger.saveUser(:userId, :userPhone, :createdAt)";
		MapSqlParameterSource param = new MapSqlParameterSource().addValue("userId", user.getUserId())
				.addValue("userPhone",  user.getUserPhone()).addValue("createdAt", user.getCreatedAt());
		try {
			jdbcTemplate.update(query, param);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
