# Extension > Auth
> 권한 기능 관리  
> 권한과 관련된 Entity 의 권한과 관련된 기능을 정의  
> 권한이 경우 일반적인 인증인가와 gateway 에서 인증인가 처럼 같은 unit 기능을 사용하지만 비즈니스 로직이 다른경우가 있다.
> 다른 비즈니스 로직이지만 unit 기능들은 중복되기 때문에 최대한 관리 포인트를 한 곳으로 모으기 위한 모듈  
> 해당 모듈이 중복 코드에 대한 관리 포인트는 줄일 수 있지만 리소스 관리, 빠른 운영 대응, 배포 전략 등의 관점에서 본다면 차라리 중복코드가 나을 수 있다는 판단도 충분히 나올 수 있다.  
> 하지만 지금은 컴팩트하게 서비스를 운영해본 뒤 리펙토링을 통해 더 좋은 방향성을 찾기 위해서 중복 코드를 제거하는 방식이 가장 문제점 분석에 효과적이라고 생각했다.  
> 그래서 이와 같은 잉여 모듈이 만들어졌다.