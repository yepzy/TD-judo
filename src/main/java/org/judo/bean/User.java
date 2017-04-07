package org.judo.bean;

import java.util.UUID;

public class User {
    private String id;
    private String name;
    private String login;
    private String password;
    private String grade;
    private String email;
    private String phone;
    private String comment;

    /**
     * @param name
     * @param login
     * @param grade
     * @param email
     * @param phone
     * @param comment
     */
    public User(String name, String login, String password, String grade, String email, String phone, String comment) {
	super();
	this.id = UUID.randomUUID().toString();
	this.name = name;
	this.login = login;
	this.setPassword(password);
	this.grade = grade;
	this.email = email;
	this.phone = phone;
	this.comment = comment;
    }

    /**
     * @return the id
     */
    public String getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
	this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the login
     */
    public String getLogin() {
	return login;
    }

    /**
     * @param login
     *            the login to set
     */
    public void setLogin(String login) {
	this.login = login;
    }

    /**
     * @return the grade
     */
    public String getGrade() {
	return grade;
    }

    /**
     * @param grade
     *            the grade to set
     */
    public void setGrade(String grade) {
	this.grade = grade;
    }

    /**
     * @return the email
     */
    public String getEmail() {
	return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
	this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
	return phone;
    }

    /**
     * @param phone
     *            the phone to set
     */
    public void setPhone(String phone) {
	this.phone = phone;
    }

    /**
     * @return the comment
     */
    public String getComment() {
	return comment;
    }

    /**
     * @param comment
     *            the comment to set
     */
    public void setComment(String comment) {
	this.comment = comment;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "User [id=" + id + ", name=" + name + ", login=" + login + ", grade=" + grade + ", email=" + email
		+ ", phone=" + phone + ", comment=" + comment + "]";
    }

    /**
     * @return the password
     */
    public String getPassword() {
	return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
	this.password = password;
    }
}
