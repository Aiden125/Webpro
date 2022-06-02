-- TABLE DROP & CREATE
DROP TABLE MEMBER CASCADE CONSTRAINTS;
CREATE TABLE MEMBER(
    ID VARCHAR2(30) PRIMARY KEY,
    PW VARCHAR2(30) NOT NULL,
    NAME VARCHAR2(30) NOT NULL,
    PHONE1 VARCHAR2(5),
    PHONE2 VARCHAR2(5),
    PHONE3 VARCHAR2(5),
    GENDER VARCHAR2(1),
    EMAIL VARCHAR2(30),
    BIRTH DATE,
    RDATE DATE NOT NULL, --가입일
    ADDRESS VARCHAR2(200)
);
-- 1. 회원가입시 ID중복체크를 위한 SQL : public int confirmId(String id)
SELECT * FROM MEMBER WHERE ID='aaa';

-- 2. 회원가입 : pulbic int joinMember(MemberDto dto)
INSERT INTO MEMBER (ID, PW, NAME, PHONE1, PHONE2, PHONE3, GENDER, EMAIL, BIRTH, RDATE, ADDRESS)
    VALUES('aaa', '111', '홍길동', '02', '1111', '1111', 'm', 'hong@h,com', '1995-12-05', SYSDATE, '서울');
    
-- 3. 로그인(id/pw) : pulblic int loginCheck(String id, String pw)
SELECT ID, PW FROM MEMBER WHERE ID='aaa';

-- 4. ID로 dto가져오기(로그인 성공 되었을 때 할 액션)(dto 자체를 세션에다가) : public MemberDto getMember(String id)
SELECT * FROM MEMBER WHERE ID='aaa';

-- 5. 회원정보 수정
UPDATE MEMBER SET PW='111',
                NAME='신길동',
                PHONE1 = '010',
                PHONE2 = '9999',
                PHONE3 = '8888',
                GENDER = 'm',
                EMAIL = 'hong@aa.com',
                BIRTH = '1995-12-05',
                ADDRESS = '안양'
            WHERE ID='aaa';
SELECT * FROM MEMBER;
commit;






SELECT * FROM MEMBER;