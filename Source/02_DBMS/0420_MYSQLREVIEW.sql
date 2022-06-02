CREATE DATABASE 0420DB;
USE 0420DB;
SELECT DATABASE();


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
    WHERE DNO IN(10,20);
    
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
SELECT W.PNO, W.PNAME, M.PNAME
	FROM PERSONAL W, PERSONAL M
    WHERE W.MANAGER=M.PNO;
    
-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력)

-- 9. 이름이 s로 시작하는 사원 이름
SELECT PNAME
	FROM PERSONAL
    WHERE PNAME LIKE 'S%';
    
-- 10. 사번, 이름, 급여, 부서명, 상사이름
SELECT W.PNO, W.PNAME WORKER, W.PAY, D.DNAME, M.PNAME MANAGER
	FROM PERSONAL W, PERSONAL M, DIVISION D
    WHERE W.MANAGER=M.PNO AND W.DNO=D.DNO;
    
-- 11. 부서코드, 급여합계, 최대급여
SELECT DNO, SUM(PAY), MAX(PAY)
	FROM PERSONAL
    GROUP BY DNO;
    
-- 12. 부서명, 급여평균, 인원수
SELECT DNAME, AVG(PAY), COUNT(*)
	FROM PERSONAL P, DIVISION D
    WHERE P.DNO=D.DNO
    GROUP BY D.DNO;
    
-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
SELECT DNO, SUM(PAY), COUNT(*)
	FROM PERSONAL
    GROUP BY DNO
    HAVING COUNT(*)>=4;
    
-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
SELECT PNO, PNAME, PAY
	FROM PERSONAL
    WHERE PAY = (SELECT MAX(PAY) FROM PERSONAL);
    
-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여, 부서번호
SELECT PNAME, PAY, DNO
	FROM PERSONAL
    WHERE PAY > (SELECT AVG(PAY) FROM PERSONAL);

-- 16. 15번에 부서명을 추가하고 부서명순 정열 같으면 급여 큰순
SELECT PNAME, PAY, P.DNO, DNAME
	FROM PERSONAL P, DIVISION D
    WHERE P.DNO=D.DNO
    AND PAY > (SELECT AVG(PAY) FROM PERSONAL)
    ORDER BY DNAME, PAY DESC;
    
-- 17. 자신이 속한 부서번호 평균보다 많인 받는 사람의 이름, 금여, 부서번호, 반올림한 해당부서평균
SELECT PNAME, PAY, DNO, ROUND((SELECT AVG(PAY) FROM PERSONAL WHERE DNO=P.DNO))
	FROM PERSONAL P
    WHERE PAY > (SELECT AVG(PAY) A FROM PERSONAL WHERE DNO=P.DNO);

-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
SELECT PNAME, PAY, DNAME
	FROM PERSONAL P, DIVISION D
    WHERE P.DNO=D.DNO
    AND STARTDATE = (SELECT MIN(STARTDATE) FROM PERSONAL);

-- 19. 이름, 급여, 해당부서평균
SELECT PNAME, PAY, (SELECT AVG(PAY) FROM PERSONAL WHERE DNO=P.DNO)
	FROM PERSONAL P;
    
-- 20. 이름, 급여, 부서명, 해당부서평균
SELECT PNAME, PAY, DNAME, (SELECT AVG(PAY) FROM PERSONAL WHERE DNO=P.DNO)
	FROM PERSONAL P, DIVISION D
    WHERE P.DNO=D.DNO;
    
    


-- 1. 사번, 이름, 급여를 출력
SELECT PNO, PNAME, PAY FROM PERSONAL;
-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
SELECT * FROM PERSONAL WHERE PAY BETWEEN 2000 AND 5000;
-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
SELECT PNO, PNAME, DNO FROM PERSONAL WHERE DNO=10 OR DNO=20;
-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
SELECT PNO, PNAME, PAY FROM PERSONAL WHERE BONUS IS NULL ORDER BY PAY DESC;
-- 5. 사번, 이름, 부서번호, 급여. 부서코드 순 정렬 같으면 PAY 큰순

-- 6. 사번, 이름, 부서명

-- 7. 사번, 이름, 상사이름

-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력)

-- 9. 이름이 s로 시작하는 사원 이름
WHERE PNAME LIKE  'S%';
-- E-QUIT
-- 10. 사번, 이름, 급여, 부서명
SELECT PNO, PNAME, PAY, DNAME
	FROM PERSONAL P, DIVISION D
    WHERE P.DNO=D.DNO;
    
-- 10. 사번, 이름, 급여, 상사명, 상사의상사
SELECT W.PNO, W.PNAME, W.PAY, M.PNAME , K.PNAME
	FROM PERSONAL W, PERSONAL M, PERSONAL K
    WHERE W.MANAGER=M.PNO AND M.MANAGER=K.PNO;

-- 10. 사번, 이름, 급여, 부서명, 상사명
SELECT W.PNO, W.PNAME,W.PAY, DNAME, M.PNAME
	FROM PERSONAL W, DIVISION D, PERSONAL M
    WHERE W.DNO=D.DNO AND W.MANAGER=M.PNO;




SELECT * FROM PERSONAL;

-- 11. 부서코드, 급여합계, 최대급여

-- 12. 부서명, 급여평균, 인원수

-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
SELECT DNO, SUM(PAY), COUNT(*) FROM PERSONAL
	GROUP BY DNO
    HAVING COUNT(*)>=4;
-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
SELECT PNO, PNAME, PAY FROM PERSONAL
	WHERE PAY = (SELECT MAX(PAY) FROM PERSONAL); 
-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여, 부서번호

-- 16. 15번에 부서명을 추가하고 부서명순 정열 같으면 급여 큰순

-- 17. 자신이 속한 부서의 평균보다 많인 받는 사람의 이름, 금여, 부서번호, 반올림한 해당부서평균
SELECT AVG(PAY) FROM PERSONAL WHERE;

SELECT PNAME, PAY, DNO, ROUND((SELECT AVG(PAY) FROM PERSONAL WHERE DNO=P.DNO))
	FROM PERSONAL P
    WHERE PAY > (SELECT AVG(PAY) FROM PERSONAL WHERE DNO=P.DNO);
    
-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명

-- 19. 이름, 급여, 해당부서평균

-- 20. 이름, 급여, 부서명, 해당부서평균