-- FINAL DDL MYSQL











































-- 민우

DROP TABLE QNA;
DROP TABLE MEMBER;
DROP TABLE qna_seq;
DROP TABLE member_seq;
SHOW TABLE status;


CREATE TABLE QNA(
    qno VARCHAR(50) PRIMARY KEY, -- 글 번호
    qid VARCHAR(50) , -- 글쓴이 사용자 or 관리자
    qsubject VARCHAR(250) NOT NULL, -- 글 제목
    qcontent VARCHAR(4000) NOT NULL, -- 글 내용
    qhit int(8) DEFAULT 0, -- 조회수
    qgroup int(8), -- 글 그룹
    qstep int(8), -- 그룹내 출력 순서
    qrdate DATETIME DEFAULT current_timestamp, -- 등록 시점
    qsecret VARCHAR(10) default 'N',-- 비밀글 여부 
    qreplycheck VARCHAR(10) DEFAULT 0 -- 답변 없음 0, 답변 있음 1
);


-- 테이블 생성
CREATE TABLE qna_seq(
	id INT NOT NULL,
    seq_name VARCHAR(50)
);

-- 함수 제작(qna 테이블 시퀀스)
DROP FUNCTION IF EXISTS get_qna_seq;
DELIMITER $$
CREATE FUNCTION get_qna_seq(p_seq_name VARCHAR(45))
RETURNS INT READS SQL DATA
BEGIN
DECLARE RESULT_ID INT;
UPDATE qna_seq SET id = LAST_INSERT_ID(id+1)
WHERE seq_name = p_seq_name;
SET RESULT_ID = (SELECT LAST_INSERT_ID());
RETURN RESULT_ID;
END $$
DELIMITER ;

-- 시퀀스 생성
INSERT INTO qna_seq VALUES(0, 'qno');


-- 회원 테이블 생성
CREATE TABLE MEMBER (
    mid varchar(50) primary KEY, -- 고객 ID
    mname varchar(50) NOT NULL,  -- 고객 이름
    mpw varchar(50) NOT NULL,  -- 비밀번호
    mtel varchar(50) NOT NULL, -- 전화번호
    memail varchar(50) NOT NULL, -- 고객 이메일
    maddress varchar(250), -- 고객 주소 
    mgender varchar(10), -- 고객 성별
    mbirth DATE,  -- 생일   
    mprofile varchar(50)  DEFAULT 'noImg.png'
);





-- 희석

-- Admin(mysql용)
DROP TABLE admin_seq;
DROP TABLE ADMIN_L;
DROP TABLE ADMIN;

-- 테이블 생성
CREATE TABLE admin_seq(
    id INT NOT NULL,
    seq_name VARCHAR(50)
);

-- 함수 제작
DROP FUNCTION IF EXISTS get_admin_seq;
DELIMITER $$
CREATE FUNCTION get_admin_seq(p_seq_name VARCHAR(45))
RETURNS INT READS SQL DATA
BEGIN
DECLARE RESULT_ID INT;
UPDATE admin_seq SET id = LAST_INSERT_ID(id+1)
WHERE seq_name = p_seq_name;
SET RESULT_ID = (SELECT LAST_INSERT_ID());
RETURN RESULT_ID;
END $$
DELIMITER ;

-- 시퀀스 생성
INSERT INTO admin_seq VALUES(0, 'ano');


-- ADMIN LEVEL
CREATE TABLE ADMIN_L(
    alevel VARCHAR(10) PRIMARY KEY,
    alevel_name VARCHAR(50)
);

-- ADMIN LELVE DATA
INSERT INTO ADMIN_L VALUES(0, 'MANAGER');
INSERT INTO ADMIN_L VALUES(1, 'HEAD_MANAGER');
INSERT INTO ADMIN_L VALUES(2, 'MASTER');

CREATE TABLE ADMIN(
    ano int(2) PRIMARY KEY,
    aid VARCHAR(50) UNIQUE NOT NULL,
    apw VARCHAR(50) NOT NULL,
    aemail VARCHAR(50) NOT NULL,
    aname VARCHAR(50) NOT NULL,
    atel VARCHAR(50) NOT NULL,
    alevel VARCHAR(50) DEFAULT 0 REFERENCES ADMIN_L(aLEVEL),
    ardate DATETIME DEFAULT current_timestamp
);






-- -------------------------------------------------------------------------------------------------------------