package mybookapp1.DTO;

public class Guestbook {

	private Integer id;
	private Integer userId;
	private String title;
	private String content;
	private String reply;
	private String date;
	private Integer replyFlag;

	public Guestbook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Guestbook(Integer id, Integer userId, String title, String content,
			String reply, String date, Integer replyFlag) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.reply = reply;
		this.date = date;
		this.replyFlag = replyFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getReplyFlag() {
		return replyFlag;
	}

	public void setReplyFlag(Integer replyFlag) {
		this.replyFlag = replyFlag;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((reply == null) ? 0 : reply.hashCode());
		result = prime * result
				+ ((replyFlag == null) ? 0 : replyFlag.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Guestbook other = (Guestbook) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (reply == null) {
			if (other.reply != null)
				return false;
		} else if (!reply.equals(other.reply))
			return false;
		if (replyFlag == null) {
			if (other.replyFlag != null)
				return false;
		} else if (!replyFlag.equals(other.replyFlag))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Guestbook [id=" + id + ", userId=" + userId + ", title="
				+ title + ", content=" + content + ", reply=" + reply
				+ ", date=" + date + ", replyFlag=" + replyFlag + "]";
	}

}
