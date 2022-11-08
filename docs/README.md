###i# 언어에서 선언 가능한 것
- 기본 변수형
- 배열([])
- 참조(&)
- 포인터(*)

###특징
- 배열, 참조, 포인터는 순서에 상관 없이 혼합해서 사용할 수 있다
  - ex. `int&&[]*` : 정수형 변수의 참조의 참조의 배열의 포인터
- 여러개의 변수를 한줄에 정의할 수 있다. 공통된 변수형을 제일 먼저 쓰고, 각 변수의 이름과 추가적인 변수형을 쓰면 된다
  - ex. `int& a*[]&, b, c*;` : `int&&[]* a`, `int& b`, `int&* c`
  - 변수명의 반대편에 있는 변수형은 뒤집어서 반대편에 붙일 수 있다

###목적
- 한 줄에 여러개 선언된 변수를 각각 한 줄에 하나씩 선언한다
- 각각 한 줄로 선언할 때 오른편에 있는 변수형을 왼편으로 옮긴다

###입력
- 선언문 가장 처음에는 기본 변수형이 주어진다
- 그 다음으로 추가적인 변수형이 주어진다. 없을수도 있다
- 공백 이후 변수 선언이 하나씩 주어진다
  - 변수 선언은 `,`와 공백으로 나누어져 있다
  - `;`으로 끝난다
  - 기본 변수명과 변수명은 같지 않다
  - 각 줄의 길이는 120자를 넘지 않는다
###출력
- 변수형과 변수명 사이에는 하나의 공백이 있어야 한다
- 변수 선언문에서 변수가 선언된 순서대로 출력한다


###Process
1. 입력을 받는다
2. 공백이 나올때까지 변수형을 읽어들인다. 이때 읽어들인 문자가 공통 변수형이다
3. 문자를 읽어들이다 공백 이외의 문자가 발견되면 `,`가 나오기 전까지가 선언하는 변수이다
   1. `&`, `[]`, `*`이 나올때까지 문자를 읽는다. `&`, `[]`, `*`을 찾으면 그 부분을 기준으로 변수명, 변수형을 나눈다
   2. 읽어들인 변수형을 뒤집는다
   3. 공통 자료형 + 변수형 + 변수명으로 하나의 선언으로 바꾼다
   5. 결과 리스트에 삽입한다
4. 리스트를 순서대로 출력한다

###기능
####공백이 나올때까지 변수형을 읽어들인다. 이때 읽어들인 문자가 공통 변수형이다
`int findCommonTypeDivisionIndex(String input)`
- 공통 타입이 되는 부분을 구분하는, 공백 자리의 인덱스를 반환한다

`String getCommonType(int commonTypeDivisionIndex)`
- 구분 인덱스를 기준으로 처음부터 문자열을 잘라서 공통 변수형 부분을 반환한다

`String getRestString(int commonTypeDivisionIndex)`
- 공통 변수형 부분을 잘라내고 남은 나머지 부분을 반환한다

####문자를 읽어들이다 공백 이외의 문자가 발견되면 `,`가 나오기 전까지가 선언하는 변수이다
`int findVariableStartIndex(String restString)`
- 변수 선언이 시작되는 지점의 인덱스를 반환한다

`int findVariableEndIndex(String, restString, int startIndex)`
- 변수 선언이 끝나는 지점의 인덱스를 반환한다
  - `,` 가 있는 인덱스

`String getVariable(String restString, int startIndex, int endIndex)`
- 변수 선언부를 반환한다

####`&`, `[]`, `*`이 나올때까지 문자를 읽는다. `&`, `[]`, `*`을 찾으면 그 부분을 기준으로 변수명, 변수형을 나눈다
`int findVariableNameIndex(String variable)`
- 변수명 부분의 인덱스를 반환한다

`String getVariableName(int variableNameIndex)`
- 변수명을 얻는다

`String getVariableType(int variableNameIndex)`
- 변수형을 얻는다

####읽어들인 변수형을 뒤집는다
`String reverseVariableType(String variableType)`

####공통 자료형 + 변수형 + 변수명으로 하나의 선언으로 바꾼다
`String combineVariable(String commonType, String variableType, String variableName)`

