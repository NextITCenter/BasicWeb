package todo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.MySqlSession;

public class TodoService {
	private static TodoService instance = new TodoService();
	private TodoMapper mapper;
	
	private TodoService() {
		SqlSession session = MySqlSession.getSqlSession();
		mapper = session.getMapper(TodoMapper.class);
	}
	public static TodoService getInstance() {
		return instance;
	}
	
	public List<TodoVO> selectTodoList() {
		return mapper.selectTotoList();
	}
	
	public TodoVO selectTodo(int searchTNo) {
		return mapper.selectToto(searchTNo);
	}
	
	public int insertTodo(TodoVO todo) {
		return mapper.insertTodo(todo);
	}
	
	public int updateTodo(TodoVO todo) {
		return mapper.updateTodo(todo);
	}
	
	public int deleteTodo(int tNo) {
		return mapper.deleteTodo(tNo);
	}
	
	public TodoVO updateComplete(TodoVO todo) {
		mapper.updateComplete(todo);
		return mapper.selectComplete(todo.gettNo());
	}
}






