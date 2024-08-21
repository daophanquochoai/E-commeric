package com.doctorhoai.proxyclient.repository;

import com.doctorhoai.proxyclient.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
