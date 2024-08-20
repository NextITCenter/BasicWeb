package file;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

@WebServlet("/file/download")
public class FileDownloadServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramId = req.getParameter("id");
		int id = paramId == null || paramId.isEmpty() ? 0 : Integer.parseInt(paramId);

		ServletContext context = req.getServletContext();
		SqlSession sqlSession = (SqlSession) context.getAttribute("sqlSession");

		FileService service = FileService.getInstance(sqlSession);
		FileDTO file = service.selectFile(id);
		// 첨부파일만 응답해야한다.
		String filePath = file.getFilePath();
		String fileName = file.getFileName();
		Path path = Paths.get(filePath, fileName);
		OutputStream outputStream = resp.getOutputStream();
		Files.copy(path, outputStream);
		resp.setContentType("application/octet-stream");
		resp.setHeader("Content-Disposition", "attachment;filename=\"" + file.getOriginalName() + "\"");
		resp.setHeader("Content-Length", String.valueOf(file.getFileSize()));
	}
}










