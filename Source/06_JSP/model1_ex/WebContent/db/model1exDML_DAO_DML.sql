-- ★★★고객(CUSTOMER) 테이블 DAO★★★
-- 1. 회원가입시 cID 중복체크
SELECT * FROM CUSTOMER WHERE cID='aaa';
-- 2. 회원가입
INSERT INTO CUSTOMER(cID, cPW, cNAME, cTEL, cEMAIL, cADDRESS, cGENDER, cBIRTH)
    VALUES('xxx', '1234', '국밥김', '010-1234-1234', 'gqw@nqwe', '서울', 'm', '1995-12-12');
-- 3. 로그인(cID/cPW)
SELECT * FROM CUSTOMER WHERE cID='aaa' AND cPW='111';
-- 4. cID로 DTO 가져오기
SELECT * FROM CUSTOMER WHERE cID='ggg';
-- 5. 회원정보 수정
UPDATE CUSTOMER SET cPW='111',
                    cNAME='홍홍',
                    cEMAIL='22@AN.COM',
                    cADDRESS='부산',
                    cGENDER='m',
                    cBIRTH='1999-1212'
                WHERE cID='ggg';
-- 6. 회원 리스트 출력(첫 화면 MAIN.JSP에서 사용할 부분)
SELECT *
    FROM (SELECT ROWNUM RN, cID, cPW, cNAME, cEMAIL, cADDRESS
                        FROM(SELECT * FROM CUSTOMER ORDER BY cID))
    WHERE RN BETWEEN 4 AND 6;
-- 7. 등록된 회원 수
SELECT COUNT(*) TOTCNT FROM CUSTOMER;



-- ★★★도서(BOOK) 테이블 DAO★★★

-- 책등록(INSERT)
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '자바의 정석', 30000, 'noimg.png', 'nothing.png', '책설명', 20);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '그림 알고리즘', 23000, 'nothing.png', 'noimg.png', '책설명', 20);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '패턴의 모든 것', 35000, 'noimg.png', 'nothing.png', '책설명', 20);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '데이터베이스 관리', 18000, 'nothing.png', 'noimg.png', '책설명', 20);

UPDATE BOOK SET bIMAGE1='NOTHING.JPG' WHERE bID IN (2,4);
-- 책목록(전체list) 신간 도서 순으로 출력
SELECT * FROM BOOK ORDER BY bRDATE DESC;

-- 책목록(top-N구문)
SELECT *
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY bRDATE DESC) A)
    WHERE  RN BETWEEN 2 AND 3;

-- 등록된 책 갯수
SELECT COUNT(*) CNT FROM BOOK;

-- 책 상세보기(bID로 dto가져오기)
SELECT * FROM BOOK WHERE BID=1;


-- ★★★파일첨부게시판(FILEBOARD) 테이블 DAO★★★
-- 1. 글 리스트 출력(startRow~endRow)
SELECT F.*, cNAME, cEMAIL
    FROM FILEBOARD F, CUSTOMER C
    WHERE F.CID = C.CID
    ORDER BY fREF DESC, fRE_STEP;


SELECT *
    FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT F.*, cNAME, cEMAIL
            FROM FILEBOARD F, CUSTOMER C
            WHERE F.CID = C.CID
            ORDER BY fREF DESC, fRE_STEP) A)
    WHERE  RN BETWEEN 2 AND 3;

    
-- 2. 등록된 글 갯수 출력
SELECT COUNT(*) A FROM FILEBOARD;


-- 3. 원글쓰기
INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT,
                        fFILENAME, fPW, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'aaa', '글1', '본문1',
                null, '1234', FILEBOARD_SEQ.CURRVAL, 0, 0, '123.123.123.1');

SELECT * FROM FILEBOARD WHERE fNUM=5; -- 방금 쓴 원글


-- 4. 답변글 쓰기 step A (답변 글 쓰기 전 작업)
UPDATE FILEBOARD SET fRE_STEP = fRE_STEP + 1 WHERE fREF=5 AND fRE_STEP>0;


-- 5. 답변글 쓰기
INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT,
                        fFILENAME, fPW, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'bbb', '글1-1', '답', null, '111', 5, 1, 1, '123.123.123.1');
    
SELECT * FROM FILEBOARD WHERE fREF=5
    ORDER BY fRE_STEP;
    
    
-- 6. 글 상세보기(fNUM으로 dto가져오기)
SELECT * FROM FILEBOARD WHERE fNUM=5;


-- 7. 조회수 올리기
UPDATE FILEBOARD SET fHIT = fHIT+1 WHERE fNUM=5;

-- 8. 글 수정
UPDATE FILEBOARD SET fSUBJECT = '수정된 제목',
                    fCONTENT = '수정된 본문',
                    fFILENAME = NULL,
                    fPW = '123',
                    fIP = '123.123.123'
            WHERE fNUM=1;

-- 9. 글 삭제하기
DELETE FROM FILEBOARD WHERE fNUM=1 AND fPW='1234';
COMMIT;




