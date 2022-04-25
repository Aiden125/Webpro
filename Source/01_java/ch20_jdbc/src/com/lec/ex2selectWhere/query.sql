-- EX1 사용자에게 부서번호 입력받아 부서 정보 뿌리기
SELECT * FROM DEPT WHERE DEPTNO=30;
INSERT INTO DEPT VALUES(50,'IT','SEOUL');
SELECT * FROM DEPT;
ROLLBACK;

-- EX2 사용자에게 부서번호 받아 정보 뿌리기
-- (1) 부서
SELECT * FROM DEPT WHERE DEPTNO=30;
-- (2) 해당부서번호 사원의 정보(사번, 이름, 급여, 상사명)
SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO AND W.DEPTNO=30;
    
-- EX3 사용자에게 부서명을 받아 정보 뿌리기
-- (1) 부서
SELECT * FROM DEPT WHERE DNAME=UPPER('sales'); -- upper써주면 입력시 소문자로 입력해도 대문자로.
-- (2) 사번, 이름, 급여, 급여등급
SELECT EMPNO, ENAME, SAL, GRADE
    FROM EMP E, SALGRADE, DEPT D
    WHERE SAL BETWEEN LOSAL AND HISAL AND E.DEPTNO=D.DEPTNO
    AND DNAME=UPPER('SALES');
-- (예외) 서브쿼리 버전
SELECT EMPNO, ENAME, SAL, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL AND DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME=UPPER('SALES'));
    
    
--1. 사용자에게 부서명을 받아
--	1-1. 부서존재하는경우 : 부서정보와 사원정보(사원, 이름, 급여, 급여등급)를 출력
--	1-2. 부서존재하지 않는 경우 : 없다고 출력

SELECT DNAME, EMPNO, ENAME, SAL, GRADE
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO
    AND SAL BETWEEN LOSAL AND HISAL
    AND DNAME=UPPER('SALES');
    
    
-- 부서번호를 입력받아 중복체크 확인 후 입력 진행
SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=30;

desc dept;




-- 부서번호가 중복되는지 체크하기. COUNT함수 이용
SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=30;
-- 인서트하기
INSERT INTO DEPT VALUES (50, 'GOODGOOD', 'SEOUL');
SELECT * FROM DEPT;
ROLLBACK;

    
    