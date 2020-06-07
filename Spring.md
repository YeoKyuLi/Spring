# Online Education - Spring Guide (2020.06.07)

### Site

https://github.com/cheese10yun/spring-guide



### Layer VS Domain

1. Layer
  장점 : 전체적인 구조를 빠르게 파악 가능

  ​			작성하고자는 계층이 명확한 경우 빠르게 개발 가능

  단점 : 코드 파악이 어려움, Layer를 기준으로 분리했기 떄문에 토드의 응집력이 떨어짐

2. Domain

   장점 : 관련된 코드들이 응집해 있음

   ​		  디렉토리 구조를 통해 도메인을 이해할 수 있음

   단점 : 도메인 지식 없이 이해하기 어려움

   ​			각 계층을 구분하기 위한 논의가 필요

```
Domin  : 도메인 담당
Global : 프로젝트의 전체담당
				- common : 공통으로 사용되는 value
				- config : 스프링 각종 설정
				- error  : 예외 핸들링하는 클래스
				- util   : 유틸성 클래스들의 위치
Infra  : 외부 인프라스트럭처 담당
```



강한 결합 관계 : 나의 조건의 다른 친구들로부터 파생될때



### Lombok

- @Data는 지양하자 : @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstrcutor
- @Setter : 의도가 분명하지 않고 객체를 언제든지 변경할 수 있는 상태가 되어서 객체의 안전성을 보장받기 힘듬.
- @ToString 양방향 순환 참조 문제: 무한 순환 참조를 발생 --> 서로 주소값을 참조하기 떄문에, JPA를 사용하다 보면 객체를 Json으로 직렬화 하는 가정에서 발생하는 문제와 동일한 이유
- @EqualsAndHashCode의 남발: Lombok에서 자동으로 생성하는 *.class 파일을 한번 씩 보는 것을 권장
- 클래스 상단의 @Builder는 지양하자 --> @AllArgsCOnstructor효과 발생, 모든 멤버 필드에 대해서 배개변수를 받는 기본 생성자를 만듬. --> 비지니스 로직에 맞게 필수 값에 대해서만 생성자를 여러둔다.
- @Builder.Default는 지양하자 --> 코드 예측이 어렵다





### 객체지향

- 객체를 상태와 행동을 함께 지닌 실체라고 정의
- 객체가 협력에 참여하는 과정에서 스스로 판단하고 스스로 결정하는 자율적인 존재로 남기 위해서는 필요한 행동과 상태를 함께 지니고 있어야한다.



