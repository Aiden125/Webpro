--  [XII] TRANSACTION ��ɾ� : COMMIT(Ʈ����ǹݿ�); ROLLBACK(Ʈ����� ���); SAVEPOINT(Ʈ����� ����)
DROP TABLE DEPT01;
CREATE TABLE DEPT01 AS SELECT * FROM DEPT; -- Ʈ����ǿ� �Ƚ���
SELECT * FROM DEPT01; -- Ʈ����ǿ� �Ƚ���
DELETE FROM DEPT01; -- ����
SELECT * FROM DEPT01;
ROLLBACK; -- DELETE ���� �ѹ�

-- ���ο� Ʈ����� ����
SELECT * FROM DEPT01;
DELETE FROM DEPT01 WHERE DEPTNO=40;
COMMIT; -- ����

-- ���ο� Ʈ����� ����
SELECT * FROM DEPT01; -- 10, 20, 30

-- ���� �� �ΰ��� Ʈ����Ǹ� ������ ���ϰų� �Ѵٸ�
DELETE FROM DEPT01 WHERE DEPTNO=30;
SAVEPOINT C1; -- C1���� : 10, 20�� �μ��� �ִ� ����

DELETE FROM DEPT01 WHERE DEPTNO=20;
SELECT * FROM DEPT01; -- 10�� �μ��� ����
SAVEPOINT C2; -- C2���� : 10�� �μ��� �ִ� ����

DELETE FROM DEPT01 WHERE DEPTNO=10;
SELECT * FROM DEPT01; -- ������ ����

ROLLBACK TO C2; -- C2�������� �ѹ�

SELECT * FROM DEPT01; -- 10�� �μ�
ROLLBACK TO C1; -- 10��, 20�� �μ�
SELECT * FROM DEPT01;
COMMIT; -- 30�� �μ� ����Ÿ� Ŀ�Ե�
SELECT * FROM DEPT01;





















