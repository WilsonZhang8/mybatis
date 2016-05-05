package com.zghw.demo.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zghw.demo.mybatis.entity.User;

public class TestConnection {

	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		long fixedID=9l;
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		SqlSession session = sqlSessionFactory.openSession(true);
		try {
			/*
			 * User user = new User(); user.setName("zghw");
			 * user.setPassword("123456"); user.setAge(27);
			 * user.setAddress("北京海淀"); // 增加
			 * 
			 * int
			 * count=session.insert("com.zghw.demo.mybatis.entity.User.insertUser"
			 * ,user); System.out.println(count);
			 */
			// 修改
			/*
			 * User userUpate = new User(); userUpate.setId(fixedID);
			 * userUpate.setName("zhangsan"); userUpate.setPassword("xxx2323");
			 * userUpate.setAge(22); userUpate.setAddress("北京朝阳");
			 * session.update("com.zghw.demo.mybatis.entity.User.updateUser",
			 * userUpate);
			 */
			// 查询
			User user1 = session.selectOne(
					"com.zghw.demo.mybatis.entity.User.selectUser", fixedID);
			System.out.println(user1);
			// 删除
			session.delete("com.zghw.demo.mybatis.entity.User.deleteUser", fixedID);
			System.out.println(user1);
		} finally {
			session.close();
		}

	}

}
