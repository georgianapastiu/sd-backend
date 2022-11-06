package net.javaguides.springboot.service.impl;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Device;
import net.javaguides.springboot.repository.DeviceRepository;
import net.javaguides.springboot.service.DeviceService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class DeviceServiceImpl implements DeviceService {


    private DeviceRepository DeviceRepository;


    public DeviceServiceImpl(DeviceRepository DeviceRepository){

        this.DeviceRepository=DeviceRepository;
    }

    @Override
    public Device saveDevice(Device device) {
        return DeviceRepository.save(device);
    }

    @Override
    public List<Device> getAllDevices() {
        return DeviceRepository.findAll();
    }

    @Override
    public Device getDeviceById(Long id) {

        return DeviceRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Device","Id",id));
    }

    @Override
    public Device updateDevice(Device device, Long id) {
        Device device_to_update=DeviceRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Device","Id",id));

        device_to_update.setDescription(device.getDescription());
        device_to_update.setAddress(device.getAddress());
        device_to_update.setMaxHourlyEnergyConsumption(device.getMaxHourlyEnergyConsumption());
        device_to_update.setUser(device.getUser());
        DeviceRepository.save(device_to_update);
        return device_to_update;

    }

    @Override
    public void deleteDevice(Long id) {
        DeviceRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Device", "Id", id));
        DeviceRepository.deleteById(id);
    }


}
