package com.example.demo.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class Article {

	private int id;
	private String regDate;
	private String updateDate;
	private int memberId;
	private String title;
	private String body;
}