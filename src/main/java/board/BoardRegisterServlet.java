package board;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.ibatis.session.SqlSession;

@WebServlet("/boards/register")
// MultipartConfig 어노테이션 또는 web.xml 에 multipart-config를 추가하지 않으면
// multipart/form-data 형식의 파일을 처리할 수 없다.
@MultipartConfig(maxFileSize = 10485760)
public class BoardRegisterServlet extends HttpServlet {
	private static final String FILE_PATH = "c:\\Users\\pc11\\upload\\";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/board/register.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 수정, 등록시 필요
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		
		// 첨부파일 처리
		// 첨부파일과 파라미터를 함께 처리할 수 있다.
		// 주로 첨부파일만 가져올 때 사용하는 경우가 많다.
		// Part: 부분
		Part filesPart = req.getPart("files");
		// 실제 데이터베이스에 저장될 내용
		long fileSize = filesPart.getSize();// 첨부파일의 용량(크기)
		String originalName = filesPart.getSubmittedFileName();// 첨부파일 이름

		String contentType = filesPart.getContentType();// 첨부파일의 컨텐츠 타입
		
		System.out.println("업로드된 파일 크기: " + fileSize);
		System.out.println("업로드된 파일 이름: " + originalName);
		System.out.println("업로드된 파일 컨텐츠 타입: " + contentType);
		
		// 실제 물리적인 서버 위치에 파일을 저장하기
		String fileName = UUID.randomUUID().toString();
		filesPart.write(FILE_PATH + fileName);
		// 리눅스, 맥에서는 다음과 같이 작성
//		filesPart.write("/User/pc11/upload/" + originalName);
		
		BoardDTO board = new BoardDTO(title, content, writer);
		// 파일 정보 넣어주기
		List<FileDTO> fileList = new ArrayList<FileDTO>();
		
		fileList.add(new FileDTO(FILE_PATH, fileName, originalName, fileSize));
		
		board.setFileList(fileList);

		ServletContext context = req.getServletContext();
		SqlSession session = (SqlSession) context.getAttribute("sqlSession");
		BoardService service = BoardService.getInstance(session);
		
		int modifyBoard = service.registerBoard(board);
		
		if (modifyBoard > 0) {
			resp.sendRedirect("/boards");
		} else {
			req.setAttribute("msg", "게시글 등록 실패!");
			req.getRequestDispatcher("/WEB-INF/views/board/register.jsp").forward(req, resp);
		}

	}
}
