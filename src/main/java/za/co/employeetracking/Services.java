/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.employeetracking;

import java.text.ParseException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import scala.annotation.meta.field;
import za.co.employeetracking.domain.EntityClass;
import za.co.employeetracking.domain.LogHistory;
import za.co.employeetracking.domain.Subject;
import za.co.employeetracking.domain.TimeTable;
import za.co.employeetracking.domain.UserRole;
import za.co.employeetracking.domain.Vanue;
import za.co.employeetracking.mapper.Mapper;
import static za.co.employeetracking.mapper.Mapper.FromPolicyEntityClassCommandModel;
import static za.co.employeetracking.mapper.Mapper.fromSubjectCommandModel;
import static za.co.employeetracking.mapper.Mapper.toSubjectQueryModel;
import static za.co.employeetracking.mapper.Mapper.toUserRoleQueryModel;
import static za.co.employeetracking.mapper.Mapper.toVanueQueryModel;
import za.co.employeetracking.model.EntityClassCommandModel;
import za.co.employeetracking.model.EntityQueryModel;
import za.co.employeetracking.model.LectureSubjectListQueryModel;
import za.co.employeetracking.model.LogHistoryCommandModel;
import za.co.employeetracking.model.LogHistoryQueryModel;
import za.co.employeetracking.model.StudentSubjectListQueryModel;
import za.co.employeetracking.model.SubjectQueryModel;
import za.co.employeetracking.model.UserRoleQueryModel;
import za.co.employeetracking.model.VanueQueryModel;
import za.co.employeetracking.repository.EntityRepository;
import za.co.employeetracking.repository.LogHistoryRepository;
import za.co.employeetracking.repository.SubjectRepository;
import za.co.employeetracking.repository.TimeTableRepository;
import za.co.employeetracking.repository.UserRoleRepository;
import za.co.employeetracking.repository.VanueRepository;

/**
 * @author User
 */
@RestController
public class Services
{

    private static final Logger log = LoggerFactory.getLogger(Services.class);

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private VanueRepository vanueRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private EntityRepository entityRepository;

    @Autowired
    private LogHistoryRepository logHistoryRepository;

    @Autowired
    private TimeTableRepository timeTableRepository;
    

    @RequestMapping(value = "api/userRoles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserRoleQueryModel> findAllUsers()
    {
        log.info("find user role");
        List<UserRole> userRoles = userRoleRepository.findAll();
        List<UserRoleQueryModel> result = toUserRoleQueryModel(userRoles);
        log.info("found user roles, size:{}", result.size());
        log.info("this service to get all user roless");
        return result;
    }

    @RequestMapping(value = "api/vanues", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VanueQueryModel> findAllVanues()
    {
        log.info("find vanues");
        List<Vanue> vanues = vanueRepository.findAll();
        List<VanueQueryModel> result = toVanueQueryModel(vanues);
        log.info("found vanues size:{}", result.size());
        log.info("this service to get all vanues");
        return result;
    }

    @RequestMapping(value = "api/subjects", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SubjectQueryModel> findAllSubject()
    {
        log.info("find vanues");
        List<Subject> subjects = subjectRepository.findAll();
        List<SubjectQueryModel> result = toSubjectQueryModel(subjects);
        log.info("found subjects size:{}", result.size());
        log.info("this service to get all subjects");
        return result;
    }

    @Transactional
    @RequestMapping(value = "api/entity", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long registerEntity(@RequestBody EntityClassCommandModel entityClassCommandModel)
    {

        UserRole role = userRoleRepository.findOne(entityClassCommandModel.getRoleId());

        EntityClass entityClass = FromPolicyEntityClassCommandModel(entityClassCommandModel, role);
        entityClass = entityRepository.save(entityClass);
                      
        List<Subject> entitySubjects = fromSubjectCommandModel(entityClassCommandModel, entityClass);
        subjectRepository.save(entitySubjects);

        return entityClass.getId();
    }

    @Transactional
    @RequestMapping(value = "api/attendance", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "text/html")
    public Long LogAttendance(@RequestBody LogHistoryCommandModel logHistoryCommandModel)
    {
        TimeTable timetable = timeTableRepository.findOne(logHistoryCommandModel.getTimeTableId());

        EntityClass entityClass = entityRepository.findOne(logHistoryCommandModel.getEntityId());

        LogHistory logHistory = Mapper.fromLogHistoryCommandModel(logHistoryCommandModel, entityClass, timetable);
        logHistory = logHistoryRepository.save(logHistory);

        return logHistory.getId();
    }

    @RequestMapping(value = "api/entity/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public EntityQueryModel getEntityClassById(@PathVariable("id") Long id) throws ParseException
    {

        EntityClass entityClass = entityRepository.findOne(id);

        return Mapper.toEntityQueryModel(entityClass);
    }
    
    
    
    @RequestMapping(value = "api/entities", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EntityQueryModel> getAllEntities() throws ParseException
    {

        List<EntityClass> entityClass = entityRepository.findAll();

        return Mapper.toEntityQueryModel(entityClass);
    }


    @RequestMapping(value = "api/student/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentSubjectListQueryModel getStudentById(@PathVariable("id") Long id) throws ParseException
    {
        return null;
    }
    
    @RequestMapping(value = "api/students", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StudentSubjectListQueryModel> getAllStudents() throws ParseException
    {
         return null;
    }

    @RequestMapping(value = "api/lecture/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public LectureSubjectListQueryModel getLectureById(@PathVariable("id") Long id) throws ParseException
    {
        return null;
    }
    
    @RequestMapping(value = "api/lectures", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LectureSubjectListQueryModel> getAllLectures() throws ParseException
    {
        return null;
    }
    
    
    @RequestMapping(value = "api/attedance/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public LogHistoryQueryModel getAttendanceById(@PathVariable("id") Long id) throws ParseException
    {
        
        return null;
    }
    
    @RequestMapping(value = "api/attedance", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public LogHistoryQueryModel getAllAttendance() throws ParseException
    {

        return null;
    }
    
    @RequestMapping(value = "api/regidter/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void registerNew(@PathVariable("id") Long id) throws ParseException
    {
        
    }

}
