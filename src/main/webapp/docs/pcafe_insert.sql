/* 개인 카페 insert 
 * 해당 이미지 upload 폴더에 넣어놓음 
 * 회원시퀀스 5번으로 박아 넣었으므로 회원가입 해서 시퀀스 5번까지 만든 후 insert 하기*/

Insert into PRIVATE_CAFE (PCAFE_NUM,U_UID,PCAFE_NAME,PCAFE_ADDRESS,PCAFE_PHONE,PCAFE_TIME,PCAFE_URL,PCAFE_INTRODUCE,PCAFE_HASH_TAG,PCAFE_IMG,PCAFE_VISIT,PCAFE_REG_DATE) values (private_cafe_seq.nextval,'5','카페 더 엘가','서울특별시 관악구 봉천동 947-15 더 엘가 커피','050-7462-0194','9:00AM ~ 1:00AM','http:// ','봉천역 3번 출구 5분 거리에 위치한 카페 ''더 엘가''입니다. 
높은 천장과 빈티지스러운 인테리어가 세련된 느낌을 자아내는 공간입니다. 은은한 조명이 아늑한 분위기를 제공하며 어느 각도에서 사진을 찍어도 잘 나오는 곳이기도 합니다.
친목 모임, 비즈니스 회의, 스터디, 세미나, 워크샵 등 다양한 모임이 가능합니다.','카페,회의실,봉천','*14757037484039.jpg',0,sysdate);
Insert into PRIVATE_CAFE (PCAFE_NUM,U_UID,PCAFE_NAME,PCAFE_ADDRESS,PCAFE_PHONE,PCAFE_TIME,PCAFE_URL,PCAFE_INTRODUCE,PCAFE_HASH_TAG,PCAFE_IMG,PCAFE_VISIT,PCAFE_REG_DATE) values (private_cafe_seq.nextval,'5','카페그라쎄','서울특별시 관악구 남부순환로 1909 지하1층 카페그라쎄','050-7462-0083','9:00AM ~ 12:00AM','http://','관악구에 위치한 카페그라쎄는 회의실, 세미나실, 스터디룸 등 다양한 용도로 사용할 수 있는 공간입니다.
개별 룸 공간이 마련되어 있어서 모임, 스터디 등 독립적인 모임을 갖기에도 적합합니다. 화이트보드, 와이파이, 주차시설 등의 편의시설이 구비되어 있어 공간 이용이 매우 편리합니다. 조용하고 차분한 분위기의 스터디 공간이 필요하신 분들,
회의, 스터디, 세미나, 독서모임 등을 하기 위한 공간이 필요하신 분들은 카페그라쎄를 이용해주세요! ','회의실,세미나실,낙성대,미팅,카페','*147570379510220.jpg',0,sysdate);
Insert into PRIVATE_CAFE (PCAFE_NUM,U_UID,PCAFE_NAME,PCAFE_ADDRESS,PCAFE_PHONE,PCAFE_TIME,PCAFE_URL,PCAFE_INTRODUCE,PCAFE_HASH_TAG,PCAFE_IMG,PCAFE_VISIT,PCAFE_REG_DATE) values (private_cafe_seq.nextval,'5','       비올즈으','서울특별시 관악구 행운동 1686-11 B1층','050-7462-0060','10:00AM ~ 11:00PM','http://www.beols.com ','관악구의 행운동에 위치한 꽃 향기 가득한 공간, 비올즈입니다.꽃과 커피를 함께 즐길 수 있으며, 아기자기한 소품들이 편안한 느낌을 주는 공간입니다.워크샵, 소규모 공연장 등 다양한 용도로 공간을 활용하실 수 있습니다. 주차시설이 마련되어 있어 매우 편리하며, 화이트보드와 복사기도 이용하실 수 있습니다.
따로 꾸미지 않아도 이미 아름다운 공간 비올즈에서 우아한 모임을 가져보는 건 어떠세요?  ','플라워카페,비올즈,관악구카페','147571706938940.jpg',0,sysdate);
Insert into PRIVATE_CAFE (PCAFE_NUM,U_UID,PCAFE_NAME,PCAFE_ADDRESS,PCAFE_PHONE,PCAFE_TIME,PCAFE_URL,PCAFE_INTRODUCE,PCAFE_HASH_TAG,PCAFE_IMG,PCAFE_VISIT,PCAFE_REG_DATE) values (private_cafe_seq.nextval,'5','coffe콩house','서울특별시 관악구 봉천동 1666-32','02-889-0981','8:00AM ~ 10:30PM','http://','  서울대입구역 근처에 위치한 스터디카페입니다.
좌식카페라 앉아서 공부하기도 좋고 노트북 들고가서 영화보기도 좋은 분위기입니다.
친구와의 수다를 원하시면 2층에 편안하게 소파에 앉으시면 되니 1석2조의 카페입니다',' 서울대입구카페,좌식카페,커피콩하우스','*147570389208424.jpg',0,sysdate);
Insert into PRIVATE_CAFE (PCAFE_NUM,U_UID,PCAFE_NAME,PCAFE_ADDRESS,PCAFE_PHONE,PCAFE_TIME,PCAFE_URL,PCAFE_INTRODUCE,PCAFE_HASH_TAG,PCAFE_IMG,PCAFE_VISIT,PCAFE_REG_DATE) values (private_cafe_seq.nextval,'5','아모르미오','서울 관악구 행운2길 20 태화빌딩 1층','070-8229-1456','6:00AM ~ 9:00PM','http://','가로수길에 이어 요즘 뜨는 핫플레이스
서울대의 샤(ㅅF)에 가로수길이 합해진 샤+로수길! 샤로수길에서 신선한 커피로 유명한 아모르 미오(Amor Mio) 2012년 한국 바리스타 챔피언쉽 우승자인 바리스타가 지난해에 오픈한 카페에요.
주택가 사이에 있지만 커피 마니아들 사이에서는 이미 입소문을 탄 곳입니다.    ','샤로수길커피,낙성대카페,서울대입구카페,아모르미오','*14757039403531.png',0,sysdate);
Insert into PRIVATE_CAFE (PCAFE_NUM,U_UID,PCAFE_NAME,PCAFE_ADDRESS,PCAFE_PHONE,PCAFE_TIME,PCAFE_URL,PCAFE_INTRODUCE,PCAFE_HASH_TAG,PCAFE_IMG,PCAFE_VISIT,PCAFE_REG_DATE) values (private_cafe_seq.nextval,'5','힐링카페 멘토','서울마포구 서교동 364-22','070-8879-7676 ','6:00AM ~ 9:00PM','http://    ','연인들의 데이트코스로 유명한 홍대멘토입니다.
심리상담과 커플 성격유형멘토링 전문 카페 입니다.','홍대놀거리,심리치유카페,홍대이색데이트   ','*14757039789771.jpg',0,sysdate);
Insert into PRIVATE_CAFE (PCAFE_NUM,U_UID,PCAFE_NAME,PCAFE_ADDRESS,PCAFE_PHONE,PCAFE_TIME,PCAFE_URL,PCAFE_INTRODUCE,PCAFE_HASH_TAG,PCAFE_IMG,PCAFE_VISIT,PCAFE_REG_DATE) values (private_cafe_seq.nextval,'5','눈탱이감탱이','서울 서대문구 연세로5길 26','02-3144-3760','6:00AM ~ 9:00PM','http://www.noongam.co.kr/','이색데이트  ','신촌데이트,암흑카페,무한도전암흑','*147570401586121.jpg',0,sysdate);
Insert into PRIVATE_CAFE (PCAFE_NUM,U_UID,PCAFE_NAME,PCAFE_ADDRESS,PCAFE_PHONE,PCAFE_TIME,PCAFE_URL,PCAFE_INTRODUCE,PCAFE_HASH_TAG,PCAFE_IMG,PCAFE_VISIT,PCAFE_REG_DATE) values (private_cafe_seq.nextval,'5','리얼이스케이프첼린지','서울특별시 마포구 서교동 339-5','02-333-3882','10:00AM ~ 12:00AM',' http://www.rec-escape.com/ ','리얼 웰메이드 방탈출!
제한시간 60분, 방 안의 단서들을 찾아내 문제를 해결하고 방을 탈출하라! 흥미 가득한 게임, 색다른 테마, 친절한 스탭들이 여러분을 기다립니다.홍대에서 가장 즐겁고 잊지 못할 추억을 찾는다면  리얼 이스케이프 첼린지로 오세요!','홍대방탈출카페,홍대이색데이트,홍대이색카페','*147570406857836.jpg',0,sysdate);
Insert into PRIVATE_CAFE (PCAFE_NUM,U_UID,PCAFE_NAME,PCAFE_ADDRESS,PCAFE_PHONE,PCAFE_TIME,PCAFE_URL,PCAFE_INTRODUCE,PCAFE_HASH_TAG,PCAFE_IMG,PCAFE_VISIT,PCAFE_REG_DATE) values (private_cafe_seq.nextval,'5','미스터리룸이스케이프','서울특별시 마포구 서교동 407-27 5층','02-323-1314','10:30AM ~ 11:00PM','http://www.mysteryroomescape.com/ ','Mystery Room Escape에서 놀라운 경험을 체험 해보세요. 여러분에게 주어진 시간 단 60분동안, 주어진 미션을 해결하고 탈출하세요.
Mystery Room Escape는 고객의 귀중한 의견을 듣고 최고의 서비스를 제공하기 위해 최선을 다하겠습니다. Mystery Room Escape는 방 탈출이라는 새로운 개념과 최신 기술력으로 완벽하게 결합하였습니다. 홍대/강남/광주 충장로/부산 /전주 방탈출 이스케이프 카페 입니다.각종 수수께끼 및 힌트를 이용하여 간단하게 자물쇠를 푸는 초급방식 개념의 벽을 넘어 신비함 놀라움 재미 웃음 등의 개념들을 활용한 현 시대의 과학기술과 결합한 
방 탈출 게임입니다','홍대,방탈출게임,미스터리룸   ','*147570410631645.png',0,sysdate);
Insert into PRIVATE_CAFE (PCAFE_NUM,U_UID,PCAFE_NAME,PCAFE_ADDRESS,PCAFE_PHONE,PCAFE_TIME,PCAFE_URL,PCAFE_INTRODUCE,PCAFE_HASH_TAG,PCAFE_IMG,PCAFE_VISIT,PCAFE_REG_DATE) values (private_cafe_seq.nextval,'5','반지카페         ','서울특별시 마포구 잔다리로6길 40-6','02-1577-9520','9:00AM ~ 9:00PM','http://  ','커플링 맞추려 할 때 가격이 부담스러워서 망설이셨던 분들 커플링인 만큼 좀 더 특별하게 손 수 제작하고 싶으신 분들께 강추입니다. 순은 99.9% 커플링 2인에 43,000원이면 정말 저렴하지 않나요, 
꼭 진지하게 커플링 맞추는 게 아니더라도 새로운 데이트코스로도 가볼만한 곳인 것 같습니다.',' 홍대,반지카페,수제커플링,홍대데이트,홍대이색데이터','*147570417532912.jpg',0,sysdate);
Insert into PRIVATE_CAFE (PCAFE_NUM,U_UID,PCAFE_NAME,PCAFE_ADDRESS,PCAFE_PHONE,PCAFE_TIME,PCAFE_URL,PCAFE_INTRODUCE,PCAFE_HASH_TAG,PCAFE_IMG,PCAFE_VISIT,PCAFE_REG_DATE) values (private_cafe_seq.nextval,'5',' 온더비1','서울 강남구 역삼1동 830-28포란빌딩     ','02-3452-1017  ','10:00AM ~ 9:00PM','없음','온더비는 커피음료를 주로 취급하고 있습니다.',' 역삼동,온더비','147570420526336.jpg',0,sysdate);
Insert into PRIVATE_CAFE (PCAFE_NUM,U_UID,PCAFE_NAME,PCAFE_ADDRESS,PCAFE_PHONE,PCAFE_TIME,PCAFE_URL,PCAFE_INTRODUCE,PCAFE_HASH_TAG,PCAFE_IMG,PCAFE_VISIT,PCAFE_REG_DATE) values (private_cafe_seq.nextval,'5','커피메이플        ','서울 영등포구 신길동 424-10  ',' 010-7621-1916 ','9:00AM ~ 9:00PM','없음                                  ','깔끔한 분위기를 원하시나요? 바로 이곳입니다.  ','커피메이플,신풍역,커피,디저트  ','*147570424076049.jpg',0,sysdate);
Insert into PRIVATE_CAFE (PCAFE_NUM,U_UID,PCAFE_NAME,PCAFE_ADDRESS,PCAFE_PHONE,PCAFE_TIME,PCAFE_URL,PCAFE_INTRODUCE,PCAFE_HASH_TAG,PCAFE_IMG,PCAFE_VISIT,PCAFE_REG_DATE) values (private_cafe_seq.nextval,'5','이에이티 카페잇 ',' 서울 강남구 논현동 234-27 명진빌딩 4층','02-1577-9520 ','9:00AM ~ 1:00AM','없음 ','열정가득한 직원들이 함께합니다    ','카페잇,이에이티,국립의료원 ','*147570428328133.jpg',0,sysdate);
Insert into PRIVATE_CAFE (PCAFE_NUM,U_UID,PCAFE_NAME,PCAFE_ADDRESS,PCAFE_PHONE,PCAFE_TIME,PCAFE_URL,PCAFE_INTRODUCE,PCAFE_HASH_TAG,PCAFE_IMG,PCAFE_VISIT,PCAFE_REG_DATE) values (private_cafe_seq.nextval,'5','카페잇브레드','대구 중구 삼덕동1가 14-1번지 ','053-766-0190  ','10:30AM ~ 12:00AM','없음','   동성로 카페 잇브레드로 놀러오세요   ','동성로,카페잇브레드,친절함','*147570432308939.jpg',0,sysdate);
Insert into PRIVATE_CAFE (PCAFE_NUM,U_UID,PCAFE_NAME,PCAFE_ADDRESS,PCAFE_PHONE,PCAFE_TIME,PCAFE_URL,PCAFE_INTRODUCE,PCAFE_HASH_TAG,PCAFE_IMG,PCAFE_VISIT,PCAFE_REG_DATE) values (private_cafe_seq.nextval,'5','비루개          ','경기도 남양주시 별내면 용암비루개길 219-88 ','031-264-8523','9:00AM ~ 10:00PM','없음','식물원을 개조해서 만든 곳이라 곳곳에 식물들이 많고, 편하게 앉거나 누워서 쉴 수 있는 공간이 많습니다. 분위기에 취해보고 싶으시면 놀러오세요.','식물원카페,비루개,경기','*147570435528710.png',0,sysdate);
Insert into PRIVATE_CAFE (PCAFE_NUM,U_UID,PCAFE_NAME,PCAFE_ADDRESS,PCAFE_PHONE,PCAFE_TIME,PCAFE_URL,PCAFE_INTRODUCE,PCAFE_HASH_TAG,PCAFE_IMG,PCAFE_VISIT,PCAFE_REG_DATE) values (private_cafe_seq.nextval,'5','설심당          ','제주특별자치도 제주시 도남동 663-9   ',' 064-722-3655  ','10:00AM ~ 10:00PM','없음',' 깔끔하고 인테리어와 분위기가 좋은 제주도의 예쁜카페 설심당입니다. 갤러리 분위기로 다양한 그림들을 구경 할 수 있습니다. 건강한 디저트를 제공하기 때문에 남녀노소 나이불문하고 다 마음에 드실거에요~
놀러오세요~','설심당,제주도,디저트','*147570439098224.jpg',0,sysdate);
Insert into PRIVATE_CAFE (PCAFE_NUM,U_UID,PCAFE_NAME,PCAFE_ADDRESS,PCAFE_PHONE,PCAFE_TIME,PCAFE_URL,PCAFE_INTRODUCE,PCAFE_HASH_TAG,PCAFE_IMG,PCAFE_VISIT,PCAFE_REG_DATE) values (private_cafe_seq.nextval,'5','더커피빌리지       ','경기도 용인시 처인구 모현면 오산리 17-4   ','031-467-8348  ','9:00AM ~ 9:00PM','없음',' 풍부한 주변 경관을 가지고 있는 경기도 광주 카페로 놀러오세요','경기도,광주카페,더커피빌리지,디저트  ','*147570442288635.jpg',0,sysdate);
Insert into PRIVATE_CAFE (PCAFE_NUM,U_UID,PCAFE_NAME,PCAFE_ADDRESS,PCAFE_PHONE,PCAFE_TIME,PCAFE_URL,PCAFE_INTRODUCE,PCAFE_HASH_TAG,PCAFE_IMG,PCAFE_VISIT,PCAFE_REG_DATE) values (private_cafe_seq.nextval,'5','롱롱디저트카페      ','천안                                 ','041-561-2212  ','11:00AM ~ 9:00PM','없음','매주 일요일 휴무 주차는 맞은편 혜강병원 뒷쪽 골목 주차장을 이용하시거나, 
포장 구매의 경우 가게 왼편 합판집에 잠지 주차 가능합니다.',' 롱롱디저트카페,디저트카페롱롱,천안카페,예쁜카페,개인카페,머랭쿠키','*147570445478825.jpg',0,sysdate);
Insert into PRIVATE_CAFE (PCAFE_NUM,U_UID,PCAFE_NAME,PCAFE_ADDRESS,PCAFE_PHONE,PCAFE_TIME,PCAFE_URL,PCAFE_INTRODUCE,PCAFE_HASH_TAG,PCAFE_IMG,PCAFE_VISIT,PCAFE_REG_DATE) values (private_cafe_seq.nextval,'5','Cafe O Clock ','서울특별시 강서구 내발산동 719-1 ','02-6338-7252 ','9:00AM ~ 1:00AM','http://',' 우장산역 미피 바로 맞은편에 위치하고 있으며, 분위기가 굉장히 좋아서 공부하러 오시는분들 즐겁게 떠들러 오시는 분들 
각양각색의 사람들이 많이 오십니다.  디저트 중 샌드위치는 양도 많도 자신이 넘치는 메뉴입니다','우장산역카페,카페어클락,클럽샌드위치,자몽주스','*147570455115529.jpg',0,sysdate);
Insert into PRIVATE_CAFE (PCAFE_NUM,U_UID,PCAFE_NAME,PCAFE_ADDRESS,PCAFE_PHONE,PCAFE_TIME,PCAFE_URL,PCAFE_INTRODUCE,PCAFE_HASH_TAG,PCAFE_IMG,PCAFE_VISIT,PCAFE_REG_DATE) values (private_cafe_seq.nextval,'5','카페인','서울시 강서구','000','9:00AM ~ 1:00AM','없음','ㅇㅇ','ㅇㅇ,ㅇㅇ,ㅇㅇ','*14757278453421.jpg',0,sysdate);