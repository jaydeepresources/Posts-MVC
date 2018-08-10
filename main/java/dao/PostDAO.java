package dao;

import java.sql.SQLException;
import java.util.List;

import model.Post;

public interface PostDAO {
	
	int insert(Post post);
	int update(Post post);
	int delete(int id);
	List<Post> view() throws SQLException;
	Post view(int id);

}
