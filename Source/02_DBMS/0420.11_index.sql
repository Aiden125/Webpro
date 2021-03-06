-- [XI] 인덱스 : 조회를 빠르게 하는 인덱스
SELECT * FROM USER_INDEXES; -- 딕셔너리뷰에서 SCOTT이 소유한 인덱스 정보
DESC EMP; -- EMPNO키가 주키로 설정되어있고 자동으로 인덱스 생성



DROP TABLE EMP01;

SELECT TO_CHAR(COUNT(*), '9,999,999') FROM EMP01;

CREATE TABLE EMP01 AS SELECT * FROM EMP; -- EMP내용과 같은 EMP01 생성
SELECT * FROM EMP01; -- 14행
INSERT INTO EMP01 SELECT * FROM EMP01; -- 1번(28행) 2번(56행)
INSERT INTO EMP01 SELECT * FROM EMP01; -- 11번(11만 4천개)
INSERT INTO EMP01 (EMPNO, ENAME, DEPTNO) VALUES(1111, 'HONG', 40);
INSERT INTO EMP01 SELECT * FROM EMP01; -- 3번 180만개 행

-- 인덱스 생성 전 조회
SELECT * FROM EMP01 WHERE ENAME='HONG'; -- 인덱스 생성 전

-- 인덱스 생성(EMP01테이블의 ENAME)하고 조회
CREATE INDEX IDX_EMP01_ENAME ON EMP01(ENAME); -- 인덱스 생성 : 0.49
SELECT * FROM EMP01 WHERE ENAME='HONG';
SELECT * FROM USER_INDEXES WHERE INDEX_NAME = 'IDX_EMP01_ENAME';
COMMIT;
INSERT INTO EMP01 SELECT * FROM EMP01; -- 인덱스 생성 후 INSERT 속도 : 21.1초
ROLLBACK; -- 90만개로 되돌리기
DROP INDEX IDX_EMP01_ENAME;
INSERT INTO EMP01 SELECT * FROM EMP01; -- 인덱스 제거 후 INSERT 속도