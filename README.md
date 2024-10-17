# java-calculator-precourse

## AngularJs Git Comment Convention
### **기본 형태**
```
<type>(<scope>): <subject>
<BLANK LINE>
<body>
<BLANK LINE>
<footer>
```
### **개요**

`<BLANK LINE>`을 기준으로 Subject line, Message body, Message footer로 구분합니다.

### **Subject line**

변경에 대한 간결한 설명을 작성합니다.

#### `<type>`에 들어갈 수 있는 것
- feat(기능)
- fix(버그 수정)
- docs(문서화 관련)
- style(인덴트 같은 포맷팅, 빠진 세미콜론 등)
- refactor
- test(빠진 테스트를 추가할 때)
- chore(maintain)

*엥 그러면 추가하기로 계획된 테스트는 그냥 feat로 넣는 건가?* => GPT는 아니라고 합니다

#### `<score>` 에 들어갈 수 있는 것

커밋의 변경 사항이 적용되는 지점이라면 어디든 가능합니다. 예를 들면, 위치/브라우저/메소드이름/클래스이름 등

#### `<subject>` 작성 시 유의 사항
- 현재시제와 명령문을 사용합니다.
- 첫번째 문자를 대문자로 쓰지 않습니다.
- 마지막에 .을 붙이지 않습니다.

### **Message body**
- 현재시제와 명령문을 사용합니다.
- 수정 이유와 수정 이후 어떻게 변했는지도 씁니다.

### **Message footer**

#### Breaking chagnes
모든 주요 변경점(Breaking changes)은 다음 내용들과 함께 footer에 명시되어야 합니다.
- 변경점
- 변경 사유
- 변경 방법(지시)

#### Referencing issues
버그에 대한 해결 시, 해당 이슈를 Closes 키워드와 함께 표시합니다.

```
Closes #234, #456
```
