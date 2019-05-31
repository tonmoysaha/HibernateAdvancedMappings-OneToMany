package com.hibernate.onetomany.entityclass.bidirectional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetailClass {

	@Id // use for primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // use for auto increment in database
	@Column(name = "id")
	private int id;

	@Column(name = "youtube_channel") // database table colum name
	private String youtube_channel;

	@Column(name = "hobby")
	private String hobby;

	@OneToOne(mappedBy = "instructorDetailClass", cascade = CascadeType.ALL)
	private Instructor instructor;

	public InstructorDetailClass() {
		super();
	}

	public InstructorDetailClass(String youtube_channel, String hobby) {
		super();
		this.youtube_channel = youtube_channel;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutube_channel() {
		return youtube_channel;
	}

	public void setYoutube_channel(String youtube_channel) {
		this.youtube_channel = youtube_channel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructorDetailClass [id=" + id + ", youtube_channel=" + youtube_channel + ", hobby=" + hobby + "]";
	}

}
