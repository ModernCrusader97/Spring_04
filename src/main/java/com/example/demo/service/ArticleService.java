package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.repository.ArticleRepository;
import com.example.demo.vo.Article;

@Service
public class ArticleService {
	
	private final ArticleRepository articleRepository;
	
	public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
        makeTestData();
    }
	
	private void makeTestData() {
		for (int i = 1; i <= 10; i++) {
			String title = "제목" + i;
			String body = "내용" + i;

			articleRepository.writeArticle(title, body);
		}
	}


	public Object getArticle(int id) {
		return articleRepository.getArticleById(id);
	}

	public Article getArticleById(int id) {
		return articleRepository.getArticleById(id);
	}

	public Article writeArticle(String title, String body) {
		articleRepository.writeArticle(title, body);
		return new Article(title, body);
		}

	public List<Article> getArticles() {
		return articleRepository.getArticles();
	}


	public void deleteArticle(int id) {
		articleRepository.deleteArticle(id);
	}
	
	public void modifyArticle(int id, String title, String body) {
		articleRepository.modifyArticle(id, title, body);
	}
}
