package com.networkproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.networkproject.model.user.User;

@Entity
public class Text {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int textId;
	
	private String subject;
	
	private String text;

	@Temporal(TemporalType.TIMESTAMP)
	private Date addDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
	
	@ManyToOne
	@JoinColumn(name = "unitId")
	private Unit unit;
	
	@ManyToOne
	@JoinColumn(name = "routerId")
	private Router router;
	
	@ManyToOne
	@JoinColumn(name = "provinceId")
	private Province province;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	public Text() {

	}

	public Text(String subject, String text, Date addDate, Date updateDate, Unit unit, Router router, Province province, User user) {
		this.subject = subject;
		this.text = text;
		this.addDate = addDate;
		this.updateDate = updateDate;
		this.unit = unit;
		this.router = router;
		this.province = province;
		this.user = user;
		
	}

	public int getTextId() {
		return textId;
	}

	public void setTextId(int textId) {
		this.textId = textId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
	public Router getRouter() {
		return router;
	}

	public void setRouter(Router router) {
		this.router = router;
	}
	
	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	@Override
	public String toString() {
		return "Text [textId=" + textId + ", subject=" + subject + ", text=" + text + ", addDate=" + addDate
				+ ", updateDate=" + updateDate + ", unit=" + unit + ", router=" + router + ", province=" + province
				+ ", user=" + user + "]";
	}

}
