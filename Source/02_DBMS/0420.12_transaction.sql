--  [XII] TRANSACTION 명령어 : COMMIT(트랜잭션반영); ROLLBACK(트랜잭션 취소); SAVEPOINT(트랜잭션 분할)
DROP TABLE DEPT01;
CREATE TABLE DEPT01 AS SELECT * FROM DEPT; -- 트랜잭션에 안쌓임
SELECT * FROM DEPT01; -- 트랜잭션에 안쌓임
DELETE FROM DEPT01; -- 쌓임
SELECT * FROM DEPT01;
ROLLBACK; -- DELETE 구문 롤백

-- 새로운 트랜잭션 시작
SELECT * FROM DEPT01;
DELETE FROM DEPT01 WHERE DEPTNO=40;
COMMIT; -- 적용

-- 새로운 트랜잭션 시작
SELECT * FROM DEPT01; -- 10, 20, 30

-- 세개 중 두개의 트랜잭션만 실행을 원하거나 한다면
DELETE FROM DEPT01 WHERE DEPTNO=30;
SAVEPOINT C1; -- C1지점 : 10, 20번 부서만 있는 지점

DELETE FROM DEPT01 WHERE DEPTNO=20;
SELECT * FROM DEPT01; -- 10번 부서만 남음
SAVEPOINT C2; -- C2지점 : 10번 부서만 있는 지점

DELETE FROM DEPT01 WHERE DEPTNO=10;
SELECT * FROM DEPT01; -- 데이터 없음

ROLLBACK TO C2; -- C2지점으로 롤백

SELECT * FROM DEPT01; -- 10번 부서
ROLLBACK TO C1; -- 10번, 20번 부서
SELECT * FROM DEPT01;
COMMIT; -- 30번 부서 지운거만 커밋됨
SELECT * FROM DEPT01;