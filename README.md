# SQL Data Generator
The purpose of this project is to fill PostgreSQL db with some data amount. This is needed for sql query testing.

## Domain

### Student
#### Properties
* `Integer id`
* `String name`
* `String surname`
* `LocalDate dateOfBirthday`
* `String primarySkill`
* `LocalDateTime createdDateTime`
* `LocalDateTime updatedDateTime`
#### Relationships
* `List<Phone> phones`: The list of student's phone numbers (one-to-many)
* `List<ExamResult> exams`: The list of student's exam results (one-to-many)

### Phone
#### Properties
* `Integer id`
* `String number`
#### Relationships
* `Student student`: The student of the phone (many-to-one)

### Subject
#### Properties
* `Integer id`
* `String name`
* `String tutor`

### ExamResult
#### Properties
* `Integer id`
* `Short mark`
#### Relationships
* `Student student`: The student which took an exam (many-to-one)

## Task
Look through the materials:
- https://www.linkedin.com/learning/advanced-sql-for-query-tuning-and-performance-optimization
- https://www.linkedin.com/learning/advanced-sql-logical-query-processing-part-1

Write following sql queries:
1. Select all primary skills that contain more than one word (please note that both `-` and ` ` could be used as a separator).
2. Select all students who do not have second name (it is absent or consists from only one letter/letter with dot).
3. Select number of students passed exams for each subject and order result by number of student descending.
4. Select number of students with the same exam marks for each subject.
5. Select students who passed at least two exams for different subject.
6. Select students who passed at least two exams for the same subject.
7. Select all subjects which exams passed only students with the same primary skills.
8. Select all subjects which exams passed only students with the different primary skills. It means that all students passed the exam for the one subject must have different primary skill.
   - Outer join
   - Subquery with ‘not in’ clause
   - Subquery with ‘any ‘ clause Check which approach is faster for 1000, 10K, 100K exams and 10, 1K, 100K students
9. Select all students whose average mark is bigger than overall average mark.
10. Select top 5 students who passed their last exam better than average students.
11. Select biggest mark for each student and add text description for the mark (use COALESCE and WHEN operators).
    - In case if student has not passed any exam `not passed` should be returned.
    - If student mark is 1,2,3 – it should be returned as `BAD`
    - If student mark is 4,5,6 – it should be returned as `AVERAGE`
    - If student mark is 7,8 – it should be returned as `GOOD`
    - If student mark is 9,10 – it should be returned as `EXCELLENT`
12. Select number of all marks for each mark type (`BAD`, `AVERAGE`,…).

### Result of the task
- SQL file that will show to your mentor and tutor how you did your homework;
- Screenshot with the result of each sql query;
- Query optimization investigation in a separate document.