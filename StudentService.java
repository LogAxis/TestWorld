import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class StudentService {

    @PersistenceContext
    private EntityManager em;

    public void createStudent(Student student) {
        em.persist(student);
    }

    public List<Student> getAllStudents() {
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s", Student.class);
        return query.getResultList();
    }

    public List<Student> getStudentsSortedByMarks() {
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s ORDER BY s.marks DESC", Student.class);
        return query.getResultList();
    }

    public Student findStudentById(Long id) {
        return em.find(Student.class, id);
    }
}
