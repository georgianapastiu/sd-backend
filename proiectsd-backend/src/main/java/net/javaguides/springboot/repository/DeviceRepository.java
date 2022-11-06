package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device,Long> {


}
