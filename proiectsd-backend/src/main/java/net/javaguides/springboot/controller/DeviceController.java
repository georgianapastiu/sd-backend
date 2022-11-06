package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Address;
import net.javaguides.springboot.model.Rol;
import net.javaguides.springboot.model.Device;
import net.javaguides.springboot.service.DeviceService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    @Component
    public class AddressEnumConverter implements Converter<String, Address> {
        @Override
        public Address convert(String value) {
            return Address.valueOf(value);
        }
    }
    private DeviceService deviceService;

    public DeviceController(DeviceService deviceService){
        this.deviceService=deviceService;
    }

    //build creaTE device rest api
    @PostMapping()
    public ResponseEntity<Device> device(@RequestBody Device device){
        return new ResponseEntity<Device>(deviceService.saveDevice(device), HttpStatus.CREATED);
    }

    //build get all devices rest api
    @GetMapping
    public List<Device> getAllDevices(){
        return deviceService.getAllDevices();
    }

    //build get  devices by id rest api
    @GetMapping("{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable("id") Long id){
        return new ResponseEntity<Device>(deviceService.getDeviceById(id),HttpStatus.OK) ;
    }

    //build update device REST API
    @PutMapping("{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable("id") Long id,
                                           @RequestBody Device device) {
        return new ResponseEntity<Device>(deviceService.updateDevice(device,id),HttpStatus.OK);

    }
    //delete rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDevice(@PathVariable("id") Long id) {
        deviceService.deleteDevice(id);
        return new ResponseEntity<String>("Device succesfully deleted",HttpStatus.OK);

    }





}
