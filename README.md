# 영화 정보 관리 시스템 구축

1. 해당 습작을 진행한 목적 : COS 라이브러리를 이용한 파일 업로드 및 데이터베이스 커넥션 풀을 이용한 CRUD 연습

2. 간단한 프로젝트 소개
- movieList.do에서 데이터베이스에 저장된 영화 목록을 보여줌
- movieList.do에서 정보 등록을 누르면, 영화 정보를 입력하는 페이지로 이동 후, 서블릿과 연동하여 dao 객체를 통해 데이터베이스에 영화 정보 추가
- movieList.do에서 정보 수정을 누르면, dao객체를 이용하여 DB에서 수정하려는 레코드 정보를 읽어와서 수정 페이지에 보여주고, 수정되는 정보는 DB에 갱신
- movieList.do에서 정보 삭제를 누르면, dao객체를 이용하여 DB에서 해당 레코드를 삭제

3. (추후 추가 예정) 보완할 점

4. 결과물
- 초안(2021.06.14) : ![](https://github.com/hy6219/MovieInfoManagement/blob/master/MovieManage.gif?raw=true)