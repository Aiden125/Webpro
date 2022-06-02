-- [VII] DDL, DML, DCL
-- SQL = DDL(테이블 생성, 테이블 삭제, 테이블구조변경, 테이블 모든 데이터 제거)
--       DML(검색=SELECT, 추가=INSERT, 수정=UPDATE, 삭제=DELETE)
--       DCL(사용자계정생성, 사용자권한부여, 권한박탈, 사용자계정삭제, 트랜잭션 명령어=ROLLBACK,COMMIT


-- ★ ★ ★ DDL ★ ★ ★
-- 1. 테이블 생성 (CREATE TABLE)
CREATE TABLE BOOK(
-- ①PRIMARY KEY 즉, 제약조건을 밑에 따로 선언한 것
    BOOKID NUMBER(4), -- BOOKIB는 숫자 4자리까지로 하겠다
    BOOKNAME VARCHAR2(300), -- BOOKNAME은 300바이트까지로 하겠다
    PUBLISHER VARCHAR2(300), -- 출판사 필드 300바이트까지
    RDATE DATE, -- 출판일 RDATE 필드는 DATE형
    PRICE NUMBER(8), -- 가격 PRICE 필드는 숫자 8자리
    PRIMARY KEY(BOOKID) ); -- 테이블 내 주키(PRIMARY KEY) 설정(NOT NULL, 유일한 값 입력)

SELECT * FROM BOOK;
DROP TABLE BOOK;
-- ②PRIMARY KEY 즉, 제약조건을 바로 선언한 것
CREATE TABLE book (
    bookid NUMBER(4) PRIMARY KEY,
    BOOKNAME VARCHAR2(20),
    PUBLISHER VARCHAR2(20),
    RDATE DATE,
    PRICE NUMBER(8) );

--VARCHAR2는 유동적으로 쓴만큼 데이터를 잡고, CHAR는 일단 명령한 바이트를 잡아버림
--EX. 전자는 2000으로 설정해놓고 실제로 30만 쓰게되면 30으로 먹지만 CHAR는 2000 다 잡아먹음

SELECT * FROM BOOK;
DESC EMP;

-- ROWNUM
-- 테이블에서 읽어들인 논리적 순서
SELECT ROWNUM, EMPNO, ENAME FROM EMP;
SELECT ROWNUM, EMPNO, ENAME FROM EMP WHERE DEPTNO=20 ORDER BY ENAME;

-- EMP 테이블과 유사한 EMP01 : EMPNO(숫자4), ENAME(문자20), SAL(숫자7,2)
CREATE TABLE EMP01(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(20),
    SAL NUMBER(7,2));
DESC EMP01;

-- DDEPT와 유사한 DETP01 : DNAMDE(숫자2, PRK), DMMAE(문자14), LOC(문자13)
CREATE TABLE DEPT01 (
    DEPTNO NUMBER(2),
    DNAME VARCHAR2(14),
    LOC VARCHAR2(13),
    PRIMARY KEY(DEPTNO));
DROP TABLE DEPT01;
DESC DEPT01;
ROLLBACK;


SELECT * FROM TAB; -- SCOTT이 생성한 테이블 LIST


-- 서브쿼리를 이용한 테이블 생성
CREATE TABLE EMP02 AS SELECT * FROM EMP; -- 서브쿼리 결과만 EMP02테이블 생성 후 들어감(제약조건은 미포함)
SELECT * FROM EMP02;
DESC EMP02; --제약조건 미포함

    -- EX. EMP03 : EMP 테이블에서 EMPNO, ENAME, DEPTNO만 추출한 데이터로 테이블 생성
CREATE TABLE EMP03
    AS
    SELECT EMPNO, ENAME, DEPTNO FROM EMP;
SELECT * FROM EMP03;

    -- EX. EMP04 : EMP테이블에서 10번 부서만 추출한 데이터로 테이블
CREATE TABLE EMP04
    AS
    SELECT * FROM EMP
    WHERE DEPTNO=10;
SELECT * FROM EMP04;


    -- EX. EMP05 : EMP 테이블 구조(필드와 그의 타입)만 추출
    -- 절대 참일 수 없는 문장을 넣기.EX:(WHERE 1=0;)
CREATE TABLE EMP05
    AS
    SELECT * FROM EMP
    WHERE 1=0;
SELECT * FROM EMP05;
DROP TABLE EMP05;
ROLLBACK;


-- 2. 테이블 구조 변경(ALTER TABLE)
-- ALTER TABLE 테이블명 ADD || MODIFY || DROP ~

-- (1) 필드 추가(ADD) : 추가된 필드의 데이터는 NULL
SELECT * FROM EMP03; -- EMPNO, ENAME, DEPTNO
ALTER TABLE EMP03 ADD (JOB VARCHAR2(20), SAL NUMBER(7,2));
SELECT * FROM EMP03;
ALTER TABLE EMP03 ADD (COMM NUMBER(7,2));

-- (2) 필드 수정 (MODIFY)
-- 기존데이터의 타입을 바꾸지는 못함
SELECT * FROM EMP03; -- EMPNO(숫4), ENAME(문10), DEPTNO(숫2) / JOB(문20), SAL(숫7,2), COMM(숫7,2) 데이터는 NULL
ALTER TABLE EMP03 MODIFY (EMPNO VARCHAR2(4)); -- 이미 숫자데이터가 들어있어서 문자로 변경 불가
ALTER TABLE EMP03 MODIFY (EMPNO NUMBER(5)); -- 이미 4자리가 들어있어 큰 숫자인 5는 가능하지만 현재 가장 큰 데이터보다 작은 숫자는 안됨(데이터 손실 가능성 때문에)
ALTER TABLE EMP03 MODIFY (ENAME NUMBER(4)); -- 문자 데이터가 들어 있는 상태에서는 문자로만 변경 가능
SELECT MAX(LENGTH(ENAME)) FROM EMP;
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(3000));
DESC EMP03;
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(6));
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(5)); -- 불가능 (6BYTE 글자 데이터가 있어서)
ALTER TABLE EMP03 MODIFY (JOB VARCHAR2(2)); -- 데이터가 없어서 자유롭게 바뀜
ALTER TABLE EMP03 MODIFY (JOB NUMBER(4)); -- 데이터가 없어서 자유롭게 바뀜

-- (3) 필드 삭제 (DROP)
ALTER TABLE EMP03 DROP COLUMN JOB;
SELECT * FROM EMP03;

-- 논리적으로 특정 필드를 접근 못하도록 (낮)
ALTER TABLE EMP03 SET UNUSED (DEPTNO);
SELECT * FROM EMP03;

-- 논리적으로 접근 불가했던 필드를 물리적으로 삭제(새벽)
ALTER TABLE EMP03 DROP UNUSED COLUMNS;
SELECT * FROM EMP03;



-- 3. 테이블 삭제 (DROP TABLE)
DROP TABLE EMP01;
DROP TABLE DEPT; -- 다른 테이블에서 참조하는 데이터가 있을 경우 DROP만으로는 DROP 불가



-- 4. 테이블 모든 행을 제거(TRUNCATE)
SELECT * FROM EMP03;
TRUNCATE TABLE EMP03; -- EMP03안의 데이터 제거(취소 불가)
SELECT * FROM EMP03;



-- 5. 테이블명 변경(RENAME : 원이름 TO 새이름)
SELECT * FROM EMP02;
RENAME EMP02 TO EMP2;
SELECT * FROM EMP2;


-- 6. 데이터 딕셔너리(접근 불가) VS. 데이터 딕셔너리 뷰(사용자 접근용)
-- 종류
-- USER_XXX : 현 계정이 소유하고 있는 객체(테이블, 인덱스, 제약조건, 뷰 등)
    -- EX. USER_TABLES, USER_INDEXES, USER_CONSTRAINTS, USER_VIEWS
-- ALL_XXX : 현 계정이 접근 가능한 객체(테이블, 인덱스, 제약조건, 뷰)
    -- EX. ALL_TABLES, ALL_INDEXES, ALL_CONSTRAINTS, ALL_VIEWS
-- DBA_XXX : DBA권한자만 접근가능. DBMS의 모든 객체
    -- EX. DBA_TABLES, DBA_INDEXES, DBA_CONSTRAINTS, DBA_VIEWS
SELECT * FROM ALL_TABLES;
SELECT * FROM ALL_INDEXES;
SELECT * FROM ALL_CONSTRAINTS;
SELECT * FROM ALL_VIEWS;

SELECT * FROM DBA_TABLES;
SELECT * FROM DBA_INDEXES;
SELECT * FROM DBA_CONSTRAINTS;
SELECT * FROM DBA_VIEWS;

SELECT * FROM USER_TABLES; -- 내 계정이 소유한 테이블 객체정보
SELECT * FROM USER_INDEXES; -- 내 계정이 소유한 인덱스 정보
SELECT * FROM USER_CONSTRAINTS; -- 내 계정이 소유한 제약조건들
SELECT * FROM USER_VIEWS; -- 내 계정이 소유한 뷰 정보


-- ★ ★ ★ DCL(사용자계정생성, 사용자권한부여, 권한박탈, 사용자계정삭제) ★ ★ ★
CREATE USER scott2 IDENTIFIED BY 1234; -- scott2 계정 생성
-- 권한부여(세션권한, scott.EMP, scott.DEPT 테이블에 대한 모든 권한 부여)
GRANT CREATE SESSION TO scott2;
GRANT ALL ON EMP TO scott2; -- EMP 테이블에 대한 모든 권한(검색, 추가, 수정, 삭제)
GRANT ALL ON DEPT TO scott2;
show user;

--권한 박탈 (권한박탈할 사용자계정이 접속해제)
REVOKE ALL ON EMP FROM scott2; --scott2의 EMP 테이블에 대한 모든 권한 박탈
REVOKE ALL ON DEPT FROM scott2; --scott2의 DEPT 테이블에 대한 모든 권한 박탈
SHOW USER;
-- 사용자 계정 삭제(접속 중인 계정 삭제불가)
DROP USER scott2 CASCADE;



-- ★ ★ ★ DML(SELECT, INSERT, UPDATE, DELETE) ★ ★ ★
-- 1. INSERT INTO 테이블명 VALUES (값1, 값2, 값3,...);
--    INSERT INTO 테이블명 (필드명1, 필드명2,..) VALUES (값1, 값2,...);
ALTER TABLE DEPT01 RENAME COLUMN DNNAME TO DNAME;
SELECT * FROM DEPT01;
INSERT INTO DEPT01 VALUES (50,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT01 (DEPTNO,DNAME,LOC) VALUES (60,'IT','SEOUL');
INSERT INTO DEPT01 (DEPTNO, DNAME) VALUES(70, 'OPERATION'); --묵시적으로 LOC에 NULL로 추가
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES (80,'HR',NULL); --명시적으로 NULL 추가
INSERT INTO DEPT01 VALUES (90, 'SALES', NULL); --명시적으로 NULL 추가
-- 서브쿼리를 이용한 INSERT
INSERT INTO DEPT01 SELECT * FROM DEPT;
-- 트랜잭션 명령어(DML 명령어만)
COMMIT;









-- 연습문제 2
CREATE TABLE SAM01(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10),
    JOB VARCHAR2(9),
    SAL NUMBER(7,2),
    CONSTRAINTS SAM_PK PRIMARY KEY(EMPNO)); --제약조건은 앞에다 이름 선언 CONSTRAINTS 활용


TRUNCATE TABLE SAM01;
DROP TABLE SAM01;
SELECT * FROM SAM01;
SELECT * FROM USER_CONSTRAINTS; --제약조건 확인하는 법


INSERT INTO SAM01 VALUES(1000, 'APPLE', 'POLICE', 10000);
INSERT INTO SAM01 VALUES(1010, 'BANANA', 'NURSE', 15000);
INSERT INTO SAM01 VALUES(1020, 'ORANGE', 'DOCTOR', 25000);
INSERT INTO SAM01 VALUES(1030, 'VERY', NULL, 25000);
INSERT INTO SAM01 VALUES(1040, 'CAT', NULL, 2000);
INSERT INTO SAM01 SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE DEPTNO=10;

-- 트랜잭션 명령어
COMMIT;

CREATE TABLE BOOK(
-- ①PRIMARY KEY 즉, 제약조건을 밑에 따로 선언한 것
    BOOKID NUMBER(4), -- BOOKIB는 숫자 4자리까지로 하겠다
    BOOKNAME VARCHAR2(300), -- BOOKNAME은 300바이트까지로 하겠다
    PUBLISHER VARCHAR2(300), -- 출판사 필드 300바이트까지
    RDATE DATE, -- 출판일 RDATE 필드는 DATE형
    PRICE NUMBER(8), -- 가격 PRICE 필드는 숫자 8자리
    PRIMARY KEY(BOOKID) ); -- 테이블 내 주키(PRIMARY KEY) 설정(NOT NULL, 유일한 값 입력)





-- 2. UPDATE 테이블명 SET 필드명1=값1 [, 필드명2=값,....][WHERE 조건];
SELECT * FROM EMP01;
CREATE TABLE EMP01 AS SELECT * FROM EMP; -- 테이블 복사해오기

-- EMP01테이블의 부서번호를 30으로 수정(WHERE 절 없이는 모든 행이 수정됨)
UPDATE EMP01 SET DEPTNO=30;
ROLLBACK;
SELECT * FROM EMP01;

-- EMP01 테이블의 모든 사원 급여를 10%인상
UPDATE EMP01
    SET SAL=SAL*1.1;
SELECT * FROM EMP01;

-- 10번 부서 직원의 입사일을 오늘로, 부서번호는 30번으로 수정
UPDATE EMP01
    SET HIREDATE = SYSDATE,
        DEPTNO = 30
    WHERE DEPTNO = 10;
SELECT * FROM EMP01;

-- SAL이 3000이상인 직원만 급여를 10% 인상
UPDATE EMP01 SET SAL=SAL*1.1 WHERE SAL>=3000;


-- 'DALLAS'에 근무하는 직원의 급여를 1000$씩 인상(서브쿼리 인상)
UPDATE EMP01 SET SAL=SAL+1000
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS');
SELECT * FROM EMP01;


-- 'SCOTT'의 부서번호를 20으로, JOB을 MANAGR로, SAR과 COMM을 500씩 인상, 상사를 KING으로 수정
UPDATE EMP01
    SET DEPTNO=20,
        JOB = 'MANAGER',
        SAL = SAL+500,
        COMM = NVL(COMM,0)+500,
        MGR = (SELECT EMPNO FROM EMP WHERE ENAME='KING')
    WHERE ENAME='SCOTT';
SELECT * FROM EMP01 WHERE ENAME='SCOTT';
SELECT * FROM EMP01;


-- DEPT01에서 20부터의 지역명을 DEPT테이블에 60번 지역명으로 변경
SELECT * FROM DEPT01;
UPDATE DEPT01 SET LOC=(SELECT LOC FROM DEPT WHERE DEPTNO=60)
    WHERE DEPTNO>=20; -- DEPT테이블의 60번부서가 없어서 NULL값으로 수정
SELECT * FROM DEPT01;


-- EMP01테이블의 모든 사원의 급여와 입사일을 'KING'의 급여와 입사일로 수정
COMMIT;
ROLLBACK;
SELECT * FROM EMP01;
-- 방법1
UPDATE EMP01
    SET SAL = (SELECT SAL FROM EMP WHERE ENAME='KING'),
        HIREDATE = (SELECT HIREDATE FROM EMP WHERE ENAME='KING');
-- 방법2 - 간편한 방법
UPDATE EMP01
    SET (SAL, HIREDATE) = (SELECT SAL, HIREDATE FROM EMP WHERE ENAME='KING');


-- DEPT01 테이블의 20번 부서의 지역명과 부서명을 40번 부서의 지역명과 부서명으로 변경
UPDATE DEPT01
    SET (DNAME, LOC) = (SELECT DNAME, LOC FROM DEPT01 WHERE DEPTNO=40)
    WHERE DEPTNO=20;
SELECT * FROM DEPT01;
COMMIT;
ROLLBACK;



-- 3. DELETE FROM 테이블명 WHERE 조건;
SELECT * FROM EMP01;
DELETE FROM EMP01; -- WEHRE절을 안 쓸경우 전체행이 모두 삭제(취소 가능)


-- EMP01테이블에서 'FORD'인 사원을 삭제
DELETE FROM EMP01 WHERE ENAME='FORD';
SELECT * FROM EMP01;


-- EMP01 테이블에서 30번 부서 직원을 삭제
DELETE FROM EMP01 WHERE DEPTNO=30;
SELECT * FROM EMP01;


-- EMP01테이블에서 부서명이 RESEARCH부서의 직원을 삭제
DELETE FROM EMP01 WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE DNAME='RESEARCH');
SELECT * FROM EMP01;


-- SAM01 테이블에서 JOB이 정해지지 않은 사원을 삭제
SELECT * FROM SAM01;
DELETE FROM SAM01 WHERE JOB IS NULL;


-- SAM01테이블에서 ENAME이 ORANGE인 사원을 삭제
DELETE FROM SAM01 WHERE ENAME=(SELECT ENAME FROM SAM01 WHERE ENAME='ORANGE');
SELECT * FROM SAM01;
COMMIT;



-- 연습문제 1

-- 테이블 생성
CREATE TABLE MY_DATA(
    ID NUMBER(4),
    NAME VARCHAR2(10),
    USERID VARCHAR2(30),
    SALARY NUMBER(10,2),
    PRIMARY KEY(ID) );
SELECT * FROM MY_DATA;
-- 인서트
INSERT INTO MY_DATA VALUES(1,'Scott','sscott',10000);
INSERT INTO MY_DATA VALUES(2,'Ford','fford',13000);
INSERT INTO MY_DATA VALUES(3,'Patel','ppatel',33000);
INSERT INTO MY_DATA VALUES(4,'Report','rreport',23500);
INSERT INTO MY_DATA VALUES(5,'Good','ggood',44450);
-- TO_CHAR
SELECT ID, NAME, USERID, TO_CHAR(SALARY,'99,999.00') "number"
    FROM MY_DATA;
-- COMMIT
COMMIT;
-- 넘버3번 급여 65000으로 변경
UPDATE MY_DATA SET SALARY='65000' WHERE ID=3;
COMMIT;
-- FORD 삭제
DELETE FROM MY_DATA WHERE NAME='Ford';
COMMIT;
-- 샐러리 15000이하인 사람 15000으로 변경
UPDATE MY_DATA SET SALARY='15000' WHERE SALARY<15000;
COMMIT;
-- 테이블 삭제
DROP TABLE MY_DATA;






-- ★ ★ ★ 제약조건 : 부적합한 데이터가 테이블에 삽입, 수정되는 것을 방지하기 위해
SELECT * FROM EMP;
INSET INTO EMP VALUES(7369, '홍', NULL, NULL, SYSDATE, NULL, NULL, 40); --SMITH 사번과 중복 에러
UPDATE EMP SET EMPNO=7369 WHERE ENAME='ALLEN'--SMITH 사번과 중복 에러

-- (1) ★PRIMARY KEY★ : 유일하게 테이블의 각 행을 식별. 해당 필드는 NULL 값 허용 안됨
    INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES(7369, '홍', 40); -- 중복된 사번 입력 불가
-- (2) NOT NULL : NULL값만 아니면 됨(필수항목으로 지정)
-- (3) UNIQUE : 모든 행에 대해 유일(UNLL값은 허용, NULL은 여러개 넣어도 됨)
-- (4) ★FOREIGN KEY★ : 테이블의 열은 다른 테이블의 열을 참조(EX. EMP테이블의 DEPTNO는 DEPT 테이블의 DEPTNO를 참조)
    -- 비식별관계 : 부모테이블의 주키가 자식테이블의 일반속성에 속한 필드로 관계 (exERD에서 빨간점선화살표)
    -- 식별관계 : 부모테이블의 주키가 자식테이블의 주키(주키군)에 속한 필드로 관계 (exERD에서 초록점선화살표)
    INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES(1111, '차', 90); -- 외래키로 90번 입력불가(고유키에 없는 값)
-- (5) CHECK(조건) : 해당 조건이 만족(NULL값 허용)
-- (기타) ★DEFALUT★ : 해당 열의 데이터 입력값이 없으면 원래는 NULL이 들어가나 기본값 설정시 기본값으로 들어감(엄밀히 따지면 제약조건은 아닌 항목)
DROP TABLE DEPT1;
CREATE TABLE DEPT1(
    DEPTNO NUMBER(2) PRIMARY KEY,
    DNAME VARCHAR2(14) UNIQUE,
    LOC VARCHAR2(14) NOT NULL );
DROP TABLE EMP1;
CREATE TABLE EMP1(
    EMPNO NUMBER(4) PRIMARY KEY,
    ENAME VARCHAR2(10) NOT NULL,
    JOB VARCHAR2(9),
    MGR NUMBER(4),
    HIREDATE DATE DEFAULT SYSDATE,
    SAL NUMBER(7,2) CHECK(SAL>0),
    COMM NUMBER(7,2),
    DEPTNO NUMBER(2) REFERENCES DEPT1(DEPTNO));
DROP TABLE EMP1; -- 자식테이블(참조하는 테이블) 먼저 DROP
DROP TABLE DEPT1; -- 다른 테이블에서 참조하는 필드가 있을  DROP불가
DROP TABLE DEPT1 CASCADE CONSTRAINTS; -- 비추 (참조하는 테이블이 있어도 무시하고 DROP)


CREATE TABLE DEPT1(
    DEPTNO NUMBER(2),
    DNAME VARCHAR2(14),
    LOC VARCHAR2(13) NOT NULL,
    PRIMARY KEY(DEPTNO),
    UNIQUE(DNAME) );

CREATE TABLE EMP1(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10) NOT NULL,
    JOB VARCHAR2(9),
    MGR NUMBER(4),
    HIREDATE DATE DEFAULT SYSDATE,
    SAL NUMBER(7,2),
    COMM NUMBER(7,2),
    DEPTNO NUMBER(2),
    PRIMARY KEY(EMPNO),
    CHECK(SAL>0),
    FOREIGN KEY(DEPTNO) REFERENCES DEPT1(DEPTNO));

INSERT INTO DEPT1 SELECT * FROM DEPT;
SELECT * FROM DEPT1;
INSERT INTO DEPT1 VALUES (40, 'IT', 'SEOUL'); -- PK제약조건 위배(고유키)
INSERT INTO DEPT1 VALUES (50, 'SALES', 'SEOUL'); -- UNIQUE제약조건 위배
INSERT INTO DEPT1 VALUES (50, 'IT', 'NULL'); --NOT NULL제약 위배

INSERT INTO EMP1 (EMPNO, ENAME, DEPTNO)
    VALUES (1001, '홍', 10);
SELECT * FROM EMP1; -- HIREDATE에 설정된 기본값 입력
INSERT INTO EMP1 (EMPNO, ENAME, DEPTNO)
    VALUES (1001, '김', 10) -- PK 위배
INSERT INTO EMP1 (EMPNO, DEPTNO)
    VALUES (1002, 20); -- ENAME의 NOT NULL 위배
INSERT INTO EMP1( EMPNO, ENAME, SAL)
    VALUES (1002, '박', -1); --SAL>0 위배
INSERT INTO EMP1 VALUES(1002,'윤',NULL,NULL,TO_DATE('95/12/12', 'YY/MM/DD'), 900,NULL,99); -- FOREIGN키 위배

DROP TABLE EMP1;
DROP TABLE DEPT1;


-- 연습문제(pdf4, 5page)