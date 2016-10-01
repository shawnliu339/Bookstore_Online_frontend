package mybookapp1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mybookapp1.DTO.Book;
import mybookapp1.factory.ConnectionFactory;

public class BookDAO {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public List<String> getTypes() {
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT DISTINCT book_type ");
			sql.append("FROM tb_book ");
			pstm = conn.prepareStatement(sql.toString());
			rs = pstm.executeQuery();

			List<String> types = new ArrayList<String>();
			String type = null;
			while (rs.next()) {
				type = new String();
				type = rs.getString("book_type");
				types.add(type);
			}
			return types;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.close(conn, pstm, rs);
		}
	}
	
	public List<Book> findBooksByType(String type){
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT book_id, book_name, book_publisher, book_price ");
			sql.append("FROM tb_book ");
			sql.append("WHERE book_type = ? ");
			pstm = conn.prepareStatement(sql.toString());
			pstm.setString(1, type);
			rs = pstm.executeQuery();
			List<Book> books = new ArrayList<Book>();
			Book book = null;
			while(rs.next()) {
				Integer id = rs.getInt("book_id");
				String name = rs.getString("book_name");
				String publisher = rs.getString("book_publisher");
				Double price = rs.getDouble("book_price");
				
				book = new Book();
				book.setId(id);
				book.setName(name);
				book.setPublisher(publisher);
				book.setPrice(price);
				books.add(book);
			}
			return books;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.close(conn, pstm, rs);
		}
	}
	public Book findBookById(Integer id) {
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM tb_book ");
			sql.append("WHERE book_id = ? ");
			pstm = conn.prepareStatement(sql.toString());
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			Book book = null;
			if (rs.next()) {
				book = new Book();
				book.setId(rs.getInt("book_id"));
				book.setISBN(rs.getString("book_ISBN"));
				book.setName(rs.getString("book_name"));
				book.setAuthor(rs.getString("book_author"));
				book.setPublisher(rs.getString("book_publisher"));
				book.setDate(rs.getString("book_date"));
				book.setPrice(rs.getDouble("book_price"));
				book.setIntroduction(rs.getString("book_introduction"));
				book.setBookType(rs.getString("book_type"));
				book.setImg(rs.getString("book_img"));
				book.setNewFlag(rs.getInt("book_newFlag"));
				book.setCommend(rs.getInt("book_commend"));
			}
			return book;
		} catch (Exception e) {
			System.out.println("find book by id error!");
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.close(conn, pstm, rs);
		}

	}

	public List<Book> findBookByLike(Book keyBook) {
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			String keyName = keyBook.getName();
			if (keyName != null && !keyName.equals("")) {
				sql.append("SELECT * FROM tb_book ");
				sql.append("WHERE book_name LIKE '%" + keyName + "%' ");
			}
			pstm = conn.prepareStatement(sql.toString());
			rs = pstm.executeQuery();
			List<Book> books = new ArrayList<Book>();

			while (rs.next()) {

				Integer id = rs.getInt("book_id");
				String ISBN = rs.getString("book_ISBN");
				String name = rs.getString("book_name");
				String author = rs.getString("book_author");
				String publisher = rs.getString("book_publisher");
				String date = rs.getString("book_date");
				Double price = rs.getDouble("book_price");
				String introduction = rs.getString("book_introduction");
				String bookType = rs.getString("book_type");
				String img = rs.getString("book_img");
				Integer newFlag = rs.getInt("book_newFlag");
				Integer commend = rs.getInt("book_commend");

				Book book = new Book();
				book.setId(id);
				book.setISBN(ISBN);
				book.setName(name);
				book.setAuthor(author);
				book.setPublisher(publisher);
				book.setDate(date);
				book.setPrice(price);
				book.setIntroduction(introduction);
				book.setBookType(bookType);
				book.setImg(img);
				book.setNewFlag(newFlag);
				book.setCommend(commend);
				books.add(book);

			}
			return books;
		} catch (Exception e) {
			System.out.println("finding book by like is error");
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.close(conn, pstm, rs);
		}
	}

	public List<Book> findAll() {
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * ");
			sql.append("FROM tb_book ");
			pstm = conn.prepareStatement(sql.toString());
			rs = pstm.executeQuery();

			List<Book> books = new ArrayList<Book>();
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("book_id"));
				book.setISBN(rs.getString("book_ISBN"));
				book.setName(rs.getString("book_name"));
				book.setAuthor(rs.getString("book_author"));
				book.setPublisher(rs.getString("book_publisher"));
				book.setDate(rs.getString("book_date"));
				book.setPrice(rs.getDouble("book_price"));
				book.setIntroduction(rs.getString("book_introduction"));
				book.setBookType(rs.getString("book_type"));
				book.setImg(rs.getString("book_img"));
				book.setNewFlag(rs.getInt("book_newFlag"));
				book.setCommend(rs.getInt("book_commend"));
				books.add(book);
			}
			return books;
		} catch (Exception e) {
			System.out.println("find all book error!");
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.close(conn, pstm, rs);
		}
	}

	public static void main(String[] args) {
		BookDAO bookDao = new BookDAO();
		Book keyBook = new Book();
		System.out.println(bookDao.getTypes());
		System.out.println(bookDao.findBooksByType("¼ÆËã»ú"));

	}
}
