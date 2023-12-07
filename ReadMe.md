### 구름 과제

---
1. 이름과 성적을 입력받아 저장하는 api
   - 성적의 입력은 특정 값이 넘었을 경우 에러응답이 나타나야합니다.
2. 입력된 성적을 조회하는 api
   - 성적의 오름차순으로 조회가 되어야합니다.
3. 특정 성적을 입력받아, 해당 성적의 학생만 조회하는 api
---
#### 구현 요구사항
1. Controller에서 응답모델 만들기
    1. ApiResponse<T> 여러가지 데이터타입을 result로 넣을 수 있도록 제네릭을 사용해서 구현
    2. makeResponse(T result), makeResponse(List<T> results): 결과를 응답객체로 만들어주기 위한 메서드

2. 에러응답을 만들기 위해서 @ExceptionHandler를 사용하여 exception의 데이터를 이용해야 합니다.
3.  exceptionHandler에서 응답 모델을 만들 때 필요한 데이터가 포함 시킬 수 있는 customException을 구현해야 합니다.
    - ErrorCode는 enum으로 정의합니다.

### (추가구현)
- grade 필드 기준 오름차순, 내림차순
- 특정 user grade 값 변경, username 변경
- SpringDataJpa, MySQL사용, TestCode 작성 