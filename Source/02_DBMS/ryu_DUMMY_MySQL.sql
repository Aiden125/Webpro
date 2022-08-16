-- ryu DUMMY
commit;
select * from storelike;
UPDATE store SET oid = 'owner2' where sno =7 ;
UPDATE store SET sconfirm = 'Y' ;
SELECT * FROM store;
SELECT * FROM storereview;
select * from store where sno = 6;
delete from store where sno between 22 and 30;
SELECT simage1, sname,  slocation, STYPE, Round((sScore/sReplycnt), 1) STSCORE FROM store where sNo = 1; -- 가게 평점 
select  get_store_seq('sno') from dual;



UPDATE STORE SET slati = 37.60954605745158, slongti = 126.97386634391374, sconfirm = 'Y' where sno = 9 ; 
       
UPDATE STORE SET   sReplycnt = sReplycnt +1 ,
                   sScore = sScore +3
                   WHERE SNo = 31;
UPDATE STOREREVIEW SET   srimage1 = 'noimg.png' , srimage2 = 'noimg.png' , srimage3 = 'noimg.png' , srimage4 = 'noimg.png' , srimage5 = 'noimg.png' 
                   WHERE SNo = 3;
                   commit;