--
desc dept;

DELETE FROM DEPT WHERE DEPTNO=88;
ROLLBACK;


-- 사용자로부터 부서명을 입력받아 해당 부서 사원의 사번, 이름, 직책, 급여를 출력하시오
SELECT EMPNO, ENAME, JOB, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND DNAME=UPPER('SALES');
    
SELECT * FROM DEPT;
insert into dept values (61, 50, 50);
commit;