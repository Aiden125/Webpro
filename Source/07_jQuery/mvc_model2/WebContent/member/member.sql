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

COMMIT;



