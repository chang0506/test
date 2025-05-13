## ER 다이어그램
<img width="1088" alt="스크린샷 2025-05-13 오후 5 26 13" src="https://github.com/user-attachments/assets/f3eec2bf-faaa-42e9-8432-bfa5f4206c13" />

--- 

## API 명세서
| 이름 | URI |
| ------- | --------|
|레스토랑 생성| api/test/restaurant|
|레스토랑 단건조회| api/test/restaurant/{id}|
|레스토랑 전체조회| api/test/restaurant|
|레스토랑 삭제| api/test/restaurant/{id}|

| 이름 | URI |
| ------- | --------|
|메뉴 생성| api/test/menu|
|메뉴 단건조회| api/test/menu/{restaurantId}/{id}|
|메뉴 전체조회| api/test/menu|
|메뉴 삭제| api/test/menu/{id}|

---

#### 짧은 소감
CRUD 구현을 하다 요구사항을 늦게 보고 수정하다 시간을 못지켰습니다...
완성이 제대로 안됐고 코드가 꼬여버렸지만 구조는 어느정도 파악할 수 있었습니다.

---

### 수정될 부분
업데이트 구현이 안되어있고 dto를 이용해 비즈니스 로직 구현할 때 레스토랑 아이디를 통해 메뉴 리스트가 보이는 구현
