package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.vo.Article;

import lombok.AllArgsConstructor;
import lombok.Data;

@Controller
public class UsrArticleController {

	int lastArticleId;
	List<Article> articles;

	public UsrArticleController() {
		articles = new ArrayList<>();
		lastArticleId = 0;

		makeTestData();
	}

	private void makeTestData() {
		for (int i = 1; i <= 10; i++) {
			String title = "제목" + i;
			String body = "내용" + i;

			writeArticle(title, body);
		}
	}

	@RequestMapping("/usr/article/getArticle")
	@ResponseBody
	public Object getArticle(int id) {
		Article article = getArticleById(id);

		if (article == null) {
			return id + "번은 존재하지 않는 게시물입니다.";
		}

		return article;
	}

	public Article getArticleById(int id) {
		for (Article article : articles) {
			if (article.getId() == id) {
				return article;
			}
		}
		return null;
	}

	private Article writeArticle(String title, String body) {
		int id = lastArticleId + 1;

		Article article = new Article(id, title, body);

		articles.add(article);
		lastArticleId++;

		return article;

	}

	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public Article doAdd(String title, String body) {
		int id = lastArticleId + 1;

		Article article = new Article(id, title, body);
		articles.add(article);
		lastArticleId++;

		return article;
	}

	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		return articles;
	}

	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public String doDelete(int id) {
		Article article = getArticleById(id);

		if (article == null) {
			return id + "번은 존재하지 않는 게시물입니다.";
		}

		articles.remove(article);
		return id + "번이 삭제되었습니다.";
	}

	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public Object doModify(int id, String title, String body) {
		Article article = getArticleById(id);

		if (article == null) {
			return id + "번은 존재하지 않는 게시물입니다.";
		}

		article.setTitle(title);
		article.setBody(body);

		return article;
	}
}