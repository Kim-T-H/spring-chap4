package xml;

public class Article {
	private int id;
	private ArticleDao dao;
	public Article() {}
	public Article(int id) {
		this.id=id;
	}
	public void inceraseReadCount() {
		dao.updateReadCount(id, 1);
	}
	public void setDao(ArticleDao dao) {
		this.dao=dao;
	}
}
