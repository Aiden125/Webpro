-- DROP & CREATE

DROP TABLE MVC_MEMBER;
CREATE TABLE MVC_MEMBER(
    mID VARCHAR2(30) PRIMARY KEY,
    mPW VARCHAR2(30) NOT NULL,
    mNAME VARCHAR2(30) NOT NULL,
    mEMAIL VARCHAR2(30),
    mPHOTO VARCHAR2(30) NOT NULL, -- 사진업로드 안할시 기본이미지로 할 예정
    mBIRTH DATE,
    mADDRESS VARCHAR2(300),
    mRDATE DATE DEFAULT SYSDATE NOT NULL
);

-- DUMMY DATA
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('gayun','1','김가연','gayun@naver.com','gayun.jpg','1972/09/09','광주광역시');
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('gico','1','지코','gico@naver.com','gico.jpg','1992/09/14','서울시');
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('go','1','고소영','go@naver.com','go.jpg','1972/10/06','서울시');
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('ham','1','함소원','ham@naver.com','ham.jpg','1976/06/16','서울시');
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('han','1','한지민','han@naver.com','han.jpg','1982/11/05','서울시');

-- 1. 로그인
SELECT * FROM MVC_MEMBER WHERE mID='111' AND mPW='1234';

-- 2. ID로 DTO 가져오기
SELECT * FROM MVC_MEMBER WHERE mID='111';

-- 3. 로그인 중복체크
SELECT * FROM MVC_MEMBER WHERE mID='111';

-- 4. 회원가입
INSERT INTO MVC_MEMBER(mID, mPW, mNAME, mEMAIL, mPHOTO, mBIRTH, mADDRESS)
    VALUES('bbb', '1234', '홍길둥', 'hong@na.com', NVL('jo.jpg', 'NOIMG.JPG'), '1995-12-12', '서울');

-- 5. 회원정보 수정
UPDATE MVC_MEMBER SET mPW='1234',
                    mNAME='111',
                    mEMAIL='111',
                    mPHOTO='kim.jpg',
                    mBIRTH='1995-12-05',
                    maddress='서울시시'
                WHERE mID='aaa';

-- 6. 회원리스트 보기
SELECT *
    FROM(SELECT ROWNUM RN, A.*
            FROM (SELECT * FROM MVC_MEMBER ORDER BY mID) A)
    WHERE RN BETWEEN 2 AND 3;


-- 7. 회원 수 보기
SELECT COUNT(*) TOTCNT
    FROM MVC_MEMBER;
    









