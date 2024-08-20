package file;

import org.apache.ibatis.session.SqlSession;

public class FileService {
	private static FileService instance = new FileService();
	private static FileMapper mapper;
	private FileService() {
	}
	public static FileService getInstance(SqlSession session) {
		mapper = session.getMapper(FileMapper.class);
		return instance;
	}
	public FileDTO selectFile(int id) {
		return mapper.selectFile(id);
	}
}

