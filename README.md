# java-calculator-precourse

## 기능 요구 사항 분석
1. 기본 덧셈 기능
   1. 사용자의 입력 수신.
   2. 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열 전달 시 구분자를 기준으로 숫자 분리.
   3. 분리한 숫자 간의 합 반환.

2. 커스텀 구분자 지정 기능
   1. 커스텀 구분자는 문자열 앞 부분의 "//"와 "\n" 사이에 위치하는 문자.

3. 사용자 입력 예외 처리
   1. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 발생시키고 애플리케이션 종료.<br>
   단, System.exit() 함수를 호출해 종료하면 안됨.
   
## 협력 설계
### 기본적인 도메인 개념
- 계산기
- 사용자인터페이스(버튼, 스크린)
- 입력값
- 구분자
- 숫자

### 도메인 개념 간의 관계 파악
계산기(1) - (1)사용자 인터페이스(1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;(1)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|<br>
&nbsp;&nbsp;&nbsp;&nbsp;(N)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(N)<br>
&nbsp;&nbsp;&nbsp;숫자(N)---------(1)입력값(1) - (1)구분자

### 기능별 구현 과정
1. 기본 덧셈 기능 협력 구상<br>
  '더해라()' -> 계산기 -> '입력받아라()' -> UI -> '<< crate >>' 입력값<br><br>
  계산기 -> '숫자 구분해라()' -> 입력값<br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;숫자&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<-<br><br>
  '계산 값' <- 계산기
2. 기본 덧셈 기능 구현 후 리팩토링<br>
   Calculator의 결합도를 낮추고, 응집도를 높임<br>
   1. 응집도 : UI 요소와의 조율 뿐 아니라 덧셈을 진행하는 비즈니스 로직을 Caculator가 모두 담당하는 문제 -> Adder로 비즈니스 로직을 분리해 응집도를 높임
   2. 결합도 : Calculator가 UserInterface, Adder, InputSequence, MyNumber에 의존하는 문제 -> UserInterface가 MyNumber에 의존하도록 변경해서 Calculator의 InputSequence로의 의존성 제거
   
   InputSequence가 MyRegex를 생성하는 과정에서 불필요한 분기문 제거
3. 커스텀 구분자 추가 기능 협력 구상<br>
   기존의 협력 구도에서, InputSequence가 Regex를 결정하는 구문 추가
4. 커스텀 구분자 추가 기능 구현 후 리팩토링<br>
   없음. 단, InputSequence의 책임이 더 많아지는 시기가 오면 분리 예정
5. InputSequence의 책임 분산
   '숫자 구분해라()' -> Regex를 찾고, Regex를 적용해 분리하고, 숫자로 변환해라<br>
   InputSequence는 그냥 삭제<br>
   3가지 책임을 Parser 내 객체(Splitter, Converter)로 분산<br>
   Regex를 찾고 분리하는 과정에서 다형성 적용<br>
   객체 생성의 책임을 SplitterFactory로 이동