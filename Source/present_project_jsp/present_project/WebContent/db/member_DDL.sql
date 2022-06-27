DROP TABLE MEMBER_LEVEL;
DROP TABLE MBTI;
DROP SEQUENCE FREEBOARD_SEQ;
DROP TABLE FREEBOARD;
DROP TABLE MEMBER;



-- 멤버 등급
CREATE TABLE MEMBER_LEVEL(
    LEVELNO NUMBER(2) PRIMARY KEY,
    LEVELNAME VARCHAR2(30)
);

INSERT INTO MEMBER_LEVEL
    VALUES(0, '브론즈');
INSERT INTO MEMBER_LEVEL
    VALUES(1, '실버');
INSERT INTO MEMBER_LEVEL
    VALUES(2, '골드');
INSERT INTO MEMBER_LEVEL
    VALUES(3, '다이아몬드');

SELECT * FROM MEMBER_LEVEL;

-- MBTI
CREATE TABLE MBTI(
    MBTI NUMBER(2) PRIMARY KEY,
    MBTINAME VARCHAR2(10)
);

INSERT INTO MBTI VALUES(0, '모름');
INSERT INTO MBTI VALUES(1, 'ENTP');
INSERT INTO MBTI VALUES(2, 'ENTJ');
INSERT INTO MBTI VALUES(3, 'ENFP');
INSERT INTO MBTI VALUES(4, 'ENFJ');
INSERT INTO MBTI VALUES(5, 'ESTP');
INSERT INTO MBTI VALUES(6, 'ESTJ');
INSERT INTO MBTI VALUES(7, 'ESFP');
INSERT INTO MBTI VALUES(8, 'ESFJ');
INSERT INTO MBTI VALUES(9, 'INTP');
INSERT INTO MBTI VALUES(10, 'INTJ');
INSERT INTO MBTI VALUES(11, 'INFP');
INSERT INTO MBTI VALUES(12, 'INFJ');
INSERT INTO MBTI VALUES(13, 'ISTP');
INSERT INTO MBTI VALUES(14, 'ISTJ');
INSERT INTO MBTI VALUES(15, 'ISFP');
INSERT INTO MBTI VALUES(16, 'ISFJ');

SELECT * FROM MBTI;


-- 멤버
CREATE TABLE MEMBER(
    mID VARCHAR2(30) PRIMARY KEY,
    mPW VARCHAR2(30) NOT NULL,
    mNAME VARCHAR2(30) NOT  NULL,
    mBIRTH DATE,
    mGENDER VARCHAR2(10) NOT NULL,
    MBTI NUMBER(2) REFERENCES MBTI(MBTI),
    mRDATE DATE DEFAULT SYSDATE,
    LEVELNO NUMBER(2) DEFAULT 0 REFERENCES MEMBER_LEVEL(LEVELNO),
    mLIKE NUMBER(5) DEFAULT 0,
    mWRITECOUNT NUMBER(5) DEFAULT 0
);

INSERT INTO MEMBER(mID, mPW, mNAME, mBIRTH, mGENDER, MBTI)
    VALUES('moan', '1234', '문희석', '1995-12-05', 'm', 9);
INSERT INTO MEMBER(mID, mPW, mNAME, mBIRTH, mGENDER, MBTI, LEVELNO)
    VALUES('aaa', '1234', '홍길동1', '1995-12-05', 'f', 1, 2);
INSERT INTO MEMBER(mID, mPW, mNAME, mBIRTH, mGENDER, MBTI, LEVELNO)
    VALUES('bbb', '1234', '홍길동2', '1995-12-05', 'm', 9, 0);
INSERT INTO MEMBER(mID, mPW, mNAME, mBIRTH, mGENDER, MBTI, LEVELNO)
    VALUES('ccc', '1234', '홍길동3', '1995-12-05', 'f', 0, 3);
INSERT INTO MEMBER(mID, mPW, mNAME, mBIRTH, mGENDER, MBTI, LEVELNO)
    VALUES('ddd', '1234', '홍길동4', '1995-12-05', 'm', 15, 0);    

SELECT * FROM MEMBER;


-- 자유게시판
CREATE TABLE FREEBOARD(
    bNO NUMBER(6) PRIMARY KEY,
    mID VARCHAR2(30) REFERENCES MEMBER(mID),
    MBTI NUMBER(2) REFERENCES MBTI(MBTI),
    bTITLE VARCHAR2(100) NOT NULL,
    bCONTENT VARCHAR2(4000) NOT NULL,
    bFILENAME VARCHAR2(100),
    bRDATE DATE DEFAULT SYSDATE,
    bHIT NUMBER(6) DEFAULT 0 NOT NULL,
    bGROUP NUMBER(6) NOT NULL,
    bSTEP NUMBER(6) NOT NULL,
    bINDENT NUMBER(6) NOT NULL,
    bLIKE NUMBER(6) DEFAULT 0 NOT NULL,
    bIP VARCHAR2(30) NOT NULL,
    bANSWERCOUNT NUMBER(6) DEFAULT 0 NOT NULL,
    bDELETEMARK NUMBER(2) DEFAULT 0 NOT NULL
);

CREATE SEQUENCE FREEBOARD_SEQ
MAXVALUE 999999 NOCACHE NOCYCLE;

INSERT INTO FREEBOARD(bNO, mID, MBTI, bTITLE, bCONTENT, bFILENAME,
                bGROUP, bSTEP, bINDENT, bIP)
        VALUES(FREEBOARD_SEQ.NEXTVAL, 'aaa', '5', 'title', 'content', 'filename',
                FREEBOARD_SEQ.CURRVAL, 1, 1, '123.123.123.123');
INSERT INTO FREEBOARD(bNO, mID, MBTI, bTITLE, bCONTENT, bFILENAME,
                bGROUP, bSTEP, bINDENT, bIP)
        VALUES(FREEBOARD_SEQ.NEXTVAL, 'bbb', '2', 'title', 'content', 'filename',
                FREEBOARD_SEQ.CURRVAL, 0, 0, '125.123.123.123');
INSERT INTO FREEBOARD(bNO, mID, MBTI, bTITLE, bCONTENT, bFILENAME,
                bGROUP, bSTEP, bINDENT, bIP)
        VALUES(FREEBOARD_SEQ.NEXTVAL, 'ccc', '5', 'title', 'content', 'filename',
                FREEBOARD_SEQ.CURRVAL, 0, 0, '123.123.123.123');          
INSERT INTO FREEBOARD(bNO, mID, MBTI, bTITLE, bCONTENT, bFILENAME,
                bGROUP, bSTEP, bINDENT, bIP)
        VALUES(FREEBOARD_SEQ.NEXTVAL, 'aaa', '5', 'title', 'content', 'filename',
                FREEBOARD_SEQ.CURRVAL, 1, 1, '123.123.123.123');
INSERT INTO FREEBOARD(bNO, mID, MBTI, bTITLE, bCONTENT, bFILENAME,
                bGROUP, bSTEP, bINDENT, bIP)
        VALUES(FREEBOARD_SEQ.NEXTVAL, 'aaa', '5', 'title', 'content', 'filename',
                5, 1, 1, '123.123.123.123');                

SELECT * FROM FREEBOARD;













