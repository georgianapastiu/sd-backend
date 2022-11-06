package net.javaguides.springboot.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name="device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description",nullable = false)
    private String description;
    @Column(name = "address",nullable = false)
    private Address address;
    @Column(name = "maxHourlyEnergyConsumption",nullable = false)
    private int maxHourlyEnergyConsumption;

    @ManyToOne(fetch=FetchType.LAZY,optional = false)
    @JoinColumn(name="user")
    private User user;

    @OneToMany(mappedBy = "device", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Measurement> measurement;

}
