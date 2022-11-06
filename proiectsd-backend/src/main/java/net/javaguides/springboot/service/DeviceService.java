package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Device;

import java.util.List;


public interface DeviceService {

    Device saveDevice(Device Device);

    List<Device> getAllDevices();

    Device getDeviceById(Long id);

    Device updateDevice(Device Device,Long id);

    void deleteDevice(Long id);

}
