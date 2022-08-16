-- SEQUENCE & TABLE  DROP/CREATE
-- DROP SEQUENCE MEMBER_SQ;
-- DROP SEQUENCE QNA_SQ;



DROP TABLE QNA;

-- CREATE SEQUENCE MEMBER_SQ MAXVALUE 999999 NOCYCLE NOCACHE;

-- qna 테이블 만들기

CREATE TABLE QNA(
    qNO VARCHAR(50) PRIMARY KEY, -- 글 번호
    qID VARCHAR(50) , -- 글쓴이 사용자 or 관리자
    qSUBJECT VARCHAR(250) NOT NULL, -- 글 제목
    qCONTENT VARCHAR(4000) NOT NULL, -- 글 내용
    qHIT int(8) DEFAULT 0, -- 조회수
    qGROUP int(8), -- 글 그룹
    qSTEP int(8), -- 그룹내 출력 순서
    qRDATE DATETIME DEFAULT current_timestamp, -- 등록 시점
    qSECRET VARCHAR(10) default 'N',-- 비밀글 여부 
    qREPLYCHECK VARCHAR(10) DEFAULT 0 -- 답변 없음 0, 답변 있음 1
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

-- 이걸로 시퀀스 호출
SELECT get_admin_seq('qno');

SELECT * FROM QNA;








-- SEQUENCE & TABLE  DROP/CREATE
DROP TABLE MEMBER;

-- 회원 테이블 생성
CREATE TABLE MEMBER (
    MID varchar(50) primary KEY, -- 고객 ID
    MNAME varchar(50) NOT NULL,  -- 고객 이름
    MPW varchar(50) NOT NULL,  -- 비밀번호
    MTEL varchar(50) NOT NULL, -- 전화번호
    MEMAIL varchar(50) NOT NULL, -- 고객 이메일
    MADDRESS varchar(250), -- 고객 주소 
    MGENDER varchar(10), -- 고객 성별
    MBIRTH DATE,  -- 생일   
    mprofile varchar(50)  DEFAULT 'noImg.png'
);

SELECT * FROM MEMBER;








CREATE SEQUENCE QNA_SQ MAXVALUE 999999 NOCYCLE NOCACHE;

--member Dummy
INSERT INTO MEMBER VALUES('aaa', '지코','1', '010-1234-1234','zico@naver.com','서울시 강남구 역삼동','남자','1992/09/14','zico.jpg');
INSERT INTO MEMBER VALUES('kang', '강동원','1', '010-4321-4321','kang@naver.com','서울시 강남구 역삼동','남자','1992/09/14','kang.jpg');

select * from member;
select * from qna where qno=272;


CREATE TABLE MEMBER (
    MID VARCHAR(50) PRIMARY KEY, -- 고객 ID
    MNAME VARCHAR(50) NOT NULL,  -- 고객 이름
    MPW VARCHAR(50) NOT NULL,  -- 비밀번호
    MTEL VARCHAR(50) NOT NULL, -- 전화번호
    MEMAIL VARCHAR(50) NOT NULL, -- 고객 이메일
    MADDRESS VARCHAR(250), -- 고객 주소 
    MGENDER VARCHAR(10), -- 고객 성별
    MBIRTH DATETIME DEFAULT current_timestamp,  -- 생일   
    mprofile VARCHAR(50)  DEFAULT 'noImg.png' NOT NULL -- 프로필
);




-- 로그인 API 관련된 부분들

drop table member_log;
-- 로그인 log
create table MEMBER_LOG (
    MID VARCHAR(50) REFERENCES MEMBER(MID),
    LOGIN_DATE DATE,
    LOGIN_STATUS VARCHAR(45)
);

-- 카카오
create table kakao (
    k_id VARCHAR(50) primary key,
    k_name VARCHAR(50),
    k_email VARCHAR(50)
);
CREATE SEQUENCE kakao_SQ MAXVALUE 999999 NOCYCLE NOCACHE;
-- 네이버 
drop table naver;
create table NAVER (
    mid VARCHAR(50) references member (mid),
    n_id VARCHAR(50) primary key, --네이버 아이디
    n_name VARCHAR(255), 
    n_phone VARCHAR(50), --전화번호
    n_email VARCHAR(50),
    n_profile VARCHAR(255), --네이버 프로필
    n_birth Date --생일
);
ALTER TABLE naver add (n_email VARCHAR(50));
CREATE SEQUENCE naver_SQ MAXVALUE 999999 NOCYCLE NOCACHE;

--네이버 로그인 처리
SELECT M.MNAME, M.MEMAIL, n.n_email, n.n_name
    from member m , naver n where m.mname = n.n_name and m.memail = n.n_email; 
    
select m.mname , m.memail , n.n_email, n.n_name   
from member m , naver n
where m.mid = n.mid and m.mname = n.n_name;

--네이버 간편 회원가입
insert into naver (mid, n_id, n_name,n_phone,n_email,n_birth)
    values ('aaa','zico0914','지코','010-1234-1234','1992/09/14');
