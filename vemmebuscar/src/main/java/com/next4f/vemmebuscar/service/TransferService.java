package com.next4f.vemmebuscar.service;

import com.next4f.vemmebuscar.domain.Transfer;
import com.next4f.vemmebuscar.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;

    public Transfer save(Transfer transfer) {
        return transferRepository.save(transfer);
    }

    /*IJG*/
    public List<Transfer> findAllByDestination(){
        return  transferRepository.findAllByDestinationIsNotNull();
    }
    public List<Transfer> findAll(){
        return transferRepository.findAll();
    }

    public Page<Transfer> listAllByPage(PageRequest pageable){
        return transferRepository.findAll(pageable);
    }
    /*IJG*/

}
