package cn.bdqn.service;

import cn.bdqn.entity.Address;

import java.util.List;

public interface AddressService {

    int add(Address address);
    int del(int id);
    int update(Address address);
    List<Address> findAll();
    Address findById(int id);
    Address findByIsDefault(int id);
    List<Address> getAllByUserId(int userId);
}
