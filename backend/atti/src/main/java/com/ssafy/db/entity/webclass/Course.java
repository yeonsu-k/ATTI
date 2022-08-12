package com.ssafy.db.entity.webclass;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ssafy.db.entity.depart.Depart;
import com.ssafy.db.entity.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



/*
 * 수업 시간표 테이블
 */

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="course_id")
	private Long courseId;						// 수업 ID
	
	@Column(name="course_name")
	private String courseName;					// 수업 이름
	
	@Column(name="course_teacher_name")
	private String courseTeacherName;			// 교수명
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="course_start_time")	
	private Date courseStartTime;				// 시작 시간
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="course_end_time")
	private Date courseEndTime;					// 종료 시간
	
	@Temporal(TemporalType.DATE)
	@Column(name="course_date")
	private Date courseDate;					// 강의 날짜
	
	//////////////////////////////////////////////////////
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="depart_course")
	private Depart depart;						// 채널 ID (FK)
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="in_user_id") 
	private User in_user;
	
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "make_user_id")
	private User make_user;
	
//	@OneToOne(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private WebClass webclass;
	
//	@OneToMany(mappedBy = "user")
//	private List<UserCourse> usercourses = new ArrayList<>();
	
	public void setUser(User user) {
		this.in_user = user;
		user.getCourses().add(this);
	}
}
