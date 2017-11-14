package za.co.employeetracking.mapper;

import java.util.ArrayList;
import java.util.List;
import za.co.employeetracking.domain.Subject;
import za.co.employeetracking.domain.UserRole;
import za.co.employeetracking.domain.Vanue;
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
