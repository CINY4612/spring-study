## 용어

### Advice

- 횡단적 관심사의 구현 메서드
- 로그 출력 및 트랜잭션 제어
- @Before, @AfterReturning, @AfterThrowing, @After, @Around 등 중심적 관심사 기준 횡단적 관심사가 실행할 시점을 표현

### Aspect

- 어드바이스를 정리한 클래스

### JoinPoint

- 중심적인 관심사에 적용하는 타이밍
- 메서드 실행 전, 실행 후 등

### Pointcut

- 어드바이스를 삽입할 수 있는 위치
- 메서드 이름에 따른 처리 조건 지정 등

### Interceptor

- 처리의 제어를 인터셉트하기 위한 구조 또는 프로그램

### Target

- 어드바이스가 도입되는 대상