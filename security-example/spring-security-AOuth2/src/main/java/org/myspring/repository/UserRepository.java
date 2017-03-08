package org.myspring.repository;

import java.util.Optional;

import org.myspring.models.User;
import org.myspring.models.projections.UserProjections;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(excerptProjection = UserProjections.UserBasicProjection.class)
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	User findFirstByUserName(@Param("userName") String userName);

	@PreAuthorize("@userRepository.findFirstByUserName(#userName)?.userName == authentication?.name")
	User findByUserName(@Param("userName") String userName);

	Optional<User> findOneByUserName(@Param("userName") String userName);

}
