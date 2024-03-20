package personAndProblem;

public class Problem {
    private String name;
    private final Type type;
    private boolean isSolved;



    public Problem(String name, Type type){
        this.name = name;
        this.type = type;

    }


    public boolean isSolved() {
        return isSolved;
    }

    public void changeStatus() {
        isSolved = true;
    }

    @Override
    public String toString(){
        return String.format("%s: %s", name, type);
    }

}
