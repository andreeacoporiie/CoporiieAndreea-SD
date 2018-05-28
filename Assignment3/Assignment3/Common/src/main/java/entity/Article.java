package entity;

import java.util.List;

public class Article {

	String title;
	String author;
	String abs;     // article abstract
	String body;
	List<Article> relatedArticles;
	
	public Article(){}
	
	public Article(String title, String author, String abs, String body, List<Article> relatedArticles) {
		super();
		this.title = title;
		this.author = author;
		this.abs = abs;
		this.body = body;
		this.relatedArticles = relatedArticles;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAbs() {
		return abs;
	}
	public void setAbs(String abs) {
		this.abs = abs;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public List<Article> getRelatedArticles() {
		return relatedArticles;
	}
	public void setRelatedArticles(List<Article> relatedArticles) {
		this.relatedArticles = relatedArticles;
	}

	@Override
	public String toString() {
		return title + "\n" + abs + "\n" + "Author: " + author + "\n";
	}
	
	public String titleToString() {
		return title;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
	    if (obj == this) return true;
	    if (!(obj instanceof Article)) return false;
	    Article o = (Article) obj;
	    return (o.getTitle() == this.getTitle());
	}
	
	
	
	
}
