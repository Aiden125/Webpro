-- 초기화
DROP TABLE CUSTOMER;

-- 테이블 생성
CREATE TABLE CUSTOMER(
    cID VARCHAR2(50) PRIMARY KEY,
    cPW VARCHAR2(50) NOT NULL,
    cNAME VARCHAR2(50) NOT NULL,
    cTEL VARCHAR2(50) NOT NULL,
    cEMAIL VARCHAR2(50),
    cADDRESS VARCHAR2(250),
    cGENDER VARCHAR2(10) NOT NULL,
    cBIRTH DATE NOT NULL,
    cRDATE DATE NOT NULL
);
    

-- 1. 중복확인
SELECT * FROM CUSTOMER WHERE cID='aaa';   


-- 2. 회원가입
INSERT INTO CUSTOMER (cID, cPW, cNAME, cTEL, cEMAIL, cADDRESS, cGENDER, cBIRTH, cRDATE)
    VALUES('gildong', '1234', '홍길동', '010-1234-1234' , 'gildong@gmail.com', '서울 강남구', '남', '1922-12-12', SYSDATE); 

-- 3. 로그인
SELECT cID, cPW FROM CUSTOMER WHERE cID='gildong';

-- 4. 세션 부여할 때
SELECT * FROM CUSTOMER WHERE cID='gildong';

-- 5. 정보수정
UPDATE CUSTOMER SET cPW='111',
                    cNAME='111',
                    cTEL='111',
                    cEMAIL='111',
                    cADDRESS='111',
                    cGENDER='111',
                    cBIRTH='111'
                WHERE cID='111';

COMMIT;
SELECT * FROM CUSTOMER;