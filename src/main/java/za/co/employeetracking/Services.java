/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.employeetracking;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.co.employeetracking.domain.EntityType;
import za.co.employeetracking.domain.UserRole;
import za.co.employeetracking.mapper.Mapper;
import static za.co.employeetracking.mapper.Mapper.toUserRoleQueryModel;
import za.co.employeetracking.model.EntityTypeQueryModel;
import za.co.employeetracking.model.UserRoleQueryModel;
import za.co.employeetracking.repository.EntityRoleRepository;
import za.co.employeetracking.repository.EntityTypeRepository;
import za.co.employeetracking.repository.StatusRepository;
import za.co.employeetracking.repository.SubjectRepository;
import za.co.employeetracking.repository.UserRoleRepository;
import za.co.employeetracking.repository.VanueRepository;

/**
 * @author User
 */
@RestController
public class Services {
    
    
    private static final Logger log = LoggerFactory.getLogger(Services.class);
    
    
    @Autowired
    private UserRoleRepository userRoleRepository;
    
    @Autowired
    private EntityTypeRepository entityTypeRepository;
    
    @Autowired
    private EntityRoleRepository entityRoleRepository;
    
    @Autowired
    private VanueRepository vanueRepository;
    
    @Autowired
    private StatusRepository statusRepository;
    
    @Autowired
    private SubjectRepository subjectRepository;
    
    
    
    	@RequestMapping(value = "api/userRoles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserRoleQueryModel> findAllUsers() {
		log.info("find user role");
		List<UserRole> userRoles = userRoleRepository.findAll();
		List<UserRoleQueryModel> result = toUserRoleQueryModel(userRoles);
		log.info("found user roles, size:{}", result.size());
		log.info("this service to get all user roless");
		return result;
	}
        
        @RequestMapping(value = "api/entityTypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        public List<EntityTypeQueryModel> findAllEntityTypes()
        {
            log.info("find entity types");
            
            List<EntityType> entityTypes = entityTypeRepository.findAll();
            
            List<EntityTypeQueryModel> result = Mapper.toEnityTypeQueryModel(entityTypes);
            
            return result;            
        }

    
    
}
