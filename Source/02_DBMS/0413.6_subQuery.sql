-- [VI] SUB QUERY ; QUERY�ȿ� QUERY�� ����



-- �� 1. ���� ���� ����(�ʿ伺)
-- ���������� ����� �� ���� : �޿����� ���� �޴� ����� ���, �̸�, ��å, �޿�
SELECT MAX(SAL) FROM EMP;
SELECT EMPNO, MAX(SAL) FROM EMP GROUP BY EMPNO;

SELECT MAX(SAL) FROM EMP; --��������
SELECT EMPNO, ENAME, JOB, SAL
    FROM EMP
    WHERE SAL = (SELECT MAX(SAL) FROM EMP); -- ��������(���������� ��ȣ�� �����־�� ��)


-- �������� ����(1) ������ �������� - ���������� �������� �� ����� ������ �� �� : =, >, >=, <, <=, != ��� �ε�ȣ ��밡��

    -- EX. SCOTT�� �ٹ��ϴ� �μ��̸� ���
SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'; --��������
SELECT DNAME
    FROM DEPT
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'); --��������
    
SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME='SCOTT';


-- �������� ����(2) ������ ��������(�������� ��� 2���̻�) : IN. ANY, ALL, EXISTS
    -- EX. JOB�� MANAGER�� ����� �μ��̸�
    SELECT DEPTNO FROM EMP WHERE JOB='MANAGER'; -- ��������
    SELECT DNAME FROM DEPT
        WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB='MANAGER');



-- �� 2. ������ ��������
    -- �Ʒ� ���� ��ó��(SCOTT �μ���ȣ:20, �ٹ���:DALLAS)
SELECT E.DEPTNO, LOC FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME='SCOTT';

-- SCOTT�� ������ �μ���ȣ �߰��� ���� �μ�Ʈ �ϴµ�, �θ� �Ǵ� DEPT���� �ؾ��� ����� ������
INSERT INTO DEPT VALUES(50, 'IT', 'DALLAS');
INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES (9999, 'ȫ�浢', 50); --EMP�ڿ� ������ ������ ������ �� �����͸� �ְڴٴ� ��. �������� NULL�� �ڵ�����

    -- EX. SCOTT�� ���� �μ��� ����� �̸��� �޿� ���
SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'; --��������
SELECT ENAME, SAL
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT') AND ENAME!='SCOTT'; --���� ����

    -- EX. SCOTT�� ���� �ٹ����� ����� �̸��� �޿� ���
SELECT LOC FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME='SCOTT'; -- ��������
SELECT ENAME, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
        AND LOC = (SELECT LOC FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME='SCOTT')
        AND ENAME!='SCOTT';
    ROLLBACK; --���� �ֱٿ� �� DML ���(DML-�������߰�,����,���� ���� ���)
    

    -- EX. �����Ի��ϰ� �����Ի��� ����̸�
SELECT MIN(HIREDATE) FROM EMP; -- ������ ��������
SELECT ENAME, HIREDATE
    FROM EMP
    WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP); --��������
    
    
    -- EX. �ֱ��Ի��ϰ� �ֱ��Ի��� ����̸�
SELECT MAX(HIREDATE) FROM EMP; -- ������ ��������
SELECT ENAME, HIREDATE
    FROM EMP
    WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP); --��������
    
    
    -- EX. �����Ի��ϰ� �����Ի��� ����̸�, �ֱ��Ի��ϰ� �ֱ��Ի��� ����̸�
    -- ����Ʈ���� �������� �־ �ϴ°��
SELECT
    (SELECT MAX(HIREDATE) FROM EMP) LAST,
    (SELECT ENAME FROM EMP
    WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP)) LASTMAN,
    (SELECT MIN(HIREDATE) FROM EMP) FIRST,
    (SELECT ENAME FROM EMP
    WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP)) FIRSTMAN
    FROM DUAL;
    
    -- JOIN �̿��ؼ� �ϴ� ���
    SELECT E1.HIREDATE, E1.ENAME, E2.HIREDATE, E2.ENAME
    FROM EMP E1, EMP E2
    WHERE E1.HIREDATE = (SELECT MIN(HIREDATE) FROM EMP)
    AND E2.HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);

    -- EX. SCOTT�� ���� �μ��� �ٹ��ϴ� ������� �޿���
SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'; --��������
SELECT SUM(SAL)
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'); --��������
    
    -- EX. SCOTT�� ������ ��å(JOB)�� ���� ����� ��� �ʵ�
SELECT JOB FROM EMP WHERE ENAME='SCOTT';
SELECT * FROM EMP WHERE JOB=(SELECT JOB FROM EMP WHERE ENAME='SCOTT');

    -- EX. DALLAS���� �ٹ��ϴ� ����� �̸�, �μ���ȣ
SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS'; -- ��������
SELECT ENAME, DEPTNO
    FROM EMP
    WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS'); -- ��������

    -- EX. 'KING'�� ���ӻ���� ����� �̸��� �޿�
SELECT EMPNO FROM EMP WHERE ENAME='KING'; -- ��������
SELECT ENAME, SAL
    FROM EMP
    WHERE MGR=(SELECT EMPNO FROM EMP WHERE ENAME='KING'); -- ��������
    
SELECT W.ENAME, W.SAL
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO AND M.ENAME='KING';


    -- EX1. ��� �޿� ���Ϸ� �޴� ����� �̸��� �޿��� ���
SELECT AVG(SAL) FROM EMP;
SELECT ENAME, SAL
    FROM EMP
    WHERE SAL<=(SELECT AVG(SAL) FROM EMP)
    ORDER BY SAL;

    -- EX2. ��ձ޿� ���Ϸ� �޴� ����� �̸�, �޿�, ��ձ޿� ���
SELECT ENAME, SAL, ROUND((SELECT AVG(SAL) FROM EMP))
    FROM EMP
    WHERE SAL <= (SELECT AVG(SAL) FROM EMP)





