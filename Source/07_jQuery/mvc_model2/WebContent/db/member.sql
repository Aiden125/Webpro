--DROP, CREATE
DROP TABLE MEMBER;

-- 고객 테이블 생성
CREATE TABLE MEMBER(
    mID VARCHAR2(30) PRIMARY KEY,
    mPW VARCHAR2(30),
    mNAME VARCHAR2(30),
    mEMAIL VARCHAR2(30) UNIQUE NOT NULL,
    mPHOTO VARCHAR2(30),
    mBIRTH DATE,
    mADDRESS VARCHAR2(30),
    mRDATE DATE DEFAULT SYSDATE
);
-- DUMMY 삽입
INSERT INTO MEMBER(mID, mPW, mNAME, mEMAIL, mPHOTO,
                mBIRTH, mADDRESS)
            VALUES('aaa1', '1234', '홍길동1', '1hong2@hong.com', 'go.jpg',
                    '1995-12-05', '서울시');
INSERT INTO MEMBER(mID, mPW, mNAME, mEMAIL, mPHOTO,
                mBIRTH, mADDRESS)
            VALUES('aaa2', '1234', '홍길동2', '2hong2@hong.com', 'go.jpg',
                    '1995-12-05', '서울시');
INSERT INTO MEMBER(mID, mPW, mNAME, mEMAIL, mPHOTO,
                mBIRTH, mADDRESS)
            VALUES('aaa3', '1234', '홍길동3', '3hong2@hong.com', 'go.jpg',
                    '1995-12-05', '서울시');
INSERT INTO MEMBER(mID, mPW, mNAME, mEMAIL, mPHOTO,
                mBIRTH, mADDRESS)
            VALUES('aaa4', '1234', '홍길동4', '4hong2@hong.com', 'go.jpg',
                    '1995-12-05', '서울시');
INSERT INTO MEMBER(mID, mPW, mNAME, mEMAIL, mPHOTO,
                mBIRTH, mADDRESS)
            VALUES('aaa5', '1234', '홍길동5', '5hong2@hong.com', 'go.jpg',
                    '1995-12-05', '서울시');

SELECT * FROM MEMBER;
-- 1. 아이디 중복 조회
SELECT * FROM MEMBER WHERE mID='aaa';

-- 2. 로그인
SELECT * FROM MEMBER WHERE mID='aaa' AND mPW='1234';

-- 3. 회원가입
INSERT INTO MEMBER(mID, mPW, mNAME, mEMAIL, mPHOTO,
                mBIRTH, mADDRESS)
            VALUES('aaa', '1234', '홍길동', 'hong2@hong.com', 'go.jpg',
                    '1995-12-05', '서울시');

-- 4. 이메일 중복조회
SELECT * FROM MEMBER WHERE mEMAIL='aaa@aaa';


-- 5. mID로 DTO 가져오기
SELECT * FROM MEMBER WHERE mID='aaa';

-- 6. 회원정보 수정
UPDATE MEMBER SET mPW='1234',
                  mNAME='123',
                  mEMAIL='11@11',
                  mPHOTO='123.PNG',
                  mBIRTH='1995-12-12',
                  mADDRESS='서울'
            WHERE mID='aaa';

-- 7. 회원리스트보기
SELECT *
    FROM (SELECT ROWNUM RN, A.*
            FROM (SELECT * FROM MEMBER ORDER BY mID ) A)
    WHERE RN BETWEEN 2 AND 3;

-- 8. 등록된 회원수
SELECT COUNT(*) TOTCNT FROM MEMBER;

COMMIT;



-- 게시판 테이블 생성
DROP TABLE FILEBOARD;
CREATE TABLE FILEBOARD(
    fID NUMBER(6) PRIMARY KEY,
    mID VARCHAR2(30) REFERENCES MEMBER(mID),
    fTITLE VARCHAR2(100) NOT NULL,
    fCONTENT VARCHAR2(4000),
    fFILENAME VARCHAR2(100),
    fRDATE DATE DEFAULT SYSDATE NOT NULL,
    fHIT NUMBER(6) DEFAULT 0 NOT NULL,
    fGROUP NUMBER(6) NOT NULL,
    fSTEP NUMBER(6) NOT NULL,
    fINDENT NUMBER(6) NOT NULL,
    fIP VARCHAR2(30) NOT NULL
);

DROP SEQUENCE  FILE_SEQ;
CREATE SEQUENCE FILE_SEQ MAXVALUE 999999 NOCACHE NOCYCLE;

-- 더미
INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME,
                fGROUP, fSTEP, fINDENT, fIP)
        VALUES(FILE_SEQ.NEXTVAL, 'aaa1', 'title', 'content', 'go.png',
                FILE_SEQ.CURRVAL, 0, 0, '123.123.123.123');
INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME,
                fGROUP, fSTEP, fINDENT, fIP)
        VALUES(FILE_SEQ.NEXTVAL, 'aaa2', 'title', 'content', 'go.png',
                FILE_SEQ.CURRVAL, 0, 0, '123.123.123.123');
INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME,
                fGROUP, fSTEP, fINDENT, fIP)
        VALUES(FILE_SEQ.NEXTVAL, 'aaa3', 'title', 'content', 'go.png',
                FILE_SEQ.CURRVAL, 0, 0, '123.123.123.123');
INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME,
                fGROUP, fSTEP, fINDENT, fIP)
        VALUES(FILE_SEQ.NEXTVAL, 'aaa4', 'title', 'content', 'go.png',
                FILE_SEQ.CURRVAL, 0, 0, '123.123.123.123');
INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME,
                fGROUP, fSTEP, fINDENT, fIP)
        VALUES(FILE_SEQ.NEXTVAL, 'aaa5', 'title', 'content', 'go.png',
                FILE_SEQ.CURRVAL, 0, 0, '123.123.123.123');

SELECT * FROM FILEBOARD;

-- 1. 글목록
SELECT *
    FROM (SELECT ROWNUM RN, A.*
            FROM(SELECT F.*, mNAME, mEMAIL
                FROM FILEBOARD F, MEMBER M
                WHERE F.mID = M.mID
                ORDER BY FGROUP DESC, fSTEP) A)
    WHERE RN BETWEEN 2 AND 6;
        
-- 2. 등록된 글 수
SELECT COUNT(*) FROM FILEBOARD;

-- 3. 원글쓰기
INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME,
                fGROUP, fSTEP, fINDENT, fIP)
        VALUES(FILE_SEQ.NEXTVAL, 'aaa', 'title', 'content', 'go.png',
                FILE_SEQ.CURRVAL, 0, 0, '123.123.123.123');

-- 4. 답변글 쓰기전 스텝
UPDATE FILEBOARD SET fSTEP = fSTEP +1 WHERE fGROUP=5 AND fSTEP>0;

-- 5. 답변글 쓰기
INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME,
                fGROUP, fSTEP, fINDENT, fIP)
        VALUES(FILE_SEQ.NEXTVAL, 'aaa', '글1-1', '답변', 'go.png',
                5, 1, 1, '222.123.123.123');
    
-- 6. dto 가져오기
SELECT * FROM FILEBOARD WHERE fID = 3;

-- 6. 글 상세보기
SELECT * FROM FILEBOARD WHERE fID = 3;
SELECT F.*, mNAME, mEMAIL FROM FILEBOARD F, MEMBER M WHERE F.mID=M.mID AND fID=2;

-- 7. 조회수 올리기
UPDATE FILEBOARD SET fHIT = fHIT+1 WHERE fID = 2;

-- 8. 글 수정하기
UPDATE FILEBOARD SET fTITLE='AAA',
                    fCONTENT='AAA',
                    fFILENAME='AAA.PNG',
                    fIP='123.123.123.123'
                WHERE fID=2;
                
-- 9. 글 삭제하기
DELETE FROM FILEBOARD WHERE fID=2;



COMMIT;




-- 관리자 테이블 생성
DROP TABLE ADMIN;
CREATE TABLE ADMIN(
    aID VARCHAR2(30) PRIMARY KEY,
    aPW VARCHAR2(30),
    aNAME VARCHAR2(30)
);



