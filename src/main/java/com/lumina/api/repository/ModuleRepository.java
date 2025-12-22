package com.lumina.api.repository;

import com.lumina.api.model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ModuleRepository extends JpaRepository<Module, UUID> {
    // This allows us to find all modules created by a specific instructor
    // Spring generates the SQL for this automatically based on the name!
}