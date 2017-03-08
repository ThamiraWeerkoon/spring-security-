package org.myspring.models.projections;

import org.myspring.models.User;
import org.springframework.data.rest.core.config.Projection;

public interface UserProjections {

	@Projection(name = "basic", types = User.class)
	public interface UserBasicProjection {

		String getUserName();

		Boolean getActivated();

		String getEmail();

	}

	@Projection(name = "dataTable", types = User.class)
	public interface UserDataTableProjection {

		String getUserName();

		String getEmail();

	}

	@Projection(name = "advance", types = User.class)
	public interface UserMinimalProjection extends UserProjections {

		String getFirstName();

		String getLastNmae();

	}

}
