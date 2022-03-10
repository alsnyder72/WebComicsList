//final annotated ListItem POJO
package model;

//All these import statements came in by clicking the red X and using Import option from the javax.persistence package
//If you are asked to create a class, interface, constant, etc, you made a spelling or capitalization error!!
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author AlSnyder - asnyder7
 * CIS175 - SPRING 2022
 * Feb 02, 2022
 * Comics List
 */

@Entity
@Table(name="comics")
public class ListItem {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="PUBLISHER")
	private String publisher;
	@Column(name="TITLE")
	private String title;
	@Column(name="VOLUME")
	private int volume;
	@Column(name="ISSUE")
	private int issue;
	
	
	public ListItem() {
		super();
	}

	public ListItem(String publisher, String title) {
		super();
		this.publisher = publisher;
		this.title = title;
		this.volume = 1;
		this.issue = 1;
	}
	
	public ListItem(String publisher, String title, int volume, int issue) {
		super();
		this.publisher = publisher;
		this.title = title;
		this.volume = volume;
		this.issue = issue;
	}
	
	public ListItem(String publisher, String title, String volume, String issue) {
		super();
		this.publisher = publisher;
		this.title = title;
		this.volume = Integer.parseInt(volume);
		this.issue = Integer.parseInt(issue);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int newVolume) {
		this.volume = newVolume;
	}

	public int getIssue() {
		return issue;
	}

	public void setIssue(int issue) {
		this.issue = issue;
	}
	
	
	public String returnItemDetails() {
		return this.publisher + ": " + this.title + ": " + this.volume + ": " + this.issue;
	}

	@Override
	public String toString() {
		return "ListItem [id=" + id + ", publisher=" + publisher + ", title=" + title + "]";  //", volume=" + volume + ", issue=" + issue + "]"; for future use
	}
	
	
	
}
