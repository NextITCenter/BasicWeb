package todo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO {
	public List<TodoVO> selectTotoList() {
		List<TodoVO> list = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std225", "oracle21c");
			String sql = """
					select
						t_no,
						title,
						writer,
						complete,
						due_date
					from
						todo
					""";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int tNo = resultSet.getInt("t_no");
				String title = resultSet.getString("title");
				String writer = resultSet.getString("writer");
				boolean complete = resultSet.getBoolean("complete");
				LocalDate dueDate = resultSet.getDate("due_date").toLocalDate();
				list.add(new TodoVO(tNo, title, writer, complete, dueDate));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public TodoVO selectToto(int searchTNo) {
		TodoVO vo = null;
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std225", "oracle21c");
			String sql = """
					select
						t_no,
						title,
						writer,
						complete,
						due_date
					from
						todo
					where
						t_no = ?
					""";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, searchTNo);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int tNo = resultSet.getInt("t_no");
				String title = resultSet.getString("title");
				String writer = resultSet.getString("writer");
				boolean complete = resultSet.getBoolean("complete");
				LocalDate dueDate = resultSet.getDate("due_date").toLocalDate();
				vo = new TodoVO(tNo, title, writer, complete, dueDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return vo;
	}
	
	public int insertTodo(TodoVO todo) {
		Connection connection = null;
		PreparedStatement statement = null;
		int executeUpdate = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std225", "oracle21c");
			String sql = """
					insert into todo
						(title, writer, due_date)
					values
						(?, ?, ?)
					""";
			statement = connection.prepareStatement(sql);
			statement.setString(1, todo.getTitle());
			statement.setString(2, todo.getWriter());
			statement.setDate(3, Date.valueOf(todo.getDueDate()));

			executeUpdate = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return executeUpdate;
	}
	public int updateTodo(TodoVO todo) {
		Connection connection = null;
		PreparedStatement statement = null;
		int executeUpdate = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std225", "oracle21c");
			String sql = """
					update
						todo
					set
						title = ?,
						writer = ?,
						due_date = ?
					where
						t_no = ?
					""";
			statement = connection.prepareStatement(sql);
			statement.setString(1, todo.getTitle());
			statement.setString(2, todo.getWriter());
			statement.setDate(3, Date.valueOf(todo.getDueDate()));
			statement.setInt(4, todo.gettNo());
			
			executeUpdate = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return executeUpdate;
	}
	
	public int deleteTodo(int tNo) {
		Connection connection = null;
		PreparedStatement statement = null;
		int executeUpdate = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe","std225","oracle21c");
			String sql = """
					delete from
						todo
					where
						t_no = ?
					""";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, tNo);
			
			executeUpdate = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return executeUpdate;
	}
	
	public int updateComplete(TodoVO todo) {
		Connection connection = null;
		PreparedStatement statement = null;
		int executeUpdate = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std225", "oracle21c");
			String sql = """
					update
						todo
					set
						complete = ?
					where
						t_no = ?
					""";
			statement = connection.prepareStatement(sql);
			statement.setBoolean(1, todo.isComplete());
			statement.setInt(2, todo.gettNo());
			
			executeUpdate = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return executeUpdate;
	}
	public TodoVO selectComplete(int tNo) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		TodoVO todo = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std225", "oracle21c");
			String sql = """
					select complete from todo where t_no = ?
					""";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, tNo);
			
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				boolean complete = resultSet.getBoolean("complete");
				todo = new TodoVO(tNo, complete);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return todo;
	}
}













