# TechInterviewHelper

기술 면접 도와주는 서비스

기술 면접 대비를 위해 면접에서 나올만한 문제들을 저장, 조회하고 분야별로 분리하여 관리해주는 서비스

# 주요 기능

- 회원 관리
  - 회원에 대한 추가, 조회, 삭제, 수정 기능과 회원별 자신이 관심 있는 문제, 문제집 관리 기능
- 문제 관리
  - 문제에 대한 추가, 조회, 삭제, 수정 기능과 랜덤 조회, 분야(태그)별 관리 기능

# 시스템 동작 과정

### 메인 스레드
 - 회원 모드
   - 로그인 이후 회원별 문제 관리 서비스를 제공
 - 비회원 모드
   - 비회원들에게 제공하는 서비스로 랜덤으로 문제를 출력
 - 회원 가입
   - 처음 사용하는 유저가 가입할 수 있는 서비스

### 회원 모드
 - 문제 관리 기능
    - 문제 추가
    - 문제 전체 출력
    - 문제 랜덤 출력 

### 비회원 모드
 - 랜덤 문제 출력

# 사용 기술
- JDK 11
- Oracle, H2
- junit 4

# 클래스 다이어그램

![TechInterviewHelperServiceUML](https://user-images.githubusercontent.com/22315365/134883437-3ef255b5-33f8-46d4-ad36-5bc47da3d4fa.png)

# 테이블 구조

![TechInterviewHelper_dbTablepng](https://user-images.githubusercontent.com/22315365/134884254-4849e550-ffdb-4801-b586-75afbcf7367e.png)
