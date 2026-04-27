# 데이터베이스 생성
DROP DATABASE IF EXISTS `Spring_26_04`;
CREATE DATABASE `Spring_26_04`;
USE `Spring_26_04`;


# 게시글 테이블 생성
CREATE TABLE `article` (
    `id` INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `regDate` DATETIME NOT NULL,
    `updateDate` DATETIME NOT NULL,
    `title` CHAR(100) NOT NULL,
    `body` CHAR(100) NOT NULL
);
/*
- id
- regDate
- updateDate
- loginId
- loginPw
- name
- nickname
- cellphoneNum
- email
*/
# 회원 테이블 생성
CREATE TABLE `member`(
	`id` INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`updateDate` DATETIME NOT NULL,
	`regDate` DATETIME NOT NULL,
	`loginId` CHAR(100) NOT NULL,
	`loginPw` CHAR(100) NOT NULL,
	`authLevel` SMALLINT(2) UNSIGNED DEFAULT 3 COMMENT '권한 레벨 (3=일반,7=관리자)',
	`name` CHAR(100) NOT NULL,
	nickname CHAR(20) NOT NULL,
	cellphoneNum CHAR(20) NOT NULL,
	email CHAR(20) NOT NULL,
	delStatus TINYINT(1) UNSIGNED DEFAULT 0 NOT NULL COMMENT '탈퇴 여부 (0=탈퇴 전, 1=탈퇴 후)',
	delDate DATETIME COMMENT '탈퇴 날짜'
);

# 게시글 데이터 삽입
INSERT INTO `article`
SET `regDate` = NOW(),
	`updateDate` = NOW(),
	`title` = '제목1',
	`body` = '내용1';
	
INSERT INTO `article`
SET `regDate` = NOW(),
	`updateDate` = NOW(),
	`title` = '제목2',
	`body` = '내용2';

INSERT INTO `article`
SET `regDate` = NOW(),
	`updateDate` = NOW(),
	`title` = '제목3',
	`body` = '내용3';

# 회원 데이터 삽입
INSERT INTO `member`
SET `regDate` = NOW(),
	`updateDate` = NOW(),
	`loginId` = 'admin',
	`loginPw` = 'admin',
	`authLevel` = 7,
	`name` = '관리자',
	nickname = '관리자_별명',
	cellphoneNum = '01012341234',
	email = 'abc@gmail.com';

INSERT INTO `member`
SET `regDate` = NOW(),
	`updateDate` = NOW(),
	`loginId` = 'test1',
	`loginPw` = 'test1',
	`name` = '회원1',
	nickname = '회원1_별명',
	cellphoneNum = '01012345678',
	email = 'def@gmail.com';
	
INSERT INTO `member`
SET `regDate` = NOW(),
	`updateDate` = NOW(),
	`loginId` = 'test2',
	`loginPw` = 'test2',
	`name` = '회원2',
	nickname = '회원2_별명',
	cellphoneNum = '01045671234',
	email = 'eeee@gmail.com';	
	

SELECT * FROM `article`;
	
SELECT * FROM `member`;

SELECT LAST_INSERT_ID();

# 테이블 구조확인
DESC article;

# article 테이블 => memberId 컬럼 추가.
ALTER TABLE article ADD COLUMN memberId INT UNSIGNED NOT NULL AFTER regDate;


# article 테이블 => memberId 값 추가
UPDATE article
SET memberId = 1
WHERE id IN (1,2);

UPDATE article
SET memberId = 2
WHERE id = 3;

DESC `member`;

# 테스트
SELECT *
FROM article
ORDER BY id DESC;

ALTER TABLE article ADD COLUMN memberId INT UNSIGNED NOT NULL AFTER regDate;

UPDATE article
SET memberId = 2
WHERE id IN (1,2);

UPDATE article
SET memberId = 3
WHERE id = 3;