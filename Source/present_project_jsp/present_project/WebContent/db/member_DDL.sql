DROP SEQUENCE FREEBOARD_SEQ;
DROP TABLE FREEBOARD;
DROP TABLE MEMBER;

-- 멤버
CREATE TABLE MEMBER(
    mID VARCHAR2(30) PRIMARY KEY,
    mPW VARCHAR2(30) NOT NULL,
    mNAME VARCHAR2(30) NOT  NULL,
    mBIRTH DATE,
    mGENDER VARCHAR2(10) NOT NULL,
    mEMAIL VARCHAR2(30) UNIQUE,
    mMBTI VARCHAR2(10),
    mRDATE DATE DEFAULT SYSDATE,
    mLIKE NUMBER(5) DEFAULT 0,
    mWRITECOUNT NUMBER(5) DEFAULT 0
);

INSERT INTO MEMBER(mID, mPW, mNAME, mBIRTH, mGENDER, mMBTI, mEMAIL)
    VALUES('moan', '1234', '문희석', '1995-12-05', 'm', 'INTJ', 'moan@moan.com');
INSERT INTO MEMBER(mID, mPW, mNAME, mBIRTH, mGENDER, mMBTI, mEMAIL)
    VALUES('aaa', '1234', '홍길동1', '1995-12-05', 'm', 'ENTP', 'moan1@moan.com');
INSERT INTO MEMBER(mID, mPW, mNAME, mBIRTH, mGENDER, mMBTI, mEMAIL)
    VALUES('bbb', '1234', '홍길동2', '1995-12-05', 'm', 'ISFJ', 'moan2@moan.com');
INSERT INTO MEMBER(mID, mPW, mNAME, mBIRTH, mGENDER, mMBTI, mEMAIL)
    VALUES('ccc', '1234', '홍길동3', '1995-12-05', 'm', 'INFP', 'moan3@moan.com');
INSERT INTO MEMBER(mID, mPW, mNAME, mBIRTH, mGENDER, mMBTI, mEMAIL)
    VALUES('ddd', '1234', '홍길동4', '1995-12-05', 'm', 'ENTJ', 'moan4@moan.com');
INSERT INTO MEMBER(mID, mPW, mNAME, mBIRTH, mGENDER, mMBTI, mEMAIL)
    VALUES('eee', '1234', '홍길동5', '1995-12-05', 'm', 'ENFP', 'moan5@moan.com');
INSERT INTO MEMBER(mID, mPW, mNAME, mBIRTH, mGENDER, mMBTI, mEMAIL)
    VALUES('fff', '1234', '홍길동6', '1995-12-05', 'm', 'ESFJ', 'moan6@moan.com');
    

SELECT * FROM MEMBER;


-- 자유게시판
CREATE TABLE FREEBOARD(
    bNO NUMBER(6) PRIMARY KEY,
    mID VARCHAR2(30) REFERENCES MEMBER(mID),
    bMBTI VARCHAR2(10),
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

INSERT INTO FREEBOARD(bNO, mID, bMBTI, bTITLE, bCONTENT, bFILENAME,
                bGROUP, bSTEP, bINDENT, bIP)
        VALUES(FREEBOARD_SEQ.NEXTVAL, 'aaa', 'INTP', 'title', 'content', 'filename',
                FREEBOARD_SEQ.CURRVAL, 1, 1, '123.123.123.123');
INSERT INTO FREEBOARD(bNO, mID, bMBTI, bTITLE, bCONTENT, bFILENAME,
                bGROUP, bSTEP, bINDENT, bIP)
        VALUES(FREEBOARD_SEQ.NEXTVAL, 'bbb', 'ISFJ', 'title', 'content', 'filename',
                FREEBOARD_SEQ.CURRVAL, 0, 0, '125.123.123.123');
INSERT INTO FREEBOARD(bNO, mID, bMBTI, bTITLE, bCONTENT, bFILENAME,
                bGROUP, bSTEP, bINDENT, bIP)
        VALUES(FREEBOARD_SEQ.NEXTVAL, 'ccc', 'ENFP', 'title', 'content', 'filename',
                FREEBOARD_SEQ.CURRVAL, 0, 0, '123.123.123.123');          
INSERT INTO FREEBOARD(bNO, mID, bMBTI, bTITLE, bCONTENT, bFILENAME,
                bGROUP, bSTEP, bINDENT, bIP)
        VALUES(FREEBOARD_SEQ.NEXTVAL, 'ddd', 'INTJ', 'title', 'content', 'filename',
                FREEBOARD_SEQ.CURRVAL, 1, 1, '123.123.123.123');
INSERT INTO FREEBOARD(bNO, mID, bMBTI, bTITLE, bCONTENT, bFILENAME,
                bGROUP, bSTEP, bINDENT, bIP)
        VALUES(FREEBOARD_SEQ.NEXTVAL, 'eee', 'ISFP', 'title', 'content', 'filename',
                5, 1, 1, '123.123.123.123');                

SELECT * FROM FREEBOARD;













