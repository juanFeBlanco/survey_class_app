package co.domi.survey_class_app;

public class Student {
    private String code;
    private String name;
    private int preparationLevel;
    private int selfEvaluation;

    //constructor
    public Student(String name, String code){
        this.name = name;
        this.code = code;
        preparationLevel = 0;
        selfEvaluation = 0;
    }

    public String toString(){
        return name + ":" + code + ":" + preparationLevel + ":" + selfEvaluation;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getPreparationLevel() {
        return preparationLevel;
    }

    public void setPreparationLevel(int preparationLevel) {
        this.preparationLevel = preparationLevel;
    }

    public int getSelfEvaluation() {
        return selfEvaluation;
    }

    public void setSelfEvaluation(int selfEvaluation) {
        this.selfEvaluation = selfEvaluation;
    }
}
