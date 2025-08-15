package com.acceleraite.repository;

import com.acceleraite.entity.Multimedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultimediaRepository extends JpaRepository<Multimedia, Long> {
}
