package za.co.employeetracking.mapper;

import java.util.ArrayList;
import java.util.List;
import za.co.employeetracking.domain.EntityClass;
import za.co.employeetracking.domain.LogHistory;
import za.co.employeetracking.domain.Subject;
import za.co.employeetracking.domain.TimeTable;
import za.co.employeetracking.domain.User;
import za.co.employeetracking.domain.UserRole;
import za.co.employeetracking.domain.Vanue;
import za.co.employeetracking.model.EntityClassCommandModel;
import za.co.employeetracking.model.EntityQueryModel;
import za.co.employeetracking.model.LectureSubjectListQueryModel;
import za.co.employeetracking.model.LogHistoryCommandModel;
import za.co.employeetracking.model.StudentSubjectListQueryModel;
import za.co.employeetracking.model.SubjectQueryModel;
import za.co.employeetracking.model.UserQueryModel;
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
        entityQueryModel.setIsFingerPrint(from.isIsFingerPrint());

        UserRoleQueryModel userRoleQueryModel = new UserRoleQueryModel();
        userRoleQueryModel.setId(from.getUserRole().getId());
        userRoleQueryModel.setRoleDesc(from.getUserRole().getRoleDesc());

        entityQueryModel.setUserRole(userRoleQueryModel);

        for (Subject subject : from.getSubject())
        {
            EntityQueryModel.Subjects subjects = new EntityQueryModel.Subjects();
            subjects.setId(subject.getId());
            subjects.setSubjectDesc(subject.getSubjectDesc());
            
            entityQueryModel.getSubjects().add(subjects);
        }

        return entityQueryModel;
    }

    public static List<EntityQueryModel> toEntityQueryModel(List<EntityClass> fromList)
    {
        List<EntityQueryModel> entityQueryModels = new ArrayList<EntityQueryModel>();

        for (EntityClass entityClass : fromList)
        {
            entityQueryModels.add(toEntityQueryModel(entityClass));
        }
        return entityQueryModels;
    }

    public static List<Subject> fromSubjectCommandModel(EntityClassCommandModel entityClassCommandModel, EntityClass entityClass)
    {
        List<Subject> result = new ArrayList<Subject>();
        for (EntityClassCommandModel.Subjects subjects : entityClassCommandModel.getSubjects())
        {
            Subject subject = new Subject();
            subject.setSubjectDesc(subjects.getSubjectDesc());
            subject.setEntityClass(entityClass);
            result.add(subject);
        }
        return result;
    }

    public static EntityClass FromPolicyEntityClassCommandModel(EntityClassCommandModel entityClassCommandModel, UserRole role)
    {
        EntityClass entityClass = new EntityClass();

        entityClass.setFirstName(entityClassCommandModel.getFistName());
        entityClass.setSurname(entityClassCommandModel.getSurname());
        entityClass.setIdNumber(entityClassCommandModel.getIdNumber());
        entityClass.setGender(entityClassCommandModel.getGender());
        entityClass.setIsFingerPrint(entityClassCommandModel.isIsFingerPrint());
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

    public static UserQueryModel toUserQueryModel(User from)
    {
        UserQueryModel user = new UserQueryModel();
        user.setId(from.getId());
        user.setUserName(from.getUserName());

        EntityQueryModel entityQueryModel = new EntityQueryModel();
        entityQueryModel.setFistName(from.getEntityClass().getFirstName());
        entityQueryModel.setGender(from.getEntityClass().getGender());
        entityQueryModel.setIdNumber(from.getEntityClass().getIdNumber());
        entityQueryModel.setId(from.getEntityClass().getId());

        UserRoleQueryModel userRoleQueryModel = new UserRoleQueryModel();
        userRoleQueryModel.setId(from.getEntityClass().getUserRole().getId());
        userRoleQueryModel.setRoleDesc(from.getEntityClass().getUserRole().getRoleDesc());

        entityQueryModel.setUserRole(userRoleQueryModel);

        user.setEntity(entityQueryModel);

        return user;
    }

    public static List<UserQueryModel> toUserQueryModel(List<User> fromList)
    {
        List<UserQueryModel> userList = new ArrayList<UserQueryModel>();
        for (User user : fromList)
        {
            userList.add(toUserQueryModel(user));
        }
        return userList;
    }

}
