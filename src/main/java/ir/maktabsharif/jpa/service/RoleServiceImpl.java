package ir.maktabsharif.jpa.service;

import ir.maktabsharif.jpa.domains.Role;
import ir.maktabsharif.jpa.repositories.RoleRepository;
import ir.maktabsharif.jpa.service.base.BaseServiceImpl;

public class RoleServiceImpl
        extends BaseServiceImpl<Role, Long, RoleRepository>
        implements RoleService {

    public RoleServiceImpl(RoleRepository repository) {
        super(repository);
    }
}
