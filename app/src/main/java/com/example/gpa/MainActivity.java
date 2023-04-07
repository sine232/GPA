package com.example.gpa;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText courseNameEditText, courseCreditEditText, courseGradeEditText;
    private Button addCourseButton, calculateGpaButton;
    private TextView gpaTextView;
    private ArrayList<Course> courseList = new ArrayList<>();
    private double totalGradePoints = 0, totalCredits = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courseNameEditText = findViewById(R.id.course_name_edittext);
        courseCreditEditText = findViewById(R.id.course_credit_edittext);
        courseGradeEditText = findViewById(R.id.course_grade_edittext);
        addCourseButton = findViewById(R.id.add_course_button);
        calculateGpaButton = findViewById(R.id.calculate_gpa_button);
        gpaTextView = findViewById(R.id.gpa_textview);

        addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = courseNameEditText.getText().toString();
                double credit = Double.parseDouble(courseCreditEditText.getText().toString());
                String grade = courseGradeEditText.getText().toString();
                Course course = new Course(name, credit, grade);
                courseList.add(course);
                courseNameEditText.getText().clear();
                courseCreditEditText.getText().clear();
                courseGradeEditText.getText().clear();
            }
        });

        calculateGpaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Course course : courseList) {
                    totalGradePoints += course.getGradePoints();
                    totalCredits += course.getCredit();
                }
                double gpa = totalGradePoints / totalCredits;
                gpaTextView.setText(String.format("%.2f", gpa));
            }
        });
    }
}
