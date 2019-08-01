package com.next4f.vemmebuscar.service;

import com.next4f.vemmebuscar.domain.OrderStatusEnum;
import com.next4f.vemmebuscar.domain.PurchaseOrder;
import com.next4f.vemmebuscar.domain.Transfer;
import com.next4f.vemmebuscar.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    public PurchaseOrder createPurchaseOrder(Transfer transfer) {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setDate(LocalDate.now());
        purchaseOrder.setHour(LocalTime.now());
        purchaseOrder.setOrderStatus(OrderStatusEnum.PENDING);
        int amountOfPeople = transfer.getNumberOfAdults() + transfer.getNumberOfChildren() + transfer.getNumberOfBabies();

        if (amountOfPeople > 6 && transfer.getDestination().getFixedPrice() == null)
            purchaseOrder.setTotalAmount(amountOfPeople * transfer.getDestination().getVariablePrice());
        else
            purchaseOrder.setTotalAmount(transfer.getDestination().getFixedPrice() - ((transfer.getDestination().getPercentageDiscount() / 100) * transfer.getDestination().getFixedPrice()));

        return purchaseOrder;
    }

    public PurchaseOrder save(PurchaseOrder purchaseOrder) {
        return purchaseOrderRepository.save(purchaseOrder);
    }

    public Page<PurchaseOrder> findPaginatedOrders(int pageRequest) {
        Pageable pageable = PageRequest.of(pageRequest, 50);
        return purchaseOrderRepository.findAll(pageable);
    }


}
