-- ryu DML store / storereview / request queries

-- table store
-- 1. storeRegister / 가게 등록하기
insert into store (sNo, oId, sImage1, sImage2, sImage3, sName, sAddress, sLocation, sTel, sType, sPrice, sTime, sHoliday,
            sMenu1 , sMenu1cost , sMenu2, sMenu2cost, sMenu3, sMenu3cost, sSearchtag, sstart, sEnd) 
values ((SELECT get_store_seq('sno')), 'owner2', 'noimg.jpg', 'noimg.jpg', 'noimg.jpg', '군옥각2', '리월시 취헌부', '강남', '070-8888-8888', '중식, 중국요리, 짜장면', '2만원-4만원대',  
        '11:00-20:00', '금요일', '짜장면', '5000원', '짬뽕', '6000원', '탕수육', '10000원',
        '#강남#강남역#강남역맛집#중국집#중화요리#중국요리', 11, 20);
        
-- 2. storeModify / 가게 정보 수정하기
update store set sImage1 = 'modify.jpg',
                 sImage2 = 'modify.jpg',
                 sImage3 = 'modify.jpg',
                 sName = '청진각',
                 sAddress = '리월시 칠성부 옥형성면',
                 sTel = '010-9998-8888',
                 sType = '중식', 
                 sPrice = '1만원-2만원대',
                 sTime = '24시간' ,
                 sStart = 9,
                 sEnd = 22,
                 sHoliday = '설날, 추석, 공휴일',
                 sMenu1 = '황금새우볼튀김',
                 sMenu1cost = '15000원',
                 sMenu2 = '리월두부',
                 sMenu2cost = '11500원',
                 sMenu3 = '용수면',
                 sMenu3cost = '9500원', 
                 sSearchtag = '#리월#리월맛집#옥형성#각청'
                 where sNo = 3 and oId = 'aaa'; 
                 
-- 3. storeDetail / 가게 정보 상세보기 (sNo로 DTO 불러오기)
SELECT * FROM store WHERE sno = 1;


-- 4. storeDelete / 가게 정보 삭제 (해당 가게 사장님 아이디 / 관리자 사용 가능)
DELETE from store where sno = 5 and oid = 'aaa'; 

-- 5. storeScore 해당 가게 평점 출력하기 (메인 페이지에 이와 같이 출력)
                 
SELECT SIMAGE1, SNAME, SLOCATION, STYPE, Round((sScore/sReplycnt), 1) STSCORE FROM store where sno = 1 order by stscore;

-- 5. 0. storeCnt 등록 완료된 가게 숫자세기

select count(*) cnt from store where sConfirm = 'Y';

-- 5. 0. storeSearchCnt 가게 숫자세기
select count(*) cnt from store where ssearchtag like '%'||'강남'||'%'  and sConfirm = 'Y'; 

-- 5 - 1. storeList / 가게 리스트 페이징하기
SELECT SNO, SIMAGE1, SNAME,  SLOCATION, STYPE, Round((sScore/sReplycnt), 1) STSCORE 
     FROM store order by STSCORE desc limit 1, 3;
     
-- 5 - 2. storeListSearch / 가게 리스트 페이징하기
SELECT SNO, SIMAGE1, SNAME,  SLOCATION, STYPE, Round((sScore/sReplycnt), 1) STSCORE 
     FROM store where sSearchtag like '%'||'강남역'||'%' and sConfirm = 'Y' order by STSCORE desc limit 1, 3;
     
     
-- 5 - 3. storeListNew / 가게 리스트 페이징하기
SELECT SNO, SIMAGE1, SNAME, SLOCATION, STYPE, Round((sScore/sReplycnt), 1) STSCORE 
     FROM store where sConfirm = 'Y' order by sno desc limit 1, 5;
-- 5 - 4. myStoreList / 가게 리스트 페이징하기
SELECT SNO, SIMAGE1, SNAME, SLOCATION, STYPE 
     FROM store where oid = 'bbb' order by sno desc limit 1, 3;   

-- 6. 1. storeScoreUp     
UPDATE store SET   sReplycnt = sReplycnt +1 ,
                   sScore = sScore + 5
                   WHERE SNo = 2;     

-- table storereview

-- 1. reviewWrite / 가게의 리뷰 쓰기
insert into storereview (srNo, sNo, mId, mProfile, srContent, 
    srImage1, srScore) 
VALUES ((SELECT get_storereview_seq('srno')), 2, 'aaa', 'noImg.jpg', '여기 너무 맛있어요',
        'noImg.png', 4); 

SELECT * FROM store;
         
-- 1. - 1. addScore / 가게의 평점 등록 (reviewWrite와 동시에 이뤄지며 score + 숫자에는 srScore 가 들어갈 예정)         
UPDATE store SET   sReplycnt = sReplycnt + 1 ,
                   sScore = sScore + 3
                   WHERE sno = 6; 

-- 2. 0. reviewCnt / 리뷰 숫자 세기 (페이징용)

select count(*) cnt from storereview where sno = 3;

-- 2. reviewList / 해당 가게의 리뷰 목록 조회하기

select * from storereview where sno = 1 order by srno desc;
select * from storereview where sno = 3 order by srno desc limit 1, 3;
        
-- 3. reviewModify / 특정 리뷰 수정
update storereview set 
            srcontent = '이거 진짜 맛있어요!',
            srimage1 ='review1.png'
            where srno = 18;

-- 4. reviewDelete / 해당 리뷰 삭제
delete from storereview where srno = 18;  
commit;

-- 5.reviewDetail (srno로 dto)
select * from storereview where srno = 1;
 
-- table request

-- 1. writeRequest / 사업자가 가게 등록과 동시에 등록 요청
insert into request (rNo, sNo, oid, sName)
values ((SELECT get_request_seq('rno')), 3, 'owner2', '청진각');

-- 2. 0. requestCnt / 리퀘스트 수 (페이징용)

select count(*) cnt from request;

-- 2. requestList / 전체 리퀘스트 목록 조회 (페이징)
select * from request order by rno desc limit 1, 3;
    
-- 2 - 1. myRequestList / 사업자 개인 리퀘스트 조회
select rno, oid, sno, sname, rdate from request where oid = 'ccc' order by rno desc;
    
-- 3. requestDone / 확인 후 업체 등록 (관리자용) sno(가게번호)로 두 테이블에 update 진행
 
update request set sname = CONCAT( sname, ' - 처리 완료 ') where sno = 1; 
update request set sname = '카즈하스시' where sno = 9;

update store set sConfirm = 'Y' where sno = 9;

commit;

select * from OWNER;
                 
-- STORELIKE TABLE

-- 1. 0. 내 찜한 목록 갯수 세기 myLikeCnt
SELECT * FROM StoreLike;
select count(*) cnt from StoreLike where mId = 'aaa'; 

-- 1. 1. 내 찜한 목록 출력하기 myLikeList
select * from StoreLike where mid = 'aaa'
    order by StoreLike.slno desc limit 1, 3;
    
-- 2. 해당 가게 찜하기 insertLike

insert INTO StoreLike (slNo, sNo, mId, sName) values ((SELECT get_storeLike_seq('slno')), 2, 'aaa', '카즈하스시');
                 
-- 3. 해당 가게 찜 삭제하기 deleteLike

delete from StoreLike where mid = 'aaa' and sno = 7;

-- 4. 해당 가게 찜 여부 likeCnt
                 
select count(*) cnt from StoreLike where mid = 'aaa' and sno = 7;                 
                 
 -- 5. likeDetail

select * from StoreLike where sno= 2;

                 
                 
                 
                 
                 