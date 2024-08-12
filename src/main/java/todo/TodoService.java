package todo;

import java.util.List;

public class TodoService {
	
	public List<TodoVO> selectTodoList() {
		TodoDAO dao = new TodoDAO();
		return dao.selectTotoList();
	}
	
	public TodoVO selectTodo(int searchTNo) {
		TodoDAO dao = new TodoDAO();
		return dao.selectToto(searchTNo);
	}
	
	public int insertTodo(TodoVO todo) {
		TodoDAO dao = new TodoDAO();
		return dao.insertTodo(todo);
	}
	
	public int updateTodo(TodoVO todo) {
		TodoDAO dao = new TodoDAO();
		return dao.updateTodo(todo);
	}
	
	public int deleteTodo(int tNo) {
		TodoDAO dao = new TodoDAO();
		return dao.deleteTodo(tNo);
	}
	
	public TodoVO updateComplete(TodoVO todo) {
		TodoDAO dao = new TodoDAO();
		dao.updateComplete(todo);
		return dao.selectComplete(todo.gettNo());
	}
}






