# VideoRental
** 변경된 코드는 develop branch에 올려두었습니다. 

1. UI와 Logic 분리
- VRControl 클래스 추가하여 VRUI내 Logic 부분 분리

2. Video의 하위 클래스로 DvdVideo, CdVideo, VhsVideo 생성
- Video Type에 따른 Switch문을 상속을 이용하여 변경
- Video 인스턴스를 factory로 생성

3. Duplicate Code 제거
- VRUI의 clearRentals(), getCustomerReport(), returnVideo() 메소드에서 Customer를 탐색하는 코드를 VRControl 클래스의 findCustomer 메소드로 구현하여 중복되는 코드 제거함

4. Collection 관리
- get 수행시 read only
- set 함수 제거
- add 함수 제공

5. magic number num 및 함수 변경
- rental status 관련 enum 사용 및 해당 클래스에서 함수 제공으로 변경
