package za.co.employeetracking.mapper;

import java.util.ArrayList;
import java.util.List;
import za.co.employeetracking.domain.EntityClass;
import za.co.employeetracking.domain.LectureSubjectList;
import za.co.employeetracking.domain.LogHistory;
import za.co.employeetracking.domain.StudentSubjectList;
import za.co.employeetracking.domain.Subject;
import za.co.employeetracking.domain.TimeTable;
import za.co.employeetracking.domain.UserRole;
import za.co.employeetracking.domain.Vanue;
import za.co.employeetracking.model.EntityClassCommandModel;
import za.co.employeetracking.model.EntityQueryModel;
import za.co.employeetracking.model.LectureSubjectListQueryModel;
import za.co.employeetracking.model.LogHistoryCommandModel;
import za.co.employeetracking.model.StudentSubjectListQueryModel;
import za.co.employeetracking.model.SubjectQueryModel;
import za.co.employeetracking.model.UserRoleQueryModel;
import za.co.employeetracking.model.VanueQueryModel;

public class Mapper
{

    public static UserRoleQueryModel toUserRoleQueryModel(UserRole from)
    {
        UserRoleQueryModel userRoleQueryModel = new UserRoleQueryModel();

        userRoleQueryModel.setId(from.getId());
        userRoleQueryModel.setRoleDesc(from.getRoleDesc());

        return userRoleQueryModel;
    }

    public static List<UserRoleQueryModel> toUserRoleQueryModel(List<UserRole> fromList)
    {
        List<UserRoleQueryModel> userRoleQueryModels = new ArrayList<UserRoleQueryModel>();

        for (UserRole userRole : fromList)
        {
            userRoleQueryModels.add(toUserRoleQueryModel(userRole));
        }
        return userRoleQueryModels;
    }

    public static VanueQueryModel toVanueQueryModel(Vanue from)
    {
        VanueQueryModel vanueQueryModel = new VanueQueryModel();

        vanueQueryModel.setId(from.getId());
        vanueQueryModel.setVanueDesc(from.getVanueDesc());

        return vanueQueryModel;
    }

    public static List<VanueQueryModel> toVanueQueryModel(List<Vanue> fromList)
    {
        List<VanueQueryModel> vanueQueryModels = new ArrayList<VanueQueryModel>();

        for (Vanue vanue : fromList)
        {
            vanueQueryModels.add(toVanueQueryModel(vanue));
        }
        return vanueQueryModels;
    }

    public static SubjectQueryModel toSubjectQueryModel(Subject from)
    {
        SubjectQueryModel subjectQueryModel = new SubjectQueryModel();

        subjectQueryModel.setId(from.getId());
        subjectQueryModel.setSubjectDesc(from.getSubjectDesc());

        return subjectQueryModel;
    }

    public static List<SubjectQueryModel> toSubjectQueryModel(List<Subject> fromList)
    {
        List<SubjectQueryModel> subjectQueryModels = new ArrayList<SubjectQueryModel>();

        for (Subject subject : fromList)
        {
            subjectQueryModels.add(toSubjectQueryModel(subject));
        }
        return subjectQueryModels;
    }
    
    public static EntityQueryModel toEntityQueryModel(EntityClass from)
    {
        EntityQueryModel entityQueryModel = new EntityQueryModel();

        entityQueryModel.setId(from.getId());
        entityQueryModel.setIdNumber(from.getIdNumber());
        entityQueryModel.setFistName(from.getFirstName());
        entityQueryModel.setSurname(from.getSurname());
        entityQueryModel.setGender(from.getGender());
        
        UserRoleQueryModel userRoleQueryModel = new UserRoleQueryModel();
        userRoleQueryModel.setId(from.getUserRole().getId());
        userRoleQueryModel.setRoleDesc(from.getUserRole().getRoleDesc());

        return entityQueryModel;
    }

    public static List<EntityQueryModel> toEntityQueryModel(List<EntityClass> fromList)
    {
        List<EntityQueryModel>  entityQueryModels = new ArrayList<EntityQueryModel>();

        for (EntityClass entityClass : fromList)
        {
            entityQueryModels.add(toEntityQueryModel(entityClass));
        }
        return entityQueryModels;
    }
    
    
    
     public static StudentSubjectListQueryModel toStudentSubjectListQueryModel(StudentSubjectList from)
    {
        StudentSubjectListQueryModel studentSubjectListQueryModel = new StudentSubjectListQueryModel();

        studentSubjectListQueryModel.setId(from.getId());
        
        EntityQueryModel entityQueryModel = new EntityQueryModel();
        entityQueryModel.setFistName(from.getEntityClass().getFirstName());
        entityQueryModel.setGender(from.getEntityClass().getGender());
        entityQueryModel.setId(from.getEntityClass().getId());
        entityQueryModel.setIdNumber(from.getEntityClass().getIdNumber());
        entityQueryModel.setSurname(from.getEntityClass().getSurname());
        
        UserRoleQueryModel roleQueryModel = new UserRoleQueryModel();
        roleQueryModel.setId(from.getEntityClass().getUserRole().getId());
        roleQueryModel.setRoleDesc(from.getEntityClass().getUserRole().getRoleDesc());
        
        entityQueryModel.setUserRole(roleQueryModel);
        studentSubjectListQueryModel.setEntity(entityQueryModel);
        
        SubjectQueryModel subjectQueryModel = new SubjectQueryModel();
        subjectQueryModel.setId(from.getSubject().getId());
        subjectQueryModel.setSubjectDesc(from.getSubject().getSubjectDesc());
        
        studentSubjectListQueryModel.setSubject(subjectQueryModel);
        

        return studentSubjectListQueryModel;
    }

    public static List<StudentSubjectListQueryModel> toStudentSubjectListQueryModel(List<StudentSubjectList> fromList)
    {
        List<StudentSubjectListQueryModel> studentSubjectListQueryModels = new ArrayList<StudentSubjectListQueryModel>();

        for (StudentSubjectList studentSubjectList : fromList)
        {
            studentSubjectListQueryModels.add(toStudentSubjectListQueryModel(studentSubjectList));
        }
        return studentSubjectListQueryModels;
    }
    
    
    
    
    public static LectureSubjectListQueryModel toLectureSubjectListQueryModel(LectureSubjectList  from)
    {
        LectureSubjectListQueryModel lectureSubjectListQueryModel = new LectureSubjectListQueryModel();

        lectureSubjectListQueryModel.setId(from.getId());
        
        EntityQueryModel entityQueryModel = new EntityQueryModel();
        entityQueryModel.setFistName(from.getEntityClass().getFirstName());
        entityQueryModel.setGender(from.getEntityClass().getGender());
        entityQueryModel.setId(from.getEntityClass().getId());
        entityQueryModel.setIdNumber(from.getEntityClass().getIdNumber());
        entityQueryModel.setSurname(from.getEntityClass().getSurname());
        
        UserRoleQueryModel roleQueryModel = new UserRoleQueryModel();
        roleQueryModel.setId(from.getEntityClass().getUserRole().getId());
        roleQueryModel.setRoleDesc(from.getEntityClass().getUserRole().getRoleDesc());
        
        entityQueryModel.setUserRole(roleQueryModel);
        lectureSubjectListQueryModel.setEntity(entityQueryModel);
        
        SubjectQueryModel subjectQueryModel = new SubjectQueryModel();
        subjectQueryModel.setId(from.getSubject().getId());
        subjectQueryModel.setSubjectDesc(from.getSubject().getSubjectDesc());
        
        lectureSubjectListQueryModel.setSubject(subjectQueryModel);
        

        return lectureSubjectListQueryModel;
    }

    public static List<LectureSubjectListQueryModel> toLectureSubjectListQueryModel(List<LectureSubjectList> fromList)
    {
        List<LectureSubjectListQueryModel> lectureSubjectListQueryModels = new ArrayList<LectureSubjectListQueryModel>();

        for (LectureSubjectList lectureSubjectList : fromList)
        {
            lectureSubjectListQueryModels.add(toLectureSubjectListQueryModel(lectureSubjectList));
        }
        return lectureSubjectListQueryModels;
    }
    
    
    public static EntityClass FromPolicyEntityClassCommandModel(EntityClassCommandModel entityClassCommandModel, UserRole role)
    {
        EntityClass entityClass = new EntityClass();
        
        entityClass.setFirstName(entityClassCommandModel.getFistName());
        entityClass.setSurname(entityClassCommandModel.getSurname());
        entityClass.setIdNumber(entityClassCommandModel.getIdNumber());
        entityClass.setGender(entityClassCommandModel.getGender());
        
        entityClass.setUserRole(role);
        
        return entityClass;    
    }
    
    public static LogHistory fromLogHistoryCommandModel(LogHistoryCommandModel logHistoryCommandModel, EntityClass entityClass, TimeTable timeTable)
    {
        LogHistory logHistory = new LogHistory();
        
        logHistory.setIsAttended(logHistoryCommandModel.isIsAttended());
        
        logHistory.setEntityClass(entityClass);
        logHistory.setTimeTable(timeTable);
        return logHistory;
    }

}
