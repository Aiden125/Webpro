-- 고객초기화
DROP TABLE  CUSTOMER CASCADE CONSTRAINTS;

-- 게시판 초기화
DROP TABLE BBS;
DROP SEQUENCE BBS_SQ;

-- 관리자 초기화
DROP TABLE MANAGER;



-- 고객테이블 생성
CREATE TABLE CUSTOMER(
    cID VARCHAR2(30) PRIMARY KEY,
    cPW VARCHAR2(30) NOT NULL,
    cNAME VARCHAR2(30) NOT NULL,
    cEMAIL VARCHAR2(50),
    cIMAGE VARCHAR2(50),
    cBIRTH DATE,
    cADDRESS VARCHAR2(250),
    cCURRENT DATE DEFAULT SYSDATE
);



-- 글쓰기용 테이블, 시퀀스 생성
CREATE TABLE BBS(
    bNO NUMBER(6) PRIMARY KEY,
    bID VARCHAR2(30) NOT NULL,
    bTITLE VARCHAR2(200) NOT NULL,
    bCONTENT VARCHAR2(4000) NOT NULL,
    bFILENAME VARCHAR2(50),
    bREADCOUNT NUMBER(7) DEFAULT 0 NOT NULL,
    bREF NUMBER(7) NOT NULL,
    bRE_STEP NUMBER(7) NOT NULL,
    bRE_INDENT NUMBER(7) NOT NULL,
    bIP VARCHAR2(50) NOT NULL,
    bCURRENT DATE DEFAULT SYSDATE NOT NULL
);

CREATE SEQUENCE BBS_SQ MAXVALUE 999999 NOCACHE NOCYCLE;



-- 관리자용 테이블
CREATE TABLE MANAGER(
    mID VARCHAR2(30) PRIMARY KEY,
    mPW VARCHAR2(30) NOT NULL,
    mNAME VARCHAR2(30) NOT NULL
);


-- 커밋
SELECT * FROM CUSTOMER;
SELECT * FROM BBS;
SELECT * FROM MANAGER;
COMMIT;