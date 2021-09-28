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
    - 문제 관심 목록에 추가
    - 관심 목록 문제 모두 출력

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

# 서비스 사용 예시

## 메인 화면

![사용법1](https://user-images.githubusercontent.com/22315365/134948013-009a48b2-e596-4607-b1aa-765f03d07964.PNG)

## 회원 모드 

#### 로그인

![image](https://user-images.githubusercontent.com/22315365/135003498-0dbe57e4-0a1d-4f13-94b2-4794aa50e004.png)

### 로그인 이후 메뉴

![image](https://user-images.githubusercontent.com/22315365/134949161-f1f09a00-7f94-4a5d-a591-477191a3eaa8.png)

#### 1) 문제 추가 기능

![image](https://user-images.githubusercontent.com/22315365/134948533-42233d05-6935-4b32-8a8e-f8c2a3128776.png)

#### 2) 모든 문제 출력 결과

![image](https://user-images.githubusercontent.com/22315365/134948906-d591c0d2-9a92-4b32-ac3f-7932611b6620.png)

#### 3) 문제 랜덤 출력 결과

![image](https://user-images.githubusercontent.com/22315365/134949567-5f063505-e580-444b-8e15-037e66edbe57.png)

#### 4) 문제 관심 목록에 추가 기능

![image](https://user-images.githubusercontent.com/22315365/134949813-0075e966-2309-413c-88fa-e098923c663b.png)

#### 5) 관심 목록 문제 모두 출력

![image](https://user-images.githubusercontent.com/22315365/134949679-a587e6a1-be38-4bf8-964f-3b8f8ed37689.png)


## 비회원 실행

![image](https://user-images.githubusercontent.com/22315365/135003444-4a4dfcfa-a62e-4cee-a766-f29baf489867.png)

## 회원 가입

![image](https://user-images.githubusercontent.com/22315365/135003334-39925f68-a558-4ec2-91e5-78e9002986ef.png)


# 추가 개선 사항

- 기본 구조의 중복 코드를 제거하고 더 간결하게 리팩토링
- 테스트 코드 추가 구현
- 문제 마다 유형을 나타내는 태그 기능 추가
- 문제들을 패키지로 합칠 수 있는 기능 추가
