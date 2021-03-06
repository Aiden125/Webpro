-- BOARD table DROP & CREATE
DROP SEQUENCE BOARD_SEQ;
CREATE SEQUENCE BOARD_SEQ MAXVALUE 999999 NOCACHE NOCYCLE;
DROP TABLE BOARD;
CREATE TABLE BOARD(
    bID NUMBER(6) PRIMARY KEY,
    bNAME VARCHAR2(50) NOT NULL, -- 작성자 이름
    bTITLE VARCHAR2(100) NOT NULL,
    bCONTENT VARCHAR2(1000),
    bDATE DATE DEFAULT SYSDATE NOT NULL, -- 작성시점
    bHIT NUMBER(6) DEFAULT 0 NOT NULL, -- 조회수
    bGROUP NUMBER(6) NOT NULL, -- 글 그룹
    bSTEP NUMBER(6) NOT NULL, -- 글 그룹내 출력 순서
    bINDENT NUMBER(6) NOT NULL, -- 들여쓰기
    bIP VARCHAR2(20) NOT NULL
);


-- DUMMY DATA
SELECT * FROM BOARD;
INSERT INTO BOARD (bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP)
 VALUES(BOARD_SEQ.NEXTVAL, '홍홍길', '글1', '본문1', BOARD_SEQ.CURRVAL, 0, 0, '192.123.123.111');
INSERT INTO BOARD (bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP)
 VALUES(BOARD_SEQ.NEXTVAL, '김문길', '글2', '본문1', BOARD_SEQ.CURRVAL, 0, 0, '192.123.123.111');
 
SELECT * FROM BOARD;

INSERT INTO BOARD (bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP)
    VALUES (BOARD_SEQ.NEXTVAL, '답변', '글-1', '답', 1, 1, 1, '123.123.123.1');
    
    
-- DAO에 들어갈 QUERY
-- 글목록(startRow ~ endRow)
SELECT * FROM BOARD ORDER BY BGROUP DESC, BSTEP; -- 글 출력 순서
SELECT *
    FROM(SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOARD ORDER BY BGROUP DESC, BSTEP) A)
    WHERE RN BETWEEN 2 AND 3;
    
-- 전체 글 갯수
SELECT COUNT(*) FROM BOARD;

-- 원글쓰기
INSERT INTO BOARD (bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP)
 VALUES(BOARD_SEQ.NEXTVAL, '퀵퀵동', '글3', '본문1', BOARD_SEQ.CURRVAL, 0, 0, '192.123.123.111');

-- BID로 조회수 올리기
UPDATE BOARD SET bHIT = bHIT+1 WHERE bID=1;

-- 글 상세보기(bID로 DTO가져오기)
SELECT * FROM BOARD WHERE bID=1;

-- 답변글 쓰기전 STEP A (기존의 답변글의 출력 순서 +1) : 1번글의 답변글 쓸 예정
SELECT * FROM BOARD WHERE bGROUP=1; -- 1번 글 GROUP 출력
UPDATE BOARD SET bSTEP = bSTEP+1 WHERE bGROUP=1 AND bSTEP>0;

-- 답변글 쓰기
INSERT INTO BOARD(bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP)
    VALUES(BOARD_SEQ.NEXTVAL, '답변이요', '글1-2', NULL, 1, 1, 1, '123.123.0.1');
    
-- 글 수정
UPDATE BOARD SET bNAME = '봄봄봄',
                bTITLE = '수정제목',
                bCONTENT = '수정본문',
                bIP = '123.12.12.12'
            WHERE bID = 2;

-- 글 삭제
DELETE FROM BOARD WHERE bID=2;
COMMIT;


