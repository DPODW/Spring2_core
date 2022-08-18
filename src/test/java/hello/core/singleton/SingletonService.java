package hello.core.singleton;

public class SingletonService {

    //1. static 영역에 싱글톤 객체를 1개 생성해둔다
    private static final SingletonService instance = new SingletonService();

    //2. 외부에서 해당 싱글톤 객체가 필요하면, 해당 static메소드를 통해서만 조회할수 있도록 한다. (고로 public)
    public static SingletonService getInstance() {
        return instance;
    }

    // 3. 생성자를 private로 선언해서 외부에서 new 키워드를 활용한 객체 생성을 못하게 막는다
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }



}
