package org.example.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();


        //creating object;\
        Answer answer = new Answer(203, "Java is programming lang!!");

        Question question = new Question(1, "what is Java?", answer);
        answer.setQuestion(question);

        Answer answer2 = new Answer(204, "Java Framework");

        Question question2 = new Question(2, "what is Collections?", answer2);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(answer);
        session.save(question);
//        session.save(answer2);
//        session.save(question2);

        tx.commit();

        Question question1 = (Question) session.get(Question.class, 1);
        System.out.println(question1.getAnswer().getAnswer());
        session.close();


        factory.close();
    }
}
