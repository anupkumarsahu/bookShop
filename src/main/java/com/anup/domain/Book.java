package com.anup.domain;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="BOOKS")
public class Book implements Serializable {

	private Integer bookNo;
	private String bookName;
	private Integer author1No;
	private Integer author2No;
	private Integer author3No;
	private Integer author4No;
	private Integer publisherNo;
	private Integer categoryNo;
	private Blob coverPage;
	private String isbn;
	private String edition;
	private Integer year;
	private Integer cost;
	private String synopsis;
	private String aboutAuthors;
	private String topicsCovered;
	private String contentsCDROM;
	private Blob toc;
	private Blob sampleChapter;
	private Integer hits;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="BOOKNO")
	public Integer getBookNo() {
		return bookNo;
	}
	public void setBookNo(Integer bookNo) {
		this.bookNo = bookNo;
	}
	
	@Column(name="BOOKNAME")
    @NotEmpty(message="Book name is mandatory")
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	@Column(name="AUTHOR1NO")
    @NotNull(message="Author name is mandatory")
	public Integer getAuthor1No() {
		return author1No;
	}
	public void setAuthor1No(Integer author1No) {
		this.author1No = author1No;
	}
	
	@Column(name="AUTHOR2NO")
	public Integer getAuthor2No() {
		return author2No;
	}
	public void setAuthor2No(Integer author2No) {
		this.author2No = author2No;
	}
	
	@Column(name="AUTHOR3NO")
	public Integer getAuthor3No() {
		return author3No;
	}
	public void setAuthor3No(Integer author3No) {
		this.author3No = author3No;
	}
	
	@Column(name="AUTHOR4NO")
	public Integer getAuthor4No() {
		return author4No;
	}
	public void setAuthor4No(Integer author4No) {
		this.author4No = author4No;
	}
	
	@Column(name="PUBLISHERNO")
    @NotNull(message="Publisher name is mandatory")
	public Integer getPublisherNo() {
		return publisherNo;
	}
	public void setPublisherNo(Integer publisherNo) {
		this.publisherNo = publisherNo;
	}
	
	@Column(name="CATEGORYNO")
    @NotNull(message="Category is mandatory")
	public Integer getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(Integer categoryNo) {
		this.categoryNo = categoryNo;
	}
	
	@Column(name="COVERPAGE")
    @Lob
	public Blob getCoverPage() {
		return coverPage;
	}
	public void setCoverPage(Blob coverPage) {
		this.coverPage = coverPage;
	}
	
	@Column(name="ISBN")
    @NotEmpty(message="ISBN is mandatory")
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	@Column(name="EDITION")
    @NotEmpty(message="Edition is mandatory")
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	
	@Column(name="YEAR")
    @NotNull(message="Year is mandatory")
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	
	@Column(name="COST")
    @NotNull(message="Cost is mandatory")
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
	@Column(name="SYNOPSIS")
    @NotEmpty(message="Synopsis is mandatory")
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	@Column(name="ABOUTAUTHORS")
    @NotEmpty(message="About Authors is mandatory")
	public String getAboutAuthors() {
		return aboutAuthors;
	}
	public void setAboutAuthors(String aboutAuthors) {
		this.aboutAuthors = aboutAuthors;
	}
	
	@Column(name="TOPICSCOVERED")
	public String getTopicsCovered() {
		return topicsCovered;
	}
	public void setTopicsCovered(String topicsCovered) {
		this.topicsCovered = topicsCovered;
	}
	
	@Column(name="CONTENTSCDROM")
	public String getContentsCDROM() {
		return contentsCDROM;
	}
	public void setContentsCDROM(String contentsCDROM) {
		this.contentsCDROM = contentsCDROM;
	}
	
	@Column(name="TOC")
    @Lob
	public Blob getToc() {
		return toc;
	}
	public void setToc(Blob toc) {
		this.toc = toc;
	}
	
	@Column(name="SAMPLECHAPTER")
    @Lob
	public Blob getSampleChapter() {
		return sampleChapter;
	}
	public void setSampleChapter(Blob sampleChapter) {
		this.sampleChapter = sampleChapter;
	}
	
	@Column(name="HITS")
	public Integer getHits() {
		return hits;
	}
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	
	
}
