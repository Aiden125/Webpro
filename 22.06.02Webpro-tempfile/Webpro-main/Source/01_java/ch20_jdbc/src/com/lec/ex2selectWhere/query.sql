-- EX1 ����ڿ��� �μ���ȣ �Է¹޾� �μ� ���� �Ѹ���
SELECT * FROM DEPT WHERE DEPTNO=30;
INSERT INTO DEPT VALUES(50,'IT','SEOUL');
SELECT * FROM DEPT;
ROLLBACK;

-- EX2 ����ڿ��� �μ���ȣ �޾� ���� �Ѹ���
-- (1) �μ�
SELECT * FROM DEPT WHERE DEPTNO=30;
-- (2) �ش�μ���ȣ ����� ����(���, �̸�, �޿�, ����)
SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO AND W.DEPTNO=30;
    
-- EX3 ����ڿ��� �μ����� �޾� ���� �Ѹ���
-- (1) �μ�
SELECT * FROM DEPT WHERE DNAME=UPPER('sales'); -- upper���ָ� �Է½� �ҹ��ڷ� �Է��ص� �빮�ڷ�.
-- (2) ���, �̸�, �޿�, �޿����
SELECT EMPNO, ENAME, SAL, GRADE
    FROM EMP E, SALGRADE, DEPT D
    WHERE SAL BETWEEN LOSAL AND HISAL AND E.DEPTNO=D.DEPTNO
    AND DNAME=UPPER('SALES');
-- (����) �������� ����
SELECT EMPNO, ENAME, SAL, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL AND DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME=UPPER('SALES'));
    
    
--1. ����ڿ��� �μ����� �޾�
--	1-1. �μ������ϴ°�� : �μ������� �������(���, �̸�, �޿�, �޿����)�� ���
--	1-2. �μ��������� �ʴ� ��� : ���ٰ� ���

SELECT DNAME, EMPNO, ENAME, SAL, GRADE
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO
    AND SAL BETWEEN LOSAL AND HISAL
    AND DNAME=UPPER('SALES');
    
    
-- �μ���ȣ�� �Է¹޾� �ߺ�üũ Ȯ�� �� �Է� ����
SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=30;

desc dept;




-- �μ���ȣ�� �ߺ��Ǵ��� üũ�ϱ�. COUNT�Լ� �̿�
SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=30;
-- �μ�Ʈ�ϱ�
INSERT INTO DEPT VALUES (50, 'GOODGOOD', 'SEOUL');
SELECT * FROM DEPT;
ROLLBACK;

    
    