# 1. introduction
여기 있는 규칙을 만족하면 Google Style을 준수한다고 할 수 있음

다른 프로그래밍 언어 스타일 가이드처럼, 예쁘게 포맷팅하는 것 뿐 아니라 다른 종류의 코딩 컨벤션 등도 다룸.

그러나 이 문서의 주요 목적은 우리가 항상 따르는 strict한 규칙에 초점이 맞춰져 있습니다. 또한, 명확하게 따라할 수 없는 조언은 피하고 있습니다.

## 1.1 용어 사전
이 문서에서 우리가 따로 명시하지 않는다면,
1. 클래스(class)는 일반적인 클래스, enum, interface를 의미합니다.
2. 멤버(member)는 중첩 클래스, 멤버 변수, 메서드, 생성자를 의미합니다. 즉, 주석과 초기화 블럭을 제외하면 클래스의 가장 윗단 구성요소들을 의미합니다.
3. 주석(comment)는 항상 구현부에 있는 주석을 의미합니다. 문서용 주석은 Javadoc라고 부릅니다.

## 1.2 주의사항
이 문서에 있는 예제 코드는 비표준입니다. 즉, 예제들이 Google Style은 맞지만, 코드를 표현하는 유일한 스타일은 아닙니다. 예제에서 몇가지 필수가 아닌 선택들이 있는데, 이런 것들은 규칙으로 강제되면 안됩니다.

# 2. Source file basics
## 2.1 File name
소스파일 이름은, 그 파일이 포함한 유일한 하나의 클래스 이름을 대소문자를 지킨 뒤 뒤에 .java를 붙인 것입니다.
## 2.2 File encoding
소스파일은 UTF-8로 인코딩 됩니다.
## 2.3 Special Characters
### 2.3.1 Whiltespace Characters
개행문자를 제외하고, 소스파일에서 등장할 수 있는 공백문자는 아스키 코드로 0x20으로 표현되는 공백문자입니다.

이 말은 곧,
1. string이나 char 리터럴에 포함되는 다른 형태의 공백문자(개행, 탭 등)는 escape 형태로 표현되야합니다.
2. 탭은 인덴트에 활용되지 않습니다.
라는 걸 의미합니다.

### 2.3.2 Special escape sequences
\b, \t, \n, \f, \r, \", \', \\와 같은 이스케이프 시퀀스들 대신 octal(eg. \012)이나 unicode(\u000a) 이스케이프를 사용하지 말아야 합니다.

### 2.3.3 Non-ASCII characters
다른 아스키 문자들에 대해서는 진짜 유니코드 문자 자체도 좋고, 아니면 이스케이프 형태를 써도 좋습니다. 오직 가독성에 초점을 맞춰서 알아서 선택해서 쓰세요.

물론, 이스케이프 형태는 매우 권장하지 않습니다.

Tip : 이스케이프 형태를 쓰거나, 아니면 유니코드 문자 자체를 쓰더라도(유니코드라서 처음보는 문자일 수 있음) 설명을 달아주면 좋아 죽습니다.

| 예시                                                       | 설명                                            |
|----------------------------------------------------------|-----------------------------------------------|
| `String unitAbbrev = "μs";`                              | 아주 좋습니다. 주석도 필요 없어요.                          |
| `String unitAbbrev = "\u03bcs"; // "μs"`                 | 허용은 하는데, 왜 굳이 이렇게?                            |
| `String unitAbbrev = "\u03bcs"; // Greek letter mu, "s"` | 허용은 하는데, 좀 어색하고 실수유발하기 좋음                     |
| `String unitAbbrev = "\u03bcs";`                         | 구림. 읽는 사람은 이게 전혀 뭔지 모름                        |
| `return '\ufeff' + content; // byte order mark`          | 좋습니다. 프린트 불가능한 문자는 이스케이프를 쓰고, 필요하다면 주석을 다세요. |


Tip : 특정 프로그램이 유니코드 문자열을 해독하지 못할까봐 두려워서 이스케이프를 쓰는 일은 없어도 됩니다. 그런 프로그램들이 수정될 거니까요.

# 3. Source file structure
소스파일은 아래 순서대로 구성됩니다.
1. 존재한다면, 라이센스나 저작권
2. 패키지 구문
3. import 구문
4. 딱 1개의 클래스
각 부분들은 정확히 1개의 공백 라인으로 구분됩니다.

## 3.1 License or copyright information, if present
파일에 라이센스나 저작권에 관한 내용이 있다면, 여기에 적으세요.

## 3.2 Package statement
패키지 구문은 줄을 바꾸지 않습니다(개행 없음). 4.4에 100글자 넘으면 개행해라 라는 규칙이 있는데 이것도 적용되지 않습니다.

## 3.3 Import statements
### 3.3.1 No wildcard imports
wildcard import(sample.package.name.* 처럼 *을 써서 전부 다 import 해버리는 것)를 쓰지 마세요. static도 포함입니다.

### 3.3.2 No line-wrapping
import 구문도 패키지 구문처럼 줄을 바꾸지 않습니다(개행 없음). 4.4에 100글자 넘으면 개행해라 라는 규칙이 있는데 이것도 적용되지 않습니다.

### 3.3.3 Ordering and spacing
import 구문들은 아래와 같은 순서로 정렬되어야 합니다.

1. 모든 static import 구문들을 모은 블럭.

2. 모든 non-static import 구문들을 모은 블럭.

만약 static import 블럭이랑 non-static import 블럭이 둘 다 있는 경우, 이 둘을 1개의 공백 라인으로 구분해야 합니다.

참, 이 사이에 있어야 한다는 거고 다른 import 구문에는 없어야 합니다.

각 블럭 안에서는 ASCII 문자 순서대로 정렬됩니다.

import 뒤에 나오는 이름들의 ASCII 순서대로 정렬된다는 겁니다(? 이 부분은 정말 잘 모르겠습니다.)

### 3.3.4 No static import for classes
static import는 정적 중첩 클래스(static nested class)를 위해 쓰이지 않습니다. 얘들도 그냥 import를 써야 합니다.

## 3.4 Class declaration
### 3.4.1 Exactly one top-level class declaration
소스파일에는 하나의 클래스만 선언되어 있어야 합니다.

### 3.4.2 Ordering of class contents
클래스 안에서 변수나 초기화 블럭을 배열하는 순서는, 가독성에 큰 영향을 줍니다. 근데 딱히 정해진 방법은 없긴 하죠.

중요한 건, 누가 물어보면 대답할 수 있게 논리적인 순서로 배열해야 한다는 겁니다. 예를 들어 습관적으로 새로운 메서드를 맨 밑에 추가했다면, 그건 "추가한 순서대로 정렬"인데, 이건 누가봐도 논리적이지 않죠.

#### 3.4.2.1 Overloads: never split
클래스의 메서드 중 특정한 이름을 공유한다면 연속해서 작성하세요. 당연히 생성자도 포함입니다. 심지어 static이나 private 같은 게 다르더라도요.

# 4. Formatting
용어 안내 : block-like construct는 
Terminology Note: block-like construct라는 말은 클래스나 메서드, 생성자의 본문을 의미합니다. 4.8.3.1에 나와용~(에 그 전에도 나오네요)

## 4.1 Braces
### 4.1.1 Use of optional braces
괄호는 if, else, for, do, while 문에서 쓰입니다. 내용이 비거나 한 줄 밖에 없어도 씁니다.

람다 같은 선택 가능한 괄호들은 알아서 하세요.

### 4.1.2 Nonempty blocks: K & R style
괄호는 비어있지 않은 블럭이나 block-like construct에 대해 K & R 스타일(이집트 괄호법?)을 따릅니다.

여는 괄호 앞에서 개행하지 않기(예외 있긴 함. 밑에서 설명)

여는 괄호 이후에 개행하기.

닫는 괄호 이전에 개행하기.

만약 괄호가 표현 식이나, 메서드, 생성자, named class(익명 클래스 아닌 클래스 의미하는 것)를 종료시킬 땐, 닫는 괄호 이후에 개행하기. 그니까 콤마나 else 문 앞에서는 닫는 괄호 이전에 개행해야겠죠?

예외(? 뭔 소린 지 모르겠습니다.)

### 4.1.3 Empty blocks: may be concise
K & R style 대신에, 안에 아무 내용이 없는 블럭이나 block-like construct는 그냥 바로 괄호 닫는 걸 허용합니다. {} 이렇게요. (근데 if/else 같은 다중 블럭 표현 식은 제외합니다)

## 4.2 Block indentation: +2 spaces
새로운 블럭이나 block-like construct가 열릴 때마다, Indent는 2 space 문자 만큼 늘어납니다. 블럭이 닫히면 다시 이전 인덴트 만큼 돌아옵니다. 이건 코드 뿐 아니라 주석도 포함이예요.

(우테코는 4개의 space 문자입니다 = tab)

## 4.3 One statement per line
각 표현식의 뒤에는 개행이 있어야 합니다.

## 4.4 Column limit: 100
자바코드는 100글자가 넘으면 개행해야 합니다. 여기서 말하는 "글자"란 유니코드 point(?)를 말합니다. 예외는 아래와 같습니다.

각 유니코드 point는 그게 화면에 어떻게 표시되던 1 글자로 셉니다.

예외
1. column limit을 지킬 수 없는 경우(너무 긴 URL 등)
2. 패키지 구문 또는 import 구문(이건 3.2, 3.3 해당 항목에도 쓰여있습니다.)
3. shell에 복붙되어야 하는 command line을 주석에 달아놓은 경우
4. 엄청 긴 아이디나 이름인 경우

## 4.5 Line-wrapping
용어 안내 : 하나의 줄에 합법적으로(위에서 명시한 규칙대로) 잘 들어가는데도 불구하고 여러 라인으로 쪼개는 경우, 이를 line-wrapping이라고 합니다.

모든 상황 속에서 line-wrapping을 위한 완전하고, 확정적인 공식은 없습니다. 그냥 best practice들이 있습니다.

주의 : 웬만한 line-wrapping의 이유가 다 100글자 안 넘기 위해서겠지만(?? 위에 설명대로면 아니지 않나), 작성자 재량에 따라 그 전에 해도 됩니다.

Tip : 메소드나 지역변수로 빼내면 line-wrapping 할 필요가 없을 수 있습니다.

### 4.5.1 Where to break
line-wrapping을 위한 주요 힌트는 높은 문법 수준에서 끊어라입니다.

또한, 
1. 할당 연산자가 아닌 곳에서 개행하는 경우, 개행은 기호 앞에 와야 합니다.
   - 이건 아래 "연산자 닮은 꼴" 기호에도 적용됩니다.
     - dot (.)
     - 메소드 참조를 위한 콜론 2개 짜리 연산자 (::)
     - 진짜 살면서 한 번도 안써본 type bound 연산자 (&) (eg. <T extends Foo & Bar>)
     - catch 블럭에서의 파이프 (|) (eg. catch(FooException | BarException))
2. 할당 연산자에서 개행하는 경우, 일반적으로 개행은 기호 뒤에 옵니다. 근데 뭐 사실 앞에 와도 상관 없어요 ㅋ
   - 이건 이제 "할당 연산자 닮은 꼴" 기호인 콜론에도 적용됩니다. 그거 아시죠? 개선된 for(each)문에 쓰이는 그 콜론
3. 메소드나 생성자 뒤에 따라오는 괄호는 딱 붙어 있어야 합니다
4. 콤마도 앞에 나오는 애랑 딱 붙이 있어야 합니다
5. 람다의 화살표 뒤에서는 절대 개행되서는 안됩니다. 단, 한줄짜리 람다는 가능 ㅋ

주의 : line-wrapping의 가장 주요한 목적은 읽기 편한 코드를 작성하는 것이지, 라인 수 줄이는 게 아닙니다.

### 4.5.2 Indent continuation lines at least +4 spaces
line-wrapping을 할 때, 두번째 줄 부터는 첫번째 줄보다 최소 4 space는 떨어져 있어야 합니다.

여러 줄이면 아래 줄로 갈 수록 4 space보다 멀어지긴 하는데, 문법적으로 병렬적이면 그냥 4 space로 유지하세요. Stream 아시죠?
