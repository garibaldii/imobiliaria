package service;

import model.Contract;

public class ContractService {


    public Contract verifyFeeDiscount(Contract c ) {
        if(c.getMonths() >= 12){
            c.setContractPrice((int) (c.getContractPrice() * 0.95));
        } else if (c.getMonths() >= 24 ) {
            c.setContractPrice((int) (c.getContractPrice() * 0.90));
        } else if (c.getMonths() >= 36) {
            c.setContractPrice((int) (c.getContractPrice() * 0.80));
        }

        return c;

    }
}
