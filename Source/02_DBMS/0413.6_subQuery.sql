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



--------------------------------------------------------------------------------


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
    WHERE SAL <= (SELECT AVG(SAL) FROM EMP);
    
    -- EX3. ��ձ޿� ���Ϸ� �޴� ����� �̸�, �޿�, ��հ� ���� ���
SELECT AVG(SAL) FROM EMP;
SELECT ENAME, SAL, ROUND(ABS(((SELECT AVG(SAL) FROM EMP)-SAL))) GAP
    FROM EMP
    WHERE SAL<=(SELECT AVG(SAL) FROM EMP);


-- ������ ���߿� �������� : SCOTT�� JOB, DEPTNO�� ���� ������ ��� �ʵ� ���
-- ���������� ���߿����̸� WHERE ���ǿ� �Ȱ��� ��ȣ�� �����ֱ�. �ؿ��� (JOB, DEPTNO) �� ��ó��.(������ ��ġ���Ѿ���)
SELECT JOB, DEPTNO FROM EMP WHERE ENAME='SCOTT'; --��������(������ ���߿�)
SELECT * FROM EMP
    WHERE (JOB, DEPTNO) =(SELECT JOB, DEPTNO FROM EMP WHERE ENAME='SCOTT')
    AND ENAME!='SCOTT';
    
    


-- �� �� ��������
--1. ������̺��� ���� ���� �Ի��� ����� �̸�, �޿�, �Ի���
SELECT MIN(HIREDATE) FROM EMP;
SELECT ENAME, SAL, HIREDATE
    FROM EMP
    WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);
    
-- 2. ȸ�翡�� ���� �޿��� ���� ����� �̸�, �޿�
SELECT MIN(SAL) FROM EMP;
SELECT ENAME, SAL
    FROM EMP
    WHERE SAL = (SELECT MIN(SAL) FROM EMP);
    
-- 3. ȸ�� ��պ��� �޿��� ���� �޴� ����� �̸�, �޿�, �μ��ڵ�
SELECT AVG(SAL) FROM EMP;
SELECT ENAME, SAL, DEPTNO
    FROM EMP
    WHERE SAL>(SELECT AVG(SAL) FROM EMP);

--4. ȸ�� ��� ������ �޿��� �޴� ����� �̸�, �޿�, �μ���
SELECT AVG(SAL) FROM EMP;
SELECT ENAME, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    AND SAL < (SELECT AVG(SAL) FROM EMP);
    
--5. SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���
SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT';
SELECT ENAME, SAL, HIREDATE, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
    AND HIREDATE<(SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT');

--6. 5��(SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���)�� �μ��� �߰��ϰ� �޿��� ū �� ����
SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT';
SELECT DNAME, ENAME, SAL, HIREDATE, GRADE
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO
    AND SAL BETWEEN LOSAL AND HISAL
    AND HIREDATE<(SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT')
    ORDER BY SAL DESC;

--7. BLAKE ���� �޿��� ���� ������� ���, �̸�, �޿�
SELECT SAL FROM EMP WHERE ENAME='BLAKE';
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME='BLAKE');
    
--8. MILLER���� �ʰ� �Ի��� ����� ���, �̸�, �Ի���
SELECT HIREDATE FROM EMP WHERE ENAME='MILLER';
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE HIREDATE>(SELECT HIREDATE FROM EMP WHERE ENAME='MILLER');
    
--9. �����ü ��� �޿����� �޿��� ���� ������� ���, �̸�, �޿�
SELECT AVG(SAL) FROM EMP;
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL > (SELECT AVG(SAL) FROM EMP);

--10. CLARK�� ���� �μ���ȣ�̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ����� ���, �̸�, �޿�
SELECT DEPTNO FROM EMP WHERE ENAME='CLARK';
SELECT SAL FROM EMP WHERE EMPNO='7698';
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME='CLARK')
        AND SAL > (SELECT SAL FROM EMP WHERE EMPNO='7698');

--11.  �����ȭ. CLARK�� ���� �μ����̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ����� ���, �̸�, �޿�
SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME='CLARK';
SELECT SAL FROM EMP WHERE EMPNO='7698';
SELECT EMPNO, ENAME, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
        AND DNAME = (SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME='CLARK')
        AND SAL > (SELECT SAL FROM EMP WHERE EMPNO='7698');
    
--12. BLAKE�� ���� �μ��� �ִ� ��� ����� �̸��� �Ի�����
SELECT DEPTNO FROM EMP WHERE ENAME='BLAKE';
SELECT ENAME, HIREDATE
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME='BLAKE');

--13. ��� �޿� �̻��� �޴� ��� �������� ���ؼ� �����ȣ�� �̸� �� �޿��� ���� ������ ���)
SELECT AVG(SAL) FROM EMP;
SELECT EMPNO, ENAME
    FROM EMP
    WHERE SAL > (SELECT AVG(SAL) FROM EMP)
    ORDER BY SAL DESC;



--------------------------------------------------------------------------------


-- �� 3. ������ ��������
-- (1) IN : �������� ��� �� �ϳ��� ��ġ�ϸ� ��
    -- EX. �μ����� �Ի����� ���� ���� ����� �̸�, �Ի���, �μ���ȣ
SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO; -- ��������(������, ���߿�)
SELECT ENAME, HIREDATE, DEPTNO
    FROM EMP
    WHERE (DEPTNO, HIREDATE) IN (SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO); --��������
    
    -- EX. �޿� 3000�̻� �޴� ����� �Ҽӵ� �μ����� �ٹ��ϴ� ����� ��� �ʵ�
SELECT DEPTNO FROM EMP WHERE SAL>=3000;
SELECT *
    FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE SAL>=3000);
    

-- (2) ALL : �ش� �� �ȿ��� ���� ū ��(BUT, ��κ� ������ ���������� ���� ���°� ����)
    -- EX. 30�� �μ� �޿��� ��κ��� ū ����� ��� �ʵ�= 30�� �μ� �ִ� �޿����� ū ���
SELECT SAL FROM EMP WHERE DEPTNO=30; -- ��������(������)
SELECT * FROM EMP WHERE SAL > ALL(SELECT SAL FROM EMP WHERE DEPTNO=30);

-- ���� ������ ���������� ������ ���������� ���� ��
SELECT MAX(SAL) FROM EMP WHERE DEPTNO=30;
SELECT *
    FROM EMP
    WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE DEPTNO=30);



-- (3) ANY=SOME ; �������� ����� �ϳ��� �����ϸ� ��

    -- EX. 30�� �μ� �޿��� �� �ϳ����̶� ū ���(=30�� �μ� �ּұ޿����� ū ���)
SELECT SAL FROM EMP WHERE DEPTNO=30;
SELECT *
    FROM EMP
    WHERE SAL > ANY(SELECT SAL FROM EMP WHERE DEPTNO=30);

    -- ���� QUERY�� ������ ����������
SELECT * FROM EMP WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO=30);



-- (4) EXISTS : �������� ����� �����ϸ� ��
    -- EX. ���Ӻ��ϰ� �ִ� �������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL
    FROM EMP MANAGER
    WHERE EXISTS (SELECT * FROM EMP WHERE MANAGER.EMPNO=MGR);

SELECT DISTINCT M.EMPNO, M.ENAME, M.SAL
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO;
    
    -- EX. ���� ����� ��� �ʵ� ���
SELECT *
    FROM EMP MANAGER
    WHERE NOT EXISTS (SELECT * FROM EMP WHERE MANAGER.EMPNO=MGR); -- �������� �̿�
    
SELECT M.*
    FROM EMP W, EMP M
    WHERE W.MGR(+)=M.EMPNO AND W.ENAME IS NULL; --SELF JOIN �̿�


-- źź1. �μ����� ���� �޿��� ���� �޴� ����� ����(��� ��ȣ, �̸�, �޿�, �μ���ȣ)�� ���(IN ������ Ȱ��)
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; -- ��������
SELECT EMPNO, ENAME, SAL, DEPTNO
    FROM EMP
    WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO); --���� ����
    

-- źź2. ����(JOB)�� MANAGER�� ����� ���� �μ��� �μ���ȣ, �μ���, ������ ���(IN)
SELECT DEPTNO FROM EMP WHERE JOB='MANAGER';
SELECT DEPTNO, DNAME, LOC
    FROM DEPT
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB='MANAGER'); 

-- źź3.�޿��� 3000�̻��� ����� �� �޿� ����� ���� �ش� ��޺� �ְ� �޿��� �޴� �������
-- ���, �̸�, ����, �Ի���, �޿�, �޿������ ���
SELECT * FROM SALGRADE;

SELECT ENAME FROM EMP WHERE SAL>=3000;
SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
    AND SAL = HISAL;
    AND ENAME IN (SELECT ENAME FROM EMP WHERE SAL>=3000);


SELECT GRADE, MAX(SAL)
    FROM SALGRADE, EMP
    WHERE SAL BETWEEN LOSAL AND HISAL AND SAL>=3000
    GROUP BY GRADE; --�������� 4,5���
    
SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, GRADE
    FROM SALGRADE, EMP
    WHERE SAL BETWEEN LOSAL AND HISAL
        AND (GRADE, SAL) IN (SELECT GRADE, MAX(SAL)
                             FROM SALGRADE, EMP
                             WHERE SAL BETWEEN LOSAL AND HISAL AND SAL>=3000
                             GROUP BY GRADE);

-- źź4. �����ȭ : �Ի��� �б⺰�� ���� ���� �޿��� �޴� �������
-- �б�, ���, �̸�, JOB, �����, �Ի���, �޿�, �󿩸� ����ϼ���
SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3) "QUARTER", MAX(SAL) FROM EMP GROUP BY CEIL(EXTRACT(MONTH FROM HIREDATE)/3); --��������
SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3) "QUARTER", EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, NVL(COMM,0)
    FROM EMP
    WHERE (CEIL(EXTRACT(MONTH FROM HIREDATE)/3), SAL) IN
            (SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3) "QUARTER", MAX(SAL)
             FROM EMP GROUP BY CEIL(EXTRACT(MONTH FROM HIREDATE)/3))
    ORDER BY "QUARTER";


-- źź5. JOB�� SALESMAN�� ����麸�� �޿��� ���� �޴� ������� �̸�, �޿�, ����(������)�� ���. ��, ��������� ��� X
SELECT SAL FROM EMP WHERE JOB='SALESMAN'; -- ��������(������)
SELECT ENAME, SAL, JOB
    FROM EMP
    WHERE SAL > ALL(SELECT SAL FROM EMP WHERE JOB='SALESMAN')
    ORDER BY SAL; --��������
    
SELECT ENAME, SAL, JOB
    FROM EMP
    WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE JOB='SALESMAN')
    ORDER BY SAL; --���������� ���� ��


-- źź6. SALESMAN ����� � �� ������� �޿��� ���� �޴� ������� �̸��� �޿��� ������ ���. ��, ��������� ���X
SELECT SAL FROM EMP WHERE JOB='SALESMAN'; -- ��������(������)
SSELECT ENAME, SAL, JOB
    FROM EMP
    WHERE SAL > ANY(SELECT SAL FROM EMP WHERE JOB='SALESMAN')
    ORDER BY SAL; --��������


-- źź7. ������ 3000�̸��� ����� �� ���� �ֱ� �Ի����� �����ȣ, �̸�, ����, �Ի��� ���
SELECT MAX(HIREDATE) FROM EMP WHERE SAL<3000;
SELECT EMPNO, ENAME, SAL, HIREDATE
    FROM EMP
    WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP WHERE SAL<3000);


-- źź8. ������ 'SALESMAN'�� ����� �޴� �ּұ޿����� ���� �޴� ������� �̸�, �޿�, ����, �μ���ȣ. ��,20���μ� ��� ����(ANY ������ �̿�)
SELECT SAL FROM EMP WHERE JOB='SALESMAN';
SELECT ENAME, SAL, JOB, DEPTNO
    FROM EMP
    WHERE SAL > ANY( SELECT SAL FROM EMP WHERE JOB='SALESMAN')
    AND DEPTNO!=20
    ORDER BY DEPTNO, SAL;





-- ���⼭���ʹ� �����༭�������� �����༭������, ������ �����༭������
-- 14.  �̸��� ��T���� �ִ� ����� �ٹ��ϴ� �μ����� �ٹ��ϴ� ��� ������ ��� ��ȣ,�̸�,�޿�(�� ��� �� ���)
SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%';
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%')
    ORDER BY EMPNO;
    
-- 15. �μ� ��ġ�� Dallas�� ��� �������� ���� �̸�,����,�޿�
SELECT ENAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND LOC='DALLAS';
SELECT ENAME, JOB, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    AND ENAME IN (SELECT ENAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND LOC='DALLAS');

-- 16. EMP ���̺��� King���� �����ϴ� ��� ����� �̸��� �޿�
SELECT W.ENAME FROM EMP W, EMP M WHERE W.MGR=M.EMPNO AND M.ENAME='KING';
SELECT W.ENAME, W.SAL
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO
    AND W.ENAME IN (SELECT W.ENAME FROM EMP W, EMP M WHERE W.MGR=M.EMPNO AND M.ENAME='KING');

-- 17. SALES�μ� ����� �̸�, ����
SELECT DNAME FROM DEPT WHERE DNAME='SALES';
SELECT ENAME, JOB
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    AND DNAME = (SELECT DNAME FROM DEPT WHERE DNAME='SALES');

-- 18. ������ �μ� 30�� ���� ���޺��� ���� ����� ��� �ʵ�
SELECT SAL FROM EMP WHERE DEPTNO=30;
SELECT *
    FROM EMP
    WHERE SAL > ANY(SELECT SAL FROM EMP WHERE DEPTNO=30);

-- 19. �μ� 10���� �μ� 30�� ����� ���� ������ �ð� �ִ� ����� �̸��� ����
SELECT JOB FROM EMP WHERE DEPTNO=30;
SELECT ENAME, JOB
    FROM EMP
    WHERE JOB IN (SELECT JOB FROM EMP WHERE DEPTNO=30)
    AND DEPTNO=10;

-- 20.  FORD�� ������ ���޵� ���� ����� ��� �ʵ�
SELECT JOB, SAL FROM EMP WHERE ENAME='FORD';
SELECT *
    FROM EMP
    WHERE (JOB, SAL) = (SELECT JOB, SAL FROM EMP WHERE ENAME='FORD') AND ENAME!='FORD';


-- 21. �̸��� JONES�� ������ JOB�� ���ų� FORD�� SAL �̻��� �޴� ����� ������ �̸�, ����, �μ���ȣ, �޿�
    -- ��, ������ ���ĺ� ��, ������ ���� ������ ���
SELECT JOB FROM EMP WHERE ENAME='JONES';
SELECT SAL FROM EMP WHERE ENAME='FORD';
SELECT ENAME, JOB, DEPTNO, SAL
    FROM EMP
    WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME='JONES')
    OR SAL > (SELECT SAL FROM EMP WHERE ENAME='FORD')
    ORDER BY JOB, SAL;


-- 22. SCOTT �Ǵ� WARD�� ������ ���� ����� ������ �̸�,����,�޿�
SELECT SAL FROM EMP WHERE ENAME='SCOTT' OR ENAME='WARD';
SELECT ENAME, JOB, SAL
    FROM EMP
    WHERE SAL IN (SELECT SAL FROM EMP WHERE ENAME='SCOTT' OR ENAME='WARD')
    AND ENAME NOT IN('SCOTT', 'WARD');


-- 23. CHICAGO���� �ٹ��ϴ� ����� ���� ������ �ϴ� ������� �̸�,����
SELECT JOB FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND LOC='CHICAGO';
SELECT ENAME, JOB
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    AND JOB IN (SELECT JOB FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND LOC='CHICAGO');

-- 24. �μ����� ������ ��� ���޺��� ���� ����� ���, �̸�, �޿�, �μ���ȣ
-- ����
SELECT EMPNO, ENAME, SAL
    FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO)
    ORDER BY DEPTNO;

-- FROM���� ���������� �־ �ϴ� ���
SELECT EMPNO, ENAME, SAL
    FROM EMP E, (SELECT DEPTNO, AVG(SAL) "AVG" FROM EMP GROUP BY DEPTNO) A
    WHERE E.DEPTNO=A.DEPTNO AND SAL>AVG; --�ζ��κ�

-- �ش�μ���պ��� ���� ����� ���, �̸�, �޿�, �μ���ȣ, �ش�μ��� ���(�Ҽ���2�ڸ�)
SELECT EMPNO, ENAME, SAL, DEPTNO, ROUND((SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO),2) "AVG"
    FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO);

-- �ζ��κ並 Ȱ���� ���
SELECT EMPNO, ENAME, SAL, E.DEPTNO, AVG
    FROM EMP E, (SELECT DEPTNO, AVG(SAL) AVG FROM EMP GROUP BY DEPTNO) A
    WHERE E.DEPTNO=A.DEPTNO AND SAL > AVG;

-- ������ ��
SELECT EMPNO, ENAME, SAL, DEPTNO
    FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP T WHERE T.DEPTNO=E.DEPTNO)
    ORDER BY DEPTNO;



-- ���������� �غ� ��
SELECT *
    FROM EMP E, EMP T
    WHERE E.DEPTNO=T.DEPTNO
    ORDER BY E.ENAME;
    
SELECT DEPTNO, COUNT(*)
    FROM EMP
    GROUP BY DEPTNO;

-- 25. �������� ��� ���޺��� ���� ������ �޴� ����� �μ���ȣ, �̸�, �޿�
SELECT DEPTNO, ENAME, SAL, JOB
    FROM EMP E
    WHERE SAL < (SELECT AVG(SAL) FROM EMP T WHERE T.JOB=E.JOB)
    ORDER BY DEPTNO; 

-- ���������� �غ� ��
SELECT *
    FROM EMP E, EMP T
    WHERE E.JOB=T.JOB;


-- 26. ��� �� �� �̻����κ��� ���� ���� �� �ִ� ����� ����, �̸�, ���, �μ���ȣ�� ���(��, �μ���ȣ ������ �������� ����)
SELECT JOB, ENAME, EMPNO, DEPTNO
    FROM EMP M
    WHERE EXISTS(SELECT * FROM EMP WHERE MGR=M.EMPNO)
    ORDER BY DEPTNO;


-- 27.  ���� ����� ���, �̸�, ����, �μ���ȣ
SELECT EMPNO, ENAME, JOB, DEPTNO
    FROM EMP M
    WHERE NOT EXISTS(SELECT * FROM EMP WHERE MGR=M.EMPNO)
    ORDER BY DEPTNO;




-- (4) EXISTS : �������� ����� �����ϸ� ��
    -- EX. ���Ӻ��ϰ� �ִ� �������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL
    FROM EMP MANAGER
    WHERE EXISTS (SELECT * FROM EMP WHERE MANAGER.EMPNO=MGR);

SELECT DISTINCT M.EMPNO, M.ENAME, M.SAL
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO;
    
    -- EX. ���� ����� ��� �ʵ� ���
SELECT *
    FROM EMP MANAGER
    WHERE NOT EXISTS (SELECT * FROM EMP WHERE MANAGER.EMPNO=MGR); -- �������� �̿�
    
SELECT M.*
    FROM EMP W, EMP M
    WHERE W.MGR(+)=M.EMPNO AND W.ENAME IS NULL; --SELF JOIN �̿�