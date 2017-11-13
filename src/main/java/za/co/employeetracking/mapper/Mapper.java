package za.co.employeetracking.mapper;

import java.util.ArrayList;
import java.util.List;
import za.co.employeetracking.domain.EntityRole;
import za.co.employeetracking.domain.EntityType;
import za.co.employeetracking.domain.Status;
import za.co.employeetracking.domain.Subject;
import za.co.employeetracking.domain.UserRole;
import za.co.employeetracking.domain.Vanue;
import za.co.employeetracking.model.EntityRoleQueryModel;
import za.co.employeetracking.model.EntityTypeQueryModel;
import za.co.employeetracking.model.StatusQueryModel;
import za.co.employeetracking.model.SubjectQueryModel;
import za.co.employeetracking.model.UserRoleQueryModel;
import za.co.employeetracking.model.VanueQueryModel;

public class Mapper
{

    public static EntityTypeQueryModel toEntityTypeQueryModel(EntityType from)
    {
        EntityTypeQueryModel entityType = new EntityTypeQueryModel();

        entityType.setId(from.getId());
        entityType.setEntityTypeDesc(from.getEntityTypeDesc());

        return entityType;
    }

    public static List<EntityTypeQueryModel> toEnityTypeQueryModel(List<EntityType> fromList)
    {
        List<EntityTypeQueryModel> entityTypeQueryModels = new ArrayList<EntityTypeQueryModel>();

        for (EntityType entityType : fromList)
        {
            entityTypeQueryModels.add(toEntityTypeQueryModel(entityType));
        }

        return entityTypeQueryModels;
    }

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

    public static EntityRoleQueryModel toEntityRoleQueryModel(EntityRole from)
    {
        EntityRoleQueryModel entityRoleQueryModel = new EntityRoleQueryModel();

        UserRoleQueryModel userRole = new UserRoleQueryModel();
        userRole.setId(from.getUserRole().getId());
        userRole.setRoleDesc(from.getUserRole().getRoleDesc());
        entityRoleQueryModel.setUserRole(userRole);

        EntityTypeQueryModel entityType = new EntityTypeQueryModel();
        entityType.setId(from.getEntityType().getId());
        entityType.setEntityTypeDesc(from.getEntityType().getEntityTypeDesc());
        entityRoleQueryModel.setEntityType(entityType);

        return entityRoleQueryModel;
    }

    public static List<EntityRoleQueryModel> toEntityRoleQueryModel(List<EntityRole> fromList)
    {
        List<EntityRoleQueryModel> entityRoleQueryModels = new ArrayList<EntityRoleQueryModel>();

        for (EntityRole entityRole : fromList)
        {
            entityRoleQueryModels.add(toEntityRoleQueryModel(entityRole));
        }
        return entityRoleQueryModels;
    }

    public static StatusQueryModel toStatusQueryModel(Status from)
    {
        StatusQueryModel statusQueryModel = new StatusQueryModel();

        statusQueryModel.setId(from.getId());
        statusQueryModel.setStatusDesc(from.getStatusDesc());

        return statusQueryModel;
    }

    public static List<StatusQueryModel> toStatusQueryModel(List<Status> fromList)
    {
        List<StatusQueryModel> statusQueryModels = new ArrayList<StatusQueryModel>();

        for (Status status : fromList)
        {
            statusQueryModels.add(toStatusQueryModel(status));
        }
        return statusQueryModels;
    }
    
    
        public static VanueQueryModel toVanueQueryModel(Vanue from)
    {
        VanueQueryModel vanueQueryModel = new VanueQueryModel();

        vanueQueryModel.setId(from.getId());
        vanueQueryModel.setVanueDesc(from.getSubjectDesc());

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

}
