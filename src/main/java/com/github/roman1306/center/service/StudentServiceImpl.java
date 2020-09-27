package com.github.roman1306.center.service;

import com.github.roman1306.center.entity.Course;
import com.github.roman1306.center.entity.Curriculum;
import com.github.roman1306.center.entity.Student;
import com.github.roman1306.center.repository.StudentRepository;
import com.github.roman1306.center.service.sort.TypeSortStudent;
import lombok.RequiredArgsConstructor;
import org.apache.commons.math3.util.Precision;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    @Override
    public List<Student> getStudentsList() {
        return studentRepository.getStudentsList();
    }

    @Override
    public void overviewStudent(String nameStudent) {
        Student student = studentRepository.findStudent(nameStudent);

        double averageMarks = getAverageMarks(student.getMarks());
        Duration remainingHours = getRemainingHours(student);

        double potentialMaxAverageMarks = getPotentialMaxAverageMarks(student);

        System.out.println(student.getName() + " - " + "До окончания обучения по программе "
                + student.getCurriculum().getName() + " осталось " + remainingHours.toHours() + "ч."
                + " Средний бал " + averageMarks + " "
                + (potentialMaxAverageMarks >= 4.5 ? "Может продолжать обучение" : "Отчислить "));

    }

    @Override
    public void overviewStudentsSortList(TypeSortStudent typeSortStudent) {
        List<Student> students = studentRepository.getStudentsList();

        switch (typeSortStudent) {
            case AVERAGE_MARKS:
                students.sort((s1, s2) -> (int) (getRemainingHours(s1).toHours() - getRemainingHours(s2).toHours()));
                break;
            case REMAINING_HOURS:
                students.sort((s1, s2) -> (int) ((getAverageMarks(s2.getMarks()) - getAverageMarks(s1.getMarks())) * 10));
                break;
            case ONLY_POTENTIAL:
                students = students.stream().filter(s ->
                        getPotentialMaxAverageMarks(s) >= 4.5).collect(Collectors.toList());
                break;
            default:
                throw new IllegalArgumentException("Неопознаный тип сортировки");
        }
        students.forEach(s -> overviewStudent(s.getName()));
    }

    private Duration getInitialHoursCurriculum(Curriculum curriculum) {
        Duration initialHours = Duration.ofHours(0);
        for (Course course : curriculum.getCourses()) {
            initialHours = initialHours.plus(course.getDuration());
        }
        return initialHours;
    }

    private Duration getRemainingHours(Student student) {
        Duration initialHours = getInitialHoursCurriculum(student.getCurriculum());

        return initialHours.minus(Duration.ofHours((long) student.getMarks().size() * 8));
    }

    private double getAverageMarks(List<Integer> marks) {
        return Precision.round(marks.stream()
                .mapToDouble(s -> s).average().orElse(0.0), 1);
    }

    private double getPotentialMaxAverageMarks(Student student) {
        List<Integer> potentialMarks = new ArrayList<>(student.getMarks());
        for (int i = 0; i < getRemainingHours(student).dividedBy(8).toHours(); i++) {
            potentialMarks.add(5);
        }
        return getAverageMarks(potentialMarks);
    }

}
