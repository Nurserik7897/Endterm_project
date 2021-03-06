package com.company.repository;

import com.company.bean.Question;
import com.company.database.IDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionRepository implements QuestionInterface {

    private IDB db;

    public QuestionRepository(IDB db) {
        this.db = db;
    }

    @Override
    public Question getQuestion(int id) {

        Connection con = null;

        try {
            con = db.getConnection();

            String sql = "SELECT * FROM question WHERE id=" + id;
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                Question question = new Question(
                        rs.getInt("id"),
                        rs.getString("question"),
                        rs.getString("answer"),
                        rs.getString("option1"),
                        rs.getString("option2"),
                        rs.getString("option3"),
                        rs.getString("option4")
                );

                return question;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public ArrayList<Question> getAllQuestions() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM question";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            ArrayList<Question> questions = new ArrayList<>();
            while (rs.next()) {
                Question question = new Question(
                        rs.getInt("id"),
                        rs.getString("question"),
                        rs.getString("answer"),
                        rs.getString("option1"),
                        rs.getString("option2"),
                        rs.getString("option3"),
                        rs.getString("option4")
                );

                questions.add(question);
            }

            return questions;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean createQuestion(Question question) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO question(question, answer, option1, option2, option3, option4) " +
                    "VALUES (?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, question.getQuestion());
            st.setString(2, question.getAnswer());
            st.setString(3, question.getOption1());
            st.setString(4, question.getOption2());
            st.setString(5, question.getOption3());
            st.setString(6, question.getOption4());

            return st.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
}

