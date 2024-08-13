package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySqlSession {
	/*
	 *  MyBatis의 경우 처음에 시스템이 시작될 때
	 *  SqlSessionFactoryBuilder를 통해 SqlSessionFactory를 만들고
	 *  SqlSessionFactory를 통해 SqlSession 객체를 만든 다음
	 *  SqlSession을 통해 데이터베이스 쿼리를 실행한다.
	 *  즉 처음 시작될 때 한번만 생성해서 모든 위치에서 실행 가능하도록 설정해야 한다.
	 *  static 사용
	 *  field, method 에 사용할 수 있다.
	 *  static block 은 처음에 클래스가 사용될 때 호출
	*/
	private static SqlSessionFactory sqlSessionFactory;
	static {
		String resouce = "/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resouce);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	public static SqlSession getSqlSession() {
		// MyBatis는 등록, 수정, 삭제시 auto commit 이 비활성화 되어 있음
		// SqlSession 객체 생성시 옵션에 auto commit을 true로 활성화 해줘야 함
		return sqlSessionFactory.openSession(true);
	}
}










