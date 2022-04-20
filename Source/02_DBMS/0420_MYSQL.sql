-- DCL (계정생성, 권한부여, 권한박탈, 계정삭제)
-- DDL (제약조건)(시퀀스는 없음)
-- DML (OUTER JOIN, AND=&&, OR=||, 일부단일행함수)

show databases; -- database 리스트 보기
-- ★ ★ ★ DCL(계정생성, 권한부여, 권한박탈, 계정제거)
create user user01 identified by 'password'; -- 계정생성
grant all on *.* to user01; -- 권한부여
revoke all on *.* from user01; -- 권한박탈. 오류뜨는건 상관없음
drop user user01;
-- 데이터베이스로 들어감
SHOW DATABASES;
create database MOONDB; -- 새로운 MOONDB 데이터베이스 생성
USE MOONDB; -- MOONDB 데이터베이스로 들어감
SELECT DATABASE(); -- 현재 들어와있는 데이터베이스
USE WORLD; -- WORLD 데이터베이스 영역으로 들어감
USE MOONDB; -- 다시 MOONDB로 들어가기
SHOW TABLES; -- 오라클의 SELECT * FROM TAB; 와 같음

-- ★ ★ ★ DDL(테이블 생성, 제약조건)(시퀀스는 없음)
CREATE TABLE EMP(
	EMPNO numeric(4) PRIMARY KEY, -- NUMERIC -> NUMBER와 동일
    ENAME VARCHAR(20) NOT NULL,
    NICKNAME VARCHAR(20) UNIQUE,
    SAL NUMERIC(7,2) CHECK(SAL>0),
    HIREDATE DATETIME DEFAULT NOW(),
    COMM NUMERIC(7,2) DEFAULT 0
);
SELECT * FROM EMP;
DROP TABLE IF exists EMP;

-- MAJOR (MCODE(시퀀스같은 순차번호):PK, MNAME, MOFFICE)
-- STUDEN (SNO:PK, SNAME, MCODE)
CREATE TABLE MAJOR(
	MCODE INT PRIMARY KEY auto_increment, -- 시퀀스 대신 하는 역할 AUTO_INCREMENT의 경우 무조건INT 형식으로
    MNAME VARCHAR(20),
    MOFFICE VARCHAR(50)
);
CREATE TABLE STUDENT(
	SNO INT PRIMARY KEY,
    SNAME VARCHAR(20),
    MCODE INT references MAJOR(MCODE)
);
INSERT INTO MAJOR(MNAME, MOFFICE) VALUES('컴공','402호');
INSERT INTO MAJOR(MNAME, MOFFICE) VALUES('경영','502호');
INSERT INTO MAJOR(MNAME, MOFFICE) VALUES('경제','301호');
SELECT * FROM MAJOR;
INSERT INTO STUDENT VALUES(1111,'홍',1);
INSERT INTO STUDENT VALUES(2222,'이',2);
INSERT INTO STUDENT VALUES(3333,'삵',3);
INSERT INTO STUDENT VALUES(4444,'밞',4);
SELECT * FROM STUDENT;

DROP TABLE MAJOR;
DROP TABLE STUDENT;
CREATE TABLE MAJOR(
	MCODE INT AUTO_INCREMENT,
    MNAME VARCHAR(30) NOT NULL,
    MOFFICE  VARCHAR(30),
    PRIMARY KEY(MCODE) );

CREATE TABLE STUDENT(
	SNO INT,
    SNAME VARCHAR(30),
    MCODE INT,
    PRIMARY KEY(SNO),
    FOREIGN KEY(MCODE) REFERENCES MAJOR(MCODE) );
    
INSERT INTO MAJOR(MNAME, MOFFICE) VALUES('컴공','402호');
INSERT INTO MAJOR(MNAME, MOFFICE) VALUES('경영','502호');
INSERT INTO MAJOR(MNAME, MOFFICE) VALUES('경제','301호');
SELECT * FROM MAJOR;
INSERT INTO STUDENT VALUES(1111,'홍',1);
INSERT INTO STUDENT VALUES(2222,'이',2);
INSERT INTO STUDENT VALUES(3333,'삵',3);
INSERT INTO STUDENT VALUES(4444,'밞',4);
SELECT * FROM STUDENT;

-- 학번, 이름, 학과코드, 학과명, 사무실
SELECT SNO, SNAME, S.MCODE, MNAME, MOFFICE
	FROM STUDENT S, MAJOR M
    WHERE S.MCODE=M.MCODE;
    
-- 자바(JDBC) 수업시간에 쓸 테이블
DROP TABLE IF exists PERSONAL; -- EMP 테이블과 유사
DROP TABLE IF exists DIVISION; -- DEPT 테이블과 유사
CREATE TABLE DIVISION(
	DNO INT,	-- 부서번호
    DNAME VARCHAR(20), -- 부서이름
    PHONE VARCHAR(20), -- 부서전화
    POSITION VARCHAR(20), -- 부서위치
    PRIMARY KEY(DNO) );
INSERT INTO DIVISION VALUES(10, 'FINANCE', '02-111-2222', '강남');
INSERT INTO DIVISION VALUES(20, 'RESEARCH', '02-777-6666', '회현');
INSERT INTO DIVISION VALUES(30, 'SALES', '02-133-3333', '서초');
INSERT INTO DIVISION VALUES(40, 'MAKETING', '02-999-9999', '역삼');
SELECT * FROM DIVISION;

DROP TABLE PERSONAL;
create table PERSONAL(
	PNO INT, -- 사번
    PNAME VARCHAR(20) NOT NULL, -- 사원명
    JOB VARCHAR(20) NOT NULL, -- 직책
    MANAGER INT, -- 상사의 사번
    STARTDATE DATE, -- 입사일
    PAY INT, -- 급여
    BONUS INT, -- 상여
    DNO INT, -- 부서번호
	PRIMARY KEY(PNO),
    FOREIGN KEY(DNO) REFERENCES DIVISION(DNO)
 );   
 
insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);
COMMIT;
SELECT * FROM DIVISION;
SELECT * FROM PERSONAL;   


-- ★ ★ ★ DML(OUTER JOIN, 단일행함수 일부, TOP-N구문, AND=&&, OR=||, 연결연산자가 없기에 CONCAT쓰기) 그 외 FOREIGN키 밑에 선언하기 
-- 1. 사번, 이름, 급여를 출력
SELECT PNO, PNAME, PAY
	FROM PERSONAL;
    
-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
SELECT *
	FROM PERSONAL
    WHERE PAY BETWEEN 2000 AND 5000;

-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
SELECT PNO, PNAME, DNO
	FROM PERSONAL
    WHERE DNO IN (10, 20);

-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
SELECT PNO, PNAME, PAY
	FROM PERSONAL
    WHERE BONUS IS NULL
    ORDER BY PAY DESC;

-- 5. 사번, 이름, 부서번호, 급여. 부서번호 순 정렬 같으면 PAY 큰순
SELECT PNO, PNAME, DNO, PAY
	FROM PERSONAL
    ORDER BY DNO, PAY DESC;

-- 6. 사번, 이름, 부서명
SELECT PNO, PNAME, DNAME
	FROM PERSONAL P, DIVISION D
    WHERE P.DNO=D.DNO;
    
-- 7. 사번, 이름, 상사이름
SELECT W.PNO, W.PNAME WORKER, M.PNAME MANAGER
	FROM PERSONAL W, PERSONAL M
    WHERE W.MANAGER=M.PNO;
    
-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력, 상사가 없으면 NULL 대신 'CEO')
-- NVL 대신 IFNULL, OUTER JOIN은 LEFT OUTER JOIN 혹은 RIGHT OUTER JOIN ~ ON
SELECT W.PNO, W.PNAME, ifnull(M.PNAME, 'CEO')
	FROM PERSONAL W LEFT OUTER JOIN PERSONAL M
    ON W.MANAGER=M.PNO; -- LEFT OUTTER JOIN(왼쪽애 위주로 하겠다)
    
    SELECT W.PNO, W.PNAME, if(M.PNAME IS NULL, 'CEO', M.PNAME)
	FROM PERSONAL W LEFT OUTER JOIN PERSONAL M
    ON W.MANAGER=M.PNO; -- LEFT OUTTER JOIN(왼쪽애 위주로 하겠다)

-- 9. 이름이 s로 시작하는 사원 이름
SELECT PNAME
	FROM PERSONAL
    WHERE PNAME LIKE 'S%';
    -- + SUBSTR, INSTR 써서도 해보기

-- 10. 사번, 이름, 급여, 부서명, 상사이름
SELECT W.PNO, W.PNAME, W.PAY, D.DNAME, M.PNAME
	FROM PERSONAL W, PERSONAL M, DIVISION D
	WHERE W.MANAGER=M.PNO AND W.DNO=D.DNO;

-- 11. 부서코드, 급여합계, 최대급여
SELECT DNO, SUM(PAY), MAX(PAY)
	FROM PERSONAL
    group by DNO;
    
-- 12. 부서명, 급여평균, 인원수
SELECT DNAME, AVG(PAY), COUNT(*)
	FROM PERSONAL P, DIVISION D
    WHERE P.DNO=D.DNO
    group by DNAME;

-- 13. 부서번호, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
SELECT DNO, SUM(PAY), COUNT(*) A
	FROM PERSONAL
    GROUP BY DNO
    HAVING A>=4;
    
-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
SELECT PNO, PNAME, PAY
	FROM PERSONAL
    WHERE PAY = (SELECT MAX(PAY) FROM PERSONAL);
    
-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여, 부서번호
SELECT AVG(PAY) FROM PERSONAL;
SELECT PNAME, PAY, DNO
	FROM PERSONAL
    WHERE PAY > (SELECT AVG(PAY) FROM PERSONAL);

-- 16. 15번에 부서명을 추가하고 부서명순 정열 같으면 급여 큰순
SELECT AVG(PAY) FROM PERSONAL, DIVISION;
SELECT PNAME, PAY, P.DNO
	FROM PERSONAL P , DIVISION D
    WHERE PAY > (SELECT AVG(PAY) FROM PERSONAL)
    AND P.DNO=D.DNO
    ORDER BY DNAME, PAY DESC;

-- 17. 자신이 속한 부서의 평균보다 많인 받는 사람의 이름, 급여, 부서번호, 반올림한 해당부서평균
SELECT PNAME, PAY, DNO, ROUND((SELECT AVG(PAY) "AVG" FROM PERSONAL WHERE DNO=P.DNO)) AVG
	FROM PERSONAL P
    WHERE PAY > (SELECT AVG(PAY) "AVG" FROM PERSONAL WHERE DNO=P.DNO);

-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
SELECT MIN(STARTDATE) FROM PERSONAL;
SELECT PNAME, PAY, DNAME
	FROM PERSONAL P, DIVISION D
    WHERE P.DNO=D.DNO
    AND STARTDATE=(SELECT MIN(STARTDATE) FROM PERSONAL);

-- 19. 이름, 급여, 해당부서평균
SELECT PNAME, PAY,  AVG, P.DNO
	FROM PERSONAL P, (SELECT DNO, AVG(PAY) AVG FROM PERSONAL GROUP BY DNO) A
    WHERE P.DNO=A.DNO;

	-- + SELECT절을 AVG자리에다 넣어서 더 간단하게 만들어보기

-- 20. 이름, 급여, 부서명, 해당부서평균
SELECT PNAME, PAY,  AVG, DNAME
	FROM PERSONAL P, (SELECT DNO, AVG(PAY) AVG FROM PERSONAL GROUP BY DNO) A, DIVISION D
    WHERE P.DNO=A.DNO AND P.DNO=D.DNO;
    
-- Oracle에서 단일행함수와 MYSQL 컬럼함수의 다른 부분alter
SELECT ROUND(789.65, 2); -- MYSQL에선 DUAL없이 FROM절 생략 가능
SELECT PNAME || '은' || JOB || '이다' FROM PERSONAL; -- X
SELECT CONCAT(PNAME, '은', JOB, '이다') FROM PERSONAL;

-- 날짜 관련 컬럼함수 (PERSONAL 테이블의 STARTDATE의 타입 : DATETIME)
-- 날짜 데이터를 뽑으면 시간부터는 0으로 나옴
SELECT YEAR(STARTDATE), MONTH(STARTDATE), DAY(STARTDATE),
HOUR(STARTDATE), MINUTE(STARTDATE), SECOND(STARTDATE) FROM PERSONAL;

	-- DATE_FORMAT(날짜형이나 시간형데이터, '포맷') TO_CHAR 대신
		-- 포맷글자 : %y:22(년도2자리), %Y : 2022(년도 4자리)
        -- %M 4월, %m 04월, %b 짧은월이름, %c 4(월수)
        -- %d 01,02('일'을 두자리로) %e 1,2,3('일'을 간편식으로)
        -- %H 24시간 %h 12시간 %p 오전오후, %i분, %s초

-- 시스템으로부터 현재 날짜와 시간
SELECT SYSDATE();
SELECT NOW();
-- 시스템으로부터 현재 날짜만 가져오기
SELECT current_date();
SELECT CURDATE();
-- 시스템으로부터 현재 시간만 가져오기
SELECT CURRENT_TIME();
SELECT CURTIME();
SELECT DATE_FORMAT(NOW(), '%Y년%m월%e일 %p %h시 %i분');

-- FORMAT(숫자데이터) ; 3자리마다 콤마 추가
-- FORMAT(숫자데이터, 소수점자리수); 소수점 확보되면서 3자리마다 콤마 추가
SELECT FORMAT(PAY, 1) FROM PERSONAL;

-- WORKBENCH에서 데이터 삭제하거나 수정 (WHERE절에 PRIMARY KEY를 이용한 비교)
INSERT INTO PERSONAL (PNO, PNAME, JOB, MANAGER, STARTDATE, PAY, BONUS, DNO)
	VALUES(1000,'HONG','MANAGER',1001,CURDATE(),9000,900,40);
COMMIT;
SET SQL_SAFE_UPDATES = 0; -- 이 구문을 넣어줘야 DELETE가 가능해짐 MYSQL에서만
DELETE FROM PERSONAL WHERE PNAME='HONG';
SELECT * FROM PERSONAL;

-- ★ ★ ★ TOP-N 구문
SELECT ROWNUM, PNO FROM PERSONAL; -- MYSQL은 ROWNUM이 없음
SELECT PNAME, PAY FROM PERSONAL ORDER BY PAY DESC;
-- LIMIT N (1~N등까지)
SELECT PNAME, PAY FROM PERSONAL ORDER BY PAY DESC LIMIT 5;
-- LIMIT 3,3 (4등부터 6등까지)
SELECT PNAME, PAY FROM PERSONAL ORDER BY PAY DESC LIMIT 3,3;
-- LIMIT 5,4 (6등부터 9등까지)
SELECT PNAME, PAY FROM PERSONAL ORDER BY PAY DESC LIMIT 5,4;





