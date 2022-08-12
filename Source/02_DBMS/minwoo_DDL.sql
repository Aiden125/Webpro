-- SEQUENCE & TABLE  DROP/CREATE
-- DROP SEQUENCE MEMBER_SQ;
-- DROP SEQUENCE QNA_SQ;

DROP TABLE MEMBER;

DROP TABLE QNA;

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

-- CREATE SEQUENCE MEMBER_SQ MAXVALUE 999999 NOCYCLE NOCACHE;



    
CREATE TABLE QNA(
    QNO VARCHAR(50) PRIMARY KEY, -- 글 번호
    qID VARCHAR(50) , -- 글쓴이 사용자 or 관리자
    QSUBJECT VARCHAR(250) NOT NULL, -- 글 제목
    QCONTENT VARCHAR(4000) NOT NULL, -- 글 내용
    QHIT NUMBER(8) DEFAULT 0, -- 조회수
    QGROUP NUMBER(8), --글 그룹
    QSTEP NUMBER(8), -- 그룹내 출력 순서
    QRDATE DATE DEFAULT SYSDATE, -- 등록 시점
    QSECRET VARCHAR(10) default 'N',-- 비밀글 여부 
    QREPLYCHECK VARCHAR(10) DEFAULT 0 -- 답변 없음 0, 답변 있음 1
);
CREATE SEQUENCE QNA_SQ MAXVALUE 999999 NOCYCLE NOCACHE;

--member Dummy
INSERT INTO MEMBER VALUES('aaa', '지코','1', '010-1234-1234','zico@naver.com','서울시 강남구 역삼동','남자','1992/09/14','zico.jpg');
INSERT INTO MEMBER VALUES('kang', '강동원','1', '010-4321-4321','kang@naver.com','서울시 강남구 역삼동','남자','1992/09/14','kang.jpg');

select * from member;
select * from qna where qno=272;













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
