package todo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.MySqlSession;

public class TodoDAO {
	private static TodoDAO instance = new TodoDAO();
	private SqlSession session = MySqlSession.getSqlSession();
	
	private TodoDAO() {
		// 생성자: 객체를 생성할 때 호출하는 메소드
	}
	
	public static TodoDAO getInstance() {
		return instance;
	}
	
	public List<TodoVO> selectTotoList() {
		return session.selectList("todo.TodoMapper.selectTotoList");
	}
	public TodoVO selectToto(int searchTNo) {
		return session.selectOne("todo.TodoMapper.selectToto", searchTNo);
	}
	public int insertTodo(TodoVO todo) {
		return session.insert("todo.TodoMapper.insertTodo", todo);
	}
	public int updateTodo(TodoVO todo) {
		return session.update("todo.TodoMapper.updateTodo", todo);
	}
	public int deleteTodo(int tNo) {
		return session.delete("todo.TodoMapper.deleteTodo", tNo);
	}
	public int updateComplete(TodoVO todo) {
		return session.update("todo.TodoMapper.updateComplete", todo);
	}
	public TodoVO selectComplete(int tNo) {
		return session.selectOne("todo.TodoMapper.selectComplete", tNo);
	}
}













