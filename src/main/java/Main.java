
import entity.*;
import jakarta.persistence.*;
import net.datafaker.Faker;


import java.util.*;

public class Main {
    static Faker faker = new Faker(new Locale("vi"));
    public static void main(String[] args) throws Exception {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Generate generate = new Generate();
        Student exceptionStudent = null;

//        arrStudentEntities.addAll(generate.generateStudents(30000));
//        for(int i =0;i<arrStudentEntities.size();i++){
//            Student student = arrStudentEntities.get(i);
//            if(student.getId()==null){ System.out.println(i);
//            throw new Exception("null value");}
//        }
//        List<CourseStudent> arrCourseStudents = null;
        try {
            transaction.begin();
//            ArrayList<Student> arrStudentEntities = generate.generateStudents(100000);
//            ArrayList<Student> arrStudentEntities =new ArrayList<>(entityManager.createNativeQuery("select * from Student schedule",Student.class).getResultList());
//            Collections.shuffle(arrStudentEntities);
//            ArrayList<Course> arrCourses = new ArrayList<>(entityManager.createNativeQuery("select * from Course course",Course.class).getResultList());
//            for (Student student :
//                    arrStudentEntities) {
////                entityManager.merge(student);
//            Collections.shuffle(arrCourses);
//                for (int i = 0; i < 5; i++) {
//                    CourseStudent cs = new CourseStudent();
//                    cs.setStudentId(student.getId());
//                    cs.setCourseId(arrCourses.get(i).getId());
//                    entityManager.merge(cs);
//                }
//
//            }
//            ArrayList<Student> arrStudentEntities =new ArrayList<>(entityManager.createNativeQuery("select * from Student schedule",Student.class).getResultList());
//            Collections.shuffle(arrStudentEntities);
//            int tmp =0;
//            ArrayList<Course> arrCourses = new ArrayList<>(entityManager.createNativeQuery("select * from Course course",Course.class).getResultList());
//            for(Student student:arrStudentEntities){
//                tmp++;
//                CourseStudent courseStudent = new CourseStudent();
//                Collections.shuffle(arrCourses);
//                for(int i =0;i<5;i++){
//                    courseStudent.setCourseId(arrCourses.get(i).getId());
//                    courseStudent.setStudentId(student.getId());
//                    entityManager.merge(courseStudent);
//                }
//
//            }
//            entityManager.createQuery("delete from CourseStudent ").executeUpdate();


//            for (Student student :
//                    arrStudentEntities) {
//                exceptionStudent = student;
//                entityManager.merge(student);
//            }
//            Query query = entityManager.createQuery("select schedule from ExamSchedule schedule where schedule.id = 'ES082948'");
//            ExamSchedule schedule = (ExamSchedule) query.getResultList().get(0);
//            Course course = schedule.getCoursesById();
//            System.out.println(course.getName());
//            ArrayList<Classroom> arrClassrooms = generate.generateClassrooms(120);
//            for (Classroom room :
//                    arrClassrooms) {
//                entityManager.merge(room);
//            }

//            Query getCousres = entityManager.createQuery("select course from Course course");
//            List<Course> arrCousre = (List<Course>) getCousres.getResultList();
//            Collections.shuffle(arrCousre);
//            for (CourseStudent courseStudent :
//                    arrCousre.get(0).getCourseStudentsById()) {
//                System.out.println(courseStudent.toString());
//            }
//Bắt đầu thuật toán

            int totalSlot;
//            {
                Query getCourse = entityManager.createNativeQuery("select * from Course course",Course.class);
                ArrayList<Course> arrCourses = (ArrayList<Course>) getCourse.getResultList();
                Map<Course,Collection<CourseStudent>> courseStudentMap = new HashMap<>();
                int tmp=0;
                for(Course course:arrCourses){
                    courseStudentMap.put(course,course.getCourseStudentsById());
                    tmp+=course.getCourseStudentsById().size();
                }
//                int tmp =0;
//                for (Course course:
//                     arrCourses) {
//                    courseStudentMap.put(course,course.getCourseStudentsById());
//                    tmp += course.getCourseStudentsById().size();
//                }
//                System.out.println(tmp);
//                Query getStudents = entityManager.createQuery("select student from CourseStudent student");
//                arrCourseStudents = (List<CourseStudent>) getStudents.getResultList();
//                Collections.shuffle(arrCourseStudents);
                Query getClassrooms = entityManager.createQuery("select room from Classroom room");
                List<Classroom> arrClassrooms = (List<Classroom>) getClassrooms.getResultList();
////                Query getCousres = entityManager.createQuery("select course from Course course");
                int sizeRoom = 25;
                totalSlot = tmp / (arrClassrooms.size() * sizeRoom);
                if (tmp % (arrClassrooms.size() * sizeRoom) != 0) {
                    totalSlot++;
                }
                Query getSlot = entityManager.createQuery("select slot from ExamSlot slot");
                ArrayList<ExamSlot> arrSlots = (ArrayList<ExamSlot>) getSlot.getResultList();

//                int countRoom = 0;
                ArrayList<ExamSchedule> examScheduleArrayList = new ArrayList<>();

                int indexSlot =0 ;
            int indexStudent =0; //vị trí sinh viên trong MỘT MÔN
            int indexCourse =0; //vị trí môn học
            int totalCourse =arrCourses.size();
            int indexExamSche =0;

                    int totalStudent =courseStudentMap.get(arrCourses.get(indexCourse)).size();
                    int indexChair =0; //vị trí ghế trong MỘT PHÒNG
                    int indexRoom =0; //vị trí phong tron MỘT SLOT
                    int totalChair = 25;
                    int totalRoom = arrClassrooms.size();
                        ArrayList<CourseStudent> arrStudent = new ArrayList<>(courseStudentMap.get(arrCourses.get(indexCourse)));
try {
    do {
        indexExamSche++;
        ExamSchedule examSchedule = new ExamSchedule();
        examSchedule.setId(String.valueOf(indexExamSche));
        examSchedule.setStudentId(arrStudent.get(indexStudent).getStudentId());
        indexStudent++;
        examSchedule.setCourseId(arrCourses.get(indexCourse).getId());
        examSchedule.setRoomId(arrClassrooms.get(indexRoom).getRoom());
        examSchedule.setSlotId(arrSlots.get(indexSlot).getId());
        examScheduleArrayList.add(examSchedule);
        indexChair++;

        if (indexChair == totalChair) {
            indexRoom++;
            indexChair = 0;
        }
        if (indexRoom == totalRoom) {
            indexSlot++;
            indexRoom = 0;
        }
        if (indexStudent == totalStudent) {
            indexCourse++;
            indexStudent = 0;
            totalStudent = courseStudentMap.get(arrCourses.get(indexCourse)).size();
            arrStudent = new ArrayList<>(courseStudentMap.get(arrCourses.get(indexCourse)));

        }

    } while (!(indexSlot == totalSlot-1 && indexStudent == totalStudent-1));
}
catch (Exception e){
    e.printStackTrace();
}



//                for (int i = 0; i < totalSlot; i++) {
//                    int countRoom = 0;
//                        Set<Course> keySet = courseStudentMap.keySet();
//                        keySet.stream().sorted(Comparator.comparing(Course::getId));
//                        for (Course course :
//                                keySet) {
////                            for (int j = 0; j < 25; j++) {
////                                ExamSchedule ex = new ExamSchedule();
////                                ex.setSlotId(arrSlots.get(i).getId());
////                                ex.setRoomId(arrClassrooms.get(countRoom).getRoom());
////                                ex.setCourseId(course.getId());
////                                ex.setId(faker.regexify("EX[0-9]{6}"));
////                                ex.setStudentId(((ArrayList<CourseStudent>)courseStudentMap.get(course)).get(j).getStudentId());
////                            }
//                            int j = 0;
//                            do {
//
//                                do {
//                                    ExamSchedule ex = new ExamSchedule();
//                                    ex.setSlotId(arrSlots.get(i).getId());
//                                    ex.setRoomId(arrClassrooms.get(countRoom).getRoom());
//                                    ex.setCourseId(course.getId());
//                                    ex.setId(faker.regexify("EX[0-9]{6}"));
//                                    if(j==new ArrayList<>(courseStudentMap.get(course)).size()){
//                                        break;
//                                    }
//                                    ex.setStudentId(new ArrayList<>(courseStudentMap.get(course)).get(j).getStudentId());
//                                    examScheduleArrayList.add(ex);
//                                    j++;
//                                } while (j % 25 != 0);
//                                countRoom++;
//                                if(countRoom==arrClassrooms.size()) {
//                                    countRoom=0;
//                                    i++;
//                                    break;
//                                }
//                            }while (j!=new ArrayList<>(courseStudentMap.get(course)).size());
//                        }
//
//                }


//            List<ExamSlot> arrSlots = generate.generateSlot(totalSlot,"12/12/2023");
//            ExamSlot a = null;
//            try {
//                for (ExamSlot slot : arrSlots) {
//                    a=slot;
//                    entityManager.merge(slot);
//                }
//            }
//            catch (Exception e){
//                e.printStackTrace();
//            }
            for (ExamSchedule ex :
                    examScheduleArrayList) {
                try {
                    entityManager.merge(ex);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            transaction.commit();
        }
        finally {
//            System.out.println(arrCourseStudents.size());
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
