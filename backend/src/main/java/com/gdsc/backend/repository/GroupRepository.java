package com.gdsc.backend.repository;

import com.gdsc.backend.domain.GroupList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<GroupList,Long> {
    public GroupList findGroupListByGroupListIndex(final Long index);
}
