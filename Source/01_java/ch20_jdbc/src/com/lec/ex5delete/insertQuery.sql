--
desc dept;

DELETE FROM DEPT WHERE DEPTNO=88;
ROLLBACK;


-- ����ڷκ��� �μ����� �Է¹޾� �ش� �μ� ����� ���, �̸�, ��å, �޿��� ����Ͻÿ�
SELECT EMPNO, ENAME, JOB, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND DNAME=UPPER('SALES');
    
SELECT * FROM DEPT;
insert into dept values (61, 50, 50);
commit;