package com.example.demo.repository;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.Article;

@Mapper
public interface ArticleRepository {

	@Insert("INSERT INTO article SET regDate = NOW(), updateDate = NOW(), title = #{title}, `body` = #{body}")
	int writeArticle(String title, String body);

	@Update("UPDATE article SET updateDate = NOW(), title = #{title}, `body` = #{body} WHERE id = #{id}")
	void modifyArticle(int id, String title, String body);
	
	@Delete("DELETE FROM article WHERE id = #{id}")
	void deleteArticle(int id);

	@Select("SELECT * FROM article WHERE id = #{id}")
	Article getArticleById(int id);
	
	@Select("SELECT * FROM article ORDER BY id DESC")
	List<Article> getArticles();
}