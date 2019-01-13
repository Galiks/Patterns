package com.turchenkov.TemplateMethod;

public class Program {
    public static void main(String[] args) {
        School school = new School();
        school.learn();
        System.out.println();
        University university = new University();
        university.learn();
    }
}

abstract class Education{
    void learn(){
        enter();
        study();
        passExam();
        getDocument();
    }

    abstract void enter();
    abstract void study();
    abstract void passExam();
    abstract void getDocument();
}

class School extends Education{

    @Override
    void enter() {
        System.out.println("Start go to school");
    }

    @Override
    void study() {
        System.out.println("Start study in school");
    }

    @Override
    void passExam() {
        System.out.println("Pass exams in school");
    }

    @Override
    void getDocument() {
        System.out.println("Get document in school");
    }
}

class University extends Education{

    @Override
    void enter() {
        System.out.println("Start go to university");
    }

    @Override
    void study() {
        System.out.println("Start study in university");
    }

    @Override
    void passExam() {
        System.out.println("Pass exams in university");
    }

    @Override
    void getDocument() {
        System.out.println("Get document in university");
    }
}