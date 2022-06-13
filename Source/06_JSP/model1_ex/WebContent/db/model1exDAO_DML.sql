-- ★ ★ 고객(CUSTOMER) 테이블 DAO ★ ★ 
-- 1. 회원가입시 CID중복 체크
SELECT * FROM CUSTOMER WHERE CID='aaa';
-- 2. 회원가입
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH)
    VALUES ('ggg','111','홍마동','010-1234-1234','g@g.com', '서울','f','1995-12-12');
-- 3. 로그인(CID/CPW)
SELECT * FROM CUSTOMER WHERE CID='ggg' AND CPW='111';
-- 4. CID로 DTO 가져오기
SELECT * FROM CUSTOMER WHERE CID='ggg';
-- 5. 회원정보 수정
UPDATE CUSTOMER SET CPW='111',
                    CNAME='홍홍홍',
                    CTEL = '010-1111-0000',
                    CEMAIL = 'GG@G.COM',
                    CADDRESS = '부산',
                    CGENDER = 'm',
                    CBIRTH = '1999-12-12'
            WHERE CID='ggg';
-- 6. 회원 리스트 보기(첫화면 main.jsp에서 사용할 부분 - top-N)
SELECT *
    FROM (SELECT ROWNUM RN, CID, CPW, CNAME, CEMAIL, CADDRESS
                FROM (SELECT * FROM CUSTOMER ORDER BY CID))
    WHERE RN BETWEEN 4 AND 6;
-- 7. 등록된 회원수
SELECT COUNT(*) TOTCNT FROM CUSTOMER;
-- ★ ★ 도서(BOOK) 테이블 DAO ★ ★ 
-- 책등록
INSERT INTO BOOK (BID, BTITLE, BPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '이것은 자바다', 30000, 'noImg.png','NOTHING.JPG','책설명',20);

-- 책목록(전체list) -- 신간 도서 순으로 출력
SELECT * FROM BOOK ORDER BY BRDATE DESC;
-- 책목록(top-N구문)
SELECT * 
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) A)
    WHERE RN BETWEEN 2 AND 3;
-- 등록된 책 갯수
SELECT COUNT(*) CNT FROM BOOK;
-- 책 상세보기(bID로 dto가져오기)
SELECT * FROM BOOK WHERE BID=1;

-- ★ ★ 파일첨부게시판(FILEBOARD) 테이블 DAO ★ ★ 
-- 1. 글목록(startRow~endRow)
    SELECT F.*, CNAME, CEMAIL
        FROM FILEBOARD F, CUSTOMER C  
        WHERE F.CID = C.CID
        ORDER BY FREF DESC, FRE_STEP;
SELECT *
    FROM (SELECT ROWNUM RN, A.* 
            FROM (SELECT F.*, CNAME, CEMAIL
                        FROM FILEBOARD F, CUSTOMER C  
                        WHERE F.CID = C.CID
                        ORDER BY FREF DESC, FRE_STEP) A )
    WHERE RN BETWEEN 2 AND 3;
-- 2. 등록된 글 수
SELECT COUNT(*) FROM FILEBOARD;
-- 3. 원글쓰기
INSERT INTO FILEBOARD (fNUM, CID, fSUBJECT, fCONTENT, fFILENAME, fPW, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa', '글1','본문1',null,'111', 
            FILEBOARD_SEQ.CURRVAL, 0,0,'126.12.12.1');
SELECT * FROM FILEBOARD WHERE FNUM=5; -- 방금 쓴 원글 5번글
-- 4. 답변글 쓰기전 step A -- 5번글에 대한 답변글 쓰기 전작업
UPDATE FILEBOARD SET fRE_STEP = fRE_STEP + 1 WHERE fREF=5 AND fRE_STEP>0;
-- 5. 답변글 쓰기 -- 5번글의 답변
INSERT INTO FILEBOARD (fNUM, CID, fSUBJECT, fCONTENT, fFILENAME, fPW, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'bbb', '글1-1','답',null, '111', 5, 1, 1, '192.168.10.10');
SELECT * FROM FILEBOARD WHERE fREF = 5
    ORDER BY FRE_STEP;
-- 6. 글 상세보기(fnum으로 dto가져오기 cNAME, cEMAIL도 가져오기 위해 조인)
SELECT * FROM FILEBOARD WHERE fNUM=1;
SELECT F.*, cNAME, cEMAIL FROM FILEBOARD F, CUSTOMER C WHERE F.CID=C.CID AND fNUM=1;


-- 7. 조회수 올리기
UPDATE FILEBOARD SET fHIT = fHIT+1 WHERE fNUM=5;
-- 8. 글 수정하기
UPDATE FILEBOARD SET fSUBJECT = '수정된 제목',
                    fCONTENT = '수정된 본문',
                    fFILENAME = NULL,
                    fPW = '111',
                    fIP = '192.168.10.30'
                WHERE fNUM=1;
-- 9. 글 삭제하기
DELETE FROM FILEBOARD WHERE fNUM=1 AND fPW='111';
COMMIT;

select count(*) from customer;