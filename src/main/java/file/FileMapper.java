package file;

public interface FileMapper {
	// 게시판 상세 화면에서 한 개의 파일을 다운로드할 때 파일 정보 가져오기
	FileDTO selectFile(int id);
}
