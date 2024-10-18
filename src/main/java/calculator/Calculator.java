package calculator;

public class Calculator {
    private UserInterface userInterface = new UserInterface();
    private Adder adder = new Adder();

    public int add() {
        // 캡슐화 굿, 응집도 애매... view랑 비즈니스 로직이 같이 있다, 결합도도 애매... 3개나 의존함
        // Adder로 비즈니스 로직 분리
        return adder.add(userInterface.getNumbers());
    }
}
